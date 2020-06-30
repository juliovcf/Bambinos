package com.example.bambino;

import android.content.Intent;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Carta extends AppCompatActivity {

    ListView listView;
    BottomNavigationItemView item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carta);

        listView = (ListView) findViewById(R.id.lCarta);
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("Entrantes");
        arrayList.add("Antipasti");
        arrayList.add("Pasta");
        arrayList.add("Pizzas");
        arrayList.add("Carnes");
        arrayList.add("Postres");
        arrayList.add("Bebidas");
        //arrayList.add("Pizzas");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                // Explicit Intent to launch the ExplicitIntentActivity
                intent = new Intent(Carta.this, Platos.class);
                // Include the value of a String called "message" as parameter
                intent.putExtra("message", position);
                startActivity(intent);
            }
        });
    }

    /*BottomNavigationView.OnNavigationItemSelectedListener{
        item -> when(item.){
            R.id.bottom_navigation
        }
    }*/
}
