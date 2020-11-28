package main.java.Views;
/*
Last updated 11-27-2020.
This is an implementation of a input Collector for the standard search view.
Contributors-Michael
*/
import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.TimePicker;
import main.java.models.general.Property;
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


    public ToAnyWhereCollector(JTextField _origin, DatePicker _departing, TimePicker _departTime) {
        super(
                _origin,
                null,
                _departing,
                _departTime
                );
    }

    @Override
    public Property[] getFields() {

        Property[] result = new Property[numberofProperties];
        result[0] = new Property( "origin",this.origin.getText());
        result[1] = new Property( "destination","Anywhere");
        result[2] = new Property( "departing", this.convertToIso_LocalL_Date_Time(this.departing,this.departTime));
        result[3] = new Property( "currencycode",ControllerBox.getBox().getCurrencyCont().getSelectedCurrencyCode());
        result[4] = new Property( "countrycode",ControllerBox.getBox().getCountryCont().getSelectedCountryCode());

        return result;
    }

}
