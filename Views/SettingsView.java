package main.java.Views;
/*
Last updated 11-27-2020.
Contributors-Michael
This is the Settings view. Handdles getting Inputs to change settings.
*/

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JComboBox ;
import main.java.controllers.ControllerBox;
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

    public SettingsView(JComboBox _comboCounty, JComboBox _comboCurrency) {
        comboCounty = _comboCounty;
        comboCounty.removeAllItems();
        comboCurrency = _comboCurrency;
        comboCurrency.removeAllItems();
        inilize();
    }

    public void inilize() {
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



    //=================  GETTERS ===============
    public String getCountyName() {
        return countryCont.getSelectedCountryName();
    }

    //=================  SETTERS ===============
    public void setCountry(int _index) {
        comboCounty.setSelectedIndex(_index);
        countryCont.selectCountry(_index);
    }

    public void setCurrency(int _index) {
        comboCurrency.setSelectedIndex(_index);
        CurrencyCont.selectCurrency(_index);
    }


}
