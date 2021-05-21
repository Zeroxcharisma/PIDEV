/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entitie;

/**
 *
 * @author yossr
 */
public class Categorie {
    int id;
    String description;
    int productId;

    public Categorie() {
    }

    public Categorie(int id, String description, int productId) {
        this.id = id;
        this.description = description;
        this.productId = productId;
    }

    public Categorie(String description, int productId) {
        this.description = description;
        this.productId = productId;
    }

    public Categorie(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public Categorie(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public int getProductId() {
        return productId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
    
}
