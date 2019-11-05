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
    private transient long deadTime; // store time instant when zombie's isAlive set to false
    private transient Timeline deadLine ; // dead timeline animation
    private boolean move; 
//    
//    final ImageView im1= new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Walk/1.png")));
//    final ImageView im2= new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Walk/2.png")));
//    final ImageView im3= new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Walk/3.png")));
//    final ImageView im4= new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Walk/4.png")));
//    final ImageView im5= new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Walk/5.png")));
//    final ImageView im6= new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Walk/6.png")));
//    final ImageView im7= new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Walk/7.png")));
//    final ImageView im8= new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Walk/8.png")));
//    final ImageView im9= new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Walk/9.png")));
//    final ImageView im10= new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Walk/10.png")));
//    
//    
//    final ImageView Im1= new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Dead/1.png")));
//    final ImageView Im2= new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Dead/2.png")));
//    final ImageView Im3= new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Dead/3.png")));
//    final ImageView Im4= new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Dead/4.png")));
//    final ImageView Im5= new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Dead/5.png")));
//    final ImageView Im6= new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Dead/6.png")));
//    final ImageView Im7= new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Dead/7.png")));
//    final ImageView Im8= new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Dead/8.png")));

    Zombie(int row) {
        //////////////////////////////////////////
        move = true ;
        speed = 1f;// to be edited
        damage = 0.05f;
        setImage();
    /////////////////////////////////////////////////////
        
        view.setTranslateX(1125);
        switch(row){
            case 0 :
                view.setTranslateY(105);
                break;
            case 1 :
                view.setTranslateY(225);
                break;
            case 2 :
                view.setTranslateY(345);
                break;    
            case 3 :
                view.setTranslateY(465);
                break;
            case 4 :
                view.setTranslateY(600);
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
        updateCoordiante();
    }
    
    private void setImage(){
        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE); 
        view = new Group(new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Walk/1.png"))));
        
        
        timeline.getKeyFrames().add(new KeyFrame(
                Duration.millis(100),(ActionEvent e) -> {
                    view.getChildren().setAll(new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Walk/2.png"))));
                }
        
        ));
        
        timeline.getKeyFrames().add(new KeyFrame(
                Duration.millis(200),(ActionEvent e) -> {
                    view.getChildren().setAll(new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Walk/3.png"))));
                }
        
        ));
        
        timeline.getKeyFrames().add(new KeyFrame(
                Duration.millis(300),(ActionEvent e) -> {
                    view.getChildren().setAll(new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Walk/4.png"))));
                }
        
        ));
        
        timeline.getKeyFrames().add(new KeyFrame(
                Duration.millis(400),(ActionEvent e) -> {
                    view.getChildren().setAll(new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Walk/5.png"))));
                }
        
        ));
        
        timeline.getKeyFrames().add(new KeyFrame(
                Duration.millis(500),(ActionEvent e) -> {
                    view.getChildren().setAll(new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Walk/6.png"))));
                }
        
        ));
        
        timeline.getKeyFrames().add(new KeyFrame(
                Duration.millis(600),(ActionEvent e) -> {
                    view.getChildren().setAll(new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Walk/7.png"))));
                }
        
        ));
        
        timeline.getKeyFrames().add(new KeyFrame(
                Duration.millis(700),(ActionEvent e) -> {
                    view.getChildren().setAll(new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Walk/8.png"))));
                }
        
        ));
        
        timeline.getKeyFrames().add(new KeyFrame(
                Duration.millis(800),(ActionEvent e) -> {
                    view.getChildren().setAll(new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Walk/9.png"))));
                }
        
        ));
        
        
        timeline.getKeyFrames().add(new KeyFrame(
                Duration.millis(900),(ActionEvent e) -> {
                    view.getChildren().setAll(new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Walk/10.png"))));
                }
        
        ));
        
        
        timeline.getKeyFrames().add(new KeyFrame(
                Duration.millis(0),(ActionEvent e) -> {
                    view.getChildren().setAll(new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Walk/1.png"))));
                }
        
        ));
        
        timeline.play();
    
        //////////////////////////////////////////////////////////
        
        
        deadLine = new Timeline();
        
        deadLine.getKeyFrames().add(new KeyFrame(
                Duration.millis(10),(ActionEvent e) -> {
                    view.getChildren().setAll(new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Dead/1.png"))));
                }));
        
        
        deadLine.getKeyFrames().add(new KeyFrame(
                Duration.millis(90),(ActionEvent e) -> {
                    view.getChildren().setAll(new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Dead/2.png"))));
                }));
        
        deadLine.getKeyFrames().add(new KeyFrame(
                Duration.millis(180),(ActionEvent e) -> {
                    view.getChildren().setAll(new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Dead/3.png"))));
                }));
        
        deadLine.getKeyFrames().add(new KeyFrame(
                Duration.millis(270),(ActionEvent e) -> {
                    view.getChildren().setAll(new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Dead/4.png"))));
                }));
        
        deadLine.getKeyFrames().add(new KeyFrame(
                Duration.millis(360),(ActionEvent e) -> {
                    view.getChildren().setAll(new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Dead/5.png"))));
                }));
        
        deadLine.getKeyFrames().add(new KeyFrame(
                Duration.millis(450),(ActionEvent e) -> {
                    view.getChildren().setAll(new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Dead/6.png"))));
                }));
        
        deadLine.getKeyFrames().add(new KeyFrame(
                Duration.millis(540),(ActionEvent e) -> {
                    view.getChildren().setAll(new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Dead/7.png"))));
                }));
        
        deadLine.getKeyFrames().add(new KeyFrame(
                Duration.millis(640),(ActionEvent e) -> {
                    view.getChildren().setAll(new ImageView(new Image(getClass().getResourceAsStream("/project/resources/ZombieOGA/Dead/8.png"))));
                }));
        
        deadLine.setCycleCount(1);
        
    }

    @Override
    public void load() {
        setImage();
        view.setTranslateX(px);
        view.setTranslateY(py);
    }
    
}
