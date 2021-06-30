
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author afaqs
 */
public class DeleteAccountGUI {
    JFrame frame,messageFrame;
    RoundedPanel panel;
    JLabel user,pass,cniclabel,recniclabel;
    UserDAO dao;
    JButton jb,cancel;
    JCheckBox usercheckBox1,usercheckBox2;
    JTextField usernametf,cnicField,recnicField; 
    JPasswordField passField;
    DeleteAccountHandler dlthnd;
    
    int Loc_X_Cor_Fr =50;
    int Loc_Y_Cor_Fr =100;
    int X_cor_Size =700;
    int Y_cor_Size =480;
    
    
   public DeleteAccountGUI()
   {
      dao= new UserDAO();
      initGUI();
   }

    public void initGUI() {
        frame = new JFrame();
        panel = new RoundedPanel();
        user = new JLabel();
        pass = new JLabel();
        cniclabel = new JLabel();
        recniclabel = new JLabel();
        jb =new JButton();
        cancel = new JButton();
        dlthnd =new DeleteAccountHandler(this);
       
        frame.setTitle("Rent_A_Car_DeleteAccount");
        frame.setLayout(null);
        
        panel.setSize(330,200);
        panel.setLayout(null);
        panel.setLocation(150,150);
        panel.setBackground(Color.BLACK);
        
        user = new JLabel();
        user.setText("User Name");
        user.setForeground(Color.red);
        user.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 15));
        user.setBounds(30, 10, 200,15);
        panel.add(user);
        
        usernametf = new JTextField();
        usernametf.setBounds(150, 10,150,25);
        panel.add(usernametf);
        
        pass = new JLabel();
        pass.setText("Password");
        pass.setForeground(Color.red);
        pass.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 15));
        pass.setBounds(30, 60, 200,15);
        panel.add(pass);
        
        passField = new JPasswordField();
        passField.setBounds(150, 60,150,25);
        panel.add(passField);
        
        cniclabel = new JLabel();
        cniclabel.setText("CNIC No.");
        cniclabel.setForeground(Color.red);
        cniclabel.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 15));
        cniclabel.setBounds(20, 60, 200,15);
        cniclabel.setVisible(false);
        panel.add(cniclabel);
        
        cnicField = new JTextField();
        cnicField.setBounds(150, 60,150,25);
        panel.add(cnicField);
        cnicField.setVisible(false);
        
        recniclabel = new JLabel();
        recniclabel.setText("ReEnter CNIC No.");
        recniclabel.setForeground(Color.red);
        recniclabel.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 15));
        recniclabel.setBounds(20, 110, 200,15);
        recniclabel.setVisible(false);
        panel.add(recniclabel);
        
        recnicField = new JTextField();
        recnicField.setBounds(150, 110,150,25);
        panel.add(recnicField);
        recnicField.setVisible(false);
        
        jb.setText("Delete Account");
        jb.setBackground(Color.red);
        jb.setForeground(Color.white);
        jb.setBounds(20, 160, 150, 30);
        jb.addActionListener(dlthnd);
        panel.add(jb);
        
        cancel.setText("Cancel");
        cancel.setBackground(Color.red);
        cancel.setForeground(Color.white);
        cancel.setBounds(200, 160, 100, 30);
        cancel.addActionListener(dlthnd);
        panel.add(cancel);
        
        usercheckBox1 =new JCheckBox("As Admin");
        usercheckBox1.setBounds(20,110,100,30);
        usercheckBox1.setBackground(Color.BLACK);
        usercheckBox1.setForeground(Color.red);
        panel.add(usercheckBox1);
        
        usercheckBox2 = new JCheckBox("As Normal User");
        usercheckBox2.setBounds(120,110,130,30);
        usercheckBox2.setBackground(Color.BLACK);
        usercheckBox2.setForeground(Color.red);
        panel.add(usercheckBox2);
        
        frame.add(panel);
        
        JLabel bg = new JLabel();
        bg.setIcon(new ImageIcon("rent.jpg"));
        bg.setLayout(new BorderLayout());
        bg.setSize(X_cor_Size,Y_cor_Size);
        bg.setLocation(0,0);
        frame.add(bg);
        
        frame.setLocation(Loc_X_Cor_Fr,Loc_Y_Cor_Fr);
        frame.setSize(X_cor_Size, Y_cor_Size);  
        frame.setVisible(true);
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
        btn.addActionListener(dlthnd);
        
        pan.add(msg);
        pan.add(btn);
        messageFrame.add(pan);
        messageFrame.setVisible(true);
    }
}
