/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class loadingScreenController implements Initializable {
    @FXML
    private StackPane container;
    @FXML
    private ImageView img;
    @FXML
    private AnchorPane anchorRoot;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        new SplashScreen().start();
    }    
    
    class SplashScreen extends Thread{
        @Override
        public void run(){
            try {
                Thread.sleep(5000);
                    Platform.runLater(new Runnable(){
                        @Override
                        public void run() {
                            Parent root=null;
                                FadeTransition fadeTransition = new FadeTransition();
                                fadeTransition.setDuration(Duration.seconds(5));
                                fadeTransition.setNode(anchorRoot);
                                fadeTransition.setFromValue(1);
                                fadeTransition.setToValue(0);
                                fadeTransition.play();
//                                fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {
//                                    @Override
//                                    public void handle(ActionEvent event) {
                                        try {
                                            root = FXMLLoader.load(getClass().getResource("mainScreen.fxml"));
                                            Scene sc = img.getScene();
                                            root.translateYProperty().set(-sc.getHeight());
                                            container.getChildren().add(root);
                                            Timeline t = new Timeline();
                                            KeyValue kv = new KeyValue(root.translateYProperty(),0,Interpolator.EASE_IN);
                                            KeyFrame kf = new KeyFrame(Duration.millis(1000),kv);
                                            t.getKeyFrames().add(kf);
                                            t.setOnFinished(t1->{
                                                container.getChildren().remove(anchorRoot);
                                            });
                                            System.out.println("2222");
                                            t.play();
                                            System.out.println("2222");
                                        } catch (IOException ex) {
                                            Logger.getLogger(loadingScreenController.class.getName()).log(Level.SEVERE, null, ex);
                                        }
//                                    }
//                                });
//                            container.getScene().getWindow().hide();
                        }
                    });
            } catch (InterruptedException ex) {
                Logger.getLogger(loadingScreenController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } 
        
}
