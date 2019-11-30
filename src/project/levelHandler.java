/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import com.sun.javafx.font.freetype.HBGlyphLayout;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.scene.Group;
import javafx.scene.control.ProgressBar;


/**
 *
 * @author verma
 */
public class levelHandler implements Serializable {
    private int level;
    private int zombieCount;
    private long lastZombieAdded;
    private transient static ArrayList<ArrayList<Plant>> plantList;
    private ArrayList<ArrayList<Zombie>> zombieList;
    private transient static ArrayList<ArrayList<Pea>> peaList;
    private static ArrayList<Sun> sunList;
    private float spawnTime; // Zombie 
    private final float sunTime ;
    private long lastSunAdded;
    private ArrayList<LawnMower> lawnMowerList ; 
    private transient ProgressBar progress ;
    private double wZombieOffset;  // progress bar
    



    //////plant remove 
    private static HashMap<Integer , Plant> plantMap ;


////////////////////for serialization
    private static final long serialVersionUID = 42L;
    
    private  ArrayList<ArrayList<Plant>> plantList1;  
    /// for zombie wave
    private static boolean[] placed = new boolean[45];
    
    private int wState ;//wave state
    private float wTimeGap;
    private int wZombieCount;
    private float wSpawnTime;
    private final int MAX_WAVE ;
    private float initialWait ;
    private long timeInstant ; // store time instant when levelhandler instantiate, initial time delay
    private boolean warning;
    private boolean preparation ;
    private float minimumWaveTime ;
    public levelHandler(int level){
      this.level = level;
        preparation = true;
        warning = true;
        MAX_WAVE = 4;// to be changed 
        
        setZombieCount();
        lastZombieAdded = 0L;
        lastSunAdded = 0L;
        sunTime = 5;
        
        lawnMowerList = new ArrayList<LawnMower>();
        zombieList = new ArrayList<ArrayList<Zombie>>();
        containers();
        plantList1 = plantList;
        wState=1;
        setWaveParameters();
        initialWait = 4;
        timeInstant = System.currentTimeMillis();
        minimumWaveTime = 0f;
        plantMap = new HashMap<Integer, Plant>();
        
    }
    
