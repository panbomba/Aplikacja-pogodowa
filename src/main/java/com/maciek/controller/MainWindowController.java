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
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.ResourceBundle;

public class MainWindowController extends BaseController implements Initializable {
    public MainWindowController(WeatherDataManager weatherDataManager, ViewFactory viewFactory, String fxmlName) {
        super(weatherDataManager, viewFactory, fxmlName);
    }

    public void setLabelText(String data, Label label) {
        label.setText(data);
    }

    public String degrees = "\u00B0";

    @FXML
    private AnchorPane anchor;
    @FXML
    private TextField citySelection1;
    @FXML
    private TextField citySelection2;

    @FXML
    private StackPane todayCity1;
    @FXML
    private Label todayDateCity1;
    @FXML
    private ImageView mainImageCity1;
    @FXML
    private Label actualizationCity1;
    @FXML
    private Label nameCity1;
    @FXML
    private Label tempTodayCity1;
    @FXML
    private Label descriptionTodayCity1;
    @FXML
    private Label feelslikeTodayCity1;
    @FXML
    private Label minToday1;
    @FXML
    private Label maxToday1;
    @FXML
    private Label humidityToday1;
    @FXML
    private Label pressureToday1;

    @FXML
    private StackPane todayCity2;
    @FXML
    private Label todayDateCity2;
    @FXML
    private ImageView mainImageCity2;
    @FXML
    private Label actualizationCity2;
    @FXML
    private Label nameCity2;
    @FXML
    private Label tempTodayCity2;
    @FXML
    private Label descriptionTodayCity2;
    @FXML
    private Label feelslikeTodayCity2;
    @FXML
    private Label minToday2;
    @FXML
    private Label maxToday2;
    @FXML
    private Label humidityToday2;
    @FXML
    private Label pressureToday2;

    @FXML
    private StackPane day1City1Pane;
    @FXML
    private Label dateDay1City1;
    @FXML
    private Label descriptionDay1City1;
    @FXML
    private ImageView imageDay1City1;
    @FXML
    private Label tempDay1City1;

    @FXML
    private StackPane day2City1Pane;
    @FXML
    private Label dateDay2City1;
    @FXML
    private Label descriptionDay2City1;
    @FXML
    private ImageView imageDay2City1;
    @FXML
    private Label tempDay2City1;

    @FXML
    private StackPane day3City1Pane;
    @FXML
    private Label dateDay3City1;
    @FXML
    private Label descriptionDay3City1;
    @FXML
    private ImageView imageDay3City1;
    @FXML
    private Label tempDay3City1;

    @FXML
    private StackPane day4City1Pane;
    @FXML
    private Label dateDay4City1;
    @FXML
    private Label descriptionDay4City1;
    @FXML
    private ImageView imageDay4City1;
    @FXML
    private Label tempDay4City1;

    @FXML
    private StackPane day5City1Pane;
    @FXML
    private Label dateDay5City1;
    @FXML
    private Label descriptionDay5City1;
    @FXML
    private ImageView imageDay5City1;
    @FXML
    private Label tempDay5City1;

    @FXML
    private StackPane day1City2Pane;
    @FXML
    private Label dateDay1City2;
    @FXML
    private Label descriptionDay1City2;
    @FXML
    private ImageView imageDay1City2;
    @FXML
    private Label tempDay1City2;

    @FXML
    private StackPane day2City2Pane;
    @FXML
    private Label dateDay2City2;
    @FXML
    private Label descriptionDay2City2;
    @FXML
    private ImageView imageDay2City2;
    @FXML
    private Label tempDay2City2;

    @FXML
    private StackPane day3City2Pane;
    @FXML
    private Label dateDay3City2;
    @FXML
    private Label descriptionDay3City2;
    @FXML
    private ImageView imageDay3City2;
    @FXML
    private Label tempDay3City2;

    @FXML
    private StackPane day4City2Pane;
    @FXML
    private Label dateDay4City2;
    @FXML
    private Label descriptionDay4City2;
    @FXML
    private ImageView imageDay4City2;
    @FXML
    private Label tempDay4City2;

    @FXML
    private StackPane day5City2Pane;
    @FXML
    private Label dateDay5City2;
    @FXML
    private Label descriptionDay5City2;
    @FXML
    private ImageView imageDay5City2;
    @FXML
    private Label tempDay5City2;

