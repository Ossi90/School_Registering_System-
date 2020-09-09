/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment1;

import TimeTable.TimeTableController;
import java.time.DayOfWeek;

/**
 *
 * @author ornha
 */

/**
 This class is used for creating  hard coded data within the program
 **/
public class HardCodedData {
     SchoolDataBase registered = new SchoolDataBase();  
     TimeTableController time = new TimeTableController();

    /**
     *
     */
    public HardCodedData(){
        
        
        
    Parents Mike = new Parents("Mike Haraldsson");
    Parents Alexandra = new Parents("Alexndra Rognvaldsdottir");
    Parents Haraldur = new Parents("Haraldur Olafsson");
    Parents Erna = new Parents("Erna ArnarDottir");
    Parents harry = new Parents("Harry Allen");
    Parents tony = new Parents ("Tony Hawk");
    Parents rodney = new Parents ("Rodney Mullen");
    Parents jamie = new Parents ("Jamie Thomas");
    Parents elisa = new Parents ("Elisa Steamer");
    Parents noly = new Parents ("Moly Naria");
    Parents homer = new Parents("Homer Simpsson");
    Parents peter = new Parents ("Peter Griffen");
    Parents stan = new Parents ("Stan Smith");
    Parents bobby = new Parents("Bobby Fisher");
    Parents nina = new Parents("Nina Noonenberg");
    Parents alex = new Parents("Alex Randomer");
    Parents sofie = new Parents("Sofie Sambony");
    Parents silvia = new Parents("Silvia Bergen");
    Parents sonja = new Parents("Sonja Haraldsdottir");
    Parents monika= new Parents("Monika Moore");
    Parents steinun = new Parents("Steinun Samanda");   
    Parents grayham = new Parents("Grayham hollipoll");
    Parents fredo = new Parents("Fredo Canvazo");
    
    Student rambo = new Student("Phil James","Baker Street", 4875155);
    Student jack = new Student("Jack Ralf","Green Street", 5566658);
    Student steven = new Student("Steve Stevenson","Blue Street", 447555);
    Student nick = new Student("Nick Mellostone","Baker Street", 4875155);
    Student morty = new Student("Monrty Carlson","Brown Street", 5566658);
    Student lolly = new Student("Laura Jacksson","Blue Street", 447555);
    Student julia = new Student("Julia Jackbin","Yellow Street", 34532234);
    Student katrin = new Student("Katrin Uphill","Pink Street", 9857885);
    Student james = new Student("James Guiena","Red Street", 824886);
    Student sky = new Student("Sky Rendeldor","Dark Street", 989854);
    Student mobi = new Student("Mobi Barder","Light Street", 789654);
    Student lilly = new Student("Lilly Nextor","Big Street", 963228);
    Student van = new Student("Van Damme","Kick Street", 15987456);
    Student emma = new Student("Emma Spice","Girl Street", 7410002);
    Student igor = new Student("Igor Frank","Einstain Street", 22560023);
    

    
    DayOfWeek mon = DayOfWeek.MONDAY;
    DayOfWeek tue = DayOfWeek.TUESDAY; 
    DayOfWeek wed = DayOfWeek.WEDNESDAY; 
    DayOfWeek thu = DayOfWeek.THURSDAY; 
    DayOfWeek fri = DayOfWeek.FRIDAY; 
    
    Tutors picasso = new Tutors("Pablo Picasso","Red Street",8955);
    Tutors dali = new Tutors("Salvador Dali","Yellow Street",7412);
    Tutors barry = new Tutors("Barry McGee","Gray Street",2589);
    Tutors frida = new Tutors("Frida Kahlo","Bay Street",3589);
    Tutors monet = new Tutors("Claude Monet","Holy Street",4589);
    

    
    
    Lessons english = new Lessons(picasso,"English","07.00-08.00",mon,"Room A",6);
    Lessons math = new Lessons(dali,"Math","07.00-08.00",mon,"Room B",7);
    Lessons french = new Lessons(barry,"French","10.00-11.00",tue,"Room A",8);
    Lessons programming = new Lessons(frida,"Programming","10.00-11.00",wed,"Room A",5);
    Lessons science = new Lessons(monet,"Science","08.00-09.00",wed,"Room A",5);
    Lessons database = new Lessons(picasso, "Database", "11.00-12.00",tue,"Room A",4);
    Lessons UX = new Lessons(dali, "User Experience","07.00-08.00",wed,"Room B",10);
    Lessons spanish = new Lessons(barry, "Spanish","12.00-13.00",thu,"Room A",6);
    Lessons history = new Lessons(frida, "History","14.00-15.00",fri,"Room B",6);
    Lessons webDesign = new Lessons(monet,"Web Design","10.00-11.00",fri,"Room A",8);
    
    math.addStudent(emma);
    math.addStudent(julia);
    math.addStudent(rambo);
    math.addStudent(nick);
    math.addStudent(james);
    math.addStudent(sky);
    
    english.addStudent(mobi);
    english.addStudent(katrin);
    english.addStudent(morty);
    english.addStudent(steven);
    english.addStudent(lolly);
    english.addStudent(jack);
    
    french.addStudent(mobi);
    french.addStudent(sky);
    french.addStudent(katrin);
    french.addStudent(julia);
    french.addStudent(jack);
    french.addStudent(lolly);
    
    programming.addStudent(james);
    programming.addStudent(julia);
    programming.addStudent(morty);
    
    science.addStudent(jack);
    science.addStudent(nick);
    
    database.addStudent(james);
    database.addStudent(katrin);
    database.addStudent(jack);
    database.addStudent(lolly);
    
    UX.addStudent(igor);
    UX.addStudent(lilly);
    UX.addStudent(mobi);
    UX.addStudent(james);
    UX.addStudent(julia);
    UX.addStudent(rambo);
    UX.addStudent(morty);
    
    spanish.addStudent(sky);
    spanish.addStudent(katrin);
    spanish.addStudent(rambo);
    spanish.addStudent(nick);
    
    history.addStudent(van);
    history.addStudent(mobi);
    history.addStudent(sky);
    history.addStudent(julia);
    history.addStudent(rambo);
    history.addStudent(lolly);
    
    webDesign.addStudent(igor);
    webDesign.addStudent(emma);
    webDesign.addStudent(van);
    webDesign.addStudent(lilly);
    webDesign.addStudent(james);
    webDesign.addStudent(katrin);
    webDesign.addStudent(steven);
    webDesign.addStudent(nick);
    
    OfficeHours officePicasso = new OfficeHours(picasso,mon,0);
    OfficeHours officeDali = new OfficeHours(dali,tue,1);
    OfficeHours officeBarry= new OfficeHours(barry,wed,2);
    OfficeHours officeFrida = new OfficeHours(frida,thu,3);
    OfficeHours officeMonet = new OfficeHours(monet,fri,1);
  
     time.injectActivityToTimeTable(officePicasso);
     time.injectActivityToTimeTable(officeDali);
     time.injectActivityToTimeTable(officeBarry);
     time.injectActivityToTimeTable(officeFrida);
     time.injectActivityToTimeTable(officeMonet);
   
     time.injectActivityToTimeTable(english);
     time.injectActivityToTimeTable(math);
     time.injectActivityToTimeTable(database);
     time.injectActivityToTimeTable(french);
     time.injectActivityToTimeTable(science);
     time.injectActivityToTimeTable(programming);
     time.injectActivityToTimeTable(UX);
     time.injectActivityToTimeTable(spanish);
     time.injectActivityToTimeTable(history);
     time.injectActivityToTimeTable(webDesign);
     
     time.injectDayIntoWeek();
     time.combineAllWeeks();
     
     
     
     time.attendStudentLesson(emma, math, 1);
     time.attendStudentLesson(emma, math, 2);
     time.attendStudentLesson(emma, math, 3);
     time.attendStudentLesson(emma, math, 5);
     time.attendStudentLesson(emma, math, 7);
     time.attendStudentLesson(emma, math, 8);
     
     time.attendStudentLesson(rambo, math, 1);
     time.cancelStudentsLesson(rambo, science, 3);
     time.attendStudentLesson(rambo, math, 5);
     time.attendStudentLesson(rambo, math, 7);
     
     time.attendStudentLesson(julia, math, 1);
     time.attendStudentLesson(julia, math, 2);
     time.attendStudentLesson(julia, math, 3);
     time.attendStudentLesson(julia, math, 4);
     time.attendStudentLesson(julia, math, 5);
     time.attendStudentLesson(julia, math, 6);
     time.attendStudentLesson(julia, math, 7);
     time.attendStudentLesson(julia, math, 8);
     
     time.attendStudentLesson(nick, math, 5);
     time.attendStudentLesson(nick, math, 1);
     
     time.attendStudentLesson(james, math, 1);
     time.attendStudentLesson(james, math, 5);
     time.attendStudentLesson(james, math, 7);
     time.attendStudentLesson(james, math, 8);
     
     time.attendStudentLesson(sky, math, 2);
     time.attendStudentLesson(sky, math, 3);
     time.cancelStudentsLesson(sky, math, 4);
     time.cancelStudentsLesson(sky, math, 5);
     time.attendStudentLesson(sky, math, 7);
     time.attendStudentLesson(sky, math, 8);
  
     time.attendStudentLesson(mobi, english, 2);
     time.attendStudentLesson(mobi, english, 3);
     time.attendStudentLesson(mobi, english, 6);
     time.attendStudentLesson(mobi, english, 7);
     time.cancelStudentsLesson(mobi, english, 8);
     
     time.cancelStudentsLesson(morty, english, 1);
     time.cancelStudentsLesson(morty, english, 2);
     time.cancelStudentsLesson(morty, english, 3);
     time.cancelStudentsLesson(morty, english, 4);
     time.cancelStudentsLesson(morty, english, 5);
     time.cancelStudentsLesson(morty, english, 6);
     time.cancelStudentsLesson(morty, english, 7);
     time.cancelStudentsLesson(morty, english, 8);
     
     time.attendStudentLesson(katrin, english, 1);
     time.attendStudentLesson(katrin, english, 2);
     time.attendStudentLesson(katrin, english, 3);
     time.attendStudentLesson(katrin, english, 4);
     time.attendStudentLesson(katrin, english, 5);
     time.attendStudentLesson(katrin, english, 6);
     time.attendStudentLesson(katrin, english, 7);
     time.attendStudentLesson(katrin, english, 8);
     
     time.attendStudentLesson(steven, english, 2);
     time.attendStudentLesson(steven, english, 4);
     time.attendStudentLesson(steven, english, 8);
     
     time.attendStudentLesson(lolly, english, 1);
     
     time.attendStudentLesson(jack, english, 1);
     time.attendStudentLesson(jack, english, 2);
     time.attendStudentLesson(jack, english, 4);
     time.attendStudentLesson(jack, english, 7);
     time.attendStudentLesson(jack, english, 8);

      time.attendStudentLesson(mobi, french, 4);
      
      time.attendStudentLesson(katrin, french, 1);
      time.attendStudentLesson(katrin, french, 2);
      time.attendStudentLesson(katrin, french, 3);
      time.attendStudentLesson(katrin, french, 4);
      time.attendStudentLesson(katrin, french, 5);
      time.attendStudentLesson(katrin, french, 6);
      time.attendStudentLesson(katrin, french, 7);
      time.attendStudentLesson(katrin, french, 8);
      
      time.attendStudentLesson(julia, french, 1);
      time.attendStudentLesson(julia, french, 2);
      time.attendStudentLesson(julia, french, 3);
      time.attendStudentLesson(julia, french, 4);
      time.attendStudentLesson(julia, french, 5);
      time.attendStudentLesson(julia, french, 6);
      time.attendStudentLesson(julia, french, 7);
      time.attendStudentLesson(julia, french, 8);
      
      time.attendStudentLesson(jack, french, 1);
      time.cancelStudentsLesson(jack, french, 2);
      time.attendStudentLesson(jack, french, 3);
      time.attendStudentLesson(jack, french, 6);
      time.attendStudentLesson(jack, french, 7);
      
      time.cancelStudentsLesson(lolly, french, 1);
      time.attendStudentLesson(lolly, french, 2);
      time.attendStudentLesson(lolly, french, 7);
      time.cancelStudentsLesson(lolly, french, 6);
      time.attendStudentLesson(lolly, french, 8);
              
      time.attendStudentLesson(julia, programming, 1);
      time.attendStudentLesson(julia, programming, 2);
      time.attendStudentLesson(julia, programming, 3);
      time.attendStudentLesson(julia, programming, 4);
      time.attendStudentLesson(julia, programming, 5);
      time.attendStudentLesson(julia, programming, 6);
      time.attendStudentLesson(julia, programming, 7);
      time.attendStudentLesson(julia, programming, 8);
      
      time.attendStudentLesson(james, programming, 1);
      time.attendStudentLesson(james, programming, 2);
      time.attendStudentLesson(james, programming, 3);
      time.attendStudentLesson(james, programming, 6);
      
      time.cancelStudentsLesson(morty, programming, 1);
      time.cancelStudentsLesson(morty, programming, 2);
      time.cancelStudentsLesson(morty, programming, 3);
      time.cancelStudentsLesson(morty, programming, 4);
      time.cancelStudentsLesson(morty, programming, 5);
      time.cancelStudentsLesson(morty, programming, 6);
      time.cancelStudentsLesson(morty, programming, 7);
      time.cancelStudentsLesson(morty, programming, 8);
      
     
      
      time.attendStudentLesson(jack, science, 2);
      time.attendStudentLesson(jack, science, 4);
      time.attendStudentLesson(jack, science, 5);
      time.cancelStudentsLesson(jack, science, 6);
      time.attendStudentLesson(jack, science, 7);
      
      time.attendStudentLesson(nick, science, 5);
      time.attendStudentLesson(nick , science, 4);
      time.attendStudentLesson(jack, science, 7);
      time.attendStudentLesson(jack, science, 8);
      
      
      time.attendStudentLesson(james, database, 1);
      time.attendStudentLesson(james, database, 2);
      time.attendStudentLesson(james, database, 3);
      time.attendStudentLesson(james, database, 4);
      time.attendStudentLesson(james, database, 5);
      time.attendStudentLesson(james, database, 6);
      time.cancelStudentsLesson(james, database, 7);
      time.cancelStudentsLesson(james, database, 8);
      
      time.attendStudentLesson(katrin, database, 1);
      time.attendStudentLesson(katrin, database, 2);
      time.attendStudentLesson(katrin, database, 3);
      time.attendStudentLesson(katrin, database, 4);
      time.attendStudentLesson(katrin, database, 5);
      time.attendStudentLesson(katrin, database, 6);
      time.attendStudentLesson(katrin, database, 7);
      time.attendStudentLesson(katrin, database, 8);
      
      time.attendStudentLesson(jack, database, 1);
      
      time.attendStudentLesson(lolly, database, 2);
      time.attendStudentLesson(lolly, database, 4);
      time.attendStudentLesson(lolly, database, 6);
      time.attendStudentLesson(lolly, database, 8);
      
      time.attendStudentLesson(igor,UX, 1);
      time.attendStudentLesson(igor,UX, 5);
      
      time.attendStudentLesson(lilly,UX, 1);
      time.attendStudentLesson(lilly,UX, 2);
      time.attendStudentLesson(lilly,UX, 3);
      time.attendStudentLesson(lilly,UX, 4);
      time.attendStudentLesson(lilly,UX, 5);
      time.cancelStudentsLesson(lilly, UX, 6);
      
      time.attendStudentLesson(mobi,UX, 5);
      time.attendStudentLesson(mobi,UX, 7);
      time.attendStudentLesson(mobi,UX, 8);
      time.attendStudentLesson(mobi,UX, 6);
      
      time.attendStudentLesson(julia,UX, 1);
      time.attendStudentLesson(julia,UX, 2);
      time.attendStudentLesson(julia,UX, 3);
      time.attendStudentLesson(julia,UX, 4);
      time.attendStudentLesson(julia,UX, 5);
      time.attendStudentLesson(julia,UX, 6);
      time.attendStudentLesson(julia,UX, 7);
      time.attendStudentLesson(julia,UX, 8);
      
      time.cancelStudentsLesson(rambo, UX, 1);
      time.cancelStudentsLesson(rambo, UX, 2);
      time.cancelStudentsLesson(rambo, UX, 3);
      time.cancelStudentsLesson(rambo, UX, 4);
      time.cancelStudentsLesson(rambo, UX, 5);
      time.cancelStudentsLesson(rambo, UX, 6);
      time.cancelStudentsLesson(rambo, UX, 7);
      time.cancelStudentsLesson(rambo, UX, 8);
      
      time.attendStudentLesson(morty, UX, 1);
      time.attendStudentLesson(morty, UX, 3);
      time.attendStudentLesson(morty, UX, 5);
      time.attendStudentLesson(morty, UX, 7);
      
      time.cancelStudentsLesson(morty, UX, 2);
      time.cancelStudentsLesson(morty, UX, 4);
      time.cancelStudentsLesson(morty, UX, 6);
      time.cancelStudentsLesson(morty, UX, 8);

      time.attendStudentLesson(sky, spanish, 1);
      time.attendStudentLesson(sky, spanish, 2);
      time.attendStudentLesson(sky, spanish, 3);
      time.attendStudentLesson(sky, spanish, 4);
      time.attendStudentLesson(sky, spanish, 5);
      time.attendStudentLesson(sky, spanish, 6);
      time.attendStudentLesson(sky, spanish, 7);
      time.attendStudentLesson(sky, spanish, 8);
      
      time.attendStudentLesson(katrin, spanish, 1);
      time.attendStudentLesson(katrin, spanish, 2);
      time.attendStudentLesson(katrin, spanish, 3);
      time.attendStudentLesson(katrin, spanish, 4);
      time.attendStudentLesson(katrin, spanish, 5);
      time.attendStudentLesson(katrin, spanish, 6);
      time.attendStudentLesson(katrin, spanish, 7);
      time.attendStudentLesson(katrin, spanish, 8);
      
      time.attendStudentLesson(rambo, spanish, 1);
      time.attendStudentLesson(rambo, spanish, 2);
      time.attendStudentLesson(rambo, spanish, 3);
      time.attendStudentLesson(rambo, spanish, 4);
      time.attendStudentLesson(rambo, spanish, 5);
      time.attendStudentLesson(rambo, spanish, 6);
      time.attendStudentLesson(rambo, spanish, 7);
      time.attendStudentLesson(rambo, spanish, 8);
      
      time.attendStudentLesson(nick, spanish, 1);
      time.attendStudentLesson(nick, spanish, 2);
      time.attendStudentLesson(nick, spanish, 3);
      time.attendStudentLesson(nick, spanish, 4);
      time.attendStudentLesson(nick, spanish, 5);
      time.attendStudentLesson(nick, spanish, 6);
      time.attendStudentLesson(nick, spanish, 7);
      time.attendStudentLesson(nick, spanish, 8);
      
      time.attendStudentLesson(nick, spanish, 1);

      
      time.attendStudentLesson(van, history, 1);
      time.cancelStudentsLesson(van, history, 2);
      time.cancelStudentsLesson(van, history, 3);
      time.cancelStudentsLesson(van, history, 4);
      time.cancelStudentsLesson(van, history, 5);
      time.cancelStudentsLesson(van, history, 7);
      
      time.attendStudentLesson(julia, history, 1);
      time.attendStudentLesson(julia, history, 2);
      time.attendStudentLesson(julia, history, 3);
      time.attendStudentLesson(julia, history, 4);
      time.attendStudentLesson(julia, history, 5);
      time.attendStudentLesson(julia, history, 6);
      time.attendStudentLesson(julia, history, 7);
      time.attendStudentLesson(julia, history, 8);
      
      
      time.cancelStudentsLesson(rambo, history, 2);
      time.cancelStudentsLesson(rambo, history, 7);
      time.attendStudentLesson(rambo, history, 1);
      time.attendStudentLesson(rambo, history, 4);
      time.attendStudentLesson(rambo, history, 5);
      time.attendStudentLesson(rambo, history, 3);
      time.attendStudentLesson(rambo, history, 8);
      
      time.attendStudentLesson(lolly, history, 1);
      time.cancelStudentsLesson(lolly, history, 2);
      time.cancelStudentsLesson(lolly, history, 3);
      time.cancelStudentsLesson(lolly, history, 4);
      time.cancelStudentsLesson(lolly, history, 5);
      time.cancelStudentsLesson(lolly, history, 6);
      time.cancelStudentsLesson(lolly, history, 7);
      time.cancelStudentsLesson(lolly, history, 8);
      
      
      time.attendStudentLesson(emma, webDesign, 1);
      time.attendStudentLesson(emma, webDesign, 2);
      time.attendStudentLesson(emma, webDesign, 3);
      time.attendStudentLesson(emma, webDesign, 4);
      time.attendStudentLesson(emma, webDesign, 5);
      time.cancelStudentsLesson(emma, webDesign, 6);
      time.cancelStudentsLesson(emma, webDesign, 7);
      time.cancelStudentsLesson(emma, webDesign, 8);
      
      time.cancelStudentsLesson(van, webDesign, 1);
      
       time.attendStudentLesson(lilly, webDesign, 1);
       time.attendStudentLesson(lilly, webDesign, 3);
       time.attendStudentLesson(lilly, webDesign, 6);
       time.attendStudentLesson(lilly, webDesign, 8);
       time.attendStudentLesson(lilly, webDesign, 2);
       
       time.attendStudentLesson(james, webDesign, 1);
       time.attendStudentLesson(james, webDesign, 2);
       time.attendStudentLesson(james, webDesign, 6);
       time.attendStudentLesson(james, webDesign, 7);
       time.cancelStudentsLesson(james, webDesign, 3);
       time.cancelStudentsLesson(james, webDesign, 8);
       
       time.attendStudentLesson(katrin, webDesign, 1);
       time.attendStudentLesson(katrin, webDesign, 2);
       time.attendStudentLesson(katrin, webDesign, 3);
       time.attendStudentLesson(katrin, webDesign, 4);
       time.attendStudentLesson(katrin, webDesign, 5);
       time.attendStudentLesson(katrin, webDesign, 6);
       time.attendStudentLesson(katrin, webDesign, 7);
       time.attendStudentLesson(katrin, webDesign, 8);
       
       time.attendStudentLesson(steven, webDesign, 2);
       time.attendStudentLesson(steven, webDesign, 4);
       time.attendStudentLesson(steven, webDesign, 6);
       time.attendStudentLesson(steven, webDesign, 8);
       
       time.attendStudentLesson(nick, webDesign, 1);
       time.cancelStudentsLesson(nick, webDesign, 3);
       time.cancelStudentsLesson(nick, webDesign, 5);
       time.attendStudentLesson(nick, webDesign, 2);
       time.attendStudentLesson(nick, webDesign, 4);
       time.attendStudentLesson(nick, webDesign, 6);
       time.attendStudentLesson(nick, webDesign, 7);
       time.attendStudentLesson(nick, webDesign, 8);
     
      
       
      time.parentBookAppointment(Erna, officePicasso, 1, "14:00");
      time.parentBookAppointment(Haraldur, officePicasso, 2, "14:40");
      time.parentBookAppointment(Alexandra, officePicasso, 3, "14:00");
      time.parentBookAppointment(Mike, officePicasso, 4, "14:20");
      time.parentBookAppointment(harry, officePicasso, 5, "14:00");
      time.parentBookAppointment(stan, officePicasso, 5, "14:40");
      time.parentBookAppointment(Erna, officePicasso, 6, "14:00");
      time.parentBookAppointment(tony, officePicasso, 7, "14:20");
      time.parentBookAppointment(jamie, officePicasso, 8, "14:40");
      time.parentBookAppointment(elisa, officePicasso, 8, "14:20");
      
     officePicasso.BookAppointment(Erna);
     officePicasso.BookAppointment(Mike);
     officePicasso.BookAppointment(Alexandra);
     officePicasso.BookAppointment(Haraldur);
     officePicasso.BookAppointment(jamie);
     officePicasso.BookAppointment(harry);
     officePicasso.BookAppointment(stan);
     officePicasso.BookAppointment(tony);
     officePicasso.BookAppointment(elisa);
      
      time.parentBookAppointment(stan, officeDali, 1, "15:00");
      time.parentBookAppointment(rodney, officeDali, 1, "15:20");
      time.parentBookAppointment(elisa, officeDali, 3, "15:00");
      time.parentBookAppointment(homer, officeDali, 4, "15:20");
      time.parentBookAppointment(peter, officeDali, 4, "15:40");
      time.parentBookAppointment(harry, officeDali, 4, "15:00");
      time.parentBookAppointment(Erna, officeDali, 5, "15:00");
      time.parentBookAppointment(Haraldur, officeDali, 5, "15:40");
      time.parentBookAppointment(nina, officeDali, 6, "15:20");
      time.parentBookAppointment(alex, officeDali, 6, "15:00");
      time.parentBookAppointment(silvia, officeDali, 6, "15:40");
      time.parentBookAppointment(sonja, officeDali, 7, "15:40");
      time.parentBookAppointment(monika, officeDali, 8, "15:00");
      time.parentBookAppointment(steinun, officeDali, 8, "15:40");
      
     officePicasso.BookAppointment(Erna);
     officePicasso.BookAppointment(Mike);
     officePicasso.BookAppointment(Alexandra);
     officePicasso.BookAppointment(Haraldur);
     officePicasso.BookAppointment(jamie);
     officePicasso.BookAppointment(harry);
     officePicasso.BookAppointment(stan);
     officePicasso.BookAppointment(tony);
     officePicasso.BookAppointment(elisa);                                                                                                                                                                                                                                         

      time.parentBookAppointment(grayham, officeBarry, 1, "16:00");
      time.parentBookAppointment(fredo, officeBarry, 2, "16:00");
      time.parentBookAppointment(Erna, officeBarry, 2, "16:40");
      time.parentBookAppointment(Alexandra, officeBarry, 3, "16:20");
      time.parentBookAppointment(Haraldur, officeBarry, 4, "16:00");
      time.parentBookAppointment(harry, officeBarry, 4, "16:20");
      time.parentBookAppointment(stan, officeBarry, 4, "16:40");
      time.parentBookAppointment(Erna, officeBarry, 5, "16:20");
      time.parentBookAppointment(tony, officeBarry, 5, "16:40");
      time.parentBookAppointment(jamie, officeBarry, 6, "16:00");
      time.parentBookAppointment(noly, officeBarry, 8, "16:40");
      time.parentBookAppointment(homer, officeBarry, 8, "16:00");
      
      officeBarry.BookAppointment(Erna);
      officeBarry.BookAppointment(grayham);
      officeBarry.BookAppointment(fredo);
      officeBarry.BookAppointment(Alexandra);
      officeBarry.BookAppointment(Haraldur);
      officeBarry.BookAppointment(harry);
      officeBarry.BookAppointment(stan);
      officeBarry.BookAppointment(tony);
      officeBarry.BookAppointment(jamie);
      officeBarry.BookAppointment(noly);
      officeBarry.BookAppointment(homer);
     
      time.parentBookAppointment(peter, officeFrida, 1, "17:00");
      time.parentBookAppointment(harry, officeFrida, 1, "17:20");
      time.parentBookAppointment(Erna, officeFrida, 1, "17:40");
      time.parentBookAppointment(bobby, officeFrida, 2, "17:40");
      time.parentBookAppointment(Haraldur, officeFrida, 3, "17:20");
      time.parentBookAppointment(alex, officeFrida, 3, "17:40");
      time.parentBookAppointment(sonja, officeFrida, 5, "17:20");
      time.parentBookAppointment(monika, officeFrida, 6, "17:00");
      time.parentBookAppointment(homer, officeFrida, 7, "17:40");
      time.parentBookAppointment(steinun, officeFrida, 8, "17:00");
      time.parentBookAppointment(harry, officeFrida, 8, "17:20");
      
      officeFrida.BookAppointment(Erna);
      officeFrida.BookAppointment(peter);
      officeFrida.BookAppointment(harry);
      officeFrida.BookAppointment(bobby);
      officeFrida.BookAppointment(Haraldur);
      officeFrida.BookAppointment(alex);
      officeFrida.BookAppointment(sonja);
      officeFrida.BookAppointment(monika);
      officeFrida.BookAppointment(homer);
      officeFrida.BookAppointment(steinun);
      
      
      time.parentBookAppointment(harry, officeMonet, 1, "15:00");
      time.parentBookAppointment(stan, officeMonet, 1, "15:20");
      time.parentBookAppointment(rodney, officeMonet, 1, "15:40");
      time.parentBookAppointment(elisa, officeMonet, 2, "15:00");
      time.parentBookAppointment(homer, officeMonet, 2, "15:20");
      time.parentBookAppointment(Erna, officeMonet, 2, "15:40");
      time.parentBookAppointment(sonja, officeMonet, 3, "15:00");
      time.parentBookAppointment(Haraldur, officeMonet, 3, "15:20");
      time.parentBookAppointment(sofie, officeMonet, 3, "15:40");
      time.parentBookAppointment(monika, officeMonet, 4, "15:00");
      time.parentBookAppointment(steinun, officeMonet, 4, "15:20");
      time.parentBookAppointment(peter, officeMonet, 4, "15:40");
      time.parentBookAppointment(noly, officeMonet, 5, "15:00");
      time.parentBookAppointment(nina, officeMonet, 5, "15:20");
      time.parentBookAppointment(alex, officeMonet, 5, "15:40");
      time.parentBookAppointment(homer, officeMonet, 6, "15:20");
      time.parentBookAppointment(jamie, officeMonet, 7, "15:00");
      time.parentBookAppointment(tony, officeMonet, 8, "15:40");
     
      officeFrida.BookAppointment(Erna);
      officeFrida.BookAppointment(harry);
      officeFrida.BookAppointment(stan);
      officeFrida.BookAppointment(rodney);
      officeFrida.BookAppointment(elisa);
      officeFrida.BookAppointment(homer);
      officeFrida.BookAppointment(sonja);
      officeFrida.BookAppointment(Haraldur);
      officeFrida.BookAppointment(sofie);
      officeFrida.BookAppointment(monika);
      officeFrida.BookAppointment(steinun);
      officeFrida.BookAppointment(peter);
      officeFrida.BookAppointment(noly);
      officeFrida.BookAppointment(nina);
      officeFrida.BookAppointment(alex);
      officeFrida.BookAppointment(homer);
      officeFrida.BookAppointment(jamie);
      officeFrida.BookAppointment(tony);
              
      
     
     
     
     
   
    }
    
    /**
     *
     * @return
     */
    public TimeTableController getTimeTable(){
        return time;
    }
    
    /**
     *
     * @return
     */
    public SchoolDataBase getRegisteredLessons(){
        return registered;
    }
    
    
    
}
