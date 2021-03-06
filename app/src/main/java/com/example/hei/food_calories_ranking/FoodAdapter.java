package com.example.hei.food_calories_ranking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FoodAdapter extends ArrayAdapter<Food> {
    public FoodAdapter(Context context, ArrayList<Food> foods) {
        super(context, 0, foods);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Food currentFood = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.main_list_item, parent, false);
        }

        // Lookup view for data population
        ViewHolder holder = new ViewHolder();
        holder.foodName = (TextView) convertView.findViewById(R.id.food_name);
        holder.foodBrand = (TextView) convertView.findViewById(R.id.food_brand);
        holder.foodCalories = (TextView) convertView.findViewById(R.id.food_calories);
        holder.foodPrice = (TextView) convertView.findViewById(R.id.food_price);
        holder.vegRating = (ImageView) convertView.findViewById(R.id.veg_rating);
        holder.imageView = (ImageView) convertView.findViewById(R.id.food_image);
        convertView.setTag(holder);

        // Populate the data into the template view using the data object
        holder.foodName.setText (currentFood.getFoodName());
        holder.foodBrand.setText (currentFood.getFoodBrand());
        holder.foodCalories.setText (String.valueOf(currentFood.getFoodCalories()));
        holder.foodPrice.setText (String.valueOf(currentFood.getFoodPrice()));
        holder.vegRating.setImageResource(currentFood.getRatingResId());
        holder.imageView.setImageResource(currentFood.getImageViewId());

        // Return the completed view to render on screen
        return convertView;
    }
}
