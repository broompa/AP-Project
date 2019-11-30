/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
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
public class leaderBoardScreenController implements Initializable {
   @FXML
    private StackPane container;
    
    @FXML
    private AnchorPane anchorRoot;
    @FXML
    private Label user1;
    @FXML
    private Label user2;
    @FXML
    private Label user3;
    @FXML
    private Label user4;
    @FXML
    private Label user5;
    @FXML
    private Label score1;
    @FXML
    private Label score2;
    @FXML
    private Label score3;
    @FXML
    private Label score4;
    @FXML
    private Label score5;
    
    
    @FXML
    private ImageView backButton;

    public void initialize() {
        
    }

    MediaPlayer a;
    public leaderBoardScreenController() {
     URL resource = getClass().getResource("/project/resources/Sounds/Soul2.wav");
        a =new MediaPlayer(new Media(resource.toString()));
        a.setOnEndOfMedia(new Runnable() {
            public void run() {
                a.seek(Duration.ZERO);
            }
        });
        a.play();
    }

    
    public void user_back1(MouseEvent event) throws IOException {
        if(Project.setState(0)){
            a.stop();
//            System.out.println("adas");
            Parent root = FXMLLoader.load(getClass().getResource("mainScreen.fxml"));
//            System.out.println("adas");
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
    
    public void buttonEnter(MouseEvent e){
        backButton.setOpacity(0.75);
    }
    public void buttonExit(MouseEvent e ){
        backButton.setOpacity(1);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<User>  arr = User.getUserList();
        for (int x = 0 ; x<arr.size() ;x++){
            String userName = arr.get(x).getName();
            String userScore = Integer.toString(arr.get(x).getScore());
            switch(x){
                case 0:
                    score1.setText(userScore);
                    user1.setText(userName);
                    break;
                case 1:
                    score2.setText(userScore);
                    user2.setText(userName);
                    break;
                case 2:
                    score3.setText(userScore);
                    user3.setText(userName);
                    break;
                case 3:
                    score4.setText(userScore);
                    user4.setText(userName);
                    break;
                case 4:
                    score4.setText(userScore);
                    user4.setText(userName);
                    break;
            }
        }
    }
}
