package com.davinci.coffeemaker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.davinci.coffeemaker.domain.entities.Coffee;

import java.util.ArrayList;

public class CoffeeListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_coffee_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ArrayList<Coffee> coffeeList = new ArrayList<Coffee>();

        coffeeList.add(
                new Coffee(
                        "Espresso",
                        "Café fuerte y concentrado.",
                        R.drawable.expresso,
                        3900.00F
                )
        );
        coffeeList.add(
                new Coffee(
                        "Café Americano",
                        "Café suave y ligero.",
                        R.drawable.expresso,
                        4500.00F
                )
        );

        for (Coffee coffee: coffeeList) {
            addCafeFragment(coffee);
        }
    }

    private void addCafeFragment(Coffee coffee) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Fragment fragment = CoffeeFragment.newInstance(coffee);
        fragmentTransaction.add(R.id.coffeeListContainer, fragment);
        fragmentTransaction.commit();
    }
}