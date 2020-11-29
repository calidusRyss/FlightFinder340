package main.java.models.general;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Callidus
 */
public class Property{
    public final String name;
    public final String content;

    public Property(String n, String c)
    {
        this.name = n.toLowerCase();
        this.content = c;
    }

    public static Property[] createProperty(String[] s)
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
