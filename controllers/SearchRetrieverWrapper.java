
package main.java.controllers;
/*
Last updated 10-28-2020.
This is an interface to retrieve Search results from some source. 
Contributors-Michael
*/

import java.util.ArrayList;
import main.java.models.general.Property;
import main.java.models.flightapi.structures.QuoteStruct;

/**
 *
 * @author Callidus
 */
public interface SearchRetrieverWrapper {
    
    public ArrayList<QuoteStruct> getStandardResults(Property[] searchFields);
    
}
