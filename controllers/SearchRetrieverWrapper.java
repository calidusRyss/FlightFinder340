/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.controllers;

import main.java.models.flightapi.structures.Property;
import java.util.ArrayList;
import main.java.models.flightapi.structures.QuoteStruct;

/**
 *
 * @author Callidus
 */
public interface SearchRetrieverWrapper {

    public ArrayList<QuoteStruct> getStandardResults(Property[] searchFields);

}
