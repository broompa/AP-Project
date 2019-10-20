/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.File;
import java.util.regex.Matcher;

import java.util.regex.Pattern;

/**
 *
 * @author verma
 */
public class User {
    private int diamonds;
    private int currentLevel;
    private boolean isLevelCompleted;
    private String name ;
    /// Level type object
    
    public User(String name ){
        this.name =name ;
    }
    
    public static boolean doesExists(String name ){
        File file = new File(System.getProperty("user.dir"));
        File [] ls = file.listFiles();
        for (File fs : ls){
            if (fs.toString().endsWith(".zzz")&& name.equals(parsePlayer(fs.toString()))){
                return true;
                
            }
        }
        return false;
    }
    private static String parsePlayer(String s){
        Pattern pat = Pattern.compile("[a-zA-Z0-9]+.zzz");
        Matcher m = pat.matcher(s);
        m.find();
        String g = m.group(0);
        return g.substring(0,g.lastIndexOf("."));
        
    }   
    
    
}
