/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.FlightFinder340.Views;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import main.java.controllers.CountryController;
import main.java.controllers.CurrencyController;
import main.java.controllers.PlaceSuggestionsController;
import main.java.controllers.QuoteSearchController;

/**
 *
 * @author Callidus
 */
public class MainView {
    
    private ArrayList<JPanel> LoadedViews;
    private final JFrame frame;
    
    private  JPanel[] viewPanels;
        
    
    public MainView(JFrame _frame)
    {
        LoadedViews = new ArrayList<JPanel>();
        frame = _frame;   
        
        try
        {
            loadJPanels();
        }            
        catch  (main.java.exceptions.controllers.ApiFailedToLoadException  e)
        {
           int userChoice = JOptionPane.showConfirmDialog(frame, "Api Failed To Load would you like to  retry?","error", JOptionPane.YES_NO_OPTION);

           if (userChoice == 1)
           {
               loadJPanels();                   
           }
           else
           {
               System.exit(0);
           } 

        }
        
        
            
       
        //load(new LoadingJPanel());
        //setView(LoadingJPanel.class);
        
        for (int i = 0; i < viewPanels.length; i++)
        {
           load(viewPanels[i]);
        }
        
        setView(viewPanels[0].getClass());        
    }
       
    private void loadJPanels()
    {
       viewPanels = new JPanel[] {
            new StandardSearchJPanel(),
            new CheapestToAnywhereSearchJPanel(),
            new SettingsJPanel(),
            new TripViewerJPanel()
        };
    }
    
    
    public void setView(Class<?> _view)
    {
        JPanel p = (JPanel) GetLoadedPanel(_view);
        
        p.setSize(frame.getSize());
        frame.setContentPane(p);   
        frame.repaint();             //Ensures that the frame swaps to the next panel and doesn't get stuck.
        frame.revalidate();   
    }
    
    private JPanel GetLoadedPanel(Class<?> _view)
    {
        if (LoadedViews == null)
            return null;
        else
        {
            for (JPanel j :LoadedViews)
            {
                if (j != null && j.getClass() == _view)
                    return j;
            }  
            return null;
        }
    }
    
    private void load(JPanel _p)
    {
        LoadedViews.add(_p);
        
        frame.add(_p); 
    }
}
