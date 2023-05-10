/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.semer.gui.offre;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextComponent;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.esprit.semer.entities.Candidature;
import com.esprit.semer.entities.Offre;


/**
 *
 * @author Farah
 */
public class DetailCandidatureForm extends Form {
     public DetailCandidatureForm(Candidature ev,Form previous) {
         Container cnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
         Label id = new Label("id : "+ev.getId());
Label datecreation = new Label("datecreation : "+ev.getDatecreation());


cnt.add(id);
cnt.add(datecreation);


add(cnt);
getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.show());
     }

    DetailCandidatureForm(Offre prod, Form previous) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
