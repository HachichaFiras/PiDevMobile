/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.entities.Offre;
import com.mycompany.services.OffreService;

/**
 *
 * @author bhk
 */
public class AddOffre extends Form{

    public AddOffre(Form previous) {
      setTitle("Add a new offre");
        setLayout(BoxLayout.y());
        
        TextField titre = new TextField("","Titre");
        TextField description = new TextField("","Description");
        TextField etat = new TextField("","Etat");
        TextField date = new TextField("","Date");
        Button btnValider = new Button("Add offre");
        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((titre.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                       
                        Offre o = new Offre(description.getText(), BRB_OTHER, N_RESIZE_CURSOR, titre.getText(), etat.getText(), date.getText());
                        if( OffreService.getInstance().addOffre(o))
                        {
                           Dialog.show("Success","Connection accepted",new Command("OK"));
                        }else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "etat must be a number", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
        
        addAll(titre,description,etat,date,btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
                
    }
    
    
}
