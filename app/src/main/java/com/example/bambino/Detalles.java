package com.example.bambino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class Detalles extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        List<String> spinnerArray = new ArrayList<String>();
        spinnerArray.add("13:30");
        spinnerArray.add("14:00");
        spinnerArray.add("14:30");
        spinnerArray.add("15:00");
        spinnerArray.add("20:30");
        spinnerArray.add("21:00");
        spinnerArray.add("21:30");
        spinnerArray.add("22:00");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = (Spinner) findViewById(R.id.spinner);
        sItems.setAdapter(adapter);
    }

    public void launchNewActivity(View v) {
        Intent intent;

        // Determine what to do depending on the Button clicked
        switch (v.getId()) {
            // Nothing special, just launch the new activity
            case R.id.bHecho:
                // Explicit Intent to launch the ExplicitIntentActivity
                intent = new Intent(Detalles.this, Carta.class);
                startActivity(intent);
                break;

        }
    }
}