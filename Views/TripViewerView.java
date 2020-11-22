/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.FlightFinder340.Views;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import main.java.controllers.ControllerBox;
import main.java.controllers.TripController;
import main.java.models.Trips.Trip;

/**
 *
 * @author Callidus
 */
public class TripViewerView extends StandardSearchView{

    private  TripController tc;
    private int SelectedTripIndex = 0;

    public void setSelectedTripIndex(int _SelectedTripIndex) {
        this.SelectedTripIndex = _SelectedTripIndex;
        ControllerBox.getBox().getTripEditCont().setSelectedTrip(_SelectedTripIndex);
        
        if (this.SelectedTripIndex <0)
            this.SelectedTripIndex = 0;
    }
    
    
    public TripViewerView( JPanel _fBoxPanel) {
       super(null,_fBoxPanel);  
       tc = ControllerBox.getBox().getTripCont();
       tc.createNewTrip("MyFirstTrip");
       
    }
    
    public void createNewTrip(String _tripName)
    {               
        tc.createNewTrip(_tripName);
    }
    
    @Override
    public void setFlightResults()
    {
        setFlightResults(tc.getTripAtIndex(SelectedTripIndex).getQuoteStructArrayList());
    }
    
    public void updateTripListCombobox(JComboBox _combo)
    {
        _combo.removeAllItems();
        for (Trip t : tc.getAllTrips())
        {
            _combo.addItem(t.getName());
        }
    }
}
