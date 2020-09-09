
package com.assignment1.ActionListeners;

import TimeTable.TimeTableController;
import com.assignment1.Lessons;
import com.assignment1.SchoolDataBase;
import com.assignment1.Student;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ornha
 */

// this class allows students to book lessons
public class StudentBookLesson implements ActionListener {
 private SchoolDataBase schoolData;
 private Lessons lesson;
 private Student student;
 private JComboBox lessoncomboBox;    
 private JEditorPane editor;
 private JPanel panel;
 private JFrame frame;
 private TimeTableController time;

 

    /**
     *
     * @param student
     * @param lessonComboBox
     * @param editor
     * @param panel
     * @param frame
     * @param time
     */// this is the constructor for the class
 public StudentBookLesson (Student student, JComboBox lessonComboBox, JEditorPane editor, JPanel panel, JFrame frame,TimeTableController time){
     schoolData = new SchoolDataBase();
     this.lessoncomboBox=lessonComboBox;
     this.editor = editor;
     this.student = student;
     this.editor=editor;
     this.panel = panel;
     this.frame = frame;
     this.time = time;
     
     
 }

    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
              String lessonString = (String)lessoncomboBox.getSelectedItem();
             
            // calls a methd passing the lesson selected from the dropdown menu
        switch(lessonString){
            
                case "English":
               book(lessonString); 
                break;
                
                case "Math":
                book(lessonString);
                break;
                
                case "French":
                book(lessonString);
                break;
                
                case "Programming":
                book(lessonString);
                break;
                
                case "Science":
                book(lessonString);
                break;
                
                case "Database":
                book(lessonString); 
                break;
                
                case "User Experience":
                book(lessonString);
                break;
                
                case "Spanish":
                book(lessonString);
                break;
                
                case "History":
                book(lessonString);
                break;
                
                case "Web Design":
                book(lessonString);
                break;
                
                default:
                editor.setText("Woops! \nPlease select a lesson!");   
                break;
         
    }
        
    }
    

    /**
     *
     * @param lessonString
     */// this method books the lessons 
     public void book (String lessonString){
         String outPut = "";
         
         // finds the lesson in the database
            lesson = schoolData.findLesson(lessonString);
            
             outPut =lesson.addStudent(student); // checks the lessons status
             
            if(outPut.equals("check")){ // checks if the student can be added to the lesson
                
             // adds the student to the lesson
             time.addStudentToTimeTable(student, lesson);

             
             // creates a string to be printed 
                    outPut = "You have been registerd to "+lesson.getName()+"!\n\n\n"+
                        "Lesson info:\n"
                       +"Lesson: "+ lesson.getName()+"\n"+ 
                        "Tutor: " +lesson.getTutor().getName()+"\n"+
                        "Time: " + lesson.getTime()+"\n"+
                        "Day: " + lesson.getDay()+"\n"+
                        "Location: " + lesson.getPlace()+"\n";
                    
                    // adds the lesson to the student GUI
                    editor.setText(outPut);
                    JLabel infoLabel6 = new JLabel("------------------------");
                    JLabel infoLabel1 = new JLabel(" "+lesson.getName());
                    JLabel infoLabel2 = new JLabel(" "+lesson.getTutor().getName());
                    JLabel infoLabel3 = new JLabel(" "+ lesson.getTime());
                    JLabel infoLabel4 = new JLabel(" "+lesson.getDay().toString());
                    JLabel infoLabel5 = new JLabel(" "+lesson.getPlace());
                    JLabel infoLabel7 = new JLabel("------------------------");
                    
                    // resets my lessons panel 
                    panel.add(infoLabel6);
                    panel.add(infoLabel1).setForeground(Color.BLUE);
                    panel.add(infoLabel2).setForeground(Color.BLUE);
                    panel.add(infoLabel3).setForeground(Color.BLUE);
                    panel.add(infoLabel4).setForeground(Color.BLUE);
                    panel.add(infoLabel5).setForeground(Color.BLUE);
                    panel.add(infoLabel7);
                    frame.setVisible(true);
                  
           
                 editor.setText(outPut);
            }else{
            
                // prints why student could not joint lesson
                 editor.setText(outPut);
                
            }
            
    }
}


