
package src;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;


public class TeacherLeave extends JFrame implements ActionListener{

    Choice CemployeID , ctime;
    JDateChooser DCdate;
    JButton submit , cancel , rendom;
    DB db;
    

    public TeacherLeave(){

       JLabel heading = new JLabel("Apply Leave for Teacher");  
       heading.setFont(new Font("serif",Font.BOLD,20));
       heading.setBounds(40, 50, 300, 30);
       add(heading);


       
       JLabel LableEmploye = new JLabel("EMploye Id");  
       LableEmploye .setFont(new Font("serif",Font.PLAIN,20));
       LableEmploye .setBounds(60,100,200,20);
       add(LableEmploye );

        //  Drop DOwm dfghl

        CemployeID = new Choice();
        CemployeID.setBounds(60,130,200,20);
        add(CemployeID);
        //  Adding DRop Down Menu
            try{
                DB db = new DB();
                ResultSet rs = db.executeQuery("SELECT * FROM `teacher`");
                while (rs.next()){
                    CemployeID.add(rs.getString("employeid"));
                }
            }catch(Exception e){
                e.printStackTrace();
            }

            JLabel Date = new JLabel("DATE");
            Date.setBounds(60,180,200,20);
            Date.setFont(new Font("serif",Font.PLAIN,20));
            add(Date);

            DCdate = new JDateChooser();
            DCdate.setBounds(60,210,200,25);
            add(DCdate);

            JLabel lbltime = new JLabel("Time Duration");
            lbltime.setBounds(60, 260, 200, 20);
            lbltime.setFont(new Font("Tahoma", Font.PLAIN, 18));
            add(lbltime);
        
            ctime = new Choice();
            ctime.setBounds(60, 290, 200, 20);
            ctime.add("Full Day");
            ctime.add("Half Day");
            add(ctime);

            submit = new JButton("Submit");
            submit.setBounds(60, 350, 100, 25);
            submit.setBackground(Color.BLACK);
            submit.setForeground(Color.WHITE);
            submit.addActionListener(this);
            submit.setFont(new Font("Tahoma", Font.BOLD, 15));
            add(submit);
        
            cancel = new JButton("Cancel");
            cancel.setBounds(200, 350, 100, 25);
            cancel.setBackground(Color.BLACK);
            cancel.setForeground(Color.WHITE);
            cancel.addActionListener(this);
            cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
            add(cancel);

            rendom = new JButton("Cancel");
            rendom.setBounds(350, 350, 100, 25);
            rendom.setBackground(Color.BLACK);
            rendom.setForeground(Color.WHITE);
            rendom.addActionListener(this);
            rendom.setFont(new Font("Tahoma", Font.BOLD, 15));
            add(rendom);

        try {
            db = new DB(); // Initialize DB connection
            System.out.println("Connected to the database!"); // Optional: Print confirmation
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
        setSize(500,550);
        setLocation(550,100);
        setLayout(null);
        getContentPane().setBackground(Color.white);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String EmployeId = CemployeID.getSelectedItem();
            String date = ((JTextField) DCdate.getDateEditor().getUiComponent()).getText();
            String duration = ctime.getSelectedItem();

           
            try{ 
                String query = "INSERT INTO `teacherleave`(`employeid`, `date`, `duration`) VALUES ('"+ EmployeId +"','"+ date +"','"+ duration +"')";
                db.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "YOUR LEAVE IS CONFIRMED");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == cancel){
            setVisible(false);
        }

    }




    public static void main(String args[]){
        new TeacherLeave();
    }
}
