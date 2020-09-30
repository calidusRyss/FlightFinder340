package main.java.models.HTTP;

import java.util.Arrays;

/**
 * A class representing an HTTP request
 * @author Teegan Krieger
 */
public class Request {

    private final String url;
    private final RequestMethod requestMethod;
    private Header[] headers;
    private Query[] queries;
    private RequestBodyFormat requestBodyFormat;
    private String requestBody;

    public Request(String _url, RequestMethod _requestMethod) {
        url = _url;
        requestMethod = _requestMethod;
        headers = new Header[0];
        queries = new Query[0];
        requestBodyFormat = RequestBodyFormat.JSON;
        requestBody = "";
    }

    /**
     * Add one or multiple headers to this request
     * @param _headers The headers to add
     */
    public void AddHeaders(Header... _headers) {
        headers = Arrays.copyOf(headers, headers.length + _headers.length);

        for (int i = 0, j = 0; i < _headers.length; i++, j++) {
            headers[j] = _headers[i];
        }
    }

    /**
     * Add one or multiple queries to this request
     * @param _queries The queries to add
     */
    public void AddQueries(Query... _queries) {
        queries = Arrays.copyOf(queries, queries.length + _queries.length);

        for (int i = 0, j = 0; i < _queries.length; i++, j++) {
            queries[j] = _queries[i];
        }
    }

    /**
     * Set the request body for this request.
     * Request body is only used if RequestMethod is PUT, PATCH, POST or DELETE
     * @param _requestBodyFormat The format the request body will be in
     * @param _requestBody The content of the request body
     */
    public void SetRequestBody(RequestBodyFormat _requestBodyFormat, String _requestBody) {
        requestBodyFormat = _requestBodyFormat;
        requestBody = _requestBody;
    }

    /**
     * Checks if this request is valid (within the context of itself. Each wrapper should do further validity checks)
     * @return True is the request is valid, otherwise false
     */
    public boolean CheckValidity() {
        if (!(requestMethod == RequestMethod.GET || requestMethod == RequestMethod.HEAD)) {
            if (requestBody == null) {
                return false;
            }
        }
        return true;
    }

    //=================  GETTERS ===============
    public String getUrl() {
        return url;
    }

    public RequestMethod getRequestMethod() {
        return requestMethod;
    }

    public Header[] getHeaders() {
        return headers;
    }

    public Query[] getQueries() {
        return queries;
    }

    public RequestBodyFormat getRequestBodyType() {
        return requestBodyFormat;
    }

    public String getRequestBody() {
        return requestBody;
    }

}
