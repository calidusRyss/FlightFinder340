package main.java.Views;
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
    private final String identifier;
    private String inputFieldText;
    private final JList list;
    private Timer timer;

    /**
     *Public Constructor.
     * @param _list the list that will hold the Suggestions.
     * @param _inputFieldText the inputField that provides the source for the Suggestions.
     * @param _identifier the string to identify this instance of KeyInputUpdater.
     */
    public KeyInputUpdater(JList _list, String _inputFieldText, String _identifier) {
        list =_list;
        inputFieldText = _inputFieldText;
        identifier = _identifier;

        //creates a timer that updates the sugstions by calling
        //"updateSugjustions()" after the specifed amount of time.
        timer = new Timer(updateDelaySeconds *1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
            updateSuggestions();
            }
        } );

        timer.setRepeats(false);
        timer.start();
    }

    /**
     * Updates the input for the suggestions and resets the delay timer.
     * @param _inputFieldText the source string for the suggestions.
     */
    public void updateInput(String _inputFieldText) {
        inputFieldText = _inputFieldText;
        timer.restart();
    }

    /**
     * gets the new suggestions from the placeSuguestions Controller.
     */
    private void updateSuggestions() {
        PlaceSuggestionsController placeSug = ControllerBox.getBox().getPlaceSuggestionsCont();

        placeSug.setQuery(inputFieldText);
        placeSug.refreshSuggestions();
        String[] suggestions = placeSug.getSuggestions();

        DefaultListModel listModel = new DefaultListModel();

        // adds each suggestions tp the listModel.
        for (int i = 0 ; i < this.maxSuguestions; i++) {
            if (i < suggestions.length) {
                listModel.addElement(suggestions[i]);
            }
        }
        listModel.addElement(" ");
        list.setModel(listModel);
    }

//=================  GETTERS ===============
 public String getIdentifier() {
        return identifier;
    }

}
