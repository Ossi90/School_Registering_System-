/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment1;

import java.time.DayOfWeek;
import java.util.HashSet;
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
public class StudentTest {
    HardCodedData data = new HardCodedData();
    SchoolDataBase Schooldata = data.getRegisteredLessons();
    TimeTableController time = data.getTimeTable();
    DayOfWeek mon = DayOfWeek.MONDAY;
    Student student1 = new Student("Bob James","Baker Street", 4875155);
    Student student2 = new Student("Jack Ralf","Green Street", 5566658);
    Student student3 = new Student("Steve Stevenson","Blue Street", 447555);
    Tutors Dave = new Tutors("Dave Davesson","Red Street",8955);
    Lessons english = new Lessons(Dave,"English","07.00-08.00",mon,"Room A",6);
    SchoolUsers newStudent = student1;
    
    /**
     *
     */
    public StudentTest() {
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
     * Test of getID method, of class Student.
     */
    @Test
    public void testGetID() {
        assertEquals(4880, student1.getID());
        assertEquals(4880, student1.getID());
        assertEquals(4890, student2.getID());
        assertEquals(4900, student3.getID());
        assertEquals(4880, newStudent.getID());
    }

    /**
     * Test of getName method, of class Student.
     */
    @Test
    public void testGetName() {
        assertEquals("Bob James", student1.getName());
        assertEquals("Jack Ralf", student2.getName());
        assertEquals("Steve Stevenson", student3.getName());
        assertEquals("Bob James", newStudent.getName());
    }

    /**
     * Test of getAddress method, of class Student.
     */
    @Test
    public void testGetAddress() {
         assertEquals("Baker Street", student1.getAddress());
         assertEquals("Green Street", student2.getAddress());
         assertEquals("Blue Street", student3.getAddress());
         assertEquals("Baker Street", newStudent.getAddress());
    }

    /**
     * Test of getTelephoneNumber method, of class Student.
     */
    @Test
    public void testGetTelephoneNumber() {
      assertEquals(4875155, student1.getTelephoneNumber());
       assertEquals(5566658, student2.getTelephoneNumber());
        assertEquals(447555, student3.getTelephoneNumber());
         assertEquals(4875155, newStudent.getTelephoneNumber());
    }

    /**
     * Test of addLesson method, of class Student.
     */
    @Test
    public void testAddStudentsLesson() {
        Set<Lessons> testSet = new HashSet();
        english.addStudent(student1);
        testSet.add(english);
        
        assertEquals(testSet,student1.getMyLessonsSet());
        
    }

    /**
     * Test of getMyLessonsSet method, of class Student.
     */
    @Test
    public void testGetStudentsLessons() {
       Set<Lessons> testSet = new HashSet();
        english.addStudent(student1);
        testSet.add(english);
        
        assertEquals(testSet,student1.getMyLessonsSet());
    }

    /**
     * Test of addLesson method, of class Student.
     */
    @Test
    public void testAddLesson() {

        student1.addLesson(english);
        assertEquals(student1.getMyLessonsSet().contains(english),true);
        assertEquals(student2.getMyLessonsSet().contains(english),false);

    
    }

    /**
     * Test of getMyLessonsSet method, of class Student.
     */
    @Test
    public void testGetLessonsSet() {
        student1.addLesson(english);
        Set<Lessons> s = new HashSet();
        s.add(english);
        assertEquals(student1.getMyLessonsSet(),s);


    }

    /**
     * Test of removeLesson method, of class Student.
     */
    @Test
    public void testRemoveLesson() {
        student1.addLesson(english);
        Set<Lessons> s = new HashSet();
        s.add(english);
        assertEquals(student1.getMyLessonsSet(),s);
        s.clear();

        student1.removeLesson(english);
        assertEquals(student1.getMyLessonsSet(),s);
    }

    /**
     * Test of cointainsSameDayAndtime method, of class Student.
     */
    @Test
    public void testCointainsSameDayAndtime() {
        student1.addLesson(english);
        Set<Lessons> s = new HashSet();
        assertEquals(student1.cointainsSameDayAndtime(DayOfWeek.MONDAY,"07:00-08:00"),false);
       
    }

 
   
}

   
    
