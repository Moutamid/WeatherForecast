package com.example.madassignment1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.madassignment1.adapter.WeatherForecastListAdpater;
import com.kwabenaberko.openweathermaplib.implementation.OpenWeatherMapHelper;
import com.kwabenaberko.openweathermaplib.implementation.callback.ThreeHourForecastCallback;
import com.kwabenaberko.openweathermaplib.model.threehourforecast.ThreeHourForecast;
import com.kwabenaberko.openweathermaplib.model.threehourforecast.ThreeHourForecastWeather;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager manager;
    private ArrayList<ThreeHourForecastWeather> weatherModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        manager = new LinearLayoutManager(HomeActivity.this);
        manager.setOrientation(RecyclerView.VERTICAL);
        LinearLayoutManager horizontalLinearLayout = new LinearLayoutManager(HomeActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLinearLayout);
//        recyclerView.setLayoutManager(manager);
        weatherModelArrayList = new ArrayList<>();
        OpenWeatherMapHelper helper = new OpenWeatherMapHelper(getString(R.string.OPEN_WEATHER_MAP_API_KEY));
        // getWeatherDetails();
        helper.setUnits("metric");
        helper.getThreeHourForecastByCityName("Buena Vista", new ThreeHourForecastCallback() {
            @Override
            public void onSuccess(ThreeHourForecast threeHourForecast) {

                for (int i = 0; i < 5; i++) {
                    weatherModelArrayList.add(threeHourForecast.getList().get(i));
                }

                WeatherForecastListAdpater adpater = new WeatherForecastListAdpater(HomeActivity.this, weatherModelArrayList);
                recyclerView.setAdapter(adpater);
                adpater.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Throwable throwable) {
                //  Log.v(TAG, throwable.getMessage());
            }
        });
    }

}