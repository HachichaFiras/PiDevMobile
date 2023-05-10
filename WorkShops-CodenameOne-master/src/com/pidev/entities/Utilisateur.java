/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.entities;

/**
 *
 * @author Asus
 */
public class Utilisateur {
    
    private int id ,role,numTel;
    private Domaine domaine;
    private String nom,email,password,prenom,login,adresse;
    private String role_nom,domaine_nom;

    public Utilisateur(int id,String nom)
            
    {
        this.id=id;
        this.nom=nom;
    }
    
    
    public Utilisateur(int id, int role, Domaine domaine, int numTel, String nom, String email, String password, String prenom, String login, String adresse, String role_nom, String domaine_nom) {
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
        this.role_nom = role_nom;
        this.domaine_nom = domaine_nom;
    }

    public Utilisateur(int id) {
        this.id = id;
    }
    
    public void setRole_nom(String role_nom) {
        this.role_nom = role_nom;
    }

    public void setDomaine_nom(String domaine_nom) {
        this.domaine_nom = domaine_nom;
    }

    public String getRole_nom() {
        return role_nom;
    }

    public String getDomaine_nom() {
        return domaine_nom;
    }
    
    @Override
    public String toString() {
        return "Utilisateur{" +  ", nom=" + nom + ", prenom=" + prenom  + '}';
    }

    public Utilisateur(int role,  Domaine domaine, String nom, String email, String password, String prenom, String login, int numTel, String adresse) {
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

    public Utilisateur() {
    }

    public Utilisateur(int id, int role,  Domaine domaine, String nom, String email, String password, String prenom, String login, int numTel, String adresse) {
        this.id = id;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void setDomaine(Domaine domaine) {
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

    public  Domaine getDomaine() {
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
