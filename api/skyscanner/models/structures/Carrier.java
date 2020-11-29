package main.java.api.skyscanner.models.structures;

/**
 *
 * @author Willie Holmes
 */
public class Carrier {
    private final int CarrierId;
    private final String Name;

     /**
     * Construct a Carrier object
     * @param _CarrierId The Carrier ID Example: "29"
     * @param _Name The Name of the carrier. Example: 'Mombasa Air Safari'

     */
    public Carrier (int _CarrierId, String _Name) {
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
