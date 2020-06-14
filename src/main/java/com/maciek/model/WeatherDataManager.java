package com.maciek.model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import static java.lang.String.*;

public class WeatherDataManager {

    private static String apiKey = "fb39b81cd3a7ca7c9c2938c1e8a19e6d"; //CZY TO MA BYC STALA ALBO PRIVATE?
    private Object HashMap;

    public String getJsonStringWeather(String city) throws IOException {

        String adresURLweather =
                "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&lang=pl" + "&units=metric" +
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

    public String getJsonStringForecast(String city) throws IOException {

        String adresURLforecast =
                "http://api.openweathermap.org/data/2.5/forecast?q=" + city + "&lang=pl" + "&units=metric" +
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

    public String getTimeStamp() {
        String timeStamp = new SimpleDateFormat("HH:mm").format(new java.util.Date());
        return timeStamp;
    }

    public Map<String, String> getWeatherToday(String city) throws IOException {

        Map<String, String> weatherConditions = new HashMap<>();
        String jsonString = getJsonStringWeather(city);
        JSONObject obiect = new JSONObject(jsonString);
        JSONArray lineItems = obiect.getJSONArray("weather");

        String temperature = valueOf(obiect.getJSONObject("main").getInt("temp"));
        String feelslike = valueOf(obiect.getJSONObject("main").getInt("feels_like"));
        String min = valueOf(obiect.getJSONObject("main").getInt("temp_min"));
        String max = valueOf(obiect.getJSONObject("main").getInt("temp_max"));
        String pressure = valueOf(obiect.getJSONObject("main").getInt("pressure"));
        String humidity = valueOf(obiect.getJSONObject("main").getInt("humidity"));

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
        return unixTimeStamp;
    }

    public Map<String, String> getForecastMap(String city) throws IOException, StringIndexOutOfBoundsException {
        Map<String, String> weatherForecastMap = new HashMap<>();
        long uniXTimeAtNoon = getUnixTimeForTomorrow();
        long unixTimeAtNoonDay2 = uniXTimeAtNoon + 86400;
        long unixTimeAtNoonDay3 = unixTimeAtNoonDay2 + 86400;
        long unixTimeAtNoonDay4 = unixTimeAtNoonDay3 + 86400;


        long unixTimeAtNoonDay5 = unixTimeAtNoonDay4 + 43200; //pointing midnight in case day5 data is
        // not yet available

        String timeDay1 = String.valueOf((uniXTimeAtNoon));

        String timeDay1End;
        timeDay1End = String.valueOf((uniXTimeAtNoon + 10800));
        String timeDay2 = String.valueOf(unixTimeAtNoonDay2);
        String timeDay2End = String.valueOf(unixTimeAtNoonDay2 + 10800);
        String timeDay3 = String.valueOf(unixTimeAtNoonDay3);
        String timeDay3End = String.valueOf(unixTimeAtNoonDay3 + 10800);
        String timeDay4 = String.valueOf(unixTimeAtNoonDay4);
        String timeDay4End = String.valueOf(unixTimeAtNoonDay4 + 10800);
        String timeDay5 = String.valueOf(unixTimeAtNoonDay5);

        String jsonString = getJsonStringForecast(city);
        try {

            int size;
            size = jsonString.length();

            if (size > 0) {

                int timeDay1Index = jsonString.indexOf(timeDay1);
                System.out.println(timeDay1Index);
                int timeDay1EndIndex = jsonString.indexOf(timeDay1End);
                int timeDay2Index = jsonString.indexOf(timeDay2);
                int timeDay2EndIndex = jsonString.indexOf(timeDay2End);
                int timeDay3Index = jsonString.indexOf(timeDay3);
                int timeDay3EndIndex = jsonString.indexOf(timeDay3End);
                int timeDay4Index = jsonString.indexOf(timeDay4);
                int timeDay4EndIndex = jsonString.indexOf(timeDay4End);
                int timeDay5Index = jsonString.indexOf(timeDay5);
                int timeDay5EndIndex = jsonString.indexOf(timeDay5) + 300; //three hour weather data is a string of
                // around 300 characters - in case request is done before 3 AM this is the last entry

                String day1Forecast = (String) jsonString.subSequence(timeDay1Index, timeDay1EndIndex);
                String day2Forecast = (String) jsonString.subSequence(timeDay2Index, timeDay2EndIndex);
                String day3Forecast = (String) jsonString.subSequence(timeDay3Index, timeDay3EndIndex);
                String day4Forecast = (String) jsonString.subSequence(timeDay4Index, timeDay4EndIndex);
                String day5Forecast = (String) jsonString.subSequence(timeDay5Index, timeDay5EndIndex);

                weatherForecastMap.put("day1temp", getTemp(day1Forecast));
                weatherForecastMap.put("day1desc", getDescription(day1Forecast));
                weatherForecastMap.put("day1icon", getIcon(day1Forecast));

                weatherForecastMap.put("day2temp", getTemp(day2Forecast));
                weatherForecastMap.put("day2desc", getDescription(day2Forecast));
                weatherForecastMap.put("day2icon", getIcon(day2Forecast));

                weatherForecastMap.put("day3temp", getTemp(day3Forecast));
                weatherForecastMap.put("day3desc", getDescription(day3Forecast));
                weatherForecastMap.put("day3icon", getIcon(day3Forecast));

                weatherForecastMap.put("day4temp", getTemp(day4Forecast));
                weatherForecastMap.put("day4desc", getDescription(day4Forecast));
                weatherForecastMap.put("day4icon", getIcon(day4Forecast));

                weatherForecastMap.put("day5temp", getTemp(day5Forecast));
                weatherForecastMap.put("day5desc", getDescription(day5Forecast));
                weatherForecastMap.put("day5icon", getIcon(day5Forecast));
            }
        } catch(StringIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        return  weatherForecastMap;
    }

    public String getTemp(String weatherDescription) {

        int tempIndex = weatherDescription.indexOf("temp");
        return weatherDescription.substring(tempIndex+6, tempIndex+8).replace(".", "");
    }

    public String getDescription(String weatherDescription) {

        int iconIndex = weatherDescription.indexOf("icon");
        int descriptionIndex = weatherDescription.indexOf("description");
        return weatherDescription.substring(descriptionIndex + 14, iconIndex - 3);
    }

    public String getIcon(String weatherDescription) {

        int iconIndex = weatherDescription.indexOf("icon");
        return weatherDescription.substring(iconIndex + 7, iconIndex + 10);
    }

    public String translateWeekday(String weekday) {
        switch (weekday) {
            case "SUNDAY":
                return "Niedziela";
            case "MONDAY":
                return "Poniedziałek";
            case "TUESDAY":
                return "Wtorek";
            case "WEDNESDAY":
                return "Środa";
            case "THURSDAY":
                return "Czwartek";
            case "FRIDAY":
                return "Piątek";
            case "SATURDAY":
                return "Sobota";
        }
        return weekday;
    }

}
