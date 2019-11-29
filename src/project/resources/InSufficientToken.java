/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.resources;

/**
 *
 * @author verma
 */
public class InSufficientToken extends RuntimeException{
    public InSufficientToken(String message){
        super(message);
    }
    public InSufficientToken(){}
}
