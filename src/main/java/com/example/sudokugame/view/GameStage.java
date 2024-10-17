package com.example.sudokugame.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GameStage extends Stage {

    public GameStage() throws IOException {
        FXMLLoader loader;
        loader = new FXMLLoader(getClass().getResource("/com/example/sudokugame/game-view-sudoku.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        setTitle("Sudoku 6x6");
        setResizable(false);
        setScene(scene);
        show();
    }
    public static GameStage getInstance() throws IOException {
        return  GameStageHolder.INSTANCE =new GameStage();
    }
    private static class GameStageHolder {
        private static GameStage INSTANCE;
    }
    public static  void deleteInstance (){
        GameStageHolder.INSTANCE.close();
        GameStageHolder.INSTANCE = null;
    }
}
