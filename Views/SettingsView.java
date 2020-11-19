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
import main.java.controllers.CurrencyController;

/**
 *
 * @author Callidus
 */
public class SettingsView {
    
    private CountryController countryCont;
    private CurrencyController CurrencyCont;
    private final JComboBox comboCounty;
    private final JComboBox comboCurrency;
    
    public SettingsView(JComboBox _comboCounty, JComboBox _comboCurrency)
    {
        comboCounty = _comboCounty;
        comboCounty.removeAllItems();
        comboCurrency = _comboCurrency;
        comboCurrency.removeAllItems();
        inilize();
    }
    
    public void inilize(){
        this.countryCont = ControllerBox.getBox().getCountryCont();
        
        for (String s : this.countryCont.getAllCountryNames()) {           
            comboCounty.addItem(s);
        }  
        
        this.setCountry(countryCont.getIndexOf("US"));
        
        
        this.CurrencyCont = ControllerBox.getBox().getCurrencyCont();     
        
        for (String s : this.CurrencyCont.getAllCurrencyCodes()) {
            comboCurrency.addItem(s);
        }
        
        this.setCurrency(CurrencyCont.getIndexOf("USD"));
        
        
    }    
    
    
    public void setCountry(int index)
    {
        comboCounty.setSelectedIndex(index);
        countryCont.selectCountry(index);
    }
    
    public void setCurrency(int index)
    {
        comboCurrency.setSelectedIndex(index);
        CurrencyCont.selectCurrency(index);
    }
    
    public String getCountyName()
    {
        return countryCont.getSelectedCountryName();
    }
    
    
}
