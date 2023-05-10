package com.esprit.semer.gui;

import com.codename1.components.InteractionDialog;
import com.codename1.ui.*;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.esprit.semer.gui.GestionRapport;
import com.esprit.semer.services.RapportService;
import com.ipmobile.entities.Rapport;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ShowAll extends Form {

    Form previous;

    public static Rapport currentRapport = null;
    Button addBtn;

    TextField searchTF;
    ArrayList<Component> componentModels;


    public ShowAll(Form previous) {
        super("Rapport", new BoxLayout(BoxLayout.Y_AXIS));
        this.previous = previous;

        addGUIs();
        addActions();

        super.getToolbar().addMaterialCommandToLeftBar("  ", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
    }

    public void refresh() {
        this.removeAll();
        addGUIs();
        addActions();
        this.refreshTheme();
    }

    private void addGUIs() {
        addBtn = new Button("Ajouter");
        addBtn.setUIID("buttonWhiteCenter");
        this.add(addBtn);


        ArrayList<Rapport> listRapport = RapportService.getInstance().getAll();
        componentModels = new ArrayList<>();

        searchTF = new TextField("", "Chercher rapport par Type");
        searchTF.addDataChangedListener((d, t) -> {
            if (componentModels.size() > 0) {
                for (Component componentModel : componentModels) {
                    this.removeComponent(componentModel);
                }
            }
            componentModels = new ArrayList<>();
            for (Rapport rapport : listRapport) {
                if (rapport.getTitre().toLowerCase().startsWith(searchTF.getText().toLowerCase())) {
                    Component model = makeRapportModel(rapport);
                    this.add(model);
                    componentModels.add(model);
                }
            }
            this.revalidate();
        });
        this.add(searchTF);


        if (listRapport.size() > 0) {
            for (Rapport rapport : listRapport) {
                Component model = makeRapportModel(rapport);
                this.add(model);
                componentModels.add(model);
            }
        } else {
            this.add(new Label("Aucune donnée"));
        }
    }

    private void addActions() {
        addBtn.addActionListener(action -> {
            currentRapport = null;
            new GestionRapport(this).show();
        });

    }

    Label dateLabel, titreLabel, etatLabel, descriptionLabel ;


    private Container makeModelWithoutButtons(Rapport rapport) {
        Container reclamationModel = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        reclamationModel.setUIID("containerRounded");


        dateLabel = new Label("Date : " + new SimpleDateFormat("dd-MM-yyyy").format(rapport.getDateCreation()));
        dateLabel.setUIID("labelDefault");

        titreLabel = new Label("Titre : " + rapport.getTitre());
        titreLabel.setUIID("labelDefault");
        
          descriptionLabel = new Label("Description : " + rapport.getDescription());
        descriptionLabel.setUIID("labelDefault");

        etatLabel = new Label("Etat : " + rapport.getEtat());
        etatLabel.setUIID("labelDefault");

      


        reclamationModel.addAll(

                dateLabel, titreLabel, etatLabel, descriptionLabel
        );

        return reclamationModel;
    }

    Button editBtn, deleteBtn;
    Container btnsContainer;

    private Component makeRapportModel(Rapport rapport) {

        Container rapportModel = makeModelWithoutButtons(rapport);

        btnsContainer = new Container(new BorderLayout());
        btnsContainer.setUIID("containerButtons");

        editBtn = new Button("Modifier");
        editBtn.setUIID("buttonWhiteCenter");
        editBtn.addActionListener(action -> {
            currentRapport = rapport;
            new GestionRapport(this).show();
        });

        deleteBtn = new Button("Supprimer");
        deleteBtn.setUIID("buttonWhiteCenter");
        deleteBtn.addActionListener(action -> {
            InteractionDialog dlg = new InteractionDialog("Confirmer la suppression");
            dlg.setLayout(new BorderLayout());
            dlg.add(BorderLayout.CENTER, new Label("Voulez vous vraiment supprimer ce reclamation ?"));
            Button btnClose = new Button("Annuler");
            btnClose.addActionListener((ee) -> dlg.dispose());
            Button btnConfirm = new Button("Confirmer");
            btnConfirm.addActionListener(actionConf -> {
                int responseCode = RapportService.getInstance().delete(rapport.getId());

                if (responseCode == 200) {
                    currentRapport = null;
                    dlg.dispose();
                    rapportModel.remove();
                    this.refreshTheme();
                } else {
                    Dialog.show("Erreur", "Erreur de suppression du rapport. Code d'erreur : " + responseCode, new Command("Ok"));
                }
            });
            Container btnContainer = new Container(new BoxLayout(BoxLayout.X_AXIS));
            btnContainer.addAll(btnClose, btnConfirm);
            dlg.addComponent(BorderLayout.SOUTH, btnContainer);
            dlg.show(800, 800, 0, 0);
        });

        btnsContainer.add(BorderLayout.WEST, editBtn);
        btnsContainer.add(BorderLayout.EAST, deleteBtn);


        rapportModel.add(btnsContainer);

        return rapportModel;
    }

}