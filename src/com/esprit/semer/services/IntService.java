/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.semer.services;
import java.util.ArrayList;
/**
 *
 * @author Narimen
 */
public interface IntService<T> {
    public void Create(T obj);
    public void Delete(T obj);
    public void Update(T obj);
    public ArrayList<T> getAll();
    public T get(T obj);
}
