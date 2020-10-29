package main.java.models.HTTP;

import java.util.HashMap;
import java.util.Map;

/**
 * A class the holds a static map with all response codes.
 * This works around a java limitation that states that ENUM constructors cannot access static fields.
 * @author Teegan Krieger
 * @LastUpdate 10/5/2020
 */
class ResponseCodeMapper {
    private static Map<Integer, ResponseCode> valueToResponseCode = new HashMap<Integer, ResponseCode>();

    /**
     * Put a key and value into the response code map.
     * @param key The integer value representing the response code.
     * @param value The response code itself.
     */
    static void put(Integer key, ResponseCode value)
    {
        valueToResponseCode.put(key, value);
    }

    /**
     * Get a response code via its integer value.
     * @param key The integer value representing a response code.
     * @return The response code represented by the key.
     */
    static ResponseCode get(Integer key)
    {
        return valueToResponseCode.get(key);
    }
}
