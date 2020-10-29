package flightfinder3.main.java.FlightFinder340.Views;
/*
Last updated 10-28-2020.
This is the main View file for Standard Search function it is passed the needed components from a JFrame in its constructor.
The main feature is updateing a Fligtbox panel. with search results. 
Contributors-Michael
*/
import flightfinder3.main.java.FlightFinder340.controllers.SearchRetrieverWrapper;
import flightfinder3.main.java.FlightFinder340.models.flightapi.structures.Property;
import flightfinder3.main.java.FlightPlannerTests.QouteStructBulider;
import flightfinder3.main.java.FlightPlannerTests.TestMain;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
        
    private  int currentfilghtIndex = 0; 
    private  boolean inilized = false;
    
    public  Property[][] flightResuts;
    public  Property[] searchFields;
    public  StandardSearchCollector searchCollector;
    private JPanel[] flightBoxs;    
    private JPanel flightBoxPanel;
    private SearchRetrieverWrapper retriever;

    
    public StandardSearchView(StandardSearchCollector _collector, JPanel _fBoxPanel) {
        
        this.retriever = new TestMain();
        this.searchCollector = _collector;
        this.flightBoxPanel = _fBoxPanel;
        
        setLableNames(this.flightBoxPanel);   
        
        this.flightBoxs = getPanelChildren(this.flightBoxPanel);

        // This just sets the boders of each flight box to null so the don't look out of place
        // before being populated.
        for(  JPanel jp :  this.flightBoxs)
        {
            jp.setBorder(null);
        }  
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
    
    public static JPanel[] getPanelChildren(JPanel jp)
    {
        int num =0;
        
        for( Component c : jp.getComponents())        
        {
            if (c instanceof JPanel)
                num++;
        }
        
        
        ArrayList<JPanel> List = new ArrayList<>();
        JPanel[] result = new JPanel[num];
        
        for( Component c : jp.getComponents())        
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
                if (max.getY() < List.get(i).getY())
                    max = List.get(i);
            }
            
            result[--num] = max;
            
            List.remove(max);
            
        }            
        return result;
    }          
    
    
        
    private void setFlightbox(JPanel ParentPanel, Property[] props ) {
        
        for( Component c : ParentPanel.getComponents())        
        {
                       
            if (c instanceof JLabel && c.getName()  != null)
            {
                JLabel j =(JLabel) c;
          
                
                for ( Property p : props )
                {
                    
                    if (c.getName().toLowerCase().equals(p.name.toLowerCase() ))
                    {
                        j.setText(p.content);
                    }  
                }   
            }
    
        }
        
    }
    
    public void setFlightResults()
    {
       
        
        ArrayList<QuoteStruct> qsarr = retriever.getStandardResults(searchCollector.getFields());
         Property[][] results = new  Property[qsarr.size()] [8];
        
        
        
        for (int i = 0; i < qsarr.size(); i++)
        {
            QuoteStruct qs = qsarr.get(i);
            
            Property[] props = ConvertQuoteToPropertyArr(qs) ;
            
            Property index = new Property("index","" +i);
            props[7] = index;
            
            results[i] = props;
        }
        
        flightResuts = results;
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
            if (flightBoxs[box].getBorder() == null)
            {
                flightBoxs[box].setBorder(BorderFactory.createEtchedBorder(1));
            }
            
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
         Property[] parr = new  Property[8];
        
        parr[0] = new Property("Origin",qs.origin);
        parr[1] = new Property("originDepartureTime",qs.originDepartureTime);
        parr[2] = new Property("originFlightCarrier",qs.originFlightCarrier);
        parr[3] = new Property("destination",qs.destination);
        parr[4] = new Property("inboundDepartureTime",qs.inboundDepartureTime);
        parr[5] = new Property("inboundFlightCarrier",qs.inboundFlightCarrier);
        parr[6] = new Property("price",qs.price);
        
        return parr;
        
    }
}

