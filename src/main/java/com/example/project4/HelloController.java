package com.example.project4;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class HelloController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button currentOrderButton;

    @FXML
    private Button chicagoStyleButton;

    @FXML
    private Button nyStyleButton;

    @FXML
    private Button ordersPlacedButton;






    @FXML
    public void switchToCurrentOrder(javafx.scene.input.MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("currentOrderWindow.fxml"));
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        scene = new Scene(root);
        stage.setScene(scene);

        stage.initOwner(currentOrderButton.getScene().getWindow());
        stage.showAndWait();
    }


    @FXML
    public void switchToChicagoStyle(javafx.scene.input.MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("chicagoStyleWindow.fxml"));
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        scene = new Scene(root);
        stage.setScene(scene);

        stage.initOwner(chicagoStyleButton.getScene().getWindow());
        stage.showAndWait();
    }

    @FXML
    public void switchToNyStyle(javafx.scene.input.MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("nyStyleWindow.fxml"));
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        scene = new Scene(root);
        stage.setScene(scene);

        stage.initOwner(nyStyleButton.getScene().getWindow());
        stage.showAndWait();
    }

    @FXML
    public void switchToOrdersPlaced(javafx.scene.input.MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("ordersPlacedWindow.fxml"));
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        scene = new Scene(root);
        stage.setScene(scene);

        stage.initOwner(ordersPlacedButton.getScene().getWindow());
        stage.showAndWait();
    }
}