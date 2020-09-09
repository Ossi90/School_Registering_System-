/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimeTable;


import com.assignment1.*;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;



/**
 *
 * @author ornha
 */

// This class is a leaf class of the composite pattern, a child node under week.

public class Day implements TimeTable{
   private School officeHours;
   private School lesson;
   private DayOfWeek day;
   private List<String> AppointmentTimeSlots = new ArrayList();
   private HashMap <String,String> parents;
   private Set<Users> studentSet = new HashSet();
   private List <School> officeHoursList;
   private Set <School> lessonSet = new HashSet();
   private HashMap <Users,String> students;
   private Map<School,HashMap<Users,String>>  StudentAttendanceMap= new HashMap();
   private Map<School,HashMap<String,String>>  parentAttendanceMap;
    
    /**
     *
     * @param day
     */
    public Day(DayOfWeek day){ 
        this.day=day;  // constructor for this class, set the day.
    }
    
    /**
     *
     * @return
     */
    public DayOfWeek getDay(){
        return day; // a getter for day.
    }
    
    /**
     *
     * @return
     */
    public Map getStudentMap(){
        return StudentAttendanceMap; // getter for the double HashMap, that holds attendance for students
    }    
    
    
   

    /**
     *
     * @param activity
     */ 
//Add lessons to each day within the composite pattern
    public void addActivtyToDay(School activity){ //Add lessons to each day within the composite pattern
        
     if(activity instanceof Lessons){ // If the object is instance of lesson then it gets added to the lessonSet
        this.lesson = activity;
        lessonSet.add(activity);
        studentTimeTable(activity);
        
    }else if( activity instanceof OfficeHours){ //  If the object is instance of OfficeHours then it gets added to the officeHours list
        officeHoursList = new ArrayList();
        officeHoursList.add(activity);
        parentTimeTable(activity);   
        }     
    }
    
    /**
     *
     * @return
     */
    public int getParetsMapSize(){ // This method is made for testing
        return parents.size();
    }
  
    /**
     *
     * @param lesson
     */
    public void studentTimeTable(School lesson){   // add Students to the timetable when a student registers to a lesson
        
        studentSet = lesson.getStudents(); // gets the student set from each lesson
        students = new HashMap(); 
    
      for(Users student: studentSet){  
        students.put(student,"Did Not Attend");
         }
         StudentAttendanceMap.put(lesson,students); // adds each student to the double HashMap with the value of "Did Not Attend"
      }
    
    /**
     *
     * @param hour
     */
    public void parentTimeTable(School hour){ // add parents to the timetable when a parent books an apointment
       AppointmentTimeSlots = hour.getTimeSlots(); // puts each timeslot from each tutor into a ArrayList
       parents = new HashMap();
       parentAttendanceMap= new HashMap(); 
       for(String timeSlot: AppointmentTimeSlots){  
       parents.put(timeSlot,"Free");
       } 
       parentAttendanceMap.put(hour, parents); // adds each timeslot to a double HashMap with the value of "Free"
    }
    
    /**
     *
     * @param time
     * @param hour
     * @return
     */
    public String getParentActivity(String time, School hour){ // returns parent Appointment
       return parentAttendanceMap.get(hour).get(time);
    }
    
    /**
     *
     * @param activity
     * @return
     */
    @Override
    public boolean hasActivity(School activity){ // checks if the activity exist
      if(activity instanceof Lessons){
      return lessonSet.contains(activity);        
      }else {
      return officeHoursList.contains(activity);
      }
      
    }

    /**
     *
     * @param s
     * @param l
     */
    @Override
    public void removeStudent(Student s,Lessons l){ // removes student from the timetable
      try{StudentAttendanceMap.get(l).remove(s);
      }catch(NullPointerException e){}
    }   
    
    /**
     *
     * @return
     */
    @Override
    public int getLessonSetSize(){ // gets the size of the lesson set
      return lessonSet.size();
    }
    
    /**
     *
     * @return
     */
    public int getLessonSe(){ // gets the size of the lesson set
      return lessonSet.size();
    }
    
