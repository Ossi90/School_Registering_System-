
package com.assignment1.ActionListeners;

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

// this class allow student to search for lessons
public class StudentFindLessons implements ActionListener {
    
 private SchoolDataBase schoolData;
 private SchoolUsers tutor;    
 private Lessons lesson;
 private JComboBox comboBox;    
 private JEditorPane editor;



    /**
     *
     * @param comboBox
     * @param schoolData
     * @param editor
     */ // this is the constructor of the class
 public StudentFindLessons(JComboBox comboBox, SchoolDataBase schoolData ,JEditorPane editor){
     schoolData = new SchoolDataBase();
     this.comboBox=comboBox;
     this.editor = editor;
     this.schoolData=schoolData;
     
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
               info(lessonString); 
                break;
                
                case "Math":
                info(lessonString);
                break;
                
                case "French":
                info(lessonString);
                break;
                
                case "Programming":
                info(lessonString);
                break;
                
                case "Science":
                info(lessonString);
                break;
                
                case "Database":
                info(lessonString); 
                break;
                
                case "User Experience":
                info(lessonString);
                break;
                
                case "Spanish":
                info(lessonString);
                break;
                
                case "History":
                info(lessonString);
                break;
                
                case "Web Design":
                info(lessonString);
                break;
                
                default:
                editor.setText("Woops! \nPlease select a lesson!");   
                break;
         
    }
        
    }
    

    /**
     *
     * @param lessonString
     */// this method finds and prints out the tutor information that is teaching the lesson
     public void info(String lessonString){
                editor.setText("");
                tutor = schoolData.findTutorByLesson(lessonString);
                lesson =  schoolData.findLesson(lessonString);
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
