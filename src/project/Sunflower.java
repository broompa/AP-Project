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
public class Sunflower extends Plant {
    
    ImageView im1= new ImageView(new Image(getClass().getResourceAsStream("/project/resources/sun_flower.gif")));
    private long lastShine ;//  sun time count , just a fancy name 
    private int shineInterval ;
    public Sunflower(double x , double y){
        view = new Group(im1);
        view.setTranslateX(x);
        view.setTranslateY(y);
        lastShine = System.currentTimeMillis();
        shineInterval= 20;
        
    }
    
    
    
    
    
    @Override
    public void update() {
      if (health <= 0) { isAlive = false;}
      if (System.currentTimeMillis()- lastShine>= shineInterval*1000){
          lastShine =System.currentTimeMillis();
          levelHandler.addSun(view.getTranslateX(), view.getTranslateY());
      }
    }
    
}
