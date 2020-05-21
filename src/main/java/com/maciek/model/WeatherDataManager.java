package com.maciek.model;


import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.HashMap;

public class WeatherDataManager {

    private static String apiKey = "fb39b81cd3a7ca7c9c2938c1e8a19e6d"; //CZY TO MA BYC STALA ALBO PRIVATE?
    private Object HashMap;

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

    public HashMap getWeatherToday(String miasto) throws IOException {

        HashMap<String, String> weatherConditions = new HashMap<String, String>();
        String jsonString = getJsonStringWeather(miasto);
        JSONObject obiekt = new JSONObject(jsonString);
        JSONArray lineItems = obiekt.getJSONArray("weather");

        String temperature = String.valueOf(obiekt.getJSONObject("main").getInt("temp"));
        String feelslike = String.valueOf(obiekt.getJSONObject("main").getInt("feels_like"));
        String min = String.valueOf(obiekt.getJSONObject("main").getInt("temp_min"));
        String max = String.valueOf(obiekt.getJSONObject("main").getInt("temp_max"));
        String pressure = String.valueOf(obiekt.getJSONObject("main").getInt("pressure"));
        String humidity = String.valueOf(obiekt.getJSONObject("main").getInt("humidity"));

        String icon = null;
        String description = null;
        for (Object o : lineItems) {
            JSONObject jsonLineItem = (JSONObject) o;
            description = jsonLineItem.getString("description");
            icon = jsonLineItem.getString("icon");
        }

        weatherConditions.put("icon", icon);
        weatherConditions.put("temperature", temperature);
        weatherConditions.put("description", description);
        weatherConditions.put("feelslike", feelslike);
        weatherConditions.put("min", min);
        weatherConditions.put("max", max);
        weatherConditions.put("humidity", humidity);
        weatherConditions.put("pressure", pressure);

        System.out.println(weatherConditions);
        return weatherConditions;
    }

    public void getForecast(String miasto) throws IOException {
        HashMap<String, String> weatherForecast = new HashMap<>();

        String jsonString = getJsonStringForecast(miasto);

        return;



    }
}
