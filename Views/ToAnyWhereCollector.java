package main.java.FlightFinder340.Views;
/*
Last updated 10-28-2020.
This is an implementation of a input Collector for the standard search view.  
Contributors-Michael
*/
import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.TimePicker;
import main.java.models.flightapi.structures.Property;
import java.awt.Component;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JTextField;
import main.java.controllers.ControllerBox;

/**
 *
 * @author Callidus
 */
public class ToAnyWhereCollector extends StandardSearchCollector {


    public ToAnyWhereCollector(JTextField _origin, DatePicker _departing, DatePicker _returning, TimePicker _departTime, TimePicker _returnTime) {
        super(
                _origin,
                null,
                _departing,
                _returning,
                _departTime,
                _returnTime
                );
    }
        
  
    
    /**
     *
     * @return
     */
    @Override
    public Property[] getFields()
    {       
               
        Property[] result = new Property[6];
        result[0] = new Property( "origin",this.origin.getText());
        result[1] = new Property( "destination","Anywhere");
        result[2] = new Property( "departing", this.getISO_LOCAL_DATE_TIME(this.departing,this.departTime));
        result[3] = new Property( "returning",getISO_LOCAL_DATE_TIME(this.returning,this.returnTime));
        result[4] = new Property( "currencycode",ControllerBox.getBox().getCurrencyCont().getSelectedCurrencyCode());
        result[5] = new Property( "countrycode",ControllerBox.getBox().getCountryCont().getSelectedCountryCode());
        
        return result; 
    }
    
}
