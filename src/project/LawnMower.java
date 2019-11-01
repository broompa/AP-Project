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
public class LawnMower extends GameObject {
    private boolean move ;
    private double speed;
    
    ImageView im1= new ImageView(new Image(getClass().getResourceAsStream("/project/resources/lawn_mower.gif")));
    public LawnMower(int x , int y ){
        view = new Group(im1);
        move = false;
        view.setTranslateX(x);
        view.setTranslateY(y);
        speed =  0.5;
    }
    
    @Override
    public void update() {
        if (move){
            speed+=0.01;
            
            view.setTranslateX(view.getTranslateX()+speed);
            if (view.getTranslateX()>=753){
            isAlive = false;}
        }
        
    }
    
    public void moveNow(){
        move = true;
    }
   
    
}
