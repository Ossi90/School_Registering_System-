/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment1;
import TimeTable.*;
import com.assignment1.ActionListeners.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showInputDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author ornha
 */
// this is the UserInterface class that executes the program and GUI
public class UserInterface {
    /**
     * @param args the command line arguments
     */
    
    // This is the main method 
    public static void main (String[] args) {
    
    // Creates a new Thread by implementing the Runnable interface
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
     public void run() {
        
        UserInterface app = new UserInterface();
        
  
   
     }
    });
  }
        private Users parent;
        private Student student;
        private Tutors tutor;
        private JFrame frame = new JFrame("The Inspire Tuition Centre");
        private JPanel startUpCheckBoxPanel = new JPanel();
        private JScrollPane scroll;
        private JEditorPane editor;
        private JComboBox jComboTime = new JComboBox();
        private JComboBox jComboWeeks;
        private JComboBox jComboWeeks2;
        private JComboBox JComboLessons3;
        private JComboBox jComboLessons;
        private JComboBox jComboLessons2;
        private JComboBox jComboTutor;
        private JComboBox JComboOptions;
        private JComboBox jComboTutor2 = new JComboBox();
        private JButton buttonTutor = new JButton("Search");
        private JButton buttonLesson = new JButton("Search");
        private JButton buttonBook= new JButton(" Book   ");
        private JButton buttonOption;
        private HardCodedData data = new HardCodedData();
        private SchoolDataBase schoolData = data.getRegisteredLessons();
        private TimeTableController time = data.getTimeTable();
        
        
       // This is the constructor, which only responsibility is to set up the frame

        public UserInterface(){
        
            setUpFrame();
        }
        
        // This method sets up the start frame where users can login

    /**
     *
     */
        public void setUpFrame(){
        frame.getContentPane().removeAll();
        frame.revalidate();
        frame.repaint();
        frame.setLocationRelativeTo(null);
        JCheckBox jCheckBoxStudent = new JCheckBox("Student");
        JCheckBox jCheckBoxNewStudent = new JCheckBox("New Student");
        JCheckBox jCheckBoxparent = new JCheckBox("Parent");
        JCheckBox jCheckBoxtutor = new JCheckBox("Tutor");
        frame.add(startUpLabelJPanel(),BorderLayout.NORTH);
        frame.add(startUpCheckBoxJPanel(jCheckBoxparent,jCheckBoxStudent,jCheckBoxNewStudent,jCheckBoxtutor),BorderLayout.CENTER);
        frame.addWindowListener(new WindowExit());
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        JButton continue1 = new JButton("Continue");
        
        // check which user is using the system
        continue1.addActionListener((ActionEvent e) -> {
        if(jCheckBoxparent.isSelected()){
        parentGUI();
        }
        else if(jCheckBoxStudent.isSelected()){
        studentGUI();
        }
        else if(jCheckBoxNewStudent.isSelected()){
        newStudentGUI();
        }else if(jCheckBoxtutor.isSelected()){
        tutorGUI();
        }});
        continue1.setBackground(Color.LIGHT_GRAY);
        frame.add(continue1,BorderLayout.SOUTH);
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);        
      }
        
       
        
        
