package com.example.project4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.PrintStream;

public class HelloApplication extends Application {
    public static BorderPane root;

    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        stage.setTitle("Clinic Manager");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloApplication.class.getResource("hello-view.fxml"));
        root = loader.load();

        //String date = datePicker.getValue().toString();
        HelloController controller = loader.getController();

        //root.setCenter(controller.tabPane);

        // Pass the reference of HelloApplication to the controller

//        TextField textField = controller.getConsoleOutputField();
//
//        // Redirect System.out to the TextField
//        TextFieldOutputStream textFieldOutputStream = new TextFieldOutputStream(textField);
//        System.setOut(new PrintStream(textFieldOutputStream, true));


        Scene scene = new Scene(root, 600, 600);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}