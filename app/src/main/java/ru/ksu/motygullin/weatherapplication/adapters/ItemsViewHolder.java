package ru.ksu.motygullin.weatherapplication.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import ru.ksu.motygullin.weatherapplication.R;
import ru.ksu.motygullin.weatherapplication.resources.Weather;

/**
 * Created by UseR7 on 11.11.2016.
 */
public class ItemsViewHolder extends RecyclerView.ViewHolder {

    TextView city;

    public ItemsViewHolder(View itemView) {
        super(itemView);

        city = (TextView) itemView.findViewById(R.id.city_name);
    }

    public void bind(Weather weather){
        city.setText(weather.location.getCity());
    }
}
