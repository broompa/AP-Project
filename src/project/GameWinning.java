/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author verma
 */
public class GameWinning extends RuntimeException {
    public GameWinning(){}
    public GameWinning (String message){
        super(message);
    }
}
