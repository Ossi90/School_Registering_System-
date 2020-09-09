/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimeTable;

import com.assignment1.*;

import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class WeekTest {
    HardCodedData data = new HardCodedData();
    SchoolDataBase Schooldata = data.getRegisteredLessons();
    TimeTableController  time = data.getTimeTable();
    Student rambo = new Student("rambo James","Baker Street", 4875155);
    Student jack = new Student("Jack Ralf","Green Street", 5566658);
    Student steven = new Student("Steve Stevenson","Blue Street", 447555);
    Student nick = new Student("Nick","Baker Street", 4875155);
    Student orn = new Student("Orn","Green Street", 5566658);
    Student lolly = new Student("Lolly","Blue Street", 447555);
    
    DayOfWeek mon = DayOfWeek.MONDAY;
    DayOfWeek tue = DayOfWeek.TUESDAY; 
    
    Tutors Bill = new Tutors("Bill Billson","Gray Street",2589);
    Tutors Dave = new Tutors("Dave Davesson","Red Street",8955);
    Tutors Bob = new Tutors("Bob Bobson","Yellow Street",7412);
    
    Lessons english = new Lessons(Dave,"English","07.00-08.00",mon,"Room A",6);
    Lessons math = new Lessons(Bob,"Math","07.00-08.00",mon,"Room B",6);
    Lessons french = new Lessons(Bill,"French","10.00-11.00",tue,"Room A",6);
    Lessons database = new Lessons(Dave, "Database", "11.00-12.00",tue,"Room A",6);
    Week one = new Week(1);
   
    /**
     *
     */
    public WeekTest() {
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
     * Test of addTime method, of class Week.
     */
    @Test
    public void testAddTime() {
      
    }

    /**
     * Test of listSize method, of class Week.
     */
    @Test
    public void testListSize() {
        Day monday = one.getMonday();
        Day tuesday = one.getTuesday();
        monday.addActivtyToDay(math);
        monday.addActivtyToDay(english);
        one.addTime(monday);
        assertEquals(1,one.listSize());
        
        tuesday.addActivtyToDay(math);
        one.addTime(tuesday);
        assertEquals(2,one.listSize());
    }

    /**
     * Test of getWeekNumer method, of class Week.
     */
    @Test
    public void testGetWeekNumer() {
       assertEquals(1,one.getWeekOrDayNumer());
    }

    /**
     * Test of getWeekOrDayNumer method, of class Week.
     */
    @Test
    public void testGetWeekOrDayNumer() {
        assertEquals(1,one.getWeekOrDayNumer());
   
    }

    /**
     * Test of getWeek method, of class Week.
     */
    @Test
    public void testGetWeek() {
        Week week = new Week();
        week.addTime(one);
      assertEquals(one,week.getWeek(1));  
     
    }

    /**
     * Test of hasDay method, of class Week.
     */
    @Test
    public void testHasDay() {
      Day monday = one.getMonday();
       Day tuesday =one.getTuesday();
        english.addStudent(orn);
        english.addStudent(steven); 
        french.addStudent(steven);
        math.addStudent(nick);
        
        one.addActivityToDay(english);
        one.addActivityToDay(math);
        one.addActivityToDay(french);
        
        one.insertDaysIntoWeek();
        one.studentAttendsActicity(orn,english);
        one.studentAttendsActicity(steven,english);
        
         assertEquals(true,one.hasDay(monday)); 
        
        
    }

    /**
     * Test of hasWeek method, of class Week.
     */
    @Test
    public void testHasWeek() {
          Week week = new Week();
        week.addTime(one);
      assertEquals(true,week.hasWeek(one));  
    }



    /**
     * Test of hasActivity method, of class Week.
     */
    @Test
    public void testHasLesson() {
        assertEquals(false,one.hasActivity(math));
     
    }

    /**
     * Test of addActivityToDay method, of class Week.
     */
    @Test
    public void testAddLessonsToDay() {
       one.addActivityToDay(math);
       one.addActivityToDay(english);
       
       assertEquals(true,one.getMonday().hasActivity(math));
       assertEquals(true,one.getMonday().hasActivity(english));
    }

    /**
     * Test of attendActivity method, of class Week.
     */
    @Test
    public void testAttendLesson() {
     Day monday = one.getMonday();
       Day tuesday =one.getTuesday();
        english.addStudent(orn);
        english.addStudent(steven); 
        french.addStudent(steven);
        math.addStudent(nick);
        
        one.addActivityToDay(english);
        one.addActivityToDay(math);
        one.addActivityToDay(french);
        
        one.insertDaysIntoWeek();
        one.studentAttendsActicity(orn,english);
        one.studentAttendsActicity(steven,english);
         one.studentAttendsActicity(steven,english);
        Map<Lessons,HashMap<Student,Boolean>> mondayMap = monday.getStudentMap();
        Map<Lessons,HashMap<Student,Boolean>> tuesDayMap = tuesday.getStudentMap();

        assertEquals("Attended", mondayMap.get(english).get(orn));
        assertEquals(null, tuesDayMap.get(french).get(orn));
        assertEquals(null,tuesDayMap.get(french).get(nick));
        assertEquals("Did Not Attend", tuesDayMap.get(french).get(steven));
      
        
    }


    /**
     * Test of insertDaysIntoWeek method, of class Week.
     */
    @Test
    public void testInsertWeekDaysIntoWeek() {
        Day monday = one.getMonday();
        english.addStudent(orn);
        math.addStudent(steven);
        french.addStudent(nick);
        one.insertDaysIntoWeek();
        one.addActivityToDay(english);
        one.addActivityToDay(math);
        
        assertEquals(one.getMonday(),monday);
        assertEquals(true,monday.hasActivity(math));
    }

    /**
     * Test of getMonday method, of class Week.
     */
    @Test
    public void testGetMonday() {
     Day monday = one.getMonday();
     assertEquals(monday,one.getMonday());
     
    }

    /**
     * Test of getTuesday method, of class Week.
     */
    @Test
    public void testGetTuesday() {
      Day tuesday = one.getTuesday();
      assertEquals(tuesday,one.getTuesday());
    }

    /**
     * Test of removeStudent method, of class Week.
     */
    @Test
    public void testRemoveStudent() {
        english.addStudent((Student) orn);



        one.addActivityToDay(english);
        one.insertDaysIntoWeek();
        one.studentAttendsActicity(orn, english);

        assertEquals(1,one.getMonday().getStudentHashMapSize());

        one.removeStudent((Student) orn, english);
        assertEquals(0,one.getMonday().getStudentHashMapSize());

    }



    /**
     * Test of studentQuitsLesson method, of class Week.
     */
    @Test
    public void testStudentQuitsLesson() {
        Student s = Schooldata.getStudentByID(2030);
        Lessons l = Schooldata.findLesson("English");
        System.out.println(s);
        time.studentQuitsLesson(s,l);
        Week week = time.getWeekOne();
        Day day = week.getMonday();
        Map m = day.getStudentMap();
        assertEquals(m.get(s),null);
    }

    /**
     * Test of studentAttendsActicity method, of class Week.
     */
    @Test
    public void testStudentAttendsActicity() {

        Day monday = one.getMonday();
        Day tuesday =one.getTuesday();

        english.addStudent((Student) orn);
        english.addStudent((Student) steven);
        french.addStudent((Student) steven);
        math.addStudent((Student) nick);

        one.addActivityToDay(english);
        one.addActivityToDay(math);
        one.addActivityToDay(french);

        one.insertDaysIntoWeek();
        one.studentAttendsActicity(orn,english);
        one.studentAttendsActicity(steven,english);
        one.studentAttendsActicity(steven,french);
        Map<Lessons,HashMap<Student,Boolean>> mondayMap = monday.getStudentMap();
        Map<Lessons,HashMap<Student,Boolean>> tuesDayMap = tuesday.getStudentMap();

        assertEquals("Attended", mondayMap.get(english).get(orn));
        assertEquals(null, tuesDayMap.get(french).get(orn));
        assertEquals(null,tuesDayMap.get(french).get(nick));
        assertEquals("Attended", tuesDayMap.get(french).get(steven));
    }

    /**
     * Test of addStudentToTimeTable method, of class Week.
     */
    @Test
    public void testAddStudentToLesson() {
        Student s = Schooldata.getStudentByID(2030);
        Lessons l = Schooldata.findLesson("English");
        time.attendStudentLesson(s,l,1);
        Week week = time.getWeekOne();
        Day day = week.getMonday();
        Map m = day.getStudentMap();
        assertEquals(m.get(s),null);
    }

    /**
     * Test of cancelActivity method, of class Week.
     */
    @Test
    public void testCancelActivity() {
        Student s = Schooldata.getStudentByID(2030);
        Lessons l = Schooldata.findLesson("English");
        String check =  time.cancelStudentsLesson(s,l,1);

        assertEquals(check, "");
    }

    /**
     * Test of attendActivity method, of class Week.
     */
    @Test
    public void testAttendActivity() {
        Parents parent = new Parents("H");


        String check =  time.parentBookAppointment(parent,Schooldata.getOfficeHours("Pablo Picasso"),1,"14:20");
        assertEquals(check,"");
    }








  

}
