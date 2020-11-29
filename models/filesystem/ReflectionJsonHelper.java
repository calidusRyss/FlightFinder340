package main.java.models.filesystem;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * A helper class for converting objects to and from JSONObjects using reflection
 *
 * @author Teegan Krieger
 * @LastModified 11/22/2020
 */
public class ReflectionJsonHelper {

    private Class klass;

    public ReflectionJsonHelper(Class klass) {
        this.klass = klass;
    }

    /**
     * Convert an object of type T into a JSONObject
     *
     * @param obj The object to convert
     * @return A JSONObject
     */
    public JSONObject toJSON(Object obj) {

        //If obj is null, we return a null JSONObject
        if (obj == null) {
            return null;
        }

        JSONObject json = new JSONObject();

        //Get all fields
        Field[] f = getAllFields();

        //Encapsulate the for loop in a try catch to catch any reflection errors
        try {
            for (int i = 0; i < f.length; i++) {

                //Skip Static Fields
                if (Modifier.isStatic(f[i].getModifiers())) {
                    continue;
                }

                //Sets private fields to be accessible via reflection
                f[i].setAccessible(true);

                //Obtain the field's Type, Name and Value
                Class fieldType = f[i].getType();
                String fieldName = f[i].getName();
                Object fieldValue = f[i].get(obj);

                //We perform different actions depending on if the object is an Array, Non-Primitive or (Primitive or String)
                if (fieldType.isArray()) {

                    //Skip fields with null values
                    if (fieldValue == null) {
                        continue;
                    }

                    //Get the array's type. I.E. int[] would be of type int
                    Class arrayType = fieldType.getComponentType();

                    //Get array length
                    int arrayLength = Array.getLength(fieldValue);

                    //Create a new JSONArray
                    JSONArray jsonArr = new JSONArray();

                    //Two cases: Is the array type (primitive or string) or is it non-primitive
                    if (arrayType.isPrimitive() || arrayType.equals(String.class)) {

                        //If the array type was primitive or string, simply put the objects into the JSONArray
                        for (int j = 0; j < arrayLength; j++) {
                            jsonArr.put(Array.get(fieldValue, j));
                        }
                    } else {

                        //If the array type was non-primitive, convert each object in the array into a JSONObject, then put those JSONObjects into the JSONArray
                        for (int j = 0; j < arrayLength; j++) {
                            //Recursively call toJSON using new ReflectionJsonHelper instances of type ArrayType
                            ReflectionJsonHelper objReflect = new ReflectionJsonHelper(arrayType);

                            JSONObject jsonReflect = objReflect.toJSON(Array.get(fieldValue, j));

                            jsonArr.put(jsonReflect);
                        }
                    }

                    //Finally, put the JSONArray into the JSONObject
                    json.put(fieldName, jsonArr);

                } else if (fieldType.isPrimitive() || fieldType.equals(String.class)) {

                    //Simply put the field value into the JSONObject
                    json.put(fieldName, fieldValue);
                } else {

                    //Recursively call toJSON using new ReflectionJsonHelper instances of type FieldType
                    ReflectionJsonHelper objReflect = new ReflectionJsonHelper(fieldType);

                    JSONObject jsonReflect = objReflect.toJSON(fieldValue);

                    json.put(fieldName, jsonReflect);
                }
            }
        } catch (IllegalAccessException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        //Return the JSONObject we created
        return json;
    }

    /**
     * Convert a JSONObject into a new object of type T
     *
     * @param json The JSONObject to parse
     * @return A new object of type T
     */
    public Object fromJson(JSONObject json) {

        //Create a null instance of T
        Object newObj = null;

        //Try to instantiate a new instance of T
        try {
            newObj = klass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            System.out.println("Instantitation Error: " + e.getCause().getMessage());
        }

        //If the instantiation failed and was not caught, return null
        if (newObj == null) {
            return null;
        }

        //Get all fields
        Field[] f = getAllFields();

        //Encapsulate the for loop in a try catch to catch any reflection errors
        try {
            for (int i = 0; i < f.length; i++) {

                //Skip static fields
                if (Modifier.isStatic(f[i].getModifiers())) {
                    continue;
                }

                //Get the Field, Field Name and Field Type
                Field field = f[i];
                Class fieldType = field.getType();
                String fieldName = field.getName();

                //Skip Fields the JSONObject does not contain
                if (!json.has(fieldName)) {
                    continue;
                }

                //Make private Fields accessible to Reflection
                field.setAccessible(true);

                //We perform different actions depending on if the object is an Array, Non-Primitive or (Primitive or String)
                if (fieldType.isArray()) {

                    //Get the array's type. I.E. int[] would be of type int
                    Class arrayType = fieldType.getComponentType();

                    //Get the JSONArray using the Field's Name
                    JSONArray jsonArray = json.getJSONArray(fieldName);

                    //Create a new array of type ArrayType
                    Object newArray = Array.newInstance(arrayType, jsonArray.length());

                    //Two cases: Is the array type (primitive or string) or is it non-primitive
                    if (arrayType.isPrimitive() || arrayType.equals(String.class)) {

                        //If the array type was primitive or string, simply set the value at index j in newArray to the value from the JSONArray at index j
                        for (int j = 0; j < jsonArray.length(); j++) {
                            Object val = jsonArray.get(j);
                            Array.set(newArray, j, val);
                        }
                    } else {
                        for (int j = 0; j < jsonArray.length(); j++) {
                            //Recursively call fromJSON using new ReflectionJsonHelper instances of type ArrayType
                            ReflectionJsonHelper objReflect = new ReflectionJsonHelper(arrayType);

                            Object val = objReflect.fromJson(jsonArray.getJSONObject(j));

                            Array.set(newArray, j, val);
                        }
                    }

                    field.set(newObj, newArray);
                } else if (fieldType.isPrimitive() || fieldType.equals(String.class)) {
                    //Simply set the Field's Value to the value in the JSONObject
                    field.set(newObj, json.get(fieldName));
                } else {
                    //Recursively call fromJSON using new ReflectionJsonHelper instances of type FieldType
                    ReflectionJsonHelper objReflect = new ReflectionJsonHelper(fieldType);

                    field.set(newObj, objReflect.fromJson(json.getJSONObject(fieldName)));
                }

            }
        } catch (IllegalAccessException e) {
            System.out.println("Parsing Error!");
        }

        //Return the new object
        return newObj;
    }

    /**
     * Get all fields of the type T
     *
     * @return
     */
    private Field[] getAllFields() {
        return klass.getDeclaredFields();
    }

}
