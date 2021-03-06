package main.java.Views;
/*
Last updated 11-27-2020.
Contributors-Michael
This is the main View file for Standard Search function it is passed the needed components from a JFrame in its constructor.
The main feature is updateing a Fligtbox panel. with search results.
*/

import main.java.FlightFinder340.Views.interfaces.IInputFieldCollector;
import main.java.Views.JPanels.FlightBoxJPanel;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import main.java.FlightFinder340.Views.helpers.KeyInputUpdater;
import main.java.controllers.ControllerBox;
import main.java.controllers.PlaceSuggestionsController;
import main.java.controllers.QuoteSearchController;
import main.java.exceptions.controllers.QuoteRequestException;
import main.java.models.trips.collections.Trip;
import main.java.models.enums.SortMode;
import main.java.models.general.Property;
import main.java.models.flightapi.structures.QuoteStruct;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Callidus
 */
public class StandardSearchView {


    protected final int numberOfFlightBoxes = 4;
    private final int numberOfProps = 8;
    private  int currentfilghtIndex = 0;
    private  boolean inilized = false;

    private  Property[][] flightResuts;
    private  Property[] searchFields;
    private  IInputFieldCollector searchCollector;
    protected JPanel[] flightBoxs;
    protected JPanel flightBoxPanel;
    private QuoteSearchController QuoteRetriever;
    private ArrayList<KeyInputUpdater> kIUpdaterList;


    /**
     * Public Constructor.
     * @param _collector This is a helper class to collect inputs from user fields.
     * @param _fBoxPanel This is the JPanel that the flight boxes will be added to.
     */
    public StandardSearchView(IInputFieldCollector _collector, JPanel _fBoxPanel) {

        kIUpdaterList = new ArrayList<KeyInputUpdater>();
        flightBoxs = new JPanel[numberOfFlightBoxes];

        this.QuoteRetriever = ControllerBox.getBox().getQuoteSearchCont();
        this.searchCollector = _collector;
        this.flightBoxPanel = _fBoxPanel;
        this.addFlightBoxPanels();

        this.setLableNames(this.flightBoxPanel);

        //this.flightBoxs = getPanelChildren(this.flightBoxPanel);

        // This just sets the boders of each flight box to null so the don't look out of place
        // before being populated.
        for(  JPanel jp :  this.flightBoxs) {
            jp.setVisible(false);
        }
    }

    /**
     * Updates the Suggestions.
     * @param _jList The Jlist where Suggestions will be displayed.
     * @param _inputFieldText The Inputfield used to query for Suggestions.
     * @param _identifier a unique identifier for the Suggestion field.
     */
    public void updateSugjustions(JList _jList, String _inputFieldText, String _identifier) {

        boolean kiuExsists = false;

        for (KeyInputUpdater kiu : kIUpdaterList) {
            if (_identifier.equals(kiu.getIdentifier())) {
                kiu.updateInput(_inputFieldText);
                kiuExsists = true;
            }
        }

        if (kiuExsists == false) {
            kIUpdaterList.add(new KeyInputUpdater(_jList, _inputFieldText, _identifier));
        }
    }

    /**
     *  Populates a ComboBox with SortMode enums.
     * @param _combo
     * @param _defaultMode
     */
    public void loadSortModes(JComboBox _combo, SortMode _defaultMode) {
        _combo.removeAllItems();

        int index = 0;
        int count =0;
        for (SortMode mode : SortMode.values()) {

            _combo.addItem(mode.toString());
            if (_defaultMode == mode) {
                index = count;
            }
            count++;
        }
        _combo.setSelectedIndex(index);
    }

    /**
     * sets the sort mode from the index provided.
     * @param _index
     */
    public void setSortMode(int _index) {
        if (_index >= 0)
            ControllerBox.getBox().getQuoteSearchCont().sortQuotesBy(SortMode.values()[_index]);
    }

    public static void setLableNames( JPanel _jp) {
        for( Component c : _jp.getComponents()) {
            JPanel box = (JPanel)c;

           for( Component c2 : box.getComponents()) {
                if (c2 instanceof JLabel) {
                    JLabel j = (JLabel) c2;
                    String s = j.getText();

                    if (s != null ) {
                        j.setName(j.getText());

                        if (s.startsWith("\"") == false){
                            j.setText("");
                        } else {
                            j.setText(s.replace('\"', ' '));
                        }
                    }
                }
           }
        }
    }

    /**
     * sets FlightResults by querying the API.
     */
    public void setFlightResults() {
        try{
            setFlightResults(QuoteRetriever.searchQuotes(searchCollector.getFields()));
        } catch (QuoteRequestException e)
        {
             JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(flightBoxPanel);

            JOptionPane.showMessageDialog( frame,
                "Your search parameters were invalid!\nPlease try different parameters!"
                );
        }
    }

