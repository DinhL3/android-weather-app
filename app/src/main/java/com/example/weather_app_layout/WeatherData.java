package com.example.weather_app_layout;

public class WeatherData {
    private String date;
    private Short temperature;
    private String weather;


    public WeatherData(String date, Short temperature, String weather) {
        this.date = date;
        this.temperature = temperature;
        this.weather = weather;
    }

    public String getDate() {
        return date;
    }

    public Short getTemperature() {
        return temperature;
    }

    public String getWeather() {
        return weather;
    }
}
