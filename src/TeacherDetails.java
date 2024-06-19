package src;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;



public class TeacherDetails extends JFrame implements ActionListener {

    Choice cEmpId ;
    JTable Jtable;
    JButton search , print ,  update , add , cancle;

    public TeacherDetails(){

       JLabel heading = new JLabel("Search By Employe ID");  
       heading.setFont(new Font("serif",Font.BOLD,20));
       heading.setBounds(20,20,150,20);
       add(heading);

        //  Drop DOwm 
        cEmpId = new Choice();
        cEmpId.setBounds(180,20,150,20);
        add(cEmpId);
        //  Adding DRop Down Menu
            try{
                DB db = new DB();
                ResultSet rs = db.executeQuery("SELECT * FROM `teacher`");
                while (rs.next()){
                    cEmpId.add(rs.getString("employeId"));
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
                ResultSet rs = db.executeQuery("SELECT * FROM `teacher`");
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

            update = new JButton("UPDATE");
            update.setBounds(220,70,90,25);
            update.addActionListener(this);
            add(update);

            add = new JButton("ADD");
            add.setBounds(320,70,90,25);
            add.addActionListener(this);
            add(add);

            cancle = new JButton("CANCLE");
            cancle.setBounds(420,70,90,25);
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
            String query = "SELECT * FROM `teacher` WHERE `employeId` = '" + cEmpId.getSelectedItem()+ "'";
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
        }else if(ae.getSource() == add){
            setVisible(false);
            new AddTeacher();
        }else if(ae.getSource() == update){
            new UpdateTeachers();
        }else if(ae.getSource() == cancle){
            setVisible(false);
        }
    }

   public static void main(String args[]){
    new TeacherDetails();
   } 
}
