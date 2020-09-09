/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment1;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;

/**
 *
 * @author ornha
 */

// This is the Interface for the school 
// Lessins and OfficeHours implement this interface
public interface School {

    /**
     *
     * @return
     */
    public Tutors getTutor();

    /**
     *
     * @return
     */
    public int getMaxStudents();

    /**
     *
     * @return
     */
    public DayOfWeek getDay();

    /**
     *
     * @return
     */
    public String getPlace();

    /**
     *
     * @return
     */
    public String toString();

    /**
     *
     * @return
     */
    public Set getStudents();

    /**
     *
     * @return
     */
    public int getStudentSetSize();

    /**
     *
     * @return
     */
    public Set getStudentsLessons();

    /**
     *
     * @return
     */
    public String getName();

    /**
     *
     * @return
     */
    public List getTimeSlots();

    /**
     *
     * @param parent
     * @return
     */
    public Parents getParent(String parent);
    
    public void registerActivity();
}