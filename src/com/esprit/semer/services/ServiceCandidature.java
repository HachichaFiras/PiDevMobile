/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.semer.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import static com.codename1.io.Log.p;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.esprit.semer.entities.Candidature;
import com.esprit.semer.utils.Statics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Farah
 */
public class ServiceCandidature {

    public static void getOneCandidature(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
    public ArrayList<Candidature> candidature;
    public Candidature farah;
    public static ServiceCandidature instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceCandidature() {
         req = new ConnectionRequest();
    }

    public static ServiceCandidature getInstance() {
        if (instance == null) {
            instance = new ServiceCandidature();
        }
        return instance;
    }

    public ArrayList<Candidature> parseCandidature(String jsonText){
        try {
            candidature =new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Candidature e = new Candidature();
                float id = Float.parseFloat(obj.get("id").toString());
                e.setId((int)id);
                e.setDatecreation(((String)(obj.get("datecreation").toString())));
              

                System.out.println(e);

               candidature.add(e);
            }
            
            
        } catch (IOException ex) {
            
        }
        return candidature;
    }
    
    
    
    public ArrayList<Candidature> getAllCandidature(){
        String url = Statics.BASE_URL+"/cand";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                candidature = parseCandidature(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return candidature;
    }
        public Candidature parseOneCandidature(String jsonText){
            Candidature e = new Candidature();
        try {

            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                
              float id = Float.parseFloat(obj.get("id").toString());
                e.setId((int)id);
                e.setDatecreation(((String)(obj.get("datecreation").toString())));

            }
            
            
        } catch (IOException ex) {
            
        }

        return e;
    }
    
}
