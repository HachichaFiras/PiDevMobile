/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.semer.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.codename1.ui.util.Resources;
import com.esprit.semer.entities.Utilisateur;
import com.esprit.semer.gui.ProfileForm;
import static com.esprit.semer.utils.Statics.BASE_URL;
import java.util.Map;


/**
 *
 * @author ASUS
 */
public class UtilisateurService {
    public static UtilisateurService instance = null;
    private ConnectionRequest req;

    public static UtilisateurService getInstance() {
        if(instance == null){
            instance = new UtilisateurService();
            
        }
        return instance;
    }
    public UtilisateurService(){
        req = new ConnectionRequest();
    }
    
    
     public void login(String login,String password,Resources rs){
        String url=BASE_URL+"/json/login?login="+login+"&password="+password;
        System.out.println(url);
        req.setUrl(url);
        
        req.addResponseListener((e)-> {
            JSONParser j = new JSONParser();
            
            String json = new String(req.getResponseData()) + "";
            
            
            try {
            
            if(json.equals("failed")) {
                Dialog.show("Echec d'authentification","Username ou mot de passe éronné","OK",null);
            }
            else {
                //System.out.println("data =="+json);
                
                Map<String,Object> user = j.parseJSON(new CharArrayReader(json.toCharArray()));
                
                
             
                //Session 
                Double id = (double) user.get("id");
                //Float idf= id.floatValue();
                int idi = id.intValue();
                SessionManager.setId(idi);
                //jibt id ta3 user ly3ml login w sajltha fi session ta3i
                SessionManager.setPrenom(user.get("prenom").toString());
                SessionManager.setAdresse(user.get("adresse").toString());
                SessionManager.setPassowrd(user.get("password").toString());
                SessionManager.setNom(user.get("nom").toString());
                SessionManager.setEmail(user.get("email").toString());
                SessionManager.setLogin(user.get("login").toString());
                Double num = (double) user.get("numtel");
                int numi = num.intValue();
                
                SessionManager.setNumTel(numi);
                Double role = (double) user.get("role");
                int rolei = role.intValue();
                SessionManager.setRole(rolei);
                //SessionManager.setIsBlocked((boolean) user.get("isVerified"));
                //SessionManager.setIsBlocked((boolean) user.get("isBlocked"));
                
                //System.out.println(user.get("numTel"));
                //System.out.println("Current User ===> "+SessionManager.getNom());
                //User u = new User();
                /*u.setEmail(user.get("email").toString());
                u.setId(idi);
                u.setNom(user.get("nom").toString());
                u.setPrenom(user.get("prenom").toString());
                u.setAdresse(user.get("adresse").toString());
                Double numTelDouble = (Double) user.get("numTel");
                int numTel = numTelDouble.intValue();
                u.setNumTel(numTel);
                SessionManager.setNumTel(numTel);
                //u.setNumTel(Integer.parseInt(user.get("numTel").toString()));
                //u.setDateNaissance((Date) user.get("dateNaissance"));
                //String dateString = (String) user.get("dateNaissance");
                //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                //Date date = format.parse(dateString);
                .setDateNaissance(date);*/
                if(user.size() >0 ) // l9a user
                   // new ListReclamationForm(rs).show();//yemchi lel list reclamation
                    new ProfileForm(rs).show();
            }
            }catch(Exception ex) {
                ex.printStackTrace();
            }
            //String str = new String(req.getResponseData());
            //System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        
    }
    
    public void register(Utilisateur user){
        
        String url= BASE_URL+"/json/register?login="+user.getLogin()+"&email="+user.getEmail()+"&password="+
                user.getPassword()+"&nom="+user.getNom()+"&prenom="+user.getPrenom()+
                "&numTel="+user.getNumTel()+
                "&adresse="+user.getAdresse();
        
        req.setUrl(url);
        
        if(user.getLogin().equals("")&&user.getPassword().equals("")){
            Dialog.show("Erreur", "Veuillez remplir les champs ", "OK", null);
        }
        req.addResponseListener((e)->{
            byte[]data = (byte[]) e.getMetaData();
            String responseData = new String(data);
            System.out.println("data ===> "+responseData);
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
    }
    
    
    
}
