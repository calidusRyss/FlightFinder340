package main.java.models.flightapi.stores;

import java.util.ArrayList;
import main.java.models.flightapi.structures.Currency;

/**
 * A class that manages all currencies
 *
 * @author Teegan Krieger
 * @LastUpdate 10/28/2020
 */
public class CurrencySelector {

    private ArrayList<Currency> allCurrencies;

    private Currency selectedCurrency;

    public CurrencySelector() {
        allCurrencies = new ArrayList<>();
        selectedCurrency = null;
    }

    /**
     * Set the currency data contained in the selector
     *
     * @param _currencyObjects An array of currency objects to store in the selector
     */
    public void setCurrencyData(Currency... _currencyObjects) {
        allCurrencies.clear();
        selectedCurrency = null;

        for (Currency c : _currencyObjects) {
            allCurrencies.add(c);
        }
    }

    /**
     * Set the currency selection using the index of the currency
     *
     * @param _index The index of the currency to set the selection to
     * @throws IndexOutOfBoundsException thrown if the provided index is out of bounds for the data currently in the selector
     */
    public void selectCurrency(int _index) {
        if (_index < 0 || _index > allCurrencies.size() - 1) {
            throw new IndexOutOfBoundsException("The index " + _index + " was not in bounds!");
        }

        selectedCurrency = allCurrencies.get(_index);
    }

    /**
     * Get an array list of all currency codes
     *
     * @return An array list of all currency codes
     */
    public ArrayList<String> getAllCurrencyCodes() {
        ArrayList<String> codes = new ArrayList<String>(allCurrencies.size());

        for (int i = 0; i < allCurrencies.size(); i++) {
            codes.add(i, allCurrencies.get(i).getCode());
        }

        return codes;
    }

    /**
     * Get an array list of all currency symbols
     *
     * @return An array list of all currency symbols
     */
    public ArrayList<String> getAllCurrencySymbols() {
        ArrayList<String> symbols = new ArrayList<String>(allCurrencies.size());

        for (int i = 0; i < allCurrencies.size(); i++) {
            symbols.add(i, allCurrencies.get(i).getSymbol());
        }

        return symbols;
    }

    /**
     * Get the currency code of the selected currency
     *
     * @return The currency code of the selected currency
     */
    public String getSelectedCurrencyCode() {
        return selectedCurrency.getCode();
    }

    /**
     * Get the currency symbol of the selected currency
     *
     * @return The currency symbol of the selected currency
     */
    public String getSelectedCurrencySymbol() {
        return selectedCurrency.getSymbol();
    }

    /**
    * Get the selected Currency object
    * @return The selected currency object
    */
    public Currency getSelectedCurrency()
    {
        return selectedCurrency;
    }

    /**
     * Get the index of either a currency symbol or currency code
     * @param _currencySymbolOrCode The currency symbol or code
     * @return The index of this currency within the selector. Returns -1 if the currency or code was not found
     */
    public int getIndexOf(String _currencySymbolOrCode)
    {
        for (int i = 0; i < allCurrencies.size(); i++)
        {
            Currency c = allCurrencies.get(i);
            if (c.getCode().equals(_currencySymbolOrCode) || c.getSymbol().equals(_currencySymbolOrCode))
                return i;
        }
        return -1;
    }
}
