
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Afaq
 */
public class AddCarGUI {
    JFrame frame,popupframe;
    JButton backbtn,Addbtn;
    JLabel heading;
    JLabel label1,label2,label3,label4,label5,label6,label7;    
    JTextField vin,make,m_year,model,eno,color,pdrent;
    RoundedPanel r;
    AddCarBtnHandler hnd;
    CarDAO Dao;
    JPanel pan1,pan2;
    
    int Loc_X_Cor_Fr =0;
    int Loc_Y_Cor_Fr =10;
    int X_cor_Size =670;
    int Y_cor_Size =665;
    
    public AddCarGUI(){
    Dao =new CarDAO();
    initGUI();    
  }    

    private void initGUI() {
        frame=new JFrame();
        frame.setTitle("Add a Car");
        frame.setLayout(null);
        
        hnd = new AddCarBtnHandler(this);
        
        pan1 = new JPanel();
        pan1.setLocation(0,0);
        pan1.setSize(250,665);
        pan1.setBackground(Color.BLACK);
        frame.add(pan1);
        
        JLabel bg = new JLabel();
        bg.setIcon(new ImageIcon("Car2.png"));
        bg.setLayout(new BorderLayout());
        bg.setSize(254,673);
        bg.setLocation(0,0);
        pan1.add(bg);
        
        r = new RoundedPanel();
        r.setSize(330,550);
        r.setLayout(null);
        r.setLocation(270,30);
        r.setBackground(Color.BLACK);
        frame.add(r);
        
        heading = new JLabel();
        heading.setText("Car Details");
        Font font = new Font("Times New Roman", Font.BOLD, 24);
        heading.setFont(font);
        heading.setForeground(Color.red);
        heading.setLocation(50,20);
        heading.setSize(150,40);
        r.add(heading);
        
        label1 = new JLabel();
        label1.setText("Car Regd_No*");
        label1.setForeground(Color.red);
        label1.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 15));
        label1.setBounds(10, 100, 200,15);
        r.add(label1);
        
        vin = new JTextField();
        vin.setBounds(150, 100,150,25);
        r.add(vin);
        
        label2 = new JLabel();
        label2.setText("Make*");
        label2.setForeground(Color.red);
        label2.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 15));
        label2.setBounds(10, 150, 200,15);
        r.add(label2);
        
        make = new JTextField();
        make.setBounds(150, 150,150,25);
        r.add(make);
        
        label3 = new JLabel();
        label3.setText("Make Year*");
        label3.setForeground(Color.red);
        label3.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 15));
        label3.setBounds(10, 200, 200,15);
        r.add(label3);
        
        m_year = new JTextField();
        m_year.setBounds(150, 200,150,25);
        r.add(m_year);
        
        label4 = new JLabel();
        label4.setText("Model*");
        label4.setForeground(Color.red);
        label4.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 15));
        label4.setBounds(10, 250, 200,15);
        r.add(label4);
        
        model = new JTextField();
        model.setBounds(150, 250,150,25);
        r.add(model);
        
        label5 = new JLabel();
        label5.setText("Engine No");
        label5.setForeground(Color.red);
        label5.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 15));
        label5.setBounds(10, 300, 200,15);
        r.add(label5);
        
        eno = new JTextField();
        eno.setBounds(150, 300,150,25);
        r.add(eno);
        
        label6 = new JLabel();
        label6.setText("Color");
        label6.setForeground(Color.red);
        label6.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 15));
        label6.setBounds(10, 350, 200,15);
        r.add(label6);
        
        color = new JTextField();
        color.setBounds(150, 350,150,25);
        r.add(color);
        
        label7 = new JLabel();
        label7.setText("Rent Per day*");
        label7.setForeground(Color.red);
        label7.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 15));
        label7.setBounds(10, 400, 200,15);
        r.add(label7);
        
        pdrent = new JTextField();
        pdrent.setBounds(150, 400,150,25);
        r.add(pdrent);
        
        backbtn = new JButton();
        backbtn.setText("Back");
        backbtn.setBackground(Color.red);
        backbtn.setForeground(Color.white);
        backbtn.setBounds(20, 450, 120, 30);
        backbtn.addActionListener(hnd);
        r.add(backbtn);
        
        Addbtn = new JButton();
        Addbtn.setText("Add");
        Addbtn.setBackground(Color.red);
        Addbtn.setForeground(Color.white);
        Addbtn.setBounds(150, 450, 120, 30);
        Addbtn.addActionListener(hnd);
        r.add(Addbtn);
        
        JLabel note = new JLabel();
        note.setText("* show here necessary fields");
        note.setForeground(Color.red);
        note.setFont(new Font(Font.SANS_SERIF,  Font.PLAIN, 10));
        note.setBounds(10, 500, 200,15);
        r.add(note);
        
        JLabel bg1 = new JLabel();
        bg1.setIcon(new ImageIcon("HCBfJmb_.png"));
        bg1.setLayout(new BorderLayout());
        bg1.setSize(X_cor_Size-200,Y_cor_Size);
        bg1.setLocation(250,0);
        frame.add(bg1);
        
        frame.setLocation(Loc_X_Cor_Fr,Loc_Y_Cor_Fr);
        frame.setSize(X_cor_Size, Y_cor_Size);  
        frame.setVisible(true);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
     public void DisplayMessage(String s)
    {
        int fr_s_x=500,fr_s_y=150;
        int fr_l_x=400,fr_l_y=300;
        popupframe = new JFrame("Sign In:");
        popupframe.setIconImage(new ImageIcon("12.jpg").getImage());
        popupframe.setSize(fr_s_x,fr_s_y);
        popupframe.setLocation(fr_l_x,fr_l_y);
        popupframe.setLayout(null);
        popupframe.setBackground(Color.BLACK);
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
        popupframe.add(pan);
        popupframe.setVisible(true);
    }
}
