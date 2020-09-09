
package com.assignment1;


import java.time.DayOfWeek;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 *
 * @author ornha
 */

// this class is for creating lessons
public class Lessons implements School{
    SchoolDataBase register = new SchoolDataBase();
    private Set <Student> setOfStudents = new HashSet();
    private int maxStudents;
    private final  String name;
    private final Tutors tutor;
    private final String time;
    private final DayOfWeek day;
    private final String place;
   
     
    /**
     Constructor for this class
     * @param tutor
     * @param name
     * @param time
     * @param maxStudents
     * @param day
     * @param place
     **/
     public Lessons(Tutors tutor, String name, String time, DayOfWeek day,String place, int maxStudents){ 
        this.name=name;
        this.tutor=tutor;
        this.day = day;
        this.time = time;
        this.place = place;
        this.maxStudents = maxStudents;
        this.tutor.addLesson(this);
        registerActivity();
     }
     
 
    /**
     *
     * @return
     */
    //gets the tutor of the object 
    @Override
    public Tutors getTutor(){
        return tutor;
    }
    
    //gets the name of the lesson

    /**
     *
     * @return
     */
    @Override
    public String getName(){
        return name;
    }
     
  

    /**
     *
     * @return
     */  
    // gets how many students are allowed on this lesson
    @Override
    public int getMaxStudents(){
         return maxStudents;
     }
     
    

    /**
     *
     * @param newMaxStudents
     */
    // sets how many students are allowed on this lesson
     public void setMaxStudent(int newMaxStudents){
         this.maxStudents = newMaxStudents;
     }
     
     

    /**
     *
     * @return
     */
    // gets the size of the student set
    @Override
     public int getStudentSetSize(){
         return setOfStudents.size();
     }
     
     

    /**
     *
     * @return
     */
    //gets the lessons time
     public String getTime(){
         return time;
     }
     
     

    /**
     *
     * @return
     */
    // gets the lessons day
    @Override
     public DayOfWeek getDay(){
         return day;
     }
     
     

    /**
     *
     * @return
     */
    // gets the place where the lesson is 
    @Override
     public String getPlace(){
         return place;
     }
     
     

    /**
     *
     * @return
     */
    // gets the student set
    @Override
     public Set getStudents(){
         return setOfStudents;
     }
     
     
     

    /**
     *
     * @param student
     * @return
     */
    //checks if the student is allow to join the lesson
     public boolean checkStudent(Student student){
        return setOfStudents.size()>= maxStudents || student.getMyLessonsSet().contains(this) || student.cointainsSameDayAndtime(day,time);
        
     }
 
    /**
     *
     * @param student
     * @return
     */
    public String addStudent(Student student){ // adds student to lesson
        String status = "";
       if(checkStudent(student) == true){ // calls to check if the student is allow to join the lesson if not, then checks why
         if(setOfStudents.size()>= maxStudents){ 
           return status ="This Lesson is be full.\n"; 
         }else if(student.getMyLessonsSet().contains(this) == true){
           return status = "You are already be enrolled to this Lesson.";
         }else {
           return status = "You are enrolled to another lessons during this time.\n";      
           }
      }else{
          setOfStudents.add(student);
          student.addLesson(this);           
          return status = "check";
             }  
         }

          

    /**
     *
     * @param student
     */
    // removes student from the lesson
     public void removeStudent(Student student){
        setOfStudents.remove(student);
     }
     
     

    /**
     *
     */
    // registers the lesson to the SchoolDataBase class
    @Override
     public void registerActivity(){
         register.registerLesson(this);
     }
    
    /**
     *
     * @return
     */
    @Override
     public String toString(){
         return "Lesson: "+name + "\n"+
                 "Tutor: "+tutor.getName()+"\n"+
                 "Time: "+time + "\n"+
                 "Place: "+place;
                 
     }

    /**
     *
     * @return
     */
    @Override
    public Set getStudentsLessons() {
      return null;
    }

    /**
     *
     * @return
     */
    @Override
    public List getTimeSlots() {
      return null;
    }

    /**
     *
     * @param parent
     * @return
     */
    @Override
    public Parents getParent(String parent) {
   return null;
    }

 
}
