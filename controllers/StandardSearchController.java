package flightfinder3.main.java.FlightFinder340.controllers;


import flightfinder3.main.java.FlightFinder340.models.flightapi.structures.property;
import flightfinder3.main.java.FlightPlannerTests.QouteStructBulider;
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
public class StandardSearchController {
    
        
    private static int currentfilghtIndex = 0; 
    private static boolean inilized = false;
    
    public static property[][] flightResuts;
    
    public static JPanel[] flightBoxs;    
    
        
    public static void setFlightbox(JPanel ParentPanel, property[] props ) {
        
        for( Component c : ParentPanel.getComponents())        
        {
                       
            if (c instanceof JLabel && c.getName()  != null)
            {
                JLabel j =(JLabel) c;
          
                
                for ( property p : props )
                {
                    
                    if (c.getName().toLowerCase().equals(p.name.toLowerCase() ))
                    {
                        j.setText(p.content);
                    }  
                }   
            }
    
        }
        
    }
    
    
    
    public static void setAllFlightBoxsNext()
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
    
    
    public static void setAllFlightBoxsBack()
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
        
    
    public static void setRandomFlightResults(int numofflights)
    {
        property[][] results = new  property[numofflights] [8];
        
        ArrayList<QuoteStruct> qsarr = QouteStructBulider.getArrList(numofflights);
        
        for (int i = 0; i < numofflights; i++)
        {
            QuoteStruct qs = qsarr.get(i);
            
            property[] props = ConvertQuoteToPropertyArr(qs) ;
            
            property index = new property("index","" +i);
            props[7] = index;
            
            results[i] = props;
        }
        
        flightResuts = results;
    }
    
    private static property[] ConvertQuoteToPropertyArr(QuoteStruct qs)
    {
         property[] parr = new  property[8];
        
        parr[0] = new property("Origin",qs.origin);
        parr[1] = new property("originDepartureTime",qs.originDepartureTime);
        parr[2] = new property("originFlightCarrier",qs.originFlightCarrier);
        parr[3] = new property("destination",qs.destination);
        parr[4] = new property("inboundDepartureTime",qs.inboundDepartureTime);
        parr[5] = new property("inboundFlightCarrier",qs.inboundFlightCarrier);
        parr[6] = new property("price",qs.price);
        
        return parr;
        
    }
}

