package com.example.messengerserver;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {


    @FXML
    private Button button_send;

    @FXML
    private VBox vbox_message;

    @FXML
    private TextField tf_message;

    @FXML
    private ScrollPane sp_main;


    private Server server;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try{
        server = new Server(new ServerSocket(1234));

    } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error creating server");

        }
        vbox_message.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                sp_main.setVvalue((double) t1);
            }
        });
    }