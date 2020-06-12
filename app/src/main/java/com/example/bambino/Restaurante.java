package com.example.bambino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Restaurante extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurante);
    }

    public void launchNewActivity(View v) {
        Intent intent;

        // Determine what to do depending on the Button clicked
        if(v.getId() == R.id.bLocaliza) {
            // Explicit Intent to launch the ExplicitIntentActivity
            intent = new Intent(Restaurante.this, Localiza.class);
            startActivity(intent);
        }
        else{
            intent = new Intent(Restaurante.this, Carta.class);
            intent.putExtra("message", "Bambino's Valencia");
            startActivity(intent);
        }
    }
}
