/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimeTable;

import com.assignment1.*;

import java.time.DayOfWeek;
import java.util.HashMap;
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
public class TimeTableControllerTest {
    HardCodedData data = new HardCodedData();
    SchoolDataBase Schooldata = data.getRegisteredLessons();
    TimeTableController time = data.getTimeTable();


    
   private Parents ornharads = new Parents("Orn Haraldsson");
   private Parents Alexandra = new Parents("Alexndra Rognvaldsdottir");
   private Parents Haraldur = new Parents("Haraldur Olafsson");
   private Parents Erna = new Parents("Erna ArnarDottir");
    
   private  DayOfWeek mon = DayOfWeek.MONDAY;
   private  DayOfWeek tue = DayOfWeek.TUESDAY; 
   private  DayOfWeek wen = DayOfWeek.WEDNESDAY; 
   private  DayOfWeek thu = DayOfWeek.THURSDAY; 
   private  DayOfWeek fri = DayOfWeek.FRIDAY;
   
   private  Week week= new Week();
   private  Week one = new Week(1);   
   private  Week two = new Week(2); 
   private  Week three = new Week(3);
   private  Week four = new Week(4); 
   
   private  Week five = new Week(5); 
   private  Week six = new Week(6); 
   private  Week seven = new Week(7);
   private  Week eight = new Week(8);
   
   private Day monday = new Day(mon);
   private Day tuesday = new Day(tue);
   private Day wednesday = new Day(wen);
   private Day thursday = new Day(thu);
   private Day friday = new Day(fri);
   
    Tutors Dave = new Tutors("Dave Davesson","Red Street",8955);
    Tutors bob = new Tutors("Bob Bobson","Yellow Street",7412);
    Tutors Bill = new Tutors("Bill Billson","Gray Street",2589);
    Tutors Gill = new Tutors("Gill S","Bay Street",3589);
    Tutors Maria = new Tutors("Maria M","Holy Street",4589);
    
    Student rambo = new Student("rambo James","Baker Street", 4875155);
    Student jack = new Student("Jack Ralf","Green Street", 5566658);
    Student steven = new Student("Steve Stevenson","Blue Street", 447555);
    Student nick = new Student("Nick","Baker Street", 4875155);
    Student orn = new Student("Orn","Green Street", 5566658);
    Student lolly = new Student("Lolly","Blue Street", 447555);
    
    Lessons english = new Lessons(Dave,"English","07.00-08.00",mon,"Room A",6);
    Lessons math = new Lessons(bob,"Math","07.00-08.00",mon,"Room B",6);
    Lessons french = new Lessons(Bill,"French","10.00-11.00",tue,"Room A",6);
    Lessons programming = new Lessons(Gill,"Programming","10.00-11.00",wen,"Room A",6);
    Lessons science = new Lessons(Maria,"Science","08.00-09.00",wen,"Room A",6);
    Lessons database = new Lessons(Dave, "Database", "11.00-12.00",tue,"Room A",6);
    Lessons UX = new Lessons(bob, "User Experience","07.00-08.00",wen,"Room B",6);
    Lessons spanish = new Lessons(Bill, "Spanish","12.00-13.00",thu,"Room A",6);
    Lessons history = new Lessons(Gill, "History","14.00-15.00",fri,"Room B",6);
    Lessons webDesign = new Lessons(Maria,"Web Design","10.00-11.00",fri,"Room A",6);
    
