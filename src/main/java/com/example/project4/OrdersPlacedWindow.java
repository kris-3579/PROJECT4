package com.example.project4;

import javafx.beans.value.ChangeListener;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import src.Order;
import src.Pizza;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class OrdersPlacedWindow {

    public static ArrayList<Order> ordersPlaced = new ArrayList<>();

    @FXML
    ListView ordersPlacedListView = new ListView();

    @FXML
    ChoiceBox ordersChoiceBox = new ChoiceBox();

    @FXML
    TextField orderTotalTextField = new TextField();


    public void initialize() {


        for (Order order : ordersPlaced) {
            order.getNumber();
            ordersChoiceBox.getItems().add(order.getNumber());
        }
        


        ordersChoiceBox.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    try {
                        updateListView();
                        totalCost();

                    } catch (NullPointerException e) {
                        ordersChoiceBox.getSelectionModel().clearSelection();
                    }
                }
        );
    }

    public void updateListView() {
        ordersPlacedListView.getItems().clear();
        int index = (int) ordersChoiceBox.getSelectionModel().getSelectedItem();
        for (Order order : ordersPlaced) {
            if (index == order.getNumber()) {
                for (Pizza pizza : order.getPizzas()) {
                    ordersPlacedListView.getItems().add(pizza.toString());
                }

            }
        }

    }

    @FXML
    public void cancelOrder(javafx.scene.input.MouseEvent event) throws IOException {
        int index = (int) ordersChoiceBox.getSelectionModel().getSelectedItem();
        Iterator<Order> iterator = ordersPlaced.iterator(); // Create an iterator for the list
        while (iterator.hasNext()) {
            Order order = iterator.next();
            if (order.getNumber() == index) {
                iterator.remove(); // Safe removal
            }
        }

        ordersChoiceBox.getItems().clear();
        for (Order order : ordersPlaced) {
            order.getNumber();
            ordersChoiceBox.getItems().add(order.getNumber());
        }
    }

    private void totalCost(){
        double total = 0;
        int index = (int) ordersChoiceBox.getSelectionModel().getSelectedItem();
        Iterator<Order> iterator = ordersPlaced.iterator();
        while (iterator.hasNext()) {
            Order order = iterator.next();
            if (order.getNumber() == index) {
                for(Pizza p: order.getPizzas()) {
                    total += p.price();
                }
                break;
            }
        }

        total = Math.round((total + (total * 0.0625 )) * 100.0) / 100.0;
        orderTotalTextField.setText(String.valueOf(total));
    }
}






