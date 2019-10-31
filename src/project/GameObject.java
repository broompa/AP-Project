/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import javafx.animation.Timeline;
import javafx.scene.Group;

/**
 *
 * @author verma
 */
public abstract class GameObject {
    protected boolean isAlive ; 
    protected double health ;
    protected Timeline timeline;
    protected Group view;
    
    
    public GameObject(){
        isAlive = true;
        health = 10;
        
    }
    
    
    
    
    public void setHealth(double health){
        this.health = health ;
    }
    public double getHealth(){
        return health ;
    }
    
    
    
    
    
    
    
    
    
    
    
    public boolean getIsAlive(){
        return isAlive;
    }
    
    public void setIsAlive(boolean x){ 
        isAlive = x;
    }
    
    public Group getView(){
        return view;
    }
    
    public boolean isColliding(GameObject other) {
         return getView().getBoundsInParent().intersects(other.getView().getBoundsInParent());
    
    }
    public abstract void update();   
    
}
