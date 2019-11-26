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
public class PotatoMine extends Plant{

    
    private long blastStart ;
    private float gifTime;
    private boolean blasting;
    public PotatoMine(double x, double y){
        setImage();
        view.setTranslateX(x);
        view.setTranslateY(y);
        blastStart = 0;
        gifTime = 1.2f;
        blasting = false;
        health = 1;
    }
    
    public PotatoMine(int boxNum){
        setImage();
        setPosition(boxNum);
        blastStart = 0;
        gifTime = 1.2f;
        blasting = false;
        health = 1;
    
    }
    
    
    
    private void setImage(){
        view = new Group(new ImageView(new Image(getClass().getResourceAsStream("/project/resources/potatoMine.gif"))));
    }
    
    
    
    public boolean isBlasting(){
        if ( blastStart != 0 && System.currentTimeMillis()-blastStart >= 700){
            return true;
        }
        return false;
    }
    
    
    
    @Override
    public void load() {
        setImage();
        view.setTranslateX(px);
        view.setTranslateY(py);
    }

    @Override
    public void update() {
        updateCoordiante();
        
        if (health<=0){
            if (blastStart==0){ 
                System.out.println("blast--> " + blastStart ) ;
                blastStart = System.currentTimeMillis();
                view.getChildren().setAll(new ImageView( new Image(getClass().getResourceAsStream("/project/resources/blast_potatoMine.gif"))));
                
            }
            else if (System.currentTimeMillis()-blastStart>gifTime*1000){
                isAlive = false;
            }
             
            
        }        
        
    }
    
}
