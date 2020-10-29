/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightFinderParsers;

/**
 *
 * @author Willie Holmes
 */
public class Countries {
    private String Code;
    private String Name;


    /**
     * Construct a Countries object
     * @param _CarrierId The Country code Example: "AD"
     * @param _Name The Name of the carrier. Example: 'Andorra'
   
     */
    public Countries (String _Code, String _Name) {
        this.Code = _Code;
        this.Name = _Name;
    
    }
   @Override
    public String toString() {
        return "Countries [Code=" + Code + ", Name=" + Name  + "]";
    }

    //=================  GETTERS ===============

    /**
     * 
     * @return The Country code
     */
    public String getCode() {
        return Code;
    }

    /**
     * 
     * @return The Name of the Country
     */
    public String getName() {
        return Name;
    }

    
}






