
package TimeTable ;

import com.assignment1.Lessons;
import com.assignment1.School;
import com.assignment1.Student;
import com.assignment1.Tutors;
import com.assignment1.Users;




/**
 *
 * @author ornha
 */

// this class serves as a controller and a gateway to the composite pattern, 
// this class is awlays used to get through to the composite pattern

public class TimeTableController {    
   
    // creates weeks for the composite pattern
   private final  Week firstTerm= new Week();
   private final  Week secondTerm= new Week();
   private final  Week semester= new Week();
   private final  Week one = new Week(1);   
   private final  Week two = new Week(2); 
   private final  Week three = new Week(3);
   private final  Week four = new Week(4); 
   
   private final  Week five = new Week(5); 
   private final  Week six = new Week(6); 
   private final  Week seven = new Week(7);
   private final  Week eight = new Week(8);
   
   // all weeks are inserted into an array
   private final Week[] weeks = {one,two,three,four,five,six,seven,eight};

    /**
     *
     * @param activity
     */
    public void injectActivityToTimeTable(School activity){ // this method adds lesson and office hours into each week of the composite pattern
    for(Week s: weeks){ // the array is used to iterate through the weeks adding activity to each week
       s.getWeekOrDayNumer();
       s.addActivityToDay(activity);
       }     
    }
   
    /**
     *
     */
    public void injectDayIntoWeek(){
   for(Week s: weeks){
    s.insertDaysIntoWeek();
         }
   }
   
    /**
     *
     */
    public void combineAllWeeks(){ // This method adds each week into a one container 
    for(Week s: weeks){
    semester.addTime(s); 
    if(s.getWeekOrDayNumer() <=4){ // the first term
       firstTerm.addTime(s);
   }
    if(s.getWeekOrDayNumer() >4){ // the second term
       secondTerm.addTime(s);
        }
     }  
  }

    /**
     *
     * @param person
     * @param activity
     * @param weekNumber
     * @return
     */
    public String attendStudentLesson(Users person, School activity, int weekNumber){ // this method sends students into the composite pattern to attend lesson on the timetable
    String check = "";
    TimeTable newWeek = semester.getWeek(weekNumber);
    check =newWeek.studentAttendsActicity(person,activity);
    return check;
  }
   
    /**
     *
     * @param person
     * @param activity
     * @param weekNumber
     * @return
     */
    public String cancelStudentsLesson(Users person, School activity, int weekNumber){ // this method sends students into the composite pattern to cancel a lesson on the timetable

    TimeTable newWeek = semester.getWeek(weekNumber);
  String check=newWeek.cancelActivity(person,activity);
    return check;
  }
  
    /**
     *
     * @param person
     * @param activity
     * @param weekNumber
     * @param time
     * @return
     */
    public String parentBookAppointment(Users person, School activity, int weekNumber,String time){ // this method sends Parents into the composite pattern to book appointment on the timetable
    TimeTable newWeek = semester.getWeek(weekNumber);
    String results = newWeek.attendActivity(activity,person,time,newWeek.getWeekOrDayNumer());
    return results;
  }

    /**
     *
     * @param student
     * @param lesson
     */
    public void addStudentToTimeTable(Users student, Lessons lesson){  // this method sends students into the composite pattern to be added to a lesson on the timetable
   semester.addStudentToLesson(student, lesson);
    }
    
    /**
     *
     * @param student
     * @param lesson
     */
    public void changeStudentLesson(Student student, Lessons lesson){ // this method sends students into the composite pattern to change a lesson on the timetable
   semester.changeStudentLesson(student, lesson);
    }
    
    /**
     *
     * @param student
     * @param lesson
     */
    public void studentQuitsLesson(Student student, Lessons lesson){// this method sends students into the composite pattern to quit a lesson on the timetable
     semester.studentQuitsLesson(student,lesson);
    }
    
    /**
     *
     * @param tutor
     * @param user
     * @return
     */
    public String getTutorsAppointment(Tutors tutor, Users user){ // this method sends parents into the composite pattern to view Appointments on the timetable
    String appointments =  tutor+"\n\n";   
    appointments += "THESE OFFICE HOURS ARE ALWAY ON " + tutor.getMyOfficeHours().getDay()+"S\n";  
    appointments+= semester.getTutorsAppointments(tutor,user);
     return appointments;
    }
    
   //retuns the first week in the time table, it's only for testing 

    /**
     *
     * @return
     */
    public Week getWeekOne(){
    return one;
        }
       
 
    /**
     *
     * @return
     */ 
    // returns all weeks in the time table;           
   public Week getSemester(){
   return semester;
   }
   
 

    /**
     *
     * @return
     */ 
   //returns the first four weeks in the time table, for tutorReport;
    public Week getFirstTerm(){
    return firstTerm;
   }
    

    /**
     *
     * @return
     */
    // return weeks five to eight in the time table, for tutorReport;
    public Week getSecondTerm(){
    return secondTerm;
   }
   }

        