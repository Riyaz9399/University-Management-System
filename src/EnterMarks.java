package src;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class EnterMarks extends JFrame implements ActionListener{

    JLabel nameField ;
    JTextField tfsub1,tfsub2,tfsub3 , tfsub4 , tfsub5 ,tfmarks1 ,tfmarks2 , tfmarks3 , tfmarks4 , tfmarks5  ;
    Choice CRollnum;
    @SuppressWarnings("rawtypes")
    JComboBox cbsemester;
    JButton submit , cancel;

    public EnterMarks(){

            ImageIcon i1 = new ImageIcon("C:\\Users\\saksh\\Desktop\\University Management System\\icons\\exam.jpg");
            Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(500,40,400,300);
            add(image);

            JLabel heading = new JLabel("Enter Marks For student:");
            heading.setBounds(50,0,500,50);
            heading.setFont(new Font("serif",Font.ITALIC,20));
            add(heading);
    

    
            JLabel RollNumber = new JLabel("Select Roll NUmber");  
            RollNumber.setBounds(50,70,150,20);
            add(RollNumber);
    
            //  Drop DOwm 
            CRollnum = new Choice();
            CRollnum.setBounds(200,70,150,20);
            add(CRollnum);
            //  Adding DRop Down Menu
                try{
                    DB db = new DB();
                    ResultSet rs = db.executeQuery("SELECT * FROM `student`");
                    while (rs.next()){
                      CRollnum.add(rs.getString("rollno"));
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }

                JLabel selectSemester = new JLabel("Select Semester");  
                selectSemester.setBounds(50,110,150,20);
                add(selectSemester);
    
                String semester[] = {"Semester 1st","Semester 2nd","Semester 3rd","Semester 4th","Semester 5th","Semester 6th","Semester 7th","Semester 8th"};
                cbsemester = new JComboBox<>(semester);
                cbsemester.setBounds(200,110,150,20);
                cbsemester.setBackground(Color.white);
                add(cbsemester);

                JLabel subject = new JLabel("Enter Subject");
                subject.setBounds(100,150,200,40);
                add(subject);

                JLabel marks = new JLabel("Enter Marks");
                marks.setBounds(320,150,200,40);
                add(marks);


                tfsub1 = new JTextField();
                tfsub1.setBounds(50, 200, 200, 20);
                add(tfsub1);
                
                tfsub2 = new JTextField();
                tfsub2.setBounds(50, 230, 200, 20);
                add(tfsub2);
                
                tfsub3 = new JTextField();
                tfsub3.setBounds(50, 260, 200, 20);
                add(tfsub3);
                
                tfsub4 = new JTextField();
                tfsub4.setBounds(50, 290, 200, 20);
                add(tfsub4);
                
                tfsub5 = new JTextField();
                tfsub5.setBounds(50, 320, 200, 20);
                add(tfsub5);
                
                tfmarks1 = new JTextField();
                tfmarks1.setBounds(250, 200, 200, 20);
                add(tfmarks1);
                
                tfmarks2 = new JTextField();
                tfmarks2.setBounds(250, 230, 200, 20);
                add(tfmarks2);
                
                tfmarks3 = new JTextField();
                tfmarks3.setBounds(250, 260, 200, 20);
                add(tfmarks3);
                
                tfmarks4 = new JTextField();
                tfmarks4.setBounds(250, 290, 200, 20);
                add(tfmarks4);
                
                tfmarks5 = new JTextField();
                tfmarks5.setBounds(250, 320, 200, 20);
                add(tfmarks5);

                submit = new JButton("Submit");
                submit.setBounds(70, 360, 150, 25);
                submit.setBackground(Color.BLACK);
                submit.setForeground(Color.WHITE);
                submit.addActionListener(this);
                submit.setFont(new Font("Tahoma", Font.BOLD, 15));
                add(submit);
                
                cancel = new JButton("Back");
                cancel.setBounds(280, 360, 150, 25);
                cancel.setBackground(Color.BLACK);
                cancel.setForeground(Color.WHITE);
                cancel.addActionListener(this);
                cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
                add(cancel);



        setVisible(true);
        setLayout(null);
        setSize(1000,600);
        setLocation(300,100);
        getContentPane().setBackground(Color.white);
    }


    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == submit){
            try{
                DB db = new DB();

                String query1  = "INSERT INTO `subjects`(`rollno`, `semester`, `subject1`, `subject2`, `subject3`, `subject4`, `subject5`) VALUES ('"+ CRollnum.getSelectedItem() +"','"+cbsemester.getSelectedItem()+"','"+tfsub1.getText()+"','"+tfsub2.getText()+"','"+tfsub3.getText()+"','"+tfsub4.getText()+"','"+tfsub5.getText()+"')";

                String query2  = "INSERT INTO `marks`(`rollno`, `semester`, `marks1`, `marks2`, `marks3`, `marks4`, `marks5`) VALUES ('"+ CRollnum.getSelectedItem() +"','"+cbsemester.getSelectedItem()+"','"+tfmarks1.getText()+"','"+tfmarks2.getText()+"','"+tfmarks3.getText()+"','"+tfmarks4.getText()+"','"+tfmarks5.getText()+"')";

                db.executeUpdate(query1);
                db.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "SUBJECTS AND MARKS INSERTED SUCCFULLY");
                setVisible(false);

            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == cancel){
            setVisible(false);
        }

    }
    public static void main(String args[]){
        new EnterMarks();
    }
}
