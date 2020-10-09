package main.java.models.HTTP;

/**
 * A class that represents a Query used in HTTP requests.
 *
 * @author Teegan Krieger
 * @LastUpdate 9/29/2020
 */
public class Query {

    private final String name;
    private final String value;

    public Query(String _name, String _value) {
        this.name = _name;
        this.value = _value;
    }

    //=================  GETTERS ===============
    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }
}
