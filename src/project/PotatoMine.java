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

    PotatoMine(double x, double y, int row){
        setImage();
        view.setTranslateX(x);
        view.setTranslateY(y); 
    }
    
    
    
    private void setImage(){
        view = new Group(new ImageView(new Image(getClass().getResourceAsStream("/project/resources/potatoMine.gif"))));
    }
    
    
    @Override
    public void load() {
        setImage();
        view.setTranslateX(px);
        view.setTranslateY(py);
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
