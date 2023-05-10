package com.ipmobile.services;

import com.codename1.components.InfiniteProgress;
import com.codename1.io.*;
import com.codename1.ui.events.ActionListener;
import com.ipmobile.entities.Rapport;
import com.ipmobile.utils.Statics;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RapportService {

    public static RapportService instance = null;
    public int resultCode;
    private ConnectionRequest cr;
    private ArrayList<Rapport> listRapport;


    private RapportService() {
        cr = new ConnectionRequest();
    }

    public static RapportService getInstance() {
        if (instance == null) {
            instance = new RapportService();
        }
        return instance;
    }

    public ArrayList<Rapport> getAll() {
        listRapport = new ArrayList<>();

        cr = new ConnectionRequest();
        cr.setUrl(Statics.BASE_URL + "/rapport");
        cr.setHttpMethod("GET");
        cr.setPost(false);

        cr.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                if (cr.getResponseCode() == 200) {
                    listRapport = getList();
                }

                cr.removeResponseListener(this);
            }
        });

        try {
            cr.setDisposeOnCompletion(new InfiniteProgress().showInfiniteBlocking());
            NetworkManager.getInstance().addToQueueAndWait(cr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listRapport;
    }

    private ArrayList<Rapport> getList() {
        try {
            Map<String, Object> parsedJson = new JSONParser().parseJSON(new CharArrayReader(
                    new String(cr.getResponseData()).toCharArray()
            ));
            List<Map<String, Object>> list = (List<Map<String, Object>>) parsedJson.get("root");

            for (Map<String, Object> obj : list) {
                Rapport rapport = new Rapport(
                        (int) Float.parseFloat(obj.get("id").toString()),

                        new SimpleDateFormat("dd-MM-yyyy").parse((String) obj.get("date")),
                        (String) obj.get("titre"),
                        (String) obj.get("etat"),
                        (String) obj.get("description")

                );

                listRapport.add(rapport);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return listRapport;
    }

    public int add(Rapport rapport, String email) {
        return manage(rapport, false, email);
    }

    public int edit(Rapport rapport) {
        return manage(rapport, true, "");
    }

    public int manage(Rapport rapport, boolean isEdit, String email) {

        cr = new ConnectionRequest();


        cr.setHttpMethod("GET");
        cr.setPost(false);

        if (isEdit) {
            cr.setUrl(Statics.BASE_URL + "/rapport/edit");
            cr.addArgument("id", String.valueOf(rapport.getId()));
        } else {
            cr.setUrl(Statics.BASE_URL + "/rapport/add");
            cr.addArgument("email", String.valueOf(email));
        }

        cr.addArgument("date", new SimpleDateFormat("dd-MM-yyyy").format(rapport.getDateCreation()));
        cr.addArgument("titre", rapport.getTitre());
        cr.addArgument("etat", rapport.getEtat());
        cr.addArgument("description", rapport.getDescription());


        cr.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultCode = cr.getResponseCode();
                cr.removeResponseListener(this);
            }
        });
        try {
            cr.setDisposeOnCompletion(new InfiniteProgress().showInfiniteBlocking());
            NetworkManager.getInstance().addToQueueAndWait(cr);
        } catch (Exception ignored) {

        }
        return resultCode;
    }

    public int delete(int rapportId) {
        cr = new ConnectionRequest();
        cr.setUrl(Statics.BASE_URL + "/rapport/delete");
        cr.setHttpMethod("GET");
        cr.setPost(false);

        cr.addArgument("id", String.valueOf(rapportId));

        cr.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                cr.removeResponseListener(this);
            }
        });

        try {
            cr.setDisposeOnCompletion(new InfiniteProgress().showInfiniteBlocking());
            NetworkManager.getInstance().addToQueueAndWait(cr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cr.getResponseCode();
    }
}
