/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.uikit.pheonixui.entity;

import java.util.List;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
/**
 *
 * @author Asus
 */
public class Blog {
    private int id;
    private String title;
    private String contenu;
    private String dateCreation;

    private  Utilisateur actor;
    
    private List<Comments> commentaires;

    public Blog() {
    }

    
    
    public Blog(int id, String title, String contenu, Utilisateur actor, List<Comments> commentaires) {
        this.id = id;
        this.title = title;
        this.contenu = contenu;
        this.actor = actor;
        this.commentaires = commentaires;
    }

   public Blog(int id, String title, String contenu, Utilisateur actor) {
        this.id = id;
        this.title = title;
        this.contenu = contenu;
        this.actor = actor;
     
    }

    public Utilisateur getActor() {
        return actor;
    }

    public List<Comments> getCommentaires() {
        return commentaires;
    }

    public String getContenu() {
        return contenu;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

 
    public String getTitle() {
        return title;
    }

    public void setActor(Utilisateur actor) {
        this.actor = actor;
    }

    public void setCommentaires(List<Comments> commentaires) {
        this.commentaires = commentaires;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

   
   

    public void setTitle(String title) {
        this.title = title;
    }



    
    
    
    
    
   
    
    
}
