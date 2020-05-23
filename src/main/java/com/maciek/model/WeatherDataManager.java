package com.maciek.model;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.TimeZone;

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

    public long getUnixTimeForTomorrow() {
        Calendar c = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        long unixTimeStamp = c.getTimeInMillis() / 1000;
        unixTimeStamp += 129600;
        System.out.println(unixTimeStamp);
        return unixTimeStamp;
    }

    public HashMap getForecastMap (String miasto) throws IOException {
        HashMap<String, ArrayList<String>> weatherForecastMap = new HashMap();
        long uniXTimeAtNoon = (Long) getUnixTimeForTomorrow();
        long unixTimeAtNoonDay2 = uniXTimeAtNoon + 86400;
        long unixTimeAtNoonDay3 = unixTimeAtNoonDay2 + 86400;
        long unixTimeAtNoonDay4 = unixTimeAtNoonDay3 + 86400;
        long unixTimeAtNoonDay5 = unixTimeAtNoonDay4 + 86400;

        String timeDay1 = String.valueOf(uniXTimeAtNoon);
        String timeDay1End = String.valueOf(uniXTimeAtNoon + 10800);
        String timeDay2 = String.valueOf(unixTimeAtNoonDay2);
        String timeDay2End = String.valueOf(unixTimeAtNoonDay2 + 10800);
        String timeDay3 = String.valueOf(unixTimeAtNoonDay3);
        String timeDay3End = String.valueOf(unixTimeAtNoonDay3 + 10800);
        String timeDay4 = String.valueOf(unixTimeAtNoonDay4);
        String timeDay4End = String.valueOf(unixTimeAtNoonDay4 + 10800);
        String timeDay5 = String.valueOf(unixTimeAtNoonDay5);
        String timeDay5End = String.valueOf(unixTimeAtNoonDay5 + 10800);

        String jsonString = getJsonStringForecast(miasto);
        JSONObject obiekt = new JSONObject(jsonString);
        JSONArray lineItems = obiekt.getJSONArray("list");
        System.out.println(lineItems);

        int timeDay1Index = jsonString.indexOf(timeDay1);
        int timeDay1EndIndex = jsonString.indexOf(timeDay1End);
        int timeDay2Index = jsonString.indexOf(timeDay2);
        int timeDay2EndIndex = jsonString.indexOf(timeDay2End);
        int timeDay3Index = jsonString.indexOf(timeDay3);
        int timeDay3EndIndex = jsonString.indexOf(timeDay3End);
        int timeDay4Index = jsonString.indexOf(timeDay4);
        int timeDay4EndIndex = jsonString.indexOf(timeDay4End);
        int timeDay5Index = jsonString.indexOf(timeDay5);
        int timeDay5EndIndex = jsonString.indexOf(timeDay5End);

        System.out.println(timeDay1Index);
        System.out.println(timeDay1EndIndex);
        System.out.println(timeDay2Index);
        System.out.println(timeDay2EndIndex);
        System.out.println(timeDay3Index);
        System.out.println(timeDay3EndIndex);
        System.out.println(timeDay4Index);
        System.out.println(timeDay4EndIndex);
        System.out.println(timeDay5Index);
        System.out.println(timeDay5EndIndex);

        String day1Forecast = (String) jsonString.subSequence(timeDay1Index, timeDay1EndIndex);
        String day2Forecast = (String) jsonString.subSequence(timeDay2Index, timeDay2EndIndex);
        String day3Forecast = (String) jsonString.subSequence(timeDay3Index, timeDay3EndIndex);
        String day4Forecast = (String) jsonString.subSequence(timeDay4Index, timeDay4EndIndex);
        String day5Forecast = (String) jsonString.subSequence(timeDay5Index, timeDay5EndIndex);

        getTempDescriptionAndIcon(day3Forecast);
        getTempDescriptionAndIcon(day2Forecast);
        getTempDescriptionAndIcon(day1Forecast);
        getTempDescriptionAndIcon(day4Forecast);
        getTempDescriptionAndIcon(day5Forecast);

        weatherForecastMap.put(timeDay1, getTempDescriptionAndIcon(day1Forecast));
        weatherForecastMap.put(timeDay2, getTempDescriptionAndIcon(day2Forecast));
        weatherForecastMap.put(timeDay3, getTempDescriptionAndIcon(day3Forecast));
        weatherForecastMap.put(timeDay4, getTempDescriptionAndIcon(day4Forecast));
        weatherForecastMap.put(timeDay5, getTempDescriptionAndIcon(day5Forecast));

        System.out.println(weatherForecastMap);
        //System.out.println(tablicaDanych);
        return  weatherForecastMap;
    }

    public ArrayList<String> getTempDescriptionAndIcon(String weatherDescription) {

        ArrayList<String> tablicaWarunkow = new ArrayList<String>();

        int tempIndex = weatherDescription.indexOf("temp");
        int iconIndex = weatherDescription.indexOf("icon");
        int descriptionIndex = weatherDescription.indexOf("description");

        String temp = weatherDescription.substring(tempIndex+6, tempIndex+8);
        System.out.println(temp);
        tablicaWarunkow.add(temp);

        String description = weatherDescription.substring(descriptionIndex+14, iconIndex-3);
        System.out.println(description);
        tablicaWarunkow.add(description);

        String icon = weatherDescription.substring(iconIndex+7, iconIndex+10);
        System.out.println(icon);
        tablicaWarunkow.add(icon);


        return tablicaWarunkow;
    }

}
