package main.java.FlightFinder340.Views;
/*
Last updated 11-27-2020.
This is a class for Updateing a JList by passing the inpute from a input field to
the PlaceSuggestionsController.
Contributors-Michael
*/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.Timer;
import main.java.controllers.ControllerBox;
import main.java.controllers.PlaceSuggestionsController;

/**
 *
 * @author Callidus
 */
public class KeyInputUpdater {

    private final int updateDelaySeconds = 1;
    private final int maxSuguestions = 5;
    private final String lable;
    private String inputFieldText;
    private final JList list;
    private Timer timer;

    public KeyInputUpdater(JList _list, String _inputFieldText, String _lable)
    {
        list =_list;
        inputFieldText = _inputFieldText;
        lable = _lable;

        timer = new Timer(updateDelaySeconds *1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
            updateSugjustions();
            }
        } );

        timer.setRepeats(false);
        timer.start();
    }

    public void updateInput(String _inputFieldText) {
        inputFieldText = _inputFieldText;
        timer.restart();
    }

    private void updateSugjustions() {
        PlaceSuggestionsController placeSug = ControllerBox.getBox().getPlaceSuggestionsCont();

        placeSug.setQuery(inputFieldText);
        placeSug.refreshSuggestions();
        String[] suggestions = placeSug.getSuggestions();

        DefaultListModel listModel = new DefaultListModel();


        for (int i = 0 ; i < this.maxSuguestions; i++) {
            if (i < suggestions.length) {
                listModel.addElement(suggestions[i]);
            }
        }
        listModel.addElement(" ");

        try {
            list.setModel(listModel);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.print("hey");
        }

    }

//=================  GETTERS ===============
 public String getLable() {
        return lable;
    }

}
