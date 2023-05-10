/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import static com.codename1.push.PushContent.setTitle;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import static com.codename1.ui.Component.BRB_OTHER;
import static com.codename1.ui.Component.N_RESIZE_CURSOR;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.services.OffreService;
import com.mycompany.entities.Offre;


/**
 *
 * @author 21624
 */
public class UpdateOffre extends Form {
    
    public UpdateOffre(Form previous) {
        setTitle("Modifier offre");
//        setLayout(BoxLayout.y());
        
        TextField titre = new TextField("","Titre");
        TextField description = new TextField("","Description");
        TextField etat = new TextField("","Etat");
        TextField date = new TextField("","Date");
        Button btnValider = new Button("Add offre");
        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
              
                    try {
                       
                        Offre o = new Offre(description.getText(), BRB_OTHER, N_RESIZE_CURSOR, titre.getText(), etat.getText(), date.getText());
                        if( OffreService.getInstance().addOffre(o))
                        {
                           Dialog.show("Success","Connection accepted",new Command("OK"));
                        }else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    
                }
        });
        
       addAll(titre,description,etat,date,btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
                
    }

}
