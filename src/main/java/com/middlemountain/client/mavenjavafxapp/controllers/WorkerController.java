package com.middlemountain.client.mavenjavafxapp.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class WorkerController {
    public static int exist = -1;

    @FXML
    private Button createOrderAction;

    @FXML
    private Button getOrderAction;

    @FXML
    private Button creationJobCreateAction;

    @FXML
    private Button creationJobGetAction;

    @FXML
    private Label nameWorker;

    @FXML
    private Label infoWorker;

    @FXML
    private Button exitButtonAction;


    @FXML
    void initialize() {
        System.out.println(LoginController.loginUsername);
        nameWorker.setText(LoginController.employee.getName());
        createOrderAction.setOnAction(event -> {
            exist = 0;
            Stage oldStage = (Stage)createOrderAction.getScene().getWindow();
            oldStage.hide();
            Stage stage = new Stage();
            try {
                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("formForOrder.fxml"));
                stage.setTitle("Order");
                stage.setResizable(false);
                stage.setScene(new Scene(root));
                stage.initModality(Modality.WINDOW_MODAL);
                stage.initOwner(((Node)event.getSource()).getScene().getWindow());
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
            /*Stage oldStage = (Stage)createOrderAction.getScene().getWindow();
            oldStage.hide();
            Stage stage = new Stage();
            try {
                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("formForOrder.fxml"));
                stage.setTitle("Order");
                stage.setResizable(false);
                stage.setScene(new Scene(root));
                stage.initModality(Modality.WINDOW_MODAL);
                stage.initOwner(((Node)event.getSource()).getScene().getWindow());
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }*/

        });

        getOrderAction.setOnAction(event -> {
            exist = 1;
            Stage stage = new Stage();
            try {
                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("askForSearch.fxml"));
                stage.setTitle("Search");
                stage.setResizable(false);
                stage.setScene(new Scene(root));
                stage.initModality(Modality.WINDOW_MODAL);
                stage.initOwner(((Node)event.getSource()).getScene().getWindow());
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        creationJobCreateAction.setOnAction(event -> {
        });

        exitButtonAction.setOnAction(event -> {
            Controller controller = new Controller();
            controller.exitButton(exitButtonAction);
        });

    }

}