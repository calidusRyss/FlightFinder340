package main.java.api.skyscanner.models.structures;

/**
 * A class that holds information about a flight carrier
 *
 * @author Willie Holmes
 * @LastModified 11/15/2020
 */
public class Carrier {

    private final int carrierId;
    private final String name;

    /**
     * Construct a Carrier object
     *
     * @param _CarrierId The Carrier ID Example: "29"
     * @param _Name The Name of the carrier. Example: 'Mombasa Air Safari'
     *
     */
    public Carrier(int _CarrierId, String _Name) {
        this.carrierId = _CarrierId;
        this.name = _Name;

    }

    @Override
    public String toString() {
        return "Carriers [CarrierId=" + this.carrierId + ", Name=" + this.name + "]";
    }

    //=================  GETTERS ===============
    /**
     * Get an integer that represents the ID of this carrier
     *
     * @return An integer that represents the ID of this carrier
     */
    public int getCarrierId() {
        return this.carrierId;
    }

    /**
     * Get the name of the Carrier
     *
     * @return The Name of the Carrier
     */
    public String getName() {
        return this.name;
    }

}
