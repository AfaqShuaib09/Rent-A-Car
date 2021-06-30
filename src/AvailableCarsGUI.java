
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javafx.scene.layout.Border;
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
public class AvailableCarsGUI {
    JFrame frame,popupframe;
    JPanel pan1,pan2,pan3,pan4;
    RoundedPanel r;
    JButton backbtn,Addbtn;
    JTable jt;
    DefaultTableModel JTmodel;
    CarDAO Dao;
    JScrollPane sp;
    AvailCarGUIBtnHandler hnd;
    JLabel label1,label2,label3,label4,label5,label6,label7,msg ;
    JTextField vin,make,m_year,model,eno,color,pdrent;
    int Loc_X_Cor_Fr =0;
    int Loc_Y_Cor_Fr =10;
    int X_cor_Size =1138;
    int Y_cor_Size =700;
    
    public AvailableCarsGUI()
    {
       Dao = new CarDAO();
       initGUI();
    } 
   
    public void initGUI() {
    frame = new JFrame();
    frame.setLayout(null);
    hnd = new AvailCarGUIBtnHandler(this);
    
    pan2 = new JPanel();
    pan2.setLocation(0,0);
    pan2.setSize(200,665);
    pan2.setBackground(Color.BLACK);
    frame.add(pan2);
    
    JLabel bg = new JLabel();
    bg.setIcon(new ImageIcon("Car3.jpg"));
    bg.setLayout(new BorderLayout());
    bg.setSize(254,673);
    bg.setLocation(0,0);
    
    JLabel bg1 = new JLabel();
    bg1.setIcon(new ImageIcon("rent (2).jpg"));
    bg1.setLayout(new BorderLayout());
    bg1.setSize(500,341);
    bg1.setLocation(0,0);
    
    pan4 = new JPanel();
    pan4.setLocation(200,0);
    pan4.setSize(920,40);
    pan4.setBackground(Color.BLACK);
    frame.add(pan4);
    JLabel head = new JLabel("Available Cars");
    head.setLocation(920/2-20,0);
    head.setFont(new Font("Helvetica Neue",Font.BOLD,30));
    head.setForeground(Color.RED);
    pan4.add(head);
    
    pan2.add(bg);
    pan2.setBorder(BorderFactory.createLineBorder(Color.red));
    pan1 = new JPanel();
    pan1.setLayout(new BorderLayout());
    pan1.setSize(920,460);
    pan1.setLocation(200,40);
    pan1.setBackground(Color.red);
    JTmodel = Dao.DisplayUserData();
    jt = new JTable(JTmodel);
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    centerRenderer.setHorizontalAlignment( JLabel.CENTER );
    int numOfCols= jt.getColumnCount();
    for(int i=0;i<numOfCols;i++)
    {  
        jt.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
    }
    JTableHeader tableHeader = jt.getTableHeader();
    tableHeader.setFont(new Font("Times New Roman",Font.BOLD,20));
    tableHeader.setBackground(Color.BLACK);
    tableHeader.setForeground(Color.red);
    Font font = new Font("Arial", Font.PLAIN, 15);
    jt.setFont(font);
    jt.setRowHeight(30);
//jt.setGridColor(Color.GREEN);
    jt.setRowSelectionAllowed(false);
    jt.setColumnSelectionAllowed(false);
    jt.setCellSelectionEnabled(false);
    jt.setDragEnabled(false);
    jt.setPreferredScrollableViewportSize(jt.getPreferredScrollableViewportSize());
    jt.setFillsViewportHeight(true);
    
    jt.setBounds(30,40,1000,500);   
    jt.setBackground(Color.BLACK);
    jt.setForeground(Color.WHITE);
    sp=new JScrollPane(jt); 
    sp.setBackground(Color.BLACK);
    
    pan1.add(sp);
    frame.add(pan1); 
    
    pan3 = new JPanel();
    pan3.setLocation(201,500);
    pan3.setSize(X_cor_Size-200,Y_cor_Size-500);
    pan3.setLayout(null);
    pan3.setBackground(Color.BLACK);
    
    label1 = new JLabel();
    label1.setText("Car Regd_No*");
    label1.setForeground(Color.red);
    label1.setFont(new Font("Times New Roman",  Font.BOLD, 15));
    label1.setBounds(10, 5, 150,15);
    pan3.add(label1);
    
    label2 = new JLabel();
    label2.setText("Make*");
    label2.setForeground(Color.red);
    label2.setFont(new Font("Times New Roman",  Font.BOLD, 15));
    label2.setBounds(200, 5, 150,15);
    pan3.add(label2);
     
    label3 = new JLabel();
    label3.setText("Make Year*");
    label3.setForeground(Color.red);
    label3.setFont(new Font("Times New Roman",  Font.BOLD, 15));
    label3.setBounds(400, 5, 150,15);
    pan3.add(label3); 
    
    label4 = new JLabel();
    label4.setText("Model*");
    label4.setForeground(Color.red);
    label4.setFont(new Font("Times New Roman",  Font.BOLD, 15));
    label4.setBounds(600, 5, 150,15);
    pan3.add(label4);
    
    label5 = new JLabel();
    label5.setText("Engine No");
    label5.setForeground(Color.red);
    label5.setFont(new Font("Times New Roman",  Font.BOLD, 15));
    label5.setBounds(780, 5, 150,15);
    pan3.add(label5);
    
    label6 = new JLabel();
    label6.setText("Color");
    label6.setForeground(Color.red);
    label6.setFont(new Font("Times New Roman",  Font.BOLD, 15));
    label6.setBounds(10, 70, 150,15);
    pan3.add(label6);
    
    label7 = new JLabel();
    label7.setText("Rent Per day*");
    label7.setForeground(Color.red);
    label7.setFont(new Font("Times New Roman",  Font.BOLD, 15));
    label7.setBounds(200, 70, 150,15);
    pan3.add(label7);
    
    vin = new JTextField();
    vin.setBounds(10,30,130,25);
    pan3.add(vin);
    
    make = new JTextField();
    make.setBounds(200,30,130,25);
    pan3.add(make);
    
    m_year = new JTextField();
    m_year.setBounds(400,30,130,25);
    pan3.add(m_year);
    
    model = new JTextField();
    model.setBounds(600,30,130,25);
    pan3.add(model);
    
    eno = new JTextField();
    eno.setBounds(780,30,130,25);
    pan3.add(eno);
    
    color = new JTextField();
    color.setBounds(10,95,130,25);
    pan3.add(color);
    
    pdrent = new JTextField();
    pdrent.setBounds(200,95,130,25);
    pan3.add(pdrent);
    
    backbtn = new JButton();
    backbtn.setText("Back");
    backbtn.setBackground(Color.red);
    backbtn.setForeground(Color.white);
    backbtn.setBounds(780, 95, 120, 30);
    backbtn.addActionListener(hnd);
    pan3.add(backbtn);
        
    Addbtn = new JButton();
    Addbtn.setText("Add");
    Addbtn.setBackground(Color.red);
    Addbtn.setForeground(Color.white);
    Addbtn.setBounds(650, 95, 120, 30);
    Addbtn.addActionListener(hnd);
    pan3.add(Addbtn);
    
    JLabel note = new JLabel();
    note.setText("* shows here necessary fields");
    note.setForeground(Color.red);
    note.setFont(new Font("Times New Roman",  Font.PLAIN, 12));
    note.setBounds(10, 135, 250,10);
    pan3.add(note);
    
    JLabel backg = new JLabel();
    backg.setIcon(new ImageIcon("bg.png"));
    backg.setLayout(new BorderLayout());
    backg.setSize(X_cor_Size-200,Y_cor_Size-500);
    backg.setLocation(0,0);
    pan3.add(backg);
    
    frame.add(pan3);
    frame.setLocation(Loc_X_Cor_Fr,Loc_Y_Cor_Fr);
    frame.setSize(X_cor_Size,Y_cor_Size);    
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
        
        msg = new JLabel(s);
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
