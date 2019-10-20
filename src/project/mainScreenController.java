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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;




public class mainScreenController {
    
    
    @FXML
    private StackPane container;
    
    @FXML
    private AnchorPane anchorRoot;
    
    
    @FXML
    private Button newGameButton;
    
    
    
    
    
    
    
    public void newGame(ActionEvent event) throws IOException {
                Parent root = FXMLLoader.load(getClass().getResource("userDetails.fxml"));
                Scene sc = newGameButton.getScene();
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
                
            
		
	}
    public void resumeGame(ActionEvent event) throws IOException {
		
		
	}
    public void exitGame(ActionEvent event) throws IOException {
        System.exit(0);
		
	}
    public void almanac(ActionEvent event) throws IOException {
		
		
	}
    public void credits(ActionEvent event) throws IOException {
		
		
	}
    public void leaderboard(ActionEvent event) throws IOException {
		
		
	}
    
    
}
