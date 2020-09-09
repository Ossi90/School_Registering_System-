 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment1.ActionListeners;

import TimeTable.TimeTableController;
import com.assignment1.SchoolDataBase;
import com.assignment1.Tutors;
import com.assignment1.Users;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;

/**
 *
 * @author ornha
 */
// This class allows parents to find tutors by entering lessons
public class ParentsFindLessonListener implements ActionListener {

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
     */// This is the constructor for the class
 public ParentsFindLessonListener(Users parent,JComboBox comboBox, TimeTableController time,JEditorPane editor){
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
           String lessonString = (String)comboBox.getSelectedItem();
           
           // calls a methd passing the lesson selected from the dropdown menu
        switch(lessonString){
            
                case "English":
               getAppointmentsPerWeek(lessonString); 
                break;
                
                case "Math":
                getAppointmentsPerWeek(lessonString);
                break;
                
                case "French":
                getAppointmentsPerWeek(lessonString);
                break;
                
                case "Programming":
                getAppointmentsPerWeek(lessonString);
                break;
                
                case "Science":
                getAppointmentsPerWeek(lessonString);
                break;
                
                case "Database":
                getAppointmentsPerWeek(lessonString); 
                break;
                
                case "User Experience":
                getAppointmentsPerWeek(lessonString);
                break;
                
                case "Spanish":
                getAppointmentsPerWeek(lessonString);
                break;
                
                case "History":
                getAppointmentsPerWeek(lessonString);
                break;
                
                case "Web Design":
                getAppointmentsPerWeek(lessonString);
                break;
                
                default:
                editor.setText("Woops! \nPlease select a lesson!");   
                break;
         
    }
        
    }
    
     
    /**
     *
     * @param lessonString
     */// This method prints all appointmetns for the tutor teaching the lesson

     public void getAppointmentsPerWeek(String lessonString){
                editor.setText("");
                tutor = register.findTutorByLesson(lessonString);
                editor.setText( time.getTutorsAppointment(tutor,parent));
            
    }
    
}
