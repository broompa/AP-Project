/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
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
public class ingameMenuController implements Initializable {
    @FXML
    private StackPane container;
    @FXML
    private AnchorPane anchorRoot;
    @FXML
    private ComboBox chooseUser; 
    @FXML
    private ImageView backButton;
    @FXML
    private ImageView saveandexitButton;
    
    
    
    
    public void user_back(MouseEvent event) throws IOException{
        Project.startAnimation();
        Parent root = FXMLLoader.load(getClass().getResource("level1.fxml"));
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
    public void saveAndExit(MouseEvent event) throws IOException,FileNotFoundException{
        try {
            Project.saveGame();
        } catch (IOException ex) {
            System.out.println("This is inGameMenuController");
        }
        Parent root = FXMLLoader.load(getClass().getResource("mainScreen.fxml"));
        Scene sc = saveandexitButton.getScene();
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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
