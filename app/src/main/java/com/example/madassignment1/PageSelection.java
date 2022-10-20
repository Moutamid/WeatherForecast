package com.example.madassignment1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PageSelection extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_selection);

        // PROCEED FROM THE LANDING PAGE
        Intent navToMenu = getIntent();

        // RECEIVE INFORMATION FROM THE LANDING PAGE
        String location = navToMenu.getStringExtra("location");

        // BUTTON FINDERS
        Button navToWarnings = findViewById(R.id.button);
        Button navToGoogleMap = findViewById(R.id.button2);

        navToWarnings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent navToWarn = new Intent(PageSelection.this, WeatherWarning.class);
                startActivity(navToWarn);
            }
        });

        // TO PROCEED TO THE PAGE SELECTION PAGE
        navToGoogleMap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent navToGoogleMap = new Intent(PageSelection.this, GoogleMap.class);

                // PASS IN INFO TO PASS TO THE NEXT PAGE
                navToGoogleMap.putExtra("realTimeLocation", location);
                startActivity(navToGoogleMap);
            }
        });

        findViewById(R.id.button7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PageSelection.this, HomeActivity.class));
            }
        });

    }
}