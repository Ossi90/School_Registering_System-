/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment1;

import static org.hamcrest.CoreMatchers.is;
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
public class OrderUserTest {
    
    /**
     *
     */
    public OrderUserTest() {
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
     * Test of orderUser method, of class OrderUserTest.
     */
    @Test
    public void testOrderUser() {
      Users student = new Student("Bob","street",3);
      Users parent = new Parents("John");
       
       UserFactory factory = new UserFactory();
       OrderUser signUp = new OrderUser(factory);
       
       Users factoryStudent = signUp.orderUser("student","Bob","street",3);      
       Users factoryParent = signUp.orderUser("parent","John");
       
        
        assertEquals(factoryStudent.getName(),student.getName());
        assertEquals(factoryStudent.getAddress(),student.getAddress());
        assertEquals(factoryStudent.getTelephoneNumber(),student.getTelephoneNumber());
        
        assertEquals(factoryParent.getName(),parent.getName());
      
    }


    
}
