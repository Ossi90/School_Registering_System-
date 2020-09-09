/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment1;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 *
 * @author ornha
 */
public class SchoolDataBase {
   private static List<OfficeHours> officehoursList = new ArrayList();
   private static List<Lessons> lessonsList = new ArrayList();
   private static Set<Tutors> tutorSet = new HashSet();
   private static  Set<Student> studentSet = new HashSet();
   

    

    /**
     *
     * @param lesson
     */
   // This is the Constructor of the class
    public void registerLesson(Lessons lesson){
       tutorSet.add(lesson.getTutor());
       lessonsList.add(lesson);
    }
    
        

    /**
     *
     * @param student
     */
    // This method registers students to the database 
     public void registerStudent(Student student){
      studentSet.add(student); 
    }
    
     

    /**
     *
     * @param ID
     * @return
     */
     // This student returns a student by using ID
    public Student getStudentByID(int ID){       
     for(Student student : studentSet){
         if(student.getID()==ID){
             return student;
         }
       }   
     return null;
    }
    
    

    /**
     *
     * @param ID
     * @return
     */
    // This student returns a tutor by using ID
    public Tutors getTutorByID(int ID){
         for(Lessons l: lessonsList){
           if(l.getTutor().getID()==ID){
               return l.getTutor();
         }
     }
    return null;
    }
  
    
    

    /**
     *
     * @param name
     * @return
     */
    //This method gets a Tutor by using name
    public Tutors getTutor(String name){
       for(Lessons l: lessonsList){
           if(l.getTutor().getName().equals(name)){
               return l.getTutor();
            }
       }
     return null;  
    }
    
    

    /**
     *
     * @param hour
     */
    // This method registers officehours in the database
    public void registerOfficeHour(OfficeHours hour){
      officehoursList.add(hour); 
    }
     
   

    /**
     *
     * @param tutorsName
     * @return
     */
    // gets officehours from database by using tutor name 
   public OfficeHours getOfficeHours(String tutorsName){
       for(OfficeHours hour: officehoursList){

           if(hour.getTutor().getName().equals(tutorsName)){
               return hour;
           }
       }
        return null;  }
    
   

    /**
     *
     * @param key
     * @return
     */ // returns lessons tought by a tutor;
   // tutors name used to find lesson
    public Set findLessonWithTutor(String  key){
        Set lessonSet = new HashSet();
        String tutorsLessons="";
        for(Lessons lesson: lessonsList){
            if(lesson.getTutor().getName().equals(key)){
               // System.out.println(lesson);
                lessonSet.add(lesson);
           }
        }
      return lessonSet;
    }
    
    

    /**
     *
     * @return
     */// return all tutors registered in the database
    public Set getTutorSet(){
        return tutorSet;
    }

    

    /**
     *
     * @return
     */// returns a list of all lessons within the database
    public List getLessonList(){
        return lessonsList;
    }
    
    

    /**
     *
     * @param l
     * @return
     */// finds a lesson by using the name of the lesson
    public Lessons findLesson(String l){
        for(Lessons lesson: lessonsList){
            if(lesson.getName().equals(l)){
               // System.out.println(lesson);
               return lesson;
              }
         }
        return null;
    }
    
    
    /**
     *
     * @param les
     * @return
     */// retuns a tutor that teaches the lesson

    public Tutors findTutorByLesson(String les){
  	  for(Lessons l: lessonsList){
            if(l.getName().equals(les)){
                 return l.getTutor();
            }
           }
        return null;
        }
    
    

    /**
     *
     */// clears all lessons from the data base
   // used for testing
    public void removeAllRegistration(){
        lessonsList.clear();
    }
    
    

    /**
     *
     * @return
     */// retuns how many lessons are in the database
    // used for testing
    public int numberOfRegistrations(){
        return lessonsList.size();
          }
 }
