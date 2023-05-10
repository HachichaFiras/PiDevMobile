/*
 * Copyright (c) 2016, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */
package com.esprit.semer.gui;


import com.codename1.components.FloatingActionButton;
import com.codename1.components.MultiButton;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.esprit.semer.services.SessionManager;

/**
 * Represents a user profile in the app, the first form we open after the walkthru
 *
 * @author Shai Almog
 */
public class ProfileForm extends SideMenuBaseForm {
public ProfileForm(Resources res) {
        super(BoxLayout.y());
        Toolbar tb = getToolbar();
        tb.setTitleCentered(false);
        Image profilePic = res.getImage("user-picture.jpg");
        Image mask = res.getImage("round-mask.png");
        profilePic = profilePic.fill(mask.getWidth(), mask.getHeight());
        Label profilePicLabel = new Label(profilePic, "ProfilePicTitle");
        profilePicLabel.setMask(mask.createMask());

        Button menuButton = new Button("");
        menuButton.setUIID("Title");
     FontImage.setMaterialIcon(menuButton, FontImage.MATERIAL_MENU);
       menuButton.addActionListener(e -> getToolbar().openSideMenu());
       

        Container remainingTasks = BoxLayout.encloseY(
                        new Label("12", "CenterTitle"),
                        new Label("remaining tasks", "CenterSubTitle")
                );
        remainingTasks.setUIID("RemainingTasks");
        /*Container completedTasks = BoxLayout.encloseY(
                        new Label("32", "CenterTitle"),
                        new Label("completed tasks", "CenterSubTitle")
        );*/
        
        //completedTasks.setUIID("CompletedTasks");

        Container titleCmp = BoxLayout.encloseY(
                        FlowLayout.encloseIn(menuButton),
                        BorderLayout.centerAbsolute(
                                BoxLayout.encloseY(
                                    new Label(SessionManager.getLogin(), "Title"),
                                    new Label(SessionManager.getEmail(), "SubTitle")
                                )
                            ).add(BorderLayout.WEST, profilePicLabel)
                        
                );
        
        //FloatingActionButton fab = FloatingActionButton.createBadge("Update");
        //fab.getAllStyles().setMarginUnit(Style.UNIT_TYPE_PIXELS);
        //fab.getAllStyles().setMargin(BOTTOM, completedTasks.getPreferredH() - fab.getPreferredH() / 2);
        //tb.setTitleComponent(fab.bindFabToContainer(titleCmp, CENTER, BOTTOM));
        tb.add(BorderLayout.CENTER, titleCmp);
        //add(titleCmp);                
        /*TextField username = new TextField(user.getNom());
        username.setUIID("TextFieldBlack");
        addStringValue("Nom", username);*/
        Label nom = new Label(SessionManager.getNom());
        Label prenom = new Label(SessionManager.getPrenom() );
        Label adresse = new Label(SessionManager.getAdresse());
        add(BorderLayout.west(new Label("Nom :", "PaddedLabel")).
        add(BorderLayout.CENTER, nom));
        
        add(BorderLayout.west(new Label("Prenom :", "PaddedLabel")).
        add(BorderLayout.CENTER, prenom));
        
        add(BorderLayout.west(new Label("Adresse", "PaddedLabel")).
        add(BorderLayout.CENTER, adresse));
        
        
        Label num = new Label(String.valueOf(SessionManager.getNumTel()));
        add(BorderLayout.west(new Label("Numero :", "PaddedLabel")).
        add(BorderLayout.CENTER, num));
        
        Button btn = new Button("modifier");
        btn.addActionListener((e)-> {
            
            
            
            
            
            //new UpdateProfileForm(user,res).show();
        });
        add(btn);
        
        
        /*TextField email = new TextField(user.getPrenom());
        email.setUIID("TextFieldBlack");
        addStringValue("Prenom", email);
       
        TextField num = new TextField(user.getNumTel());
        email.setUIID("TextFieldBlack");
        addStringValue("Numero Tel ", num);
        
        TextField adresse = new TextField(user.getAdresse());
        email.setUIID("TextFieldBlack");
        addStringValue("Adresse", adresse);
        */
        //Button btn = new Button("Modifier profile");
        //add(btn);
        setupSideMenu(res);
    }
    private void addStringValue(String s, Component v) {
        add(BorderLayout.west(new Label(s, "PaddedLabel")).
                add(BorderLayout.CENTER, v));
    }
    
    private void addButtonBottom(Image arrowDown, String text, int color, boolean first) {
        MultiButton finishLandingPage = new MultiButton(text);
        finishLandingPage.setEmblem(arrowDown);
        finishLandingPage.setUIID("Container");
        finishLandingPage.setUIIDLine1("TodayEntry");
        finishLandingPage.setIcon(createCircleLine(color, finishLandingPage.getPreferredH(),  first));
        finishLandingPage.setIconUIID("Container");
        add(FlowLayout.encloseIn(finishLandingPage));
    }
    
    private Image createCircleLine(int color, int height, boolean first) {
        Image img = Image.createImage(height, height, 0);
        Graphics g = img.getGraphics();
        g.setAntiAliased(true);
        g.setColor(0xcccccc);
        int y = 0;
        if(first) {
            y = height / 6 + 1;
        }
        g.drawLine(height / 2, y, height / 2, height);
        g.drawLine(height / 2 - 1, y, height / 2 - 1, height);
        g.setColor(color);
        g.fillArc(height / 2 - height / 4, height / 6, height / 2, height / 2, 0, 360);
        return img;
    }

    @Override
    protected void showOtherForm(Resources res) {
        //new StatsForm(res).show();
    }
}
