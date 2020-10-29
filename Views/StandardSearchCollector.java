package flightfinder3.main.java.FlightFinder340.Views;
/*
Last updated 10-28-2020.
This is an implementation of a input Collector for the standard search view.  
Contributors-Michael
*/
import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.TimePicker;
import flightfinder3.main.java.FlightFinder340.models.flightapi.structures.property;
import java.awt.Component;
import javax.swing.JTextField;

/**
 *
 * @author Callidus
 */
public class StandardSearchCollector implements IInputFieldCollector{
    
    
    private JTextField origin;
    private JTextField destination;
    private DatePicker departing;
    private DatePicker returning;
    private TimePicker departTime;
    private TimePicker returnTime;

    public StandardSearchCollector(JTextField _origin, JTextField _destination, DatePicker _departing, DatePicker _returning, TimePicker _departTime, TimePicker _returnTime) {
        this.origin = _origin;
        this.destination = _destination;
        this.departing = _departing;
        this.returning = _returning;
        this.returnTime = _returnTime;
        this.departTime = _departTime;
    }
   
    
    
    
    
    public property[] getFields()
    {
        property[] result = new property[4];
        result[0] = new property( "origin",this.origin.getText());
        result[1] = new property( "destination",this.destination.getText());
        result[2] = new property( "departing",this.departing.getText() + " " + this.departTime.getText());
        result[3] = new property( "returning",this.returning.getText() + " " + this.returnTime.getText());
        
        return result; 
    }
    
}
