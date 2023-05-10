/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.uikit.pheonixui.entity;


/**
 *
 * @author Asus
 */
public class Comments {
    private int id;
    private Utilisateur freelancer;
    private String contenu;
   private Blog blog;
       private String dateCreation;


    public Comments( Utilisateur freelancer, String contenu, Blog blog) {
      
        this.freelancer = freelancer;
        this.contenu = contenu;
        this.blog = blog;
    }

    public Blog getBlog() {
        return blog;
    }

    public String getContenu() {
        return contenu;
    }

  
    public Utilisateur getFreelancer() {
        return freelancer;
    }

    public int getId() {
        return id;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }
    

  


    
    
    
    
}
