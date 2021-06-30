
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Afaq
 */
public class BookingPanel {
    JFrame reciept ;
    RoundedPanel r2;
    JLabel lable1, lable2,lable3,lable4,lable5,lable6,lable7,headerReciept;
    JLabel info1,info2,info3,info4,info5,info6,info7;
    JPanel picPanel;
    public BookingPanel(Booking bk,int x_axis,int y_axis,JPanel p) {
        initGUI(bk,x_axis,y_axis,p);
    }
    private void initGUI(Booking bk,int x_axis,int y_axis,JPanel p) {
        //To change body of generated methods, choose Tools | Templates
      reciept = new JFrame();
      reciept.setTitle("Reciept");
      reciept.setLayout(null);
      r2 = new RoundedPanel();
      r2.setLocation(x_axis,y_axis);
      r2.setSize(350,530);
      r2.setBackground(Color.BLACK);
      r2.setLayout(null);
     
      picPanel = new JPanel();
      picPanel.setSize(280,100);
      picPanel.setLayout(null);
      picPanel.setLocation(50,5);
      picPanel.setBackground(new Color(0,0,0,5));
      picPanel.setVisible(true);
      
      
      
      JLabel bg5 = new JLabel();
      bg5.setIcon(new ImageIcon("i01_Car.png"));
      bg5.setLayout(new BorderLayout());
      bg5.setSize(100, 50);
      bg5.setLocation(240, 20);
      r2.add(bg5);
      
      lable1 = new JLabel("Booking ID: ");
      lable1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
      lable1.setBounds(20, 100, 200, 15);
      lable1.setForeground(Color.WHITE);
      r2.add(lable1);
      
      info1 = new JLabel(String.valueOf(bk.getBook_id()));
      info1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
      info1.setBounds(220, 100, 200, 15);
      info1.setForeground(Color.WHITE);
      r2.add(info1);
      
      lable2 = new JLabel("Username: ");
      lable2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
      lable2.setBounds(20, 150, 200, 15);
      lable2.setForeground(Color.WHITE);
      r2.add(lable2);
      
      info2 = new JLabel(bk.getUsername());
      info2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
      info2.setBounds(220, 150, 200, 15);
      info2.setForeground(Color.WHITE);
      r2.add(info2);
      
      lable3 = new JLabel("CNIC: ");
      lable3.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
      lable3.setBounds(20, 200, 200, 15);
      lable3.setForeground(Color.WHITE);
      r2.add(lable3);
      
      info3 = new JLabel(bk.getUser_Cnic());
      info3.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
      info3.setBounds(220, 200, 200, 15);
      info3.setForeground(Color.WHITE);
      r2.add(info3);
      
      lable4 = new JLabel("Car RegdNo: ");
      lable4.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
      lable4.setBounds(20, 250, 200, 15);
      lable4.setForeground(Color.WHITE);
      r2.add(lable4);
      
      info4 = new JLabel(bk.getVehicleID());
      info4.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
      info4.setBounds(220, 250, 200, 15);
      info4.setForeground(Color.WHITE);
      r2.add(info4);
      
      lable5 = new JLabel("Booking Start Date: ");
      lable5.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
      lable5.setBounds(20, 300, 200, 15);
      lable5.setForeground(Color.WHITE);
      r2.add(lable5);
      
      info5 = new JLabel(bk.getSched_StartDate());
      info5.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
      info5.setBounds(220, 300, 200, 15);
      info5.setForeground(Color.WHITE);
      r2.add(info5);
      
      lable6 = new JLabel("Booking End Date: ");
      lable6.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
      lable6.setBounds(20, 350, 200, 15);
      lable6.setForeground(Color.WHITE);
      r2.add(lable6);
      
      info6 = new JLabel(bk.getSched_EndDate());
      info6.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
      info6.setBounds(220, 350, 200, 15);
      info6.setForeground(Color.WHITE);
      r2.add(info6);
      
      lable7 = new JLabel("Total Fare: ");
      lable7.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
      lable7.setBounds(20, 400, 200, 15);
      lable7.setForeground(Color.WHITE);
      r2.add(lable7);
      
      info7 = new JLabel(bk.getFare());
      info7.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
      info7.setBounds(220, 400, 200, 15);
      info7.setForeground(Color.WHITE);
      r2.add(info7);
      
      JLabel bg6 = new JLabel();
      bg6.setIcon(new ImageIcon("pic1.png"));
      bg6.setLayout(new BorderLayout());
      bg6.setSize(250, 90);
      bg6.setLocation(30, 430);
      r2.add(bg6);
      
      headerReciept = new JLabel("Booking Details: ");
      headerReciept.setFont(new Font("Times New Roman", Font.BOLD, 30));
      headerReciept.setBounds(10,15, 350, 40);
      headerReciept.setForeground(Color.RED);
      r2.add(headerReciept);
      
        r2.setVisible(true);
//      reciept.add(r2);
        p.add(r2);
      
//      JLabel backg1 = new JLabel();
//      backg1.setIcon(new ImageIcon("b1 (2).jpg"));
//      backg1.setLayout(new BorderLayout());
//      backg1.setSize(410,700);
//      backg1.setLocation(0, 0);
//      reciept.add(backg1);
//      
//      reciept.setLocation(200,30);
//      reciept.setSize(410,700);
//      reciept.setVisible(true);
    }
    public void setLocation(int x_axis,int y_axis)
    {
        r2.setLocation(x_axis,y_axis);
    }
}
