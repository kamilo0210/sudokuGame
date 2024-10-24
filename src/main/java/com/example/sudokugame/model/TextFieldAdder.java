package com.example.sudokugame.model;

import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

/**
 * The TextFieldAdder class is responsible for creating a pre-configured
 * {@link TextField} component with specific properties and styling for use in a Sudoku game.
 * Each instance of TextFieldAdder is associated with a unique ID, which corresponds
 * to a specific position in the Sudoku grid.
 */
public class TextFieldAdder {

    private String id;
    private TextField textField;

    /**
     * Constructs a TextFieldAdder with a specific ID.
     * Configures the TextField to be non-editable by default, sets its size, alignment,
     * background color, and border style to match the appearance needed for the Sudoku grid.
     *
     * @param id The unique identifier for the TextField, typically representing its position in the Sudoku grid.
     */
    public TextFieldAdder(String id) {
        this.id = id;
        textField = new TextField();
        textField.setEditable(false);
        textField.setMaxWidth(60);
        textField.setMaxHeight(60);
        textField.setAlignment(Pos.CENTER);
        textField.setStyle("-fx-background-color: #ffffff;");
        textField.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.DOTTED, CornerRadii.EMPTY, new BorderWidths(1))));  // Apply a dotted border.
    }

    /**
     * Returns the configured {@link TextField} component.
     *
     * @return The configured TextField component.
     */
    public TextField getTextField() {
        return textField;
    }

    /**
     * Gets the unique ID of this TextFieldAdder.
     *
     * @return The unique ID associated with this TextField.
     */
    public String getId() {
        return id;
    }
}


