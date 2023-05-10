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
public class Candidature {
    int id; 
    String datecreation;
  
    public Candidature() {}

    public Candidature(int id, String datecreation) {
        this.id = id;
        this.datecreation = datecreation;
    }

    public Candidature(String datecreation) {
        this.datecreation = datecreation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(String datecreation) {
        this.datecreation = datecreation;
    }

    @Override
    public String toString() {
        return "Candidature{" + "id=" + id + ", datecreation=" + datecreation + '}';
    }
 

}
    
    
    
