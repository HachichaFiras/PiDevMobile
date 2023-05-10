/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

import java.util.List;

/**
 *
 * @author FARAH
 */

public class Offre {
    private int id, etat ;
    private String titre, description; 
    private String date_creation;
    private int owner;
    List <Candidature> candidatures ;

    public Offre(int etat, String titre, String description, String date_creation, int owner, List<Candidature> candidatures) {
        this.etat = etat;
        this.titre = titre;
        this.description = description;
        this.date_creation = date_creation;
        this.owner = owner;
        this.candidatures = candidatures;
    }


    public Offre(int id, int etat, String titre, String description, String date_creation, int owner) {
        this.id = id;
        this.etat = etat;
        this.titre = titre;
        this.description = description;
        this.date_creation = date_creation;
        this.owner = owner;
    }
  public Offre( int etat, String titre, String description, String date_creation, int owner) {
        this.etat = etat;
        this.titre = titre;
        this.description = description;
        this.date_creation = date_creation;
        this.owner = owner;
    }

    public Offre() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Offre(String text, int BRB_OTHER, int N_RESIZE_CURSOR, String text0, String text1, String text2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public String getDate_creation() {
        return date_creation;
    }

    public int getEtat() {
        return etat;
    }

    public int getOwner() {
        return owner;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate_creation(String date_creation) {
        this.date_creation = date_creation;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "offre{" + "id=" + id + ", titre=" + titre + ", description=" + description + ", date_creation=" + date_creation + ", etat=" + etat + ", owner=" + owner + '}';
    }

   
   
}  
