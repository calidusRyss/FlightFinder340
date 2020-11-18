/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.FlightFinder340.Views;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JComboBox ;
import main.java.FlightFinder340.controllers.ControllerBox;
import main.java.controllers.CountryController;

/**
 *
 * @author Callidus
 */
public class SettingsView {
    
    private CountryController countryCont;
    private final JComboBox combo;
    
    public SettingsView(JComboBox _combo)
    {
        combo = _combo;
        inilize();
    }
    
    public void inilize(){
        this.countryCont = ControllerBox.getBox().getCountryCont();
        
        this.countryCont.loadCountries();
        this.countryCont.selectCountry(0);
        
        combo.removeAllItems();
        
        ArrayList<String> a = this.countryCont.getAllCountryNames();
        System.out.print("hey2");
        
        for (String s : a) {
            System.out.println(s);
            combo.addItem(s);
        }
        
        
    }
    
    public String getCountyName()
    {
        return countryCont.getSelectedCountryName();
    }
    
    
}
