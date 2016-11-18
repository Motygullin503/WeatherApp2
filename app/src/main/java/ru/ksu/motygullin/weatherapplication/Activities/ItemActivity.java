package ru.ksu.motygullin.weatherapplication.Activities;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

import ru.ksu.motygullin.weatherapplication.R;
import ru.ksu.motygullin.weatherapplication.WeatherAsyncTask;
import ru.ksu.motygullin.weatherapplication.resources.Weather;

public class ItemActivity extends AppCompatActivity implements WeatherAsyncTask {


    private TextView conditionTextView;
    private TextView temperatureTextView;
    private TextView locationTextView;
    private ProgressDialog dialog;
    static String default_city = "Kazan,RU";
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        conditionTextView = (TextView) findViewById(R.id.conditionTextView);
        temperatureTextView = (TextView) findViewById(R.id.temperatureTextView);
        locationTextView = (TextView) findViewById(R.id.locationTextView);
        progressBar= (ProgressBar) findViewById(R.id.progress_bar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public void onTaskStart() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onUpgrade(int i) {
        progressBar.setProgress(i);
    }

    @Override
    public void onFinish(ArrayList list) {
        progressBar.setVisibility(View.GONE);
        Weather weather = (Weather) list.get(0);

        locationTextView.setText(weather.location.getCity() + "," + weather.location.getCountry());
        conditionTextView.setText(weather.currentCondition.getDescription());
        temperatureTextView.setText((Math.round(weather.currentCondition.getTemp()-273.15) ) +"\u00B0"+ "C");
    }
}

