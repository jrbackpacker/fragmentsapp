package com.example.fragmentsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class CalculatorFragment extends Fragment {

    private TextView resultTextView;
    private String currentInput = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_calculator, container, false);

        resultTextView = view.findViewById(R.id.result_text);


        Button button1 = view.findViewById(R.id.button1);
        Button button2 = view.findViewById(R.id.button2);
        Button button3 = view.findViewById(R.id.button3);
        Button button4 = view.findViewById(R.id.button4);
        Button button5 = view.findViewById(R.id.button5);
        Button button6 = view.findViewById(R.id.button6);
        Button button7 = view.findViewById(R.id.button7);
        Button button8 = view.findViewById(R.id.button8);
        Button button9 = view.findViewById(R.id.button9);
        Button button0 = view.findViewById(R.id.button0);
        Button buttonAdd = view.findViewById(R.id.buttonAdd);
        Button buttonSubtract = view.findViewById(R.id.buttonSubtract);
        Button buttonMultiply = view.findViewById(R.id.buttonMultiply);
        Button buttonDivide = view.findViewById(R.id.buttonDivide);
        Button buttonEquals = view.findViewById(R.id.buttonEquals);


        button1.setOnClickListener(v -> appendNumber("1"));
        button2.setOnClickListener(v -> appendNumber("2"));
        button3.setOnClickListener(v -> appendNumber("3"));
        button4.setOnClickListener(v -> appendNumber("4"));
        button5.setOnClickListener(v -> appendNumber("5"));
        button6.setOnClickListener(v -> appendNumber("6"));
        button7.setOnClickListener(v -> appendNumber("7"));
        button8.setOnClickListener(v -> appendNumber("8"));
        button9.setOnClickListener(v -> appendNumber("9"));
        button0.setOnClickListener(v -> appendNumber("0"));
        buttonAdd.setOnClickListener(v -> appendOperator("+"));
        buttonSubtract.setOnClickListener(v -> appendOperator("-"));
        buttonMultiply.setOnClickListener(v -> appendOperator("*"));
        buttonDivide.setOnClickListener(v -> appendOperator("/"));
        buttonEquals.setOnClickListener(v -> calculateResult());

        return view;
    }



    private void appendNumber(String number) {
        currentInput += number;
        resultTextView.setText(currentInput);
    }

    private void appendOperator(String operator) {
        currentInput += " " + operator + " ";
        resultTextView.setText(currentInput);
    }

    private void clearInput() {
        currentInput = "";
        resultTextView.setText(currentInput);
    }

    private void calculateResult() {
        try {

            double result = evaluateExpression(currentInput);
            resultTextView.setText(String.valueOf(result));
            currentInput = String.valueOf(result);
        } catch (Exception e) {
            resultTextView.setText("Error");
        }
    }

    private double evaluateExpression(String expression) {

        String[] tokens = expression.split(" ");
        double num1 = Double.parseDouble(tokens[0]);
        String operator = tokens[1];
        double num2 = Double.parseDouble(tokens[2]);

        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    throw new ArithmeticException("Divide by zero");
                }
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }
}

