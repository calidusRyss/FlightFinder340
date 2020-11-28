package main.java.models.flightapi.structures;

/**
 * A class that contains a country code and name
 *
 * @author Willie Holmes
 * @LastModified 10/22/2020
 */
public class Country {

    private String code;
    private String name;

    /**
     * Construct a Countries object
     *
     * @param _Code The Country code Example: "AD"
     * @param _Name The Name of the carrier. Example: 'Andorra'
     *
     */
    public Country(String _Code, String _Name) {
        this.code = _Code;
        this.name = _Name;

    }

    @Override
    public String toString() {
        return "Countries [Code=" + this.code + ", Name=" + this.name + "]";
    }

    //=================  GETTERS ===============
    /**
     *
     * @return The Country code
     */
    public String getCode() {
        return this.code;
    }

    /**
     *
     * @return The Name of the Country
     */
    public String getName() {
        return this.name;
    }

}
