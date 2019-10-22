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
    private boolean isAlive ; 
    private int health ;
    private Timeline timeline;
    private Group view;
    
    
    public Group getView(){
        return view;
    }
    
    public boolean isColliding(GameObject other) {
         return getView().getBoundsInParent().intersects(other.getView().getBoundsInParent());
    
    }
    public abstract void update();   
    
}
