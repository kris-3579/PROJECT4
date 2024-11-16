package com.example.project4;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import src.Order;
import src.Pizza;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Iterator;

public class CurrentOrderWindow {

    static int index = 1;
    public static Order order = new Order(1);
    @FXML
    TextField ordersPlacedTextField = new TextField();

    @FXML
    public ListView<String> ordersPlacedListView = new ListView<>();

    @FXML
    TextField subtotalTextField = new TextField();


    @FXML
    TextField taxTextField = new TextField();

    @FXML
    TextField totalPriceTextField = new TextField();




    @FXML
    public void initialize() throws IOException {

        for (Pizza p : order.getPizzas()) {
            ordersPlacedListView.getItems().add(p.toString());
        }

        ordersPlacedListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        ordersPlacedTextField.setEditable(false);
        ordersPlacedTextField.setText(Integer.toString(index));

        outputPrice();
        ordersPlacedListView.getSelectionModel().getSelectedItems().addListener(
                (ListChangeListener<String>) change -> {
                    outputPrice();
                });
    }

    @FXML
    public void placeOrder(javafx.scene.input.MouseEvent event) throws IOException {
        OrdersPlacedWindow.ordersPlaced.add(order);
        index += 1;
        order = new Order(index);

        updateListView();

    }

    @FXML
    public void cancelOrder(javafx.scene.input.MouseEvent event) throws IOException {
        order.clearOrder();

        updateListView();
    }

    @FXML
    public void removePizza(javafx.scene.input.MouseEvent event) throws IOException {
        ObservableList<String> selectedItems = ordersPlacedListView.getSelectionModel().getSelectedItems();

        // Use an iterator to safely remove elements from the list while iterating
        Iterator<Pizza> iterator = order.getPizzas().iterator();
        while (iterator.hasNext()) {
            Pizza p = iterator.next();
            if (selectedItems.contains(p.toString())) {
                iterator.remove();  // Safe removal using the iterator
            }
        }

        // Update the ListView to reflect the changes
        updateListView();
    }

    public void updateListView(){

        ordersPlacedListView.getItems().clear();
        for (Pizza p: order.getPizzas()){
            ordersPlacedListView.getItems().add(p.toString());
        }

    }

    public void outputPrice() {
        double total = 0;
        for (Pizza p: order.getPizzas()){
            total += p.price();
        }
        subtotalTextField.setText(Double.toString(total));
        double tax = Math.round(total * 0.0625 * 100) / 100.0;
        taxTextField.setText(Double.toString(tax));

        total = Math.round((total + tax) * 100) / 100.0;
        totalPriceTextField.setText(Double.toString(total));
    }




}

