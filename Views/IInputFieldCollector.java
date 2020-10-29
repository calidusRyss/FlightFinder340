package flightfinder3.main.java.FlightFinder340.Views;
/*
Last updated 10-28-2020.
This is an interface for getting data from from some source. Itended use is input fields in a JFrame. 
Contributors-Michael
*/

import main.java.models.flightapi.structures.Property;

/**
 *
 * @author Callidus
 */
public interface IInputFieldCollector {
    
    public Property[] getFields();   
    
}
