package com.ipmobile.entities;

import java.util.Date;

public class Rapport {

    private int id;
    private Date dateCreation;
    private String titre;
    private String etat;
    private String description;

    public Rapport() {
    }

    public Rapport(int id, Date dateCreation, String titre, String etat, String description) {
        this.id = id;
        this.dateCreation = dateCreation;
        this.titre = titre;
        this.etat = etat;
        this.description = description;
    }

    public Rapport(Date dateCreation, String titre, String etat, String description) {
        this.dateCreation = dateCreation;
        this.titre = titre;
        this.etat = etat;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Rapport{" + "id=" + id + ", dateCreation=" + dateCreation + ", titre=" + titre + ", etat=" + etat + ", description=" + description + '}';
    }

   

}