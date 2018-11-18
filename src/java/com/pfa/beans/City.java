///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.pfa.beans;
//
//import java.io.Serializable;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.GeneratedValue;
//import javax.persistence.ManyToOne;
//
///**
// *
// * @author medEl
// */
//@Entity
//public class City implements Serializable{
//    @Id
//    @GeneratedValue
//    private int id;
//    private String name;
//    
//    @ManyToOne
//    private Region region; 
//
//    public City() {
//    }
//
//    public City(String name, Region region) {
//        this.name = name;
//        this.region = region;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Region getRegion() {
//        return region;
//    }
//
//    public void setRegion(Region region) {
//        this.region = region;
//    }
//    
//    
//}
