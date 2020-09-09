
package TimeTable;

import com.assignment1.Lessons;
import com.assignment1.OfficeHours;
import com.assignment1.School;
import com.assignment1.Student;
import com.assignment1.Tutors;
import static java.time.DayOfWeek.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.assignment1.Users;
/**
 *
 * @author ornha
 */
public class Week implements TimeTable {
   private Day monday = new Day(MONDAY);
   private Day tuesday = new Day(TUESDAY);
   private Day wednesday = new Day(WEDNESDAY);
   private Day thursday = new Day(THURSDAY);
   private Day friday = new Day(FRIDAY);
   private List <TimeTable> days;
   private int weekNumber;
   //private Users tutor;
    
    /**
     *
     */
    public Week(){ // constructor for this class
    weekNumber = 0;
    days = new ArrayList();
    }
    
    /**
     *
     * @param weekNumber
     */
    public Week(int weekNumber){ // overloaded constructor for this class
     this.weekNumber=weekNumber;
     days = new ArrayList();
    }
    
    
    

    /**
     *
     * @param activity
     */
// this method adds components to the this composite pattern
    public void addActivityToDay(School activity){
          
      switch(activity.getDay()){
       case MONDAY:
        monday.addActivtyToDay(activity);
        break; 
       case TUESDAY:
        tuesday.addActivtyToDay(activity);
        break;
       case WEDNESDAY:
        wednesday.addActivtyToDay(activity);
        break;
       case THURSDAY:
        thursday.addActivtyToDay(activity);
        break;
       case FRIDAY:
         friday.addActivtyToDay(activity);
       break;            
        }
    }
    
   

 // adds days into weeks    
   public void insertDaysIntoWeek(){
       days.add(monday);
       days.add(tuesday);
       days.add(wednesday);
       days.add(thursday);
       days.add(friday);
   } 
    
    /**
     *
     * @return
     */
    public int listSize(){
     return days.size();
    }
    
     
   

    /**
     *
     * @param day
     * @return
     */ 
    // checks if the day exists;
    public boolean hasDay(Day day){
        return days.contains(day);
    }
    
  

    /**
     *
     * @param week
     * @return
     */  
//checks if the week exists
    public boolean hasWeek(Week week){
        return days.contains(week);  
    }


    

    /**
     *
     * @param week
     */
// adds a single week
      public void addTime(TimeTable time){
        days.add(time);
    }
       
    /**
     *
     * @return
     */
    @Override // made for testing
   public Day getMonday(){
       return monday;
   }
   

    /**
     *
     * @return
     */
    // made for testing
      public Day getTuesday(){
       return tuesday;
   }
      





    /**
     *
     * @return
     */
   @Override
    public int getWeekOrDayNumer(){
     return weekNumber;
    }
    
    

    /**
     *
     * @param weekNr
     * @return
     */
    // finds the week numer
    public TimeTable getWeek(int weekNr){   
      for (TimeTable timeTable : days) {
      if(timeTable.getWeekOrDayNumer()==weekNr){
      return timeTable;
          }  
      
       }
       return null;
    }
    
   

    /**
     *
     * @param student
     * @param lesson
     */ 
 // calls a leaf to reamove a student from the composite pattern
   @Override
    public void removeStudent(Student student,Lessons lesson){
        for (TimeTable timeTable : days) {
            timeTable.removeStudent(student,lesson);

            }
       }  
    

    /**
     *
     * @param student
     * @param lesson
     */
    // calls a leaf to change lesson in the composite pattern
     @Override
    public void changeStudentLesson(Student student, Lessons lesson) {
           for (TimeTable timeTable : days) {

            timeTable.changeStudentLesson(student,lesson);    
        }
    }
    
    

    /**
     *
     * @param student
     * @param lesson
     */
    // calls a leaf to quit a lesson in the the composite pattern
     @Override
    public void studentQuitsLesson(Student student, Lessons lesson){
           for (TimeTable timeTable : days) {

            timeTable.studentQuitsLesson(student,lesson);    
        }
    }
    
    

