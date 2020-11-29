package main.java.models.http;

/**
 * A class that represents a header used in HTTP requests.
 *
 * @author Teegan Krieger
 * @Last Modified 9/29/2020
 */
public class Header {

    private final String name;
    private final String value;

    public Header(String _name, String _value) {
        this.name = _name;
        this.value = _value;
    }

    //=================  GETTERS ===============
    /**
     * Get the name of the header
     *
     * @return The name of the header
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get the value of the header
     *
     * @return The value of the header
     */
    public String getValue() {
        return this.value;
    }

}