// This is the Tutors GUI
        public void tutorGUI(){
        
            
        // Checks if ID is valid
        try{String tempID = JOptionPane.showInputDialog(null,"Please Enter Your Tutor ID","Welcome Tutor", JOptionPane.QUESTION_MESSAGE);
        int ID  = Integer.parseInt(tempID);
        if(schoolData.getTutorByID(ID)!= null){
        
        tutor = schoolData.getTutorByID(ID);
        // Sets up Tutors GUI
        resturcureFrame();
        tutorMenuBar();
        
        // adds basic info about the tutorGUI to the GUI
        JPanel infoPanel = basicInfo(tutor);
        JScrollPane scroller = new JScrollPane(infoPanel);
        frame.add(scroller ,BorderLayout.CENTER);
        
        
        }else{
        // pop up if ID is not found
        JOptionPane.showMessageDialog (null, "There is no tutor registerd under this ID","Error",JOptionPane.ERROR_MESSAGE);
                 }
        }catch(java.lang.NumberFormatException e){
        // pop up if ID is not valid     
        JOptionPane.showMessageDialog (null, "Please enter a valid ID","Error",JOptionPane.ERROR_MESSAGE);
                    }
        }
        
        // this is the Students GUI for both new and registered students
        

        public void studentGUI(){
        
        // Checks if ID is valid    
        try{String tempID = JOptionPane.showInputDialog(null,"Please Enter Your Student ID","Welcome Student", JOptionPane.QUESTION_MESSAGE);
        int ID  = Integer.parseInt(tempID);
        
        if(schoolData.getStudentByID(ID)!= null){
        student = schoolData.getStudentByID(ID);
        
        // Sets up the students GUY
        resturcureFrame();
        studentMenuBar();
        
        frame.add(studentSearchPanel(buttonTutor,buttonLesson,buttonBook),BorderLayout.NORTH);
        
        JPanel infoPanel = basicInfo(student);
        JScrollPane scroller = new JScrollPane(infoPanel);
        frame.add(scroller ,BorderLayout.CENTER);
        
        //Action Listeners for buttons
        buttonTutor.addActionListener(new StudentFindTutor(jComboTutor,time,editor,schoolData));
        buttonLesson.addActionListener(new StudentFindLessons(jComboLessons,schoolData,editor));
        buttonBook.addActionListener(new StudentBookLesson (student,jComboLessons2,editor,infoPanel,frame,time));
        buttonOption.addActionListener(new StudentOptionListener(student,JComboOptions, jComboWeeks2,JComboLessons3,editor,infoPanel,frame,time));
        }else{
             // pop up ef studentGUI ID is not found
        JOptionPane.showMessageDialog (null, "There is no student registerd under this ID","Error",JOptionPane.ERROR_MESSAGE);
                 }
        
        }catch(java.lang.NumberFormatException e){
            // pop up if ID is not valid
        JOptionPane.showMessageDialog (null, "Please enter a valid ID","Error",JOptionPane.ERROR_MESSAGE);
                   }
        }
        
        
        // this method allows new students to register and greates a popup with input fields

        public void newStudentGUI(){
            
        // Creates text fields    
        JTextField name = new JTextField(15);
        JTextField address = new JTextField(15);
        JTextField telephone= new JTextField(15);
        
        // creates Panels
        JPanel info = new JPanel();
        JPanel namePanel = new JPanel();
        JPanel addressPanel = new JPanel();
        JPanel telephonePanel = new JPanel();
        
        // adds inputs fields to their panels 
        info.add(new JLabel("Please Enter Your Information In The Fields Below"));
        
        namePanel.add(new JLabel("Name:"));
        namePanel.add(name);
        
        addressPanel.add(new JLabel("Address:"));
        addressPanel.add(address);
        
        telephonePanel.add(new JLabel("Phone:"));
        telephonePanel.add(telephone);
        
        JPanel registerPanel = new JPanel();
        
        // adds all panels into one panel
        registerPanel.setLayout (new BoxLayout ( registerPanel, BoxLayout.Y_AXIS));
        registerPanel.add(info);
        registerPanel.add(namePanel);
        registerPanel.add(addressPanel);
        registerPanel.add(telephonePanel);
        
        // creates space between fields
        registerPanel.add(Box.createHorizontalStrut(35)); // a spacer
        
        // pop up for registering
        int result = JOptionPane.showConfirmDialog(null, registerPanel,
        "Please Enter Your Information", JOptionPane.OK_CANCEL_OPTION);
        
        // if new students click OK on the popup, all information gets sent to the factory
        if(result ==0){
        
        // Creating new Student object
        UserFactory factory = new UserFactory();
        OrderUser system = new OrderUser(factory);
        int tel = Integer.parseInt(telephone.getText());
        student = (Student)system.orderUser("student", name.getText(), address.getText(), tel);
        
        // promting new studentGUI with his/her ID
        JOptionPane.showMessageDialog (null,
        "Your Student ID is:" + student.getID()+"\n"+ "Please Remember It",
        "Your ID",
        JOptionPane.INFORMATION_MESSAGE);
        
        // calls the studentGUI GUI method
        studentGUI();
                  }
        }
        
        
        // This is the parentGUI GUI

        public void parentGUI(){
        String name = "";
        UserFactory factory = new UserFactory();
        OrderUser system = new OrderUser(factory);
        
        //Pop up asking the Parent name
        name = showInputDialog(null,"Please Enter your name","Welcome New Parent!", JOptionPane.QUESTION_MESSAGE);
        
        // checking if name is valid
        if( name == null|| name.isEmpty()){
        // if name is not valid then the method get called again    
        parentGUI();
        }else{
        // orders a new parentGUI object from the factory    
        parent = system.orderUser("Parent", name);
        
        // sets up the parentGUI GUI
        resturcureFrame();
        parentMenuBar();
        
        // adds basic infor about the parentGUI
        JPanel infoPanel = parentAppointments(name);
        JScrollPane scroller = new JScrollPane(infoPanel);
        frame.add(ParentSearchPanel(buttonTutor,buttonLesson,buttonBook),BorderLayout.NORTH);
        frame.add(scroller ,BorderLayout.CENTER);
        
        // action listeners for the buttons
        buttonTutor.addActionListener(new ParentsFindAppointmentTutor(parent,jComboTutor,time,editor));
        buttonLesson.addActionListener(new ParentsFindLessonListener(parent,jComboLessons,time,editor));
        buttonBook.addActionListener(new ParentsBookListener(jComboTutor2, jComboTime,jComboWeeks,time,editor,parent,infoPanel,frame)); 
                }
        
        }
        
        

    /**
     *
     * @param name
     * @return
     */// This method adds information about what appointment the parentGUI has 
        public JPanel parentAppointments(String name){
        JPanel panel = new JPanel();
        panel.setLayout (new BoxLayout (panel, BoxLayout.Y_AXIS));
        JLabel welcome = new JLabel("Welcome "+ name);
        JLabel appointments = new JLabel("your Appointments:");
        panel.add(welcome);
        panel.add(appointments);
        panel.add(new JLabel("------------------------"));
        return panel;
        }
        
        

    /**
     *
     * @param user
     * @return
     */// this method adds basic info about users and adds it to the GUI
        public JPanel basicInfo(Users user){
        JPanel panel = new JPanel();
        panel.setLayout (new BoxLayout (panel, BoxLayout.Y_AXIS));
        JLabel name = new JLabel("Name: "+ user.getName());
        JLabel ID = new JLabel("ID: "+ user.getID());
        JLabel address = new JLabel("Address: "+ user.getAddress());
        JLabel telephone= new JLabel("Phone: "+ user.getTelephoneNumber());
        JLabel lessons = new JLabel("My "+"Lessons:");
        Set <Lessons> lesson = user.getMyLessonsSet();
        
        panel.add(name);
        panel.add(ID);
        panel.add(address);
        panel.add(telephone);
        panel.add(new JLabel("------------------------"));
        panel.add(new JLabel("                   "));
        panel.add(lessons);
        
        lesson.stream().map((l) -> {
        panel.add(new JLabel("------------------------"));
        panel.add(new JLabel("   "+l.getName())).setForeground(Color.BLUE);
        return l;
        }).map((l) -> {
        panel.add(new JLabel("   "+l.getTutor().getName())).setForeground(Color.BLUE);
        return l;
        }).map((l) -> {
        panel.add(new JLabel("   "+l.getTime())).setForeground(Color.BLUE);
        return l;
        }).map((l) -> {
        panel.add(new JLabel("   "+l.getDay().toString())).setForeground(Color.BLUE);
        return l;
        }).map((l) -> {
        panel.add(new JLabel("   "+l.getPlace())).setForeground(Color.BLUE);
        return l;
        }).forEachOrdered((_item) -> {
        panel.add(new JLabel("------------------------"));
        });
        if(user instanceof Tutors){
            tutorOfficeHourBasicInfo(user, panel);
        }
        
        panel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
     
        
        return panel;
        }
        
        public void tutorOfficeHourBasicInfo(Users user,JPanel panel){
            OfficeHours oh = user.getMyOfficeHours();
             panel.add(new JLabel("                     "));
             panel.add(new JLabel("                     "));
             panel.add(new JLabel("My "+"OfficeHours:"));
             List<String> list = oh.getTimeSlots();
             panel.add(new JLabel("------------------------"));
             panel.add(new JLabel(oh.getDay().toString()+"S")).setForeground(Color.BLUE);
             panel.add(new JLabel("  Time slots: "));
             for(String time: list){
                 panel.add(new JLabel("  "+time)).setForeground(Color.BLUE);
                }
        }
            
        
        
        

    /**
     *
     * @param tutorButton
     * @param lessonButton
     * @param book
     * @return
     */// This method creates the serch GUI for the Parent
        public JPanel ParentSearchPanel(JButton tutorButton, JButton lessonButton,JButton book){
         
       
        String[][] comboOptions = JComboBoxOptions(); //gets a sting of options    
        JPanel comboPanel= new JPanel ();
        comboPanel.setLayout (new BoxLayout (comboPanel, BoxLayout.Y_AXIS));
        GroupLayout layout = new GroupLayout(comboPanel);
        
        // creating three different Panel to be used for searching and booking
        JPanel bookPanel = new JPanel();
        JPanel comboPanelLessons= new JPanel ();
        JPanel comboPanelTutors= new JPanel ();
        
        // sets the layout for the panels
        comboPanelLessons.setLayout (new BoxLayout (comboPanelLessons, BoxLayout.X_AXIS));
        comboPanelTutors.setLayout (new BoxLayout (comboPanelTutors, BoxLayout.X_AXIS));
        bookPanel.setLayout (new BoxLayout (bookPanel, BoxLayout.X_AXIS));
        
        //Creats a drop down menu list for parents to choose lessons or tutors from
        jComboTime = new JComboBox<>(comboOptions[3]);
        jComboWeeks= new JComboBox<>(comboOptions[2]);
        jComboLessons = new JComboBox<>(comboOptions[0]);
        jComboTutor = new JComboBox<>(comboOptions[1]);
        jComboTutor2 = new JComboBox<>(comboOptions[1]);
        
        tutorButton= new JButton("Search");
        lessonButton = new JButton("Search");
        
        // adds panels togheter
        bookPanel.add(book);
        bookPanel.add(jComboTutor2);
        bookPanel.add(jComboWeeks);
        bookPanel.add(jComboTime);
        comboPanelTutors.add(buttonTutor);
        comboPanelTutors.add(jComboTutor );
        comboPanelLessons.add(buttonLesson);
        comboPanelLessons.add(jComboLessons);
        
        
        // sets layout for the search GUI
        setNorthLayout(layout, comboPanelTutors, comboPanelLessons,bookPanel);
        
        return  comboPanel;
        }
        
        
       

    /**
     *
     * @param tutorButton
     * @param lessonButton
     * @param book
     * @return
     */ // This method creates the search GUI for Students 
        public JPanel studentSearchPanel(JButton tutorButton, JButton lessonButton, JButton book){
        String[][] comboOptions = JComboBoxOptions();  //gets a sting of options  
        
        JPanel comboPanel= new JPanel ();
        comboPanel.setLayout (new BoxLayout (comboPanel, BoxLayout.Y_AXIS));
        GroupLayout layout = new GroupLayout(comboPanel);
        
         // creating three different Panel to be used for searching and booking
        JPanel actionPanel = new JPanel();
        JPanel bookPanel = new JPanel();
        JPanel comboPanelLessons= new JPanel ();
        JPanel comboPanelTutors= new JPanel ();
        
          // sets the layout for the panels
        comboPanelLessons.setLayout (new BoxLayout (comboPanelLessons, BoxLayout.X_AXIS));
        comboPanelTutors.setLayout (new BoxLayout (comboPanelTutors, BoxLayout.X_AXIS));
        actionPanel.setLayout (new BoxLayout (actionPanel, BoxLayout.X_AXIS));
        bookPanel.setLayout (new BoxLayout (bookPanel, BoxLayout.X_AXIS));
        
        //Creats a drop down menu list for parents to choose lessons or tutors from
        jComboWeeks2= new JComboBox<>(comboOptions[2]);
        jComboLessons = new JComboBox<>(comboOptions[0]);
        jComboLessons2 = new JComboBox<>(comboOptions[0]);
        JComboLessons3 = new JComboBox<>(comboOptions[0]);
        jComboTutor = new JComboBox<>(comboOptions[1]);
        JComboOptions = new JComboBox<>(comboOptions[4]);
        
        
        tutorButton= new JButton("Search");
        lessonButton = new JButton("Search");
        buttonOption = new JButton("Confirm");
        
        // add all panels togheter
        bookPanel.add(book);
        bookPanel.add(jComboLessons2);
        actionPanel.add(buttonOption);
        actionPanel.add(JComboOptions);
        actionPanel.add(JComboLessons3);
        actionPanel.add(jComboWeeks2);
        comboPanelTutors.add(buttonTutor);
        comboPanelTutors.add(jComboTutor );
        comboPanelLessons.add(buttonLesson);
        comboPanelLessons.add(jComboLessons);
        
        // sets layout for the search GUI
        setNorthLayout(layout, comboPanelTutors, comboPanelLessons,actionPanel,bookPanel);
        return  comboPanel;
        }
        
        

    /**
     *
     * @param layout
     * @param comboPanelTutors
     * @param comboPanelLessons
     * @param actionPanel
     */// sets a smooth layout for the Search GUI
        public void setNorthLayout(GroupLayout layout,JPanel comboPanelTutors,JPanel comboPanelLessons,JPanel actionPanel ){
        layout.setVerticalGroup(
        layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        .addComponent(comboPanelTutors)
        .addComponent(comboPanelLessons)
        .addComponent(actionPanel)
        ));
        
        }
        

    /**
     *
     * @param layout
     * @param comboPanelTutors
     * @param comboPanelLessons
     * @param actionPanel
     * @param bookPanel
     */// overloaded 
        public void setNorthLayout(GroupLayout layout,JPanel comboPanelTutors,JPanel comboPanelLessons,JPanel actionPanel, JPanel bookPanel ){
        layout.setVerticalGroup(
        layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        .addComponent(comboPanelTutors)
        .addComponent(comboPanelLessons)
        .addComponent(actionPanel)
        .addComponent(bookPanel)));
        
        }
        
        

    /**
     *
     * @return
     */// returns a 2D string with options
        public String[][] JComboBoxOptions(){
        String[] Lessons ={"Lessons","English","Math","French","Programming","Science","Database","User Experience","Spanish","History","Web Design"};
        String[] tutorsArray = {"Tutors","Pablo Picasso","Salvador Dali","Barry McGee","Frida Kahlo","Claude Monet"};
        String[] weeks = {"Week","1","2","3","4","5","6","7","8"};
        String[] time = {"Time","14:00","14:20","14:40","15:00","15:20", "15:40","16:00","16:20", "16:40","17:00","17:20", "17:40"};
        String[] options= {"Options","Change Lesson","Cancel Lesson","Attend Lesson","Quit Lesson"};
        String[][] comoboOptions= {Lessons,tutorsArray,weeks,time,options};
        return comoboOptions;
        }
        
