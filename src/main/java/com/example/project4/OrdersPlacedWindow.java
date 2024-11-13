package com.example.project4;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import src.Order;
import src.Pizza;

import java.awt.*;

public class OrdersPlacedWindow {

    public static Order order = new Order();
    @FXML
    TextField ordersPlacedTextField;

    @FXML
    public ListView<String> ordersPlacedListView = new ListView<>();

    @FXML
    public void initialize() {





        for (Pizza p: order.getPizzas()){
            ordersPlacedListView.getItems().add(p.toString());
        }


    }
}
