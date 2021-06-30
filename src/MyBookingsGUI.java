
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Afaq
 */
public class MyBookingsGUI {
    JFrame frame; 
    JPanel pan1, pan2, pan3, pan4;
    RoundedPanel r, tempPan5;
    int move;
    JButton backbtn,next,previous;
    JTable jt;
    DefaultTableModel JTmodel;
    CarDAO Dao;
    BookingDAO bdao;
    JScrollPane sp;
    int booking_count;
    Booking []bookings;
    BookingPanel []bk_panels;
    MyBookingsBtnHandler hnd;
    JLabel head, heading,MovingTagline;
    JLabel label1, label2, label3, label4, label5, label6, label7, bg3;
    int Loc_X_Cor_Fr = 0;
    int Loc_Y_Cor_Fr = 10;
    int X_cor_Size = 1138;
    int Y_cor_Size = 735;
    UserMenuGUI userGUI;

    public MyBookingsGUI(UserMenuGUI refg) {
        userGUI = refg;
        Dao = new CarDAO();
        bdao = new BookingDAO();
        initGUI();
    }

    public void initGUI() {
        frame = new JFrame();
        frame.setLayout(null);
        hnd = new MyBookingsBtnHandler(this, userGUI);
        int x_pos=250;
        int y_pos =10;
        pan2 = new JPanel();
        pan2.setLocation(0, 0);
        pan2.setSize(200, 705);
        pan2.setBackground(Color.BLACK);
        pan2.setBorder(BorderFactory.createLineBorder(Color.red));
        frame.add(pan2);

        JLabel bg = new JLabel();
        bg.setIcon(new ImageIcon("Car3.jpg"));
        bg.setLayout(new BorderLayout());
        bg.setSize(254, 705);
        bg.setLocation(0, 0);
        pan2.add(bg);
        

        pan4 = new JPanel();
        pan4.setLocation(200, 0);
        pan4.setSize(920, 50);
        pan4.setBackground(Color.BLACK);
        frame.add(pan4);
        head = new JLabel("My Bookings");
        head.setLocation(920 / 2 - 20, 0);
        head.setFont(new Font("Helvetica Neue", Font.BOLD, 30));
        head.setForeground(Color.RED);
        pan4.add(head);

        
        pan1 = new JPanel();
        pan1.setLayout(new BorderLayout());
        pan1.setSize(920, 560);
        pan1.setLocation(200, 50);
        //pan1.setBackground(Color.BLUE);
        String u=userGUI.loggedInUser.getUsername();
//        System.out.println(u);
        booking_count = bdao.getBookingsCountofUser(u);
        bookings = bdao.getBookingsOfUser(u);
        bk_panels = new BookingPanel[booking_count];
        int inc=0;
        move =booking_count;
        for(int i=0;i<booking_count;i++)
        {
           bk_panels[i]= new BookingPanel(bookings[i], x_pos+inc, y_pos, pan1);
           inc +=380;
        }
        bg3 = new JLabel();
        bg3.setIcon(new ImageIcon("b1 (4).jpg"));
        bg3.setLayout(new BorderLayout());
        bg3.setSize(920, 560);
        bg3.setLocation(0, 0);
        bg3.setVisible(true);
        pan1.add(bg3);

        frame.add(pan1);

        pan3 = new JPanel();
        pan3.setLocation(200, 610);
        pan3.setSize(X_cor_Size - 215, Y_cor_Size - 650);
        pan3.setLayout(null);
        pan3.setBackground(Color.BLACK);

        previous = new JButton();
        previous.setText("Previous");
        previous.setBackground(Color.red);
        previous.setForeground(Color.white);
        previous.setBounds(520, 35, 120, 30);
        previous.addActionListener(hnd);
        pan3.add(previous);
        
        next = new JButton();
        next.setText("Next");
        next.setBackground(Color.red);
        next.setForeground(Color.white);
        next.setBounds(650, 35, 120, 30);
        next.addActionListener(hnd);
        pan3.add(next);
        
        backbtn = new JButton();
        backbtn.setText("Back");
        backbtn.setBackground(Color.red);
        backbtn.setForeground(Color.white);
        backbtn.setBounds(780, 35, 120, 30);
        backbtn.addActionListener(hnd);
        pan3.add(backbtn);

        JLabel backg = new JLabel();
        backg.setIcon(new ImageIcon("bg.png"));
        backg.setLayout(new BorderLayout());
        backg.setSize(X_cor_Size - 215, Y_cor_Size - 650);
        backg.setLocation(0, 0);
        pan3.add(backg);

        frame.add(pan3);
        frame.setLocation(Loc_X_Cor_Fr, Loc_Y_Cor_Fr);
        frame.setSize(X_cor_Size, Y_cor_Size);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
}
