/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.FlightFinder340.controllers;

import main.java.controllers.CountryController;
import main.java.controllers.CurrencyController;
import main.java.controllers.PlaceSuggestionsController;
import main.java.controllers.QuoteSearchController;

/**
 *
 * @author Callidus
 */
public class ControllerBox {
    
    private static ControllerBox singleton;
     
    
    private CurrencyController currencyCont;
    private CountryController countryCont;
    private PlaceSuggestionsController placeSuggestionsCont;
    private QuoteSearchController quoteSearchCont;
    
    public static ControllerBox getBox()
    {
        if (singleton == null)
        {
            new ControllerBox();                      
        }
        
        return  singleton; 
    }
    
    

    public CurrencyController getCurrencyCont() {
        return currencyCont;
    }

    public CountryController getCountryCont() {
        return countryCont;
    }

    public PlaceSuggestionsController getPlaceSuggestionsCont() {
        return placeSuggestionsCont;
    }

    public QuoteSearchController getQuoteSearchCont() {
        return quoteSearchCont;
    }
    
    public ControllerBox()
    {
        if (singleton == null)
        {
            
            currencyCont = new CurrencyController();
            countryCont = new CountryController();        
            placeSuggestionsCont = new PlaceSuggestionsController(countryCont,currencyCont);
            quoteSearchCont = new QuoteSearchController(placeSuggestionsCont);

            singleton = this;
            
            
                
        }
    }
    
    
}
