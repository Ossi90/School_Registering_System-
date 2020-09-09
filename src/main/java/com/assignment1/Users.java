/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment1;

import java.util.Set;

/**
 *
 * @author ornha
 */

// This is the interface for Users
// Parents, and SchoolPeople implement this interface
public interface Users {

    /**
     *
     * @return
     */
    public String getName();

    /**
     *
     * @return
     */
    @Override
    public String toString();

    /**
     *
     * @return
     */
    public String getAddress();

    /**
     *
     * @return
     */
    public int getID();

    /**
     *
     * @return
     */
    public int getTelephoneNumber();

    /**
     *
     * @return
     */
    public Set getMyLessonsSet();

    /**
     *
     * @param officeHour
     */
    public void myAppointments(OfficeHours officeHour);

    /**
     *
     * @return
     */
    public OfficeHours getMyOfficeHours();
    
}
