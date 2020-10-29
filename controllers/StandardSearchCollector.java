/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flightfinder3.main.java.FlightFinder340.controllers;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.TimePicker;
import main.java.FlightFinder340.models.flightapi.structures.property;
import java.awt.Component;
import javax.swing.JTextField;

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





    public property[] getFields()
    {
        property[] result = new property[4];
        result[0] = new property( "origin",origin.getText());
        result[1] = new property( "destination",destination.getText());
        result[2] = new property( "departing",departing.getText() + " " + departTime.getText());
        result[3] = new property( "returning",returning.getText() + " " + returnTime.getText());

        return result;
    }

}
