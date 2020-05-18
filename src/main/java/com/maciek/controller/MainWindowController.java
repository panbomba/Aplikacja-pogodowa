package com.maciek.controller;

import com.maciek.model.WeatherDataManager;
import com.maciek.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController extends BaseController implements Initializable {
    public MainWindowController(WeatherDataManager weatherDataManager, ViewFactory viewFactory, String fxmlName) {
        super(weatherDataManager, viewFactory, fxmlName);
    }

    @FXML
    private AnchorPane anchor;

    @FXML
    private Label etykietaMiasta1;

    @FXML
    private TextField wyborMiasta1;

    @FXML
    private Label etykietaMiasta2;

    @FXML
    private TextField wyborMiasta2;

    @FXML
    private StackPane todayCity1;

    @FXML
    private Label todayDate;

    @FXML
    private ImageView obraz;

    @FXML
    private ImageView obraz2;

    @FXML
    private Label warunkiToday;

    @FXML
    private StackPane todayCity2;

    @FXML
    private StackPane day1City1Pane;

    @FXML
    private StackPane day2City1Pane;

    @FXML
    private StackPane day3City1Pane;

    @FXML
    private StackPane day4City1Pane;

    @FXML
    private StackPane day5City1Pane;

    @FXML
    private StackPane day1City2Pane;

    @FXML
    private StackPane day2City2Pane;

    @FXML
    private StackPane day3City2Pane;

    @FXML
    private StackPane day4City2Pane;

    @FXML
    private StackPane day5City2Pane;

    @FXML
    private Label etykietaCopyrights;

    @FXML
    private Label errorLabel1;

    @FXML
    private Label nameCity1;

    @FXML
    private Label nameCity2;

    @FXML
    private Label errorLabel2;

    @FXML
    private ImageView obrazDay1City1;

    @FXML
    private ImageView obrazDay2City1;

    @FXML
    private ImageView obrazDay3City1;

    @FXML
    private ImageView obrazDay4City1;

    @FXML
    private ImageView obrazDay5City1;

    @FXML
    private ImageView obrazDay1City2;

    @FXML
    private ImageView obrazDay2City2;

    @FXML
    private ImageView obrazDay3City2;

    @FXML
    private ImageView obrazDay4City2;

    @FXML
    private ImageView obrazDay5City2;

    @FXML
    void button1Action() throws IOException {
        String miasto1 = wyborMiasta1.getText();
        weatherDataManager.getJsonStringWeather(miasto1); // NA KONIEC WSZYSTKO UMIESCIC W JEDNEJ FUNKCJI: GET WEATHER
        weatherDataManager.getJsonStringForecast(miasto1);
        weatherDataManager.getTimeStamp();
        //errorLabel1.setText("POGODA DLA " + miasto1.toUpperCase());
        todayCity1.setVisible(true);
        Image obrazStronka = new Image("http://openweathermap.org/img/wn/10d@2x.png");
        obraz.setImage(obrazStronka);
        nameCity1.setText(miasto1.toUpperCase());
        day1City1Pane.setVisible(true);
        obrazDay1City1.setImage(obrazStronka);
        day2City1Pane.setVisible(true);
        obrazDay2City1.setImage(obrazStronka);
        day3City1Pane.setVisible(true);
        obrazDay3City1.setImage(obrazStronka);
        day4City1Pane.setVisible(true);
        obrazDay4City1.setImage(obrazStronka);
        day5City1Pane.setVisible(true);
        obrazDay5City1.setImage(obrazStronka);

    }

    @FXML
    void button2Action() {
        String miasto2 = wyborMiasta2.getText();
        //errorLabel2.setText("wybrales drugie miasto");
        Image obrazStronka2 = new Image("http://openweathermap.org/img/wn/10d@2x.png");
        obraz2.setImage(obrazStronka2);
        nameCity2.setText(miasto2.toUpperCase());
        todayCity2.setVisible(true);
        day1City2Pane.setVisible(true);
        obrazDay1City2.setImage(obrazStronka2);
        day2City2Pane.setVisible(true);
        obrazDay2City2.setImage(obrazStronka2);
        day3City2Pane.setVisible(true);
        obrazDay3City2.setImage(obrazStronka2);
        day4City2Pane.setVisible(true);
        obrazDay4City2.setImage(obrazStronka2);
        day5City2Pane.setVisible(true);
        obrazDay5City2.setImage(obrazStronka2);
    }

    // INITIALIZE??? - PO CO?
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        StackPane todayCity1 = new StackPane();
        Label labelInsideCity1 = new Label();
        todayCity1.getChildren().add(labelInsideCity1);
    }
}
