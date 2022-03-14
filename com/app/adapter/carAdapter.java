package com.app.adapter;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import com.app.R;
import com.app.beans.car;

public class carAdapter extends BaseAdapter {
    private List<car> cars;
    private LayoutInflater inflater;

    public carAdapter(Activity activity, List<car> cars) {
        this.cars = cars;
        this.inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return cars.size();
    }

    @Override
    public Object getItem(int position) {
        return cars.get(position);
    }

    @Override
    public long getItemId(int position) {
        return cars.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null)
            convertView = inflater.inflate(R.layout.item, null);

        TextView id = convertView.findViewById(R.id.id);
        TextView nom = convertView.findViewById(R.id.nom);
        TextView prix = convertView.findViewById(R.id.prix);
        ImageView image = convertView.findViewById(R.id.image);

        id.setText(cars.get(position).getId()+"");
        nom.setText(cars.get(position).getNom());
        prix.setText(cars.get(position).getPrix()+"");
        image.setImageResource(cars.get(position).getImage());


        return convertView;
    }
}

