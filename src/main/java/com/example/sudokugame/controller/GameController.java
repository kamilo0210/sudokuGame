package com.example.sudokugame.controller;


import com.example.sudokugame.model.Board;
import com.example.sudokugame.model.TextFieldAdder;
import com.example.sudokugame.view.alert.AlertBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class GameController {
    @FXML
    private Button btnDelete;


    @FXML
    private Button btnHelp;


    @FXML
    private GridPane gridPaneSudoku;


    private Board board;
    private int helpCount = 0;
    private static final int MAX_HELP = 5;


    private Button activeButton = null;


    @FXML
    public void initialize() {
        // Crear la instancia de Board que genera aleatoriamente un Sudoku
        board = new Board();


        btnDelete.setOnAction(event -> {
            activeButton = btnDelete;
            activeButton.setText(" ");
        });


        // Obtener los tableros incompleto y completo desde la instancia de Board
        int[][] boardIncomplete = board.getBoardIncomplete();
        int[][] copyBoardIncomplete = new int[6][6];


        // Copiar el tablero incompleto
        for (int i = 0; i < 6; i++) {
            System.arraycopy(boardIncomplete[i], 0, copyBoardIncomplete[i], 0, 6);
        }


        // Llenar el GridPane con los valores del tablero incompleto
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                String id = String.valueOf(i).concat(String.valueOf(j));
                TextFieldAdder textFieldAdder = new TextFieldAdder(id);
                TextField textField = textFieldAdder.getTextField();
                textField.setId(id);


                textField.setOnMouseClicked(event -> {
                    if (textField.getText().contains(" ")) {
                        textField.setEditable(true);
                    }
                    if (activeButton != null && activeButton.equals(btnDelete)) {
                        textField.setText(" ");
                    }
                });


                textField.setOnKeyTyped(eventK -> {
                    String input = eventK.getCharacter();
                    if (input.matches("[1-6]")) {
                        int row = Character.getNumericValue(id.charAt(0));
                        int col = Character.getNumericValue(id.charAt(1));
                        int correctValue = board.getBoardSolution()[row][col];
                        int enteredValue = Integer.parseInt(input);


                        if (enteredValue == correctValue) {
                            textField.setText(input);
                            copyBoardIncomplete[row][col] = enteredValue;
                        } else {
                            textField.setStyle("-fx-background-color: red;");
                            AlertBox alertBox = new AlertBox();
                            alertBox.showMessage("Error", "Número incorrecto", "El número ingresado no es correcto.");
                            textField.setText(" ");
                        }
                    } else {
                        textField.setText(" ");
                        eventK.consume();
                    }
                });


                // Configurar los TextFields en base al valor del tablero incompleto
                if (copyBoardIncomplete[i][j] == 0) {
                    textField.setText(" ");
                } else {
                    textField.setText(String.valueOf(boardIncomplete[i][j]));
                    textField.setStyle("-fx-background-color: #eaeaea;");
                }


                gridPaneSudoku.add(textField, j, i); // Colocar en la posición correcta (columna, fila)
            }
        }


        btnHelp.setOnAction(event -> provideHelp(board.getBoardSolution(), copyBoardIncomplete));
    }


    private void provideHelp(int[][] boardComplete, int[][] copyBoardIncomplete) {
        if (helpCount >= MAX_HELP) {
            AlertBox alertBox = new AlertBox();
            alertBox.showMessage("Ayuda", "Límite de ayuda alcanzado", "Ya has utilizado todas tus ayudas.");
            return;
        }


        List<TextField> emptyFields = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                String id = String.valueOf(i).concat(String.valueOf(j));
                TextField textField = (TextField) gridPaneSudoku.lookup("#" + id);
                if (copyBoardIncomplete[i][j] == 0) {
                    emptyFields.add(textField);
                }
            }
        }


        if (!emptyFields.isEmpty()) {
            Random random = new Random();
            TextField chosenField = emptyFields.get(random.nextInt(emptyFields.size()));
            int row = Character.getNumericValue(chosenField.getId().charAt(0));
            int col = Character.getNumericValue(chosenField.getId().charAt(1));


            int correctValue = boardComplete[row][col];
            chosenField.setText(String.valueOf(correctValue));
            chosenField.setStyle("-fx-background-color: #eaeaea;");
            copyBoardIncomplete[row][col] = correctValue;


            helpCount++;
        }
    }


    @FXML
    void onHandleButtonRestartGame(ActionEvent event) {
        // Reiniciar el juego creando una nueva instancia de Board
        board = new Board();
        activeButton = null;
        helpCount = 0;
        gridPaneSudoku.getChildren().clear();
        initialize();
    }


    @FXML
    void onHandleButtonHowToPlay(ActionEvent event) {
        String title = "Cómo Jugar";
        String header = "Tutorial";
        String content = "El juego de sudoku se juega de la siguiente manera: " +
                "\nHaz de insertar números del 1 al 6 de tal manera que completes el tablero" +
                " sin que los números se repitan en la columna, en la fila o en el recuadro 2x3 en el que está" +
                " ubicado.";
        AlertBox alertBox = new AlertBox();
        alertBox.showMessage(title, header, content);
    }
}
