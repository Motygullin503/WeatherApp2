package ru.ksu.motygullin.weatherapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import ru.ksu.motygullin.weatherapplication.resources.Weather;

/**
 * Created by UseR7 on 18.11.2016.
 */
public class WeathersProvider {
    private static WeathersProvider ourInstance;
    private static final String WEATHER_PREFERENCES = "weather";
    private static final String CITY_NAME = "city";


    private Context context;

    public static WeathersProvider getInstance(@NonNull Context context) {
        if (ourInstance == null) {
            ourInstance = new WeathersProvider(context.getApplicationContext());
        }
        return ourInstance;
    }

    private WeathersProvider(@NonNull Context context) {
        this.context = context;
    }

    public void saveWeathers(List<Weather> weather){
        SharedPreferences preferences = context.getSharedPreferences(WEATHER_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Weather>>(){}.getType();
        String jsonText = gson.toJson(weather, listType);
        editor.putString(CITY_NAME, jsonText);
        editor.commit();
    }



    public List<Weather> getWeathersList(){
        SharedPreferences preferences = context.getSharedPreferences(WEATHER_PREFERENCES, Context.MODE_PRIVATE);
        if(preferences.contains(CITY_NAME)) {
            Gson gson = new Gson();
            String jsonText = preferences.getString(CITY_NAME, "");
            Type listType = new TypeToken<List<Weather>>(){}.getType();
            List<Weather> contacts = gson.fromJson(jsonText, listType);
            return contacts;
        } else {
            List<Weather> weathers = new java.util.ArrayList();

            saveWeathers(weathers);
            return weathers;
        }
    }
}
