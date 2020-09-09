/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment1;

/**
 *
 * @author ornha
 */
// This class is a part of UserFactory where new students and parents can sign up
public class OrderUser {
    
    UserFactory factory;
    

    /**
     *
     * @param factory
     */
    // This is the constructor of the class, it takes a factory object as an argument
    public OrderUser(UserFactory factory){
       this.factory = factory;
    }
    
    

    /**
     *
     * @param typeOfUser
     * @param name
     * @param address
     * @param telephoneNr
     * @return
     */// A method that creates a user by sending a String value to the factory
       public Users orderUser(String typeOfUser, String name, String address, int telephoneNr){
       Users user;
       
       user = factory.createUser(typeOfUser,name,address,telephoneNr);
       return user;
    }
        
       

    /**
     *
     * @param typeOfUser
     * @param name
     * @return
     */// this method orders a new Parent object
       public Users orderUser(String typeOfUser, String name){
       Users user = null;
       
       user = factory.createUser(typeOfUser,name,"");
        
        return user;
    }
    
}
