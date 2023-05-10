package com.mycompany.utils;

import java.time.LocalDate;
import javafx.scene.control.Alert;



public class DateTimeVerifier {

    // Méthode pour vérifier si une date est valide et supérieure à la date système
    public static boolean verifierDateTime(LocalDate date) {
        // Récupérer la date système
        LocalDate now = LocalDate.now();

        // Vérifier que la date saisie est supérieure à la date système
        if (date.isBefore(now)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Date invalide");
            alert.setHeaderText(null);
            alert.setContentText("La date saisie doit être supérieure à la date système.");
            alert.showAndWait();
            return false;
        }

        return true;
    }
}
