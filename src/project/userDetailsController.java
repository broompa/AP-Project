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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;


public class userDetailsController {
    @FXML
    private StackPane container;
    
    @FXML
    private AnchorPane anchorRoot;
    
    
    @FXML
    private Button userScreenBack;
    
    @FXML
    private TextField textFieldUsername;
    
    @FXML
    private TextField textFieldAge;
    
    @FXML 
    private Button userProceed;
    
    @FXML
    private Label userScreenLabel;

   public void user_back(ActionEvent event) throws IOException {
          Parent root = FXMLLoader.load(getClass().getResource("mainScreen.fxml"));
        Scene sc = userScreenBack.getScene();
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
   
   public void user_proceed(ActionEvent event) throws IOException{
       System.out.println("func");
        if (User.doesExists(textFieldUsername.getText())){
            userScreenLabel.setText("Already Exists, choose another name.");
            textFieldUsername.setText("");
            textFieldAge.setText("");
        }
        else {
            userScreenLabel.setText("User Creation Succesful.");
                
                }
   
   }
       
    
}