    /**
     *
     * @return
     */
    public int ASDF(){ // gets the size of the lesson set
      return lessonSet.size();
    }

    /**
     *
     * @return
     */
    public int getStudentHashMapSize(){ // gets the size of the Student HashMap
        return students.size();
    }
  
    /**
     *
     * @param student
     * @param lesson
     * @return
     */
    @Override
     public String studentAttendsActicity(Users student, School lesson){ //This method is used when a student attends a lesson
       String check="";
       try{
           switch (StudentAttendanceMap.get(lesson).get(student)) {
               case "Attended":
                   // check if the lesson has already been attended
                   return  "This Lesson Has Already Been Attended";
               case "Cancelled":
                   // checks if the lessons has already been canceld
                   return "This lesson has already been cancelled";
               default:
                   StudentAttendanceMap.get(lesson).replace(student, "Attended"); // changes the value from "Not Attened" to "Attended"
                   return check = "check";
           }
       }catch(NullPointerException e){}
       
     return "check";  // returns a string to notify that the student has attened;
     }

    /**
     *
     * @param student
     * @param lesson
     * @return
     */
    @Override
     public String cancelActivity(Users student, School lesson){ // this methods is used when a student cancels a lesson and works the same as the tudentAttendsActicity method
       String check ="";
       try{
           switch (StudentAttendanceMap.get(lesson).get(student)) {
               case "Attended":
                   return  "This Lesson Has Already Been Attended";
               case "Cancelled":
                   return "This lesson has already been cancelled";
               default:   
                   StudentAttendanceMap.get(lesson).replace(student, "Cancelled");
                   break;
           }
        return "check";
       }
       catch(NullPointerException e){}
    return "check"; }
      
    /**
     *
     * @param student
     * @param lesson
     */
    @Override
     public void addStudentToLesson(Users student,Lessons lesson){ // this method allows students to join new lessons
      try{
        StudentAttendanceMap.get(lesson).put(student, "Did Not Attend");    
         }catch(NullPointerException e){    
         }
     }
     
    /**
     *
     * @param student
     * @param lesson
     */
    @Override
     public void changeStudentLesson(Student student, Lessons lesson){ // this method allows student to change lessons
       try{
         StudentAttendanceMap.get(lesson).put(student, "changed");   
      }catch(NullPointerException e){}
     }
     
    /**
     *
     * @param student
     * @param lesson
     */
    @Override
    public void studentQuitsLesson(Student student, Lessons lesson){ // this method allows students to quit lessons
      try{
        StudentAttendanceMap.get(lesson).remove(student);    
         }catch(NullPointerException e){}
    }
    
    /**
     *
     * @param appointment
     * @param time
     * @param parent
     * @return
     */
    @Override
    public String registerActivity(School appointment,String time,Users parent){ // this method allows Parents to book Appointment
      String  registerResulst = "";
       try{ 
         if(parentAttendanceMap.get(appointment).get(time).equals("Free")){// checks if the time slot is free.
         parentAttendanceMap.get(appointment).replace(time, parent.getName());
         registerResulst = "check";
       }else{registerResulst = "Woops!\nThis apointment has already been taken\n Please pick another time";}
     }catch(NullPointerException e){
            registerResulst = "Woops!\nThe tutor does not have office hours during this time, please pick again!";}
       
    return registerResulst;  // return a String confirming that the booking as been made
      }
         
    /**
     *
     * @param lesson
     * @param student
     * @return
     */
    public String StudentAttendanceReport(School lesson, Student student){ // this method prints out the student report
      String attendance = "";
      for (Map.Entry<Users, String> nameEntry : StudentAttendanceMap.get(lesson).entrySet()) { // loops through the HasMaps entrySet which is a Student object
       if(nameEntry.getKey().getMyLessonsSet().contains(lesson)&& nameEntry.getKey().equals(student) ){     
          attendance  += nameEntry.getKey().getName()+ " - ";
          attendance  += nameEntry.getValue() + "\n";
            }
         }
      return attendance;    // returns the report String
    }

