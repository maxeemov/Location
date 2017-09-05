package com.example.max.location;

/**
 * Created by max on 9/4/17.
 */
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;


public class ReaderJson {

  private String path = null;


    ReaderJson(String path){
       this.path=path;

    }

        public void reader()
        {
            JsonParser parser = new JsonParser();
            try
            {

                Object object = parser.parse(new FileReader(path));

                //convert Object to JSONObject
                JsonObject jsonObject = (JsonObject)object;


                //Reading the array
                JsonArray countries = (JsonArray)jsonObject.get("coords");


                for(JsonElement count : countries)
                {
                    System.out.println("\t"+count.getAsJsonObject().get("la"));
                    System.out.println("\t"+count.getAsJsonObject().get("lo"));
                }
            }
            catch(FileNotFoundException fe)
            {

                fe.printStackTrace();
            }
            catch(Exception e)
            {

                e.printStackTrace();
            }
        }
    }
