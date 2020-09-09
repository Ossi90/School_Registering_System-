/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment1;

import java.time.DayOfWeek;
import java.util.*;

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
public class OfficeHoursTest {
    DayOfWeek mon = DayOfWeek.MONDAY;
    DayOfWeek tue = DayOfWeek.TUESDAY; 
    DayOfWeek wed = DayOfWeek.WEDNESDAY; 
    DayOfWeek thu = DayOfWeek.THURSDAY; 
    DayOfWeek fri = DayOfWeek.FRIDAY; 
    
    Tutors dave = new Tutors("Dave Davesson","Red Street",8955);
    Tutors bob = new Tutors("Bob Bobson","Yellow Street",7412);
    Tutors bill = new Tutors("Bill Billson","Gray Street",2589);
    Tutors gill = new Tutors("Gill S","Bay Street",3589);
    Tutors maria = new Tutors("Maria M","Holy Street",4589);
    
    
    Tutors Maria = new Tutors("Maria M","Holy Street",4589);
    OfficeHours officeMaria = new OfficeHours(Maria,mon,0);  
    OfficeHours officeDave = new OfficeHours(dave,mon,0);
    OfficeHours officeBob = new OfficeHours(bob,tue,1);
    OfficeHours officeBill= new OfficeHours(bill,wed,2);
    OfficeHours officeGill = new OfficeHours(gill,thu,3);
   
    /**
     *
     */
    public OfficeHoursTest() {
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
     * Test of getAppointments method, of class OfficeHours.
     */
    @Test
    public void testGetAppointments() {
        
       List <String> list = new  ArrayList();
        Tutors Maria = new Tutors("Maria M","Holy Street",4589);
        String[] timeSlot = {"14:00","14:20", "14:40"};
        list = officeMaria.getAppointments(0, list);
        String officeHourString = "";
        
        for(int i = 0; i < timeSlot.length; i++){
                   assertEquals(true,list.contains(timeSlot[i]));
		}
     
    }

    /**
     * Test of getDay method, of class OfficeHours.
     */
    @Test
    public void testGetDay() {
        
        DayOfWeek day1 = DayOfWeek.MONDAY;
        DayOfWeek day2 = DayOfWeek.TUESDAY;
        DayOfWeek day3 = DayOfWeek.WEDNESDAY;
        DayOfWeek day4 = DayOfWeek.THURSDAY;
     
        
        assertEquals(day1,officeMaria.getDay());
        assertEquals(day1,officeDave.getDay());
        assertEquals(day2,officeBob.getDay());
        assertEquals(day3,officeBill.getDay());
        assertEquals(day4,officeGill.getDay());
        
    
    }

    /**
     * Test of getTimeSlots method, of class OfficeHours.
     */
    @Test
    public void testGetTimeMap() {
       String[] t = {"16:00","16:20", "16:40"};
       List l = new ArrayList();
       
       l.add(t[0]);       
       l.add(t[1]);     
       l.add(t[2]);     
       assertEquals(l,officeBill.getTimeSlots());
       
       l.clear();
       
       String[] t2 = {"14:00","14:20", "14:40"};
       
       l.add(t2[0]);       
       l.add(t2[1]);     
       l.add(t2[2]); 
      
        assertEquals(l,officeMaria.getTimeSlots());
        assertEquals(l,officeDave.getTimeSlots());
    }

    /**
     * Test of getTutor method, of class OfficeHours.
     */
    @Test
    public void testGetTutor() {
        assertEquals("Dave Davesson",officeDave.getTutor().getName());
    }

    /**
     * Test of getPlace method, of class OfficeHours.
     */
    @Test
    public void testGetPlace() {
     assertEquals("Tutors office",officeDave.getPlace());
    }

    /**
     * Test of getTimeSlots method, of class OfficeHours.
     */
    @Test
    public void testGetTimeList() {
   String[] t = {"14:00","14:20", "14:40"}; 
            
       List l = new ArrayList();
       
       l.add(t[0]);       
       l.add(t[1]);     
       l.add(t[2]);     
       assertEquals(l,officeDave.getTimeSlots());
    }

    /**
     * Test of getParent method, of class OfficeHours.
     */
    @Test
    public void testGetParent() {
        Parents p = new Parents("Bob");
        officeDave.BookAppointment(p);
        
        assertEquals(p,officeDave.getParent("Bob"));
    }

    /**
     * Test of BookAppointment method, of class OfficeHours.
     */
    @Test
    public void testBookAppointment() {
       Parents p = new Parents("Bob");
        officeDave.BookAppointment(p);
        
        assertEquals(1,officeDave.getParentsSet().size());
    }

    /**
     * Test of getParentsSet method, of class OfficeHours.
     */
    @Test
    public void testGetParentsSet() {

        Parents p = new Parents("Bob");
        List l = new ArrayList();
        l.add(p);
        officeDave.BookAppointment(p);
        assertEquals(officeDave.getParentsSet(),l);

    }









 
    
    
}
