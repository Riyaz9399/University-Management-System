package src;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class Project extends JFrame implements ActionListener{

        public Project(){
            setSize(1540,850);
            setLocation(0,50);

            ImageIcon i1 = new ImageIcon("C:\\Users\\saksh\\Desktop\\University Management System\\icons\\third.jpg");
            Image i2 = i1.getImage().getScaledInstance(1540, 740, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            add(image);

            JMenuBar mb = new JMenuBar();

            // New information
            JMenu newInforamtion = new JMenu("NEW INFORMATION");
            newInforamtion.setForeground(Color.BLUE);
            mb.add(newInforamtion);
            
            JMenuItem facultyInfo = new JMenuItem("New faculty information");
            facultyInfo.setBackground(Color.white);
            facultyInfo.addActionListener(this);
            newInforamtion.add(facultyInfo);

            JMenuItem StudentInfo = new JMenuItem("New student inforamtion");
            StudentInfo.setBackground(Color.white);
            StudentInfo.addActionListener(this);
            newInforamtion.add(StudentInfo);

            // Detils 
            JMenu viewDeatils = new JMenu("VIEW DETAILS");
            viewDeatils.setForeground(Color.RED);
            mb.add(viewDeatils);

            JMenuItem Viewfaculty = new JMenuItem("View faculty");
            Viewfaculty.setBackground(Color.white);
            Viewfaculty.addActionListener(this);
            viewDeatils.add(Viewfaculty);

            JMenuItem ViewStudent = new JMenuItem("View Student");
            ViewStudent.setBackground(Color.white);
            ViewStudent.addActionListener(this);
            viewDeatils.add(ViewStudent);

            // Leave
            JMenu leave = new JMenu("Apply Leave");
            leave.setForeground(Color.BLACK);
            mb.add(leave);
            
            JMenuItem facultyleave = new JMenuItem("Faculty Leave");
            facultyleave.addActionListener(this);
            facultyleave.setBackground(Color.WHITE);
            leave.add(facultyleave);
            
            JMenuItem studentleave = new JMenuItem("Student Leave");
            studentleave.addActionListener(this);
            studentleave.setBackground(Color.WHITE);
            leave.add(studentleave);

            //Leave Deatils 

            JMenu leaveDetail = new JMenu("Leave Details");
            leaveDetail.setForeground(Color.BLUE);
            mb.add(leaveDetail);
            
            JMenuItem facultyleavedetails = new JMenuItem("Faculty Leave Details");
            facultyleavedetails.setBackground(Color.WHITE);
            facultyleavedetails.addActionListener(this);
            leaveDetail.add(facultyleavedetails);
            
            JMenuItem studentleavesetails = new JMenuItem("Student Leave Details");
            studentleavesetails.setBackground(Color.WHITE);
            studentleavesetails.addActionListener(this);
            leaveDetail.add(studentleavesetails);


            // Examination
            JMenu Examination = new JMenu("Examination");
            Examination.setForeground(Color.RED);
            mb.add(Examination);
            
            JMenuItem examinationDetails = new JMenuItem("Examination Details");
            examinationDetails.setBackground(Color.WHITE);
            examinationDetails.addActionListener(this);
            Examination.add(examinationDetails);

            JMenuItem enterMarks = new JMenuItem("Enter Marks");
            enterMarks.setBackground(Color.white);
            enterMarks.addActionListener(this);
            Examination.add(enterMarks);

            // Update Info 

            JMenu updateInfo = new JMenu("Update Details");
            updateInfo.setForeground(Color.BLACK);
            mb.add(updateInfo);

            JMenuItem updatefacultyinfo = new JMenuItem("Update facutly Info");
            updatefacultyinfo.setBackground(Color.WHITE);
            updatefacultyinfo.addActionListener(this);
            updateInfo.add(updatefacultyinfo);

            JMenuItem updateStudentinfo = new JMenuItem("Update student Info");
            updateStudentinfo.setBackground(Color.WHITE);
            updateStudentinfo.addActionListener(this);
            updateInfo.add(updateStudentinfo);

            // fee

            JMenu fee = new JMenu("fee Details");
            fee.setForeground(Color.BLUE);
            mb.add(fee);

            JMenuItem feeStructure = new JMenuItem("Fee Structure");
            feeStructure.setBackground(Color.WHITE);
            feeStructure.addActionListener(this);
            fee.add(feeStructure);

            JMenuItem feeForm = new JMenuItem("Student fee Form");
            feeForm.setBackground(Color.WHITE);
            feeForm.addActionListener(this);
            fee.add(feeForm);
        
        
            // utilities

            JMenu utility = new JMenu("Utility");
            utility.setForeground(Color.RED);
            mb.add(utility);
            
            JMenuItem notepad = new JMenuItem("Notepad");
            notepad.setBackground(Color.WHITE);
            notepad.addActionListener(this);
            utility.add(notepad);
            
            JMenuItem calc = new JMenuItem("Calculator");
            calc.addActionListener(this);
            calc.setBackground(Color.WHITE);
            utility.add(calc);

            //About 

            JMenu about = new JMenu("About");
            about.setForeground(Color.BLACK);
            mb.add(about);
            
            JMenuItem ab = new JMenuItem("About");
            ab.setBackground(Color.WHITE);
            ab.addActionListener(this);
            about.add(ab);
            
             // exit
             JMenu exit = new JMenu("Exit");
             exit.setForeground(Color.BLUE);
             mb.add(exit);
             
             JMenuItem ex = new JMenuItem("Exit");
             ex.setBackground(Color.WHITE);
                ex.addActionListener(this);
             exit.add(ex);
        
            setJMenuBar(mb); // End of the Main Menu bar

            
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new FlowLayout());
            setVisible(true);
        }

        public void actionPerformed(ActionEvent ex){
           String message = ex.getActionCommand();
            if(message.equals("Exit") ){
                setVisible(false);
            }else if(message.equals("Calculator")){
                try{
                    Runtime.getRuntime().exec("calc");
                }catch(Exception e){
                    System.out.println(e);

                }
            }
            else if(message.equals("Notepad")){
                try {
                    Runtime.getRuntime().exec("Notepad");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if(message.equals("New faculty information")){
                new AddTeacher();
                
            } else if(message.equals("New student inforamtion")){
                new AddStudent();
            }else if(message.equals("View faculty")){
                new TeacherDetails();
            }else if(message.equals("View Student")){
                new StudentDetails();
            }else if(message.equals("Faculty Leave")){
                new TeacherLeave();
            }else if(message.equals("Student Leave")){
                new StudentLeave();
            }else if(message.equals("Faculty Leave Details")){
                new TeachersLeaveDetails();
            }else if(message.equals("Student Leave Details")){
                new StudentLeaveDetails();
            }else if(message.equals("Examination Details")){
                new ExaminationDetails();
            }else if(message.equals("Update facutly Info")){
                new UpdateTeachers();
            }else if(message.equals("Update student Info")){
                new UpdateStudent();
            }else if(message.equals("Fee Structure")){
                new FeeStructure();
            }else if(message.equals("Student fee Form")){
                new StudentFeeForm();
            }else if(message.equals("Enter Marks")){
                new EnterMarks();
            }else if(message.equals("About")){
                new About();
            }
        }


    public static void main(String [] args){
        new Project();
    }

    
}
