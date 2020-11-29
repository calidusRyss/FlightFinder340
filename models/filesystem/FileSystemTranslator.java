package main.java.models.filesystem;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import main.java.models.interfaces.IDataStore;

/**
 * Translator for performing CRUD operations on the local FileSystem
 *
 * @author Teegan Krieger & Willie Holmes
 */
public class FileSystemTranslator implements IDataStore {

    private static final String appdataPath = System.getenv("APPDATA") + "\\FlightFinder340";
    private static final String appdataFilePath = System.getenv("APPDATA") + "\\FlightFinder340\\Data.dat";
    private static final String arrayMagicWord = "Array";

    private File dataFile;
    private JSONObject jsonObject;

    public FileSystemTranslator() throws JSONException {

        try {
            Path directory = Paths.get(appdataPath);

            if (!Files.exists(directory)) {
                Files.createDirectory(directory);
            }

            Path file = Paths.get(appdataFilePath);

            if (!Files.exists(file)) {
                Files.createFile(file);

                dataFile = new File(appdataFilePath);

                FileWriter writer = new FileWriter(dataFile);
                writer.write("{}");
                writer.close();
            }

            dataFile = new File(appdataFilePath);

            FileReader reader = new FileReader(dataFile);
            char[] characters = new char[(int) dataFile.length()];
            reader.read(characters);

            reader.close();

            try {
                jsonObject = new JSONObject(new String(characters));
            } catch (JSONException e) {
                jsonObject = new JSONObject();
            }

        } catch (IOException e) {
        }

    }

    @Override
    /*
  *   Creates the objects to insert into the file.
     */

    /**
     * Creates and inserts a new entry into the DataStore
     *
     * @param _obj The object to insert into the DataStore
     */
    public <T> int create(T _obj) {

        Class klass = _obj.getClass();

        String objectArrayName = klass.getName() + arrayMagicWord;

        ReflectionJsonHelper helper = new ReflectionJsonHelper(klass);
        JSONObject localObj = helper.toJSON((Object) _obj);

        if (!jsonObject.has(objectArrayName)) {
            jsonObject.put(objectArrayName, new JSONArray());
        }

        JSONArray arr = jsonObject.getJSONArray(objectArrayName);

        arr.put(localObj);

        saveData();

        return arr.length();
    }

    /**
     * Loads all objects of a specified type from the DataStore
     *
     * @param _klass The class object of the type to delete. (Needed to work around a java generics limitation)
     */
    @Override
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

    /**
     * Update a specific object within the DataStore
     *
     * @param _obj The object to replace the old object with
     * @param _index The index of the object to replace
     * @param _save Should the DataStore save after updating this object
     */
    @Override
    public <T extends Object> void update(T _obj, int _index, boolean _save) {

        Class klass = _obj.getClass();

        ReflectionJsonHelper helper = new ReflectionJsonHelper(klass);

        String objectArrayName = klass.getName() + arrayMagicWord;

        if (!jsonObject.has(objectArrayName)) {

            return;
        }

        try {
            JSONArray jsonArray = jsonObject.getJSONArray(objectArrayName);

            jsonArray.put(_index, helper.toJSON(_obj));

            if (_save) {
                saveData();
            }

        } catch (JSONException e) {
            System.out.println("Error Occured during Update: " + e.getMessage());
        }
    }

    /**
     * Delete an entry from the DataStore
     *
     * @param _index The index of the item to delete
     * @param _klass The class object of the type to delete. (Needed to work around a java generics limitation)
     */
    @Override
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

    /**
     * Saves the instance of jsonObject to a file
     */
    private void saveData() {
        try {
            dataFile.delete();
            dataFile.createNewFile();

            FileWriter writer = new FileWriter(dataFile);
            writer.write(jsonObject.toString());
            writer.close();

        } catch (IOException e) {
            System.out.println("IO Exception: " + e.getMessage());
        }
    }

}
