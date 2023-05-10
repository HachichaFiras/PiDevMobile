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
public class Utilisateur {
       
    private int id ,role,domaine,numTel;
    private String nom,email,password,prenom,login,adresse;

    @Override
    public String toString() {
        return "Utilisateur{" + "id=" + id + ", role=" + role + ", domaine=" + domaine + ", nom=" + nom + ", email=" + email + ", password=" + password + ", prenom=" + prenom + ", login=" + login + ", numTel=" + numTel + ", adresse=" + adresse + '}';
    }

    public Utilisateur(int role, int domaine, String nom, String email, String password, String prenom, String login, int numTel, String adresse) {
        this.role = role;
        this.domaine = domaine;
        this.nom = nom;
        this.email = email;
        this.password = password;
        this.prenom = prenom;
        this.login = login;
        this.numTel = numTel;
        this.adresse = adresse;
    }

    public Utilisateur(int id, int role, int domaine, int numTel, String nom, String email, String password, String prenom, String login, String adresse) {
        this.id = id;
        this.role = role;
        this.domaine = domaine;
        this.numTel = numTel;
        this.nom = nom;
        this.email = email;
        this.password = password;
        this.prenom = prenom;
        this.login = login;
        this.adresse = adresse;
    }

    
    public Utilisateur() {
    }

    
    public Utilisateur(int id) {
        this.id = id;
 
    }
     public Utilisateur(int id,String nom) {
        this.id = id;
           this.login = nom;
 
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void setDomaine(int domaine) {
        this.domaine = domaine;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setNumTel(int numTel) {
        this.numTel = numTel;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getId() {
        return id;
    }

    public int getRole() {
        return role;
    }

    public int getDomaine() {
        return domaine;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getLogin() {
        return login;
    }

    public int getNumTel() {
        return numTel;
    }

    public String getAdresse() {
        return adresse;
    }
    
   

}
