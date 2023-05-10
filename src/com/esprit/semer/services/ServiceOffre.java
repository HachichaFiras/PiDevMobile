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
import com.esprit.semer.entities.Offre;
import com.esprit.semer.utils.Statics;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Farah
 */
public class ServiceOffre {

 
    public ArrayList<Offre> offres;
    
    public static ServiceOffre instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceOffre() {
         req = new ConnectionRequest();
    }

    public static ServiceOffre getInstance() {
        if (instance == null) {
            instance = new ServiceOffre();
        }
        return instance;
    }

//titre=faaaa&description=appppp&etat=active&owner=6
   

    public boolean addOffre(Offre f) {
        String url = Statics.BASE_URL + "/addOffre/new"+"?" +"titre="+f.getTitre() + "&" +"description=" + f.getDescription()+ "&" +"etat="+ f.getEtat()+ "&" +"onwer="+ f.getOwner();
        req.setUrl(url);
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
    
    public ArrayList<Offre> parseOffres(String jsonText){
        try {
            offres=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Offre f = new Offre();
                float id = Float.parseFloat(obj.get("id").toString());
               f.setId((int)id);
               
               f.setTitre(((String)(obj.get("titre").toString())));
                f.setEtat(((String)(obj.get("etat").toString())));
               f.setDatecreation(((String)(obj.get("datecreation").toString())));
                f.setDescription(((String)(obj.get("description").toString())));
              
              
               offres.add(f);
            }
            
            
        } catch (IOException ex) {
            
        }
        return offres;
    }
    
    public ArrayList<Offre> getAllTasks(){
        String url = Statics.BASE_URL+"/offre/api";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                offres = parseOffres(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return offres;
    }
    public boolean modifierOffre(Offre o) {
        String url = Statics.BASE_URL+ "/offre/api/"+o.getId()+"?"+"&titre=" + o.getTitre()+ "&description=" + o.getDescription()+ "&etat=" + o.getEtat()+ "&owner=" + o.getOwner();

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
        String url = Statics.BASE_URL +"offre/delete/"+id;
        
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

