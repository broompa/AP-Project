/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import javafx.animation.FadeTransition;
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
    private long deadTime; // store time instant when zombie's isAlive set to false
    private Timeline deadLine ; // dead timeline animation
    private boolean move; 
    
    final ImageView im1= new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Walk/1.png")));
    final ImageView im2= new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Walk/2.png")));
    final ImageView im3= new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Walk/3.png")));
    final ImageView im4= new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Walk/4.png")));
    final ImageView im5= new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Walk/5.png")));
    final ImageView im6= new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Walk/6.png")));
    final ImageView im7= new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Walk/7.png")));
    final ImageView im8= new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Walk/8.png")));
    final ImageView im9= new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Walk/9.png")));
    final ImageView im10= new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Walk/10.png")));
    
    
    final ImageView Im1= new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Dead/1.png")));
    final ImageView Im2= new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Dead/2.png")));
    final ImageView Im3= new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Dead/3.png")));
    final ImageView Im4= new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Dead/4.png")));
    final ImageView Im5= new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Dead/5.png")));
    final ImageView Im6= new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Dead/6.png")));
    final ImageView Im7= new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Dead/7.png")));
    final ImageView Im8= new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Dead/8.png")));

    Zombie(int row) {
        //////////////////////////////////////////
        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE); 
        view = new Group(im1);
        move = true ;
        speed = 1f;// to be edited
        damage = 0.05f;
    
        
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
    
        //////////////////////////////////////////////////////////
        
        
        deadLine = new Timeline();
        
        deadLine.getKeyFrames().add(new KeyFrame(
                Duration.millis(10),(ActionEvent e) -> {
                    view.getChildren().setAll(Im1);
                }));
        
        
        deadLine.getKeyFrames().add(new KeyFrame(
                Duration.millis(90),(ActionEvent e) -> {
                    view.getChildren().setAll(Im2);
                }));
        
        deadLine.getKeyFrames().add(new KeyFrame(
                Duration.millis(180),(ActionEvent e) -> {
                    view.getChildren().setAll(Im3);
                }));
        
        deadLine.getKeyFrames().add(new KeyFrame(
                Duration.millis(270),(ActionEvent e) -> {
                    view.getChildren().setAll(Im4);
                }));
        
        deadLine.getKeyFrames().add(new KeyFrame(
                Duration.millis(360),(ActionEvent e) -> {
                    view.getChildren().setAll(Im5);
                }));
        
        deadLine.getKeyFrames().add(new KeyFrame(
                Duration.millis(450),(ActionEvent e) -> {
                    view.getChildren().setAll(Im6);
                }));
        
        deadLine.getKeyFrames().add(new KeyFrame(
                Duration.millis(540),(ActionEvent e) -> {
                    view.getChildren().setAll(Im7);
                }));
        
        deadLine.getKeyFrames().add(new KeyFrame(
                Duration.millis(640),(ActionEvent e) -> {
                    view.getChildren().setAll(Im8);
                }));
        
        deadLine.setCycleCount(1);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        /////////////////////////////////////////////////////
        
        view.setTranslateX(750);
        switch(row){
            case 0 :
                view.setTranslateY(70);
                break;
            case 1 :
                view.setTranslateY(150);
                break;
            case 2 :
                view.setTranslateY(230);
                break;    
            case 3 :
                view.setTranslateY(310);
                break;
            case 4 :
                view.setTranslateY(400);
                break;
            
        }
        
    }

    public void setMove(boolean move){ this.move = move;} 
    
    public void setDeadTime(long now){
        this.deadTime = now;
    }
    
    public long getDeadTime(){
    return deadTime;}
    
    @Override
    public void setIsAlive(boolean x){
        super.setIsAlive(x);
        switchTimeLine();
    }
    
    
    private void switchTimeLine(){
        this.deadTime= System.currentTimeMillis();
        timeline.stop();
        deadLine.play();
        FadeTransition fadeout = new FadeTransition(Duration.millis(800),view);
        fadeout.setFromValue(1.0);
        fadeout.setToValue(0.2);
        fadeout.play();
    
    }
    
    
    public float getDamage(){ return this.damage;}
    
    
    @Override
    public void update() {
        if (this.health<= 0){setIsAlive(false);}
        
        if (isAlive && move){
            view.setTranslateX(view.getTranslateX()-speed);   }
    }
        
    
}
