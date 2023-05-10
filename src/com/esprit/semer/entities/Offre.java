/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.semer.entities;

/**
 *
 * @author Farah
 */
public class Offre {
    
    int id; 
   
    String titre;
    String datecreation;
    String description;
    String etat;
    int owner;

    public Offre() {
    }

    public Offre(int id, String titre, String datecreation, String description, String etat, int owner) {
        this.id = id;
        this.titre = titre;
        this.datecreation = datecreation;
        this.description = description;
        this.etat = etat;
        this.owner= owner;
    }

    public Offre(int id, String titre, String description, String etat, int owner) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.etat = etat;
        this.owner = owner;
    }
      public Offre( String titre, String description, String etat, int owner) {
      
        this.titre = titre;
        this.description = description;
        this.etat = etat;
        this.owner = owner;
    }

    public Offre(String titre, String datecreation, String description, String etat) {
        this.titre = titre;
        this.datecreation = datecreation;
        this.description = description;
        this.etat = etat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(String datecreation) {
        this.datecreation = datecreation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }


    

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Offre{" + "id=" + id + ", titre=" + titre + ", datecreation=" + datecreation + ", description=" + description + ", etat=" + etat + ", owner=" + owner + '}';
    }

    
    
    
}
