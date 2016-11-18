package ru.ksu.motygullin.weatherapplication.Model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by UseR7 on 11.11.2016.
 */

public class JSONWeatherParserForSearch {

    public static ArrayList getWeather(String data) throws JSONException {


        ArrayList arrayList = new ArrayList();

        // Creating JSONObject from the data
        JSONObject jObj = new JSONObject(data);
        JSONArray list = jObj.getJSONArray("list");

        for(int i = 0; i<list.length(); i++){
            JSONObject jsonObject = list.getJSONObject(i);
            arrayList.add(jsonObject.getString("id"));
        }


       return arrayList;
    }


    private static JSONObject getObject(String tagName, JSONObject jObj)  throws JSONException {
        return jObj.getJSONObject(tagName);

    }

    private static String getString(String tagName, JSONObject jObj) throws JSONException {
        return jObj.getString(tagName);
    }

    private static float  getFloat(String tagName, JSONObject jObj) throws JSONException {
        return (float) jObj.getDouble(tagName);
    }


    private static int  getInt(String tagName, JSONObject jObj) throws JSONException {
        return jObj.getInt(tagName);
    }


}
