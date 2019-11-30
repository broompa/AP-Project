/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
public class leveLostController implements Initializable {
    
    
    @FXML
    private StackPane container;
    @FXML
    private ImageView restartBtn;
    @FXML
    private ImageView menuBtn;
    
    
    @FXML
    private AnchorPane anchorRoot;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     public void restart(MouseEvent e ) throws IOException{
        
        level1Controller.restart();
        Project.restartGame();
        
        String s = new String("");
        switch(Project.getUser().getLevel()){
            case 1 :
                s = "level_1.fxml";
                break;
            case 2 :
                s = "level_2.fxml";
                break;
            case 3 :
                s = "level_3.fxml";
                break;    
            case 4 :
                s = "level_4.fxml";
                break;
             default:
                 s = "level1.fxml";
                 break;
        }
         if (Project.setState(2)){
            Parent root = FXMLLoader.load(getClass().getResource(s));
            Scene sc = restartBtn.getScene();
            root.translateYProperty().set(-sc.getHeight());
//            sc=null;
            container.getChildren().add(root);
            Timeline t = new Timeline();
            KeyValue kv = new KeyValue(root.translateYProperty(),0,Interpolator.EASE_IN);
            KeyFrame kf = new KeyFrame(Duration.millis(1000),kv);
            t.getKeyFrames().add(kf);
            t.setOnFinished(t1->{
                container.getChildren().remove(anchorRoot);
            });
            t.play();
        }
    }
    public void menu(MouseEvent e) throws IOException{
        Project.getUser().setLevelCompleted(true);
        try {
            Project.saveGame();
        } catch (IOException ex) {
            System.out.println("Menu level Completed");
        }
         if (Project.setState(0)){
            Parent root = FXMLLoader.load(getClass().getResource("mainScreen.fxml"));
            Scene sc = restartBtn.getScene();
            root.translateYProperty().set(-sc.getHeight());
            container.getChildren().add(root);
            Timeline t = new Timeline();
            KeyValue kv = new KeyValue(root.translateYProperty(),0,Interpolator.EASE_IN);
            KeyFrame kf = new KeyFrame(Duration.millis(1000),kv);
            t.getKeyFrames().add(kf);
            t.setOnFinished(t1->{
                container.getChildren().remove(anchorRoot);
            });
            t.play();
        }
    
    
    }
    
}