// restrucst a basic frame for parentGUI, studentGUI and tutorGUI GUI
        public void resturcureFrame(){
        frame.setSize(800,800);
        frame.getContentPane().removeAll();
        frame.repaint();
        frame.setLocationRelativeTo(null);
        editor = new JEditorPane();
        editor.setSize(400, 300);
        scroll = new JScrollPane(editor);
        scroll.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        frame.add(scroll,BorderLayout.EAST);
    
        }
       

   // creates a menu bar for Student
        public void studentMenuBar(){
        JMenuBar mb = new JMenuBar ();
        frame.setJMenuBar (mb);
        JMenu back = new JMenu("Logout");
        JMenu report = new JMenu("Report");
        JMenu firstFour= new JMenu("First Four Weeks");
        JMenu secondFour= new JMenu("Second Four Weeks");
        mb.add(back);
        mb.add(report);
        report.add(firstFour);
        report.add(secondFour);
        studentReportMenu(firstFour,secondFour);
        menuBack(mb,back);
        }
        
        // creates a menu bar for Tutors

    /**
     *
     */
        public void tutorMenuBar(){
        JMenuBar mb = new JMenuBar ();
        frame.setJMenuBar (mb);
        JMenu back = new JMenu("Logout");
        JMenu report = new JMenu("Report");
        JMenu firstFour= new JMenu("First Four Weeks");
        JMenu secondFour= new JMenu("Second Four Weeks");
        mb.add(back);
        mb.add(report);
        report.add(firstFour);
        report.add(secondFour);
        tutorReportMenu(firstFour,secondFour);
        menuBack(mb,back);
        }
        
        // creates a menu bar for parents

        public void parentMenuBar(){
        JMenuBar mb = new JMenuBar ();
        frame.setJMenuBar (mb);
        JMenu back = new JMenu("Logout");
        mb.add(back);
        menuBack(mb,back); 
        }
        
        
       

    /**
     *
     * @param firstFour
     * @param secondFour
     */ // adds actions listeners to students menu bar
        public void studentReportMenu(JMenu firstFour, JMenu secondFour){
        
        Week firstWeeks =time.getFirstTerm();
        Week secondWeeks =time.getSecondTerm();
        
        firstFour.add( new JMenuItem(new AbstractAction("Student Report") {
        public void actionPerformed(ActionEvent e) {
        
        editor.setText(firstWeeks.studentReport(student));
                     }
                 }
        ));
        
        secondFour.add( new JMenuItem(new AbstractAction("Student Report") {
        public void actionPerformed(ActionEvent e) {
        editor.setText(secondWeeks.studentReport(student)); 
                    }
                }
            ));
        }
        
        
       

    /**
     *
     * @param firstFour
     * @param secondFour
     */ // adds actions listeners to tutors menu bar
        public void tutorReportMenu(JMenu firstFour, JMenu secondFour){
        Week firstWeeks =time.getFirstTerm();
        Week secondWeeks =time.getSecondTerm();
        
        firstFour.add( new JMenuItem(new AbstractAction("Tutors Report") {
        public void actionPerformed(ActionEvent e) {
        editor.setText(firstWeeks.tutorReport(tutor));     
                          }
                      }
        ));
        
        secondFour.add( new JMenuItem(new AbstractAction("Tutors Report") {
        public void actionPerformed(ActionEvent e) {
        editor.setText(secondWeeks.tutorReport(tutor));
                    }
                 }
              ));
        
        }
        
        
        

    /**
     *
     * @param bar
     * @param back
     */// creates go back menu in the menu bar
        public void menuBack(JMenuBar bar,JMenu back){
        back.add( new JMenuItem(new AbstractAction("Logout") {
        public void actionPerformed(ActionEvent e) {
         int logout = JOptionPane.showConfirmDialog(null, "Do you want to logout?"); 
         
         if(logout == 0){
        frame.getContentPane().removeAll();
        bar.removeAll();
        startUpCheckBoxPanel.removeAll();
        setUpFrame(); }
                          }   
                  }
        ));
        
     }
        
       

    /**
     *
     * @param parent
     * @param student
     * @param newStudent
     * @param tutor
     * @return
     */ // creats a check box for user to login
        public JPanel startUpCheckBoxJPanel(JCheckBox parent,JCheckBox student,JCheckBox newStudent,JCheckBox tutor){
        ButtonGroup group = new ButtonGroup();
        group.add(parent);
        group.add(student);
        group.add(newStudent);
        group.add(tutor);
        startUpCheckBoxPanel.setLayout (new BoxLayout (startUpCheckBoxPanel, BoxLayout.X_AXIS));
        startUpCheckBoxPanel.setLayout(new GridBagLayout());
        startUpCheckBoxPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        startUpCheckBoxPanel.add(student);
        startUpCheckBoxPanel.add(newStudent);
        startUpCheckBoxPanel.add(parent);
        startUpCheckBoxPanel.add(tutor);
        return startUpCheckBoxPanel;
        }
        
       

    /**
     *
     * @return
     */ // creates a Panel for the first startup frame
        public JPanel startUpLabelJPanel(){
        JPanel startUpLabel1 = new JPanel();
        JPanel startUpLabel2 = new JPanel();
        JPanel startUpLabel1and2 = new JPanel();
        JLabel startLabel1 = new JLabel("Welcome to The Inspire Tuition Centre.",SwingConstants.CENTER);
        JLabel startLabel2 = new JLabel("Please select one of the following:", CENTER);
        startUpLabel1.add(startLabel1);
        startUpLabel2.add(startLabel2);
        startUpLabel1and2.setLayout(new GridBagLayout());
        startUpLabel1and2.setLayout (new BoxLayout (startUpLabel1and2, BoxLayout.Y_AXIS));
        startUpLabel1and2.setBackground(Color.LIGHT_GRAY);
        startUpLabel1and2.add(startUpLabel1);
        startUpLabel1and2.add(startUpLabel2);
        
        return startUpLabel1and2;
        }
       
   }