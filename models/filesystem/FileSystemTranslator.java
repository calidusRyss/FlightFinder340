/*
* Program That follows the CRUD method
* Create
* Read
* Update
* Delete
 */
package main.java.models.filesystem;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.CharBuffer;
import main.java.models.Trips.ReflectionJsonHelper;
import main.java.models.interfaces.IFileSystem;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Teegan Krieger & Willie Holmes
 */
public class FileSystemTranslator implements IFileSystem {

// Creates File to write data into. 
    private static final String appdataPath = System.getenv("APPDATA") + "/Roaming/FlightFinder340";
    private static final String arrayMagicWord = "Array";

    private File dataFile = new File(appdataPath);
    private JSONObject jsonObject;

    public FileSystemTranslator() throws JSONException {
        try {
            if (!dataFile.exists()) {
                dataFile.createNewFile();

                FileReader reader = new FileReader(dataFile);

                CharBuffer buffer = CharBuffer.allocate((int) dataFile.length());

                reader.read(buffer);

                jsonObject = new JSONObject(buffer.toString());

            }
        } catch (IOException e) {
            System.out.println("Error occured: " + e.getMessage());
        }
    }

    @Override

    // Creates the objects to insert into the file. 
    public <T> int create(T _obj) {

            Class klass = _obj.getClass();

            String objectArrayName = klass.getName() + arrayMagicWord;

            ReflectionJsonHelper helper = new ReflectionJsonHelper(klass);

            JSONObject localObj = helper.toJSON(_obj);

        if (!jsonObject.has(objectArrayName)) {
             jsonObject.put(objectArrayName, new JSONArray());
        }

            JSONArray arr = jsonObject.getJSONArray(objectArrayName);

           arr.put(localObj);

              saveData();

        return arr.length();
    }

    @Override

    // Reads the data in the file
    public <T> T[] load(Class<T> _klass) {

             ReflectionJsonHelper helper = new ReflectionJsonHelper(_klass);

        if (_klass == null) {
            
                return null;
        }

            String objectArrayName = _klass.getName() + arrayMagicWord;

        if (!jsonObject.has(objectArrayName)) {
            
                return null;
        }

        try {
                JSONArray jsonArray = jsonObject.getJSONArray(objectArrayName);
                
                Object arr = Array.newInstance(_klass, jsonArray.length());

            for (int i = 0; i < jsonArray.length(); i++) {
                
                Object obj = helper.fromJson(jsonArray.getJSONObject(i));
                
                Array.set(arr, i, obj);
            }

                 saveData();

                 return (T[]) arr;

        } catch (JSONException e) {

            return null;
        }

    }

    @Override

    // Updates data in file at a particular index. 
    public <T extends Object> void update(T _obj, int _index) {

        Class klass = _obj.getClass();

        ReflectionJsonHelper helper = new ReflectionJsonHelper(klass);

        String objectArrayName = klass.getName() + arrayMagicWord;

        if (!jsonObject.has(objectArrayName)) {
            
            return;
        }

        try {
            JSONArray jsonArray = jsonObject.getJSONArray(objectArrayName);

            jsonArray.put(_index, _obj);

            saveData();

        } catch (JSONException e) {

        }
    }

    @Override
    
    //Deletes data  at a particular index. 
    
    public <T extends Object> void delete(int _index, Class<T> _klass) {

        ReflectionJsonHelper helper = new ReflectionJsonHelper(_klass);

        String objectArrayName = _klass.getName() + arrayMagicWord;

             if (!jsonObject.has(objectArrayName)) {
            
            return;
        }

        try {
            JSONArray jsonArray = jsonObject.getJSONArray(objectArrayName);

            jsonArray.remove(_index);

            saveData();

        } catch (JSONException e) {

        }

    }
    
    // Method to save data to file. 

    private void saveData() {
        try {
            dataFile.delete();
            dataFile.createNewFile();

            FileWriter writer = new FileWriter(dataFile);
            writer.write(jsonObject.toString());
        } catch (IOException e) {
            System.out.println("IO Exception: " + e.getMessage());
        }
    }

}
