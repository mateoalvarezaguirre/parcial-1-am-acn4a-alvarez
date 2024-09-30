package com.davinci.coffeemaker;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.davinci.coffeemaker.domain.entities.Coffee;


public class CoffeeFragment extends Fragment {
    private static final String ARG_NAME = "coffe_name";
    private static final String ARG_DESCRIPTION = "coffee_description";
    private static final String ARG_PRICE = "coffee_price";
    private static final String ARG_IMAGE = "coffee_image";

    public static CoffeeFragment newInstance(Coffee coffee) {
        CoffeeFragment fragment = new CoffeeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, coffee.getName());
        args.putString(ARG_DESCRIPTION, coffee.getDescription());
        args.putDouble(ARG_PRICE, coffee.getPrice());
        args.putInt(ARG_IMAGE, coffee.getImage());
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_coffee, container, false);

        Bundle args = getArguments();
        if (args != null) {
            String name = args.getString(ARG_NAME);
            String description = args.getString(ARG_DESCRIPTION);
            double price = args.getDouble(ARG_PRICE);
            int image = args.getInt(ARG_IMAGE);

            TextView textViewName = view.findViewById(R.id.coffeeName);
            TextView textViewDescription = view.findViewById(R.id.coffeeDescription);
            TextView textViewPrice = view.findViewById(R.id.coffeePrice);
            ImageView imageViewImage = view.findViewById(R.id.coffeeImage);

            textViewName.setText(name);
            textViewDescription.setText(description);
            textViewPrice.setText(String.format("$%.2f", price));
            imageViewImage.setImageResource(image);
        }

        return view;
    }
}