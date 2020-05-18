module Aplikacja.Pogodowa1 {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.web;
    requires javafx.graphics;

    opens com.maciek;
    opens com.maciek.controller;
    opens com.maciek.view;
    opens com.maciek.model;
}