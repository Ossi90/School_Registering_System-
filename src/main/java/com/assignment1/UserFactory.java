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
// This is the factory class to create new users
public class UserFactory {
    
    
    // This method checks which user to create, Parent or Student

    /**
     *
     * @param typeOfUser
     * @param name
     * @param address
     * @param telephone
     * @return
     */
    public Users createUser(String typeOfUser, String name, String address, int ...telephone){
        Users people;
        
        if(typeOfUser.equals("student")){
            
              people = new Student(name,address,telephone[0]);
        }else{
             people = new Parents(name);
        }

        return people;
    }
    
}
