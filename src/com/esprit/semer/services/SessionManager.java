/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.semer.services;

import com.codename1.io.Preferences;

/**
 *
 * @author ASUS
 */
public class SessionManager {
    public static Preferences pref ;
    private static int id ; 
    private static String login;
    private static boolean isVerified;
    private static boolean isBlocked;
    private static String nom ;
    private static String prenom;
    private static String adresse;
    private static String email; 
    private static String passowrd ;
    private static int role;
    private static int numTel;


    public static void setPref(Preferences pref) {
        SessionManager.pref = pref;
    }

    public static void setId(int id) {
        SessionManager.id = id;
    }

    public static void setLogin(String login) {
        SessionManager.login = login;
    }

    public static void setIsVerified(boolean isVerified) {
        SessionManager.isVerified = isVerified;
    }

    public static void setIsBlocked(boolean isBlocked) {
        SessionManager.isBlocked = isBlocked;
    }

    public static void setNom(String nom) {
        SessionManager.nom = nom;
    }

    public static void setPrenom(String prenom) {
        SessionManager.prenom = prenom;
    }

    public static void setAdresse(String adresse) {
        SessionManager.adresse = adresse;
    }

    public static void setEmail(String email) {
        SessionManager.email = email;
    }

    public static void setPassowrd(String passowrd) {
        SessionManager.passowrd = passowrd;
    }

    public static void setRole(int role) {
        SessionManager.role = role;
    }

    public static void setNumTel(int numTel) {
        SessionManager.numTel = numTel;
    }

    public static Preferences getPref() {
        return pref;
    }

    public static int getId() {
        return id;
    }

    public static String getLogin() {
        return login;
    }

    public static boolean isIsVerified() {
        return isVerified;
    }

    public static boolean isIsBlocked() {
        return isBlocked;
    }

    public static String getNom() {
        return nom;
    }

    public static String getPrenom() {
        return prenom;
    }

    public static String getAdresse() {
        return adresse;
    }

    public static String getEmail() {
        return email;
    }

    public static String getPassowrd() {
        return passowrd;
    }

    public static int getRole() {
        return role;
    }

    public static int getNumTel() {
        return numTel;
    }
    
    
    
    
}
