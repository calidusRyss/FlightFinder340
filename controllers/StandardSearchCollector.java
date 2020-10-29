/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flightfinder3.main.java.FlightFinder340.controllers;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.TimePicker;
import java.awt.Component;
import javax.swing.JTextField;
import main.java.models.flightapi.structures.Property;
/**
 *
 * @author Callidus
 */

public class StandardSearchCollector implements SearchFieldCollector{


    private JTextField origin;
    private JTextField destination;
    private DatePicker departing;
    private DatePicker returning;
    private TimePicker departTime;
    private TimePicker returnTime;

    public StandardSearchCollector(JTextField origin, JTextField destination, DatePicker departing, DatePicker returning, TimePicker departTime, TimePicker returnTime) {
        this.origin = origin;
        this.destination = destination;
        this.departing = departing;
        this.returning = returning;
        this.returnTime = returnTime;
    }





    @Override
    public Property[] getFields()
    {
        Property[] result = new Property[4];
        result[0] = new Property( "origin",origin.getText());
        result[1] = new Property( "destination",destination.getText());
        result[2] = new Property( "departing",departing.getText() + " " + departTime.getText());
        result[3] = new Property( "returning",returning.getText() + " " + returnTime.getText());

        return result;
    }

}
