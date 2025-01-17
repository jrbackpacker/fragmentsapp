package com.example.fragmentsapp;

import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button menuCalculator = findViewById(R.id.menu_calculator);
        Button menuAnimals = findViewById(R.id.menu_animals);

        menuCalculator.setOnClickListener(v -> replaceFragment(new CalculatorFragment()));
        menuAnimals.setOnClickListener(v -> replaceFragment(new AnimalsFragment()));
    }

    // Método para reemplazar el fragmento
    public void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
