package com.example.bambino;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
//import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Platos extends AppCompatActivity {

    private ListView lPlatos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_platos);

        String titulo = "Platos";
        setTitle(titulo);

        lPlatos = findViewById(R.id.lPlatos);
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("Entrantes");
        arrayList.add("Antipasti");
        arrayList.add("Pasta");
        arrayList.add("Pizzas");
        arrayList.add("Carnes");
        arrayList.add("Postres");
        arrayList.add("Bebidas");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
        lPlatos.setAdapter(arrayAdapter);

        lPlatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                // Explicit Intent to launch the ExplicitIntentActivity
                intent = new Intent(Platos.this, Comanda.class);
                // Include the value of a String called "message" as parameter
                intent.putExtra("message", position);
                startActivity(intent);
            }
        });

    }
}


        /*lPlatos = new ArrayList<>();
        platosApadter = new PlatosApadter(lPlatos);


        pList = (RecyclerView) findViewById(R.id.pList);
        pList.setHasFixedSize(true);
        pList.setLayoutManager(new LinearLayoutManager(this));
        pList.setAdapter(platosApadter);
        FirebaseFirestore.getInstance().collection("Pizzas").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {

                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        Plato plato = document.toObject(Plato.class);
                        lPlatos.add(plato);
                        platosApadter.notifyDataSetChanged();
                    }
                    pList = findViewById(R.id.pList);
                    pList.setAdapter(platosApadter);
                } else {
                    Log.w("Error", "Error getting documents.", task.getException());
                }
            }
        });*/
