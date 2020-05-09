package com.maciek.controller;

import com.maciek.WeatherDataManager;
import com.maciek.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class MainWindowController extends BaseController {
    public MainWindowController(WeatherDataManager weatherDataManager, ViewFactory viewFactory, String fxmlName) {
        super(weatherDataManager, viewFactory, fxmlName);
    }

    @FXML
    private Label etykietaMiasta;

    @FXML
    private TextField wyborMiasta;

    @FXML
    void button1Action() {
        System.out.println("wybrales pierwsze miasto!");
    }

    @FXML
    void button2Action() {
        System.out.println("wybrales drugie miasto!");
    }

    @FXML
    private Pane todayCity1;

    @FXML
    private Pane todayCity2;
}
