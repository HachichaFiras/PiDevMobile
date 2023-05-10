/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.uikit.pheonixui.service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.Log;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.codename1.uikit.pheonixui.entity.Blog;
import com.codename1.uikit.pheonixui.utils.Statics;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 *
 * @author Asus
 */
public class ApiServices {
    
 
    
    public ArrayList<String> rep;

    public static ApiServices instance = null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ApiServices() {
        req = new ConnectionRequest();
    }

    public static ApiServices getInstance() {
        if (instance == null) {
            instance = new ApiServices();
        }
        return instance;
    }
    
    public ArrayList<String> getReplacementsFromJson(String json) {
        try {
                        rep= new ArrayList<>();

            Map<String, Object> jsonMap = new JSONParser().parseJSON(new InputStreamReader(new ByteArrayInputStream(json.getBytes())));
            List<Map<String, Object>> matches = (List<Map<String, Object>>) jsonMap.get("matches");
            for (Map<String, Object> match : matches) {
                List<Map<String, Object>> replacements = (List<Map<String, Object>>) match.get("replacements");
                for (Map<String, Object> replacement : replacements) {
                    String value = (String) replacement.get("value");
                   rep.add(value);
                }
            }
        } catch (IOException ex) {
            Log.e(ex);
        }
        
        return rep;
    }
    
     public ArrayList<String> getCorrection(String text) {

String url ="https://languagetool.org/api/v2/check?language=fr&text="+text;
        req.setUrl(url);
        req.setPost(false);

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                
                rep = getReplacementsFromJson(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return rep;
    }
    
    
}
