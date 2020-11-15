/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightFinderDataStore;

/**
 *
 * @author Willie Holmes
 */
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class FlightFinderDecoder {
    
 public static void main(String[] args) {

  String s = "{\"name\":\"Willie\"}";
  Object o1 = JSONValue.parse(s);
  JSONObject jsonObj = (JSONObject) o1;
  String name = (String) jsonObj.get("name");

  System.out.println(name + " " );
 }
}


