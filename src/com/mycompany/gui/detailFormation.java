/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.FloatingHint;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;

import com.mycompany.services.FormationService;
import com.pidev.entities.Formation;

/**
 *
 * @author Lenovo
 */
public class detailFormation extends BaseForm {
    
    Form current;
    int b ;
    public detailFormation(Resources res , Formation r) {
         super("Newsfeed",BoxLayout.y()); 
    
        Toolbar tb = new Toolbar(true);
        current = this ;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Modifier Formation");
        getContentPane().setScrollVisible(false);
        
        
        super.addSideMenu(res);
        
         Label objet = new Label("Titre :" + r.getTittre() ,"NewsTopLine2");
        TextField description = new TextField(r.getDescription() , "Description" , 20 , TextField.ANY);
          TextField lien_meet = new TextField(r.getLien_Meet() , "Lien Meet" , 20 , TextField.ANY);
          
      
        
       
        
       
        
        
        
        
        objet.setUIID("NewsTopLine");
        description.setUIID("NewsTopLine");
        lien_meet.setUIID("NewsTopLine");
        
       // objet.setSingleLineTextArea(true);
        description.setSingleLineTextArea(true);
        lien_meet.setSingleLineTextArea(true);
        
        Button btnModifier = new Button("Participer");
       btnModifier.setUIID("Button");
       
       //Event onclick btnModifer
       
       btnModifier.addPointerPressedListener(l ->   { 
           
         r.setTittre(objet.getText());
          // r.setDescription(description.getText());
           b= r.getId(); 
         
       
       //appel fonction modfier reclamation men service
       
       if(FormationService.getInstance().addParticipation(b)) { // if true
          
          new ListFormationForm(res).show();
          FormationService.getInstance().envoyerSms();
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
                //  new FloatingHint(objet),
                 BoxLayout.encloseX(objet),
                createLineSeparator(),
                new FloatingHint(description),
                createLineSeparator(),
                new FloatingHint(lien_meet),
                createLineSeparator(),//ligne de séparation
                btnModifier,
                btnAnnuler
                
               
        );
        
        add(content);
        show();
        
        
    }
}