package main.java.api.skyscanner.models.structures;

/**
 * A class that holds information about a QuotePlace from the SkyScanner API
 *
 * @author Willie Holmes
 * @LastModified 11/15/2020
 */
public class QuotePlace {

    private int PlaceId;
    private String Name;
    private String Type;
    private String SkyscannerCode;

    /**
     * Construct a Places object
     *
     * @param _PlaceId. Example: '837
     * @param _Name. Example 'United Arab Emirates'
     * @param _Type Example: 'Country'
     * @param _SkyscannerCode Example 'AE'
     */
    public QuotePlace(int _PlaceId, String _Name, String _Type, String _SkyscannerCode) {
        this.PlaceId = _PlaceId;
        this.Name = _Name;
        this.Type = _Type;
        this.SkyscannerCode = _SkyscannerCode;
    }

    @Override
    public String toString() {
        return "QuotePlace{" + "PlaceId=" + PlaceId + ", Name=" + Name + ", Type=" + Type + ", SkyscannerCode=" + SkyscannerCode + '}';
    }

    //=================  GETTERS ===============
    /**
     * Get an integer that represents the ID of the QuotePlace
     *
     * @return An integer that represents the ID of the QuotePlace
     */
    public int getPlaceId() {
        return PlaceId;
    }

    /**
     * Get the name of the country this QuotePlace holds
     *
     * @return The name of the country this QuotePlace holds
     */
    public String getName() {
        return Name;
    }

    /**
     * Get the type of this QuotePlace object
     *
     * @return The type of this QuotePlace object
     */
    public String getType() {
        return Type;
    }

    /**
     * Get the SkyScanner API code that this QuotePlace represents
     *
     * @return The SkyScanner API code that this QuotePlace represents
     */
    public String getSkyscannerCode() {
        return SkyscannerCode;
    }

}
