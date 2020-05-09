package com.maciek.controller;

import com.maciek.WeatherDataManager;
import com.maciek.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MainWindowController extends BaseController {
    public MainWindowController(WeatherDataManager weatherDataManager, ViewFactory viewFactory, String fxmlName) {
        super(weatherDataManager, viewFactory, fxmlName);
    }

    @FXML
    private Label etykietaMiasta1;

    @FXML
    private TextField wyborMiasta1;

    @FXML
    private Label etykietaMiasta2;

    @FXML
    private TextField wyborMiasta2;

    @FXML
    void button1Action() throws FileNotFoundException {
        System.out.println("wybrales pierwsze miasto!");

        String miasto1 = wyborMiasta1.getText();
        errorLabel1.setText("POGODA DLA " + miasto1.toUpperCase());
    }

    @FXML
    void button2Action() {
        System.out.println("wybrales drugie miasto!");
        errorLabel2.setText("wybrales drugie miasto");
    }

    @FXML
    private Label errorLabel1;

    @FXML
    private Label errorLabel2;

    @FXML
    private Pane todayCity1;

    @FXML
    private ImageView imageCity1today;

    @FXML
    private Pane todayCity2;

    @FXML
    private Label etykietaCopyrights;
}
