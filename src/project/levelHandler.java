/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.ArrayList;
import java.util.Random;


/**
 *
 * @author verma
 */
public class levelHandler {
    private int level;
    private int zombieCount;
    private long lastZombieAdded;
    private static ArrayList<ArrayList<Plant>> plantList;
    private ArrayList<ArrayList<Zombie>> zombieList;
    private static ArrayList<ArrayList<Pea>> peaList;
    private static ArrayList<Sun> sunList;
    private float spawnTime; // Zombie 
    private float sunTime ;
    private long lastSunAdded;
    private static int sunToken;
    private ArrayList<LawnMower> lawnMowerList ; 
    
    
    
    
    public levelHandler(int level){
        this.level = level;
        setZombieCount();
        
        plantList = new ArrayList<ArrayList<Plant>>();
        zombieList = new ArrayList<ArrayList<Zombie>>();
        peaList = new ArrayList<ArrayList<Pea>>();
        sunList = new ArrayList<Sun>();
        lawnMowerList = new ArrayList<LawnMower>();        
        
        
        
        
        for (int x = 0 ; x<5 ;x++){
        plantList.add(new ArrayList<Plant>());
        zombieList.add(new ArrayList<Zombie>());
        peaList.add(new ArrayList<Pea>());
        switch(x){
            case 0 :
                lawnMowerList.add(new LawnMower(220,135));
                break;
            case 1 :
                lawnMowerList.add(new LawnMower(220,255));
                break;
            case 2 :
                lawnMowerList.add(new LawnMower(220,375));
                break;
            case 3 :
                lawnMowerList.add(new LawnMower(220,495));
                break;
            case 4 :
                lawnMowerList.add(new LawnMower(220,615));
                break;
                
        }
        
        }
        sunToken= 0;
        lastZombieAdded = 0L;
        lastSunAdded = 0L;
        sunTime = 5;
        
       
    }
    
    
    public static int getSunCount(){return sunToken;}
    
    
    public void setZombieCount(){
        switch(level){
            case 1 :
                zombieCount = 5 ;
                spawnTime = 6;//to be changed
         
                break;
            case 2:
                zombieCount = 10;
                spawnTime = 7;
         
                break;
            case 3 :
                zombieCount = 15 ;
                spawnTime = 4;
         
                break;
            case 4:
                zombieCount = 20;
                spawnTime = 2;
         
                break;
            case 5 :
                zombieCount = 25;
                spawnTime = 1;
         
                break;
        }
    }
    
