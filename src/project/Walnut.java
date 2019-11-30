/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author verma
 */
public class Walnut extends Plant{
    private final double MAX_HEALTH = 20;
    public Walnut(double x , double y ){
       setImage();
       view.setTranslateX(x);
       view.setTranslateY(y);
       health = MAX_HEALTH;
    }
    
    public Walnut(int boxNum){
        setImage();
        setPosition(boxNum);
        health = MAX_HEALTH;
    
    
    
    }
    
    
    
    
    
    private void setImage(){
        view = new Group(new ImageView(new Image(getClass().getResourceAsStream("/project/resources/walnut_full_life.gif"))));
        view.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                if(level1Controller.whatSelected().equals("shovel")){
                    isAlive = false;
                }
            }
        });
    }
    
    @Override
    public void load() {
        setImage();
        view.setTranslateX(px);
        view.setTranslateY(py);
    }

    @Override
    public void update() {
        
        if(health<=0.5*MAX_HEALTH){
            view.getChildren().setAll(new ImageView(new Image(getClass().getResourceAsStream("/project/resources/walnut_half_life.gif"))));
        }
        
        if(health<0 && isAlive){
            isAlive = false;
        }
        updateCoordiante();
    }
    
}
