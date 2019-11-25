/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
    private static AnimationTimer anim;
    private static int state ;
    public static void setUser(User user1 ){ user = user1;
        startAnimation();
    }
    public static void stopAnimation(){
        anim.stop();
        g1.getChildren().remove(g);
        
    }
    public static void startAnimation(){
        anim.start();
        if (g1.getChildren().contains(g)){
            return;
        }
        g1.getChildren().add(g);
    }
    
    
    
    public static void saveGame() throws FileNotFoundException, IOException{
        System.out.println(System.getProperty("user.dir"));
        FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir")+"//userFiles//"+user.getName()+".zzz");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
	oos.writeObject(user);
	oos.close();
	fos.close();
        System.out.println("Data Stored Successfully");
        g1.getChildren().remove(g);
        g = new Group();
        g1.getChildren().add(g);
        user = null;
    
    }
    
    
    
    
    
    public static User getUser(){
        return user;
    }
    
    @Override
    public void start(Stage stage) throws Exception { 
        
        state= 0;
        Parent root = FXMLLoader.load(getClass().getResource("mainScreen.fxml"));
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
    
    public static boolean setState(int x){
        if (x!=state ){
            state = x;
            return true;
        }else {
            return false;
        }
    }
    
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
    public static int getBoxNumber(double x , double y ){
    
    
        return 0 ; //////////  to be written
    }
    
    
    
    
}
