/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.uikit.pheonixui.service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.codename1.uikit.pheonixui.entity.Blog;
import com.codename1.uikit.pheonixui.entity.Utilisateur;
import com.codename1.uikit.pheonixui.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 *
 * @author Asus
 */
public class UserService {
    
    
    public ArrayList<Utilisateur> users;

    public static UserService instance = null;
    public boolean resultOK;
    private ConnectionRequest req;

    private UserService() {
        req = new ConnectionRequest();
    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

      public ArrayList<Utilisateur> parseUser(String jsonText) {
        try {
            users = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson
                    = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");
            for (Map<String, Object> obj : list) {
                float id = Float.parseFloat(obj.get("id").toString());
                Utilisateur u = new Utilisateur((int)id, obj.get("login").toString());

              
           
         
                users.add(u);
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return users;
    }
      
         public boolean addBlog(Blog t) {

        
        
        String url = Statics.BASE_URL + "/new?title=" + t.getTitle()+ "&contenue=" + t.getContenu()+"&actor="+t.getActor();

        
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

    

    public ArrayList<Utilisateur> getAllUsers(int ids) {
       

String url ="http://127.0.0.1:8000/apiblog/get/chat/"+ids;
        req.setUrl(url);
        req.setPost(false);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                users = parseUser(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return users;
    }
    
      /* public ArrayList<Blog> getMyBlog(int id) {
       

String url = Statics.BASE_URL + "/get/user/"+id;
        req.setUrl(url);
        req.setPost(false);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                blogs = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return blogs;
    }*/
    
}
