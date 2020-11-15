/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightFinderDataStore;

/**
 *
 * Persistent Data Store Requirements

JsonEncoder Class - Using Reflection? Encodes a class into a JSON format using Org.Json
* Class should have a generic static method called "Encode" maybe with header: void Encode<T>(T objectToEncode)
* Encode Method should use reflection to find all fields in the class and convert the class into a JSON
JsonDecoder Class
* Class should have a generic static method called "Decode" maybe with header: T Decode<T>(JsonObject obj)
* Decode Method should use reflection to emplace data in all fields in a new class of type T by pulling values from the json

SaveLoadWrapper Class - Simple wrapper for saving and loading files
* Class should define a filepath to an special folder (AppData or equivalent) Try: System.getenv("APPDATA")??? This may work, not tested
* The above filepath should point to a folder of our creation, such as Appdata/FlightFinder or something equivalent
* The class should define the following methods:
  void Save(String) - Save the string parameter to the filepath
  String Load() - Load the string from the filepath
* Both above methods should always check if the directory and file itself exist. If they do not, create them
 * 
 * 
 * public abstract class JSONEncoder<T>
extends Object
implements Encoder
 * 
 * 
 */

import org.json.simple.JSONObject;

public class FlightFinderEncoder <T>{
public static void main(String [] args) {
    
  JSONObject Countries = new JSONObject();
  Countries.put("name", "Willie");
  
  System.out.print(Countries);
 }
}

    

