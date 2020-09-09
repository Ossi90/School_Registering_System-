 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimeTable;

import com.assignment1.*;
import TimeTable.Day;

import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import com.assignment1.Users;


/**
 *
 * @author ornha
 */
public class DayTest {
    HardCodedData data = new HardCodedData();
    SchoolDataBase Schooldata = data.getRegisteredLessons();
    TimeTableController  time = data.getTimeTable();
    
    Parents ornharads = new Parents("Orn Haraldsson");
    Parents Alexandra = new Parents("Alexndra Rognvaldsdottir");
    Parents Haraldur = new Parents("Haraldur Olafsson");
    Parents Erna = new Parents("Erna ArnarDottir");
    
    Users rambo = (Users) new Student("rambo James","Baker Street", 4875155);
    Users jack = (Users) new Student("Jack Ralf","Green Street", 5566658);
    Users steven = (Users) new Student("Steve Stevenson","Blue Street", 447555);
    Users nick = (Users) new Student("Nick","Baker Street", 4875155);
    Users orn = (Users) new Student("Orn","Green Street", 5566658);
    Users lolly = (Users) new Student("Lolly","Blue Street", 447555);
       
    Tutors picasso = new Tutors("Pablo Picasso","Red Street",8955);
    Tutors dali = new Tutors("Salvador Dali","Yellow Street",7412);
    Tutors barry = new Tutors("Barry McGee","Gray Street",2589);
    Tutors frida = new Tutors("Frida Kahlo","Bay Street",3589);
    Tutors monet = new Tutors("Claude Monet","Holy Street",4589);
    
    DayOfWeek mon = DayOfWeek.MONDAY;
    DayOfWeek tue = DayOfWeek.TUESDAY; 
    DayOfWeek wed = DayOfWeek.WEDNESDAY; 
    DayOfWeek thu = DayOfWeek.THURSDAY; 
    DayOfWeek fri = DayOfWeek.FRIDAY; 
    
    Users Bill =  (Users) new Tutors("Bill Billson","Gray Street",2589);
    Users Dave =   (Users) new Tutors("Dave Davesson","Red Street",8955);
    Users Bobbo =  (Users) new Tutors("Bobbo Bobson","Yellow Street",7412);
    
    Lessons english = new Lessons((Tutors)Dave,"English","07.00-08.00",mon,"Room A",6);
    Lessons math = new Lessons((Tutors)Bobbo,"Math","07.00-08.00",mon,"Room B",6);
    Lessons french = new Lessons((Tutors)Bill,"French","10.00-11.00",tue,"Room A",6);
    Lessons database = new Lessons((Tutors)Dave, "Database", "11.00-12.00",tue,"Room A",6);

    Week week = new Week();
   
    Week one = new Week(1);   
    Week two = new Week(2);   
    
