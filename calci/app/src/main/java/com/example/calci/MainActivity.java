package com.example.calci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText txtVal;
    String opVal;
    Boolean isNewOperation=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVal=(EditText) findViewById(R.id.result);
        txtVal.setShowSoftInputOnFocus(false); //disables the keyboard
        txtVal.setSingleLine(false); //to wrap the expression on next line
    }

    public void numClick(View view)
    {
        if(isNewOperation) {
            isNewOperation = false;
            txtVal.setText("");
        }

        String value = txtVal.getText().toString();

        switch(view.getId()) {
            case R.id.btn_0:
                value += "0";
                break;

            case R.id.btn_1:
                value += "1";
                break;

            case R.id.btn_2:
                value += "2";
                break;

            case R.id.btn_3:
                value += "3";
                break;

            case R.id.btn_4:
                value += "4";
                break;

            case R.id.btn_5:
                value += "5";
                break;

            case R.id.btn_6:
                value += "6";
                break;

            case R.id.btn_7:
                value += "7";
                break;

            case R.id.btn_8:
                value += "8";
                break;

            case R.id.btn_9:
                value += "9";
                break;

            case R.id.btn_dot:
                value += ".";
                break;
        }
        txtVal.setText(value);
    }

    public void operatorClick(View view) {
        String value = txtVal.getText().toString();
        switch (view.getId()) {
            case R.id.btn_add:
                opVal = "+";
                value += "+";
                break;

            case R.id.btn_sub:
                opVal = "-";
                value += "-";
                break;

            case R.id.btn_div:
                opVal = "/";
                value += "/";
                break;

            case R.id.btn_mul:
                opVal = "*";
                value += "*";
                break;
        }
        txtVal.setText(value);
    }

    public void clearButton(View view) {
        txtVal.setText("");
    }

    public void equalsClick(View view) {
        String value = txtVal.getText().toString();
        double calculatedValue = 0.0;
        String[] separated;
        switch (opVal)
        {
            case "+":
                separated = value.split("\\+");
                calculatedValue = Double.parseDouble(separated[0]) + Double.parseDouble(separated[1]);
                break;

            case "-":
                separated = value.split("-");
                calculatedValue = Double.parseDouble(separated[0]) - Double.parseDouble(separated[1]);
                break;

            case "*":
                separated = value.split("\\*");
                calculatedValue = Double.parseDouble(separated[0]) * Double.parseDouble(separated[1]);
                break;

            case "/":
                separated = value.split("/");
                calculatedValue = Double.parseDouble(separated[0]) / Double.parseDouble(separated[1]);
                break;
        }
        String finalValue = String.format("%.2f",calculatedValue);
        txtVal.setText(value +"\n"+ finalValue);
        isNewOperation = true;
    }
}