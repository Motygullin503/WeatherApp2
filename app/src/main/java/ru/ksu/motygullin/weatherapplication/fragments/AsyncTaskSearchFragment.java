package ru.ksu.motygullin.weatherapplication.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import org.json.JSONException;

import java.util.ArrayList;

import ru.ksu.motygullin.weatherapplication.Model.JSONWeatherParserForSearch;
import ru.ksu.motygullin.weatherapplication.Model.WeatherHttpClient;
import ru.ksu.motygullin.weatherapplication.WeatherAsyncTask;

/**
 * Created by UseR7 on 13.11.2016.
 */

public class AsyncTaskSearchFragment extends Fragment {

    private WeatherAsyncTask taskInterface;
    private MyAsyncTask myAsyncTask;

    public boolean isRunning(){
        return myAsyncTask !=null;
    }

    @Override
    public void onAttach(Context context) {
        bind(context);
        super.onAttach(context);
    }

    @Override
    public void onAttach(Activity activity) {
        bind(activity);
        super.onAttach(activity);
    }

    public void startTask(){
        if(myAsyncTask ==null){
            myAsyncTask = new MyAsyncTask();
            myAsyncTask.execute();
        }
    }

    public void stopTask(){
        if(myAsyncTask != null){
            myAsyncTask.cancel(true);
            myAsyncTask = null;
        }
    }

    private void bind(Context context){
        if(context instanceof WeatherAsyncTask) {
            taskInterface = (WeatherAsyncTask) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        taskInterface = null;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    private class MyAsyncTask extends AsyncTask<String, Integer, ArrayList<String>> {
        @Override
        protected ArrayList doInBackground(String... params) {

            ArrayList weather = new ArrayList();
            String data = ((new WeatherHttpClient()).getSearchData(params[0]));

            try {
                weather = JSONWeatherParserForSearch.getWeather(data);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return weather;

        }

        @Override
        protected void onPostExecute(ArrayList weather) {
            myAsyncTask = null;
            if (taskInterface != null) {
                taskInterface.onFinish(weather);
            }

        }

        @Override
        protected void onPreExecute() {
            if (taskInterface != null) {
                taskInterface.onTaskStart();
            }
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            if (taskInterface != null) {
                taskInterface.onUpgrade(values[0]);
            }
        }

    }
}
