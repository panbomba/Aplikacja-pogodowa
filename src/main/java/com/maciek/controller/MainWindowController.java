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
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class MainWindowController extends BaseController implements Initializable {
    public MainWindowController(WeatherDataManager weatherDataManager, ViewFactory viewFactory, String fxmlName) {
        super(weatherDataManager, viewFactory, fxmlName);
    }

    public void setLabelText(String data, Label label) {
        label.setText(data);
    }

    public String stopnie = "\u00B0";

    @FXML
    private AnchorPane anchor;
    @FXML
    private TextField wyborMiasta1;
    @FXML
    private TextField wyborMiasta2;

    @FXML
    private StackPane todayCity1;
    @FXML
    private Label todayDateCity1;
    @FXML
    private ImageView obraz;
    @FXML
    private Label aktualizacjaCity1;
    @FXML
    private Label nameCity1;
    @FXML
    private Label tempTodayCity1;
    @FXML
    private Label descriptionTodayCity1;
    @FXML
    private Label odczuwalnaToday1;
    @FXML
    private Label minToday1;
    @FXML
    private Label maxToday1;
    @FXML
    private Label humidToday1;
    @FXML
    private Label pressureToday1;

    @FXML
    private StackPane todayCity2;
    @FXML
    private Label todayDateCity2;
    @FXML
    private ImageView obraz2;
    @FXML
    private Label aktualizacjaCity2;
    @FXML
    private Label nameCity2;
    @FXML
    private Label tempTodayCity2;
    @FXML
    private Label descriptionTodayCity2;
    @FXML
    private Label odczuwalnaToday2;
    @FXML
    private Label minToday2;
    @FXML
    private Label maxToday2;
    @FXML
    private Label humidToday2;
    @FXML
    private Label pressureToday2;

    @FXML
    private StackPane day1City1Pane;
    @FXML
    private Label dateDay1City1;
    @FXML
    private Label descriptionDay1City1;
    @FXML
    private ImageView obrazDay1City1;
    @FXML
    private Label tempDay1City1;

    @FXML
    private StackPane day2City1Pane;
    @FXML
    private Label dateDay2City1;
    @FXML
    private Label descriptionDay2City1;
    @FXML
    private ImageView obrazDay2City1;
    @FXML
    private Label tempDay2City1;

    @FXML
    private StackPane day3City1Pane;
    @FXML
    private Label dateDay3City1;
    @FXML
    private Label descriptionDay3City1;
    @FXML
    private ImageView obrazDay3City1;
    @FXML
    private Label tempDay3City1;

    @FXML
    private StackPane day4City1Pane;
    @FXML
    private Label dateDay4City1;
    @FXML
    private Label descriptionDay4City1;
    @FXML
    private ImageView obrazDay4City1;
    @FXML
    private Label tempDay4City1;

    @FXML
    private StackPane day5City1Pane;
    @FXML
    private Label dateDay5City1;
    @FXML
    private Label descriptionDay5City1;
    @FXML
    private ImageView obrazDay5City1;
    @FXML
    private Label tempDay5City1;

    @FXML
    private StackPane day1City2Pane;
    @FXML
    private Label dateDay1City2;
    @FXML
    private Label descriptionDay1City2;
    @FXML
    private ImageView obrazDay1City2;
    @FXML
    private Label tempDay1City2;

    @FXML
    private StackPane day2City2Pane;
    @FXML
    private Label dateDay2City2;
    @FXML
    private Label descriptionDay2City2;
    @FXML
    private ImageView obrazDay2City2;
    @FXML
    private Label tempDay2City2;

    @FXML
    private StackPane day3City2Pane;
    @FXML
    private Label dateDay3City2;
    @FXML
    private Label descriptionDay3City2;
    @FXML
    private ImageView obrazDay3City2;
    @FXML
    private Label tempDay3City2;

    @FXML
    private StackPane day4City2Pane;
    @FXML
    private Label dateDay4City2;
    @FXML
    private Label descriptionDay4City2;
    @FXML
    private ImageView obrazDay4City2;
    @FXML
    private Label tempDay4City2;

    @FXML
    private StackPane day5City2Pane;
    @FXML
    private Label dateDay5City2;
    @FXML
    private Label descriptionDay5City2;
    @FXML
    private ImageView obrazDay5City2;
    @FXML
    private Label tempDay5City2;

    @FXML
    private Label etykietaCopyrights;
    @FXML
    private Label errorLabel1;
    @FXML
    private Label errorLabel2;

    @FXML
    void button1Action() throws IOException {
        String wpisanyTekst1 = wyborMiasta1.getText();
        setSceneDataCity1(wpisanyTekst1);
        weatherDataManager.getUnixTimeForTomorrow();
        weatherDataManager.getForecastMap(wpisanyTekst1);
    }

    @FXML
    void button2Action() throws IOException {
        String wpisanyTekst2 = wyborMiasta2.getText();
        setSceneDataCity2(wpisanyTekst2);
        //weatherDataManager.Forecats(wpisanyTekst2);
    }

    // INITIALIZE??? - PO CO?
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        StackPane todayCity1 = new StackPane();
        Label labelInsideCity1 = new Label();
        todayCity1.getChildren().add(labelInsideCity1);
    }

    public void setSceneDataCity1(String wpisanyTekst1) throws IOException {
        String miasto1 = wpisanyTekst1.replace(" " , "+");
        //String forecast = weatherDataManager.getJsonStringForecast(miasto1);
        HashMap weatherNow = weatherDataManager.getWeatherToday(miasto1);
        aktualizacjaCity1.setText("aktualizacja: " + weatherDataManager.getTimeStamp());
        tempTodayCity1.setText(String.valueOf(weatherNow.get("temperature")) + stopnie + " C");
        odczuwalnaToday1.setText("odczuwalna: " + (String) weatherNow.get("feelslike") + stopnie + " C");
        minToday1.setText("minimalna: " + (String) weatherNow.get("min") + stopnie + " C");
        maxToday1.setText("maksymalna: " + (String) weatherNow.get("max") + stopnie + " C");
        humidToday1.setText("wilgotność: " + (String) weatherNow.get("humidity") +
                " %");
        pressureToday1.setText("ciśnienie: " + (String) weatherNow.get("pressure") +
                " hPa");
        descriptionTodayCity1.setText((String) weatherNow.get("description"));

        String icon = ((String) weatherNow.get("icon"));
        String iconLink = ("http://openweathermap.org/img/wn/" + icon + "@2x.png");
        Image obrazStronka = new Image(iconLink);
        obraz.setImage(obrazStronka);
        nameCity1.setText(wpisanyTekst1.toUpperCase());

        todayCity1.setVisible(true);
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

    public void setSceneDataCity2(String wpisanyTekst2) throws IOException {
        String miasto2 = wpisanyTekst2.replace(" " , "+");
        HashMap weatherNow = weatherDataManager.getWeatherToday(miasto2);
        aktualizacjaCity2.setText("aktualizacja: " + weatherDataManager.getTimeStamp());
        tempTodayCity2.setText(String.valueOf(weatherNow.get("temperature")) + stopnie + " C");
        odczuwalnaToday2.setText("odczuwalna: " + (String) weatherNow.get("feelslike") + stopnie + " C");
        minToday2.setText("minimalna: " + (String) weatherNow.get("min") + stopnie + " C");
        maxToday2.setText("maksymalna: " + (String) weatherNow.get("max") + stopnie + " C");
        humidToday2.setText("wilgotność: " + (String) weatherNow.get("humidity") +
                " %");
        pressureToday2.setText("ciśnienie: " + (String) weatherNow.get("pressure") +
                " hPa");
        descriptionTodayCity2.setText((String) weatherNow.get("description"));

        String icon = ((String) weatherNow.get("icon"));
        String iconLink = ("http://openweathermap.org/img/wn/" + icon + "@2x.png");
        Image obrazStronka = new Image(iconLink);
        obraz2.setImage(obrazStronka);
        nameCity2.setText(wpisanyTekst2.toUpperCase());

        todayCity2.setVisible(true);
        day1City2Pane.setVisible(true);
        obrazDay1City2.setImage(obrazStronka);
        day2City2Pane.setVisible(true);
        obrazDay2City2.setImage(obrazStronka);
        day3City2Pane.setVisible(true);
        obrazDay3City2.setImage(obrazStronka);
        day4City2Pane.setVisible(true);
        obrazDay4City2.setImage(obrazStronka);
        day5City2Pane.setVisible(true);
        obrazDay5City2.setImage(obrazStronka);

    }

}
