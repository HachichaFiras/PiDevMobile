/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import com.codename1.io.ConnectionRequest;
import java.util.ArrayList;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionListener;
import com.pidev.entities.Formation;
import com.mycompany.utils.statics;
import com.pidev.entities.Participation;
import com.pidev.entities.Utilisateur;
import com.pidevv.MyApplication;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.io.IOException; 



import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
/**
 *
 * @author 21624
 */
public class FormationService {
    public ArrayList<Formation> tasks;
       public ArrayList<Participation> task;
    public static FormationService instance = null;
    public boolean resultOK;
    private ConnectionRequest req;

    private FormationService() {
        req = new ConnectionRequest();
    }

    public static FormationService getInstance() {
        if (instance == null) {
            instance = new FormationService();
        }
        return instance;
    }

   public boolean addTask(Formation t) {

       
        
        String url = statics.Base_URL+ "Apiformation/add?titre=" + t.getTittre()+ "&description=" + t.getDescription()+ "&lienMeet=" + t.getLien_Meet()+ "&NbrMax=" + t.getNbre_max() + "&date=" +t.getDate()+"&idF="+MyApplication.user.getId();
       // String url = statics.Base_URL + "formation/api?titre=" + titre + "&" + status   + lien + "/" + nbr;

        req.setUrl(url);
        req.setPost(false);
        
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

    public ArrayList<Formation> parseTasks(String jsonText) {
        try {
            tasks = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson
                    = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");
            for (Map<String, Object> obj : list) {
                Formation t = new Formation();
              float id = Float.parseFloat(obj.get("id").toString());
             //  String titre = obj.get("titre").toString();
              t.setId((int) id);
               //t.setTittre(titre);
               // t.setStatus(((int) Float.parseFloat(obj.get("status").toString())));
                t.setTittre(obj.get("titre").toString());
               t.setDescription(obj.get("description").toString());
                t.setLien_Meet(obj.get("lienMeet").toString());
                
                t.setDate(obj.get("date").toString());
              
                tasks.add(t);
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return tasks;
    }

    public ArrayList<Formation> getAllTasks() {
        String url = statics.Base_URL+ "Apiformation/";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                tasks = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return tasks;
    }
    
      public boolean modifierReclamation(Formation t) {
        String url = statics.Base_URL+ "Apiformation/update/"+t.getId()+"?"+"&titre=" + t.getTittre()+ "&description=" + t.getDescription()+ "&lienMeet=" + t.getLien_Meet()+ "&NbrMax=" + t.getNbre_max();

        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200 ;  // Code response Http 200 ok
                req.removeResponseListener(this);
            }
        });
        
    NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha
    return resultOK;
        
    }
      //Delete 
    public boolean deleteFormation(int id ) {
        String url = statics.Base_URL +"Apiformation/delete/"+id;
        
        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                    
                    req.removeResponseCodeListener(this);
            }
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);
        return  resultOK;
    }
    //mes formations
    
     public ArrayList<Formation> MesFormations() {
      String url = statics.Base_URL+ "Apiformation/mes/"+MyApplication.user.getId();
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                tasks = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return tasks;
    }
    public boolean DetailFormation( Formation formation) {
        
        String url = statics.Base_URL+"Apiformation/"+formation.getId();
        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200 ;  // Code response Http 200 ok
                req.removeResponseListener(this);
            }
            
            
        });
         NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha
    return resultOK;
             
        
        
    }
      public boolean addParticipation(int t) {

        
        
        String url = statics.Base_URL+ "add-participation/" + t+ "/" + MyApplication.user.getId();
       // String url = statics.Base_URL + "formation/api?titre=" + titre + "&" + status   + lien + "/" + nbr;

        req.setUrl(url);
        req.setPost(false);
        
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
    
   //mes participations
    
     public ArrayList<Participation> MesParticipations() {
      String url = statics.Base_URL+ "mesp/"+MyApplication.user.getId();
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                task = parseParticipation(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return task;
    }
     //participationDetail 
        public ArrayList<Participation> parseParticipation(String jsonText) {
        try {
            task = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson
                    = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");
            for (Map<String, Object> obj : list) {
                Participation t = new Participation();
              float id = Float.parseFloat(obj.get("id").toString());
             
              t.setId((int) id);
               t.setDate_creation(obj.get("date").toString());
              task.add(t);
              
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return task;
    }
         public ArrayList<Participation> Participations(int t) {
      String url = statics.Base_URL+ ""+t;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                task = parseParticipation(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return task;
    }
         
          public void envoyerSms() {
      Twilio.init("AC9e5756eee95f7fb3d68d8432aa0d2d9d", "645815f51111c91607f823ddf3f94d08");

// Set the recipient phone number and message content
PhoneNumber to = new PhoneNumber("+21624949242");
PhoneNumber from = new PhoneNumber("+12762888654");
String messageText = "Your Participation a Ajouté avec succés ";

// Use the Twilio API to send the SMS message
Message message = Message.creator(to, from, messageText).create();
    }
            //Delete participation
    public boolean deleteParticipation(int id ) {
        String url = statics.Base_URL +"deleteP/"+id;
        
        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                    
                    req.removeResponseCodeListener(this);
            }
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);
        return  resultOK;
    }
}
