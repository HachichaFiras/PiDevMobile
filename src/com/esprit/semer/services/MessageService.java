/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.semer.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.esprit.semer.entities.Message;
import com.esprit.semer.entities.Utilisateur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Asus
 */
public class MessageService {
    
        
    public ArrayList<Message> messages;

    public static MessageService instance = null;
    public boolean resultOK;
    private ConnectionRequest req;

    private MessageService() {
        req = new ConnectionRequest();
    }

    public static MessageService getInstance() {
        if (instance == null) {
            instance = new MessageService();
        }
        return instance;
    }

      public ArrayList<Message> parseTasks(String jsonText) {
        try {
            messages = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson
                    = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");
            for (Map<String, Object> obj : list) {
                
                float ids = Float.parseFloat(obj.get("source").toString());
                float idd = Float.parseFloat(obj.get("dest").toString());
 Utilisateur u =new Utilisateur();
                u.setId(SessionManager.getId());
               Utilisateur u2 =new Utilisateur();
                u2.setId((int)idd);
                Message m = new Message( u, u2, obj.get("Contenu").toString());
                messages.add(m);
         
           }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return messages;
    }
      
         public boolean addMsg(Message m) {

        
        
        String url = "http://127.0.0.1:8000/apiblog/msg/new?idd="+m.getDestinataire().getId()+"&contenue="+m.getContenu()+"&ids="+m.getSource().getId();

        
        req.setUrl(url);
        req.setPost(true);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    

    public ArrayList<Message> getAllMessages(int idd,int ids) {
       

String url ="http://127.0.0.1:8000/apiblog/get/room/"+ids+"/"+idd;
        req.setUrl(url);
        req.setPost(false);

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                messages = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return messages;
    }
    
     
    
    
}
