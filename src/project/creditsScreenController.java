/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class creditsScreenController {
    @FXML
    private StackPane container;
    
    @FXML
    private AnchorPane anchorRoot;
    
    
    @FXML
    private ImageView backButton;
    
    MediaPlayer a;
    public creditsScreenController() {
    URL resource = getClass().getResource("/project/resources/Sounds/Soul2.wav");
        a =new MediaPlayer(new Media(resource.toString()));
        a.setOnEndOfMedia(new Runnable() {
            public void run() {
                a.seek(Duration.ZERO);
            }
        });
        a.play();
    
    }

    
    
    public void user_back() throws IOException{
        if(Project.setState(0)){
            a.stop();
            Parent root = FXMLLoader.load(getClass().getResource("mainScreen.fxml"));
            Scene sc = backButton.getScene();
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
    public void backButtonEnter(MouseEvent e){
        backButton.setOpacity(0.75);
    }
    public void backButtonExit(MouseEvent e ){
        backButton.setOpacity(1);
    }
}