    public static void restart(){
        for(int x =0 ;x<45;x++){
            placed[x] = false;
            if (plantMap.containsKey(x)){
                plantMap.get(x).setIsAlive(false);
            }
        
        }
        
        plantMap = new HashMap<Integer, Plant>();
        
    }
    
    
//    public static int getSunCount(){return sunToken;}
    public void setZombieCount(){
        switch(level){
            case 1 :
                zombieCount =1;
                spawnTime = 1;//to be changed
                wTimeGap = 1;
                break;
            case 2:
                zombieCount = 1;
                spawnTime = 1;
                wTimeGap = 1;
                break;
            case 3 :
                zombieCount = 1 ;
                spawnTime = 1;
                wTimeGap = 1;
                break;
            case 4:
                zombieCount = 1;
                spawnTime = 1;
                wTimeGap = 1;
                break;
            case 5 :
                zombieCount = 1;
                spawnTime = 1;
                wTimeGap = 1;
                break;
        }
    }
    public void containers(){
        ////////////
        
        plantList = new ArrayList<ArrayList<Plant>>();
        
        peaList = new ArrayList<ArrayList<Pea>>();
        sunList = new ArrayList<Sun>();
        
        progress = new ProgressBar(0);
        progress.setLayoutX(50);
//        progress.setRotate(180);
        
        
        Project.addToGroup(new Group(progress));
        
        
        for (int x = 0 ; x<5 ;x++){
            plantList.add(new ArrayList<Plant>());

            if(zombieList.size()<5){
                zombieList.add(new ArrayList<Zombie>());
            }
            peaList.add(new ArrayList<Pea>());
            if (lawnMowerList.size()<5){
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
        }
    
    
    
    
    }  
    public void load(){
       ////////////////////
       containers();
       plantList = plantList1;
       for (int x = 0 ; x< lawnMowerList.size();x++){
            lawnMowerList.get(x).load();
            
        }
        
       System.out.println(plantList.size());
        for (int x = 0 ; x<plantList.size();x++){
            for (int i =  0 ; i < plantList.get(x).size();i++){ 
                plantList.get(x).get(i).load();
            }
        }
        for (int x = 0 ; x<zombieList.size();x++){
            for (int i =  0 ; i < zombieList.get(x).size();i++){
               zombieList.get(x).get(i).load();
            }
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
                
             
             
            }
        }
        boolean[] arr  =  new boolean[5];
        int zombieCount  =0 ;
//        System.out.println("1111"+zombieList.size());
        for (int x = 0 ; x<zombieList.size();x++){

            
            try{
                arr [x] = (zombieList.get(x).size()>0)?true:false;
            }catch(Exception e){
//                System.out.println(zombieList.get(x).size());
                System.out.println("Exception");
            }
            for (int i =  0 ; i < zombieList.get(x).size();i++){
                if (zombieList.get(x).get(i).getIsAlive()){
                    zombieCount += 1;
                    zombieList.get(x).get(i).update();
                    Project.addToGroup(zombieList.get(x).get(i).getView());}
                else if (System.currentTimeMillis()-zombieList.get(x).get(i).getDeadTime()>700){
                    Project.removeFromGroup(zombieList.get(x).get(i).getView());
                    zombieList.get(x).remove(zombieList.get(x).get(i));
                    Project.getUser().setScore(Project.getUser().getScore()+20);
                    ///////////////increment score
                
                }
            }
        }
        if (!warning && wZombieCount <=0 && zombieCount ==0 && (System.currentTimeMillis() - timeInstant) > minimumWaveTime*1000){
            System.out.println("wave is "+ wState);
            if (wState < MAX_WAVE){
                wState ++;
                setWaveParameters();
                warning = true;
            }
            else{
                throw new GameWinning();
            }
            
        }
        
        
        
        for (int x = 0 ; x<plantList.size();x++){
            for (int i =  0 ; i < plantList.get(x).size();i++){ 
                if (plantList.get(x).get(i).getIsAlive()){
                    plantList.get(x).get(i).update();
                    if (plantList.get(x).get(i) instanceof Shooter ){
                        Shooter shooter = (Shooter)plantList.get(x).get(i);
                        shooter.setShoot(arr[x]);
                    }
                    if (!plantMap.containsKey(plantList.get(x).get(i))){
                        plantMap.put(plantList.get(x).get(i).getBoxNum(),plantList.get(x).get(i));
                    }
                    Project.addToGroup(plantList.get(x).get(i).getView()); }
                else {
                    Project.removeFromGroup(plantList.get(x).get(i).getView());
                    placed[plantList.get(x).get(i).getBoxNum()-1] = false;
                    plantMap.remove(plantList.get(x).get(i).getBoxNum());
                    plantList.get(x).remove(plantList.get(x).get(i));
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
                System.out.println(sunList.get(x));
                sunList.remove(sunList.get(x));
                level1Controller.setSunCount(level1Controller.getSunCount()+25);
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
                boolean willStayAlive = true ;
                for (int t = 0 ; t<plantList.get(x).size();t++){
                    if (plantList.get(x).get(t).isColliding(zombieList.get(x).get(i))){
                        if (plantList.get(x).get(t) instanceof PotatoMine){
                            PotatoMine mine = (PotatoMine)plantList.get(x).get(t);
                            if (mine.isBlasting()){
                                willStayAlive = false;
                            }
                            else {
                                mine.setHealth(0);
                            }
                        }
                        else {
                            plantList.get(x).get(t).setHealth(plantList.get(x).get(t).getHealth() - zombieList.get(x).get(i).getDamage() );
                            zMove= false;
                        }
                        
                        
                    }
                }
                zombieList.get(x).get(i).setMove(zMove);
                if (willStayAlive == false){
                    zombieList.get(x).get(i).setHealth(0);
                }
            }
        }
        
        
        
        
        
        //////////////////to be edited
    }
    
    
    public void removePlant(int boxNum){
        plantMap.get(boxNum).setIsAlive(false);
        
    
    }
    
    
    
    
    private void setWaveParameters(){
        System.out.println("Wave: "+wState);
        switch(wState){
            case 1:
                wZombieCount = (int)zombieCount/5;
                wSpawnTime = 2*spawnTime;
                break;
            case 2:
                wZombieCount = (int)zombieCount/2;
                wSpawnTime = (float)(1.5*spawnTime);
                break;
            case 3:
                wZombieCount = zombieCount;
                wSpawnTime = spawnTime;
                break;
        }
        wZombieOffset = wZombieCount;
    
    }

    public void spawnZombies(){
        if (preparation && System.currentTimeMillis()-timeInstant <=  initialWait*1000){
            return ;
        }else if (preparation){
            preparation = false;
            timeInstant = System.currentTimeMillis();
            return;
        }
        if (wState < MAX_WAVE){
            if (warning){
                level1Controller.setWarning("Warning Wave "+ wState);
                level1Controller.setOpacity(1);
                
                if (System.currentTimeMillis()-timeInstant>wTimeGap*1000 ){
                    System.out.println("time up");
                    timeInstant = System.currentTimeMillis();
                    warning = false;
                    level1Controller.setOpacity(0);
                    // set parameters
                }
            }
            else{
               
                if (System.currentTimeMillis()-timeInstant>wSpawnTime*1000 && wZombieCount>0){
                    int ran = (int)(Math.random()*5);
                    zombieList.get(ran).add(new Zombie(ran));
                    timeInstant = System.currentTimeMillis();
                    wZombieCount -= 1;
                }
            
            }
        
        }else if (wState == MAX_WAVE){
            if (warning){
                level1Controller.setWarning("Warning Wave "+ wState);
                level1Controller.setOpacity(1);
                
                if (System.currentTimeMillis()-timeInstant>wTimeGap*1000 ){
                    System.out.println("time up");
                    timeInstant = System.currentTimeMillis();
                    warning = false;
                    level1Controller.setOpacity(0);
                    // set parameters
                }
        
            }else{
               
                if (System.currentTimeMillis()-timeInstant>wSpawnTime*1000 && wZombieCount>0){
                    int ran = (int)(Math.random()*5);
                    zombieList.get(ran).add(new Zombie(ran));
                    timeInstant = System.currentTimeMillis();
                    wZombieCount -= 1;
                }
            }
        }
        
        
        
        
        
        
    
    
    }
    
    
    
    
    public void shineSun(){
        if (System.currentTimeMillis()-lastSunAdded>=sunTime*1000){
            sunList.add(new Sun(true, 0,0));// coordinate doesn't affect anything because move is true. move - represents transition
            lastSunAdded = System.currentTimeMillis();
        }
    }
    public static void addPlant(double x , double y,int boxNum, String s ){
        
        if (placed[boxNum-1]){
            return;
        }
        placed[boxNum-1] = true;
        
        
        
        
        if(y>106 && y<222){
                if(s.equals("shooter")){
                    plantList.get(0).add(new Shooter(boxNum,0));
                }
                else if(s.equals("sunflower")){
                    plantList.get(0).add(new Sunflower(boxNum));
                }else if(s.equals("walnut")){
                    plantList.get(0).add(new Walnut(boxNum));
                }
                else if (s.equals("PotatoMine")){
                    plantList.get(0).add(new PotatoMine(boxNum));
                }
            }
            else if(y>222 && y<343){
                if(s.equals("shooter")){
                    plantList.get(1).add(new Shooter(boxNum,1));
                }
                else if(s.equals("sunflower")){
                    plantList.get(1).add(new Sunflower(boxNum));
                }else if(s.equals("walnut")){
                    plantList.get(1).add(new Walnut(boxNum));
                }
                else if (s.equals("PotatoMine")){
                    plantList.get(1).add(new PotatoMine(boxNum));
                }
            }
            else if(y>343 && y<463){
                if(s.equals("shooter")){
                    plantList.get(2).add(new Shooter(boxNum,2));
                }
                else if(s.equals("sunflower")){
                    plantList.get(2).add(new Sunflower(boxNum));
                }else if(s.equals("walnut")){
                    plantList.get(2).add(new Walnut(boxNum));
                }
                else if (s.equals("PotatoMine")){
                    plantList.get(2).add(new PotatoMine(boxNum));
                }
            }
            else if(y>463 && y<579){
                   if(s.equals("shooter")){
                       plantList.get(3).add(new Shooter(boxNum,3));
                   }
                   else if(s.equals("sunflower")){
                       plantList.get(3).add(new Sunflower(boxNum));
                   }else if(s.equals("walnut")){
                        plantList.get(3).add(new Walnut(boxNum));
                   }
                else if (s.equals("PotatoMine")){
                    plantList.get(3).add(new PotatoMine(boxNum));
                }
            }
            else if(y>579 && y<709){
                   if(s.equals("shooter")){
                       plantList.get(4).add(new Shooter(boxNum,4));
                   }
                   else if(s.equals("sunflower")){
                       plantList.get(4).add(new Sunflower(boxNum));
                   }else if(s.equals("walnut")){
                        plantList.get(4).add(new Walnut(boxNum));
                    }
                else if (s.equals("PotatoMine")){
                    plantList.get(4).add(new PotatoMine(boxNum));
                }
            }
        
        //405 490 595 681 783 871 962 1047 1152
        

        
        
    }
    
    
    public static void addPea(double x , double y,int row){
        peaList.get(row).add(new Pea(x , y));
    }
    public static void addSun(double x , double y ){
        sunList.add(new Sun(false, x, y));
    }
    
}
