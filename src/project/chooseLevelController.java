
package project;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class chooseLevelController  {
    @FXML
    private StackPane container;
    @FXML
    private AnchorPane anchorRoot;
    @FXML
    private ImageView back;
    @FXML
    private ImageView proceed;

    MediaPlayer a;
    public chooseLevelController() {
      URL resource = getClass().getResource("/project/resources/Sounds/Soul2.wav");
        a =new MediaPlayer(new Media(resource.toString()));
        a.setOnEndOfMedia(new Runnable() {
            public void run() {
                a.seek(Duration.ZERO);
            }
        });
        a.play();
    
    }
    
    
    
    
    public void user_back(ActionEvent event) throws IOException {
        if(Project.setState(4)){
            a.stop();
        Parent root = FXMLLoader.load(getClass().getResource("resumeGame.fxml"));
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
    
    public void user_proceed(ActionEvent event) throws IOException {
        a.stop();//after projectsetstate ********IMPORTANT*************
    }
    
    public void backButtonEnter(MouseEvent e){
        back.setOpacity(0.75);
    }
    public void backButtonExit(MouseEvent e ){
        back.setOpacity(1);
    }
    public void proceedButtonEnter(MouseEvent e){
        proceed.setOpacity(0.75);
    }
    public void proceedButtonExit(MouseEvent e ){
        proceed.setOpacity(1);
    }
}