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
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
