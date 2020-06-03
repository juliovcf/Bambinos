package com.example.bambino;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bambino.R;

//import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchNewActivity(View v) {
        Intent intent;

        // Determine what to do depending on the Button clicked
        switch (v.getId()) {
            // Nothing special, just launch the new activity
            case R.id.bCarta:
                // Explicit Intent to launch the ExplicitIntentActivity
                intent = new Intent(MainActivity.this, Carta.class);
                startActivity(intent);
                break;
            // Pass a parameter within the Intent
            case R.id.bRestaurante:
                // Explicit Intent to launch the ExplicitIntentActivity
                intent = new Intent(MainActivity.this, Restaurante.class);
                startActivity(intent);
                break;
            // Launch the new activity and wait for a result
            case R.id.bReserva:
                // Explicit Intent to launch the ForResultActivity
                intent = new Intent(MainActivity.this, Restaurante.class);
                // Include the value of a String called "message" as parameter
                intent.putExtra("message", "Reserva");
                startActivity(intent);
                break;
            case R.id.bDescuentos:
                // Explicit Intent to launch the ForResultActivity
                intent = new Intent(MainActivity.this, Descuentos.class);
                startActivity(intent);
                break;
            case R.id.bAuth:
                // Explicit Intent to launch the ExplicitIntentActivity
                intent = new Intent(MainActivity.this, Authentication.class);
                startActivity(intent);
                break;

        }
    }
}
