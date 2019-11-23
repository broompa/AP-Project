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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;




public class mainScreenController{
    
    
    @FXML
    private StackPane container;
    
    @FXML
    private AnchorPane anchorRoot;
    
    
    @FXML
    private ImageView newgameButton;
    @FXML
    private ImageView resumegameButton;
    @FXML
    private ImageView almanacButton;
    @FXML
    private ImageView leaderboardButton;
    @FXML
    private ImageView exitButton;
    @FXML
    private ImageView creditsButton;
    
    
    
    public void newGame() throws IOException{
        
        Parent root = FXMLLoader.load(getClass().getResource("userDetails.fxml"));
        Scene sc = newgameButton.getScene();
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
    public void resumeGame() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("resumeGame.fxml"));
        Scene sc = resumegameButton.getScene();
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
    
    public void exitGame() throws IOException{
        System.exit(0);
    }
    
    public void almanac() throws IOException {
        System.exit(0);        
    }	
	
    public void credits() throws IOException{
        
        Parent root = FXMLLoader.load(getClass().getResource("creditsScreen.fxml"));
        Scene sc = creditsButton.getScene();
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
    public void leaderboard() throws IOException{
             
        Parent  root = FXMLLoader.load(getClass().getResource("leaderBoardScreen.fxml"));
        Scene sc = leaderboardButton.getScene();
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
    
    
}
