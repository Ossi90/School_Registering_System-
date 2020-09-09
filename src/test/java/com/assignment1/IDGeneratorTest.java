/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment1;

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
public class IDGeneratorTest {
    
    /**
     *
     */
    public IDGeneratorTest() {
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
     *
     */
    @Test
    public void testGetID() {
       IDGenerator id = new IDGenerator();
       assertEquals(2010,id.getStudentID());
       IDGenerator id2 = new IDGenerator();
       assertEquals(2020,id2.getStudentID());
       IDGenerator id3 = new IDGenerator();
       assertEquals(7010,id3.getTutorID());
       IDGenerator id4 = new IDGenerator();
       assertEquals(7020,id4.getTutorID());
    }

}
