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
public class UserFactoryTest {
    
    /**
     *
     */
    public UserFactoryTest() {
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
    public void testSomeMethod() {
      
    }

    /**
     * Test of createUser method, of class UserFactory.
     */
    @Test
    public void testCreateUser() {
      Users student = new Student("Bob","street",3);
      Users parent = new Parents("John");
      UserFactory uf = new UserFactory();
      Users factoryStudent = uf.createUser("student","Bob","street",3);
      Users factoryParent = uf.createUser("parent","John","");
      
       assertEquals(factoryStudent.getName(),student.getName());
       assertEquals(factoryStudent.getAddress(),student.getAddress());
       assertEquals(factoryStudent.getTelephoneNumber(),student.getTelephoneNumber());
        
       assertEquals(factoryParent.getName(),parent.getName());
      
      
      
    }
    
}
