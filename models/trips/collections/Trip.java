package main.java.models.trips.collections;

import java.util.ArrayList;
import java.util.Arrays;
import main.java.models.flightapi.helpers.QuoteStructConverter;
import main.java.models.flightapi.structures.Currency;
import main.java.models.flightapi.structures.QuoteStruct;
import main.java.models.flightapi.structures.UniversalQuote;

/**
 * A class representing a Trip object. Trips are collections of quotes in sequence.
 *
 * @author Teegan Krieger
 * @LastModified 11/9/2020
 */
public class Trip {

    private UniversalQuote[] quotes;

    private Currency currency;

    private int totalPrice;

    private String name;

    public Trip() {
        this.currency = null;
    }

    public Trip(Currency _currency) {
        this.currency = _currency;
        this.quotes = new UniversalQuote[0];
        this.name = "New Trip";
    }

    /**
     * Add a quote to the Trip
     *
     * @param _quote The quote to add. Must be of the same currency type as the Trip
     */
    public void addQuote(UniversalQuote _quote) {
        if (!_quote.getCurrency().getCode().equals(this.currency.getCode())) {
            throw new IllegalArgumentException("You can only add quotes with the same currency type to the Trip. This trip's currency is: " + this.currency.getCode());
        }

        this.quotes = Arrays.copyOfRange(this.quotes, 0, this.quotes.length + 1);
        this.quotes[this.quotes.length - 1] = _quote;
        this.totalPrice += _quote.getPrice();
    }

    /**
     * Move a quote from one index to another, cascading the quotes in between the old and new indexes into place
     *
     * @param _oldIndex The index of the quote to move
     * @param _newIndex The index to move the quote to
     */
    public void moveQuote(int _oldIndex, int _newIndex) {
        if (_oldIndex < 0 || _oldIndex >= this.quotes.length) {
            throw new IndexOutOfBoundsException();
        }
        if (_newIndex < 0 || _newIndex >= this.quotes.length) {
            throw new IndexOutOfBoundsException();
        }

        if (_oldIndex == _newIndex) {
            return;
        }

        if (_oldIndex < _newIndex) {
            UniversalQuote temp = this.quotes[_oldIndex];

            for (int i = _oldIndex; i < _newIndex; i++) {
                this.quotes[i] = this.quotes[i + 1];
            }
            this.quotes[_newIndex] = temp;
        } else {
            UniversalQuote temp = this.quotes[_newIndex];

            for (int i = _newIndex; i > _oldIndex; i--) {
                this.quotes[i] = this.quotes[i - 1];
            }
            this.quotes[_oldIndex] = temp;
        }

    }

    /**
     * Removes a quote from this Trip
     *
     * @param _index The index of the quote to remove
     */
    public void removeQuote(int _index) {
        if (_index < 0 || _index >= this.quotes.length) {
            throw new IndexOutOfBoundsException();
        }

        if (this.quotes.length == 1) {
            this.totalPrice = 0;
            this.quotes = new UniversalQuote[0];
            return;
        }

        UniversalQuote[] newQuotes = new UniversalQuote[this.quotes.length - 1];

        for (int i = 0; i < _index; i++) {
            newQuotes[i] = this.quotes[i];
        }

        for (int i = _index + 1; i < this.quotes.length; i++) {
            newQuotes[i - 1] = this.quotes[i];
        }

        if (this.quotes[_index] != null) {
            this.totalPrice -= this.quotes[_index].getPrice();
        }

        this.quotes = newQuotes;
    }

    /**
     * Get the total number of Quotes in this Trip
     *
     * @return The total number of Quotes in this Trip
     */
    public int getNumberOfQuotes() {
        return this.quotes.length;
    }

    /**
     * Converts the Quote at the given index into a QuoteStruct
     *
     * @param _index The index of the Quote to get
     * @return A QuoteStruct object made from the Quote at the index
     */
    public QuoteStruct getQuoteStructAtIndex(int _index) {
        if (_index < 0 || _index >= this.quotes.length) {
            throw new IndexOutOfBoundsException();
        }

        return QuoteStructConverter.convertQuoteToStruct(this.quotes[_index]);
    }

    /**
     * Get all Quotes converted into QuoteStructs
     *
     * @return An array of QuoteStructs
     */
    public ArrayList<QuoteStruct> getQuoteStructArrayList() {
        ArrayList<QuoteStruct> arr = new ArrayList<QuoteStruct>();

        for (int i = 0; i < this.quotes.length; i++) {
            arr.add(QuoteStructConverter.convertQuoteToStruct(this.quotes[i]));
        }

        return arr;
    }

    @Override
    public String toString() {
        return "Trip{" + "quotes=" + this.quotes + ", currency=" + this.currency + ", totalPrice=" + this.totalPrice + ", name=" + this.name + '}';
    }

    //=================  SETTERS ===============
    /**
     * Set the name of this Trip
     *
     * @param _newName The new name for the Trip
     */
    public void setName(String _newName) {
        this.name = _newName;
    }

    //=================  GETTERS ===============
    /**
     * Get the total price of the Trip
     *
     * @return The total price of the Trip
     */
    public int getTotalPrice() {
        return this.totalPrice;
    }

    /**
     * Get the currency object used by this Trip
     *
     * @return The currency object used by this Trip
     */
    public Currency getCurrency() {
        return this.currency;
    }

    /**
     * Get the name of this Trip
     *
     * @return The name of this Trip
     */
    public String getName() {
        return this.name;
    }

}
