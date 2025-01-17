package com.example.fragmentsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class ResultFragment extends Fragment {

    private static final String ARG_RESULT = "result";

    public static ResultFragment newInstance(int result) {
        ResultFragment fragment = new ResultFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_RESULT, result);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);
        TextView resultText = view.findViewById(R.id.result_text);

        if (getArguments() != null) {
            int result = getArguments().getInt(ARG_RESULT);
            String formattedResult = getString(R.string.result_text, result);
            resultText.setText(formattedResult);
        }
        return view;
    }
}