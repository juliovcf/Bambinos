package com.example.bambino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Restaurante extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurante);
        listView = (ListView) findViewById(R.id.lRestaurante);
        ArrayList<String> arrayList = new ArrayList<>();
        String titulo = "Restaurantes";

        /*arrayList.add("Entrantes");
        arrayList.add("Antipasti");
        arrayList.add("Pasta");
        arrayList.add("Pizzas");
        arrayList.add("Carnes");
        arrayList.add("Postres");
        arrayList.add("Bebidas");*/
        //arrayList.add("Pizzas");

        arrayList.add("Bambino's Valencia: Blasco Ibañez 121");
        arrayList.add("Bambino's Barcelona: Plaza España 12");
        arrayList.add("Bambino's Madrid: La Castellana 212");
        arrayList.add("Bambino's Sevilla: Plaza San Francisco 2");
        arrayList.add("Bambino's Castellón: CC La salera");
        arrayList.add("Bambino's Bilbao: Plaza Mayor 13");


        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                // Explicit Intent to launch the ExplicitIntentActivity
                intent = new Intent(Restaurante.this, Detalles.class);
                // Include the value of a String called "message" as parameter
                intent.putExtra("message", position);
                startActivity(intent);
            }
        });


    }

    public void launchNewActivity(View v) {
        Intent intent;

        // Determine what to do depending on the Button clicked
        switch (v.getId()) {
            // Nothing special, just launch the new activity
            case R.id.bLocaliza:
                // Explicit Intent to launch the ExplicitIntentActivity
                intent = new Intent(Restaurante.this, Localiza.class);
                startActivity(intent);
                break;
            // Pass a parameter within the Intent

        }
    }
}
