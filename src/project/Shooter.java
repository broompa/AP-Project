/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;


import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import project.Plant;

/**
 *
 * @author verma
 */
public class Shooter extends Plant{

    private long lastShoot; 
    private int shootInterval;
    private int row ;
    //final ImageView im1= new ImageView(new Image(getClass().getResourceAsStream("/project/resources/pea_shooter.gif")));
    
    public Shooter(double x , double y,int row){
        //////// to be imlpemented plant class feature /- time to live , last added
        lastShoot = 0L;
        this.row= row;
        shootInterval = 5;
        setImage();
        view.setTranslateX(x);
        view.setTranslateY(y);
    }
    private void setImage(){
        view = new Group(new ImageView(new Image(getClass().getResourceAsStream("/project/resources/pea_shooter.gif"))));
        
    }
    
    public void load(){
        setImage();
        view.setTranslateX(px);
        view.setTranslateY(py);
    }
    
     
    @Override
    public void update() {
       if (this.health <= 0){ this.isAlive = false;}
       if (System.currentTimeMillis()-lastShoot>shootInterval*1000){
           lastShoot=System.currentTimeMillis();
           levelHandler.addPea(view.getTranslateX()+30,view.getTranslateY(),row);
       }
       updateCoordiante();
       
       
       
    }
    
}
