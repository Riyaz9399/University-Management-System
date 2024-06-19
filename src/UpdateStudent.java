package src;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateStudent extends JFrame implements ActionListener{

    JTextField addressField ,phoneField  , emailField , AadharNumberField , Course , cbBranch, cbCource ;
    JLabel rollNumberJLabel , nameField , FathernameField , Labledob , classField , LableClassXIIField, AadharNumberLable;
   
    // JDateChooser DCDOB;
    // @SuppressWarnings("rawtypes")
    // JComboBox cbCource , cbBranch;
    Choice CRollnum;
    JButton submit , cancel;
    DB db;


     // Generate random Number
    Random ran = new Random();
    Long firstFour = Math.abs((ran.nextLong() % 9000L) + 1000L);

    public UpdateStudent(){


        setLayout(null);

        //heading 

        JLabel heading = new JLabel("Update Student Details:");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif",Font.ITALIC,30));
        add(heading);

        // Name Heading
        JLabel name = new JLabel("Name:");
        name.setBounds(50,150,200,30);
        name.setFont(new Font("serif",Font.BOLD,20));
        add(name);

        nameField = new JLabel();
        nameField.setBounds(200,150,150,30);
        nameField.setFont(new Font("serif",Font.PLAIN,18));
        add(nameField);


        JLabel RollNumber = new JLabel("Select Roll NUmber");  
        RollNumber.setFont(new Font("serif",Font.PLAIN,20));
        RollNumber.setBounds(50,100,200,20);
        add(RollNumber);

        //  Drop DOwm 
        CRollnum = new Choice();
        CRollnum.setBounds(250,100,200,20);
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


        // Name Text Area
       

        // Fathere Heading
        JLabel Fathername = new JLabel("Father name:");
        Fathername.setBounds(400,150,200,20);
        Fathername.setFont(new Font("serif",Font.BOLD,20));
        add(Fathername);


        // FAther TextArea 
        FathernameField = new JLabel();
        FathernameField.setBounds(600,150,150,30);
        FathernameField.setFont(new Font("serif",Font.PLAIN,18));
        add(FathernameField);

        // Roll Number Heading
        JLabel rollNumber = new JLabel("Roll Number:");
        rollNumber.setBounds(50,200,200,30);
        rollNumber.setFont(new Font("serif",Font.BOLD,20));
        add(rollNumber);

        // Roll number lable 
        rollNumberJLabel = new JLabel();
        rollNumberJLabel.setBounds(200,200,150,30);
        rollNumberJLabel.setFont(new Font("serif",Font.PLAIN,18));
        add(rollNumberJLabel);

        // DATE of birth
        JLabel DOB = new JLabel("DATE OF BIRTH:");
        DOB.setBounds(400,200,200,20);
        DOB.setFont(new Font("serif",Font.BOLD,20));
        add(DOB);

        Labledob = new JLabel();
        Labledob.setBounds(600,200,150,30);
        Labledob.setFont(new Font("serif",Font.PLAIN,18));
        add(Labledob);


        // Address Lable
        JLabel address = new JLabel("Address:");
        address.setBounds(50,250,200,30);
        address.setFont(new Font("serif",Font.BOLD,20));
        add(address);

        // AddressFeild
        addressField = new JTextField(20);
        addressField.setBounds(200,250,150,30);
        addressField.setFont(new Font("serif",Font.PLAIN,18));
        add(addressField);

        // Phone Lable
        JLabel phone = new JLabel("Phone No:");
        phone.setBounds(400,250,200,30);
        phone.setFont(new Font("serif",Font.BOLD,20));
        add(phone);

        phoneField = new JTextField(20);
        phoneField.setBounds(600,250,150,30);
        phoneField.setFont(new Font("serif",Font.PLAIN,18));
        add(phoneField);

        // Email lable 
        JLabel email = new JLabel(" Email:");
        email.setBounds(50,300,200,30);
        email.setFont(new Font("serif",Font.BOLD,20));
        add(email);

        emailField = new JTextField();
        emailField.setBounds(200,300,150,30);
        emailField.setFont(new Font("serif",Font.PLAIN,18));
        add(emailField);

        // Lable Class 10th percentage
        JLabel Class = new JLabel("Class X (%):");
        Class.setBounds(400,300,200,30);
        Class.setFont(new Font("serif",Font.BOLD,20));
        add(Class);

         classField = new JLabel();
        classField.setBounds(600,300,150,30);
        classField.setFont(new Font("serif",Font.PLAIN,18));
        add(classField);

        
        JLabel ClassXII = new JLabel("Class XII (%):");
        ClassXII.setBounds(50,350,200,30);
        ClassXII.setFont(new Font("serif",Font.BOLD,20));
        add(ClassXII);

        LableClassXIIField = new JLabel();
        LableClassXIIField.setBounds(200,350,150,30);
        LableClassXIIField.setFont(new Font("serif",Font.PLAIN,18));
        add(LableClassXIIField);

        JLabel AadharNumber = new JLabel("Aadhaar NO:");
        AadharNumber.setBounds(400,350,200,30);
        AadharNumber.setFont(new Font("serif",Font.BOLD,20));
        add(AadharNumber);

        AadharNumberLable = new JLabel();
        AadharNumberLable.setBounds(600,350,150,30);
        AadharNumberLable.setFont(new Font("serif",Font.PLAIN,18));
        add( AadharNumberLable);

        
        //  Cources Lable 
        JLabel Course = new JLabel("Courses");
        Course.setBounds(50,400,200,30);
        Course.setFont(new Font("serif",Font.PLAIN,20));
        add(Course);

     
        cbCource = new JTextField();
        cbCource.setBackground(Color.white);
        cbCource.setBounds(200,400,150,30);
        cbCource.setFont(new Font("serif",Font.PLAIN,18));
        add(cbCource);

        // Branch Lable 
        JLabel branch = new JLabel("BRANCH");
        branch.setBounds(400,400,200,30);
        branch.setFont(new Font("serif",Font.BOLD,20));
        add(branch);
        

        cbBranch = new JTextField();
        cbBranch.setBackground(Color.white);
        cbBranch.setBounds(600,400,150,30);
        cbBranch.setFont(new Font("serif",Font.PLAIN,18));
        add(cbBranch);

        try{
            DB db = new DB();
            String query = "SELECT * FROM `student` WHERE `rollno` = '" + CRollnum.getSelectedItem()+"'";
            ResultSet rs = db.executeQuery(query);
            while (rs.next()) {
                nameField.setText(rs.getString("name"));
                FathernameField.setText(rs.getString("fathername"));
                rollNumberJLabel.setText(rs.getString("rollno"));
                Labledob.setText(rs.getString("dob"));
                addressField.setText(rs.getString("address"));
                phoneField.setText(rs.getString("phone"));
                emailField.setText(rs.getString("email"));
                classField.setText(rs.getString("Class_X"));
                LableClassXIIField.setText(rs.getString("Class_XII"));
                cbCource.setText(rs.getString("Course"));
                cbBranch.setText(rs.getString("Branch"));
                AadharNumberLable.setText(rs.getString("aadhar"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        CRollnum.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie){
                try{
                    DB db = new DB();
                    String query = "SELECT * FROM `student` WHERE `rollno` = '" + CRollnum.getSelectedItem()+"'";
                    ResultSet rs = db.executeQuery(query);
                    while (rs.next()) {
                        nameField.setText(rs.getString("name"));
                        FathernameField.setText(rs.getString("fathername"));
                        rollNumberJLabel.setText(rs.getString("rollno"));
                        Labledob.setText(rs.getString("dob"));
                        addressField.setText(rs.getString("address"));
                        phoneField.setText(rs.getString("phone"));
                        emailField.setText(rs.getString("email"));
                        classField.setText(rs.getString("Class_X"));
                        LableClassXIIField.setText(rs.getString("Class_XII"));
                        cbCource.setText(rs.getString("Course"));
                        cbBranch.setText(rs.getString("Branch"));
                        AadharNumberLable.setText(rs.getString("aadhar"));
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    


        submit= new JButton("Update");
        submit.setBounds(250,500,120,30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setFont(new Font("serif" , Font.BOLD,18));
        submit.addActionListener(this);
        add( submit);
       

        cancel= new JButton("Cancle");
        cancel.setBounds(450,500,120,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("serif" , Font.BOLD,18));
        cancel.addActionListener(this);
        add( cancel);

        try {
            db = new DB(); // Initialize DB connection
            System.out.println("Connected to the database!"); // Optional: Print confirmation
        } catch (Exception e) {
            e.printStackTrace();
        }

        setSize(900,700);
        setLocation(350,50);
        setVisible(true);
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae){
         if(ae.getSource() == submit){
            
           
            String address = addressField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();
            String course =  cbCource.getText();
            String Branch =  cbBranch.getText();
            

            try{
                String query = "UPDATE `student` SET `address` = '"+ address + "',`phone`='" + phone + "', `email` =' " + email + "',`Course` = '" + course + "' , `Branch` = '" +Branch +"'";

                db.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"Student Data is Updated Succesfylly");
               setVisible(false);

            }catch(Exception e){
                e.printStackTrace();;
            }

         }else{
            setVisible(false);
        }

    }

   


    public static void main(String args[]){
        new UpdateStudent();
    }
}
