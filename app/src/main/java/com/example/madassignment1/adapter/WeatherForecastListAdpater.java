package com.example.madassignment1.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.madassignment1.R;
import com.kwabenaberko.openweathermaplib.model.threehourforecast.ThreeHourForecastWeather;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

public class WeatherForecastListAdpater extends RecyclerView.Adapter<WeatherForecastListAdpater.WeatherForecastViewHolder> {

    private Context mContext;
    private ArrayList<ThreeHourForecastWeather> weatherModelArrayList;

    public WeatherForecastListAdpater(Context mContext, ArrayList<ThreeHourForecastWeather> weatherModelArrayList) {
        this.mContext = mContext;
        this.weatherModelArrayList = weatherModelArrayList;
    }

    @NonNull
    @Override
    public WeatherForecastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.custom_layout, parent, false);
        return new WeatherForecastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherForecastViewHolder holder, int position) {
        ThreeHourForecastWeather model = weatherModelArrayList.get(position);
        holder.dateTxt.setText(UnixTime(model.getDt()));
        for (int i = 0; i < model.getWeather().size(); i++) {
            holder.descrptionTxt.setText(model.getWeather().get(i).getDescription());
        }
        if (holder.descrptionTxt.getText().toString().contains("sky"))
            holder.imageView.setImageResource(R.drawable.clearsky);
        if (holder.descrptionTxt.getText().toString().contains("clouds"))
            holder.imageView.setImageResource(R.drawable.clouds);
        if (holder.descrptionTxt.getText().toString().contains("rain"))
            holder.imageView.setImageResource(R.drawable.rain);

//        holder.humidityTxt.setText(String.valueOf(model.getMain().getHumidity()));
        holder.tempTxt.setText(String.valueOf(model.getMain().getTemp()));
//        holder.pressureTxt.setText(String.valueOf(model.getMain().getPressure()));
//        holder.windTxt.setText(String.valueOf(model.getWind().getSpeed()));
//        holder.cloudTxt.setText(String.valueOf(model.getClouds().getAll()));
//        holder.feelsTxt.setText(String.valueOf(model.getMain().getTempMax()));
    }

    @Override
    public int getItemCount() {
        return weatherModelArrayList.size();
    }

    private String UnixTime(long timex) {

        Date date = new Date(timex * 1000L);
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        return sdf.format(date);
    }

    public class WeatherForecastViewHolder extends RecyclerView.ViewHolder {

        private TextView dateTxt,
                descrptionTxt,
        /*humidityTxt, feelsTxt, cloudTxt, windTxt, pressureTxt, */
        tempTxt;
        private ImageView imageView;

        public WeatherForecastViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageVieww);
            dateTxt = itemView.findViewById(R.id.date);
            descrptionTxt = itemView.findViewById(R.id.description);
//            humidityTxt = itemView.findViewById(R.id.humidity);
//            feelsTxt = itemView.findViewById(R.id.feels);
//            cloudTxt = itemView.findViewById(R.id.clouds);
//            windTxt = itemView.findViewById(R.id.wind);
//            pressureTxt = itemView.findViewById(R.id.pressure);
            tempTxt = itemView.findViewById(R.id.temp);
        }
    }
}
