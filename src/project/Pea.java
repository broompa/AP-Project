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
public class Pea extends GameObject {
    private float speed;
    private final float damage ;
   // final ImageView im1= new ImageView(new Image(getClass().getResourceAsStream("/project/resources/fireball.gif")));
    //final ImageView im1= new ImageView(new Image(getClass().getResourceAsStream("/project/resources/Pea.gif")));
    
    public Pea(double x , double y ){
        damage = 5;
        speed = 2;
        setImage();
        view.setTranslateX(x);
        view.setTranslateY(y);
    }
    
    public double getDamage(){ return this.damage;}
    
    private void setImage (){
        view = new Group(new ImageView(new Image(getClass().getResourceAsStream("/project/resources/fireball.gif"))));
    }
    
    
    @Override
    public void update() {
        if (isAlive){
            view.setTranslateX(view.getTranslateX()+speed);
            
        }
        
    }

    @Override
    public void load() {
        setImage();
        view.setTranslateX(px);
        view.setTranslateY(py);
    }
    
    
}
