/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.semer.gui.offre;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextComponent;
import com.codename1.ui.layouts.BoxLayout;
import com.esprit.semer.entities.Offre;


/**
 *
 * @author Farah
 */
public class DetailOffreForm extends Form {
     public DetailOffreForm(Offre ev,Form previous) {
         Container cnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
         Label titre = new Label("Titre : "+ev.getTitre());
Label datecreation = new Label("date de création : "+ev.getDatecreation());
  Label etat = new Label("Etat : "+ev.getEtat());
SpanLabel  description = new SpanLabel ("description : "+ev.getDescription());
//Label  owner = new Label ("owner : "+ev.getOwner());
cnt.add(titre);

cnt.add(datecreation);
cnt.add(etat);
cnt.add(description);
//cnt.add(owner);

add(cnt);
getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.show());
     }

  
}
