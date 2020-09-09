
package com.assignment1.ActionListeners;

import TimeTable.TimeTableController;
import com.assignment1.OfficeHours;
import com.assignment1.SchoolDataBase;
import com.assignment1.Tutors;
import com.assignment1.Users;
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
public class ParentsBookListener implements ActionListener{

 private SchoolDataBase register;
 private TimeTableController time;
 private Users parent;
 private Users tutor;    
 private JComboBox tutorComboBox;    
 private JComboBox timeComboBox;    
 private JComboBox weekComboBox;
 private OfficeHours officeHours;
 private JEditorPane editor;
 private JPanel panel;
 private JFrame frame;
 
 //This is the Constructor for this class

    /**
     *
     * @param tutorComboBox
     * @param timeComboBox
     * @param weekComboBox
     * @param time
     * @param editor
     * @param parent
     * @param panel
     * @param frame
     */
 public ParentsBookListener(JComboBox tutorComboBox,
         JComboBox timeComboBox,
         JComboBox weekComboBox,
         TimeTableController time,
         JEditorPane editor,
         Users parent,
         JPanel panel,
         JFrame frame){
     
     register = new SchoolDataBase();
     this.time = time;
     this.tutorComboBox=tutorComboBox;
     this.timeComboBox=timeComboBox;
     this.weekComboBox = weekComboBox;
     this.editor = editor;
     this.parent = parent;
     this.panel = panel;
     this.frame = frame;
     
 }
     
    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String tutorString = (String)tutorComboBox.getSelectedItem();
        String weekString = (String)weekComboBox.getSelectedItem();
        String timeString = (String)timeComboBox.getSelectedItem();
        if(weekString.equals("Week") || timeString.equals("Time")){
            editor.setText("Woops! \nPlease select week and time!!"); 
        }else {
            
        // calls the method passing the tutor selected in the dropdown menu
        switch(tutorString){
            
            case "Pablo Picasso":
               book(tutorString); 
                break;
                
                case "Salvador Dali":
                book(tutorString);
                break;
                
                case "Barry McGee":
                book(tutorString);
                break;
                
                case "Frida Kahlo":
                book(tutorString);
                break;
                
                case "Claude Monet":
                book(tutorString);
                break;
                
                default:
                editor.setText("Woops! \nPlease select a tutor!");   
                break;
         
             }
        }
      
    }
    
    

    /**
     *
     * @param tutorString
     */// This method allows parents to book appointments;
    public void book(String tutorString){
            editor.setText("");
            
           String appointmentTime = (String)timeComboBox.getSelectedItem();
           String tempWeek = (String)weekComboBox.getSelectedItem();
           int week = Integer.parseInt(tempWeek);
                
            officeHours = register.getOfficeHours(tutorString);
            tutor = officeHours.getTutor();
            System.out.println(tutor);
            String outPut=time.parentBookAppointment(parent, officeHours, week, appointmentTime); // gets a string return saying what status the appoinment is in
            
            // checks if the appointmetn is available
            if(outPut.equals("check")){
                    outPut = "Your appointment has been registered!\n\n\n"+
                        "Your Appointment:\n"
                       +"Parent: "+ parent.getName()+"\n"+ 
                        "Tutor: " +tutor.getName()+"\n"+
                        "Week: " + week+"\n"+
                        "Day: " + officeHours.getDay()+"\n"+
                        "Time: " + appointmentTime +"\n"+
                        "Location: " + officeHours.getPlace()+"\n";
                    editor.setText(outPut);
                    JLabel infoLabel1 = new JLabel("Tutor: " +tutor.getName());
                    JLabel infoLabel2 = new JLabel("Week: " + week);
                    JLabel infoLabel3 = new JLabel( "Day: " + officeHours.getDay());
                    JLabel infoLabel4 = new JLabel("Time: " + appointmentTime);
                    JLabel infoLabel5 = new JLabel("Location: " + officeHours.getPlace());
                    JLabel infoLabel6 = new JLabel("--------------------------------------");
                    JLabel infoLabel7 = new JLabel("--------------------------------------");
                    panel.add(infoLabel1).setForeground(Color.BLUE);
                    panel.add(infoLabel2).setForeground(Color.BLUE);
                    panel.add(infoLabel3).setForeground(Color.BLUE);
                    panel.add(infoLabel4).setForeground(Color.BLUE);
                    panel.add(infoLabel5).setForeground(Color.BLUE);
                    panel.add(infoLabel6);
                    panel.add(infoLabel7);
                    
                    frame.setVisible(true);
                    
            }else {
                // prints why the tutor could not book the appointment
                 editor.setText(outPut);
            }
                
           
                
               
                
              
    }
    
}
