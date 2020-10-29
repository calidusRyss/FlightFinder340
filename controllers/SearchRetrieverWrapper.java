<<<<<<< HEAD
package flightfinder3.main.java.FlightFinder340.controllers;
/*
Last updated 10-28-2020.
This is an interface to retrieve Search results from some source. 
Contributors-Michael
*/
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightfinder3.main.java.FlightFinder340.controllers;
>>>>>>> master

import flightfinder3.main.java.FlightFinder340.models.flightapi.structures.property;
import java.util.ArrayList;
import main.java.models.flightapi.structures.QuoteStruct;

/**
 *
 * @author Callidus
 */
public interface SearchRetrieverWrapper {
    
    public ArrayList<QuoteStruct> getStandardResults(property[] searchFields);
    
}
