/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.entities;

import java.util.Date;

/**
 *
 * @author 21624
 */
public class Participation {
    private int id;

    public Participation() {
    }
    private String date_creation;
    private Utilisateur user;
    private Formation formation;

    public Participation(String date_creation, Utilisateur user, Formation formation) {
        this.date_creation = date_creation;
        this.user = user;
        this.formation = formation;
    }

    public Participation(int id, String date_creation, Utilisateur user, Formation formation) {
        this.id = id;
        this.date_creation = date_creation;
        this.user = user;
        this.formation = formation;
    }

    public Participation(String date_creation, Utilisateur user) {
        this.date_creation = date_creation;
        this.user = user;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(String date_creation) {
        this.date_creation = date_creation;
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }
    
    @Override
    public String toString() {
        return "Participation{" + "id=" + id + ", date_creation=" + date_creation + ", user=" + user + ", formation=" + formation + '}';
    }

   

    
    
}
