/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
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
public class resumeGameController implements Initializable {
    
    @FXML
    private StackPane container;
    @FXML
    private AnchorPane anchorRoot;
    @FXML
    private ComboBox chooseUser; 
    @FXML
    private ImageView backButton;
    
    
    
    public void resume(MouseEvent e) throws Exception{
        try{
            
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(System.getProperty("user.dir")+"//userFiles//"+chooseUser.getValue().toString()+".zzz"));
            User g = (User) in.readObject();
            g.load();
            Project.setUser(g);
            Parent root = null;
            try {
                        root = FXMLLoader.load(getClass().getResource("level1.fxml"));
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
        }catch(NullPointerException ee){
            System.out.println("Please select a profile.");
        }
    }
    
    
    
    
    
    
    
    
    
    
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String[] arr = User.getPlayerList();
        chooseUser.getItems().addAll(arr);
    }
    
}
