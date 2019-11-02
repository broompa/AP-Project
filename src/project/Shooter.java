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
    final ImageView im1= new ImageView(new Image(getClass().getResourceAsStream("/project/resources/pea_shooter.gif")));
    
    public Shooter(double x , double y,int row){
        //////// to be imlpemented plant class feature /- time to live , last added
        lastShoot = 0L;
        this.row= row;
        shootInterval = 5;
        int [] px = exactCoordinate(x, y);
        view = new Group(im1);
        view.setTranslateX(x);
        view.setTranslateY(y);
    }
    
    
    private int[] exactCoordinate(double x,double y){
        int [] ls = new int[2];
        if (x >= 198 && x <=263){
            ls[0] = 198;
        }
        else if (x > 263 && x <= 319){
            ls[0] = 263;
        }
        else if (x>319 && x<=388 ){
            ls[0] = 319;
        }
        else if (x>388 && x<=443){
            ls[0] = 388;
        }
        else if (x>443 && x<=508 ){
            ls[0] = 443;
        }
        else if (x>508 && x<= 574){
            ls[0] = 508;
        } 
        else if (x>574 && x<= 636){
            ls[0] = 574;
        }
        else if (x>636 && x<=691){
            ls[0] = 636;
        }
        else if (x>691 && x<=753){
            ls[0] = 691;
        }else {ls[0] = -1;}
        
        if (y>=28 && y<117){
            ls[1]=28;
        }
        else if (y>=117 && y<202){
            ls[1]= 117;
        }
        else if (y>=202 && y<294){
            ls[1]=202;
        }
        else if (y>= 294 && y<380){
            ls[1]=294;
        }
        else if (y>= 380 && y<471){
            ls[1]=380;
        }else {
            ls[1] =-1;
        }
        
     return ls;
    } 
    @Override
    public void update() {
       if (this.health <= 0){ this.isAlive = false;}
       if (System.currentTimeMillis()-lastShoot>shootInterval*1000){
           lastShoot=System.currentTimeMillis();
           levelHandler.addPea(view.getTranslateX(),view.getTranslateY(),row);
       }
       
       
       
    }
    
}
