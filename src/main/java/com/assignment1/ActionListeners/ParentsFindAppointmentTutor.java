/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment1.ActionListeners;

import TimeTable.TimeTableController;
import com.assignment1.SchoolDataBase;
import com.assignment1.Tutors;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import com.assignment1.Users;

/**
 *
 * @author ornha
 */

// this class allows Parents to search for appointments with tutors name
public class ParentsFindAppointmentTutor implements ActionListener {
 private SchoolDataBase register;
 private TimeTableController time;
 private Tutors tutor;    
 private JComboBox comboBox;    
 private Users parent;
 JEditorPane editor;
 


    /**
     *
     * @param parent
     * @param comboBox
     * @param time
     * @param editor
     */ //This is the constructor of the class
 public ParentsFindAppointmentTutor(Users parent, JComboBox comboBox, TimeTableController time,JEditorPane editor){
     register = new SchoolDataBase();
     this.time = time;
     this.comboBox=comboBox;
     this.editor = editor;
     this.parent=parent;
     
 }

    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String tutorString = (String)comboBox.getSelectedItem();
        
        // calls the method passing the tutor selected in the dropdown menu
        switch(tutorString){
            
            case "Pablo Picasso":
               getAppointmentsPerWeek(tutorString); 
                break;
                
                case "Salvador Dali":
                getAppointmentsPerWeek(tutorString);
                break;
                
                case "Barry McGee":
                getAppointmentsPerWeek(tutorString);
                break;
                
                case "Frida Kahlo":
                getAppointmentsPerWeek(tutorString);
                break;
                
                case "Claude Monet":
                getAppointmentsPerWeek(tutorString);
                break;
                
                default:
                editor.setText("Woops! \nPlease select a tutor!");   
                break;
         
    }
      
    }
    
   

    /**
     *
     * @param tutorString
     */ // This method prints out all appointmetns available by the tutor
    public void getAppointmentsPerWeek(String tutorString){
                editor.setText("");
                tutor = register.getTutor(tutorString);
                editor.setText( time.getTutorsAppointment(tutor,parent));
                
    }
    
}
