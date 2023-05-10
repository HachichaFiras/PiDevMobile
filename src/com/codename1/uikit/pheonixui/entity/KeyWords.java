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
public class KeyWords {
    
    private int id;
    private String name;

    public KeyWords(String name) {
    
        this.name = name;
    }

    public KeyWords(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "keyword : "+this.getName();
    }
     
    
    
    
    
}
