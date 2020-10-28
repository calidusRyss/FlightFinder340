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
public class Carriers {
    private int CarrierId;
    private String Name;


    /**
     * Construct a Currency object
     * @param _CarrierId The Carrier ID Example: "29"
     * @param _Name The Name of the carrier. Example: 'Mombasa Air Safari'
   
     */
    public Carriers (int _CarrierId, String _Name) {
        this.CarrierId = _CarrierId;
        this.Name = _Name;
    
    }
   @Override
    public String toString() {
        return "Carriers [CarrierId=" + CarrierId + ", Name=" + Name  + "]";
    }

    //=================  GETTERS ===============

    /**
     * 
     * @return The Carrier ID
     */
    public int getCarrierId() {
        return CarrierId;
    }

    /**
     * 
     * @return The Name of the Carrier
     */
    public String getName() {
        return Name;
    }

    
}




