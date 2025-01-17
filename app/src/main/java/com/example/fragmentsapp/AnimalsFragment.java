package com.example.fragmentsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class AnimalsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_animals, container, false);

        // Botones para cada animal
        Button btnCat = view.findViewById(R.id.button_cat);
        Button btnDog = view.findViewById(R.id.button_dog);
        Button btnBird = view.findViewById(R.id.button_bird);
        Button btnFish = view.findViewById(R.id.button_fish);

        FrameLayout dynamicContainer = view.findViewById(R.id.dynamic_fragment_container);


        btnCat.setOnClickListener(v -> {
            updateDynamicContent(dynamicContainer, "Gato", R.drawable.gato,
                    "El gato es un animal doméstico popular, conocido por su independencia y curiosidad. Es ágil, con un excelente sentido de la vista y el oído, y tiene una personalidad generalmente tranquila.");
        });
        btnDog.setOnClickListener(v -> {
            updateDynamicContent(dynamicContainer, "Perro", R.drawable.perro,
                    "El perro es un animal domesticado leal y protector. Se considera el mejor amigo del hombre debido a su capacidad para establecer fuertes vínculos emocionales con los humanos y su naturaleza amigable.");
        });
        btnBird.setOnClickListener(v -> {
            updateDynamicContent(dynamicContainer, "Pájaro", R.drawable.pajaro, "Los pájaros son criaturas aladas con una gran diversidad de especies. Se encuentran en casi todos los hábitats del planeta, y algunos son conocidos por sus habilidades para cantar y su colorido plumaje.");
        });
        btnFish.setOnClickListener(v -> {
            updateDynamicContent(dynamicContainer, "Pez", R.drawable.pez, "Los peces son animales acuáticos que viven en el agua. Existen miles de especies, con una variedad impresionante de colores, formas y tamaños. Son esenciales para los ecosistemas acuáticos globales.");
        });

        return view;
    }


    private void updateDynamicContent(FrameLayout container, String animalName, int imageResId, String description) {

        container.removeAllViews();


        LayoutInflater inflater = LayoutInflater.from(getContext());
        View contentView = inflater.inflate(R.layout.fragment_animal_detail, container, false);


        ImageView animalImage = contentView.findViewById(R.id.dogimage);
        animalImage.setImageResource(imageResId);


        TextView animalNameTextView = contentView.findViewById(R.id.animal_name);
        animalNameTextView.setText(animalName);

        TextView animalDescriptionTextView = contentView.findViewById(R.id.animal_description);
        animalDescriptionTextView.setText(description);


        container.addView(contentView);


        container.setVisibility(View.VISIBLE);
    }
}
