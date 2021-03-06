package main.java.models.flightapi.structures;

/**
 * A class that contains currency formatting information
 *
 * @author Willie Holmes
 * @LastModified 10/22/2020
 */
public class Currency {

    private String code;
    private String symbol;
    private String thousandsSeparator;
    private String decimalSeparator;
    private boolean symbolOnLeft;
    private boolean spaceBetweenAmountAndSymbol;
    private int roundingCoefficient;
    private int decimalDigits;

    public Currency() {

    }

    /**
     * Construct a Currency object
     *
     * @param _code The Currency Code. Example: "USD"
     * @param _symbol The Currency Symbol. Example: '$'
     * @param _thousandsSeparator The character to separate thousands positions. Example: ','
     * @param _decimalSeparator The character to separate the decimal of the currency. Example: '.'
     * @param _symbolOnLeft Boolean determining where to place the currency symbol
     * @param _spaceBetweenAmountAndSymbol Boolean determining if a space should separate the currency symbol and the value
     * @param _roundingCoefficient A coefficient used to round the currency
     * @param _decimalDigits The number of digits allowed after the decimal separator
     */
    public Currency(String _code, String _symbol, String _thousandsSeparator, String _decimalSeparator, boolean _symbolOnLeft, boolean _spaceBetweenAmountAndSymbol, int _roundingCoefficient, int _decimalDigits) {
        this.code = _code;
        this.symbol = _symbol;
        this.thousandsSeparator = _thousandsSeparator;
        this.decimalSeparator = _decimalSeparator;
        this.symbolOnLeft = _symbolOnLeft;
        this.spaceBetweenAmountAndSymbol = _spaceBetweenAmountAndSymbol;
        this.roundingCoefficient = _roundingCoefficient;
        this.decimalDigits = _decimalDigits;
    }

    @Override
    public String toString() {
        return "Currency [code=" + this.code + ", decimalDigits=" + this.decimalDigits + ", decimalSeparator=" + this.decimalSeparator
                + ", roundingCoefficient=" + this.roundingCoefficient + ", spaceBetweenAmountAndSymbol="
                + this.spaceBetweenAmountAndSymbol + ", symbol=" + this.symbol + ", symbolOnLeft=" + this.symbolOnLeft
                + ", thousandsSeparator=" + this.thousandsSeparator + "]";
    }

    //=================  GETTERS ===============
    /**
     *
     * @return The Currency Code
     */
    public String getCode() {
        return this.code;
    }

    /**
     *
     * @return The Currency Symbol
     */
    public String getSymbol() {
        return this.symbol;
    }

    /**
     *
     * @return The Thousands Separator String
     */
    public String getThousandsSeparator() {
        return this.thousandsSeparator;
    }

    /**
     *
     * @return The Decimal Separator String
     */
    public String getDecimalSeparator() {
        return this.decimalSeparator;
    }

    /**
     *
     * @return Whether the currency symbol should be displayed on the left or right
     */
    public boolean isSymbolOnLeft() {
        return this.symbolOnLeft;
    }

    /**
     *
     * @return Whether to include a space between the currency symbol and currency value
     */
    public boolean isSpaceBetweenAmountAndSymbol() {
        return this.spaceBetweenAmountAndSymbol;
    }

    /**
     *
     * @return The coefficient used to round the currency value
     */
    public int getRoundingCoefficient() {
        return this.roundingCoefficient;
    }

    /**
     *
     * @return The number of digits allowed after the decimal place
     */
    public int getDecimalDigits() {
        return this.decimalDigits;
    }

    /**
     * Formats a value using this currency's formatting.
     *
     * @param dollarValue The value to format
     * @return A formatted string of the dollarValue
     */
    public String getFormattedValue(int dollarValue) {
        String tempThousands = dollarValue + "";
        String formatted = "";

        for (int i = tempThousands.length() - 1, j = 1; i > -1; i--, j++) {
            formatted = tempThousands.charAt(i) + formatted;
            if (j % 3 == 0 && i - 1 > -1) {
                formatted = this.thousandsSeparator + formatted;
            }

        }

        if (this.symbolOnLeft) {
            return this.symbol + (this.spaceBetweenAmountAndSymbol ? " " : "") + formatted;
        }
        return formatted + (this.spaceBetweenAmountAndSymbol ? " " : "") + this.symbol;
    }

}
