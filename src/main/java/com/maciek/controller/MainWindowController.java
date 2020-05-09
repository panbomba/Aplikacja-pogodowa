package com.maciek.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainWindowController {


    @FXML
    private Label etykietaMiasta;

    @FXML
    private TextField wyborMiasta;

    @FXML
    void button1Action() {
        System.out.println("wybrales miasto!");

    }
}
