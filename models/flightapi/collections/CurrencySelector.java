package main.java.models.flightapi.collections;

import java.util.ArrayList;
import main.java.models.flightapi.structures.Currency;

/**
 * A class that manages all currencies
 *
 * @author Teegan Krieger
 * @LastModified 10/28/2020
 */
public class CurrencySelector {

    private ArrayList<Currency> allCurrencies;

    private Currency selectedCurrency;

    public CurrencySelector() {
        this.allCurrencies = new ArrayList<>();
        this.selectedCurrency = null;
    }

    //=================  SETTERS ===============
    /**
     * Set the currency data contained in the selector
     *
     * @param _currencyObjects An array of currency objects to store in the selector
     */
    public void setCurrencyData(Currency... _currencyObjects) {
        this.allCurrencies.clear();
        this.selectedCurrency = null;

        for (Currency c : _currencyObjects) {
            this.allCurrencies.add(c);
        }
    }

    /**
     * Set the currency selection using the index of the currency
     *
     * @param _index The index of the currency to set the selection to
     * @throws IndexOutOfBoundsException thrown if the provided index is out of bounds for the data currently in the selector
     */
    public void selectCurrency(int _index) {
        if (_index < 0 || _index > this.allCurrencies.size() - 1) {
            throw new IndexOutOfBoundsException("The index " + _index + " was not in bounds!");
        }

        this.selectedCurrency = this.allCurrencies.get(_index);
    }

    //=================  GETTERS ===============
    /**
     * Get an array list of all currency codes
     *
     * @return An array list of all currency codes
     */
    public ArrayList<String> getAllCurrencyCodes() {
        ArrayList<String> codes = new ArrayList<String>(this.allCurrencies.size());

        for (int i = 0; i < this.allCurrencies.size(); i++) {
            codes.add(i, this.allCurrencies.get(i).getCode());
        }

        return codes;
    }

    /**
     * Get an array list of all currency symbols
     *
     * @return An array list of all currency symbols
     */
    public ArrayList<String> getAllCurrencySymbols() {
        ArrayList<String> symbols = new ArrayList<String>(this.allCurrencies.size());

        for (int i = 0; i < this.allCurrencies.size(); i++) {
            symbols.add(i, this.allCurrencies.get(i).getSymbol());
        }

        return symbols;
    }

    /**
     * Get the currency code of the selected currency
     *
     * @return The currency code of the selected currency
     */
    public String getSelectedCurrencyCode() {
        return this.selectedCurrency.getCode();
    }

    /**
     * Get the currency symbol of the selected currency
     *
     * @return The currency symbol of the selected currency
     */
    public String getSelectedCurrencySymbol() {
        return this.selectedCurrency.getSymbol();
    }

    /**
     * Get the selected Currency object
     *
     * @return The selected currency object
     */
    public Currency getSelectedCurrency() {
        return this.selectedCurrency;
    }

    /**
     * Get the index of either a currency symbol or currency code
     *
     * @param _currencySymbolOrCode The currency symbol or code
     * @return The index of this currency within the selector. Returns -1 if the currency or code was not found
     */
    public int getIndexOf(String _currencySymbolOrCode) {
        for (int i = 0; i < this.allCurrencies.size(); i++) {
            Currency c = this.allCurrencies.get(i);
            if (c.getCode().equals(_currencySymbolOrCode) || c.getSymbol().equals(_currencySymbolOrCode)) {
                return i;
            }
        }
        return -1;
    }
}
