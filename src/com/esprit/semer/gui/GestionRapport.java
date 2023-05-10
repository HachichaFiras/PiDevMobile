package com.esprit.semer.gui;


import com.codename1.ui.*;
import com.codename1.ui.layouts.BoxLayout;
import com.esprit.semer.services.RapportService;
import com.esprit.semer.utils.AlertUtils;
import com.ipmobile.entities.Rapport;

public class GestionRapport extends Form {


    Rapport currentRapport;

    TextField titreTF;
    TextField descriptionTF;
    TextField etatTF;

    

    TextField emailTF;
    Label titreLabel;
    Label etatLabel;

    Label emailLabel;
    Label descriptionLabel;
    PickerComponent dateTF;

    Button manageButton;

    Form previous;

    public GestionRapport(Form previous) {
        super(ShowAll.currentRapport == null ? "Ajouter" : "Modifier", new BoxLayout(BoxLayout.Y_AXIS));
        this.previous = previous;

        currentRapport = ShowAll.currentRapport;

        addGUIs();
        addActions();

        getToolbar().addMaterialCommandToLeftBar("  ", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
    }

    private void addGUIs() {


        dateTF = PickerComponent.createDate(null).label("Date");


        titreLabel = new Label("Titre : ");
        titreLabel.setUIID("labelDefault");
        titreTF = new TextField();
        titreTF.setHint("Tapez le titre");


        etatLabel = new Label("Etat : ");
        etatLabel.setUIID("labelDefault");
        etatTF = new TextField();
        etatTF.setHint("Tapez le etat");

        descriptionLabel = new Label("Description : ");
        descriptionLabel.setUIID("labelDefault");
        descriptionTF = new TextField();
        descriptionTF.setHint("Tapez le description");

        descriptionLabel = new Label("Description : ");
        descriptionLabel.setUIID("labelDefault");
        descriptionTF = new TextField();
        descriptionTF.setHint("Tapez le description");

        emailLabel = new Label("Email : ");
        emailLabel.setUIID("labelDefault");
        emailTF = new TextField();
        emailTF.setHint("Tapez le description");


        if (currentRapport == null) {


            manageButton = new Button("Ajouter");
        } else {
            dateTF.getPicker().setDate(currentRapport.getDateCreation());
            titreTF.setText(currentRapport.getTitre());
            descriptionTF.setText(currentRapport.getDescription());
            etatTF.setText(currentRapport.getEtat());



            manageButton = new Button("Modifier");
        }
        manageButton.setUIID("buttonWhiteCenter");

        Container container = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        container.setUIID("containerRounded");

        container.addAll(
                dateTF,
                titreLabel, titreTF,
                etatLabel, etatTF,
                descriptionLabel, descriptionTF,
                emailLabel, emailTF,
                manageButton
        );

        this.addAll(container);
    }

    private void addActions() {

        if (currentRapport == null) {
            manageButton.addActionListener(action -> {
                if (controleDeSaisie()) {
                    int responseCode = RapportService.getInstance().add(
                            new Rapport(
                                    dateTF.getPicker().getDate(),
                                    titreTF.getText(),
                                    etatTF.getText(),
                                    descriptionTF.getText()
                            ),
                            emailTF.getText()
                    );
                    if (responseCode == 200) {
                        AlertUtils.makeNotification("ajout ajouté avec succes");
                        showBackAndRefresh();
                    } else {
                        Dialog.show("Erreur", "Erreur d'ajout de rapport. Code d'erreur : " + responseCode, new Command("Ok"));
                    }
                }
            });
        } else {
            manageButton.addActionListener(action -> {
                if (controleDeSaisie()) {
                    int responseCode = RapportService.getInstance().edit(
                            new Rapport(
                                    currentRapport.getId(),
                                    dateTF.getPicker().getDate(),
                                    titreTF.getText(),
                                    etatTF.getText(),
                                    descriptionTF.getText()

                            )
                    );
                    if (responseCode == 200) {
                        AlertUtils.makeNotification("Rapport modifié avec succes");
                        showBackAndRefresh();
                    } else {
                        Dialog.show("Erreur", "Erreur de modification de rapport. Code d'erreur : " + responseCode, new Command("Ok"));
                    }
                }
            });
        }
    }

    private void showBackAndRefresh() {
        ((ShowAll) previous).refresh();
        previous.showBack();
    }

    private boolean controleDeSaisie() {


        if (dateTF.getPicker().getDate() == null) {
            Dialog.show("Avertissement", "Veuillez saisir la date", new Command("Ok"));
            return false;
        }


        if (titreTF.getText().equals("")) {
            Dialog.show("Avertissement", "Titre vide", new Command("Ok"));
            return false;
        }


        if (etatTF.getText().equals("")) {
            Dialog.show("Avertissement", "Etat vide", new Command("Ok"));
            return false;
        }


        if (descriptionTF.getText().equals("")) {
            Dialog.show("Avertissement", "Description vide", new Command("Ok"));
            return false;
        }


        return true;
    }
}