package com.maciek;

import com.maciek.model.WeatherDataManager;
import com.maciek.view.ViewFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class Launcher extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        //Parent parent = FXMLLoader.load(getClass().getResource("view/MainWindow.fxml"));
        //Scene scene = new Scene(parent);
        //stage.setScene(scene);
        //stage.show();

        ViewFactory viewFactory = new ViewFactory(new WeatherDataManager());
        viewFactory.showMainWindow();
    }



}
