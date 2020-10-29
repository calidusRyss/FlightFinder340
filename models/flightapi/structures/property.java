package flightfinder3.main.java.FlightFinder340.models.flightapi.structures;
/*
Last updated 10-28-2020.
This is simple 'struct' like class for Properties.
Contributors-Michael
*/

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
    public final String name;
    public final String content;
    
    public property(String n, String c)
    {
        name = n.toLowerCase();
        content = c;
    }
    
    public static property[] createProperty(String[] s)
    {
        Property[] output = new Property[s.length/2];
        
        for (int i = 0; i < s.length; i+=2)
        {
            Property p = new Property(s[i],s[i+1]);
            
            output[i/2] = p;
        }
        
        return output;        
    }
}
