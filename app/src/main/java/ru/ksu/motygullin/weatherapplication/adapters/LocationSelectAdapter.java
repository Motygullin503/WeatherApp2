package ru.ksu.motygullin.weatherapplication.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ru.ksu.motygullin.weatherapplication.R;
import ru.ksu.motygullin.weatherapplication.resources.Weather;

/**
 * Created by UseR7 on 11.11.2016.
 */

public class LocationSelectAdapter extends RecyclerView.Adapter<ItemsViewHolder>{

    private List<Weather> weather;

    @Override
    public ItemsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ItemsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemsViewHolder holder, int position) {
        holder.bind(weather.get(position));
    }

    @Override
    public int getItemCount() {
        try {
            return weather.size();
        } catch (NullPointerException e) {
            return 0;
        }
    }
}
