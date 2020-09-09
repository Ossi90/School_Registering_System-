/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment1;

import java.time.DayOfWeek;
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
public class ParentsTest {
    Parents parent1 = new Parents("Jack Jacksson");
    Parents parent2 = new Parents("Nick Nicksson");
    Parents parent3 = new Parents("Maria Mariadottir");
    DayOfWeek mon = DayOfWeek.MONDAY;

    Tutors Maria = new Tutors("Maria M", "Holy Street", 4589);
    OfficeHours officeMaria = new OfficeHours(Maria, mon, 1);

    /**
     *
     */
    public ParentsTest() {
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
     * Test of getName method, of class Parents.
     */
    @Test
    public void testGetName() {

        assertEquals("Jack Jacksson", parent1.getName());
        assertEquals("Nick Nicksson", parent2.getName());
        assertEquals("Maria Mariadottir", parent3.getName());

    }

    /**
     * Test of myAppointments method, of class Parents.
     */
    @Test
    public void testMyAppointments() {
        officeMaria.BookAppointment(parent1);
        parent1.getMyOfficeHours();
        assertEquals(true, parent1.getAppointments().contains(officeMaria));
    }

    /**
     * Test of getMyOfficeHours method, of class Parents.
     */
    @Test
    public void testGetMyAppointments() {
        officeMaria.BookAppointment(parent1);
        parent1.getMyOfficeHours();
        assertEquals(true, parent1.getAppointments().contains(officeMaria));

    }







}
