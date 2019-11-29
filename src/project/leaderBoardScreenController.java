/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project;

import java.io.IOException;
import java.util.ArrayList;
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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
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
public class leaderBoardScreenController  {
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

    public leaderBoardScreenController() {
        ArrayList<User>  ar = User.getUserList();
        System.out.println(ar);
        System.out.println(Integer.toString(ar.get(0).getScore()));
//        score1.setText(Integer.toString(ar.get(0).getScore()));
    }
//    public void user_back() throws IOException{
//        backButton.setOnMouseClicked(new EventHandler<MouseEvent>(){
//            @Override
//            public void handle(MouseEvent event) {
//                Parent root;
//                try {
//                    root = FXMLLoader.load(getClass().getResource("mainScreen.fxml"));
//                    Scene sc = backButton.getScene();
//                    root.translateYProperty().set(-sc.getHeight());
//                    container.getChildren().add(root);
//                    Timeline t = new Timeline();
//                    KeyValue kv = new KeyValue(root.translateYProperty(),0,Interpolator.EASE_IN);
//                    KeyFrame kf = new KeyFrame(Duration.millis(1000),kv);
//                    t.getKeyFrames().add(kf);
//                    t.setOnFinished(t1->{
//                        container.getChildren().remove(anchorRoot);
//                    });
//                    t.play();
//                }catch (IOException ex) {
//                    System.out.println("IO Error");
//                    System.exit(0);
//                }
//                }
//        });
//    }
    public void user_back1(MouseEvent event) throws IOException {
        if(Project.setState(0)){
            System.out.println("adas");
            Parent root = FXMLLoader.load(getClass().getResource("mainScreen.fxml"));
            System.out.println("adas");
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
//        backButton.setImage(new Image(getClass().getResourceAsStream("/project/resources/Game_Buttons/exitButton.png")));
        backButton.setOpacity(0.75);
    }
    public void buttonExit(MouseEvent e ){
//        backButton.setImage(new Image(getClass().getResourceAsStream("/project/resources/Game_Buttons/backButton.png")));
        backButton.setOpacity(1);
    }
}
