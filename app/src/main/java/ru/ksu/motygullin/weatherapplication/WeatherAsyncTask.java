package ru.ksu.motygullin.weatherapplication;

import java.util.ArrayList;

/**
 * Created by UseR7 on 13.11.2016.
 */

public interface WeatherAsyncTask {
    void onTaskStart();
    void onUpgrade(int i);
    void onFinish(ArrayList s);
}
