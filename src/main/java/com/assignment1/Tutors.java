/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment1;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author ornha
 */
// This is the Tutors class and it extends the SchoolUser class
public class Tutors extends SchoolUsers {
    
    private Set <Lessons>myLessons;
    private final int ID;
    private OfficeHours officeHour;
    IDGenerator IDgenerator = new IDGenerator();
    
    // this is the constructor of the class

    /**
     *
     * @param fullName
     * @param address
     * @param telephoneNumber
     */
    public Tutors(String fullName, String address,int telephoneNumber){
         super(fullName,address,telephoneNumber);
         ID = IDgenerator.getTutorID();
         myLessons = new HashSet();
    }
    

    /**
     *
     * @return
     */// returns tutors ID
    @Override
    public int getID(){
        return ID;
    }
    
    

    /**
     *
     * @return
     */// returns tutors name
     @Override
    public String getName() {
        return fullName;
    }
    
    

    /**
     *
     * @return
     */// returns tutors address
    @Override
    public String getAddress(){
        return address;
    }
    
    

    /**
     *
     * @return
     */// returns tutors phone number
    @Override
    public int getTelephoneNumber(){
        return telephoneNumber;
    }
    
    /**
     *
     * @return
     */
    @Override
       public String toString(){
        return "Tutor:" + getName()+"\n" +
                "Address: " + getAddress() + "\n" +
                "Phone Number: " + getTelephoneNumber();
    }
       
       

    /**
     *
     * @param oh
     */// adds office hours to a list
     public void addOfficeHour(OfficeHours oh){
         this.officeHour = oh;
     }
     
     

    /**
     *
     * @param lesson
     */// adds lessons to a list
     public void addLesson(Lessons lesson){
         myLessons.add(lesson);
     }
     
    /**
     *
     * @return
     */
    @Override
      // returns all lessons
    public Set getMyLessonsSet() {
       return  myLessons;
    }

    /**
     *
     * @return
     */
    @Override
    // returns officeHours
     public OfficeHours getMyOfficeHours(){
         return officeHour;
     }
}
