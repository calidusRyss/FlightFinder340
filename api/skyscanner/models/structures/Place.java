package main.java.api.skyscanner.models.structures;

/**
 * A class the represents a place obtained via a places request
 * @author Teegan Krieger
 */
public class Place {

    private final String placeID;
    private final String placeName;
    private final String countryID;
    private final String regionID;
    private final String cityID;
    private final String countryName;

    public Place(String _placeID, String _placeName, String _countryID, String _regionID, String _cityID, String _countryName) {
        this.placeID = _placeID;
        this.placeName = _placeName;
        this.countryID = _countryID;
        this.regionID = _regionID;
        this.cityID = _cityID;
        this.countryName = _countryName;
    }

    @Override
    public String toString() {
        return "Place{" + "placeID=" + placeID + ", placeName=" + placeName + ", countryID=" + countryID + ", regionID=" + regionID + ", cityID=" + cityID + ", countryName=" + countryName + '}';
    }

    //=================  GETTERS ===============

    public String getPlaceID() {
        return placeID;
    }

    public String getPlaceName() {
        return placeName;
    }

    public String getCountryID() {
        return countryID;
    }

    public String getRegionID() {
        return regionID;
    }

    public String getCityID() {
        return cityID;
    }

    public String getCountryName() {
        return countryName;
    }

}
