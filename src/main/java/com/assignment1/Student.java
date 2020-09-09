/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment1;

import java.time.DayOfWeek;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author ornha
 */

// This is the Student class and it extends the SchoolUser class
public class Student extends SchoolUsers{
    private final int ID;
    IDGenerator IDgenerator = new IDGenerator(); // generates a new ID
    private Set <Lessons> myLessons = new HashSet();
    private SchoolDataBase register = new SchoolDataBase();
    
    // this is the constructor of this class

    /**
     *
     * @param fullName
     * @param address
     * @param telephoneNumber
     */
    public Student(String fullName, String address,int telephoneNumber){
      super(fullName,address,telephoneNumber);
      ID = IDgenerator.getStudentID();
      register.registerStudent(this);
        
    }
    
  

    /**
     *
     * @return
     */  // gets student ID
    @Override
    public int getID(){
        return ID;
    }
    
    // gets students name

    /**
     *
     * @return
     */// gets students name
   @Override
    public String getName() {
        return fullName;
    }
    
    

    /**
     *
     * @return
     *///gets students address
    @Override
    public String getAddress(){
        return address;
    }
    
    

    /**
     *
     * @return
     */// gets students phonenumber
    @Override
    public int getTelephoneNumber(){
        return telephoneNumber;
    }
    
    
    /**
     *
     * @param lesson
     */// adds a lesson

    public void addLesson(Lessons lesson){
        myLessons.add(lesson);
    }
    
    

    /**
     *
     * @return
     */// returns lessons set
    @Override
    public Set getMyLessonsSet(){
      
        return myLessons;
    }
    
    
    /**
     *
     * @param lesson
     */// removes lesson

    public void removeLesson(Lessons lesson){
        myLessons.remove(lesson);
    }

    /**
     *
     * @return
     */
    public String getStudentsLessonsString(){
        String lessons="";
        for(Lessons l: myLessons){
            lessons += l +"\n";
        }
        return lessons;
    }
    
    

    /**
     *
     * @param day
     * @param time
     * @return
     */// checks if the student has a lessons on this day and time
    public Boolean cointainsSameDayAndtime(DayOfWeek day,String time){
        for(Lessons s : myLessons){
            if(s.getDay().equals(day)&& s.getTime().equals(time)){
                return true;
            }
        }
    return false;
    
    }
 
    /**
     *
     * @return
     */
    @Override
     public String toString(){
        return "Name:" + getName()+"\n" +
                "ID: " + getID() + "\n"+
                "Address: " + getAddress() + "\n" +
                "Telephone: " + getTelephoneNumber() + "\n\n"+
                "Lessons: " + getMyLessonsSet()+ "\n";
    }
}
