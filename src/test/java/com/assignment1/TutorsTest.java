/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment1;

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
public class TutorsTest {
    Tutors tutor1 = new Tutors("Dave Davesson","Red Street",8955);
    Tutors tutor2 = new Tutors("Bob Bobson","Yellow Street",7412);
    Tutors tutor3 = new Tutors("Bill Billson","Gray Street",2589);
    SchoolUsers newTutor = tutor1;
    
    /**
     *
     */
    public TutorsTest() {
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
     * Test of getID method, of class Tutors.
     */
    @Test
    public void testGetID() {
       assertEquals(9370, tutor1.getID());
       assertEquals(9380, tutor2.getID());
       assertEquals(9390, tutor3.getID());
       assertEquals(9370, newTutor.getID());
    }

    /**
     * Test of getName method, of class Tutors.
     */
    @Test
    public void testGetName() {
      assertEquals("Dave Davesson", tutor1.getName());
      assertEquals("Bob Bobson", tutor2.getName());
      assertEquals("Bill Billson", tutor3.getName());
      assertEquals("Dave Davesson", newTutor.getName());
    }

    /**
     * Test of getAddress method, of class Tutors.
     */
    @Test
    public void testGetAddress() {
      assertEquals("Red Street", tutor1.getAddress());
      assertEquals("Yellow Street", tutor2.getAddress());
      assertEquals("Gray Street", tutor3.getAddress());
      assertEquals("Red Street", newTutor.getAddress());
    }

    /**
     * Test of getTelephoneNumber method, of class Tutors.
     */
    @Test
    public void testGetTelephoneNumber() {
      assertEquals(8955, tutor1.getTelephoneNumber());
      assertEquals(7412, tutor2.getTelephoneNumber());
      assertEquals(2589, tutor3.getTelephoneNumber());
      assertEquals(8955, newTutor.getTelephoneNumber());
      
    }







    
}
