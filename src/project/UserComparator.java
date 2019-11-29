/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.Comparator;

/**
 *
 * @author verma
 */
public class UserComparator implements Comparator<User> {

    private static UserComparator comparator = null;
    
    private UserComparator(){
    }
    
    public static UserComparator getComparator(){
        if (comparator == null){
            comparator = new UserComparator();
        }
        return comparator ;
        
    }
    
    @Override
    public int compare(User o1, User o2) {
        if (o1.getScore()==o2.getScore()){
            return 0;
        }
        else if (o1.getScore()> o2.getScore()){
            return -1;
        }
        else {
            return 1;
        }
    }
    
    
    
    
}
