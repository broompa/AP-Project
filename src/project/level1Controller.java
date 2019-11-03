/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;


import java.io.IOException;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

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
    
    @FXML
    private Button save;
    
    
    
    
    private static int sunValue ;
    @FXML
    private ImageView menuButton;
    @FXML
    private StackPane container;
    
    @FXML
    private AnchorPane anchorRoot;
    
    private String isSelected = null;
     
    public void ingamemenu() throws IOException{
        menuButton.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                Parent root;
                Project.stopanimation();
                try {
                    root = FXMLLoader.load(getClass().getResource("ingameMenu.fxml"));
                    Scene sc = menuButton.getScene();
                    root.translateYProperty().set(sc.getHeight());
                    container.getChildren().add(root);
                    Timeline t = new Timeline();
                    KeyValue kv = new KeyValue(root.translateYProperty(),0,Interpolator.EASE_IN);
                    KeyFrame kf = new KeyFrame(Duration.millis(1000),kv);
                    t.getKeyFrames().add(kf);
                    t.setOnFinished(t1->{
                        container.getChildren().remove(anchorRoot);
                    });
                    t.play();
                }catch (IOException ex) {
                    System.out.println("IO Error");
                    System.exit(0);
                }
                }
        });
    }
    
    
    public static void  setSunCount(int val ){
        sunValue = val;
    }
    
    public static int getSunCount(){ return sunValue;}
    
    
    
    
    
    public void save() throws IOException{
       save.setOnMouseClicked(new EventHandler<MouseEvent>(){
           @Override
           public void handle(MouseEvent e){
               
           
           }
       
       });
        
    }
    
    
    
    
    
    
    public void updateSunCountLabel(MouseEvent e ) throws IOException{
          sunCount.setText(Integer.toString( sunValue));
    }
    
    
    
    
    
    // test function to check pixel boundation
     public void clickTest(MouseEvent e) throws IOException{
        double x = e.getX();
        double y = e.getY();
        System.out.println("("+x+","+y+")");
        
        if (isSelected!=null && x>=296 && x<=1166  && y>=137 &&y<=669){
            System.out.println("in grid");
            levelHandler.addPlant(x,y,isSelected);
        }
        
        
        if(y>6 && y< 98){
            if (x>384 && x<440){ 
                System.out.println("shooter selected");
                isSelected="shooter";
            }
            else if (x>451 && x<507){
                System.out.println("sunflower selected");
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
