/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author verma
 */
public abstract class Plant extends GameObject {/////test shooter class
    private int timeToLive; 
    private static long lastAdded; // stores added time of plant
    private double x;
    private double y;
//    Plant(int x,int y){
//        this.x=x;
//        this.y=y;
//    }
    public double getx(){
        return this.x;}
    public double gety(){
        return this.y;
    }
    public void setx(double x){
         this.x=x;}
    public void sety(double y){
        this.y=y;
    }
}
