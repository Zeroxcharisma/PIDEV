package edu.db3a3.entities;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import java.io.InputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.util.Date;

public class Produit extends RecursiveTreeObject<Produit>{
    private int id_bp;
    private String nom_bp;
    private String type_bp;
    private String desc_bp;
    private InputStream img_bp;
    private double prix_bp;
    
    private java.util.Date utilDate = new java.util.Date();
    private java.sql.Date date_bp = new java.sql.Date(utilDate.getTime());

    public Date getDate_bp() {
        return date_bp;
    }

    public void setDate_bp(java.sql.Date date_bp) {
        this.date_bp = date_bp;
    }

    public int getId_bp() {
        return id_bp;
    }

    public void setId_bp(int id_bp) {
        this.id_bp = id_bp;
    }

    public String getNom_bp() {
        return nom_bp;
    }

    public void setNom_bp(String nom_bp) {
        this.nom_bp = nom_bp;
    }

    public String getType_bp() {
        return type_bp;
    }

    public void setType_bp(String type_bp) {
        this.type_bp = type_bp;
    }

    public String getDesc_bp() {
        return desc_bp;
    }

    public void setDesc_bp(String desc_bp) {
        this.desc_bp = desc_bp;
    }

    public InputStream getImg_bp() {
        return img_bp;
    }
    

    public void setImg_bp(InputStream InputStream) {
        this.img_bp = InputStream;
    }

    public double getPrix_bp() {
        return prix_bp;
    }

    public void setPrix_bp(double prix_bp) {
        this.prix_bp = prix_bp;
    }
    
    
    public Produit(int id_bp,String nom_bp, String type_bp,String desc_bp, InputStream img_bp, double prix_bp)
    {
        this.id_bp=id_bp;
        this.nom_bp=nom_bp;
        this.type_bp=type_bp;
        this.desc_bp=desc_bp;
        this.img_bp=img_bp;
        this.prix_bp=prix_bp;
  
    }
    
    public Produit(String nom_bp, String type_bp,String desc_bp, InputStream img_bp, double prix_bp)
    {
        this.nom_bp=nom_bp;
        this.type_bp=type_bp;
        this.desc_bp=desc_bp;
        this.img_bp=img_bp;
        this.prix_bp=prix_bp;
        //this.id_user=id_user;
    }
    
    public Produit(int idproduit, String nom_bp, String type_bp,String desc_b, double prix_bp)
    {
    	this.id_bp =idproduit;
        this.nom_bp=nom_bp;
        this.type_bp=type_bp;
        this.desc_bp=desc_b;
        this.prix_bp=prix_bp;
    }
    
    public Produit()
    {
        
    }
    
    @Override
    public String toString()
    {
        return "\nBon Plan:\nID: "+id_bp+"\nNom: "+nom_bp+"\nType: "+type_bp+"\nDesc: "+desc_bp+"\nImage: "+img_bp
                +"\nPrix: "+prix_bp+"\nDate: "+date_bp+"\n";
    }
    
}
