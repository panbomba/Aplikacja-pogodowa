module Aplikacja.Pogodowa1 {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.web;
    requires javafx.graphics;
    requires org.json;
    requires com.google.gson;

    opens com.maciek;
    opens com.maciek.controller;
    opens com.maciek.view;
    opens com.maciek.model;
}