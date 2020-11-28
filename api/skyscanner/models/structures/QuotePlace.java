package main.java.api.skyscanner.models.structures;

/**
 * A class that holds information about a QuotePlace from the SkyScanner API
 *
 * @author Willie Holmes
 * @LastModified 11/15/2020
 */
public class QuotePlace {

    private int placeId;
    private String name;
    private String type;
    private String skyscannerCode;

    /**
     * Construct a Places object
     *
     * @param _PlaceId. Example: '837
     * @param _Name. Example 'United Arab Emirates'
     * @param _Type Example: 'Country'
     * @param _SkyscannerCode Example 'AE'
     */
    public QuotePlace(int _PlaceId, String _Name, String _Type, String _SkyscannerCode) {
        this.placeId = _PlaceId;
        this.name = _Name;
        this.type = _Type;
        this.skyscannerCode = _SkyscannerCode;
    }

    @Override
    public String toString() {
        return "QuotePlace{" + "PlaceId=" + this.placeId + ", Name=" + this.name + ", Type=" + this.type + ", SkyscannerCode=" + this.skyscannerCode + '}';
    }

    //=================  GETTERS ===============
    /**
     * Get an integer that represents the ID of the QuotePlace
     *
     * @return An integer that represents the ID of the QuotePlace
     */
    public int getPlaceId() {
        return this.placeId;
    }

    /**
     * Get the name of the country this QuotePlace holds
     *
     * @return The name of the country this QuotePlace holds
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get the type of this QuotePlace object
     *
     * @return The type of this QuotePlace object
     */
    public String getType() {
        return this.type;
    }

    /**
     * Get the SkyScanner API code that this QuotePlace represents
     *
     * @return The SkyScanner API code that this QuotePlace represents
     */
    public String getSkyscannerCode() {
        return this.skyscannerCode;
    }

}
