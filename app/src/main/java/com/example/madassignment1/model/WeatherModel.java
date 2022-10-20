package com.example.madassignment1.model;

public class WeatherModel {

    private double temp;
    private long dt;
    private double feelsLike;
    private float pressure;
    private String countryName;
    private String cityName;
    private String clouds;
    private String wind;
    private int humidity;
    private String description;

    public WeatherModel() {

    }

    public WeatherModel(long dt, double temp, double feelsLike, float pressure, String clouds, String wind, int humidity, String description) {
        this.dt = dt;
        this.temp = temp;
        this.feelsLike = feelsLike;
        this.pressure = pressure;
        this.countryName = countryName;
        this.cityName = cityName;
        this.clouds = clouds;
        this.wind = wind;
        this.humidity = humidity;
        this.description = description;
    }

    public WeatherModel(long dt) {
        this.dt = dt;
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(double feelsLike) {
        this.feelsLike = feelsLike;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getClouds() {
        return clouds;
    }

    public void setClouds(String clouds) {
        this.clouds = clouds;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }
}
