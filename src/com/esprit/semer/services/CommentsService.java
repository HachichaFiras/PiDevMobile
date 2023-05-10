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
import com.esprit.semer.entities.Comments;
import com.esprit.semer.entities.Utilisateur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Asus
 */
public class CommentsService {
    
        
    public ArrayList<Comments> comments;

    public static CommentsService instance = null;
    public boolean resultOK;
    private ConnectionRequest req;

    private CommentsService() {
        req = new ConnectionRequest();
    }

    public static CommentsService getInstance() {
        if (instance == null) {
            instance = new CommentsService();
        }
        return instance;
    }

      public ArrayList<Comments> parseTasks(String jsonText) {
        try {
            comments = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson
                    = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");
            for (Map<String, Object> obj : list) {
                
                
                float ids = Float.parseFloat(obj.get("id").toString());
            Map<String, Object> userObject = (Map<String, Object>) obj.get("user");
 Utilisateur u =new Utilisateur();
                u.setId(SessionManager.getId());
                u.setLogin(userObject.get("login").toString());
                Comments cmt = new Comments(u, obj.get("contenu").toString(), null);

                
                
                cmt.setDateCreation(obj.get("creationdate").toString());
                comments.add(cmt);
         
           }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return comments;
    }
      
         public boolean addCmt(Comments m) {

        
        
        String url = "http://127.0.0.1:8000/apiblog/cmt/new?blog="+m.getBlog().getId()+"&contenu="+m.getContenu()+"&user="+m.getFreelancer().getId();

        
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

    

    public ArrayList<Comments> getAllComments(int id) {
       

String url ="http://127.0.0.1:8000/apiblog/cmt/"+id;
        req.setUrl(url);
        req.setPost(false);

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                comments = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return comments;
    }
    
     
    
    
}
