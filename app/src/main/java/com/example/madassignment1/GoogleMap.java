package com.example.madassignment1;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
//import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.madassignment1.databinding.ActivityGooglemapBinding;

public class GoogleMap extends FragmentActivity implements OnMapReadyCallback {

    private com.google.android.gms.maps.GoogleMap mMap;
    private ActivityGooglemapBinding binding;
    private Object view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityGooglemapBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // PROCEED FROM THE PAGE SELECTION PAGE
        Intent navToGoogleMap = getIntent();

        // RECEIVE INFORMATION FROM THE PAGE SELECTION PAGE
        String location = navToGoogleMap.getStringExtra("realTimeLocation");

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(com.google.android.gms.maps.GoogleMap googleMap) {
        mMap = googleMap;

        // ADD A MARKER AT SINGAPORE
        LatLng singapore = new LatLng(1.290270, 103.851959);
        mMap.addMarker(new MarkerOptions().position(singapore).title("Singapore"));

        // MOVE THE CAMERA TO SINGAPORE
        mMap.moveCamera(CameraUpdateFactory.newLatLng(singapore));
    }
}