    @FXML
    private Label copyrightsLabel;
    @FXML
    private Label errorLabel1;
    @FXML
    private Label errorLabel2;

    @FXML
    void button1Action() throws IOException {
        try {
            String inputCity1 = citySelection1.getText();
            System.out.println(inputCity1);
            errorLabel1.setText("");
            setSceneDataCity1(inputCity1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            errorLabel1.setText("Nie znaleziono wybranego miejsca.");
        } catch (UnknownHostException e) {
            errorLabel1.setText("Nie udało się połączyć z siecią");
        }
    }

    @FXML
    void button2Action() throws IOException {
        try {
            String inputCity2 = citySelection2.getText();
            errorLabel2.setText("");
            setSceneDataCity2(inputCity2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            errorLabel2.setText("Nie znaleziono wybranego miejsca.");
        } catch (UnknownHostException e) {
            errorLabel2.setText("Nie udało się połączyć z siecią");
        }
    }

    // INITIALIZE??? - PO CO?
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        StackPane todayCity1 = new StackPane();
        Label labelInsideCity1 = new Label();
        todayCity1.getChildren().add(labelInsideCity1);
    }

    public void setSceneDataCity1(String city1) throws IOException {
        String city1NoSpaces = city1.replace(" " , "+");
        HashMap weatherNow = weatherDataManager.getWeatherToday(city1NoSpaces);
        HashMap forecast = weatherDataManager.getForecastMap(city1NoSpaces);
        actualizationCity1.setText("aktualizacja: " + weatherDataManager.getTimeStamp());
        tempTodayCity1.setText(String.valueOf(weatherNow.get("temperature")) + degrees + " C");
        feelslikeTodayCity1.setText("odczuwalna: " + (String) weatherNow.get("feelslike") + degrees + " C");
        minToday1.setText("minimalna: " + (String) weatherNow.get("min") + degrees + " C");
        maxToday1.setText("maksymalna: " + (String) weatherNow.get("max") + degrees + " C");
        humidityToday1.setText("wilgotność: " + (String) weatherNow.get("humidity") +
                " %");
        pressureToday1.setText("ciśnienie: " + (String) weatherNow.get("pressure") +
                " hPa");
        descriptionTodayCity1.setText((String) weatherNow.get("description"));

        String icon = ((String) weatherNow.get("icon"));
        String iconLink = ("http://openweathermap.org/img/wn/" + icon + "@2x.png");
        Image websiteImage = new Image(iconLink);
        mainImageCity1.setImage(websiteImage);
        nameCity1.setText(city1.toUpperCase());
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
        dateDay5City1.setText(data4 + " / " + data5 + " noc");

        String iconDay1 = (String) forecast.get("day1icon");
        String iconLinkDay1 = ("http://openweathermap.org/img/wn/" + iconDay1 + "@2x.png");
        Image imageD1C1 = new Image(iconLinkDay1);
        imageDay1City1.setImage(imageD1C1);
        tempDay1City1.setText(forecast.get("day1temp") + degrees + " C");
        descriptionDay1City1.setText((String) forecast.get("day1desc"));

        String iconDay2 = (String) forecast.get("day2icon");
        String iconLinkDay2 = ("http://openweathermap.org/img/wn/" + iconDay2 + "@2x.png");
        Image imageD2C1 = new Image(iconLinkDay2);
        imageDay2City1.setImage(imageD2C1);
        tempDay2City1.setText(forecast.get("day2temp") + degrees + " C");
        descriptionDay2City1.setText((String) forecast.get("day2desc"));

        String iconDay3 = (String) forecast.get("day3icon");
        String iconLinkDay3 = ("http://openweathermap.org/img/wn/" + iconDay3 + "@2x.png");
        Image imageD3C1 = new Image(iconLinkDay3);
        imageDay3City1.setImage(imageD3C1);
        tempDay3City1.setText(forecast.get("day3temp") + degrees + " C");
        descriptionDay3City1.setText((String) forecast.get("day3desc"));

        String iconDay4 = (String) forecast.get("day4icon");
        String iconLinkDay4 = ("http://openweathermap.org/img/wn/" + iconDay4 + "@2x.png");
        Image imageD4C1 = new Image(iconLinkDay4);
        imageDay4City1.setImage(imageD4C1);
        tempDay4City1.setText(forecast.get("day4temp") + degrees + " C");
        descriptionDay4City1.setText((String) forecast.get("day4desc"));

        String iconDay5 = (String) forecast.get("day5icon");
        String iconLinkDay5 = ("http://openweathermap.org/img/wn/" + iconDay5 + "@2x.png");
        Image imageD5C1 = new Image(iconLinkDay5);
        imageDay5City1.setImage(imageD5C1);
        tempDay5City1.setText(forecast.get("day5temp") + degrees + " C");
        descriptionDay5City1.setText((String) forecast.get("day5desc"));

    }

    public void setSceneDataCity2(String city2) throws IOException {
        String city2NoSpaces = city2.replace(" " , "+");
        HashMap weatherNow = weatherDataManager.getWeatherToday(city2NoSpaces);
        actualizationCity2.setText("aktualizacja: " + weatherDataManager.getTimeStamp());
        tempTodayCity2.setText(String.valueOf(weatherNow.get("temperature")) + degrees + " C");
        feelslikeTodayCity2.setText("odczuwalna: " + (String) weatherNow.get("feelslike") + degrees + " C");
        minToday2.setText("minimalna: " + (String) weatherNow.get("min") + degrees + " C");
        maxToday2.setText("maksymalna: " + (String) weatherNow.get("max") + degrees + " C");
        humidityToday2.setText("wilgotność: " + (String) weatherNow.get("humidity") +
                " %");
        pressureToday2.setText("ciśnienie: " + (String) weatherNow.get("pressure") +
                " hPa");
        descriptionTodayCity2.setText((String) weatherNow.get("description"));

        String icon = ((String) weatherNow.get("icon"));
        String iconLink = ("http://openweathermap.org/img/wn/" + icon + "@2x.png");
        Image websiteImage2 = new Image(iconLink);
        mainImageCity2.setImage(websiteImage2);
        nameCity2.setText(city2.toUpperCase());
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
        dateDay5City2.setText(data4 + " / " + data5 + " noc");

        HashMap forecast = weatherDataManager.getForecastMap(city2NoSpaces);

        String iconDay1 = (String) forecast.get("day1icon");
        String iconLinkDay1 = ("http://openweathermap.org/img/wn/" + iconDay1 + "@2x.png");
        Image imageD1C1 = new Image(iconLinkDay1);
        imageDay1City2.setImage(imageD1C1);
        tempDay1City2.setText(forecast.get("day1temp") + degrees + " C");
        descriptionDay1City2.setText((String) forecast.get("day1desc"));

        String iconDay2 = (String) forecast.get("day2icon");
        String iconLinkDay2 = ("http://openweathermap.org/img/wn/" + iconDay2 + "@2x.png");
        Image imageD2C1 = new Image(iconLinkDay2);
        imageDay2City2.setImage(imageD2C1);
        tempDay2City2.setText(forecast.get("day2temp") + degrees + " C");
        descriptionDay2City2.setText((String) forecast.get("day2desc"));

        String iconDay3 = (String) forecast.get("day3icon");
        String iconLinkDay3 = ("http://openweathermap.org/img/wn/" + iconDay3 + "@2x.png");
        Image imageD3C1 = new Image(iconLinkDay3);
        imageDay3City2.setImage(imageD3C1);
        tempDay3City2.setText(forecast.get("day3temp") + degrees + " C");
        descriptionDay3City2.setText((String) forecast.get("day3desc"));

        String iconDay4 = (String) forecast.get("day4icon");
        String iconLinkDay4 = ("http://openweathermap.org/img/wn/" + iconDay4 + "@2x.png");
        Image imageD4C1 = new Image(iconLinkDay4);
        imageDay4City2.setImage(imageD4C1);
        tempDay4City2.setText(forecast.get("day4temp") + degrees + " C");
        descriptionDay4City2.setText((String) forecast.get("day4desc"));

        String iconDay5 = (String) forecast.get("day5icon");
        String iconLinkDay5 = ("http://openweathermap.org/img/wn/" + iconDay5 + "@2x.png");
        Image imageD5C1 = new Image(iconLinkDay5);
        imageDay5City2.setImage(imageD5C1);
        tempDay5City2.setText(forecast.get("day5temp") + degrees + " C");
        descriptionDay5City2.setText((String) forecast.get("day5desc"));

    }

    public String getWeekday(){
        String weekday = new SimpleDateFormat("EEE, MMM d").format(new java.util.Date());
        System.out.println(weekday);
        return weekday;
    }

}
