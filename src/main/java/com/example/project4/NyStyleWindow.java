package com.example.project4;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import src.*;

import java.io.IOException;

public class NyStyleWindow {
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



    public void initialize() {

        ObservableList<String> pizzaTypeList = FXCollections.observableArrayList("Meatzza", "Build Your Own", "BBQ Chicken", "Deluxe");
        pizzaTypeChoiceBox.setItems(pizzaTypeList);
        pizzaTypeChoiceBox.getSelectionModel().selectFirst();
        toppingsListView.setDisable(true);

        smallRadioButton.setToggleGroup(toggleServiceSize);
        mediumRadioButton.setToggleGroup(toggleServiceSize);
        largeRadioButton.setToggleGroup(toggleServiceSize);


        ObservableList<String> toppingsList = FXCollections.observableArrayList("SAUSAGE", "PEPPERONI", "GREEN PEPPER", "ONION", "MUSHROOM",
                "BBQ CHICKEN", "CHEDDAR", "PROVOLONE", "BEEF", "HAM");
        toppingsListView.getItems().addAll(toppingsList);

        toppingsListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        updateGuiOnChoiceBox();
        toppingsListView.getSelectionModel().getSelectedItems().addListener(
                (ListChangeListener<String>) change -> {
                    updatePrice();

                    if (toppingsListView.getSelectionModel().getSelectedItems().size() > 7) {
                        // Deselect the last selected item to maintain the limit
                        ObservableList<Integer> selectedIndices = toppingsListView.getSelectionModel().getSelectedIndices();
                        toppingsListView.getSelectionModel().clearSelection(selectedIndices.get(7));

                    }
                }
        );

        pizzaTypeChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            updateGuiOnChoiceBox();
            updatePrice();
        });

        toggleServiceSize.selectedToggleProperty().addListener((observable, oldToggle, newToggle) -> {
            if (newToggle != null) {
                updatePrice(); // Call the method to update the price
            }
        });

        CrustTextField.setEditable(false);
        priceTextField.setEditable(false);

    }






    public void updateGuiOnChoiceBox(){
        if(pizzaTypeChoiceBox.getValue().equals("Meatzza")) {
            CrustTextField.setText("Hand-tossed");
            toppingsListView.setDisable(true);
        }

        if(pizzaTypeChoiceBox.getValue().equals("Build Your Own")) {
            CrustTextField.setText("Hand-tossed");
            toppingsListView.setDisable(false);
        }

        if(pizzaTypeChoiceBox.getValue().equals("BBQ Chicken")) {
            CrustTextField.setText("Thin");
            toppingsListView.setDisable(true);
        }
        if(pizzaTypeChoiceBox.getValue().equals("Deluxe")) {
            CrustTextField.setText("Brooklyn");
            toppingsListView.setDisable(true);
        }
    }


    public void updatePrice(){
        if (smallRadioButton.isSelected()) {
            if(pizzaTypeChoiceBox.getValue().equals("Meatzza")) {
                priceTextField.setText("17.99");
            }
            else if(pizzaTypeChoiceBox.getValue().equals("Build Your Own")) {
                double price = 8.99 + toppingsListView.getSelectionModel().getSelectedItems().size() * 1.69;
                price =  Math.round(price * 100.0) / 100.0;
                priceTextField.setText(Double.toString(price));
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
                double price = 10.99 + toppingsListView.getSelectionModel().getSelectedItems().size() * 1.69;
                price =  Math.round(price * 100.0) / 100.0;
                priceTextField.setText(Double.toString(price));
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
                double price = 12.99 + toppingsListView.getSelectionModel().getSelectedItems().size() * 1.69;
                price =  Math.round(price * 100.0) / 100.0;
                priceTextField.setText(Double.toString(price));
            }
            else if(pizzaTypeChoiceBox.getValue().equals("BBQ Chicken")) {
                priceTextField.setText("19.99");
            }
            else if(pizzaTypeChoiceBox.getValue().equals("Deluxe")) {
                priceTextField.setText("20.99");
            }
        }
    }

    private void addToppingsToBYO(Pizza pizza){

        ObservableList<String> selectedItems = toppingsListView.getSelectionModel().getSelectedItems();

        for(String topping: selectedItems){
            switch(topping){
                case "SAUSAGE" -> {
                    pizza.addToppings(Topping.SAUSAGE);
                }
                case "PEPPERONI" -> {
                    pizza.addToppings(Topping.PEPPERONI);
                }
                case "GREEN PEPPER" -> {
                    pizza.addToppings(Topping.GREENPEPPER);
                }
                case "ONION" -> {
                    pizza.addToppings(Topping.ONION);
                }
                case "MUSHROOM" -> {
                    pizza.addToppings(Topping.MUSHROOM);
                }
                case "BBQ CHICKEN" -> {
                    pizza.addToppings(Topping.BBQCHICKEN);
                }
                case "CHEDDAR" -> {
                    pizza.addToppings(Topping.CHEDDAR);
                }
                case "PROVOLONE" -> {
                    pizza.addToppings(Topping.PROVOLONE);
                }
                case "BEEF" -> {
                    pizza.addToppings(Topping.BEEF);
                }
                case "HAM" -> {
                    pizza.addToppings(Topping.HAM);
                }
            }
        }


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


    @FXML
    public void placeOrder(javafx.scene.input.MouseEvent event) throws IOException {

        PizzaFactory pizzaFactory = new NYPizza();
        String pizzaType = pizzaTypeChoiceBox.getValue().toString();

        Pizza pizza = getPizzaType(pizzaType, pizzaFactory);

        if (pizzaType.equals("Build Your Own")) {
            this.addToppingsToBYO(pizza);
        }
        if (smallRadioButton.isSelected()) {
            pizza.setSize(Size.SMALL);
        } else if (mediumRadioButton.isSelected()) {
            pizza.setSize(Size.MEDIUM);
        } else if (largeRadioButton.isSelected()) {
            pizza.setSize(Size.LARGE);
        }

        CurrentOrderWindow.order.addPizza(pizza);
    }



}
