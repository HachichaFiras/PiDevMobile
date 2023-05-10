/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.semer.entities;

/**
 *
 * @author ASUS
 */
public class CV {
    private int id;
    private String pdfcv,img,linkedin,git,bio;

    public CV() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPdfcv(String pdfcv) {
        this.pdfcv = pdfcv;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public void setGit(String git) {
        this.git = git;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public int getId() {
        return id;
    }

    public String getPdfcv() {
        return pdfcv;
    }

    public String getImg() {
        return img;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public String getGit() {
        return git;
    }

    public String getBio() {
        return bio;
    }
    
    
}
