package com.example.bambino;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

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
            case R.id.bReserva:
                // Explicit Intent to launch the ExplicitIntentActivity
                intent = new Intent(MainActivity.this, Restaurante.class);
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","julk.perezvcf@gmail.com", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Android APP - ");
                startActivity(Intent.createChooser(emailIntent, "Reserva realizada" ));
                startActivity(intent);
                break;
            // Pass a parameter within the Intent
            case R.id.bRestaurante:
                // Explicit Intent to launch the ExplicitIntentActivity
                intent = new Intent(MainActivity.this, Localiza.class);
                startActivity(intent);
                break;
            // Launch the new activity and wait for a result
            case R.id.bCarta:
                // Explicit Intent to launch the ForResultActivity
                intent = new Intent(MainActivity.this, Carta.class);
                // Include the value of a String called "message" as parameter
                intent.putExtra("message", "Reserva");
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
