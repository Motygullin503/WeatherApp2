package ru.ksu.motygullin.weatherapplication.Activities;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import ru.ksu.motygullin.weatherapplication.R;
import ru.ksu.motygullin.weatherapplication.WeatherAsyncTask;


public class LocationSelectActivity extends AppCompatActivity implements WeatherAsyncTask {
    private EditText et_city;
    private Button btn_search;
    private RecyclerView list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_select_activity);

        et_city = (EditText) findViewById(R.id.input);
        btn_search = (Button) findViewById(R.id.search);
        list = (RecyclerView) findViewById(R.id.listView);


    }


    @Override
    public void onTaskStart() {

    }

    @Override
    public void onUpgrade(int i) {

    }

    @Override
    public void onFinish(ArrayList s) {

    }
}

