/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author verma
 */
public class User implements Serializable{

    private static final long serialVersionUID = 42L;
    private int diamonds;
    private int currentLevel;
    private boolean isLevelCompleted;
    private String name ;
    private levelHandler level;
    private int score;
    private int maxLevelReached ;
    private String exception ;
    
    
    public String getException(){
        return exception;
    }
    
    
    
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
        
    }
    public int getMaxLevelReached(){ return maxLevelReached;}
    
    @Override
    public String toString(){
        return new String(this.name + " :" + score);
    
}
    
    
    public User(String name){
        this.name =name;
        this.currentLevel=1;
        this.isLevelCompleted=false;
        this.diamonds=0;
        this.level = new levelHandler(1);
        this.score= 0;
     
    }
    
    public void setLevelCompleted (boolean x){ isLevelCompleted =x;}
    
    public boolean getLevelCompleted (){ return isLevelCompleted;}
    
    
    
    
    public void resume(){
        
        if (isLevelCompleted){
            currentLevel +=1;
//            Project.restartGame();
            
        }
        
        if (maxLevelReached < currentLevel){
            maxLevelReached = currentLevel;
        }
    }
    
    
    
    public String getName(){return name;}
    public int getLevel(){
        return currentLevel;
    }
    
    
    public void restart(){
        this.level = new levelHandler(currentLevel);
        this.level.restart();

    }
    public void NextLevel(){
        currentLevel += 1;
        this.level = new levelHandler(currentLevel);
        isLevelCompleted = false;
        level.restart();
        System.out.println(currentLevel+" level");
        if (maxLevelReached < currentLevel){
            maxLevelReached = currentLevel;
        }
    }
    
    public void update()  {
        
        try{
            level.update();
            exception = "";
        } 
        catch (ZombieReached z){
            try{
                exception = "ZombieReached";
                System.out.println("Zombie Reached");
//                Project.restartGame();
                isLevelCompleted = false;
                level1Controller.getReference().lose();}
            catch(IOException e){
                e.printStackTrace();
                System.out.println("IO Exception User class");
            }

        }
        catch (GameWinning g){
            /// change fxml
            isLevelCompleted = true ;
            try{
                exception = "GameeWinning";
                level1Controller.getReference().userWon();
            }
            catch(IOException e){
                System.out.println("IO Exception User class");
            }
            catch(NullPointerException n){
            }

        }    
    }
    
    public levelHandler getLevelInstance(){ return level;}
    
    
    public static boolean doesExists(String name ){
        File file = new File(System.getProperty("user.dir")+"\\userFiles\\");
        File [] ls = file.listFiles();
        
        for (File fs : ls){
            if (fs.toString().endsWith(".zzz")&& name.trim().equals(parsePlayer(fs.toString()))){
                return true;
                
            }
        }
        return false;
    }
    private static String parsePlayer(String s){
        
        
        return s.substring(s.lastIndexOf("\\")+1,s.lastIndexOf("."));
        
    }   
    public static String[] getPlayerList(){
        File file = new File(System.getProperty("user.dir")+"\\userFiles\\");
        File[] ls = file.listFiles();
        HashMap <String,String> Player_list = new HashMap<String,String>();
        for (File fs : ls){
            if (fs.toString().endsWith(".zzz")){
                Player_list.put(parsePlayer(fs.toString()),fs.toString());
            }
        }
        String [] arr = Player_list.keySet().toArray(new String[0]);
        return arr;
        
    }
    public void load (){
        level.load();
    
    }
    
    public static ArrayList<User> getUserList() {
        String [] arr = getPlayerList();
        
        ArrayList<User> list = new ArrayList<User>();
        
        for(String s : arr){
            try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(System.getProperty("user.dir")+"//userFiles//"+s+".zzz"));
            list.add((User)in.readObject());
            }catch(Exception e){
               
                System.out.println(s);
            }
        
        }
        
        Collections.sort(list, UserComparator.getComparator());
           
        return list;
            
            
        
    } 
    
    
}
