/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.FloatingHint;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;

import com.mycompany.services.FormationService;
import com.mycompany.utils.AlertUtils;
import com.pidev.entities.Formation;

/**
 *
 * @author Lenovo
 */
public class ModifierFormationForm extends BaseForm {
    
    Form current;
    public ModifierFormationForm(Resources res , Formation r) {
         super("Newsfeed",BoxLayout.y()); //herigate men Newsfeed w l formulaire vertical
    
        Toolbar tb = new Toolbar(true);
        current = this ;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Modifier Formation");
        getContentPane().setScrollVisible(false);
        
        
        super.addSideMenu(res);
        
        TextField objet = new TextField(r.getTittre() , "Titre" , 20 , TextField.ANY);
        TextField description = new TextField(r.getDescription() , "Description" , 20 , TextField.ANY);
               TextField etat = new TextField(String.valueOf(r.getLien_Meet()) , "Lien Meet" , 20 , TextField.ANY);
 
        //etat bch na3mlo comobbox bon lazm admin ya3mlleha approuver mais just chnwarikom ComboBox
        
       
        
       
        
        
        
        
        objet.setUIID("NewsTopLine");
        description.setUIID("NewsTopLine");
        etat.setUIID("NewsTopLine");
        
        objet.setSingleLineTextArea(true);
        description.setSingleLineTextArea(true);
        etat.setSingleLineTextArea(true);
        
        Button btnModifier = new Button("Modifier");
       btnModifier.setUIID("Button");
       
       //Event onclick btnModifer
       
       btnModifier.addPointerPressedListener(l ->   { 
           
           r.setTittre(objet.getText());
           r.setDescription(description.getText());
           
         
       
       //appel fonction modfier reclamation men service
       
       if(FormationService.getInstance().modifierReclamation(r)) {// if true
           
           new ListFormationForm(res).show();
             
                        AlertUtils.makeNotification("Formation Modifié avec succes");
                       // showBackAndRefresh();
                  
       }
        });
       Button btnAnnuler = new Button("Annuler");
       btnAnnuler.addActionListener(e -> {
           new ListFormationForm(res).show();
       });
       
       
       Label l2 = new Label("");
       
       Label l3 = new Label("");
       
       Label l4 = new Label("");
       
       Label l5 = new Label("");
       
        Label l1 = new Label();
        
        Container content = BoxLayout.encloseY(
                l1, l2, 
                new FloatingHint(objet),
                createLineSeparator(),
                new FloatingHint(description),
                createLineSeparator(),
               
                createLineSeparator(),//ligne de séparation
                btnModifier,
                btnAnnuler
                
               
        );
        
        add(content);
        show();
        
        
    }
   
}