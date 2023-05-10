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
public class Message {
    private int id;
    private Utilisateur source;
    private Utilisateur destinataire;
    private String contenu;
    

    public Message(Utilisateur source, Utilisateur destinataire, String contenu) {
        this.source = source;
        this.destinataire = destinataire;
        this.contenu = contenu;
    }

    public Message(int id, Utilisateur source, Utilisateur destinataire, String contenu) {
        this.id = id;
        this.source = source;
        this.destinataire = destinataire;
        this.contenu = contenu;
    }

    public String getContenu() {
        return contenu;
    }

 

    public Utilisateur getDestinataire() {
        return destinataire;
    }

    public int getId() {
        return id;
    }

    public Utilisateur getSource() {
        return source;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

  

    public void setDestinataire(Utilisateur destinataire) {
        this.destinataire = destinataire;
    }

    public void setSource(Utilisateur source) {
        this.source = source;
    }

 
    
    
    
    
    
    
    
    
}
