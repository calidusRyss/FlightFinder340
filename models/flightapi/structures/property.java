package flightfinder3.main.java.FlightFinder340.models.flightapi.structures;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Callidus
 */
public class property {
    public String name;
    public String content;
    
    property(String n, String c)
    {
        name = n.toLowerCase();
        content = c;
    }
    
    public static property[] createProperty(String[] s)
    {
        property[] output = new property[s.length/2];
        
        for (int i = 0; i < s.length; i+=2)
        {
            property p = new property(s[i],s[i+1]);
            
            output[i/2] = p;
        }
        
        return output;        
    }
}
