/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment1;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author ornha
 */
public class Parents implements Users{
    
    private final String name;
    private Set <OfficeHours>myAppointments;
    
    

    /**
     *
     * @param name
     */// This is the constructor for this class
    public Parents(String name){
        this.name = name;
        myAppointments = new HashSet();
    }
    
    // adds an appointment 

    /**
     *
     * @param officeHour
     */ // adds an appointment 
    public void myAppointments(OfficeHours officeHour){
        myAppointments.add(officeHour);
    }

    

    /**
     *
     * @return
     */// gets parent appointment
    public Set getAppointments(){
        return myAppointments;
    }
    
    

    /**
     *
     * @return
     */// gets parent name
    @Override
    public String getName() {
       return name;
    }

    /**
     *
     * @return
     */
    @Override
        public String toString(){
        return "Parent Name:" + getName()+"\n";
                
                }

    /**
     *
     * @return
     */
    @Override
    public String getAddress() {
       return null;
    }

    /**
     *
     * @return
     */
    @Override
    public int getID() {
        return -1;
    }

    /**
     *
     * @return
     */
    @Override
    public int getTelephoneNumber() {
     return -1;
    }

    /**
     *
     * @return
     */
    @Override
    public Set getMyLessonsSet() {
        return null;
    }

    /**
     *
     * @return
     */
    @Override
    public OfficeHours getMyOfficeHours() {
        return null;
    }

}
