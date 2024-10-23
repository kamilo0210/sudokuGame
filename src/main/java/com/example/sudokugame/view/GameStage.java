package com.example.sudokugame.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The {@code GameStage} class is responsible for initializing and managing the primary game window (stage)
 * for the 6x6 Sudoku game. It extends {@link Stage} to represent the window, and uses the Singleton pattern
 * to ensure that only one instance of the game stage is created.
 */
public class GameStage extends Stage {

    /**
     * Constructs a new {@code GameStage} object, loads the FXML layout for the Sudoku game,
     * and sets up the game window with its scene, title, and icon.
     *
     * @throws IOException if the FXML file for the game layout cannot be loaded.
     */
    public GameStage() throws IOException {
        // Load the FXML file for the Sudoku game view.
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/sudokugame/game-view-sudoku.fxml"));
        Parent root = loader.load();

        // Create a new scene with the loaded layout.
        Scene scene = new Scene(root);

        // Set the title of the window (stage).
        setTitle("Sudoku 6x6");

        // Set the window icon.
        getIcons().add(new Image(String.valueOf(getClass().getResource("/com/example/sudokugame/images/favicon.png"))));

        // Disable window resizing.
        setResizable(false);

        // Set the scene for this stage.
        setScene(scene);

        // Show the stage.
        show();
    }

    /**
     * Returns the singleton instance of {@code GameStage}.
     * If the instance does not exist, a new one will be created.
     *
     * @return the singleton instance of {@code GameStage}.
     * @throws IOException if an error occurs while creating the game stage.
     */
    public static GameStage getInstance() throws IOException {
        return GameStageHolder.INSTANCE = new GameStage();
    }

    /**
     * A static inner class that holds the singleton instance of {@code GameStage}.
     * This is part of the Singleton pattern implementation to lazily load the instance.
     */
    private static class GameStageHolder {
        private static GameStage INSTANCE;  // The singleton instance of GameStage.
    }

    /**
     * Closes the current instance of {@code GameStage} and sets it to {@code null},
     * effectively deleting the singleton instance. This allows for the game stage to be
     * created again if needed.
     */
    public static void deleteInstance() {
        if (GameStageHolder.INSTANCE != null) {
            GameStageHolder.INSTANCE.close();   // Close the current game stage.
            GameStageHolder.INSTANCE = null;    // Dereference the instance, allowing it to be recreated.
        }
    }
}
