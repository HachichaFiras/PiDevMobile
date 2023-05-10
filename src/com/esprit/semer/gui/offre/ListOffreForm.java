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
import com.esprit.semer.entities.Offre;
import com.esprit.semer.services.ServiceOffre;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Farah
 */
public class ListOffreForm extends Form{

    public ListOffreForm(Form previous) {
        setTitle("List des offres");
     /*       Map<String,Object>[] data = new HashMap[100];
        SpanLabel sp = new SpanLabel();
        
        sp.setText(ServicOffre.getInstance().getAllProducts().toString());
        add(sp);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());*/
     Container cnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
     for(Offre offre :ServiceOffre.getInstance().getAllTasks()){
         MultiButton mb = new MultiButton(offre.getTitre());
        
         mb.setTextLine2("voir plus");
        
                  mb.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent evt) {
             DetailOffreForm DEF =new DetailOffreForm(offre,previous);
             DEF.show();
             }
         });
         cnt.add(mb);
     }
     add(cnt);
     getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
    }

    
}
