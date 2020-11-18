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
        
    
    public MainView(JFrame _frame)
    {
        LoadedViews = new ArrayList<JPanel>();
        frame = _frame;        
       
        load(new SettingsJPanel());
        load(new StandardSearchJPanel());       
        
        
        
    }
       
    
    
    
    public void setView(Class<?> _view)
    {
        JPanel p = (JPanel) GetLoadedPanel(_view);
        
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
        _p.setSize(frame.getSize());
        frame.add(_p); 
    }
}
