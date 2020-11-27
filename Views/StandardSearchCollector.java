package main.java.FlightFinder340.Views;
/*
Last updated 11-27-2020.
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

    protected final int numberofProperties = 5;
    protected  JTextField origin;
    protected  JTextField destination;
    protected  DatePicker departing;
    protected  TimePicker departTime;


    public StandardSearchCollector(JTextField _origin, JTextField _destination, DatePicker _departing, TimePicker _departTime) {
        this.origin = _origin;
        this.destination = _destination;
        this.departing = _departing;
        this.departTime = _departTime;

        this.departing.setDate(LocalDate.now().plusDays(1));
    }


    public String getISO_LOCAL_DATE_TIME(DatePicker _DatePicker , TimePicker _tPick) {

      LocalDate d = _DatePicker.getDate();
      if (d == null)
          d = LocalDate.now();

      LocalTime t;
      if (_tPick == null) {
            t = LocalTime.now();
      }else {
            t = _tPick.getTime();
      }


      LocalDateTime ldt = LocalDateTime.of(
              d.getYear(),
              d.getMonth(),
              d.getDayOfMonth(),
              t.getHour(),
              t.getMinute());

        return ldt.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);

    }

    public Property[] getFields() {

        Property[] result = new Property[numberofProperties];
        result[0] = new Property( "origin",this.origin.getText());
        result[1] = new Property( "destination",this.destination.getText());
        result[2] = new Property( "departing", getISO_LOCAL_DATE_TIME(this.departing,this.departTime));
        result[3] = new Property( "currencycode",ControllerBox.getBox().getCurrencyCont().getSelectedCurrencyCode());
        result[4] = new Property( "countrycode",ControllerBox.getBox().getCountryCont().getSelectedCountryCode());

        return result;
    }

}
