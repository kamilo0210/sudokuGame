package com.example.sudokugame.view.alert;

import javafx.scene.control.Alert;

/**
 * The {@code AlertBox} class provides a simple utility to display informational alert messages to the user.
 * This class implements the {@link IAlertBox} interface and uses JavaFX's {@link Alert} to display messages.
 */
public class AlertBox implements IAlertBox {

    /**
     * Displays an informational alert box with a given title, header, and content.
     * The alert is modal, meaning it will block input to the rest of the application until closed.
     *
     * @param title   The title of the alert window.
     * @param header  The header text of the alert box.
     * @param content The main content or message to be displayed in the alert box.
     */
    @Override
    public void showMessage(String title, String header, String content) {
        // Create an informational alert.
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        // Set the title of the alert dialog window.
        alert.setTitle(title);

        // Set the header text of the alert dialog.
        alert.setHeaderText(header);

        // Set the content or the main message of the alert.
        alert.setContentText(content);

        // Display the alert and wait for user interaction before proceeding.
        alert.showAndWait();
    }
}
