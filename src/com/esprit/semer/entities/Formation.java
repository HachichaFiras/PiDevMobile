/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.semer.entities;


import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 *
 * @author 21624
 */
public class Formation {
    private int id ;
    private String description;
    private int nbre_max;
    private int nbre_participants;
    private String tittre;
    private String lien_Meet;
    private String date;
    List <Participation> participations ;
    private Utilisateur formateur ;

    public Formation(int id, String description, int nbre_max, int nbre_participants, String tittre, String lien_Meet, String date, List<Participation> participations, Utilisateur formateur) {
        this.id = id;
        this.description = description;
        this.nbre_max = nbre_max;
        this.nbre_participants = nbre_participants;
        this.tittre = tittre;
        this.lien_Meet = lien_Meet;
        this.date = date;
        this.participations = participations;
        this.formateur = formateur;
    }

    public Formation(String description, int nbre_max, int nbre_participants, String tittre, String lien_Meet, String date, List<Participation> participations, Utilisateur formateur) {
        this.description = description;
        this.nbre_max = nbre_max;
        this.nbre_participants = nbre_participants;
        this.tittre = tittre;
        this.lien_Meet = lien_Meet;
        this.date = date;
        this.participations = participations;
        this.formateur = formateur;
    }
    

    public Formation(String description, int nbre_max, int nbre_participants, String tittre, String lien_Meet, String date) {
        this.description = description;
        this.nbre_max = nbre_max;
        this.nbre_participants = nbre_participants;
        this.tittre = tittre;
        this.lien_Meet = lien_Meet;
        this.date = date;
    }

    public Formation(String description, String tittre, String date,String lien_Meet,int nbre_max, int nbre_participants,   Utilisateur formateur) {
        this.description = description;
        this.nbre_max = nbre_max;
        this.nbre_participants = nbre_participants;
        this.tittre = tittre;
        this.lien_Meet = lien_Meet;
        this.date = date;
        this.formateur = formateur;
    }

    public Formation(String tittre) {
        this.tittre = tittre;
    }

    public Formation() {
    }

 

   

   
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNbre_max() {
        return nbre_max;
    }

    public void setNbre_max(int nbre_max) {
        this.nbre_max = nbre_max;
    }

    public int getNbre_participants() {
        return nbre_participants;
    }

    public void setNbre_participants(int nbre_participants) {
        this.nbre_participants = nbre_participants;
    }

    public String getTittre() {
        return tittre;
    }

    public void setTittre(String tittre) {
        this.tittre = tittre;
    }

    public String getLien_Meet() {
        return lien_Meet;
    }

    public void setLien_Meet(String lien_Meet) {
        this.lien_Meet = lien_Meet;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Participation> getParticipations() {
        return participations;
    }

    public void setParticipations(List<Participation> participations) {
        this.participations = participations;
    }

    public Utilisateur getFormateur() {
        return formateur;
    }

    public void setFormateur(Utilisateur formateur) {
        this.formateur = formateur;
    }

    @Override
    public String toString() {
        return "Formation{" + "id=" + id + ", description=" + description + ", nbre_max=" + nbre_max + ", nbre_participants=" + nbre_participants + ", tittre=" + tittre + ", lien_Meet=" + lien_Meet + ", date=" + date + ", participations=" + participations + ", formateur=" + formateur + '}';
    }

    public Formation( String tittre,String description, String lien_Meet, int nbre_max,String date,Utilisateur formateur ) {
        this.description = description;
        this.tittre = tittre;
        this.lien_Meet = lien_Meet;
          this.nbre_max = nbre_max;
        this.formateur = formateur;
           this.date = date;
    }

    

    
    
    
}
