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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
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
        getWeekday();
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
        todayDateCity1.setText(getWeekday());

        todayCity1.setVisible(true);
        day1City1Pane.setVisible(true);
        day2City1Pane.setVisible(true);
        day3City1Pane.setVisible(true);
        day4City1Pane.setVisible(true);
        day5City1Pane.setVisible(true);

        LocalDate localDate = LocalDate.now();
        String data1 = weatherDataManager.translateWeekday(localDate.getDayOfWeek().plus(1).toString());
        String data2 = weatherDataManager.translateWeekday(localDate.getDayOfWeek().plus(2).toString());
        String data3 = weatherDataManager.translateWeekday(localDate.getDayOfWeek().plus(3).toString());
        String data4 = weatherDataManager.translateWeekday(localDate.getDayOfWeek().plus(4).toString());
        String data5 = weatherDataManager.translateWeekday(localDate.getDayOfWeek().plus(5).toString());

        dateDay1City1.setText(data1);
        dateDay2City1.setText(data2);
        dateDay3City1.setText(data3);
        dateDay4City1.setText(data4);
        dateDay5City1.setText(data5);

        HashMap forecast = weatherDataManager.getForecastMap(miasto1);

        String iconDay1 = (String) forecast.get("day1icon");
        String iconLinkDay1 = ("http://openweathermap.org/img/wn/" + iconDay1 + "@2x.png");
        Image imageD1C1 = new Image(iconLinkDay1);
        obrazDay1City1.setImage(imageD1C1);
        tempDay1City1.setText(forecast.get("day1temp") + stopnie + " C");
        descriptionDay1City1.setText((String) forecast.get("day1desc"));

        String iconDay2 = (String) forecast.get("day2icon");
        String iconLinkDay2 = ("http://openweathermap.org/img/wn/" + iconDay2 + "@2x.png");
        Image imageD2C1 = new Image(iconLinkDay2);
        obrazDay2City1.setImage(imageD2C1);
        tempDay2City1.setText(forecast.get("day2temp") + stopnie + " C");
        descriptionDay2City1.setText((String) forecast.get("day2desc"));

        String iconDay3 = (String) forecast.get("day3icon");
        String iconLinkDay3 = ("http://openweathermap.org/img/wn/" + iconDay3 + "@2x.png");
        Image imageD3C1 = new Image(iconLinkDay3);
        obrazDay3City1.setImage(imageD3C1);
        tempDay3City1.setText(forecast.get("day3temp") + stopnie + " C");
        descriptionDay3City1.setText((String) forecast.get("day3desc"));

        String iconDay4 = (String) forecast.get("day4icon");
        String iconLinkDay4 = ("http://openweathermap.org/img/wn/" + iconDay4 + "@2x.png");
        Image imageD4C1 = new Image(iconLinkDay4);
        obrazDay4City1.setImage(imageD4C1);
        tempDay4City1.setText(forecast.get("day4temp") + stopnie + " C");
        descriptionDay4City1.setText((String) forecast.get("day4desc"));

        String iconDay5 = (String) forecast.get("day5icon");
        String iconLinkDay5 = ("http://openweathermap.org/img/wn/" + iconDay5 + "@2x.png");
        Image imageD5C1 = new Image(iconLinkDay5);
        obrazDay5City1.setImage(imageD5C1);
        tempDay5City1.setText(forecast.get("day5temp") + stopnie + " C");
        descriptionDay5City1.setText((String) forecast.get("day5desc"));

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
        todayDateCity2.setText(getWeekday());

        todayCity2.setVisible(true);
        day1City2Pane.setVisible(true);
        day2City2Pane.setVisible(true);
        day3City2Pane.setVisible(true);
        day4City2Pane.setVisible(true);
        day5City2Pane.setVisible(true);

        LocalDate localDate = LocalDate.now();
        String data1 = weatherDataManager.translateWeekday(localDate.getDayOfWeek().plus(1).toString());
        String data2 = weatherDataManager.translateWeekday(localDate.getDayOfWeek().plus(2).toString());
        String data3 = weatherDataManager.translateWeekday(localDate.getDayOfWeek().plus(3).toString());
        String data4 = weatherDataManager.translateWeekday(localDate.getDayOfWeek().plus(4).toString());
        String data5 = weatherDataManager.translateWeekday(localDate.getDayOfWeek().plus(5).toString());

        dateDay1City2.setText(data1);
        dateDay2City2.setText(data2);
        dateDay3City2.setText(data3);
        dateDay4City2.setText(data4);
        dateDay5City2.setText(data5);


        HashMap forecast = weatherDataManager.getForecastMap(miasto2);

        String iconDay1 = (String) forecast.get("day1icon");
        String iconLinkDay1 = ("http://openweathermap.org/img/wn/" + iconDay1 + "@2x.png");
        Image imageD1C1 = new Image(iconLinkDay1);
        obrazDay1City2.setImage(imageD1C1);
        tempDay1City2.setText(forecast.get("day1temp") + stopnie + " C");
        descriptionDay1City2.setText((String) forecast.get("day1desc"));

        String iconDay2 = (String) forecast.get("day2icon");
        String iconLinkDay2 = ("http://openweathermap.org/img/wn/" + iconDay2 + "@2x.png");
        Image imageD2C1 = new Image(iconLinkDay2);
        obrazDay2City2.setImage(imageD2C1);
        tempDay2City2.setText(forecast.get("day2temp") + stopnie + " C");
        descriptionDay2City2.setText((String) forecast.get("day2desc"));

        String iconDay3 = (String) forecast.get("day3icon");
        String iconLinkDay3 = ("http://openweathermap.org/img/wn/" + iconDay3 + "@2x.png");
        Image imageD3C1 = new Image(iconLinkDay3);
        obrazDay3City2.setImage(imageD3C1);
        tempDay3City2.setText(forecast.get("day3temp") + stopnie + " C");
        descriptionDay3City2.setText((String) forecast.get("day3desc"));

        String iconDay4 = (String) forecast.get("day4icon");
        String iconLinkDay4 = ("http://openweathermap.org/img/wn/" + iconDay4 + "@2x.png");
        Image imageD4C1 = new Image(iconLinkDay4);
        obrazDay4City2.setImage(imageD4C1);
        tempDay4City2.setText(forecast.get("day4temp") + stopnie + " C");
        descriptionDay4City2.setText((String) forecast.get("day4desc"));

        String iconDay5 = (String) forecast.get("day5icon");
        String iconLinkDay5 = ("http://openweathermap.org/img/wn/" + iconDay5 + "@2x.png");
        Image imageD5C1 = new Image(iconLinkDay5);
        obrazDay5City2.setImage(imageD5C1);
        tempDay5City2.setText(forecast.get("day5temp") + stopnie + " C");
        descriptionDay5City2.setText((String) forecast.get("day5desc"));

    }

    public String getWeekday(){
        String weekday = new SimpleDateFormat("EEE, MMM d").format(new java.util.Date());
        System.out.println(weekday);
        return weekday;
    }

}
