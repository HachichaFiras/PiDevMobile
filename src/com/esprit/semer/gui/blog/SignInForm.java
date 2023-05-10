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
package com.esprit.semer.gui.blog;

import com.esprit.semer.gui.*;
import com.codename1.ui.FontImage;
import com.codename1.ui.TextField;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.list.MultiList;
import com.esprit.semer.entities.Blog;
import com.esprit.semer.entities.Utilisateur;
import com.esprit.semer.services.ApiServices;
import com.esprit.semer.services.BlogService;
import com.esprit.semer.services.SessionManager;

import java.util.List;

/**
 * GUI builder created Form
 *
 * @author Shai Almog
 */
public class SignInForm extends com.codename1.ui.Form {

    public SignInForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public SignInForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        getTitleArea().setUIID("Container");
        getToolbar().setUIID("Container");
        getToolbar().getTitleComponent().setUIID("SigninTitle");
        FontImage mat = FontImage.createMaterial(FontImage.MATERIAL_CLOSE, "SigninTitle", 3.5f);
        getToolbar().addCommandToLeftBar("", mat, e -> new TrendingForm().show());
        getContentPane().setUIID("SignInForm");
    }

////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    protected com.codename1.ui.ComponentGroup gui_Component_Group_1 = new com.codename1.ui.ComponentGroup();
    protected com.codename1.ui.TextField gui_Text_Field_2 = new com.codename1.ui.TextField();
      protected com.codename1.ui.TextField gui_Text_Field_3 = new com.codename1.ui.TextField();
    protected com.codename1.ui.TextField gui_Text_Field_1 = new com.codename1.ui.TextField();
    protected com.codename1.ui.Button gui_Button_2 = new com.codename1.ui.Button();
        protected com.codename1.ui.Button gui_Button_0 = new com.codename1.ui.Button();

    protected com.codename1.ui.Button gui_Button_3 = new com.codename1.ui.Button();
    protected com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();
    


    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_Button_2.addActionListener(callback);
    }

    class EventCallbackClass implements com.codename1.ui.events.ActionListener, com.codename1.ui.events.DataChangedListener {
        private com.codename1.ui.Component cmp;
        public EventCallbackClass(com.codename1.ui.Component cmp) {
            this.cmp = cmp;
        }

        public EventCallbackClass() {
        }

        public void actionPerformed(com.codename1.ui.events.ActionEvent ev) {
            com.codename1.ui.Component sourceComponent = ev.getComponent();

            if(sourceComponent.getParent().getLeadParent() != null && (sourceComponent.getParent().getLeadParent() instanceof com.codename1.components.MultiButton || sourceComponent.getParent().getLeadParent() instanceof com.codename1.components.SpanButton)) {
                sourceComponent = sourceComponent.getParent().getLeadParent();
            }

            if(sourceComponent == gui_Button_2) {
                onButton_2ActionEvent(ev);
            }
        }

        public void dataChanged(int type, int index) {
        }
    }
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.BorderLayout());
        setInlineStylesTheme(resourceObjectInstance);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("Ajouter un Blog");
        setName("SignInForm");
        gui_Container_1.setScrollableY(true);
                gui_Container_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_1.setName("Container_1");
        gui_Button_1.setText("Ajouter bLog");
        gui_Button_1.setUIID("CenterLabel");
                gui_Button_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Button_1.setName("Button_1");
        addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_1);
        gui_Label_1.setUIID("CenterLabel");
                gui_Label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1.setName("Label_1");
         gui_Component_Group_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Component_Group_1.setName("Component_Group_1");
        gui_Button_2.setText("Ajouter");
                gui_Button_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Button_2.setName("Button_2");
         gui_Button_0.setText("Correcteur");
                gui_Button_0.setInlineStylesTheme(resourceObjectInstance);
        gui_Button_0.setName("Button_0");
        gui_Button_3.setUIID("CenterLabelSmall");
                gui_Button_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Button_3.setName("Button_3");
        gui_Container_1.addComponent(gui_Label_1);
        gui_Container_1.addComponent(gui_Component_Group_1);
        gui_Text_Field_2.setText("Titre");
                gui_Text_Field_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Text_Field_2.setName("Text_Field_2");
         gui_Text_Field_3.setHint("Text a corrigè");
                gui_Text_Field_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Text_Field_3.setName("Text_Field_3");
        gui_Text_Field_1.setText("Contenue");
                gui_Text_Field_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Text_Field_1.setName("Text_Field_1");
        gui_Component_Group_1.addComponent(gui_Text_Field_2);
        gui_Component_Group_1.addComponent(gui_Text_Field_1);
                gui_Component_Group_1.addComponent(gui_Text_Field_3);
        gui_Container_1.addComponent(gui_Button_0);

        gui_Container_1.addComponent(gui_Button_2);
        gui_Container_1.addComponent(gui_Button_3);
        addComponent(com.codename1.ui.layouts.BorderLayout.SOUTH, gui_Button_1);
        
               

        
        
      
        
        
        gui_Button_2.addActionListener((evt) -> {
            
             Utilisateur u =new Utilisateur();
                u.setId(SessionManager.getId());
            BlogService.getInstance().addBlog(new Blog(0, gui_Text_Field_2.getText() , gui_Text_Field_1.getText(),u));
       new TrendingForm().show();
        });
        gui_Button_0.addActionListener((evt) -> {
              StringBuilder stringBuilder = new StringBuilder();
        for (String s : ApiServices.getInstance().getCorrection(gui_Text_Field_3.getText())) {
            stringBuilder.append(s).append(" , ");
        }
        String stringResult = stringBuilder.toString().trim();
       gui_Text_Field_3.setText(stringResult);
            
        });
        
    }

    public void onButton_2ActionEvent(com.codename1.ui.events.ActionEvent ev) {
        
        
      
    }

}
