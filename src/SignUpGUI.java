
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
public class SignUpGUI {
    //GUI components
    JFrame frame,SignUpError,adminConfirm,QuitFrame;
    JPanel signIn;
    JLabel l1,l2,l3,l4,l5,Heading,s1;
    JTextField username,CNICfield,phField;
    JPasswordField password,pass;
    SignUpBtnHandler hnd;
    JCheckBox usercheckBox1,usercheckBox2,gender1,gender2;
    Font f;
    JButton btn,btn1;
    UserDAO DAO;
    String AdminConfirmation= "admin123";
    User user;
    //Size and location of frame
    int Loc_X_Cor_Fr =0;
    int Loc_Y_Cor_Fr =10;
    int X_cor_Size =1000;
    int Y_cor_Size =683;
    
    public SignUpGUI(){
     DAO = new UserDAO();
    initGUI();    
  }    
public void initGUI() {
        frame=new JFrame();
        frame.setTitle("Rent_A_Car_SignUp");
        frame.setLayout(null);
        
        hnd = new SignUpBtnHandler(this);
        
        signIn = new JPanel() {
            //  For transparent Curved Border of JPanel
        protected void paintComponent(Graphics g) {
           super.paintComponent(g);
           Dimension arcs = new Dimension(15,15);
           int width = getWidth();
           int height = getHeight();
           Graphics2D graphics = (Graphics2D) g;
           graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //Draws the rounded opaque panel with borders.
          graphics.setColor(getBackground());
          graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint background
          graphics.setColor(getForeground());
          graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint border
     }
  };
        signIn.setOpaque(false);
        signIn.setBounds(30,140,350,500);
        signIn.setLayout(null);
        signIn.setBackground(Color.BLACK);
        
        f = new Font(Font.SERIF,Font.BOLD,40);
        Heading = new JLabel();
        Heading.setText("Sign Up");
        Heading.setFont(f);
        Heading.setForeground(Color.red);
        Heading.setBounds(110,10,150,47);
        signIn.add(Heading);
        
       
        l1 = new JLabel();
        l1.setText("User Name");
        l1.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 15));
        l1.setBounds(30, 100, 200,15);
        //l1.setLocation(30,300);
        //l1.setSize(200,15);
        l1.setForeground(Color.RED);
        signIn.add(l1);
        
        username = new JTextField();
        username.setBounds(120, 100,200,25);
        signIn.add(username);
        
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                username.requestFocus();
            }
            @Override
            public void windowClosing(WindowEvent e) {
                frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                ExitMessage();
            }
        });
        
        l2 = new JLabel();
        l2.setText("Password");
        l2.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 15));
        l2.setBounds(30, 150, 200,15);
        l2.setForeground(Color.RED);
        signIn.add(l2);
        
        password = new JPasswordField();
        password.setBounds(120, 150,200,25);
        signIn.add(password);
        
        l3 = new JLabel();
        l3.setText("CNIC No.");
        l3.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 15));
        l3.setBounds(30, 200, 200,15);
        l3.setForeground(Color.RED);
        signIn.add(l3);
        
        CNICfield = new JTextField();
        CNICfield.setBounds(120, 200,200,25);
        signIn.add(CNICfield);
        
        l4 = new JLabel();
        l4.setText("Gender.");
        l4.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 15));
        l4.setBounds(30, 250, 200,15);
        l4.setForeground(Color.RED);
        signIn.add(l4);
        
        gender1 =new JCheckBox("Male");
        gender1.setBounds(130,243,100,30);
        gender1.setBackground(Color.BLACK);
        gender1.setForeground(Color.red);
        signIn.add(gender1);
        
        gender2 = new JCheckBox("Female");
        gender2.setBounds(230,243,100,30);
        gender2.setBackground(Color.BLACK);
        gender2.setForeground(Color.red);
        signIn.add(gender2);
        
        l4 = new JLabel();
        l4.setText("Phone No.");
        l4.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 15));
        l4.setBounds(30, 300, 200,15);
        l4.setForeground(Color.RED);
        signIn.add(l4);
        
        phField = new JTextField();
        phField.setBounds(120,300,200,25);
        signIn.add(phField);
        
        usercheckBox1 =new JCheckBox("As Admin");
        usercheckBox1.setBounds(20,350,100,30);
        usercheckBox1.setBackground(Color.BLACK);
        usercheckBox1.setForeground(Color.red);
        signIn.add(usercheckBox1);
        
        usercheckBox2 = new JCheckBox("As Normal User");
        usercheckBox2.setBounds(150, 350,130,30);
        usercheckBox2.setBackground(Color.BLACK);
        usercheckBox2.setForeground(Color.red);
        signIn.add(usercheckBox2);
 
        btn = new JButton();
        btn.setText("Sign Up");
        btn.setBounds(20,400,300,30);
        btn.setBackground(Color.RED);
        btn.setForeground(Color.WHITE);
        signIn.add(btn);
        btn.addActionListener(hnd);
        
        s1 = new JLabel();
        s1.setText("Do you already have an Account?");
        s1.setForeground(Color.red);
        s1.setBounds(20, 450,200,20);
        signIn.add(s1);
        
        btn1 = new JButton();
        btn1.setText("Sign In");
        btn1.setBounds(210,450,110,30);
        btn1.setBackground(Color.RED);
        btn1.setForeground(Color.WHITE);
        signIn.add(btn1);
        
        btn1.addActionListener(hnd);
        
        frame.add(signIn);
        JLabel contentPane = new JLabel();
        contentPane.setIcon(new ImageIcon("car_title.jpg"));
        contentPane.setLayout(new BorderLayout());
        contentPane.setSize(X_cor_Size,Y_cor_Size);
        contentPane.setLocation(0,0);
        frame.add(contentPane);
        
        
        //frame.add(signIn);
        frame.setLocation(Loc_X_Cor_Fr,Loc_Y_Cor_Fr);
        frame.setSize(X_cor_Size, Y_cor_Size);  
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
    }    
    public void DisplayErrorMessage(String s)
    {
        int fr_s_x=500,fr_s_y=150;
        int fr_l_x=400,fr_l_y=300;
        SignUpError = new JFrame("Sign Up ERROR");
        SignUpError.setIconImage(new ImageIcon("12.jpg").getImage());
        SignUpError.setSize(fr_s_x,fr_s_y);
        SignUpError.setLocation(fr_l_x,fr_l_y);
        SignUpError.setLayout(null);
        SignUpError.setBackground(Color.BLACK);
        JPanel pan = new JPanel();
        pan.setLayout(null);
        pan.setSize(fr_s_x, fr_s_y);
        pan.setLocation(0,0);
        pan.setBackground(Color.BLACK);
        
        JLabel msg = new JLabel(s);
        msg.setBackground(Color.BLACK);
        msg.setForeground(Color.red);
        msg.setFont(new Font("Arial", Font.PLAIN, 22));
        msg.setLocation(50,20);
        msg.setSize(500,30);
        
        JButton btn= new JButton();
        btn.setText("OK");
        btn.setForeground(Color.WHITE);
        btn.setBackground(Color.red);
        btn.setLocation(200,70);
        btn.setSize(100,30);
        btn.addActionListener(hnd);
        
        pan.add(msg);
        pan.add(btn);
        SignUpError.add(pan);
        SignUpError.setVisible(true);
    }
    public void AdminConfirmation()
    {
        int fr_s_x=500,fr_s_y=150;
        int fr_l_x=400,fr_l_y=300;
        adminConfirm = new JFrame("Admin Confirmation");
        adminConfirm.setIconImage(new ImageIcon("12.jpg").getImage());
        adminConfirm.setSize(fr_s_x,fr_s_y);
        adminConfirm.setLocation(fr_l_x,fr_l_y);
        adminConfirm.setLayout(null);
        adminConfirm.setBackground(Color.BLACK);
        JPanel pan = new JPanel();
        pan.setLayout(null);
        pan.setSize(fr_s_x, fr_s_y);
        pan.setLocation(0,0);
        pan.setBackground(Color.BLACK);
        adminConfirm.add(pan);
        JLabel statement = new JLabel("Enter the Admin Confirmation Password:");
        statement.setForeground(Color.red);
        statement.setLocation(10,20);
        statement.setSize(250,30);
        pan.add(statement);
        
        pass = new JPasswordField();
        pass.setBounds(250,20,220,30);
        pan.add(pass);
        
       JButton jb = new JButton();
       jb.setBackground(Color.red);
       jb.setForeground(Color.white);
       jb.setText("Verify");
       jb.setBounds(170, 70, 200, 30);
       jb.addActionListener(hnd);
       pan.add(jb);
       
 
       adminConfirm.setVisible(true);
    }
     void fillUser()
    {
        user = new User();
        user.setUsername(username.getText());
        user.setPassword(password.getText());
        user.setCNIC(CNICfield.getText());
        user.setPhno(phField.getText());
        if(gender1.isSelected())
               user.setGender("Male");
        else if(gender2.isSelected())
               user.setGender("Female");
        else 
            user.setGender("Null");
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
}

