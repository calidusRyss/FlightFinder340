package main.java.models.HTTP;

import java.util.Arrays;

/**
 * A class representing an HTTP request.
 *
 * @author Teegan Krieger
 * @LastUpdate 9/29/2020
 */
public class Request {

    private final String url;
    private final RequestMethod requestMethod;
    private Header[] headers;
    private Query[] queries;
    private RequestBodyFormat requestBodyFormat;
    private String requestBody;

    public Request(String _url, RequestMethod _requestMethod) {
        this.url = _url;
        this.requestMethod = _requestMethod;
        this.headers = new Header[0];
        this.queries = new Query[0];
        this.requestBodyFormat = RequestBodyFormat.JSON;
        this.requestBody = "";
    }

    /**
     * Add one or multiple headers to this request.
     *
     * @param _headers The headers to add.
     */
    public void addHeaders(Header... _headers) {
        this.headers = Arrays.copyOf(this.headers, this.headers.length + _headers.length);

        for (int i = 0, j = 0; i < _headers.length; i++, j++) {
            this.headers[j] = _headers[i];
        }
    }

    /**
     * Add one or multiple queries to this request.
     *
     * @param _queries The queries to add.
     */
    public void addQueries(Query... _queries) {
        this.queries = Arrays.copyOf(this.queries, this.queries.length + _queries.length);

        for (int i = 0, j = 0; i < _queries.length; i++, j++) {
            this.queries[j] = _queries[i];
        }
    }

    /**
     * Set the request body for this request. Request body is only used if
     * RequestMethod is PUT, PATCH, POST or DELETE.
     *
     * @param _requestBodyFormat The format the request body will be in.
     * @param _requestBody The content of the request body.
     */
    public void setRequestBody(RequestBodyFormat _requestBodyFormat, String _requestBody) {
        this.requestBodyFormat = _requestBodyFormat;
        this.requestBody = _requestBody;
    }

    //=================  GETTERS ===============
    public String getUrl() {
        return this.url;
    }

    public RequestMethod getRequestMethod() {
        return this.requestMethod;
    }

    public Header[] getHeaders() {
        return this.headers;
    }

    public Query[] getQueries() {
        return this.queries;
    }

    public RequestBodyFormat getRequestBodyType() {
        return this.requestBodyFormat;
    }

    public String getRequestBody() {
        return this.requestBody;
    }

}
