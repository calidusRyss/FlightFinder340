/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.models.filesystem;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.CharBuffer;
import main.java.models.interfaces.IFileSystem;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author teega
 */
public class FileSystemTranslator implements IFileSystem {

    private static final String appdataPath = System.getenv("APPDATA") + "/Roaming/FlightFinder340";
    private static final String arrayMagicWord = "Array";

    private File dataFile = new File(appdataPath);
    private JSONObject jsonObject;

    public FileSystemTranslator() {
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
    public <T> T[] load(Class<T> _klass) {

        ReflectionJsonHelper helper = new ReflectionJsonHelper(_klass);

        String objectArrayName = _klass.getName() + arrayMagicWord;


    }

    @Override
    public <T extends Object> void update(T _obj, int _index) {

        Class klass = _obj.getClass();

        ReflectionJsonHelper helper = new ReflectionJsonHelper(klass);

        String objectArrayName = klass.getName() + arrayMagicWord;

    }

    @Override
    public <T extends Object> void delete(int _index, Class<T> _klass) {

        ReflectionJsonHelper helper = new ReflectionJsonHelper(_klass);

        String objectArrayName = _klass.getName() + arrayMagicWord;

    }

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
