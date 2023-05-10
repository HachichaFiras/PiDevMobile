/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.semer.gui.offre;

import com.codename1.components.MultiButton;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.esprit.semer.entities.Candidature;
import com.esprit.semer.services.ServiceCandidature;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author farah
 */
public class ListCandidatureForm extends Form{

    public ListCandidatureForm(Form previous) {
        setTitle("List des candidature");
     
     Container cnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
     for(Candidature ev :ServiceCandidature.getInstance().getAllCandidature()){
         MultiButton mb = new MultiButton(ev.getDatecreation());
        MultiButton resD = new MultiButton(ev.getDatecreation());
         
         mb.setTextLine3("Voir plus");
            resD.setTextLine4("supprimer");
         


     resD.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent evt) {
             ServiceCandidature.getOneCandidature(ev.getId());
             
             }

          
         });
                  mb.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent evt) {
             DetailCandidatureForm DEF =new DetailCandidatureForm(ev,previous);
             DEF.show();
             }
         });

         cnt.add(mb);
     }
     add(cnt);
     getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
    }

    
}
