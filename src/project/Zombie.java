/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 *
 * @author verma
 */
public class Zombie extends GameObject {
    private float speed ;
    private float damage ;
    
    ImageView im1= new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Walk/1.png")));
    ImageView im2= new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Walk/2.png")));
    ImageView im3= new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Walk/3.png")));
    ImageView im4= new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Walk/4.png")));
    ImageView im5= new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Walk/5.png")));
    ImageView im6= new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Walk/6.png")));
    ImageView im7= new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Walk/7.png")));
    ImageView im8= new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Walk/8.png")));
    ImageView im9= new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Walk/9.png")));
    ImageView im10= new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Walk/10.png")));
    
    
    

    Zombie(int ran,int row) {
        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE); 
        view = new Group(im1);
        
        timeline.getKeyFrames().add(new KeyFrame(
                Duration.millis(100),(ActionEvent e) -> {
                    view.getChildren().setAll(im2);
                }
        
        ));
        
        timeline.getKeyFrames().add(new KeyFrame(
                Duration.millis(200),(ActionEvent e) -> {
                    view.getChildren().setAll(im3);
                }
        
        ));
        
        timeline.getKeyFrames().add(new KeyFrame(
                Duration.millis(300),(ActionEvent e) -> {
                    view.getChildren().setAll(im4);
                }
        
        ));
        
        timeline.getKeyFrames().add(new KeyFrame(
                Duration.millis(400),(ActionEvent e) -> {
                    view.getChildren().setAll(im5);
                }
        
        ));
        
        timeline.getKeyFrames().add(new KeyFrame(
                Duration.millis(500),(ActionEvent e) -> {
                    view.getChildren().setAll(im6);
                }
        
        ));
        
        timeline.getKeyFrames().add(new KeyFrame(
                Duration.millis(600),(ActionEvent e) -> {
                    view.getChildren().setAll(im7);
                }
        
        ));
        
        timeline.getKeyFrames().add(new KeyFrame(
                Duration.millis(700),(ActionEvent e) -> {
                    view.getChildren().setAll(im8);
                }
        
        ));
        
        timeline.getKeyFrames().add(new KeyFrame(
                Duration.millis(800),(ActionEvent e) -> {
                    view.getChildren().setAll(im9);
                }
        
        ));
        
        
        timeline.getKeyFrames().add(new KeyFrame(
                Duration.millis(900),(ActionEvent e) -> {
                    view.getChildren().setAll(im10);
                }
        
        ));
        
        
        timeline.getKeyFrames().add(new KeyFrame(
                Duration.millis(0),(ActionEvent e) -> {
                    view.getChildren().setAll(im1);
                }
        
        ));
        
        timeline.play();
    
        
        
        
        
        
        
        
        
        
        
        speed = 0.3f;// to be edited
        damage = 1;
    
        view.setTranslateX(750);
        switch(row){
            case 1 :
                view.setTranslateY(100);
                break;
            case 2 :
                view.setTranslateY(200);
                break;    
            case 3 :
                view.setTranslateY(300);
                break;
            case 4 :
                view.setTranslateY(400);
                break;
            case 5 :
                view.setTranslateY(500);
                break;
        }
        
    }

    @Override
    public void update() {
     view.setTranslateX(view.getTranslateX()-speed);   
    }
        
    
}