    /**
     *
     * @param student
     * @param lesson
     * @return
     */
    // calls a leaf to let student attend Lesson  in the composite pattern
      @Override
    public String studentAttendsActicity(Users student,School lesson) {
        String check = "";
          for (TimeTable timeTable : days) {
                     
                if(timeTable.hasActivity(lesson) == true ){
                check =  timeTable.studentAttendsActicity(student,lesson);      
               break;
             }
        }
        
        return check;
    }
    
    

    /**
     *
     * @param student
     * @param lesson
     */
    // calls a leaf to add a student to a lesson in the composite pattern
        @Override
    public void addStudentToLesson(Users student, Lessons lesson){
     
              for (TimeTable timeTable : days) {

            timeTable.addStudentToLesson(student,lesson);      
          
         }
            
    }

    

    /**
     *
     * @param student
     * @param lesson
     * @return
     */
    // calls a leaf to let student cancel a lesson the composite pattern
    @Override
    public String cancelActivity(Users student, School lesson) {
          String check = "";
                  for (TimeTable timeTable : days) {

                if(timeTable.hasActivity(lesson) == true ){
               check =   timeTable.cancelActivity(student,lesson);
               break;
             }
        }
        return check;
    }
    
    

    /**
     *
     * @param activity
     * @param person
     * @param time
     * @param weekNr
     * @return
     */
    // calls a leaf  let student attend lesson in the composite pattern
   @Override
     public String attendActivity(School activity, Users person, String time, int weekNr) {
          String  registerResulst = "";
                  for (TimeTable timeTable : days) {
                     
                     
                if(timeTable.hasActivity(activity) == true && this.weekNumber == weekNr){
                registerResulst =  timeTable.registerActivity(activity,time,person);      
               break;
             }
        }
    return registerResulst;
     }

    /**
     *
     * @param tutor
     * @param user
     * @return
     */
    @Override
     public String getTutorsAppointments(Tutors tutor, Users user){// calls a leaf component to view tutors appointment
         String apointments = "";
         
       if(weekNumber != 0){
        apointments += "WEEK NUMER: " + weekNumber+"\n";
       }
       for (TimeTable timeTable : days) {
     apointments +=  timeTable.getTutorsAppointments(tutor, user);
       }
    return apointments;

     }
    
    /**
     *
     * @param student
     * @return
     */
    @Override
    public String studentReport(Student student) { // gets students report
       
       String report = "";

       if(weekNumber != 0){
       report += "WEEK NUMER: " + weekNumber + "\n";
       }
       for (TimeTable timeTable : days) {
       report +=  timeTable.studentReport(student);
       
       }
       report+="-----------------------------"+"\n";
       
     return report;
    }
     
    /**
     *
     * @param tutor
     * @return
     */
    @Override
    public String tutorReport(Users tutor) { // gets tutors report
       
       String report = "";

       if(weekNumber != 0){
       report += "WEEK NUMER: " + weekNumber + "\n";
       }
       for (TimeTable timeTable : days) {
       report +=  timeTable.tutorReport(tutor);
       }
               report+="-----------------------------"+"\n";
    return report;
    }

    /**
     *
     * @param officehour
     * @param parentName
     */
    @Override
    public void bookAppointment(OfficeHours officehour, String parentName) {
    
    }

    /**
     *
     * @param activity
     * @param time
     * @param person
     * @return
     */
    @Override
    public String registerActivity(School activity, String time, Users person) {
       return null;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString(){
        return""+weekNumber;
    }

    /**
     *
     * @param activity
     * @param person
     */
    @Override
    public void cancelStudentsActivity(School activity, Users person) {

    }
        // checks if 

    /**
     *
     * @param lesson
     * @return
     */
      @Override
    public boolean hasActivity(School lesson) {
       return false;
    }

//    void addActivityToDay(Lessons english) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public List getDays() {
        return null;
    }

    /**
     *
     * @return
     */

    @Override
    public int getLessonSetSize() {
     return -1;
    }
   
}
