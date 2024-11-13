package com.example.project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import src.*;

import java.io.IOException;
import java.util.ArrayList;

public class ChicagoStyleWindow {

    public static ArrayList<Pizza> pizzasArrayList = new ArrayList<>();
    @FXML
    private ChoiceBox pizzaTypeChoiceBox = new ChoiceBox();

    @FXML
    private RadioButton smallRadioButton;

    @FXML
    private RadioButton mediumRadioButton;

    @FXML
    private RadioButton largeRadioButton;

    @FXML
    private ToggleGroup toggleServiceSize = new ToggleGroup();

    @FXML
    ListView<String> toppingsListView = new ListView<>();

    @FXML
    Button addToOrderButton;

    @FXML
    TextField CrustTextField = new TextField();

    @FXML
    TextField priceTextField = new TextField();




    @FXML
    public void initialize() {

        ObservableList<String> pizzaTypeList = FXCollections.observableArrayList("Meatzza", "Build Your Own", "BBQ Chicken", "Deluxe");
        pizzaTypeChoiceBox.setItems(pizzaTypeList);
        pizzaTypeChoiceBox.getSelectionModel().selectFirst();


        smallRadioButton.setToggleGroup(toggleServiceSize);
        mediumRadioButton.setToggleGroup(toggleServiceSize);
        largeRadioButton.setToggleGroup(toggleServiceSize);

        ObservableList<String> toppingsList = FXCollections.observableArrayList("SAUSAGE", "PEPPERONI", "GREEN PEPPER", "ONION", "MUSHROOM",
                "BBQ CHICKEN", "CHEDDAR", "PROVOLONE", "BEEF", "HAM");
        toppingsListView.setItems(toppingsList);

        CrustTextField.setEditable(false);
        priceTextField.setEditable(false);

    }


    private Pizza getPizzaType(String pizzaType, PizzaFactory pizza) {
        switch(pizzaType){
            case "Meatzza" -> {
                return pizza.createMeatzza();
            }
            case "Build Your Own" -> {
                return pizza.createBuildYourOwn();
            }
            case "BBQ Chicken" -> {
                return pizza.createBBQChicken();
            }
            case "Deluxe" -> {
                return pizza.createDeluxe();
            }

        }
        return null;

    }

    private void addToppings(Pizza pizza){


    }

    @FXML
    public void updateGuiOnChoiceBox(javafx.scene.input.MouseEvent event){
        if(pizzaTypeChoiceBox.getValue().equals("Meatzza")) {
            CrustTextField.setText("Stuffed");
            toppingsListView.setDisable(true);
        }

        if(pizzaTypeChoiceBox.getValue().equals("Build Your Own")) {
            CrustTextField.setText("Pan");
            toppingsListView.setDisable(false);
        }

        if(pizzaTypeChoiceBox.getValue().equals("BBQ Chicken")) {
            CrustTextField.setText("Pan");
            toppingsListView.setDisable(true);
        }
        if(pizzaTypeChoiceBox.getValue().equals("Deluxe")) {
            CrustTextField.setText("Deep Dish");
            toppingsListView.setDisable(true);
        }
    }

    @FXML
    public void updatePrice(javafx.scene.input.MouseEvent event){
        if (smallRadioButton.isSelected()) {
            if(pizzaTypeChoiceBox.getValue().equals("Meatzza")) {
                priceTextField.setText("17.99");
            }
            else if(pizzaTypeChoiceBox.getValue().equals("Build Your Own")) {
                priceTextField.setText("8.99");
            }
            else if(pizzaTypeChoiceBox.getValue().equals("BBQ Chicken")) {
                priceTextField.setText("14.99");
            }
            else if(pizzaTypeChoiceBox.getValue().equals("Deluxe")) {
                priceTextField.setText("16.99");
            }
        }
        else if (mediumRadioButton.isSelected()) {
            if(pizzaTypeChoiceBox.getValue().equals("Meatzza")) {
                priceTextField.setText("19.99");
            }
            else if(pizzaTypeChoiceBox.getValue().equals("Build Your Own")) {
                priceTextField.setText("10.99");
            }
            else if(pizzaTypeChoiceBox.getValue().equals("BBQ Chicken")) {
                priceTextField.setText("16.99");
            }
            else if(pizzaTypeChoiceBox.getValue().equals("Deluxe")) {
                priceTextField.setText("18.99");
            }
        }
        else if (largeRadioButton.isSelected()) {
            if(pizzaTypeChoiceBox.getValue().equals("Meatzza")) {
                priceTextField.setText("21.99");
            }
            else if(pizzaTypeChoiceBox.getValue().equals("Build Your Own")) {
                priceTextField.setText("10.99");
            }
            else if(pizzaTypeChoiceBox.getValue().equals("BBQ Chicken")) {
                priceTextField.setText("19.99");
            }
            else if(pizzaTypeChoiceBox.getValue().equals("Deluxe")) {
                priceTextField.setText("20.99");
            }
        }
    }





    @FXML
    public void placeOrder(javafx.scene.input.MouseEvent event) throws IOException {

        PizzaFactory pizzaFactory = new ChicagoPizza();
        String pizzaType = pizzaTypeChoiceBox.getValue().toString();

        if (pizzaType.equals("Build Your Own")) {

        }
        Pizza pizza = getPizzaType(pizzaType, pizzaFactory);
        if (smallRadioButton.isSelected()) {
            pizza.setSize(Size.SMALL);
        } else if (mediumRadioButton.isSelected()) {
            pizza.setSize(Size.MEDIUM);
        } else if (largeRadioButton.isSelected()) {
            pizza.setSize(Size.LARGE);
        }
        pizzasArrayList.add(pizza);

        OrdersPlacedWindow.order.addPizza(pizza);
    }


}
