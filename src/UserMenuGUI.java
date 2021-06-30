
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author afaqs
 */
public class UserMenuGUI {
    JFrame frame,inputDate,QuitFrame,popupFrame;
    JPanel pan, pan1, menu;
    JLabel l1,l2,Heading,s1;
    User user;
    JButton Signout,enter;
    MenuView menu1;
    JTextField start_date, end_date;
    String sched_sd,sched_ed;
    User loggedInUser;
    UserMenuBtnHandler hnd;
    
    int Loc_X_Cor_Fr =0;
    int Loc_Y_Cor_Fr =10;
    int X_cor_Size =1170;
    int Y_cor_Size =723;
    
    public UserMenuGUI(User usr){
        loggedInUser = usr;
    initGUI();    
  }    

    public void initGUI() {
        frame = new JFrame();
        frame.setTitle("User Menu");
        frame.setLayout(null);
        
        hnd = new UserMenuBtnHandler(this);
        pan = new JPanel();
        pan.setLocation(0,0);
        pan.setSize(254,723);
        pan.setBackground(Color.BLACK);
        frame.add(pan);
        
        Signout = new JButton();
        Signout.setText("Sign Out");
        Signout.setBounds(0,10,100,30);
        Signout.setBackground(Color.red);
        Signout.setForeground(Color.WHITE);
        Signout.addActionListener(hnd);
        pan.add(Signout);
        
        pan1 = new JPanel();
        pan1.setBounds(254,0,1170-254,25);
        pan1.setBackground(Color.red);
        frame.add(pan1);
        
        
        s1 = new JLabel();
        s1.setForeground(Color.white);
        s1.setFont(new Font(Font.SERIF,Font.BOLD,15));
        s1.setText("Successfully Signed In");
        s1.setLocation(100,0);
        s1.setSize(100,15);
        pan1.add(s1);
        
        JLabel contentPane = new JLabel();
        contentPane.setIcon(new ImageIcon("Car2.png"));
        contentPane.setLayout(new BorderLayout());
        contentPane.setSize(254,673);
        contentPane.setLocation(0,0);
        pan.add(contentPane);
        
        String [][] menu = new String[2][3];
        menu [0][0]= "Book A Car";
        menu [0][1]= "Cancel Booking";
        menu [0][2]= "My Bookings";
        menu [1][0]= "Available Cars";
        menu [1][1]= "Update Booking";
        menu [1][2]= "Exit App";
        
        Size s = new Size();
        menu1 = new MenuView(menu,s);
        menu1.setBounds(254,25,900,683-25);
        frame.add(menu1);
        
         for(int i=0;i<s.rows;i++)
        {
          for(int j=0;j<s.cols;j++)
              menu1.buttons[i][j].addActionListener(hnd);
        }
         frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                ExitMessage();
            }
        });
        
        frame.setLocation(Loc_X_Cor_Fr,Loc_Y_Cor_Fr);
        frame.setSize(X_cor_Size, Y_cor_Size);  
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
    public void createAndDisplayInputDateFrame()
    {
       inputDate = new JFrame();
       inputDate.setTitle("Enter Booking Date");
       inputDate.setLayout(null);
       JPanel temppan= new JPanel();
       temppan.setBackground(Color.black);
       temppan.setLayout(null);
       temppan.setSize(600,250);
       temppan.setLocation(0,0);
       
       JLabel lab1 = new JLabel();
       lab1.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));
       lab1.setText("Enter Schedule Start Date: (fmt: yyyy-mm-dd)");
       lab1.setForeground(Color.red);
       lab1.setBackground(Color.red);
       lab1.setSize(350,25);
       lab1.setLocation(20,30);
       temppan.add(lab1);
       
       start_date = new JTextField();
       start_date.setBounds(350,30,200,25);
       temppan.add(start_date);
       
       JLabel lab2 = new JLabel();
       lab2.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));
       lab2.setForeground(Color.red);
       lab2.setText("Enter Schedule End Date: (fmt: yyyy-mm-dd)");
       lab2.setSize(350,40);
       lab2.setLocation(20,80);
       lab2.setBackground(Color.red);
       temppan.add(lab2);
       
       end_date = new JTextField();
       end_date.setBounds(350,80,200,25);
       temppan.add(end_date);
       
       enter = new JButton();
       enter.setText("Enter");
       enter.setLocation(200,130);
       enter.setBackground(Color.red);
       enter.setForeground(Color.white);
       enter.setSize(100,30);
       enter.addActionListener(hnd);
       inputDate.add(enter);
       
       enter.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        enter.setBackground(Color.cyan);
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        enter.setBackground(Color.RED);
    }
});
       
       inputDate.add(temppan);
       inputDate.setLocation(200,150);
       inputDate.setSize(600,250);
       inputDate.setVisible(true);
       inputDate.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void ExitMessage()
    {
        int fr_s_x=500,fr_s_y=150;
        int fr_l_x=400,fr_l_y=300;
        QuitFrame = new JFrame("Sign In:");
        QuitFrame.setTitle("Closing Application");
        QuitFrame.setIconImage(new ImageIcon("12.jpg").getImage());
        QuitFrame.setSize(fr_s_x,fr_s_y);
        QuitFrame.setLocation(fr_l_x,fr_l_y);
        QuitFrame.setLayout(null);
        QuitFrame.setBackground(Color.BLACK);
        JPanel pan2 = new JPanel();
        pan2.setLayout(null);
        pan2.setSize(fr_s_x, fr_s_y);
        pan2.setLocation(0,0);
        pan2.setBackground(Color.BLACK);
        
        JLabel msg = new JLabel("Are you sure you want to exit?",SwingConstants.CENTER);
        msg.setBackground(Color.BLACK);
        msg.setForeground(Color.red);
        msg.setFont(new Font("Arial", Font.PLAIN, 22));
        msg.setLocation(msg.getLocation().x,15);
        msg.setSize(500,30);
        
        JButton temp= new JButton();
        temp.setText("Yes");
        temp.setForeground(Color.WHITE);
        temp.setBackground(Color.red);
        temp.setLocation(100,70);
        temp.setSize(100,30);
        temp.addActionListener(hnd);
        
        JButton temp1= new JButton();
        temp1.setText("No");
        temp1.setForeground(Color.WHITE);
        temp1.setBackground(Color.red);
        temp1.setLocation(300,70);
        temp1.setSize(100,30);
        temp1.addActionListener(hnd);
        
        pan2.add(msg);
        pan2.add(temp);
        pan2.add(temp1);
        QuitFrame.add(pan2);
        QuitFrame.setVisible(true);
        QuitFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
     public void DisplayErrorMessage(String s)
    {
        int fr_s_x=500,fr_s_y=150;
        int fr_l_x=400,fr_l_y=300;
        popupFrame = new JFrame("Input Date Error");
        popupFrame.setIconImage(new ImageIcon("12.jpg").getImage());
        popupFrame.setSize(fr_s_x,fr_s_y);
        popupFrame.setLocation(fr_l_x,fr_l_y);
        popupFrame.setLayout(null);
        popupFrame.setBackground(Color.BLACK);
        JPanel pan = new JPanel();
        pan.setLayout(null);
        pan.setSize(fr_s_x, fr_s_y);
        pan.setLocation(0,0);
        pan.setBackground(Color.BLACK);
        
        JLabel msg = new JLabel(s,SwingConstants.CENTER);
        msg.setBackground(Color.BLACK);
        msg.setForeground(Color.red);
        msg.setFont(new Font("Arial", Font.PLAIN, 22));
        msg.setLocation(msg.getLocation().x,15);
        msg.setSize(500,30);
        
        JButton btn1= new JButton();
        btn1.setText("OK");
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.red);
        btn1.setLocation(200,70);
        btn1.setSize(100,30);
        btn1.addActionListener(hnd);
        
        pan.add(msg);
        pan.add(btn1);
        popupFrame.add(pan);
        popupFrame.setVisible(true);
        popupFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
