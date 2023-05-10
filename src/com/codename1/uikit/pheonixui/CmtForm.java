/*
 * Copyright (c) 2012, Codename One and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Codename One designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *  
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 * 
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 * 
 * Please contact Codename One through http://www.codenameone.com/ if you 
 * need additional information or have any questions.
 */

package com.codename1.uikit.pheonixui;

import com.codename1.capture.Capture;
import com.codename1.components.SpanLabel;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.system.NativeLookup;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.ComponentGroup;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.events.DataChangedListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.pheonixui.entity.Blog;
import com.codename1.uikit.pheonixui.entity.Comments;
import com.codename1.uikit.pheonixui.entity.Message;
import com.codename1.uikit.pheonixui.entity.Utilisateur;
import com.codename1.uikit.pheonixui.service.CommentsService;
import com.codename1.uikit.pheonixui.service.MessageService;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Demo of <a href="https://www.codenameone.com/">Codename One</a> inspired by the classic 
 * soundblaster demo and Apples imessage design. 
 * 
 * @author Shai Almog
 */
public class CmtForm {
    private String userName;
    private Image userPicture;
    private Form current;
    private TTS tts;
    private Resources theme;

    public void init(Object context) {
        theme = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);
        userPicture = theme.getImage("duke_iphone.png");
        tts = (TTS)NativeLookup.create(TTS.class);
    }

    public void start() {
        if (current != null) {
            current.show();
            return;
        }
        Form hi = new Form("Welcome", new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER));
        hi.setFormBottomPaddingEditingMode(true);
        final TextField name = new TextField("", "What Is Your Name?", 15, TextField.ANY);
        final Button btn = new Button("Take Photo");
        ComponentGroup cg = ComponentGroup.enclose(name, btn);
        btn.addActionListener(e -> {
            userPicture = captureRoundImage();
            btn.setIcon(userPicture);
        });
        hi.add(BorderLayout.CENTER, cg);
        Toolbar t = hi.getToolbar();
        t.addMaterialCommandToRightBar("", FontImage.MATERIAL_ARROW_FORWARD, 3.5f, e -> {
            userName = name.getText();
            if(userName.length() == 0) {
                userName = "[Unnamed]";
            }
           // showSbaitso();
        });
        hi.show();
    }

    private DataChangedListener createSearchListener(final TextField searchField, final Container discussion, final Button ask) {
        return (type, index) -> {
            String t = searchField.getText();
            int count = discussion.getComponentCount();
            if(t.length() == 0) {
                ask.setEnabled(true);
                for(Component c : discussion) {
                    c.setHidden(false);
                    c.setVisible(true);
                }
                animateChanage(discussion);
                return;
            }
            t = t.toLowerCase();
            ask.setEnabled(false);
            for(Component c : discussion) {
                SpanLabel tt = (SpanLabel)c;
                if(tt.getText().toLowerCase().indexOf(t) < 0) {
                    tt.setHidden(true);
                    tt.setVisible(false);
                } else {
                    tt.setHidden(false);
                    tt.setVisible(true);
                }
            }
            animateChanage(discussion);
        };        
    }
    
    private boolean animateLock;
    void animateChanage(Container discussion) {
        if(!animateLock) {
            animateLock = true;
            discussion.animateLayoutAndWait(300);
            animateLock = false;
        }
    }
    
    public void showSbaitso(int idd,Form previous) {
        Form sb = new Form(new BorderLayout());
        sb.setFormBottomPaddingEditingMode(true);
        Toolbar t = sb.getToolbar();
        final TextField searchField = new TextField("", "Message...", 20, TextField.ANY);
        t.setTitleComponent(searchField);
        final TextField ask = new TextField("", "Ask The Dr.", 20, TextField.ANY);
        Button askButton = new Button("Send");
        final Container discussion = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        
        sb.add(BorderLayout.SOUTH, BorderLayout.center(ask).
                    add(BorderLayout.EAST, askButton)).
                add(BorderLayout.CENTER, discussion);
        
        discussion.setScrollableY(true);

        sb.show();
        Display.getInstance().callSerially(() -> {
           
                List<Comments> cmt = CommentsService.getInstance().getAllComments(idd);
           
            for(Comments m : cmt)
            {
               
                                say(discussion, m.getFreelancer().getLogin()+" : " + m.getContenu(), false);
                                say(discussion, m.getDateCreation(), true);


             
            }

            if(tts != null && tts.isSupported()) {
                tts.say("error");
            }
        });
        searchField.addDataChangeListener(createSearchListener(searchField, discussion, askButton));
        ActionListener askEvent = (e) -> {
            String t1 = ask.getText();
            if (t1.length() > 0) {
                ask.setText("");
                say(discussion, t1, false);
                //answer(t1, discussion);
                CommentsService.getInstance().addCmt(new Comments(BaseForm.user, t1, new Blog(idd, null, null, null)));
               // MessageService.getInstance().addMsg(new Message(BaseForm.user,new Utilisateur(34), t1));
            }
        };
        ask.setDoneListener(askEvent);
        askButton.addActionListener(askEvent);
                sb.getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());

    }
    
 
    
     public void say(Container destination, String text, boolean question) {
        SpanLabel t = new SpanLabel(text);
        t.setWidth(destination.getWidth());
        t.setX(0);
        t.setHeight(t.getPreferredH());
        
        if(question) {
            t.setY(Display.getInstance().getDisplayHeight());
            t.setTextUIID("BubbleUser");
            t.setIconPosition(BorderLayout.EAST);
            t.setIcon(userPicture);
            t.setTextBlockAlign(Component.RIGHT);
        } else {
            t.setY(0);
            t.setTextUIID("BubbleSbaitso");
            t.setTextBlockAlign(Component.LEFT);
        }
        destination.add(t);
        destination.animateLayoutAndWait(400);
        destination.scrollComponentToVisible(t);
    }
    
    private Image roundImage(Image img) {
        int width = img.getWidth();
        Image roundMask = Image.createImage(width, width, 0xff000000);
        Graphics gr = roundMask.getGraphics();
        gr.setColor(0xffffff);
        gr.fillArc(0, 0, width, width, 0, 360);
        Object mask = roundMask.createMask();
        img = img.applyMask(mask);
        return img;
    }
    
    private Image captureRoundImage() {
        try {
            int width = userPicture.getWidth();
            String result = Capture.capturePhoto(width, -1);
            if(result == null) {
                return userPicture;
            }
            Image capturedImage = Image.createImage(result);
            if(capturedImage.getHeight() != width) {
                if(capturedImage.getWidth() < capturedImage.getHeight()) {
                    capturedImage = capturedImage.subImage(0, capturedImage.getHeight() / 2 - width / 2, width, width, false);
                } else {
                    Image n = Image.createImage(width, width);
                    n.getGraphics().drawImage(capturedImage, 0, width / 2- capturedImage.getHeight() / 2);
                    capturedImage = n;
                }
            }
            return roundImage(capturedImage);
        } catch (IOException err) {
            err.printStackTrace();
            return userPicture;
        }
    }

    public void stop() {
        current = Display.getInstance().getCurrent();
    }

    public void destroy() {
    }
    
    public void update(){
        String url = "http://example.com/updates";
String topic = "http://example.com/updates";

        ConnectionRequest request = new ConnectionRequest() {
    protected void readResponse(InputStream input) throws IOException {
        // handle the response
    }
};

        request.setUrl(url);
        request.setPost(false);
        request.addRequestHeader("Topic", topic);
        NetworkManager.getInstance().addToQueue(request);

    }
}
