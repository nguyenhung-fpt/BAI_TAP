package com.example.myapplication.model;

public class Wheather {
    private String DateTime;
    private int WeatherIcon;
    private String IconPhrase;

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

    public int getWeatherIcon() {
        return WeatherIcon;
    }

    public void setWeatherIcon(int weatherIcon) {
        WeatherIcon = weatherIcon;
    }

    public String getIconPhrase() {
        return IconPhrase;
    }

    public void setIconPhrase(String iconPhrase) {
        IconPhrase = iconPhrase;
    }

    public com.example.myapplication.model.Temperature getTemperature() {
        return Temperature;
    }

    public void setTemperature(com.example.myapplication.model.Temperature temperature) {
        Temperature = temperature;
    }

    private Temperature Temperature;


}
