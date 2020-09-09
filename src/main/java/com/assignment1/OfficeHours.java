/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment1;

import org.w3c.dom.ls.LSOutput;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author ornha
 */

// this class creates an office hour object for each tutor
public class OfficeHours implements School {
    private Tutors tutor;
    private DayOfWeek day;
    private String place;
    private List<Parents> parentsList;
    private List <String> tutorsOfficeHours;
    private SchoolDataBase register = new SchoolDataBase();
    private String[] timeSlotZero = {"14:00","14:20", "14:40"}; 
    private String[] timeSlotOne = {"15:00","15:20", "15:40"};
    private String[] timeSlotTwo = {"16:00","16:20", "16:40"};
    private String[] timeSlotThree = {"17:00","17:20", "17:40"};
    private String[] timeSlotFour = {"18:00","18:20", "18:40"};
    private String[][] timeSlots = {timeSlotZero,timeSlotOne,timeSlotTwo,timeSlotThree,timeSlotFour};
    
    
    // This is the constructor for the class

    /**
     *
     * @param tutor
     * @param day
     * @param appointmentSlot
     */
    public OfficeHours(Tutors tutor,DayOfWeek day,int appointmentSlot){ 
        this.tutor=tutor;
        this.day = day;
        place = "Tutors office";
        tutorsOfficeHours = new ArrayList();
        parentsList = new ArrayList();
        tutorsOfficeHours = getAppointments(appointmentSlot,tutorsOfficeHours);     
       registerActivity();
        
    }

    public SchoolDataBase getDataBase(){
        return register;
    }
    
    @Override
    public void registerActivity(){
        this.tutor.addOfficeHour(this);
        register.registerOfficeHour(this);
        
    }
 
    

    /**
     *
     * @return
     */
    // getter for the the tutor of the office hour
    @Override
  public Tutors getTutor(){
   
        return tutor;
    }
    
   

    /**
     *
     * @return
     */
   // getter for the day
    @Override
    public DayOfWeek getDay(){
        return day;
    }
    
    

    /**
     *
     * @return
     */
    //getter for the place, returns which place the office hour takes place
    @Override
    public String getPlace(){
         return place;
     }
    
    

    /**
     *
     * @return
     */
    // gets the timeslots
    @Override
    public List getTimeSlots(){
        return  tutorsOfficeHours;
    }
    
    

    /**
     *
     * @return
     */
    // get a set of parents who have an appointment 
    public List getParentsSet(){
        return parentsList;
    }
    
    

    /**
     *
     * @param parent
     * @return
     */
    // gets a specific parent that has a appointment
    @Override
    public Parents getParent(String parent){
      for(Parents p : parentsList){
       if (p.getName().equals(parent)) {
       return p;
            }
        }
        return null;
    }
    
    

    /**
     *
     * @param parent
     */
    // allows parents to book appointments
    public void BookAppointment(Parents parent){
        parentsList.add(parent);
        parent.myAppointments(this);
        
    }
  
    
    

    /**
     *
     * @param i
     * @param timeSlotList
     * @return
     */
    // get all timeslots
    public List getAppointments(int i,List<String>timeSlotList){
        /*  for(int j =0; j<3; j++){
        timeSlotList.add(timeSlots[i][j]);
        }*/
        
        timeSlotList.add(timeSlots[i][0]);
        timeSlotList.add(timeSlots[i][1]);
        timeSlotList.add(timeSlots[i][2]);

        return timeSlotList;
    }
       
    
    //

    /**
     *
     * @return
     */

    @Override
    public String toString(){
        String officeHourString ="";
        officeHourString+= "Tutor: "+tutor.getName() + "\n";

     for (String s : tutorsOfficeHours) {
		    officeHourString+= s +"\n";
		}
        return  officeHourString;              
                }

    /**
     *
     * @return
     */
    @Override
    public int getStudentSetSize() {
        return -1;
    }

    /**
     *
     * @return
     */
    @Override
    public Set getStudentsLessons() {
       return null;
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
       return null;
    }

    /**
     *
     * @return
     */
    @Override
    public int getMaxStudents() {
      return -1;
    }
    
    /**
     *
     * @return
     */
    @Override
    public Set getStudents(){
        return null;
    }
    
}
