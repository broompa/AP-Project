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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;


public class userDetailsController {
    @FXML
    private StackPane container;
    
    @FXML
    private AnchorPane anchorRoot;
    
    
    @FXML
    private ImageView backButton;
    
    @FXML
    private TextField textFieldUsername;
    
    @FXML
    private TextField textFieldAge;
    
    @FXML 
    private ImageView proceedButton;
    
    @FXML
    private Label userScreenLabel;

    public void user_back() throws IOException{
        if (Project.setState(0)){
            Parent    root = FXMLLoader.load(getClass().getResource("mainScreen.fxml"));
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
   public void user_proceed(MouseEvent event) throws IOException{
        try{
            int age=Integer.parseInt(textFieldAge.getText());
            if (textFieldUsername.getText().isEmpty()|| textFieldUsername.getText().length()==0) {
                userScreenLabel.setText("Username cannot be empty");
                textFieldUsername.setText("");
                textFieldAge.setText("");
            }
            else if(textFieldAge.getText().isEmpty()|| textFieldAge.getText().length()==0){
                userScreenLabel.setText("Age cannot be empty");
                textFieldUsername.setText("");
                textFieldAge.setText("");
            }
            else if(age>100){
                userScreenLabel.setText("Age cannot be more than 100");
                textFieldUsername.setText("");
                textFieldAge.setText("");
            }
            else if (User.doesExists(textFieldUsername.getText())){
                userScreenLabel.setText("Already Exists, choose another name.");
                textFieldUsername.setText("");
                textFieldAge.setText("");
            }
            else {
                userScreenLabel.setText("User Creation Succesful.");
                try {
                    if(Project.setState(2)){
                        Parent root = FXMLLoader.load(getClass().getResource("level_1.fxml"));
                        Scene sc = backButton.getScene();
                        root.translateYProperty().set(sc.getHeight());
                        container.getChildren().add(root);
                        Timeline t = new Timeline();
                        KeyValue kv = new KeyValue(root.translateYProperty(),0,Interpolator.EASE_IN);
                        KeyFrame kf = new KeyFrame(Duration.millis(1000),kv);
                        t.getKeyFrames().add(kf);
                        t.setOnFinished(t1->{
                            container.getChildren().remove(anchorRoot);
                        });
                        t.play();
                        Project.setUser(new User(textFieldUsername.getText()));
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                    System.out.println("IO Error");
                    System.exit(0);
                }
            }
        }
        catch(NumberFormatException e){
            userScreenLabel.setText("Age has to be a number");
            textFieldAge.setText("");
            textFieldAge.setText("");
        }
    }
    public void backButtonEnter(MouseEvent e){
        backButton.setOpacity(0.75);
    }
    public void backButtonExit(MouseEvent e ){
        backButton.setOpacity(1);
    }
    public void proceedButtonEnter(MouseEvent e){
        proceedButton.setOpacity(0.75);
    }
    public void proceedButtonExit(MouseEvent e ){
        proceedButton.setOpacity(1);
    }
   

}

