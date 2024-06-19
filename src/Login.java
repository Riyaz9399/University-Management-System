package src;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.ResultSet;
import java.awt.event.*; 

public class Login extends JFrame implements ActionListener {

    JButton login , Cancel;
    JTextField username ;
    JPasswordField password;
    DB db;
    public  Login(){
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel  l1 = new JLabel("USERNAME");
        l1.setBounds(40,20,100,40);
        add(l1);

        username = new JTextField(20);
        username.setBounds(150,30,150,20);
        add(username);

        JLabel  l2 = new JLabel("PASSWORD");
        l2.setBounds(40,60,100,40);
        add(l2);

        password = new JPasswordField(20);
        password.setBounds(150,70,150,20);
        add(password);




        login = new JButton("Login");
        login.setBounds(40,140,100,30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.setFont(new Font("Tahoma" , Font.BOLD,15));
        add(login);
        login.addActionListener(this);

        Cancel = new JButton("Cancel");
        Cancel.setBounds(150,140,100,30);
        Cancel.setBackground(Color.black);
        Cancel.setForeground(Color.white);
        Cancel.setFont(new Font("Tahoma" , Font.BOLD,15));
        add(Cancel);
        Cancel.addActionListener(this);

        // 

        ImageIcon i1 = new ImageIcon("C:\\Users\\saksh\\Desktop\\University Management System\\icons\\second.jpg");
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,0,200,200);
        add(image);

        
        // setLayout(new FlowLayout());
        setSize( 600 , 300);
        setLocation(500 ,250);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            db = new DB(); // Initialize DB connection
            System.out.println("Connected to the database!"); // Optional: Print confirmation
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    ///abstract method overRide 
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == login){
           String userName = username.getText();
           String pass = String.valueOf(password.getPassword());
           String query =  "SELECT * FROM `login` WHERE `username` = '"+ userName+"' AND `password` = '"+pass + "'";
          
           

           try{
            
            ResultSet rs = db.executeQuery(query);
            if(rs.next()){
                setVisible(false);
                new Project();
            }else{
                JOptionPane.showMessageDialog(null, "Invalid username and password");
                setVisible(false);

            }

           }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
           }

        }else if(ae.getSource() == Cancel){
            setVisible(false);
        }
    }

    public static void main(String [] args){
        new Login();
    }
}
