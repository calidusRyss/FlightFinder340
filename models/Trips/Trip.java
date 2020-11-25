package main.java.models.Trips;

import java.util.Arrays;
import main.java.models.flightapi.QuoteStructConverter;
import main.java.models.flightapi.structures.Currency;
import main.java.models.flightapi.structures.QuoteStruct;
import main.java.models.flightapi.structures.UniversalQuote;

/**
 * A class representing a Trip object. Trips are collections of quotes in sequence.
 *
 * @author Teegan Krieger
 */
public class Trip {

    private UniversalQuote[] quotes;

    private Currency currency;

    private int totalPrice;

    private String name;

    public Trip()
    {
        currency = null;
    }

    public Trip(Currency _currency)
    {
        currency = _currency;
        quotes = new UniversalQuote[0];
        name = "New Trip";
    }

    /**
     * Add a quote to the Trip
     * @param _quote The quote to add. Must be of the same currency type as the Trip
     */
    public void addQuote(UniversalQuote _quote)
    {
        if (!_quote.getCurrency().getCode().equals(currency.getCode()))
            throw new IllegalArgumentException("You can only add quotes with the same currency type to the Trip. This trip's currency is: " + currency.getCode());

        quotes = Arrays.copyOfRange(quotes, 0, quotes.length + 1);
        quotes[quotes.length - 1] = _quote;
        totalPrice += _quote.getPrice();
    }

    /**
     * Move a quote from one index to another, cascading the quotes in between the old and new indexes into place
     * @param _oldIndex The index of the quote to move
     * @param _newIndex The index to move the quote to
     */
    public void moveQuote(int _oldIndex, int _newIndex)
    {
        if (_oldIndex < 0 || _oldIndex >= quotes.length)
            throw new IndexOutOfBoundsException();
        if (_newIndex < 0 || _newIndex >= quotes.length)
            throw new IndexOutOfBoundsException();

        if (_oldIndex == _newIndex)
            return;

        if (_oldIndex < _newIndex)
        {
            UniversalQuote temp = quotes[_oldIndex];

            for (int i = _oldIndex; i < _newIndex; i++)
            {
                quotes[i] = quotes[i + 1];
            }
            quotes[_newIndex] = temp;
        }
        else
        {
            UniversalQuote temp = quotes[_newIndex];

            for (int i = _newIndex; i > _oldIndex; i--)
            {
                quotes[i] = quotes[i - 1];
            }
            quotes[_oldIndex] = temp;
        }

    }

    /**
     * Removes a quote from this Trip
     * @param _index The index of the quote to remove
     */
    public void removeQuote(int _index)
    {
        if (_index < 0 || _index >= quotes.length)
            throw new IndexOutOfBoundsException();

        if (quotes.length == 1)
        {
            totalPrice = 0;
            quotes = new UniversalQuote[0];
            return;
        }

        UniversalQuote[] newQuotes = new UniversalQuote[quotes.length - 1];

        for (int i = 0; i < _index; i++)
        {
            newQuotes[i] = quotes[i];
        }

        for (int i = _index + 1; i < quotes.length - 1; i++)
        {
            newQuotes[i] = quotes[i];
        }

        if (quotes[_index] != null)
            totalPrice -= quotes[_index].getPrice();

        quotes = newQuotes;
    }

    /**
     * Get the total number of Quotes in this Trip
     * @return The total number of Quotes in this Trip
     */
    public int getNumberOfQuotes()
    {
        return quotes.length;
    }

    /**
     * Converts the Quote at the given index into a QuoteStruct
     * @param _index The index of the Quote to get
     * @return A QuoteStruct object made from the Quote at the index
     */
    public QuoteStruct getQuoteStructAtIndex(int _index)
    {
        if (_index < 0 || _index >= quotes.length)
            throw new IndexOutOfBoundsException();

        return QuoteStructConverter.convertQuoteToStruct(quotes[_index]);
    }

    /**
     * Get all Quotes converted into QuoteStructs
     * @return An array of QuoteStructs
     */
    public QuoteStruct[] getQuoteStructArray()
    {
        QuoteStruct[] arr = new QuoteStruct[quotes.length];

        for (int i = 0; i < quotes.length; i++)
        {
            arr[i] = QuoteStructConverter.convertQuoteToStruct(quotes[i]);
        }

        return arr;
    }

    /**
     * Get the total price of the Trip
     * @return The total price of the Trip
     */
    public int getTotalPrice()
    {
        return totalPrice;
    }

    /**
     * Get the currency object used by this Trip
     * @return The currency object used by this Trip
     */
    public Currency getCurrency()
    {
        return currency;
    }

    /**
     * Set the name of this Trip
     * @param _newName The new name for the Trip
     */
    public void setName(String _newName)
    {
        name = _newName;
    }

    /**
     * Get the name of this Trip
     * @return The name of this Trip
     */
    public String getName()
    {
        return name;
    }

    @Override
    public String toString() {
        return "Trip{" + "quotes=" + quotes + ", currency=" + currency + ", totalPrice=" + totalPrice + ", name=" + name + '}';
    }

}
