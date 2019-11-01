/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;


import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class level1Controller  {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label sunCount;
    @FXML
    private Label yLabel;
    
    
    private static int sunValue ;
    
    @FXML
    private StackPane container;
    
    @FXML
    private AnchorPane anchorRoot;
    
    private String isSelected = null;
     
    
    
    
    public static void  setSunCount(int val ){
        sunValue += val;
    }
    
    
    
    
    
    
    
    
    // test function to check pixel boundation
     public void clickTest(MouseEvent e) throws IOException{
        double x = e.getX();
        double y = e.getY();
        System.out.println("("+x+","+y+")");
        
        if (isSelected!=null && x>=198 && x<=753  && y>=28 &&y<=471){
            levelHandler.addPlant(x,y,isSelected);
        }
        
        
        if(x>4 && x< 75){
            if (y>4 && y<47){ 
                isSelected="shooter";
            }
            else if (y>62 && y<111){
                isSelected="sunflower"; 
            }
            else {
                isSelected =null;
                
            }
        }
        else {
            isSelected = null;
        }
        
        
    }
    
}
