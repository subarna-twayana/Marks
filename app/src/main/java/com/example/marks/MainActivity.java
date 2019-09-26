package com.example.marks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button butcon;
    EditText etname, etan, etiot, etweb;
    TextView tvresult;
    String status = "";
    int i = 1;
    DecimalFormat decimalFormat = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butcon = findViewById(R.id.butcon);
        etname = findViewById(R.id.txtName);
        etan = findViewById(R.id.amarks);
        etiot = findViewById(R.id.iot);
        etweb = findViewById(R.id.web);
        tvresult = findViewById(R.id.result);
        butcon.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.butcon) {
            double android = 0, iot = 0, web = 0;


            //if((android>=0)||(android<=100)&&((iot>=0)||(iot<=100)&&((web>=0)||(web<=100)))){
            if ((TextUtils.isEmpty(etname.getText().toString()))) {
                etname.setError("Please enter name");
                return;
            } else if (TextUtils.isEmpty(etan.getText().toString())) {
                etan.setError("Please Android marks");
                return;
            } else if (TextUtils.isEmpty(etiot.getText().toString())) {
                etiot.setError("Please enter IOT marks");
                return;
            } else if (TextUtils.isEmpty(etweb.getText().toString())) {
                etweb.setError("Please enter web API marks");
                return;
            } else {
                android = Double.parseDouble(etan.getText().toString());
                iot = Double.parseDouble(etiot.getText().toString());
                web = Double.parseDouble(etan.getText().toString());
            }
            if ((android <= 100) && (android >= 0)) {
                if ((iot <= 100) && (iot >= 0)) {
                    if ((web <= 100) && (web >= 0)) {
                        tvresult.append((i + ") " + " Name: " + etname.getText().toString()) +
                                " | Android: " + (decimalFormat.format(Double.parseDouble(etan.getText().toString()))) + // decimalFormat.format(Double.parseDouble(etname.getText().toString())))
                                " | IOT: " + (decimalFormat.format(Double.parseDouble(etiot.getText().toString()))) +
                                " | web: " + (decimalFormat.format(Double.parseDouble(etweb.getText().toString()))) +
                                " | percentage " + percentage() + " | " + status + "\n");
                        Clear();
                        i++;
                    } else {
                        etweb.setError("Please enter marks of WEB 0 to 100");
                    }

                } else {
                    etiot.setError("Please enter marks of IOT 0 to 100");

                }
            } else {
                etan.setError("Please enter marks of Android 0 to 100");

            }

        }
    }


    public String percentage() {

        double android = 0, iot = 0, web = 0, per = 0;
        android = Double.parseDouble(decimalFormat.format(Double.parseDouble(etan.getText().toString())));
        iot = Double.parseDouble(decimalFormat.format(Double.parseDouble(etiot.getText().toString())));
        web = Double.parseDouble(decimalFormat.format(Double.parseDouble(etweb.getText().toString())));


        per = (android + iot + web) / 3;
        if ((android >= 40) && (iot >= 40) && (web >= 40)) {
            status = "Pass";
        } else {
            status = "fail";
        }

        return decimalFormat.format(per);
    }

    public void Clear() {
        etname.setText("");
        etan.setText("");
        etiot.setText("");
        etweb.setText("");
    }
}