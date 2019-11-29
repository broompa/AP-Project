/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.Random;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author verma
 */
public class Sun extends GameObject{
    private int stopLine; // stop y coordinate
    private boolean move ;
    //ImageView im1= new ImageView(new Image(getClass().getResourceAsStream("/project/resources/sun.gif")));
    
    public Sun(boolean move, double x , double y){
        setImage();
        this.move = move ;
        view.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent e){
                isAlive = false;
            }
        });
        if (move){
            Random r = new Random();

            int ran = r.nextInt(8);
            switch(ran){
                case 0:
                    view.setTranslateX(340);
                    break;
//                case 1:
//                    view.setTranslateX(265);
//                    break;
                case 2:
                    view.setTranslateX(437);
                    break;
                case 3:
                    view.setTranslateX(625);
                    break;
                case 4:
                    view.setTranslateX(707);
                    break;    
                case 5:
                    view.setTranslateX(802);
                    break;
                case 6:
                    view.setTranslateX(901);
                    break;
                case 7:
                    view.setTranslateX(994);
                    break;
                case 1:
                    view.setTranslateX(1076);
                    break;
            }
            switch(r.nextInt(3)){
                case 0:
                    stopLine = 441;
                    break;
                case 1:   
                    stopLine = 570;
                    break;
                case 2:
                    stopLine = 303;
                    break;
            }
        }
        else {
            view.setTranslateX(x);
            view.setTranslateY(y);
        
        }
    }
    
    
    
    @Override
    public void update() {
        if (view.getTranslateY()<stopLine && move && isAlive){
            view.setTranslateY(view.getTranslateY()+0.5);}
        updateCoordiante();
    }

    @Override
    public void load() {
        setImage();
        view.setTranslateX(px);
        view.setTranslateY(py);
    }
    private void setImage (){
        view = new Group(new ImageView(new Image(getClass().getResourceAsStream("/project/resources/sun.gif"))));
   }
   
   public String toString(){
       return new String("Sun at ("+ px+","+py+")");
   }
    
    
}
