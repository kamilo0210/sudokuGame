package com.example.sudokugame.view.alert;

public interface IAlertBox {
    void showMessage(String title, String header, String content);

    void showMessageWinner(String title, String header, String content);

}