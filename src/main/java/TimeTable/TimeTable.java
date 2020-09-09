/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimeTable;
import com.assignment1.*;
import java.time.DayOfWeek;
import java.util.List;

/**
 *
 * @author ornha
 */

// This is the interFace for the composite pattern
public interface TimeTable {

    /**
     *
     * @return
     */
    public List getDays();

    /**
     *
     * @return
     */
    public int getLessonSetSize();

    /**
     *
     * @return
     */
    public Day getMonday();

    /**
     *
     * @param tutor
     * @return
     */
    public String tutorReport(Users tutor);

    /**
     *
     * @param student
     * @return
     */
    public String studentReport(Student student);

    /**
     *
     * @return
     */
    public int getWeekOrDayNumer();

    /**
     *
     * @param tutor
     * @param user
     * @return
     */
    public String getTutorsAppointments(Tutors tutor,Users user);

    /**
     *
     * @param lesson
     * @return
     */
    public boolean hasActivity(School lesson);

    /**
     *
     * @param student
     * @param lesson
     */
    public void changeStudentLesson(Student student, Lessons lesson);

    /**
     *
     * @param student
     * @param lesson
     */
    public void studentQuitsLesson(Student student, Lessons lesson);

    /**
     *
     * @param student
     * @param l
     * @return
     */
    public String studentAttendsActicity(Users student, School l);

    /**
     *
     * @param student
     * @param lesson
     */
    public void removeStudent(Student student,Lessons lesson);

    /**
     *
     * @param student
     * @param lesson
     * @return
     */
    public String cancelActivity(Users student, School lesson);

    /**
     *
     * @param student
     * @param lesson
     */
    public void addStudentToLesson(Users student,Lessons lesson);

    /**
     *
     * @param activity
     * @param person
     */
    public void cancelStudentsActivity(School activity, Users person);

    /**
     *
     * @param officehour
     * @param parentName
     */
    public void bookAppointment(OfficeHours officehour, String parentName);

    /**
     *
     * @param appointment
     * @param time
     * @param parent
     * @return
     */
    public String registerActivity(School appointment,String time,Users parent);

    /**
     *
     * @param activity
     * @param person
     * @param time
     * @param weekNr
     * @return
     */
    public String attendActivity(School activity, Users person, String time, int weekNr);
   
   
}
