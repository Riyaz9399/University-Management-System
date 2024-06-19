package src;

import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class About extends JFrame implements ActionListener {

    JButton githubButton , linkdinButton , linkdiButton;
    
    public About(){

        ImageIcon i1 = new ImageIcon("C:\\Users\\saksh\\Desktop\\University Management System\\icons\\about.jpg");
        Image i2 = i1.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 300, 200);
        add(image);
        
        JLabel heading = new JLabel("<html>University<br/>Management System</html>");
        heading.setBounds(60, 20, 300, 130);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(heading);

        JLabel name = new JLabel("Developed By Sakshi kushwaha");
        name.setBounds(60,170,550,40);
        name.setFont(new Font("Serif",Font.BOLD,20));
        add(name);

        JTextArea textArea = new JTextArea();
        textArea.setText("Sakshi Kushwaha is an intermediate software developer with a focus on Java and web development. She excels in creating efficient applications and seamless user experiences. Known for her problem-solving abilities and continuous learning, Sakshi stays updated with the latest tech trends. Outside of work, she enjoys contributing to open-source projects and networking with professionals on GitHub and LinkedIn.");
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(40, 220, 600, 100);
        add(scrollPane);

        githubButton = new JButton("GitHub Profile");
        githubButton.setBounds(50, 330, 150, 30);
        githubButton.addActionListener(this);
        add(githubButton);

        linkdinButton = new JButton("Linkdin Profile");
        linkdinButton.setBounds(220, 330, 150, 30);
        linkdinButton.addActionListener(this);
        add(linkdinButton);

        linkdiButton = new JButton("Linkdin Profile 2");
        linkdiButton.setBounds(400, 330, 150, 30);
        linkdiButton.addActionListener(this);
        add(linkdiButton);

        


        


        setVisible(true);
        setSize(700,600);
        setLocation(400,150);
        setLayout(null);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == githubButton){
            openWebpage("https://github.com/Riyaz9399");
        }else if(ae.getSource() == linkdinButton){
            openWebpage("https://www.linkedin.com/in/sakshi-k-aa267725b/");
        }
    }

     private static void openWebpage(String urlString) {
        try {
            URI uri = new URI(urlString);
            Desktop desktop = Desktop.getDesktop();
            if (desktop.isSupported(Desktop.Action.BROWSE)) {
                desktop.browse(uri);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String [] args){
        new About();
    }
}
