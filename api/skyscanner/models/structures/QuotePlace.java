/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.api.skyscanner.models.structures;

/**
 *
 * @author Willie Holmes
 */
public class QuotePlace {

    private int PlaceId;
    private String Name;
    //private String PlaceName;
    private String Type;
   // private String CountryId;
  //  private String RegionId;
  //  private String CityId;
    private String SkyscannerCode;


       /**
     * Construct a Places object
     * @param _PlaceId. Example: '837
     * @param _Name. Example 'United Arab Emirates'
     * @param _PlaceName. . Example: 'Paris'
     * @param _Type  Example: 'Country'
     * @param _CountryId. Example 'FR-sky'.
     * @param _RegionId
     * @param _CityId  Example 'PARI-sky'
     * @param _CountryName  Example 'France'
     * @param _SkyscannerCode Example 'AE'
     */
     public QuotePlace (int _PlaceId, String _Name, String _Type, String _SkyscannerCode) {
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
     *
     * @return Place Id
     */
    public int  getPlaceId() {
        return PlaceId;
    }

    /**
     *
     * @return Name of country
     */
    public String getName() {
        return Name;
    }

    /**
     *
     * @return Type of place
     */
    public String  getType() {
        return Type;
    }

    /**
     *
     * @return The OutboundLeg of the trip
     */
    public String getSkyscannerCode() {
        return SkyscannerCode;
    }

}


