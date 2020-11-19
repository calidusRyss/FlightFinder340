package flightfinder3.main.java.FlightFinder340.Views;
/*
Last updated 10-28-2020.
This is the main View file for Standard Search function it is passed the needed components from a JFrame in its constructor.
The main feature is updateing a Fligtbox panel. with search results. 
Contributors-Michael
*/

import java.awt.Component;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import main.java.FlightFinder340.Views.MainView;
import main.java.FlightFinder340.controllers.ControllerBox;
import main.java.controllers.CountryController;
import main.java.controllers.CurrencyController;
import main.java.controllers.PlaceSuggestionsController;
import main.java.controllers.QuoteSearchController;
import main.java.models.flightapi.enums.StoreSortMode;
import main.java.models.flightapi.structures.Property;
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
        
    private final int numberOfProps = 8;
    private  int currentfilghtIndex = 0; 
    private  boolean inilized = false;
    
    private  Property[][] flightResuts;
    private  Property[] searchFields;
    private  StandardSearchCollector searchCollector;
    private JPanel[] flightBoxs;    
    private JPanel flightBoxPanel;
    private QuoteSearchController QuoteRetriever;

    
    public StandardSearchView(StandardSearchCollector _collector, JPanel _fBoxPanel) {
                
       
        
        this.QuoteRetriever = ControllerBox.getBox().getQuoteSearchCont();
        this.searchCollector = _collector;
        this.flightBoxPanel = _fBoxPanel;       
        
        setLableNames(this.flightBoxPanel);   
        
        this.flightBoxs = getPanelChildren(this.flightBoxPanel);        

        // This just sets the boders of each flight box to null so the don't look out of place
        // before being populated.
        for(  JPanel jp :  this.flightBoxs)
        {
            jp.setVisible(false);            
        } 
    }       
    
     
    public void updateSugjustions(JList list,String text)
    {
        
    }
    
    public void loadSortModes(JComboBox _combo)
    {
        _combo.removeAllItems();
        
        int index = 0;
        int count =0;
        for (StoreSortMode mode : StoreSortMode.values())
        {
            count++;
            _combo.addItem(mode.toString());
            if (ControllerBox.getBox().getQuoteSearchCont().getCurrentSortMode() == mode)
                index = count;
        }    
        
        _combo.setSelectedIndex(index);
        
    }
    
    public void setSortMode(int _index)
    {
        if (_index >= 0)
            ControllerBox.getBox().getQuoteSearchCont().sortQuotesBy(StoreSortMode.values()[_index]);
    }
    
    public static void setLableNames( JPanel _jp)
    {                
        for( Component c : _jp.getComponents())        
        {
            JPanel box = (JPanel)c;
                                    
            
           for( Component c2 : box.getComponents())        
           {
                if (c2 instanceof JLabel)
                {
                    JLabel j =(JLabel) c2;
                    String s = j.getText();

                    if (s != null )
                    {
                        j.setName(j.getText());
                        j.setText("");

                    }  
                }   
           }      
        }    
    }
    
    public static JPanel[] getPanelChildren(JPanel _jp)
    {
        int num =0;
        
        for( Component c : _jp.getComponents())        
        {
            if (c instanceof JPanel)
                num++;
        }
        
        
        ArrayList<JPanel> List = new ArrayList<>();
        JPanel[] result = new JPanel[num];
        
        for( Component c : _jp.getComponents())        
        {
            if (c instanceof JPanel)
            {
                JPanel j = (JPanel) c;
                 List.add(j);
            }
        }   
        
        while (List.size() > 0)
        {
            JPanel max = List.get(0);
            for (int i = 1; i < List.size(); i++)
            {
                if (max.getY() < List.get(i).getY() )
                    max = List.get(i);
            }
            
            result[--num] = max;
            
            List.remove(max);
            
        }            
        return result;
    }          
    
    
        
    private void setFlightbox(JPanel ParentPanel, Property[] _props ) {
        
        ParentPanel.setVisible(true);
        
        Component[] arr = ParentPanel.getComponents();
        
        for( Component c : ParentPanel.getComponents())        
        {
                       
            if (c instanceof JLabel && c.getName()  != null)
            {
                JLabel j =(JLabel) c;
                String cn = c.getName().toLowerCase();  
          
                
                for ( Property p : _props )
                {
                    if (p != null)
                    {
                        String pn = p.name.toLowerCase();
                    
                        if (cn.equals(pn))
                        {
                            j.setText(p.content);
                        }  
                    }
                   
                }   
            }
    
        }
        
    }
    
    public void setFlightResults()
    {
       this.flightBoxs = getPanelChildren(this.flightBoxPanel);   
        
       System.out.println(ControllerBox.getBox().getCurrencyCont().getSelectedCurrencySymbol());
       System.out.println(ControllerBox.getBox().getCurrencyCont().getSelectedCurrencyCode());
        
        ArrayList<QuoteStruct> qsarr = QuoteRetriever.searchQuotes(searchCollector.getFields());
         Property[][] results = new  Property[qsarr.size()] [numberOfProps +1];
        
        
        
        for (int i = 0; i < qsarr.size(); i++)
        {
            QuoteStruct qs = qsarr.get(i);
            
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
    
    public void setAllFlightBoxsNext()
    {
        if (flightResuts == null)
            return;      
        
        if (inilized == false)
            {inilized = true;}
        else
        {
            currentfilghtIndex += flightBoxs.length;
            if (currentfilghtIndex > flightResuts.length - flightBoxs.length)
                currentfilghtIndex = flightResuts.length - flightBoxs.length;
        }
        
        for (int box=0; box < flightBoxs.length; box++)
        {           
           
            if (flightResuts.length != 0 && currentfilghtIndex + box < flightResuts.length)
                setFlightbox(flightBoxs[box],flightResuts[currentfilghtIndex + box]);            
            
        }
    }
    
    
    public void setAllFlightBoxsBack()
    {
        if (flightResuts == null)
            return;        
     
        if (inilized == false)
            {inilized = true;}
        else
        {
            currentfilghtIndex -= flightBoxs.length;
            if (currentfilghtIndex < 0)
                currentfilghtIndex = 0;
        }
        
        for (int box=0; box < flightBoxs.length; box++)
        {            
            
          setFlightbox(flightBoxs[box],flightResuts[currentfilghtIndex + box]);            
            
        }
    }
        
    
    
    
    public Property[] ConvertQuoteToPropertyArr(QuoteStruct qs)
    {
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
}

