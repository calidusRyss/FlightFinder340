package main.java.wrappers.HTTP;

import java.io.IOException;
import main.java.exceptions.http.ConnectionFailedException;
import main.java.exceptions.http.InvalidUrlException;
import main.java.models.http.Header;
import main.java.models.http.Query;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * A class that wraps HTTP request functionality using the OKHTTP library.
 *
 * @author Teegan Krieger
 * @LastUpdate 9/30/2020
 */
public class OkHttpWrapper implements IHttpWrapper {

    private final String jsonMediaTypeString = "application/json; charset=utf-8";
    private final String xmlMediaTypeString = "application/xml; charset=utf-8";

    private OkHttpClient httpClient = new OkHttpClient();

    /**
     * Make a HTTP request using the OKHTTP library.
     *
     * @param _request The request to make.
     * @return A response object with a response code and body.
     * @throws InvalidUrlException Thrown if the provided request is not valid.
     */
    @Override
    public main.java.models.http.Response callRequest(main.java.models.http.Request _request) throws InvalidUrlException, ConnectionFailedException {

        Request okhttpRequest;
        try {
            okhttpRequest = buildRequest(_request);
        } catch (NullPointerException e) {
            throw new InvalidUrlException("The request failed due to an invalid url!", _request);
        }

        Response response;
        try {
            response = this.httpClient.newCall(okhttpRequest).execute();
        } catch (IOException e) {
            throw new ConnectionFailedException("The request failed due to a connection problem!");
        }

        return buildResponse(response);
    }

    /**
     * Build an OKHTTP RequestBody object from the generic request structure.
     *
     * @param _request The request to build into an OKHTTP request.
     * @return An OKHTTP RequestBody object.
     */
    private RequestBody buildRequestBody(main.java.models.http.Request _request) {
        MediaType mediaType;

        switch (_request.getRequestBodyType()) {
            case JSON:
                mediaType = MediaType.parse(this.jsonMediaTypeString);
                break;
            case XML:
                mediaType = MediaType.parse(this.xmlMediaTypeString);
                break;
            default:
                mediaType = MediaType.parse(this.jsonMediaTypeString);
                break;
        }

        return RequestBody.create(mediaType, _request.getRequestBody());
    }

    /**
     * Build an OKHTTP request from the generic request structure.
     *
     * @param _request The request to convert into an OKHTTP request.
     * @return An OKHTTP request object.
     */
    private Request buildRequest(main.java.models.http.Request _request) {
        //Build Request URL
        HttpUrl.Builder urlBuilder = HttpUrl.parse(_request.getUrl()).newBuilder();

        Query[] queries = _request.getQueries();

        for (Query q : queries) {
            urlBuilder.addQueryParameter(q.getName(), q.getValue());
        }

        //Build Request Object
        Request.Builder requestBuilder = new Request.Builder().url(urlBuilder.build());

        //Set Request Method
        RequestBody requestBody = buildRequestBody(_request);
        switch (_request.getRequestMethod()) {
            case GET:
                requestBuilder = requestBuilder.get();
                break;
            case HEAD:
                requestBuilder = requestBuilder.head();
                break;
            case PUT:
                requestBuilder = requestBuilder.put(requestBody);
                break;
            case PATCH:
                requestBuilder = requestBuilder.put(requestBody);
                break;
            case DELETE:
                requestBuilder = requestBuilder.put(requestBody);
                break;
            case POST:
                requestBuilder = requestBuilder.put(requestBody);
                break;
        }

        //Add Request Headers
        for (Header h : _request.getHeaders()) {
            requestBuilder.addHeader(h.getName(), h.getValue());
        }

        return requestBuilder.build();
    }

    /**
     * Build a generic response object from an OKHTTP response object.
     *
     * @param _response The OKHTTP response object to convert into a generic response.
     * @return A generic response object.
     */
    private main.java.models.http.Response buildResponse(Response _response) {

        String body;

        try {
            body = _response.body().string();
        } catch (IOException e) {
            body = "";
        }

        main.java.models.http.Response resultResponse = new main.java.models.http.Response(
                _response.isSuccessful(),
                _response.code(),
                _response.message(),
                body
        );

        return resultResponse;
    }

}
