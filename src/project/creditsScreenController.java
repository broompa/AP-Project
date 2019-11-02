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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
public class creditsScreenController {
    @FXML
    private StackPane container;
    
    @FXML
    private AnchorPane anchorRoot;
    
    
    @FXML
    private ImageView backButton;

    public void user_back() throws IOException{
        backButton.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                Parent root;
                try {
                    root = FXMLLoader.load(getClass().getResource("mainScreen.fxml"));
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
                }catch (IOException ex) {
                    System.out.println("IO Error");
                    System.exit(0);
                }
                }
        });
    }
}
