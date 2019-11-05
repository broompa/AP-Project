/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author verma
 */
public class Project extends Application {
    
    private static User user;// current user
    private static Group g ;
    private static Group g1; 
    static AnimationTimer anim;
    public static void setUser(User user1 ){ user = user1;
        anim.start();
    }
    public static void stopAnimation(){
        anim.stop();
        g1.getChildren().remove(g);
        
    }
    public static void startAnimation(){
        anim.start();
        g1.getChildren().add(g);
    }
    
    
    
    public static void saveGame(){
        
    
    }
    
    
    public static User getUser(){
        return user;
    }
    
    @Override
    public void start(Stage stage) throws Exception { 
        
        Parent root = FXMLLoader.load(getClass().getResource("loadingScreen.fxml"));
        anim = new AnimationTimer(){
            @Override 
            public void handle(long now ){
                user.update ();
            }
        };
        
        g = new Group();
        g1 = new Group(root,g);
        Scene scene = new Scene(g1);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void addToGroup(Group p){
        if (g.getChildren().contains(p)){
            return ;}
        g.getChildren().add(p);
    }
    
    public static void removeFromGroup(Group p){
        if (g.getChildren().contains(p)){
            g.getChildren().remove(p);
        }
    }
    
    
    
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
    public static int getBoxNumber(double x , double y ){
    
    
        return 0 ; //////////  to be written
    }
    
    
    
    
}
