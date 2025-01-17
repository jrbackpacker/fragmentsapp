package com.example.fragmentsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class AnimalDetailFragment extends Fragment {

    private static final String ARG_NAME = "name";
    private static final String ARG_IMAGE = "image";
    private static final String ARG_DESCRIPTION = "description";

    public static AnimalDetailFragment newInstance(String name, int imageRes, String description) {
        AnimalDetailFragment fragment = new AnimalDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, name);
        args.putInt(ARG_IMAGE, imageRes);
        args.putString(ARG_DESCRIPTION, description);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_animal_detail, container, false);

        ImageView imageView = view.findViewById(R.id.dogimage);
        TextView nameTextView = view.findViewById(R.id.animal_name);
        TextView descriptionTextView = view.findViewById(R.id.animal_description);

        if (getArguments() != null) {
            String name = getArguments().getString(ARG_NAME);
            int imageRes = getArguments().getInt(ARG_IMAGE);
            String description = getArguments().getString(ARG_DESCRIPTION);

            imageView.setImageResource(imageRes);
            nameTextView.setText(name);
            descriptionTextView.setText(description);
        }

        return view;
    }
}