    /**
     * shows the next set of results on the flightboxes.
     */
    public void setAllFlightBoxsNext() {

        if (inilized == false)
            inilized = true;
        else {
            currentfilghtIndex += flightBoxs.length;
            if (currentfilghtIndex > flightResuts.length - flightBoxs.length)
                currentfilghtIndex = flightResuts.length - flightBoxs.length;
        }

        for (int box=0; box < flightBoxs.length; box++) {

            if (flightResuts.length != 0 ) {
                if ( currentfilghtIndex + box < flightResuts.length) {
                    flightBoxs[box].setVisible(true);
                    setFlightbox(flightBoxs[box],flightResuts[currentfilghtIndex + box]);
                }else {
                    flightBoxs[box].setVisible(false);
                }
            }else {
                 flightBoxs[box].setVisible(false);
            }
        }
    }

    /**
     * setFlightResults by using the provided  ArrayList.
     * @param _qsarr the Array list to display each quote will be displayed on it's own flight box.
     */
    public void setFlightResults(ArrayList<QuoteStruct> _qsarr) {

        Property[][] results = new  Property[_qsarr.size()] [numberOfProps +1];


        for (int i = 0; i < _qsarr.size(); i++) {
            QuoteStruct qs = _qsarr.get(i);

            Property[] quoteProps = ConvertQuoteToPropertyArr(qs) ;



            Property index = new Property("index","" +(i+1) );
            quoteProps[numberOfProps] = index;

            results[i] = quoteProps;
        }

        flightResuts = results;
        currentfilghtIndex = 0;
        inilized = false;
        setAllFlightBoxsNext();

    }

    /**
     * shows the previous set of results on the flightboxes.
     */
    public void setAllFlightBoxsBack() {
        if (flightResuts == null)
            return;

        if (inilized == false)
            {inilized = true;}
        else {
            currentfilghtIndex -= flightBoxs.length;
            if (currentfilghtIndex < 0)
                currentfilghtIndex = 0;
        }


        for (int box=0; box < flightBoxs.length; box++) {

            if (flightResuts.length != 0 ) {
                if ( currentfilghtIndex + box < flightResuts.length) {
                    flightBoxs[box].setVisible(true);
                    setFlightbox(flightBoxs[box],flightResuts[currentfilghtIndex + box]);
                }else {
                    flightBoxs[box].setVisible(false);
                }
            }else {
                 flightBoxs[box].setVisible(false);
            }

        }
    }

    /**
     * Converts a QuoteStruct to an array of properties intended to be used to set the values of labels in a flight box.
     * @param qs
     * @return
     */
    public Property[] ConvertQuoteToPropertyArr(QuoteStruct qs) {
        LocalDateTime outldt = LocalDateTime.parse(qs.outboundDepartureTime, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        String outDepartureTime = outldt.format(DateTimeFormatter.ISO_DATE) + " " + outldt.format(DateTimeFormatter.ofPattern("HH:MM"));

         Property[] parr = new  Property[numberOfProps+1];

        parr[0] = new Property("Origin",qs.outboundOrigin);
        parr[1] = new Property("originDepartureTime",outDepartureTime);
        parr[2] = new Property("originFlightCarrier",qs.outboundFlightCarriers[0]);
        parr[3] = new Property("destination",qs.outboundDestination);
        parr[4] = new Property("inboundDepartureTime",qs.inboundDepartureTime);

        String s = "";
        if( qs.inboundFlightCarriers.length > 0)
            s = qs.inboundFlightCarriers[0];
        parr[5] = new Property("inboundFlightCarrier",s);
        parr[6] = new Property("price",qs.price);

        return parr;
    }



    protected void addFlightBoxPanels() {
        for (int i = 0; i < numberOfFlightBoxes; i++) {
            JPanel fbox = new FlightBoxJPanel();
              this.flightBoxPanel.add(fbox);
             flightBoxs[i] = fbox;

        }
    }

    private void setFlightbox(JPanel _parentPanel, Property[] _props ) {

        _parentPanel.setVisible(true);

        Component[] arr = _parentPanel.getComponents();

        for( Component c : _parentPanel.getComponents()) {

            if (c instanceof JComboBox) {
                ((JComboBox) c).removeAllItems();

                for (Trip t : ControllerBox.getBox().getTripCont().getAllTrips()) {
                    ((JComboBox) c).addItem(t.getName());
                }
            }

            if (c instanceof JLabel && c.getName()  != null) {
                JLabel j =(JLabel) c;
                String cn = c.getName().toLowerCase();

                for ( Property p : _props ) {
                    if (p != null) {
                        String pn = p.name.toLowerCase();

                        if (cn.equals(pn)) {
                            j.setText(p.content);
                        }
                    }
                }
            }
        }
    }
}

