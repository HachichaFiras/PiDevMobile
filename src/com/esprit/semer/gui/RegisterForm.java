/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.semer.gui;

import com.codename1.ui.Button;
import static com.codename1.ui.Component.LEFT;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;

import com.codename1.ui.Form;
import com.codename1.ui.spinner.Picker;
import com.esprit.semer.entities.Utilisateur;
import com.esprit.semer.services.UtilisateurService;


/**
 *
 * @author ASUS
 */
public class RegisterForm extends Form{
    public RegisterForm(Resources theme) {
        super(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
        setUIID("LoginForm");
        Container welcome = FlowLayout.encloseCenter(
                new Label("Welcome to ", "WelcomeWhite"),
                new Label("Freelanci", "WelcomeBlue")
        );
        
        getTitleArea().setUIID("Container");
        
        //Image profilePic = theme.getImage("user-picture.jpg");
        //Image mask = theme.getImage("round-mask.png");
        //profilePic = profilePic.fill(mask.getWidth(), mask.getHeight());
        //Label profilePicLabel = new Label(profilePic, "ProfilePic");
        //profilePicLabel.setMask(mask.createMask());
        
        TextField login = new TextField("", "Login", 20, TextField.ANY); 
        TextField email = new TextField("", "Email", 20, TextField.EMAILADDR) ;
        TextField password = new TextField("", "Password", 20, TextField.PASSWORD) ;
        TextField nom = new TextField("", "Nom", 20, TextField.ANY) ;
        TextField prenom = new TextField("", "Prenom", 20, TextField.ANY) ;
        TextField adresse = new TextField("", "Adresse", 20, TextField.ANY) ;
        TextField num = new TextField("", "Numero ", 20, TextField.PHONENUMBER) ;
        

        login.getAllStyles().setMargin(LEFT, 0);
        email.getAllStyles().setMargin(LEFT, 0);
        password.getAllStyles().setMargin(LEFT, 0);
        nom.getAllStyles().setMargin(LEFT, 0);
        prenom.getAllStyles().setMargin(LEFT, 0);
        adresse.getAllStyles().setMargin(LEFT, 0);
        num.getAllStyles().setMargin(LEFT, 0);


        
        Label loginIcon = new Label("", "TextField");
        Label EmailIcon = new Label("", "TextField");
        Label passwordIcon = new Label("", "TextField");
        Label nomIcon = new Label("", "TextField");
        Label prenomIcon = new Label("", "TextField");
        Label adresseIcon = new Label("", "TextField");
        Label numTelIcon = new Label("", "TextField");

        
        loginIcon.getAllStyles().setMargin(RIGHT, 0);
        passwordIcon.getAllStyles().setMargin(RIGHT, 0);
        FontImage.setMaterialIcon(loginIcon, FontImage.MATERIAL_PERSON_OUTLINE, 3);
        FontImage.setMaterialIcon(passwordIcon, FontImage.MATERIAL_LOCK_OUTLINE, 3);
        
        Button RegisterButton = new Button("Register");
        RegisterButton.setUIID("LoginButton");
        RegisterButton.addActionListener(e -> {
            Utilisateur user = new Utilisateur();
            user.setEmail(email.getText());
            user.setNom(nom.getText());
            user.setPrenom(prenom.getText());
            user.setNumTel(Integer.valueOf(num.getText()));
            user.setAdresse(adresse.getText());
            user.setLogin(login.getText());
            user.setPassword(password.getText());
            
            UtilisateurService.getInstance().register(user);
            Dialog.show("Success","account is created","OK",null);
            new LoginForm(theme).show();
            /*Toolbar.setGlobalToolbar(false);
            new WalkthruForm(theme).show();
            Toolbar.setGlobalToolbar(true);*/
            
        });
        
        Button loginbtn = new Button("Already Have an account ");
        loginbtn.setUIID("CreateNewAccountButton");
        loginbtn.addActionListener((e)->{
        new LoginForm(theme).show();
        });
        // We remove the extra space for low resolution devices so things fit better
        Label spaceLabel;
        if(!Display.getInstance().isTablet() && Display.getInstance().getDeviceDensity() < Display.DENSITY_VERY_HIGH) {
            spaceLabel = new Label();
        } else {
            spaceLabel = new Label(" ");
        }
        
        
        Container by = BoxLayout.encloseY(
                welcome,
                //profilePicLabel,
                spaceLabel,
                BorderLayout.center(login).
                        add(BorderLayout.WEST, loginIcon),
                BorderLayout.center(email).
                        add(BorderLayout.WEST, EmailIcon),
                BorderLayout.center(nom).
                        add(BorderLayout.WEST, nomIcon),
                BorderLayout.center(prenom).
                        add(BorderLayout.WEST, prenomIcon),
                BorderLayout.center(adresse).
                        add(BorderLayout.WEST, adresseIcon),
                BorderLayout.center(num).
                        add(BorderLayout.WEST, numTelIcon),
                BorderLayout.center(password).
                        add(BorderLayout.WEST, passwordIcon),
                RegisterButton,
                loginbtn
        );
        add(BorderLayout.CENTER, by);
        
        // for low res and landscape devices
        by.setScrollableY(true);
        by.setScrollVisible(false);
    }
}
