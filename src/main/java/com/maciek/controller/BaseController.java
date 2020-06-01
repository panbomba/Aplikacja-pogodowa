package com.maciek.controller;

import com.maciek.model.WeatherDataManager;
import com.maciek.view.ViewFactory;

public abstract class BaseController {

    protected WeatherDataManager weatherDataManager;
    protected ViewFactory viewFactory;
    private final String fxmlName;

    public BaseController(WeatherDataManager weatherDataManager, ViewFactory viewFactory, String fxmlName) {
        this.viewFactory = viewFactory;
        this.weatherDataManager = weatherDataManager;
        this.fxmlName = fxmlName;
    }

    public String getFxmlName(){
        return fxmlName;
    }
}
