package src;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddTeacher extends JFrame implements ActionListener{

    JTextField nameField ,FathernameField,addressField ,phoneField , emailField , classField ,  ClassXIIField , AadharNumberField;
    JLabel EmployeIdLable;
    JDateChooser DCDOB;
    @SuppressWarnings("rawtypes")
    JComboBox cbCource , cbBranch;
    JButton submit , cancel;
    DB db;


     // Generate random Number
    Random ran = new Random();
    Long firstFour = Math.abs((ran.nextLong() % 9000L) + 1000L);

    public AddTeacher(){


        setLayout(null);

        //heading 

        JLabel heading = new JLabel("New Teachers Details:");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);

        // Name Heading
        JLabel name = new JLabel("Name:");
        name.setBounds(50,150,200,30);
        name.setFont(new Font("serif",Font.BOLD,20));
        add(name);

        // Name Text Area
        nameField = new JTextField(20);
        nameField.setBounds(200,150,150,30);
        add(nameField);

        // Fathere Heading
        JLabel Fathername = new JLabel("Father name:");
        Fathername.setBounds(400,150,200,20);
        Fathername.setFont(new Font("serif",Font.BOLD,20));
        add(Fathername);


        // FAther TextArea 
        FathernameField = new JTextField(20);
        FathernameField.setBounds(600,150,150,30);
        add(FathernameField);

        // Roll Number Heading
        JLabel EmployeId = new JLabel("Employe Id :");
        EmployeId.setBounds(50,200,200,30);
        EmployeId.setFont(new Font("serif",Font.BOLD,20));
        add(EmployeId);

        // Roll number lable 
        EmployeIdLable = new JLabel("1533" + firstFour);
        EmployeIdLable.setBounds(200,200,150,30);
        EmployeIdLable.setFont(new Font("serif",Font.BOLD,20));
        add(EmployeIdLable);

        // DATE of birth
        JLabel DOB = new JLabel("DATE OF BIRTH:");
        DOB.setBounds(400,200,200,20);
        DOB.setFont(new Font("serif",Font.BOLD,20));
        add(DOB);

        DCDOB = new JDateChooser();
        DCDOB.setBounds(600,200,150,30);
        add(DCDOB);


        // Address Lable
        JLabel address = new JLabel("Address:");
        address.setBounds(50,250,200,30);
        address.setFont(new Font("serif",Font.BOLD,20));
        add(address);

        // AddressFeild
        addressField = new JTextField(20);
        addressField.setBounds(200,250,150,30);
        add(addressField);

        // Phone Lable
        JLabel phone = new JLabel("Phone No:");
        phone.setBounds(400,250,200,30);
        phone.setFont(new Font("serif",Font.BOLD,20));
        add(phone);

        phoneField = new JTextField(20);
        phoneField.setBounds(600,250,150,30);
        add(phoneField);

        // Email lable 
        JLabel email = new JLabel(" Email:");
        email.setBounds(50,300,200,30);
        email.setFont(new Font("serif",Font.BOLD,20));
        add(email);

        emailField = new JTextField(20);
        emailField.setBounds(200,300,150,30);
        add(emailField);

        // Lable Class 10th percentage
        JLabel Class = new JLabel("Class X (%):");
        Class.setBounds(400,300,200,30);
        Class.setFont(new Font("serif",Font.BOLD,20));
        add(Class);

        classField = new JTextField(20);
        classField.setBounds(600,300,150,30);
        add(classField);

        
        JLabel ClassXII = new JLabel("Class XII (%):");
        ClassXII.setBounds(50,350,200,30);
        ClassXII.setFont(new Font("serif",Font.BOLD,20));
        add(ClassXII);

        ClassXIIField = new JTextField(20);
        ClassXIIField.setBounds(200,350,150,30);
        add(ClassXIIField);

        JLabel AadharNumber = new JLabel("Aadhaar NO:");
        AadharNumber.setBounds(400,350,200,30);
        AadharNumber.setFont(new Font("serif",Font.BOLD,20));
        add(AadharNumber);

        AadharNumberField = new JTextField(20);
        AadharNumberField.setBounds(600,350,150,30);
        add( AadharNumberField);

        
        //  Cources Lable 
        JLabel Course = new JLabel("Education");
        Course.setBounds(50,400,200,30);
        Course.setFont(new Font("serif",Font.BOLD,20));
        add(Course);

        //  Drop Down  for Cources
        String courseArr[] = {"B.Tech","BCA","B.Com","MCA","MBA","BBA","MA" ,"BA" ,"BSC.IT" ,"M.Tech" ,"CA" ,"M.Com", "Humanities","Arts" ,"BSC"};
        cbCource = new JComboBox<>(courseArr);
        cbCource.setBackground(Color.white);
        cbCource.setBounds(200,400,150,30);
        add(cbCource);

        // Branch Lable 
        JLabel branch = new JLabel("Department");
        branch.setBounds(400,400,200,30);
        branch.setFont(new Font("serif",Font.BOLD,20));
        add(branch);

        // DropDowm for the Branch
        String branchArr[] = {"Computer Science" ,"Electronics" ,"Civil","IT"};
        cbBranch = new JComboBox<>(branchArr);
        cbBranch.setBackground(Color.white);
        cbBranch.setBounds(600,400,150,30);
        add(cbBranch);


        submit= new JButton("Add");
        submit.setBounds(250,550,120,30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Tahoma" , Font.BOLD,15));
        submit.addActionListener(this);
        add( submit);
       

        cancel= new JButton("Cancle");
        cancel.setBounds(450,550,120,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Tahoma" , Font.BOLD,15));
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
            String nameTxt = nameField.getText();
            String fatherTxt = FathernameField.getText();
            String employeID = EmployeIdLable.getText();
            String dob = ( (JTextField) DCDOB.getDateEditor().getUiComponent()).getText();
            String address = addressField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();
            String X = classField.getText();
            String XII = ClassXIIField.getText();
            String Education = (String) cbCource.getSelectedItem();
            String Depart = (String) cbBranch.getSelectedItem();
            String Aadhar = AadharNumberField.getText();


            try{
                String query = "INSERT INTO `teacher`(`name`, `fathername`, `employeId`, `dob`, `address`, `phone`, `email`, `classX`, `classXII`, `aadhar`, `Education`, `Department`) VALUES ('"+ nameTxt +"','"+ fatherTxt +"','"+ employeID +"','"+ dob +"','"+ address +"','"+ phone +"','"+ email +"','"+ X +"','"+ XII +"','"+ Aadhar +"','"+ Education +"','"+ Depart +"')";

                db.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"Student Data is Inserted Succesfylly");
               setVisible(false );
              

            }catch(Exception e){
                e.printStackTrace();;
            }

        }else{
            setVisible(false);
        }

    }

   


    public static void main(String args[]){
        new AddStudent();
    }
}
