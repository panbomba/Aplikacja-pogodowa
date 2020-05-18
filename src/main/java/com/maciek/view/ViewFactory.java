package com.maciek.view;

import com.maciek.model.WeatherDataManager;
import com.maciek.controller.BaseController;
import com.maciek.controller.MainWindowController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewFactory {

    private WeatherDataManager weatherDataManager;

    public ViewFactory(WeatherDataManager weatherDataManager) {
        this.weatherDataManager = weatherDataManager;
    }

    public void showMainWindow(){
        //System.out.println("pokazano okno glowne");

        BaseController controller = new MainWindowController(weatherDataManager, this, "MainWindow.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(controller.getFxmlName()));
        fxmlLoader.setController(controller);

        Parent root;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }


        Scene scene = new Scene(root);
        Stage stage = new Stage();

        scene.getStylesheets().clear();
        scene.getStylesheets().add(getClass().getResource("css/styles.css").toExternalForm());


        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }
}