    public void update(){
        spawnZombies();
        shineSun();
        
        
        ////////////////////////////////////////////////////////////////////
        for (int x = 0 ; x< lawnMowerList.size();x++){
            if (lawnMowerList.get(x).getIsAlive()){
            lawnMowerList.get(x).update();
            Project.addToGroup(lawnMowerList.get(x).getView());
            }else{
                Project.removeFromGroup(lawnMowerList.get(x).getView());
                //lawnMowerList.remove(lawnMowerList.get(x));
             
             
            }
        }
        for (int x = 0 ; x<plantList.size();x++){
            for (int i =  0 ; i < plantList.get(x).size();i++){ 
                if (plantList.get(x).get(i).getIsAlive()){
                    plantList.get(x).get(i).update();
                    Project.addToGroup(plantList.get(x).get(i).getView()); }
                else {
                    Project.removeFromGroup(plantList.get(x).get(i).getView());
                    plantList.get(x).remove(plantList.get(x).get(i));
                }
            }
        }
        for (int x = 0 ; x<zombieList.size();x++){
            for (int i =  0 ; i < zombieList.get(x).size();i++){
                if (zombieList.get(x).get(i).getIsAlive()){
                zombieList.get(x).get(i).update();
                 Project.addToGroup(zombieList.get(x).get(i).getView());}
                else if (System.currentTimeMillis()-zombieList.get(x).get(i).getDeadTime()>700){
                Project.removeFromGroup(zombieList.get(x).get(i).getView());
                zombieList.get(x).remove(zombieList.get(x).get(i));
                ///////////////increment score
                
                }
            }
        }
        for (int x = 0 ; x<peaList.size();x++){
            for (int i =  0 ; i < peaList.get(x).size();i++){
                if (peaList.get(x).get(i).getIsAlive()){
                    peaList.get(x).get(i).update();
                    Project.addToGroup(peaList.get(x).get(i).getView());
                }else {
                    Project.removeFromGroup(peaList.get(x).get(i).getView());
                    peaList.get(x).remove(peaList.get(x).get(i));

                }
            }
        }
        
        for (int x = 0 ; x<sunList.size();x++){
            if (sunList.get(x).getIsAlive()){
            sunList.get(x).update();
            Project.addToGroup(sunList.get(x).getView());}
            else{
                Project.removeFromGroup(sunList.get(x).getView());
                sunList.remove(sunList.get(x));
                sunToken += 25;
                level1Controller.setSunCount(level1Controller.getSunCount()+10);
            }
        }
        
        for (int x = 0 ; x<lawnMowerList.size();x++){
            for (int i = 0 ; i < zombieList.get(x).size(); i++){
                if (lawnMowerList.get(x).isColliding(zombieList.get(x).get(i)) && lawnMowerList.get(x).getIsAlive() && zombieList.get(x).get(i).getIsAlive() ){
                    System.out.println("uuhch");
                    
                    zombieList.get(x).get(i).setIsAlive(false);
                    lawnMowerList.get(x).moveNow();
                }
            }
        } 
        
        for (int x = 0 ; x<5;x++){
            for(int i = 0 ; i<zombieList.get(x).size();i++){
                
                for (int t = 0 ; t<peaList.get(x).size();t++){
                    if ( peaList.get(x).get(t).getIsAlive() && peaList.get(x).get(t).isColliding(zombieList.get(x).get(i))){
                        peaList.get(x).get(t).setIsAlive(false);
                        zombieList.get(x).get(i).setHealth(zombieList.get(x).get(i).getHealth()- peaList.get(x).get(t).getDamage() );
                    }
                }
                
            }
        }
        
        for (int x = 0 ; x<5;x++){
            for(int i = 0 ; i<zombieList.get(x).size();i++){
                boolean zMove = true ;
                for (int t = 0 ; t<plantList.get(x).size();t++){
                    if (plantList.get(x).get(t).isColliding(zombieList.get(x).get(i))){
                        plantList.get(x).get(t).setHealth(plantList.get(x).get(t).getHealth() - zombieList.get(x).get(i).getDamage() );
                        zMove= false;
                    }
                }
                zombieList.get(x).get(i).setMove(zMove);
            }
        }
        
        
        
        
        
        //////////////////to be edited
    }
    
    public void spawnZombies(){
        if (System.currentTimeMillis()-lastZombieAdded>=spawnTime*1000 && zombieCount-- > 0){
            Random r = new Random();
            int ran = r.nextInt(5);
            zombieList.get(ran).add(new Zombie(ran));
            lastZombieAdded = System.currentTimeMillis();
            
        }
    }
    
    public void shineSun(){
        if (System.currentTimeMillis()-lastSunAdded>=sunTime*1000){
            sunList.add(new Sun(true, 0,0));// coordinate doesn't affect anything because move is true. move - represents transition
            lastSunAdded = System.currentTimeMillis();
        }
    }
    public static void addPlant(double x , double y, String s ){
        if (s.equals("shooter")){
           if(28<=y && y<117){
               plantList.get(0).add(new Shooter(x,y,0) );
           }
           else if (117<=y && y<202){
               plantList.get(1).add(new Shooter(x,y,1));  
           }
           else if (202<=y && y<294){
               plantList.get(2).add(new Shooter(x,y,2));
           }
           else if (294<=y && y<380){
               plantList.get(3).add(new Shooter(x,y,3));
           }else if(y<=380 && y<471){
               plantList.get(4).add(new Shooter(x,y,4));
           }
        }
        else if (s.equals("sunflower")){
           if(28<=y && y<117){
               plantList.get(0).add(new Sunflower(x,y) );
           }
           else if (117<=y && y<202){
               plantList.get(1).add(new Sunflower(x,y));  
           }
           else if (202<=y && y<294){
               plantList.get(2).add(new Sunflower(x,y));
           }
           else if (294<=y && y<380){
               plantList.get(3).add(new Sunflower(x,y));
           }else if(y<=380 && y<471){
               plantList.get(4).add(new Sunflower(x,y));
           }
        } 
        
        
        
        
    }
    
    
    public static void addPea(double x , double y,int row){
        peaList.get(row).add(new Pea(x , y));
    }
    public static void addSun(double x , double y ){
        sunList.add(new Sun(false, x, y));
    }
    
}
