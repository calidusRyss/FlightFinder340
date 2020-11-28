package main.java.models.flightapi.structures;

/**
 * A class that contains a country code and name
 *
 * @author Willie Holmes
 * @LastModified 10/22/2020
 */
public class Country {

    private String Code;
    private String Name;

    /**
     * Construct a Countries object
     *
     * @param _CarrierId The Country code Example: "AD"
     * @param _Name The Name of the carrier. Example: 'Andorra'
     *
     */
    public Country(String _Code, String _Name) {
        this.Code = _Code;
        this.Name = _Name;

    }

    @Override
    public String toString() {
        return "Countries [Code=" + Code + ", Name=" + Name + "]";
    }

    //=================  GETTERS ===============
    /**
     *
     * @return The Country code
     */
    public String getCode() {
        return Code;
    }

    /**
     *
     * @return The Name of the Country
     */
    public String getName() {
        return Name;
    }

}
