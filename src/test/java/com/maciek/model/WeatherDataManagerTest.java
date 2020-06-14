package com.maciek.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class WeatherDataManagerTest {

    private WeatherDataManager weatherDataManager;
    @BeforeEach
    void initializeWeatherDataObject() {
        weatherDataManager = new WeatherDataManager();
    }

    @Test
    void jsonStringShouldBeLongerThanZero() throws IOException {
        //when
        String data = weatherDataManager.getJsonStringWeather("krakow");
        //then
        assertThat(data.length(), greaterThan(0));
    }

    @Test
    void weatherMapShouldHaveSizeEight() throws IOException {
        //when
        Map<String, String> weatherMap = weatherDataManager.getWeatherToday("krakow");
        //then
        assertThat(weatherMap.size(), equalTo(8));
    }

    @Test
    void forecastMapShouldHaveSizeFifteen() throws IOException {
        //when
        Map<String, String> forecastMap = weatherDataManager.getForecastMap("krakow");
        //then
        assertThat(forecastMap.size(), equalTo(15));
    }

    @Test
    void unixTimeStampIsNotNull() {
        //when
        Long unixTimestamp = weatherDataManager.getUnixTimeForTomorrow();
        //then
        assertNotNull(unixTimestamp);
    }

    @Test
    void timeStampStringShouldNotBeNull() {
        //when
        String timeStamp = weatherDataManager.getTimeStamp();
        //then
        assertNotNull(timeStamp);
    }
    @Test
    void tempStringShouldNotBeNull() throws IOException {
        //when
        String temp = weatherDataManager.getTemp(weatherDataManager.getJsonStringForecast("krakow"));
        //then
        assertNotNull(temp);
    }
    @Test
    void descriptionStringShouldNotBeNull() throws IOException {
        //when
        String description = weatherDataManager.getDescription(weatherDataManager.getJsonStringForecast("krakow"));
        //then
        assertNotNull(description);
    }
    @Test
    void iconStringLengthShouldBeThree() throws IOException {
        //when
        String icon = weatherDataManager.getIcon(weatherDataManager.getJsonStringForecast("krakow"));
        //then
        assertThat(icon.length(), equalTo(3));
    }
}