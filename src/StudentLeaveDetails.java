package src;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.DbUtils;



public class StudentLeaveDetails extends JFrame implements ActionListener {

    Choice CRollnum ;
    JTable Jtable;
    JButton search , print ,  update , add , cancle;

    public StudentLeaveDetails(){

       JLabel heading = new JLabel("Search By Roll NUmber");  
       heading.setFont(new Font("serif",Font.BOLD,20));
       heading.setBounds(20,20,150,20);
       add(heading);

        //  Drop DOwm 
        CRollnum = new Choice();
        CRollnum.setBounds(180,20,150,20);
        add(CRollnum);
        //  Adding DRop Down Menu
            try{
                DB db = new DB();
                ResultSet rs = db.executeQuery("SELECT * FROM `studentleave`");
                while (rs.next()){
                  CRollnum.add(rs.getString("rollno"));
                }
            }catch(Exception e){
                e.printStackTrace();
            }


            //  Creating Table 

            Jtable = new JTable();
            JScrollPane jsp = new JScrollPane(Jtable);
            jsp.setBounds(10,100,970,600);
            add(jsp);

            // Add table Value

            try{
                DB db = new DB();
                ResultSet rs = db.executeQuery("SELECT * FROM `studentleave`");
                Jtable.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
            }

            search = new JButton("SEARCH");
            search.setBounds(20,70,90,25);
            search.addActionListener(this);
            add(search);

            print = new JButton("PRINT");
            print.setBounds(120,70,90,25);
            print.addActionListener(this);
            add( print);

            cancle = new JButton("CANCLE");
            cancle.setBounds(220,70,90,25);
            cancle.addActionListener(this);
            add(cancle);





        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);
        setSize(1000,700);
        setLocation(300,100);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == search){
            String query = "SELECT * FROM `studentleave` WHERE `rollno` = '" + CRollnum.getSelectedItem()+ "'";
            try{
                DB db = new DB();
                ResultSet rs = db.executeQuery(query); 
                Jtable.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
            }

        }else if(ae.getSource() == print){
            try{
                Jtable.print();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == cancle){
            setVisible(false);
        }
    }

   public static void main(String args[]){
    new StudentLeaveDetails();
   } 
}
