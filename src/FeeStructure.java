package src;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

public class FeeStructure extends JFrame{

    JTable table ;
   
    public FeeStructure(){


        JLabel heading = new JLabel("Fee Structure");
        heading.setBounds(50,10,400,30);
        heading.setFont(new Font("Serif",Font.BOLD,20));
        add(heading); 


        table = new JTable();
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(10,60,970,680);
        add(jsp);

        try {
            DB db = new DB();
            ResultSet rs = db.executeQuery("select * from fee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

       
        setSize(1000,700);
        setLayout(null);
        setLocation(300,100);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        
    }
    public static void main(String args[]){
        new FeeStructure();
    }
}
