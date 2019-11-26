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
public abstract class Plant extends GameObject {/////test shooter class
    private int timeToLive; 
    private static long lastAdded; // stores added time of plant
    private int boxNum;
    
    
    protected void setPosition(int boxNum){
        this.boxNum = boxNum;
        int xPix = level1Controller.getXPixel(boxNum%9-1);
        int yPix = level1Controller.getYPixel((int)(boxNum/9));
        System.out.println("Box Number: "+ boxNum)    ;
        System.out.println("("+xPix+","+yPix+")");
        if (this  instanceof Shooter){
            view.setTranslateX(xPix+10);
            view.setTranslateY(yPix+10);    
        }else if( this instanceof Sunflower){
            view.setTranslateX(xPix+10);
            view.setTranslateY(yPix+10);
        }else if( this instanceof Walnut){
            view.setTranslateX(xPix+10);
            view.setTranslateY(yPix+10);
        }else if( this instanceof PotatoMine){
            view.setTranslateX(xPix+10);
            view.setTranslateY(yPix+10);
        }
        
    
    }


}
