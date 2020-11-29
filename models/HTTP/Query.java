package main.java.models.http;

/**
 * A class that represents a Query used in HTTP requests.
 *
 * @author Teegan Krieger
 * @LastModified 9/29/2020
 */
public class Query {

    private final String name;
    private final String value;

    public Query(String _name, String _value) {
        this.name = _name;
        this.value = _value;
    }

    //=================  GETTERS ===============
    /**
     * Get the name of the query
     *
     * @return The name of the query
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get the value of the query
     *
     * @return The value of the query
     */
    public String getValue() {
        return this.value;
    }
}
