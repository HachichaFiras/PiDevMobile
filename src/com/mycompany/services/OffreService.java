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
import com.codename1.ui.events.ActionListener;
import com.mycompany.entities.Offre;
import com.mycompany.utils.Statics;
import com.mycompany.entities.Utilisateur;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
/**
 *
 * @author Farah
 */
public class OffreService {
    public ArrayList<Offre> offres;

    public static OffreService instance = null;
    public boolean resultOK;
    private ConnectionRequest req;

    private OffreService() {
        req = new ConnectionRequest();
    }

    public static OffreService getInstance() {
        if (instance == null) {
            instance = new OffreService();
        }
        return instance;
    }

   public boolean addOffre(Offre o) {

        String titre = o.getTitre();
        String description =  o.getDescription();
        String Date = o.getDate_creation();
        int etat = o.getEtat();
        int owner = o.getOwner();
        
        String url = Statics.BASE_URL+ "addOffre/new?titre=" + o.getTitre()+ "&description=" + o.getDescription()+ "&Date=" + o.getDate_creation()+ "&etat=" + o.getEtat();
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

    public ArrayList<Offre> parseOffre(String jsonText) {
        try {
            offres = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> offresListJson
                    = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) offresListJson.get("root");
            for (Map<String, Object> obj : list) {
                Offre o = new Offre();
                float id = Float.parseFloat(obj.get("id").toString());
                o.setId((int) id);
                String Date = obj.get("date").toString();
                o.setDate_creation(Date);
               //= t.setStatus(((int) Float.parseFloat(obj.get("status").toString())));
                if (obj.get("titre") == null) {
                //    t.setName("null");
                } else {
                   o.setTitre(obj.get("titre").toString());
                }
                offres.add(o);
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return offres;
    }

    public ArrayList<Offre> getAllOffre() {
        String url = Statics.BASE_URL+ "offre/api";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                offres = parseOffre(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return offres;
    }
      public boolean modifierOffre(Offre o) {
        String url = Statics.BASE_URL+ "/offre/api?titre=" + o.getTitre()+ "&description=" + o.getDescription()+ "&Date=" + o.getDate_creation()+ "&etat=" + o.getEtat();

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

 public boolean SupprimerOffre(Offre o) {
        String url = Statics.BASE_URL+ "/offre/delete/{id}";

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
}
