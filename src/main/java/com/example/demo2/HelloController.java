package com.example.demo2;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

import java.security.Key;
import java.util.ArrayList;
import java.util.Random;

public class HelloController {

    @FXML
    private ImageView ball;

    @FXML
    private AnchorPane pane;

    @FXML
    private void initialize() {
        int count = 5;
        ArrayList<ImageView> balls = new ArrayList<>();

        Random rand = new Random();

        for (int i = 0; i < count; i++) {
            // Replace this URL with your own image
            String imagePath = "ball.jpg";
            Image image = new Image(getClass().getResource(imagePath).toExternalForm());
            ImageView imageView = new ImageView(image);

            // Set random position
            double x = rand.nextDouble() * (pane.getPrefWidth() - 50);
            double y = rand.nextDouble() * (pane.getPrefHeight() - 50);

            imageView.setLayoutX(x);
            imageView.setLayoutY(y);
            imageView.setFitWidth(50);
            imageView.setFitHeight(50);

            // Optionally, give each one an ID for debugging
            imageView.setId("image" + i);

            pane.getChildren().add(imageView);
            balls.add(imageView);
        }

        pane.setFocusTraversable(true);

        pane.sceneProperty().addListener((obs, oldScene, newScene) -> {
            if (newScene != null) {
                pane.requestFocus();
            }
        });


    }



    @FXML
    void onPressed(KeyEvent event) {

        if(event.getCode() == KeyCode.UP){
            ball.setY( ball.getY() - 20 );
            if( ball.getY() + ball.getFitHeight() < 0 ){
                ball.setY( pane.getHeight());
            }
        }
        else if( event.getCode() == KeyCode.DOWN){
            ball.setY( ball.getY() + 20 );
        }
        else if( event.getCode() == KeyCode.LEFT){
            ball.setX( ball.getX() - 20);
        }
        else if( event.getCode() == KeyCode.RIGHT){
            ball.setX( ball.getX() + 20 );
        }


    }



}
