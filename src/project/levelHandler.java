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
    private ArrayList<ArrayList<Plant>> plantList;
    private ArrayList<ArrayList<Zombie>> zombieList;
    private ArrayList<ArrayList<Pea>> peaList;
    private float spawnTime;
    
    public levelHandler(int level){
        this.level = level;
        setZombieCount();
        
        plantList = new ArrayList<ArrayList<Plant>>();
        zombieList = new ArrayList<ArrayList<Zombie>>();
        peaList = new ArrayList<ArrayList<Pea>>();
        
        
        
        
        for (int x = 0 ; x<5 ;x++){
        plantList.add(new ArrayList<Plant>());
        zombieList.add(new ArrayList<Zombie>());
        peaList.add(new ArrayList<Pea>());
        
        }
        
        lastZombieAdded = 0L;
        System.out.println("Level wow");
        
       
    }
    
    
    
    
    public void setZombieCount(){
        switch(level){
            case 1 :
                zombieCount = 5 ;
                spawnTime = 3;//to be changed
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
        for (int x = 0 ; x<plantList.size();x++){
            for (int i =  0 ; i < plantList.get(x).size();i++){
                plantList.get(x).get(i).update();
                Project.addToGroup(plantList.get(x).get(i).getView());
            }
        }
        for (int x = 0 ; x<zombieList.size();x++){
            for (int i =  0 ; i < zombieList.get(x).size();i++){
                zombieList.get(x).get(i).update();
                 Project.addToGroup(zombieList.get(x).get(i).getView());
            }
        }
        for (int x = 0 ; x<peaList.size();x++){
            for (int i =  0 ; i < peaList.get(x).size();i++){
                peaList.get(x).get(i).update();
                 Project.addToGroup(peaList.get(x).get(i).getView());
            }
        }
        
        //////////////////to be edited
    }
    
    public void spawnZombies(){
        if (System.currentTimeMillis()-lastZombieAdded>=spawnTime*1000 && zombieCount-- > 0){
            Random r = new Random();
            int ran = r.nextInt(5);
            zombieList.get(ran).add(new Zombie(1,ran));
            lastZombieAdded = System.currentTimeMillis();
            
        }
    }
    
    
    
    
}
