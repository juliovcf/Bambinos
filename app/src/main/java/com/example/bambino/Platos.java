package com.example.bambino;

import android.os.Bundle;
import android.util.Log;
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

    private RecyclerView pList;
    private PlatosApadter platosApadter;
    private List<Plato> lPlatos;
    private String coleccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_platos);

        lPlatos = new ArrayList<>();
        platosApadter = new PlatosApadter(lPlatos);


        pList = (RecyclerView) findViewById(R.id.pList);
        pList.setHasFixedSize(true);
        pList.setLayoutManager(new LinearLayoutManager(this));
        pList.setAdapter(platosApadter);
        FirebaseFirestore.getInstance().collection(coleccion).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
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
        });


    }
}


//Log.d("Pizzas", document.getId() + " => " + document.getData());