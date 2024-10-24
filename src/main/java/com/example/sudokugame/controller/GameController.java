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

/**
 * The GameController class manages the logic and interactions for the Sudoku game.
 * It controls the main game interface and handles user actions such as inserting numbers,
 * providing help, and resetting the game.
 */
public class GameController {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnHelp;
    @FXML
    private GridPane gridPaneSudoku;

    private Board board;
    private int helpCount = 0; // Counter to track the number of help requests
    private static final int MAX_HELP = 5; // Maximum number of help attempts allowed

    private Button activeButton = null;

    /**
     * Initializes the game board and user interface. Sets up event handlers for buttons
     * and populates the Sudoku grid with input fields for user interaction.
     */
    @FXML
    public void initialize() {
        board = new Board();
        btnHelp.setText("Ayuda (" + (MAX_HELP - helpCount) + ")");

        btnDelete.setOnAction(event -> activeButton = btnDelete);

        int[][] boardIncomplete = board.getBoardIncomplete();
        int[][] copyBoardIncomplete = new int[6][6];

        for (int i = 0; i < 6; i++) {
            System.arraycopy(boardIncomplete[i], 0, copyBoardIncomplete[i], 0, 6);
        }

        // Populate the Sudoku grid with TextFields
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                String id = String.valueOf(i).concat(String.valueOf(j));
                TextFieldAdder textFieldAdder = new TextFieldAdder(id);
                TextField textField = textFieldAdder.getTextField();
                textField.setId(id);

                // Handle cell clicks and delete button interaction
                textField.setOnMouseClicked(event -> {
                    if (textField.getText().contains(" ")) {
                        textField.setEditable(true);
                    }
                    if (activeButton != null && activeButton.equals(btnDelete)) {
                        textField.setText(" ");
                        textField.setStyle("-fx-background-color: white;");
                        activeButton = null;
                    }
                });

                // Handle user input in the Sudoku cells
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
                        }
                    } else {
                        textField.setText(" ");
                        eventK.consume();
                    }
                });

                // Initialize the board with predefined numbers or empty spaces
                if (copyBoardIncomplete[i][j] == 0) {
                    textField.setText(" ");
                } else {
                    textField.setText(String.valueOf(boardIncomplete[i][j]));
                    textField.setStyle("-fx-background-color: #eaeaea;");
                }

                gridPaneSudoku.add(textField, j, i);
            }
        }

        btnHelp.setOnAction(event -> provideHelp(board.getBoardSolution(), copyBoardIncomplete));
    }

    /**
     * Provides a hint to the player by randomly filling in one of the empty cells.
     * The number of hints is limited by {@code MAX_HELP}.
     *
     * @param boardComplete     The completed solution of the Sudoku board.
     * @param copyBoardIncomplete The current state of the incomplete board being played.
     */
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
            chosenField.setStyle("-fx-background-color: #d2f1f5;");
            copyBoardIncomplete[row][col] = correctValue;

            helpCount++;
            btnHelp.setText("Ayuda (" + (MAX_HELP - helpCount) + ")");
        }
    }

    /**
     * Handles the event when the "Restart Game" button is clicked. Resets the Sudoku board and help counter.
     *
     * @param event The action event triggered by the button click.
     */
    @FXML
    void onHandleButtonRestartGame(ActionEvent event) {
        board = new Board();
        activeButton = null;
        helpCount = 0;
        gridPaneSudoku.getChildren().clear();
        initialize();
        btnHelp.setText("Ayuda (" + (MAX_HELP - helpCount) + ")");
    }

    /**
     * Displays a how-to-play guide for the user when the "How To Play" button is clicked.
     *
     * @param event The action event triggered by the button click.
     */
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
