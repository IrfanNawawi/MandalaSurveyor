package com.mandala.surveyor.ui.activity.login;

public interface LoginView {
    void displaySurveyor(String message);

    void displayTakstator(String message);

    void displayError(String message);

    void showProgress();

    void hideProgress();
}
