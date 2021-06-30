
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author afaqs
 */
public class MenuView extends JPanel{
    JButton[][] buttons;
    JLabel [][] Icons;
    JLabel [][] labels;
    RoundedPanel [][] r;
    int rows =2;
    int cols =3;
    
    public MenuView(String[][] s,Size size){
       initGUI(s,size);
    }

    public void initGUI(String [][] s,Size size) {
        
        size.rows= rows;
        size.cols = cols;
        this.setSize(900,683-25);
        this.setLayout(new GridLayout(2,3));
        this.setBackground(Color.BLACK);
        
        buttons = new JButton[rows][cols];
        Icons = new JLabel[rows][cols];
        labels = new JLabel[rows][cols];
        r = new RoundedPanel[rows][cols];
        //Resources Initialization
         for (int i=0; i < rows; i++) {
              for (int j=0; j < cols; j++) {
                       buttons[i][j] = new JButton();
                       Icons[i][j]= new JLabel();
                       labels[i][j]= new JLabel();
                       r[i][j] = new RoundedPanel();
              }
        }
        
         
        //Resources Size and Background
        for (int i=0; i < rows; i++) {
              for (int j=0; j < cols; j++) {
                       buttons[i][j].setBackground(Color.BLACK);
                       buttons[i][j].setSize(300,330);
                       buttons[i][j].setText(s[i][j]);
                       labels[i][j].setForeground(Color.WHITE);
                       labels[i][j].setFont(new Font("Verdana",Font.BOLD,25));
                       labels[i][j].setLocation(20,150);
                       labels[i][j].setSize(250,30);
                       if (s[i][j]=="Add A Car")  {
                           labels[i][j].setLocation(60,150);
                       }
                       else if (s[i][j]=="Calculate Revenue")  {
                           labels[i][j].setLocation(10,150);
                           labels[i][j].setFont(new Font("Verdana",Font.BOLD,22));
                       }
                       else if (s[i][j]=="Book A Car")  {
                           labels[i][j].setLocation(40,150);
                       }
                       else if (s[i][j]=="My Bookings")  {
                           labels[i][j].setLocation(40,150);
                       }
                       else if (s[i][j]=="Exit App")  {
                           labels[i][j].setLocation(60,150);
                       }
                       labels[i][j].setText(s[i][j]);
                       r[i][j].setBounds(150,10,205,35);
                       r[i][j].add(labels[i][j]);
                       r[i][j].setBackground(Color.black); 
                       r[i][j].setOpaque(false);
                       r[i][j].setLayout(null);
       
                       Icons[i][j].setSize(300,330);
                       Icons[i][j].setBackground(Color.BLACK);
                       Icons[i][j].setLocation(0,0);
                       Icons[i][j].setIcon(new ImageIcon("g1.jpg"));
                       Icons[i][j].setLayout(new BorderLayout());
                       
                       
                       buttons[i][j].add(r[i][j]);
                       r[i][j].add(Icons[i][j]);
                       
                       this.add(buttons[i][j]);
                       
              }
        } 
       //return rows*10+cols;   
    }
}