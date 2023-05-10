package com.esprit.semer.utils;


import com.codename1.ui.Dialog;

import javafx.scene.control.Alert;
import org.joda.time.LocalDate;



public class DateTimeVerifier {

    // Méthode pour vérifier si une date est valide et supérieure à la date système
    public static boolean verifierDateTime(LocalDate date) {
        // Récupérer la date système
        LocalDate now = LocalDate.now();

        // Vérifier que la date saisie est supérieure à la date système
        if (date.isBefore(now)) {
           Dialog.show("La Date doit superieur de date d'aujourdhui","","Annuler", "OK");
        }

        return true;
    }

}
