package com.example.sudokugame;

import com.example.sudokugame.view.GameStage;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main class of the application that launches the game.
 * Extends the JavaFX Application class to initialize the game's first stage.
 */
public class Main extends Application {

    /**
     * Main method that launches the JavaFX application.
     *
     * @param args Command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Starts the JavaFX application and displays the GameStage.
     *
     * @param primaryStage The primary stage for this application
     * @throws IOException If there is an issue loading the GameStage.
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        GameStage.getInstance();
    }
}

