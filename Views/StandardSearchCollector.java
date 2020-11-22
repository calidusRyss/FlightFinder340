package main.java.FlightFinder340.Views;
/*
Last updated 10-28-2020.
This is an implementation of a input Collector for the standard search view.  
Contributors-Michael
*/
import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.TimePicker;
import main.java.models.flightapi.structures.Property;
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
public class StandardSearchCollector implements IInputFieldCollector{
    
    
    protected  JTextField origin;
    protected  JTextField destination;
    protected  DatePicker departing;
    protected  DatePicker returning;
    protected  TimePicker departTime;
    protected  TimePicker returnTime;

    public StandardSearchCollector(JTextField _origin, JTextField _destination, DatePicker _departing, DatePicker _returning, TimePicker _departTime, TimePicker _returnTime) {
        this.origin = _origin;
        this.destination = _destination;
        this.departing = _departing;
        this.returning = _returning;
        this.returnTime = _returnTime;
        this.departTime = _departTime;
        
        this.departing.setDate(LocalDate.now().plusDays(1));
        this.returning.setDate(this.departing.getDate().plusDays(1));
        
        this.returnTime.setTime(LocalTime.of(8, 0));
        this.departTime.setTime(LocalTime.of(18, 0));
    }
   
    
    public String getISO_LOCAL_DATE_TIME(DatePicker _DatePicker ,TimePicker _TPick)
    {
        
      LocalDate d = _DatePicker.getDate();
      if (d == null)
          d = LocalDate.now();
      
      LocalTime t =  _TPick.getTime();   
      if (t == null)
          t = LocalTime.now();
      
      LocalDateTime ldt = LocalDateTime.of(
              d.getYear(),
              d.getMonth(),
              d.getDayOfMonth(),
              t.getHour(),
              t.getMinute());
        
        return ldt.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        
    }
        
    public Property[] getFields()
    {       
               
        Property[] result = new Property[6];
        result[0] = new Property( "origin",this.origin.getText());
        result[1] = new Property( "destination",this.destination.getText());
        result[2] = new Property( "departing", getISO_LOCAL_DATE_TIME(this.departing,this.departTime));
        result[3] = new Property( "returning",getISO_LOCAL_DATE_TIME(this.returning,this.returnTime));
        result[4] = new Property( "currencycode",ControllerBox.getBox().getCurrencyCont().getSelectedCurrencyCode());
        result[5] = new Property( "countrycode",ControllerBox.getBox().getCountryCont().getSelectedCountryCode());
        
        return result; 
    }
    
}
