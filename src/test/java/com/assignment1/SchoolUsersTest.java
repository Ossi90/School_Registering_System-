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
public class SchoolUsersTest {
    SchoolUsers sPeople1 = new SchoolUsers("Jane More", "Silver Street",7895);
    SchoolUsers sPeople2 = new SchoolUsers("Maria Gale", "Black Street",8256);
    SchoolUsers sPeople3 = new SchoolUsers("Bill Johnson", "Pink Street",8789);
    
    /**
     *
     */
    public SchoolUsersTest() {
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
     * Test of getID method, of class SchoolUsers.
     */
    @Test
    public void testGetID() {
      
        assertEquals(4090, sPeople1.getID());
        assertEquals(4100, sPeople2.getID());
        assertEquals(4110, sPeople3.getID());

    }

    /**
     * Test of getName method, of class SchoolUsers.
     */
    @Test
    public void testGetName() {
       assertEquals("Jane More", sPeople1.getName());
       assertEquals("Maria Gale", sPeople2.getName());
       assertEquals("Bill Johnson", sPeople3.getName());
    }

    /**
     * Test of getAddress method, of class SchoolUsers.
     */
    @Test
    public void testGetAddress() {
       assertEquals("Silver Street", sPeople1.getAddress());
       assertEquals("Black Street", sPeople2.getAddress());
       assertEquals("Pink Street", sPeople3.getAddress());
    }

    /**
     * Test of getTelephoneNumber method, of class SchoolUsers.
     */
    @Test
    public void testGetTelephoneNumber() {
        assertEquals(7895, sPeople1.getTelephoneNumber());
        assertEquals(8256, sPeople2.getTelephoneNumber());
        assertEquals(8789, sPeople3.getTelephoneNumber());
    }





    
}
