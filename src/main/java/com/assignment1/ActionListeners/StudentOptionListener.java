/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment1.ActionListeners;

import TimeTable.TimeTableController;
import TimeTable.Week;
import com.assignment1.Lessons;
import com.assignment1.SchoolDataBase;
import com.assignment1.Student;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ornha
 */
// This class allows the Student to perform multiple operations such as quiting lesson, changin lesson etc.
public class StudentOptionListener implements ActionListener {
 private SchoolDataBase schoolData;
 private Lessons lesson;
 private Student student;
 private JComboBox optioncomboBox;    
 private JEditorPane editor;
 private JPanel panel;
 private JFrame frame;
 private TimeTableController time;
 private JComboBox weekComboBox;
 private JComboBox lessonComboBox;

 


    /**
     *
     * @param student
     * @param optionComboBox
     * @param weekComboBox
     * @param lessonComboBox
     * @param editor
     * @param panel
     * @param frame
     * @param time
     */ //this is the Constructor of the class
 public StudentOptionListener (Student student, 
         JComboBox optionComboBox,
         JComboBox weekComboBox,
         JComboBox lessonComboBox,
         JEditorPane editor,
         JPanel panel,
         JFrame frame,
         TimeTableController time){
     schoolData = new SchoolDataBase();
     this.optioncomboBox=optionComboBox;
     this.editor = editor;
     this.student = student;
     this.editor=editor;
     this.panel = panel;
     this.frame = frame;
     this.time = time;
     this.weekComboBox = weekComboBox;
     this.lessonComboBox = lessonComboBox;
     
     
 }

    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
             String optionString = (String)optioncomboBox.getSelectedItem();
             String weekNumber = (String)weekComboBox.getSelectedItem();
             String lessonString = (String)lessonComboBox.getSelectedItem();
             System.out.println(weekNumber +" " +lessonString);
             if(lessonString.equals("Lessons")){
                editor.setText("Woops! \nPlease select lesson and week!!"); 
             }else{
           
           // selects a method depending on the action selected from the dropdown menu
        switch(optionString){
            case "Change Lesson":
                changeLesson(lessonString);
                break;
            
            case "Cancel Lesson":
                cancelLesson(weekNumber,lessonString);
                break;
                
            case "Attend Lesson":
                attendLesson(weekNumber,lessonString);
                break;
                
            case "Quit Lesson":
                System.out.println("hi");
                 quitLesson(lessonString);
                 break;
                 
            default:
                editor.setText("Woops! \nPlease select an action!");   
                break;
                }    
           }
    }
    
    

    /**
     *
     * @param lessonString
     *///this method allows students to change Lessons
    public void changeLesson(String lessonString){
      
        // String of lessons to be added to another dropdown menu
        String[] lessonsArray ={"Lessons","English","Math","French","Programming","Science","Database","User Experience","Spanish","History","Web Design"};
        JPanel lessonPanel = new JPanel();
        lessonPanel.add(new JLabel("Please select a new lesson"));
        JComboBox newBox = new JComboBox(lessonsArray);
        lessonPanel.add(newBox);
        
        // finds old lesson in database
        Lessons Oldlesson = schoolData.findLesson(lessonString);
       
        // checks if the student is registered in the old lesson
        if(student.getMyLessonsSet().contains(Oldlesson)){
        
        // proms the user with a popup dialog where he/she can choose a new lesson    
        int result = JOptionPane.showConfirmDialog(null, lessonPanel, "Lesson", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        // finds new lesson in database
        Lessons lesson = schoolData.findLesson(newBox.getSelectedItem().toString());

        // checks if studend confirm and if the student is not already registerd to the lesson
        if(result==JOptionPane.OK_OPTION && student.getMyLessonsSet().contains(lesson) == false){
            String outPut ="";
            
            lesson = schoolData.findLesson(newBox.getSelectedItem().toString());
            
            //adds student to new lesson
            outPut =lesson.addStudent(student);
               
            if(outPut.equals("check")){ // checks the lessons status
            
            // removes student from old lesson
            student.removeLesson(Oldlesson); 
            Oldlesson.removeStudent(student);
            time.changeStudentLesson(student, lesson);
            
            //adds student to the time table
             time.addStudentToTimeTable(student, lesson);          

             // creates a string to be printed out
                    outPut = "You have been registerd to "+lesson.getName()+"!\n\n\n"+
                        "Lesson info:\n"
                       +"Lesson: "+ lesson.getName()+"\n"+ 
                        "Tutor: " +lesson.getTutor().getName()+"\n"+
                        "Time: " + lesson.getTime()+"\n"+
                        "Day: " + lesson.getDay()+"\n"+
                        "Location: " + lesson.getPlace()+"\n";
                    editor.setText(outPut);
                   
                    // refreshes the panel;
                   panelRefresh();
                      
                    frame.setVisible(true);
                  
                 
          // of something is not righ, then the messages why is printed out      
                 editor.setText(outPut);
            }else{
                 editor.setText(outPut);    
            }
   
        }else {
              editor.setText("");
            editor.setText("You are alredy registerd on this Lesson");
        }
        
        }else{
            editor.setText("");
             NotRegistered();
            
        }
        
    }
    
   

    /**
     *
     * @param weekNumber
     * @param lessonString
     */ // this method allows students to cancel a lesson
    public void cancelLesson(String weekNumber,String lessonString){
        int weekNr=0;
     try{    weekNr = Integer.parseInt(weekNumber); }
     catch( java.lang.NumberFormatException e){editor.setText("Please select a week!");}
        
        //finds lesson in database
        lesson = schoolData.findLesson(lessonString);
        if(student.getMyLessonsSet().contains(lesson)){
       String check = time.cancelStudentsLesson(student, lesson, weekNr); // cancels student in timetable
       if(check.equals("check")){
        editor.setText("");
        editor.setText(lesson.getName()+ " on week " + weekNumber+ " has been cancelled!");
      
       
    }else{
           // prints out if something goes wrong
         editor.setText("");
        editor.setText(check);    
            }
  
        
    }
    else{
               NotRegistered();
    
}
}
   

    /**
     *
     * @param weekNumber
     * @param lessonString
     */ // this method allows student to attend lesson
    public void attendLesson(String weekNumber,String lessonString){
     
      int weekNr=0;
     try{    weekNr = Integer.parseInt(weekNumber); }
     catch( java.lang.NumberFormatException e){editor.setText("Please select a week!");}
        
        //finds lesson in database
        lesson = schoolData.findLesson(lessonString);
        if(student.getMyLessonsSet().contains(lesson)){
       String check = time.attendStudentLesson(student, lesson, weekNr); // student attends in timetable
       if(check.equals("check")){
        editor.setText(lesson.getName()+" " + " attended!");
      
      
    }else{
           
           // prins out if something goes wrong
         editor.setText("");
        editor.setText(check);    
            }}else{
            NotRegistered();
        }
  
        
    }
    
    

    /**
     *
     * @param lessonString
     */// this method allows student to quit the lesson   
    public void quitLesson(String lessonString){
        
        // find lesson in database
        lesson = schoolData.findLesson(lessonString);
        if(student.getMyLessonsSet().contains(lesson)){
        // removes the lesson
        lesson.removeStudent(student);
        student.removeLesson(lesson);
        System.out.println(student);
        editor.setText("");
        editor.setText("You have been removed from " + lesson.getName());
        Week week = time.getSemester();
     
        panelRefresh();
        }else{
           NotRegistered();
            panelRefresh();
        }
        
    }
    
// this method refreshes the panel after a student has made an action.
    public void panelRefresh(){
                      panel.removeAll();
                      frame.revalidate();
                      frame.repaint();
                                      
                    
                      JLabel welcome = new JLabel("   "+ student.getName());
                      JLabel appointments = new JLabel("   "+"Lessons:");
                      Set <Lessons> lessonSet= student.getMyLessonsSet();
           
                      panel.add(welcome);
                      panel.add(appointments);
            
                     for(Lessons l: lessonSet){
                         
                      panel.add(new JLabel("------------------------"));
                      panel.add(new JLabel("   "+l.getName())).setForeground(Color.BLUE);;
                      panel.add(new JLabel("   "+l.getTutor().getName())).setForeground(Color.BLUE);;
                      panel.add(new JLabel("   "+l.getTime())).setForeground(Color.BLUE);;
                      panel.add(new JLabel("   "+l.getDay().toString())).setForeground(Color.BLUE);;
                      panel.add(new JLabel("   "+l.getPlace())).setForeground(Color.BLUE);
                      panel.add(new JLabel("------------------------"));      
                      frame.setVisible(true);    
                    }
    }
    
    public void NotRegistered(){
         editor.setText("Your are not registered on this lesson");
    }
}

