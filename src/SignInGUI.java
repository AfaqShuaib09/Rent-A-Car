
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//import javafx.scene.layout.Border;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.AbstractBorder;
import javax.swing.border.TitledBorder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author afaqs
 */
public class SignInGUI {
    JFrame frame, messageFrame,QuitFrame,popupFrame;
    JButton signUp,create;
    JPanel signIn, pan;
    JLabel l1,l2,Heading,s1;
    JTextField usernametf;
    JPasswordField passwordField;
    JCheckBox usercheckBox1,usercheckBox2;  //userCheckbox1 = admin,    userCheckbox2=normal user 
    Font f;
    User user;
    JButton btn,btn1;
    UserDAO DAO;
    SignInBtnHandler shnd;
    
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int Loc_X_Cor_Fr =0;
    int Loc_Y_Cor_Fr =10;
    int X_cor_Size =1000;
    int Y_cor_Size =683;
    
    public SignInGUI(){
    DAO =new UserDAO();
    initGUI();    
  }    
public void initGUI() {
        frame=new JFrame();
        frame.setTitle("Rent_A_Car_SignIn");
        frame.setLayout(null);
        
        shnd= new SignInBtnHandler(this);
        
        signUp = new JButton();
        signUp.setText("Delete Account");
        signUp.setBounds(690,20,125,30);
        signUp.setBackground(Color.RED);
        signUp.setForeground(Color.WHITE);
        signUp.addActionListener(shnd);
        frame.add(signUp);
        
        create = new JButton();
        create.setText("Create New Account");
        create.setBounds(820,20,150,30);
        create.setBackground(Color.RED);
        create.setForeground(Color.WHITE);
        create.addActionListener(shnd);
        frame.add(create);
        
        signIn = new JPanel() {
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
        
        signIn.setBounds(10,10,100,30);
        signIn.setOpaque(false);
        signIn.setBounds(30,200,300,400);
        signIn.setLayout(null);
        signIn.setBackground(Color.BLACK);
        f = new Font(Font.SERIF,Font.BOLD,30);
        
        Heading = new JLabel();
        Heading.setText("Sign In");
        Heading.setFont(f);
        Heading.setForeground(Color.red);
        Heading.setBounds(100,10,150,35);
       signIn.add(Heading);
        
        
       
        l1 = new JLabel();
        l1.setText("User Name");
        l1.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 15));
        l1.setBounds(30, 100, 200,15);
        l1.setForeground(Color.RED);
        signIn.add(l1);
        
        usernametf = new JTextField();
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                usernametf.requestFocus();
            }
            @Override
            public void windowClosing(WindowEvent e) {
                frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                ExitMessage();
    }
        });
        usernametf.setBounds(120, 100,150,25);
        signIn.add(usernametf);
        
        l2 = new JLabel();
        l2.setText("Password");
        l2.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 15));
        l2.setBounds(30, 150, 200,15);
        l2.setForeground(Color.RED);
        signIn.add(l2);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(120, 150,150,25);
        signIn.add(passwordField);
        
        usercheckBox1 =new JCheckBox("As Admin");
        usercheckBox1.setBounds(20,200,100,30);
        usercheckBox1.setBackground(Color.BLACK);
        usercheckBox1.setForeground(Color.red);
        signIn.add(usercheckBox1);
        
        usercheckBox2 = new JCheckBox("As Normal User");
        usercheckBox2.setBounds(150, 200,130,30);
        usercheckBox2.setBackground(Color.BLACK);
        usercheckBox2.setForeground(Color.red);
        signIn.add(usercheckBox2);
 
        btn = new JButton();
        btn.setText("Sign In");
        btn.setBounds(20,250,250,30);
        btn.setBackground(Color.RED);
        btn.setForeground(Color.WHITE);
        btn.addActionListener(shnd);
        signIn.add(btn);
        
        s1 = new JLabel();
        s1.setText("Do you have an Account?");
        s1.setForeground(Color.red);
        s1.setBounds(20, 300,150,20);
        signIn.add(s1);
        
        btn1 = new JButton();
        btn1.setText("Sign Up");
        btn1.setBounds(170,300,100,30);
        btn1.setBackground(Color.RED);
        btn1.setForeground(Color.WHITE);
        btn1.addActionListener(shnd);
        signIn.add(btn1);
        
        
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
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
    }
    public void DisplayMessage(String s)
    {
        int fr_s_x=500,fr_s_y=150;
        int fr_l_x=400,fr_l_y=300;
        messageFrame = new JFrame("Sign In:");
        messageFrame.setIconImage(new ImageIcon("12.jpg").getImage());
        messageFrame.setSize(fr_s_x,fr_s_y);
        messageFrame.setLocation(fr_l_x,fr_l_y);
        messageFrame.setLayout(null);
        messageFrame.setBackground(Color.BLACK);
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
        btn.addActionListener(shnd);
        
        pan.add(msg);
        pan.add(btn);
        messageFrame.add(pan);
        messageFrame.setVisible(true);
    }
    void fillUser()
    {
        user = new User();
        user.setUsername(usernametf.getText());
        user.setPassword(passwordField.getText());
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
        temp.addActionListener(shnd);
        
        JButton temp1= new JButton();
        temp1.setText("No");
        temp1.setForeground(Color.WHITE);
        temp1.setBackground(Color.red);
        temp1.setLocation(300,70);
        temp1.setSize(100,30);
        temp1.addActionListener(shnd);
        
        pan2.add(msg);
        pan2.add(temp);
        pan2.add(temp1);
        QuitFrame.add(pan2);
        QuitFrame.setVisible(true);
        QuitFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
