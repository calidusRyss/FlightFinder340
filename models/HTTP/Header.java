package main.java.models.HTTP;

/**
 * A class that represents a header used in HTTP requests
 * @author Teegan Krieger
 */
public class Header {
    
    private final String name;
    private final String value;
    
    public Header(String _name, String _value)
    {
        this.name = _name;
        this.value = _value;
    }
    
    //=================  GETTERS ===============

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
    
}
