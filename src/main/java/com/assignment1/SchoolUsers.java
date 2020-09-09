/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment1;
import java.util.Set;

/**
 *
 * @author ornha
 */

// this class is the parent class of Tutors and Students and it implements the Users interface
public class SchoolUsers implements Users {

    protected final String fullName;
    protected final String address;
    protected final int telephoneNumber;
    private final int ID;
    IDGenerator IDgenerator = new IDGenerator();
    
    // this is the constructor for the class

    /**
     *
     * @param fullName
     * @param address
     * @param telephoneNumber
     */
    public SchoolUsers(String fullName, String address,int telephoneNumber){
        this.fullName = fullName;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        ID = IDgenerator.getID();
    }
    
  

    /**
     *
     * @return
     */  // returns ID
    public int getID(){
        return ID;
    }
    
    

    /**
     *
     * @return
     */// returns name
   @Override
    public String getName() {
        return fullName;
    }
    
    

    /**
     *
     * @return
     */// returns address
    @Override
    public String getAddress(){
        return address;
    }
    
   

    /**
     *
     * @return
     */ // returns phone number
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
        return "Name:" + getName()+"\n" +
                "ID: " + getID() + "\n"+
                "Address: " + getAddress() + "\n" +
                "Telephone: " + getTelephoneNumber();
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
     * @param officeHour
     */
    @Override
    public void myAppointments(OfficeHours officeHour) {
       
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
        
    
    
