/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;


import java.net.URL;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import project.Plant;

/**
 *
 * @author verma
 */
public class Shooter extends Plant{

    MediaPlayer a;
    private long lastShoot; 
    private int shootInterval;
    private int row ;
    //final ImageView im1= new ImageView(new Image(getClass().getResourceAsStream("/project/resources/pea_shooter.gif")));
    private boolean zombieThere;
    public Shooter(int boxNum,int row){
        //////// to be imlpemented plant class feature /- time to live , last added
        lastShoot = 0L;
        this.row= row;
        shootInterval = 5;
        setImage();
        setPosition(boxNum);
        zombieThere = false;
    }
    public Shooter(double x , double y ,int row){
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
        view.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                if( level1Controller.whatSelected()!= null && level1Controller.whatSelected().equals("shovel")){
                    isAlive = false;
                }
            }
        });
    }
    public void setShoot(boolean x){ this.zombieThere = x;}
    
    
    
    
    
    public void load(){
        setImage();
        view.setTranslateX(px);
        view.setTranslateY(py);
    }
    
     
    @Override
    public void update() {
       if (this.health <= 0){ this.isAlive = false;}
       if (System.currentTimeMillis()-lastShoot>shootInterval*1000 && zombieThere ){
           lastShoot=System.currentTimeMillis();
            URL resource = getClass().getResource("/project/resources/Sounds/fireball.wav");
            a =new MediaPlayer(new Media(resource.toString()));
            a.play();
           levelHandler.addPea(view.getTranslateX()+30,view.getTranslateY(),row);
       }
       updateCoordiante();
       
       
       
    }
    
}
