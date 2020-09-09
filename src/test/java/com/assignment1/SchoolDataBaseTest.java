/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment1;

import java.time.DayOfWeek;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import TimeTable.TimeTableController;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ornha
 */
public class SchoolDataBaseTest {
    DayOfWeek mon = DayOfWeek.MONDAY;
    DayOfWeek tue = DayOfWeek.TUESDAY; 
    DayOfWeek wen = DayOfWeek.WEDNESDAY; 
    DayOfWeek thu = DayOfWeek.THURSDAY; 
    DayOfWeek fri = DayOfWeek.FRIDAY;

    HardCodedData data = new HardCodedData();
    SchoolDataBase Schooldata = data.getRegisteredLessons();
    TimeTableController  time = data.getTimeTable();
    
    /**
     *
     */
    public SchoolDataBaseTest() {
    }
    
    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }
    
    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }
    
    /**
     *
     */
    @Before
    public void setUp() {
    }
    
    /**
     *
     */
    @After
    public void tearDown() {
    }

    /**
     * Test of registerActivity method, of class SchoolDataBase.
     */
    @Test
    public void testRegisterLesson() {
    SchoolDataBase r = new SchoolDataBase();  
    r.removeAllRegistration();
    Tutors Dave = new Tutors("Dave Davesson","Red Street",8955);
    Tutors Bob = new Tutors("Bob Bobson","Yellow Street",7412);
    Lessons english = new Lessons(Dave,"English","07.00-08.00",mon,"Room A",6);
    Lessons math = new Lessons(Bob,"Math","07.00-08.00",mon,"Room B",6);  
    assertEquals(2,r.numberOfRegistrations());
    
    Tutors Bill = new Tutors("Bill Billson","Gray Street",2589);
    Lessons french = new Lessons(Bill,"French","10.00-11.00",tue,"Room A",6);
    assertEquals(3,r.numberOfRegistrations());
    }

    /**
     * Test of findLessonWithTutor method, of class SchoolDataBase.
     */
    @Test
    public void testFindLessonWithTutor() {
    Set lessonSet = new HashSet();
    SchoolDataBase r = new SchoolDataBase();  
    r.removeAllRegistration();
    Tutors Dave = new Tutors("Dave Davesson","Red Street",8955);
    Tutors Bob = new Tutors("Bob Bobson","Yellow Street",7412);
    Lessons english = new Lessons(Dave,"English","07.00-08.00",mon,"Room A",6);
    Lessons math = new Lessons(Bob,"Math","07.00-08.00",mon,"Room B",6);
    lessonSet.add(english);
    assertEquals(lessonSet,r.findLessonWithTutor("Dave Davesson"));
      
    }
    /**
     * Test of findTutorByLesson method, of class SchoolDataBase.
     */
    @Test
    public void testFindTutorByLesson() {
    assertEquals(Schooldata.findTutorByLesson("Math").getName(),"Salvador Dali");
    }

    /**
     * Test of numberOfRegistrations method, of class SchoolDataBase.
     */
    @Test
    public void testNumberOfRegistrations() {
    SchoolDataBase r = new SchoolDataBase();  
    r.removeAllRegistration();
    Tutors Dave = new Tutors("Dave Davesson","Red Street",8955);
    Tutors Bob = new Tutors("Bob Bobson","Yellow Street",7412);;
    Lessons english = new Lessons(Dave,"English","07.00-08.00",mon,"Room A",6);
    Lessons math = new Lessons(Bob,"Math","07.00-08.00",mon,"Room B",6); 
    assertEquals(2,r.numberOfRegistrations());
    
    Tutors Bill = new Tutors("Bill Billson","Gray Street",2589);   
    Lessons french = new Lessons(Bill,"French","10.00-11.00",tue,"Room A",6);
    assertEquals(3,r.numberOfRegistrations());
        
    }


    /**
     * Test of findLesson method, of class SchoolDataBase.
     */
    @Test
    public void testFindLesson() {
    Set lessonSet = new HashSet();
    SchoolDataBase r = new SchoolDataBase();  
    r.removeAllRegistration();
    Tutors Dave = new Tutors("Dave Davesson","Red Street",8955);
    Tutors Bob = new Tutors("Bob Bobson","Yellow Street",7412);
    Lessons english = new Lessons(Dave,"English","07.00-08.00",mon,"Room A",6);
    Lessons math = new Lessons(Bob,"Math","07.00-08.00",mon,"Room B",6);
    lessonSet.add(english);
    lessonSet.add(math);
    r.registerLesson(math);
    r.registerLesson(english);
    assertEquals(english, r.findLesson("English"));
    assertEquals(math, r.findLesson("Math"));
    r.removeAllRegistration();
    }

 
    /**
     * Test of removeAllRegistration method, of class SchoolDataBase.
     */
    @Test
    public void testRemoveAllRegistration() {
    SchoolDataBase r = new SchoolDataBase(); 
    Set lessonSet = new HashSet();
    r.removeAllRegistration();
    Tutors Dave = new Tutors("Dave Davesson","Red Street",8955);
    Tutors Bob = new Tutors("Bob Bobson","Yellow Street",7412);
    Lessons english = new Lessons(Dave,"English","07.00-08.00",mon,"Room A",6);
    Lessons math = new Lessons(Bob,"Math","07.00-08.00",mon,"Room B",6);
    lessonSet.add(english);
    lessonSet.add(math);
    assertEquals(2,r.getLessonList().size());
    r.removeAllRegistration();
    assertEquals(0,r.getLessonList().size());
    
        
    }

    /**
     * Test of registerStudent method, of class SchoolDataBase.
     */
    @Test
    public void testRegisterStudent() {
     Student s1 = new Student("Bilz","asdf",57545);
        Schooldata.registerStudent(s1);

        assertEquals(Schooldata.getStudentByID(3960).getName(),"Laura Jacksson");
    }

    /**
     * Test of getStudentByID method, of class SchoolDataBase.
     */
    @Test
    public void testGetStudentByID() {
        assertEquals(Schooldata.getStudentByID(2030).getName(),"Bob James");
    }


    /**
     * Test of getTutor method, of class SchoolDataBase.
     */
    @Test
    public void testGetTutor() {
     assertEquals(Schooldata.getTutor("Barry McGee").getName(),"Barry McGee");
    }

    /**
     * Test of registerOfficeHour method, of class SchoolDataBase.
     */
    @Test
    public void testRegisterOfficeHour() {

        Tutors Dave = new Tutors("Dave Davesson","Red Street",8955);

        OfficeHours dave = new OfficeHours(Dave,mon,0);
        Schooldata.registerOfficeHour(dave);
        OfficeHours b = Schooldata.getOfficeHours("Dave Davesson");

    }

    /**
     * Test of getOfficeHours method, of class SchoolDataBase.
     */
    @Test
    public void testGetOfficeHours() {


                    assertEquals(Schooldata.getOfficeHours("Barry McGee").getTutor().getName(),"Barry McGee");
    }

    /**
     * Test of getTutorSet method, of class SchoolDataBase.
     */
    @Test
    public void testGetTutorSet() {
        Tutors Gill = new Tutors("g","Street",7412);
        SchoolDataBase r = new SchoolDataBase();
        Tutors Dave = new Tutors("Dave Davesson","Red Street",8955);
        Tutors Bob = new Tutors("Bob Bobson","Yellow Street",7412);

        Lessons english = new Lessons(Dave,"English","07.00-08.00",mon,"Room A",6);
        Lessons math = new Lessons(Bob,"Math","07.00-08.00",mon,"Room B",6);
        Set set = r.getTutorSet();

        assertEquals(set.contains(Bob),true);
        assertEquals(set.contains(Dave),true);
        assertEquals(set.contains(Gill),false);
    }

    /**
     * Test of getLessonList method, of class SchoolDataBase.
     */
    @Test
    public void testGetLessonList() {
        SchoolDataBase r = new SchoolDataBase();
        r.removeAllRegistration();
        Tutors Dave = new Tutors("Dave Davesson","Red Street",8955);
        Tutors Bob = new Tutors("Bob Bobson","Yellow Street",7412);
        Lessons english = new Lessons(Dave,"English","07.00-08.00",mon,"Room A",6);
        Lessons math = new Lessons(Bob,"Math","07.00-08.00",mon,"Room B",6);
        int size  =r.getLessonList().size();
        assertEquals(size,2);
    }
    
}
