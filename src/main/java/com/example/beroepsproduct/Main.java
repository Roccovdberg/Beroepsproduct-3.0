package com.example.beroepsproduct;

import com.example.beroepsproduct.screens.HelloApplications;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static int[] applicationSize = {1200, 650};

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
//        primaryStage.setTitle("MyTurn");
//        primaryStage.setWidth(applicationSize[0]);
//        primaryStage.setHeight(applicationSize[1]);
//        primaryStage.setResizable(false);
//
//        primaryStage.setScene(HelloApplications(primaryStage).getScene());
//
//        primaryStage.show();
        new HelloApplications(primaryStage);
    }

}
