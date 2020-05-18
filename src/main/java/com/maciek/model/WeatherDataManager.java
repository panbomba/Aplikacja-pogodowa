package com.maciek.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

public class WeatherDataManager {

    private static String apiKey = "fb39b81cd3a7ca7c9c2938c1e8a19e6d"; //CZY TO MA BYC STALA ALBO PRIVATE?

    public static String getJsonStringWeather(String miasto) throws IOException {

        String adresURLweather =
                "http://api.openweathermap.org/data/2.5/weather?q=" + miasto + "&lang=pl" + "&units=metric" +
                        "&APPID=" + apiKey;
        URL url = new URL(adresURLweather);
        URLConnection urlConnection = url.openConnection();
        urlConnection.connect();

        BufferedReader json = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String weatherString = json.readLine();
        System.out.println(weatherString);
        System.out.println(adresURLweather);
        return weatherString;
    }

    public static String getJsonStringForecast(String miasto) throws IOException {

        String adresURLforecast =
                "http://api.openweathermap.org/data/2.5/forecast?q=" + miasto + "&lang=pl" + "&units=metric" +
                        "&APPID=" + apiKey;
        URL url = new URL(adresURLforecast);
        URLConnection urlConnection = url.openConnection();
        urlConnection.connect();

        BufferedReader json = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String forecastString = json.readLine();
        System.out.println(forecastString);
        System.out.println(adresURLforecast);
        return forecastString;
    }

    public String getTimeStamp(){
        String timeStamp = new SimpleDateFormat("HH:mm").format(new java.util.Date());
        System.out.println(timeStamp);
        return timeStamp;
    }
}
