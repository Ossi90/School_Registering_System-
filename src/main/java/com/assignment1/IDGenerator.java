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
/*
A SingleTon pattern used for creating ID's for students and Ttutors 
**/
public class IDGenerator {
    
    
    private static IDGenerator idGenerator = null;

    /**
     *
     */
    public static int ID = 0;

    /**
     *
     */
    public static int studentID = 2000;

    /**
     *
     */
    public static int tutorID = 7000;

    /**
     *
     * @return
     */
    public static IDGenerator getInstance() {
        if (idGenerator == null) {
            idGenerator = new IDGenerator();
        }
        return idGenerator;
    }
    
    /**
     *
     */
    public IDGenerator(){
    
    }
    
    /**
     *
     * @return
     */
    public synchronized int getStudentID() {
        return studentID+=10;
    }
      
    /**
     *
     * @return
     */
    public synchronized int getTutorID() {
        return tutorID+=10;
    }
       
    /**
     *
     * @return
     */
    public synchronized int getID() {
        return ID+=10;
    }
}
