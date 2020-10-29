package flightfinder3.main.java.FlightFinder340.Views;
/*
Last updated 10-28-2020.
This is an interface for getting data from from some source. Itended use is input fields in a JFrame. 
Contributors-Michael
*/

import flightfinder3.main.java.FlightFinder340.models.flightapi.structures.property;

/**
 *
 * @author Callidus
 */
public interface IInputFieldCollector {
    
    public property[] getFields();   
    
}
