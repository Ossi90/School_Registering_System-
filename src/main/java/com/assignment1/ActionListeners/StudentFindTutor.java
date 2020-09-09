/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment1.ActionListeners;

import TimeTable.TimeTableController;
import com.assignment1.Lessons;
import com.assignment1.SchoolDataBase;
import com.assignment1.SchoolUsers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;

/**
 *
 * @author ornha
 */
// This class allows student to search for Tutors 
public class StudentFindTutor implements ActionListener {
 private SchoolDataBase schoolData;
 private SchoolDataBase register;
 private TimeTableController time;
 private SchoolUsers tutor;    
 private JComboBox comboBox;    
 JEditorPane editor;
 


    /**
     *
     * @param comboBox
     * @param time
     * @param editor
     * @param schoolData
     */ //This is the constructor of the class
 public StudentFindTutor (JComboBox comboBox, TimeTableController time,JEditorPane editor,SchoolDataBase schoolData){
     register = new SchoolDataBase();
     this.time = time;
     this.comboBox=comboBox;
     this.editor = editor;
     this.schoolData = schoolData;
 }

    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String tutorString = (String)comboBox.getSelectedItem();
           // calls a methd passing the tutor selected from the dropdown menu
        switch(tutorString){
            
            case "Pablo Picasso":
               info(tutorString); 
                break;
                
                case "Salvador Dali":
                info(tutorString);
                break;
                
                case "Barry McGee":
                info(tutorString);
                break;
                
                case "Frida Kahlo":
                info(tutorString);
                break;
                
                case "Claude Monet":
                info(tutorString);
                break;
                
                default:
                editor.setText("Woops! \nPlease select a tutor!");   
                break;
         
                }
    }
    
    

    /**
     *
     * @param tutorString
     *///This method find and prints out Tutors information
    public void info(String tutorString){
                editor.setText("");
                tutor = schoolData.getTutor(tutorString);
                Set<Lessons> tutorList = tutor.getMyLessonsSet();
                String outPut ="\nLessons: \n";
                for(Lessons l : tutorList){ 
                outPut += l.getName()+"\n" + l.getDay() +"\n";
                outPut += " "+ l.getTime()+"\n ";
                outPut += l.getPlace()+"\n ";
                outPut += "Number of Registered Students: " + l.getStudentSetSize()+ "/" + l.getMaxStudents()+ "\n";
                outPut += "--------------------------------------------------------\n";
                }
                
                 editor.setText(tutor+"\n" + outPut);
    }
    }
    
