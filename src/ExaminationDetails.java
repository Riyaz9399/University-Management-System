package src;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

public class ExaminationDetails extends JFrame implements ActionListener{

    JTextField search ;
    JButton submit , cancel;
    JTable  table ;

    public ExaminationDetails(){

       getContentPane().setBackground(Color.WHITE);

       JLabel heading = new JLabel("Check Result");  
       heading.setFont(new Font("serif",Font.BOLD,20));
       heading.setBounds(80,15,150,20);
       add(heading);

       search = new JTextField();
       search.setBounds(80,90,200,30);
       add(search);


        submit = new JButton("Result");
        submit.setBounds(300, 90, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);
        
        cancel = new JButton("Back");
        cancel.setBounds(440, 90, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        table = new JTable();
        table.setFont(new Font("Tohoma",Font.PLAIN,16));

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(10,130,970,310);
        add(jsp);

        try{
            DB db = new DB();
            String query = "SELECT * from `student`";
            ResultSet rs = db.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
            

        }catch(Exception e){
            e.printStackTrace();
        }

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me){
                int row = table.getSelectedRow();
                search.setText((String) table.getModel().getValueAt(row, 2));

            }
        });
       
        setSize(1000,475);
        setLocation(300,100);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            setVisible(false);
            new Marks(search.getText());
           

        }else if(ae.getSource() == cancel){
            setVisible(true);
        }
    }
    
    public static void main(String args []){
        new ExaminationDetails();
    }
}
