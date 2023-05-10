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
import com.esprit.semer.entities.Blog;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 *
 * @author Asus
 */
public class BlogService {
    
    
    public ArrayList<Blog> blogs;

    public static BlogService instance = null;
    public boolean resultOK;
    private ConnectionRequest req;

    private BlogService() {
        req = new ConnectionRequest();
    }

    public static BlogService getInstance() {
        if (instance == null) {
            instance = new BlogService();
        }
        return instance;
    }

      public ArrayList<Blog> parseTasks(String jsonText) {
        try {
            blogs = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson
                    = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");
            for (Map<String, Object> obj : list) {
                Blog t = new Blog();
                float id = Float.parseFloat(obj.get("id").toString());
                
                t.setId((int) id);
                t.setTitle(obj.get("title").toString());
                t.setContenu(obj.get("contenue").toString());
                t.setDateCreation(obj.get("datecreation").toString());
         
                blogs.add(t);
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return blogs;
    }
      
         public boolean addBlog(Blog t) {

        
        
        String url =  "http://127.0.0.1:8000/apiblog/new?title=" + t.getTitle()+ "&contenue=" + t.getContenu()+"&actor="+t.getActor().getId();

        
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

    

    public ArrayList<Blog> getAllTasks() {
       

String url ="http://127.0.0.1:8000/apiblog/get";
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
    }
    
       public ArrayList<Blog> getMyBlog(int id) {
       

String url =  "http://127.0.0.1:8000/apiblog/get/user/"+id;
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
    }
    
}
