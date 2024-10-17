package com.example.sudokugame.model;

import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;



public class TextFieldAdder {
    private String id;
    private TextField textField;


    public TextFieldAdder(String id) {
        this.id=id;
        textField = new TextField();
        textField.setEditable(false);
        textField.setMaxWidth(50);
        textField.setMaxHeight(50);
        textField.setAlignment(Pos.CENTER);
        textField.setStyle("-fx-background-color: #ffffff;");
        textField.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.DOTTED, CornerRadii.EMPTY, new BorderWidths(1))));
    }
    public TextField getTextField() {return textField;}


    public void setTextField(TextField textField) {this.textField = textField;}


    public String getId() {return id;}
    public void setId(String id) {this.id = id;}


}

