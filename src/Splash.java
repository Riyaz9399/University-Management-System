package src;
import java.awt.FlowLayout;
import java.awt.Image;
import javax.swing.*;

 class Splash extends JFrame implements Runnable{

    Thread t ;

    public Splash(){
        // Basic JFrame need to visiable and close 
        setVisible(true);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon i1 = new ImageIcon("C:\\Users\\saksh\\Desktop\\University Management System\\icons\\first.jpg"); 
        Image i2 = i1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        t = new Thread(this);
        t.start();
        
        int x = 1;
        for(int i = 2 ; i <= 600 ; i+=4 ,x+=1){
            setLocation(600 - ((i + x)/2) , 350 - (i/2) );
            setSize(i + 4*x , i  + x/2);

            try{
                Thread.sleep(10);
            }catch(Exception e){
                System.out.println(e);
            }
        }    
    }

       public void run(){
        try{
            Thread.sleep(7000);
            setVisible(false);

            //Next Frame
            new Login();
        }catch(Exception e){
            System.out.println(e);
        }
       }


    public static void main(String [] args){
        new Splash();
       
    }
    
 }