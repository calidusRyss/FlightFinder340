package flightfinder3.main.java.FlightFinder340.controllers;
/*
Last updated 10-28-2020.
This is an interface to retrieve Search results from some source. 
Contributors-Michael
*/

import flightfinder3.main.java.FlightFinder340.models.flightapi.structures.Property;
import java.util.ArrayList;
import main.java.models.flightapi.structures.QuoteStruct;

/**
 *
 * @author Callidus
 */
public interface SearchRetrieverWrapper {
    
    public ArrayList<QuoteStruct> getStandardResults(Property[] searchFields);
    
}
