package main.java.models.flightapi.collections;

import java.util.ArrayList;
import main.java.models.flightapi.structures.Country;

/**
 * A class the manages all countries
 *
 * @author Teegan Krieger
 * @LastModified 10/28/2020
 */
public class CountrySelector {

    private ArrayList<Country> allCountries;

    private Country selectedCountry;

    public CountrySelector() {
        allCountries = new ArrayList<>();
        selectedCountry = null;
    }

    /**
     * Set the country data contained in the selector
     *
     * @param _countries An array of country objects to store in the selector
     */
    public void setCountryData(Country... _countries) {
        allCountries.clear();
        selectedCountry = null;

        for (Country c : _countries) {
            allCountries.add(c);
        }
    }

    /**
     * Set the country selection using the index of the country
     *
     * @param _index The index of the country to set the selection to
     * @throws IndexOutOfBoundsException thrown if the provided index is out of bounds for the data currently in the selector
     */
    public void selectCountry(int _index) {
        if (_index < 0 || _index > allCountries.size() - 1) {
            throw new IndexOutOfBoundsException("The index " + _index + " was not in bounds!");
        }

        selectedCountry = allCountries.get(_index);
    }

    /**
     * Get an array list of all country codes
     *
     * @return An array list of all country codes
     */
    public ArrayList<String> getAllCountryCodes() {
        ArrayList<String> codes = new ArrayList<String>(allCountries.size());

        for (int i = 0; i < allCountries.size(); i++) {
            codes.add(i, allCountries.get(i).getCode());
        }

        return codes;
    }

    /**
     * Get an array list of all country names
     *
     * @return An array list of all country names
     */
    public ArrayList<String> getAllCountryNames() {
        ArrayList<String> names = new ArrayList<String>(allCountries.size());

        for (int i = 0; i < allCountries.size(); i++) {
            names.add(i, allCountries.get(i).getName());
        }

        return names;
    }

    /**
     * Get the code of the selected country
     *
     * @return The code of the selected country
     */
    public String getSelectedCountryCode() {
        return selectedCountry.getCode();
    }

    /**
     * Get the name of the selected country
     *
     * @return The name of the selected country
     */
    public String getSelectedCountryName() {
        return selectedCountry.getName();
    }

    /**
     * Get the index of either a country name or country code
     *
     * @param _countryNameOrCode The country name or code
     * @return The index of this country within the selector. Returns -1 if the country or code was not found
     */
    public int getIndexOf(String _countryNameOrCode) {
        for (int i = 0; i < allCountries.size(); i++) {
            Country c = allCountries.get(i);
            if (c.getCode().equals(_countryNameOrCode) || c.getName().equals(_countryNameOrCode)) {
                return i;
            }
        }
        return -1;
    }

}
