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

    private String id;              // Unique identifier for the TextField, corresponding to its position in the grid.
    private TextField textField;    // The TextField component that is configured for the Sudoku game.

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
        textField.setEditable(false);                       // Set the text field to non-editable by default.
        textField.setMaxWidth(60);                         // Set maximum width to 60 pixels.
        textField.setMaxHeight(60);                        // Set maximum height to 60 pixels.
        textField.setAlignment(Pos.CENTER);                // Center the text within the text field.
        textField.setStyle("-fx-background-color: #ffffff;"); // Set the background color to white.
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


