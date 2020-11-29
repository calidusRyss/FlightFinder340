package main.java.adapters;

import main.java.api.interfaces.IFlightApiTranslator;
import main.java.api.skyscanner.SkyScannerFlightApiTranslator;

/**
 * An adapter that holds the active Flight API.
 * Classes needing to make API calls should do so through the flightAPI variable in this class
 * @author Teegan Krieger
 */
public class FlightAPIAdapter {

    public static final IFlightApiTranslator flightAPI = new SkyScannerFlightApiTranslator();
}
