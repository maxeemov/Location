package com.example.max.location;

/**
 * Created by max on 9/4/17.
 * <p>
 * The method get path for file, convert Object to JSONObject and return JsonArray.
 */

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;


public class ReaderJson {

    private String path = null;
    JsonArray coords;


    ReaderJson(String path) {
        this.path = path;
    }

    public JsonArray reader() {
        JsonParser parser = new JsonParser();

        try {

            Object object = parser.parse(new FileReader(path));

            //convert Object to JSONObject
            JsonObject jsonObject = (JsonObject) object;

            //Reading the array
            coords = (JsonArray) jsonObject.get("coords");


        } catch (FileNotFoundException fe) {

            fe.printStackTrace();
        } catch (Exception e) {

            e.printStackTrace();
        }
        return coords;
    }
}