    /**
     *
     */
    public TimeTableControllerTest() {
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
     * Test of injectActivityToTimeTable method, of class TimeTableController.
     */
    @Test
    public void testInjectLessonToTimeTable() {
        monday.addActivtyToDay(english);
        tuesday.addActivtyToDay(french);
        wednesday.addActivtyToDay(programming);
        thursday.addActivtyToDay(spanish);
        friday.addActivtyToDay(history);
        
        assertEquals(true,monday.hasActivity(english));
        assertEquals(true,tuesday.hasActivity(french));
        assertEquals(true,wednesday.hasActivity(programming));
        assertEquals(true, thursday.hasActivity(spanish));
        assertEquals(true, friday.hasActivity(history));
        assertEquals(false, monday.hasActivity(history));
    }

    /**
     * Test of injectDayIntoWeek method, of class TimeTableController.
     */
    @Test
    public void testInjectDayIntoWeek() {
    Week[] weeks = {one,two,three,four,five,six,seven,eight};   
         for(Week s: weeks){
         s.addTime(monday);
         s.addTime(tuesday);
         s.addTime(wednesday);
         s.addTime(thursday);
         s.addTime(friday);
    }
         
         assertEquals(true, one.hasDay(monday));
         assertEquals(true, two.hasDay(monday));
         assertEquals(true, two.hasDay(tuesday));
         assertEquals(true, one.hasDay(tuesday));
         
         assertEquals(true, eight.hasDay(monday));
         assertEquals(true,seven.hasDay(monday));
         assertEquals(true, six.hasDay(tuesday));
         assertEquals(true,five.hasDay(tuesday));
         
         assertEquals(true, four.hasDay(friday));
         assertEquals(true, four.hasDay(thursday));
         assertEquals(true, five.hasDay(wednesday));
         assertEquals(true, one.hasDay(friday));
         
         assertEquals(true, eight.hasDay(tuesday));
         assertEquals(true,seven.hasDay(friday));
         assertEquals(true, six.hasDay(monday));
         assertEquals(true,five.hasDay(wednesday));
    }
   
    /**
     *
     */
    @Test
    public void testCombineWeeks() {
       
       
       week.addTime(one);
       week.addTime(two);
       week.addTime(three);
       week.addTime(four);
       week.addTime(five);
       week.addTime(six);
       week.addTime(seven);
       week.addTime(eight);
       
       
       assertEquals(true, week.hasWeek(one));
       assertEquals(true, week.hasWeek(two));
       assertEquals(true, week.hasWeek(three));
       assertEquals(true, week.hasWeek(four));
       assertEquals(true, week.hasWeek(five));
       assertEquals(true, week.hasWeek(six));
       assertEquals(true, week.hasWeek(seven));
       assertEquals(true, week.hasWeek(eight));
    }

    /**
     * Test of getSemester method, of class TimeTableController.
     */
    @Test
    public void testGetWeeks() {
        
    TimeTableController time2 = new TimeTableController();
    time2.injectActivityToTimeTable(history);
    time2.injectActivityToTimeTable(english);
    time2.injectActivityToTimeTable(french);
    time2.injectActivityToTimeTable(programming);
    time2.injectActivityToTimeTable(spanish);

 
   
       
    TimeTableController time = new TimeTableController();
    time.injectActivityToTimeTable(history);
    time.injectActivityToTimeTable(english);
    time.injectActivityToTimeTable(french);
    time.injectActivityToTimeTable(programming);
    time.injectActivityToTimeTable(spanish);

    time.combineAllWeeks();
    
//    assertEquals(time2.getSemester().tutorReport(),time.getSemester().tutorReport());
    
    }

    /**
     * Test of attendStudentLesson method, of class TimeTableController.
     */
    @Test
    public void testAttendLesson() {
        Student nick = new Student("Nick","Baker Street", 4875155);
        Student orn = new Student("Orn","Green Street", 5566658); 
        english.addStudent(orn);
        math.addStudent(nick);
        time.injectActivityToTimeTable(english);
        time.injectActivityToTimeTable(math);
        time.combineAllWeeks();
      
        time.attendStudentLesson(orn, english, 1);
        time.attendStudentLesson(nick, math, 1);
        one = time.getWeekOne();
        Day monday = one.getMonday();
      
        Map<Lessons,HashMap<Student,Boolean>> mondayMap = monday.getStudentMap();
        assertEquals("Attended", mondayMap.get(english).get(orn));
        assertEquals("Attended", mondayMap.get(math).get(nick));
        
    }

    /**
     * Test of removeStudent method, of class TimeTableController.
     */
    @Test
    public void testRemoveStudent() {
  
        Student orn = new Student("Orn","Green Street", 5566658); 
        english.addStudent(orn);
     ;
        time.injectActivityToTimeTable(english);
       

        time.combineAllWeeks();
      
        one = time.getWeekOne();
        Day monday = one.getMonday();
      
        Map<Lessons,HashMap<Student,Boolean>> mondayMap = monday.getStudentMap();
        assertEquals("Did Not Attend", mondayMap.get(english).get(orn));
        
         one.removeStudent(orn, english);
        assertEquals(0,one.getMonday().getStudentHashMapSize());
        
    }

    /**
     *
     */
    @Test
    public void testGetWeekOne() {
      TimeTableController t= new TimeTableController();
      Week oneB = t.getWeekOne();
      assertEquals(oneB.toString(),one.toString());
    }

    /**
     * Test of attendStudentLesson method, of class TimeTableController.
     */
    @Test
    public void testAttendStudentActivity() {
        TimeTableController t= new TimeTableController();
        english.addStudent(orn);
        t.injectActivityToTimeTable(english);
        t.combineAllWeeks();

       
       t.attendStudentLesson(orn, english, 1);
    
        Week newWeek = t.getWeekOne();
        Day m = newWeek.getMonday();

        assertEquals(m.getStudentHashMapSize(),1);
        
    }

    /**
     * Test of parentBookAppointment method, of class TimeTableController.
     */
    @Test
    public void testAttendParentActivity() {
     TimeTableController t= new TimeTableController();
        
        OfficeHours officeDave= new OfficeHours(Dave,mon,0);
        t.injectActivityToTimeTable(officeDave);
        t.combineAllWeeks();
        Day monday = one.getMonday();
       
        t.parentBookAppointment(Erna, science, 1, "14:00");
        t.parentBookAppointment(Alexandra, science, 1, "14:20");
        t.parentBookAppointment(ornharads, science, 1, "14:40");
    
        Week newWeek = t.getWeekOne();
        Day m = newWeek.getMonday();
        
        assertEquals(m.getParetsMapSize(),3);
    }



    /**
     * Test of attendStudentLesson method, of class TimeTableController.
     */
    @Test
    public void testAttendStudentLesson() {
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
     * Test of cancelStudentsLesson method, of class TimeTableController.
     */
    @Test
    public void testCancelStudentsLesson() {
        Student s = Schooldata.getStudentByID(2030);
        Lessons l = Schooldata.findLesson("English");
        String check =  time.cancelStudentsLesson(s,l,1);
        assertEquals(check, "");
    }

    /**
     * Test of parentBookAppointment method, of class TimeTableController.
     */
    @Test
    public void testParentBookAppointment() {
        Parents parent = new Parents("H");
        String check =  time.parentBookAppointment(parent,Schooldata.getOfficeHours("Pablo Picasso"),1,"14:20");
        assertEquals(check,"");
    }

    /**
     * Test of addStudentToTimeTable method, of class TimeTableController.
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
     * Test of studentQuitsLesson method, of class TimeTableController.
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








    
}