    /**
     *
     */
    public DayTest() {
     
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
     * Test of addActivtyToDay method, of class Day.
     */
    @Test
    public void testAddActivtyToDay(){
      
       
       Day monday = one.getMonday();
       monday.addActivtyToDay(english);
       monday.addActivtyToDay(math);
       
       assertEquals(2,one.getMonday().getLessonSetSize());
    }



    /**
     * Test of getDay method, of class Day.
     */
    @Test
    public void testGetDay() {
        Day monday = one.getMonday();
        Day tuesday =one.getTuesday();
        DayOfWeek mon2 = DayOfWeek.MONDAY;
        DayOfWeek tue2 = DayOfWeek.TUESDAY; 
        assertEquals(true,mon2.equals(monday.getDay()));
        assertEquals(true,tue2.equals(tuesday.getDay()));
    }

    /**
     * Test of studentTimeTable method, of class Day.
     */
    @Test
    public void testStudentTimeTable() {
        Day monday = one.getMonday();
        Day tuesday =one.getTuesday();
        english.addStudent((Student)orn);
        english.addStudent((Student) steven);
        english.addStudent((Student) jack); 
        one.addActivityToDay(english);
        one.addActivityToDay(math);
        math.addStudent((Student) nick);
        one.addActivityToDay(math);
        french.addStudent((Student) steven);
        one.addActivityToDay(french);
        
        one.insertDaysIntoWeek();
 
       assertEquals(1,monday.getStudentHashMapSize());
    
    }



    /**
     * Test of hasActivity method, of class Day.
     */
    @Test
    public void testHasActivity() {
        Day monday = one.getMonday();
        Day tuesday =one.getTuesday();
        english.addStudent((Student) orn);
        english.addStudent((Student) steven);
        english.addStudent((Student) jack); 
        one.addActivityToDay(english);
        one.addActivityToDay(math);
        math.addStudent((Student) nick);
        one.addActivityToDay(math);
        french.addStudent((Student) steven);
        one.addActivityToDay(french);
     
        assertEquals(true,monday.hasActivity(math));
        assertEquals(true,monday.hasActivity(english));
        assertEquals(true,tuesday.hasActivity(french));
        assertEquals(false,tuesday.hasActivity(math));
        assertEquals(false,tuesday.hasActivity(english));
        assertEquals(false,monday.hasActivity(french));
        
    }

        /**
     * Test of studentAttendsActicity method, of class Day.
     */
    @Test
    public void testStudentAttendsActicity() {
       orn = (Users) new Student("Orn","Green Street", 5566658);
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
     * Test of studentAttendsActicity method, of class Day.
     */
    @Test
      public void testStudentAttends() {
   
    
    }

    /**
     * Test of getWeekOrDayNumer method, of class Day.
     */
    @Test
    public void testGetWeekOrDayNumer() {
         Day tuesday =one.getTuesday();
    assertEquals(-1, tuesday.getWeekOrDayNumer());
    }

    /**
     * Test of getStudentMap method, of class Day.
     */
    @Test
    public void testGetStudentMap() {
        
        
       

        english.addStudent((Student) steven); 
        french.addStudent((Student) steven);

         
        two.addActivityToDay(english);
        two.addActivityToDay(math);
        two.addActivityToDay(french);
        two.insertDaysIntoWeek();


        one.studentAttendsActicity(steven,english);
        two.studentAttendsActicity(steven,english);
        one.addActivityToDay(english);
        one.addActivityToDay(math);
        one.addActivityToDay(french);
        
        two.insertDaysIntoWeek();

        one.studentAttendsActicity(steven,english);
        two.studentAttendsActicity(steven,english);
        one.insertDaysIntoWeek();

        one.studentAttendsActicity(steven,english);
        two.studentAttendsActicity(steven,english);
        
        Map week1 = one.getMonday().getStudentMap();
        Map week2 = two.getMonday().getStudentMap();
     
        
        assertEquals(week1,week2);
    }

    /**
     * Test of getStudentHashMapSize method, of class Day.
     */
    @Test
    public void testGetStudentHashMapSize() {
     
       
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
        
         assertEquals(1,one.getMonday().getStudentHashMapSize());
    }

    /**
     * Test of removeStudent method, of class Day.
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
     * Test of parentTimeTable method, of class Day.
     */
    @Test
    public void testParentTimeTable() {
        
        OfficeHours officePicasso = new OfficeHours(picasso,mon,0);
        one.addActivityToDay(officePicasso);
        Day monday = one.getMonday();
        one.attendActivity(officePicasso, Erna, "14:00", 1);
        one.attendActivity(officePicasso, ornharads, "14:20", 1);
        one.attendActivity(officePicasso, Alexandra, "14:40", 1);
        one.insertDaysIntoWeek();
            
       assertEquals(3,monday.getParetsMapSize());
    }

    /**
     * Test of studentAttendsActicity method, of class Day.
     */
    @Test
    public void testRegisterActivity_People_School() {
      Day monday = one.getMonday();
        english.addStudent((Student) orn);
        english.addStudent((Student) steven);
        english.addStudent((Student) jack); 
        one.addActivityToDay(english);
        one.addActivityToDay(math);
        math.addStudent((Student) nick);
        one.addActivityToDay(math);
        french.addStudent((Student) steven);
        one.addActivityToDay(french);
        
        one.insertDaysIntoWeek();
 
       assertEquals(1,monday.getStudentHashMapSize());
    }

    /**
     * Test of studentAttendsActicity method, of class Day.
     */
    @Test
    public void testRegisterActivity_3args() {
        OfficeHours officePicasso = new OfficeHours(picasso,mon,0);
        one.addActivityToDay(officePicasso);
        Day monday = one.getMonday();   
        officePicasso.BookAppointment(Erna);
        officePicasso.BookAppointment(ornharads);
        officePicasso.BookAppointment(Alexandra);
        one.insertDaysIntoWeek();
        one.attendActivity(officePicasso, Erna, "14:00", 1);
        one.attendActivity(officePicasso, ornharads, "14:20", 1);
        one.attendActivity(officePicasso, Alexandra, "14:40", 1);
        
 
       assertEquals(ornharads.getName(),monday.getParentActivity("14:20", officePicasso));
    }

    /**
     * Test of getParetsMapSize method, of class Day.
     */
    @Test
    public void testGetParetsMapSize() {


        Week week = time.getWeekOne();
        Day day = week.getMonday();
        assertEquals(day.getParetsMapSize(),3);
        assertEquals(day.getParetsMapSize() == 4,false);

    }

    /**
     * Test of cancelActivity method, of class Day.
     */
    @Test
    public void testCancelActivity() {
        Student s = Schooldata.getStudentByID(2030);
        Lessons l = Schooldata.findLesson("English");
      String check =  time.cancelStudentsLesson(s,l,1);

        assertEquals(check, "");
    }

    /**
     * Test of getLessonSetSize method, of class Day.
     */
    @Test
    public void testSetLessonSetSize() {
       Day monday = one.getMonday();
       Day tuesday =one.getTuesday();
       monday.addActivtyToDay(english);
       monday.addActivtyToDay(math);
       
        
       
       assertEquals(2,monday.getLessonSetSize());
   
    }



    /**
     * Test of addStudentToTimeTable method, of class Day.
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
     * Test of studentQuitsLesson method, of class Day.
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
     * Test of registerActivity method, of class Day.
     */
    @Test
    public void testRegisterActivity() {
      Parents parent = new Parents("H");


   String check =  time.parentBookAppointment(parent,Schooldata.getOfficeHours("Pablo Picasso"),1,"14:20");
        assertEquals(check,"");
    }


















 
  

  


    
    
}
