package com.example.bambino;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class Localiza extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private Marker marker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localiza);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     * Longitud: -0.3773900
     * Latitud: 39.4697500
     *
     * Longitud: -3.7025600
     * Latitud: 40.4165000
     *
     *  Latitud: 41.3818
     *  Longitud: 2.1685
     *
     *  Latitud: 37.3914105
     *  Longitud: -5.9591776
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Valencia and move the camera
        LatLng valencia = new LatLng(39.4697500, -0.3773900);
        //mMap.addMarker(new MarkerOptions().position(valencia).title("Bambinos Valencia").snippet("Blasco Ibañez 121"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(valencia));

        LatLng madrid = new LatLng(40.4165000, -3.7025600);
        mMap.addMarker(new MarkerOptions().position(madrid).title("Bambinos Madrid").snippet("La Castellana 212 \n Tlf: 9876543"));

        LatLng barcelona = new LatLng(41.3818, 2.1685);
        mMap.addMarker(new MarkerOptions().position(barcelona).title("Bambinos Barcelona").snippet("Plaza España 21"));

        LatLng sevilla = new LatLng(37.3914105, -5.9591776);
        mMap.addMarker(new MarkerOptions().position(sevilla).title("Bambinos Sevilla").snippet("Plaza San Franciso 2"));

        marker = googleMap.addMarker(new MarkerOptions().position(valencia).title("Bambinos Valencia").snippet("Blasco Ibañez 121"));

        googleMap.setOnMarkerClickListener(this);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        Intent intent;
        if(marker.equals(marker)){
            intent = new Intent(Localiza.this, Carta.class);
            intent.putExtra("message", "Valencia");
            startActivity(intent);
        }
        return false;
    }
}