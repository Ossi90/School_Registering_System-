/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment1;

import TimeTable.TimeTableController;
import java.time.DayOfWeek;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
public class LessonsTest {
    DayOfWeek mon = DayOfWeek.MONDAY;
    DayOfWeek tue = DayOfWeek.TUESDAY; 
    DayOfWeek wen = DayOfWeek.WEDNESDAY; 
    DayOfWeek thu = DayOfWeek.THURSDAY; 
    DayOfWeek fri = DayOfWeek.FRIDAY;
    
    Tutors Gill = new Tutors("Gill S","Bay Street",3589);
    Tutors Maria = new Tutors("Maria M","Holy Street",4589);
    
    Lessons programming = new Lessons(Gill,"Programming","10.00-11.00",wen,"Room A",6);
    Lessons science = new Lessons(Maria,"Science","08.00-09.00",wen,"Room A",6);
    
    Student student1 = new Student("Bob James","Baker Street", 4875155);
    Student student2 = new Student("Jack Ralf","Green Street", 5566658);
    Student student3 = new Student("Steve Stevenson","Blue Street", 447555);
   
    
    /**
     *
     */
    public LessonsTest() {
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
     * Test of getTutor method, of class Lessons.
     */
    @Test
    public void testGetTutor() {
        
        Tutors result1 = programming.getTutor();
        Tutors result2 = science.getTutor();
        assertEquals(Gill, result1);
        assertEquals(Maria, result2);
        
    }

    /**
     * Test of getMaxStudents method, of class Lessons.
     */
    @Test
    public void testGetMaxStudents() {
        science.setMaxStudent(20);

       
        assertEquals(6,  programming.getMaxStudents());
        assertEquals(20, science.getMaxStudents());
       
    }

    /**
     * Test of setMaxStudent method, of class Lessons.
     */
    @Test
    public void testSetMaxStudent() {
        science.setMaxStudent(2);
        programming.setMaxStudent(8);
        int expRes1 = 2;
        int expRes2 = 8;
        assertEquals(expRes1, science.getMaxStudents());
        assertEquals(expRes2, programming.getMaxStudents());
        
    }

    /**
     * Test of addStudent method, of class Lessons.
     */
    @Test
    public void testAddStudent() {
      science.addStudent(student1);
      science.addStudent(student2); 
      int expRes1 = 2;
      programming.addStudent(student1);
      programming.addStudent(student2);
      programming.addStudent(student3);
      int expRes2 = 3;
      
      assertEquals(expRes1, science.getStudentSetSize());
      assertEquals(expRes2, programming.getStudentSetSize());
       
    }

    /**
     * Test of removeStudent method, of class Lessons.
     */
    @Test
    public void testRemoveStudent() {
        TimeTableController t = new TimeTableController();
      science.addStudent(student1);
      science.addStudent(student2); 
      programming.addStudent(student1);
      programming.addStudent(student2);
      programming.addStudent(student3);

      science.removeStudent(student1);
      programming.removeStudent(student1);
      
       
      assertEquals(1, science.getStudentSetSize());
      assertEquals(2, programming.getStudentSetSize());
    }


    /**
     * Test of getStudentSetSize method, of class Lessons.
     */
    @Test
    public void testGetStudentSetSize() {
      science.addStudent(student1);
      science.addStudent(student2); 
      int expRes1 = 2;
      programming.addStudent(student1);
      programming.addStudent(student2);
      programming.addStudent(student3);
      int expRes2 = 3;
      
      assertEquals(2, science.getStudentSetSize());
      assertEquals(3, programming.getStudentSetSize());
    }

    /**
     * Test of getTime method, of class Lessons.
     */
    @Test
    public void testGetTime() {
      String t = "10.00-11.00";
      assertEquals(t,programming.getTime());
    }
    
    
    /**
     * Test of getDay method, of class Lessons.
     */
    @Test
    public void testGetDay(){
       
       assertEquals(DayOfWeek.WEDNESDAY, programming.getDay());
       assertEquals(DayOfWeek.WEDNESDAY, science.getDay());
     }
    
    /**
     *
     */
    public void testGetPlace(){
      assertEquals("Room A", programming.getPlace());
         assertEquals("Room A",science.getPlace());
     }

    /**
     * Test of getName method, of class Lessons.
     */
    @Test
    public void testGetName() {
       String name = programming.getName();
       assertEquals("Programming", name);
       name = science.getName();
        assertEquals("Science", name);
    
    }

    /**
     * Test of getStudents method, of class Lessons.
     */
    @Test
    public void testGetStudents() {
        programming.addStudent(student1);
        programming.addStudent(student2);
        
        Set s = new HashSet();
      s.add(student1);
      s.add(student2);
      
      assertEquals(s,programming.getStudents());
    }

    /**
     * Test of registerActivity method, of class Lessons.
     */
    @Test
    public void testRegisterLesson() {
        SchoolDataBase r = new SchoolDataBase();
        programming.registerActivity();
       
      
    assertEquals(programming,r.findLesson("Programming"));
    }

    /**
     * Test of checkStudent method, of class Lessons.
     */
    @Test
    public void testCheckStudent() {
    assertEquals(programming.checkStudent(student1),false);
    programming.addStudent(student1);
        assertEquals(programming.checkStudent(student1),true);
    }









 
}
