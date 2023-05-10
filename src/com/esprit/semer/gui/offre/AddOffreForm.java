/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/
package com.esprit.semer.gui.offre;

import com.codename1.components.FloatingActionButton;
import com.codename1.components.ToastBar;
import com.codename1.io.rest.Rest;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import static com.codename1.ui.Component.BOTTOM;
import static com.codename1.ui.Component.CENTER;
import static com.codename1.ui.Component.LEFT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.util.Base64;
import com.esprit.semer.entities.Offre;
import com.esprit.semer.services.ServiceOffre;



import java.util.Map;


/**
 *
 * @author Farah
*/ 
public class AddOffreForm extends Form {
    
     public AddOffreForm(Form previous) {

           super(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
        setUIID("LoginForm");
           Container welcome = FlowLayout.encloseCenter(
                new Label("Welcome To, ", "WelcomeWhite"),
                new Label("LITO", "WelcomeBlue")
        );
        
      
        
        getTitleArea().setUIID("Container");
     
    //   add(new Label("Benevole ", "TodayTitle"));
      
        setLayout(BoxLayout.y());
        
        TextField tfTitre = new TextField("", "titre ",20, TextField.ANY);
        TextField tfDescription= new TextField("", "description",20, TextField.ANY);

         TextField tfEtat = new TextField("","etat",20, TextField.ANY);
        TextField tfOwner= new TextField("", "Owner",20, TextField.ANY);
       
        
           tfTitre.getAllStyles().setMargin(LEFT, 0);
        tfDescription.getAllStyles().setMargin(LEFT, 0);
          tfEtat.getAllStyles().setMargin(LEFT, 0);
        tfOwner.getAllStyles().setMargin(LEFT, 0);
    
           
             Button btnValider = new Button("Soummetre");
        btnValider.setUIID("LoginButton");
        
         /********************************************************** SMS **************************************/
       
  /*     btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
             com.codename1.io.rest.Response<Map> result = Rest.post("https://api.twilio.com/2010-04-01/Accounts/AC904083d7f5d44d1c6092cbaa73c672d0/Messages.json").
        queryParam("To", "+21623099545").
        queryParam("From","+15674093487").
        queryParam("Body", "Offre ajouté avec succée").
        header("Authorization", "Basic " + Base64.encodeNoNewline(("AC904083d7f5d44d1c6092cbaa73c672d0"+ ":" + "8d59c06f4578212c48d1ae0151c5e71c").getBytes())).
        getAsJsonMap();
        if(result.getResponseData() != null) {
        String error = (String)result.getResponseData().get("error_message");
            if(error != null) {
            ToastBar.showErrorMessage(error);
            }
        } 
        else {
        ToastBar.showErrorMessage("Error sending SMS: " + result.getResponseCode());
        }
            }
        });
        */
        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfTitre.getText().length()==0)||(tfDescription.getText().length()==0) ||(tfEtat.getText().length()==0 || tfOwner.getText().length()==0))
                    Dialog.show("Alert", "Remplir tout les champs", new Command("OK"));
                else
                {
                    try {
                        Offre f= new Offre( tfTitre.getText(), tfDescription.getText(),tfEtat.getText(),Integer.parseInt(tfOwner.getText()));
                        if( ServiceOffre.getInstance().addOffre(f))
                            Dialog.show("Success","Connection accepted",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "owner  must be a number", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
        
        addAll(tfTitre, tfDescription,tfEtat, tfOwner, btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
                
    }    
}