/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

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
    
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
        System.out.println("Score is "+ score);
    }
    
    public String toString(){
        return new String(this.name + " :" + score);
    
}
    
    
    public User(String name){
        this.name =name;
        this.currentLevel=1;
        this.isLevelCompleted=true;
        this.diamonds=0;
        this.level = new levelHandler(1);
        this.score= 0;
        System.out.println(getUserList());
    }
    
    public String getName(){return name;}
    
    
    
    public void restart(){
        this.level = new levelHandler(currentLevel);
    }
    
    
    public void update() {
        level.update();       
    }
    
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
        try{
            Pattern pat = Pattern.compile("[a-zA-Z0-9]+.zzz");
            Matcher m = pat.matcher(s);
            m.find();
            String g = m.group(0);
            return g.substring(0,g.lastIndexOf(".")).trim();
        }
        catch(IllegalStateException e){
            System.out.println("parse Player error");
            return "";
        }
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
