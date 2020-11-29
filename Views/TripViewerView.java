package main.java.Views;

/*
Last updated 11-27-2020.
Contributors-Michael
This is the main View file for Trip viewer.
The main feature is updateing a Fligtbox panel. with saved search results.
 */

import main.java.Views.JPanels.TripFlightBoxJPanel;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import main.java.controllers.ControllerBox;
import main.java.controllers.TripController;
import main.java.models.trips.collections.Trip;

/**
 *
 * @author Callidus
 */
public class TripViewerView extends StandardSearchView {

    private TripController tc;
    private int SelectedTripIndex = 0;
    private JLabel totalPriceLabel;

    /**
     * Public constructor.
     * @param _fBoxPanel the panel FightBoxes will be added to
     * @param _totalPriceLabel The label to display the total trip price.
     */
    public TripViewerView(JPanel _fBoxPanel, JLabel _totalPriceLabel) {
        super(null, _fBoxPanel);
        tc = ControllerBox.getBox().getTripCont();
        if (tc.getTripsCount() == 0) {
            tc.createNewTrip("MyFirstTrip");
        }
        totalPriceLabel = _totalPriceLabel;
    }

    /**
     * Sets the selected Trip Index.
     * @param _SelectedTripIndex
     */
    public void setSelectedTripIndex(int _SelectedTripIndex) {
        if (_SelectedTripIndex < 0) {
            _SelectedTripIndex = 0;
        }else if (_SelectedTripIndex >= ControllerBox.getBox().getTripCont().getTripsCount()){
            _SelectedTripIndex =  ControllerBox.getBox().getTripCont().getTripsCount();
        }

        this.SelectedTripIndex = _SelectedTripIndex;
        ControllerBox.getBox().getTripEditCont().setSelectedTrip(_SelectedTripIndex);

        if (this.SelectedTripIndex < 0) {
            this.SelectedTripIndex = 0;
        }
    }

    /**
     * Creates a new Trip.
     * @param _tripName 
     */
    public void createNewTrip(String _tripName) {
        tc.createNewTrip(_tripName);
    }

    /**
     * deletes the currently selected trip.
     */
    public void deleteTrip()
    {
        ControllerBox.getBox().getTripCont().deleteTrip(this.SelectedTripIndex);
    }

    /**
     * setFlightResults by getting the flight data for the currently selected trip.
     */
    @Override
    public void setFlightResults() {
        setFlightResults(tc.getTripAtIndex(SelectedTripIndex).getQuoteStructArrayList());
        updateTotalPriceLable();
    }

    /**
     * Updates the TripList Combobox, should be called when a trip is added or deleted.
     * @param _combo 
     */
    public void updateTripListCombobox(JComboBox _combo) {
        _combo.removeAllItems();
        for (Trip t : tc.getAllTrips()) {
            _combo.addItem(t.getName());
        }
    }

    @Override
    protected void addFlightBoxPanels() {
        for (int i = 0; i < numberOfFlightBoxes; i++) {
            JPanel fbox = new TripFlightBoxJPanel(this);
            this.flightBoxPanel.add(fbox);
            flightBoxs[i] = fbox;
        }
    }

    private void updateTotalPriceLable() {
        totalPriceLabel.setText(ControllerBox.getBox().getTripEditCont().getSelectedTrip().getCurrency().getSymbol()
                + ControllerBox.getBox().getTripEditCont().getSelectedTrip().getTotalPrice());
    }
}
