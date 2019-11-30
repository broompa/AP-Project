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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class walnut_AlmanacController{

   @FXML
    private StackPane container;
    @FXML
    private AnchorPane anchorRoot;
    @FXML
    private ImageView back;
    @FXML
    private ImageView close;
    @FXML
    private ImageView shooter;
    @FXML
    private ImageView sunflower;
    @FXML
    private ImageView mine;
    @FXML
    private ImageView walnut;

    MediaPlayer a;
    public walnut_AlmanacController() {
     URL resource = getClass().getResource("/project/resources/Sounds/Soul2.wav");
        a =new MediaPlayer(new Media(resource.toString()));
        a.setOnEndOfMedia(new Runnable() {
            public void run() {
                a.seek(Duration.ZERO);
            }
        });
        a.play();
    }
    
    
    
    public void close(MouseEvent event) throws IOException{
        if (Project.setState(0)){
            a.stop();
            Parent root = FXMLLoader.load(getClass().getResource("mainScreen.fxml"));
            Scene sc = back.getScene();
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
    public void back(MouseEvent event) throws IOException{
        a.stop();
        Parent root = FXMLLoader.load(getClass().getResource("potatomine_Almanac.fxml"));
        Scene sc = back.getScene();
        container.getChildren().add(root);
        container.getChildren().remove(anchorRoot);
    }
    public void almanac_shooter(MouseEvent event) throws IOException{
        a.stop();
        Parent root = FXMLLoader.load(getClass().getResource("almanacScreen.fxml"));
        Scene sc = back.getScene();
        container.getChildren().add(root);
        container.getChildren().remove(anchorRoot);
    }
    public void almanac_sunflower(MouseEvent event) throws IOException{
        a.stop();
        Parent root = FXMLLoader.load(getClass().getResource("sunflower_Almanac.fxml"));
        Scene sc = back.getScene();
        container.getChildren().add(root);
        container.getChildren().remove(anchorRoot);
    }
    public void almanac_mine(MouseEvent event) throws IOException{
        a.stop();
        Parent root = FXMLLoader.load(getClass().getResource("potatomine_Almanac.fxml"));
        Scene sc = back.getScene();
        container.getChildren().add(root);
        container.getChildren().remove(anchorRoot);
    }
    public void almanac_walnut(MouseEvent event) throws IOException{
//        Parent root = FXMLLoader.load(getClass().getResource("walnut_Almanac.fxml"));
//        Scene sc = back.getScene();
//        container.getChildren().add(root);
//        container.getChildren().remove(anchorRoot);
    }
    
    
}
