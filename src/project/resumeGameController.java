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
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class resumeGameController {
    String[] arr;
    @FXML
    private StackPane container;
    @FXML
    private AnchorPane anchorRoot;
    @FXML
    private ComboBox chooseUser; 
    @FXML
    private Button userScreenBack;
    public resumeGameController() {
        arr = new String[20];
        arr = User.getPlayerList();
        chooseUser = new ComboBox(FXCollections.observableArrayList(arr));
    }
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
    
}