    /**
     *
     * @param officeHours
     * @param user
     * @return
     */
    public String TutorParentReport(School officeHours,Users user){ // this method prints out the appointmetn report, it is also used for Parents to find free appointments.
        String[] tempArray = new String[3];  // ArrayList made to sort the report 
        int i = 0;
        String attendance = "";
     
       try{ for (Map.Entry<String, String> nameEntry : parentAttendanceMap.get(officeHours).entrySet()) { // loops through the HasMaps entrySet which is a String object
       
       if(user instanceof Tutors){ // checks if it is the tutor who is calling this method
       attendance  += nameEntry.getKey()+ " - ";
       attendance += nameEntry.getValue()+ "\n";
       tempArray[i] = attendance;    // adds the String to an ArrayList
       attendance = "";
       i++;
       
       }else if(user instanceof Parents){ // checks if it is the parent who is calling this method
           
       attendance  += nameEntry.getKey()+ " - ";
       if(nameEntry.getValue().equals("Free")){ // The value is not "Free" then value is overwriten with "Taken"
       attendance += nameEntry.getValue()+ "\n";
       tempArray[i] = attendance; // adds the String to an ArrayList
       attendance = "";
       i++;
        }else{
           
        attendance += "Taken\n";
       tempArray[i] = attendance;
       attendance = "";
        i++;}
        
       }
       
    }}catch(NullPointerException e){}
    java.util.Arrays.sort(tempArray); // sort the ArrayList
            for(String s :tempArray){
                attendance  += s;
            }
   
    return attendance; // returns report
      }
      
    /**
     *
     * @param tutor
     * @param user
     * @return
     */
    @Override
     public String getTutorsAppointments(Tutors tutor,Users user){// this method is used when getting the report 
      String apointments = "";
     
      
      for(School hours: officeHoursList){
          if(hours.getTutor().equals(tutor)){
      apointments+= TutorParentReport(hours,user)+"\n";
          }
      }  
    return apointments;

     }
      
    /**
     *
     * @param student
     * @return
     */
    @Override
     public String studentReport(Student student){ // this method is used to getting the report
       String report= "";
       for(School lesson: lessonSet){
        if(student.getMyLessonsSet().contains(lesson)){
         report += day +": "+"\n";
         report += lesson.getName().toUpperCase()+"\n";
         report += "Student Attendance: \n";
         report +=StudentAttendanceReport(lesson, student) + "\n";} // calls the report method 
      }
      return report;
     }
      
    /**
     *
     * @param tutor
     * @return
     */
    @Override
    public String tutorReport(Users tutor) { // this method is used to call the tutors report
       String report = "";  
       for(School lesson: lessonSet){
           
        if(tutor.getMyLessonsSet().contains(lesson)){ 
        report += day +": "+"\n";
        report += lesson+"\n"; 
        report += "Number of Students: " +lesson.getStudentSetSize()+"/"+ lesson.getMaxStudents()+ "\n\n";
           }
      }   
      for(School hours: officeHoursList){
        if(tutor.getMyOfficeHours().equals(hours)){// checks if it is the right tutor
        report+= "OFFICE HOURS - " +day+ "\n";
        report += "Tutor: "+hours.getTutor().getName()+"\n";
        report += TutorParentReport(hours,tutor)+"\n";
        }
     }
        return report;
    }
    
    /**
     *
     * @return
     */
    @Override
    public int getWeekOrDayNumer() {
     return -1;
    }

    /**
     *
     * @return
     */
    @Override
    public Day getMonday() {
        return null;
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
     * @return
     */
    @Override
    public List getDays() {
        return null;
    }

    /**
     *
     * @param activity
     * @param person
     */
    @Override
    public void cancelStudentsActivity(School activity, Users person) {
       
    }

    /**
     *
     * @param activity
     * @param person
     * @param time
     * @param weekNr
     * @return
     */
    @Override
    public String attendActivity(School activity, Users person, String time, int weekNr) {
     return null;
    }


    
    
}
 