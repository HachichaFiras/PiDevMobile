/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.semer.entities;

/**
 *
 * @author ASUS
 */
public class Domaine {
    private int id;
    private String nom;

    public Domaine(String nom) {
        this.nom = nom;
    }

    public Domaine() {
    }

    public Domaine(int id) {
        this.id = id;
    }
    
    public Domaine(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Domaine{" + "id=" + id + ", nom=" + nom + '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }
    
    
}
