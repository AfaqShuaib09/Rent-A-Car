
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
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicScrollBarUI;
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
public class RemoveCarGUI {
    JFrame frame, popupframe,DeletionGUI; 
    JPanel pan1, pan2, pan3, pan4,temppan1;
    RoundedPanel r;
    JButton backbtn, removeBtn;
    JTable jt;
    DefaultTableModel JTmodel;
    CarDAO Dao;
    BookingDAO bdao;
    JScrollPane sp;
    RemoveCarBtnHandler hnd;
    JLabel head, heading,MovingTagline;
    JButton cancel, cRemove,btn;
    JLabel label1, label2, label3, label4, label5, label6, label7, bg3;
    JLabel selLabel1, selLabel2, selLabel3, selLabel4, selLabel5, selLabel6, selLabel7,Header;
    JLabel attr1,attr2,attr3,attr4,attr5,attr6,attr7;
    JTextField vin;
    int Loc_X_Cor_Fr = 0;
    int Loc_Y_Cor_Fr = 10;
    int X_cor_Size = 1138;
    int Y_cor_Size = 700;
    AdminMenuGUI adminGUI;

    public RemoveCarGUI(AdminMenuGUI refg) {
        adminGUI = refg;
        Dao = new CarDAO();
        bdao = new BookingDAO();
        initGUI();
    }

    public void initGUI() {
        frame = new JFrame();
        frame.setLayout(null);
        
        hnd = new RemoveCarBtnHandler(this, adminGUI);

        pan2 = new JPanel();
        pan2.setLocation(0, 0);
        pan2.setSize(200, 665);
        pan2.setBackground(Color.BLACK);
        frame.add(pan2);

        JLabel bg = new JLabel();
        bg.setIcon(new ImageIcon("Car3.jpg"));
        bg.setLayout(new BorderLayout());
        bg.setSize(254, 673);
        bg.setLocation(0, 0);

        JLabel bg1 = new JLabel();
        bg1.setIcon(new ImageIcon("rent (2).jpg"));
        bg1.setLayout(new BorderLayout());
        bg1.setSize(500, 341);
        bg1.setLocation(0, 0);

        pan4 = new JPanel();
        pan4.setLocation(200, 0);
        pan4.setSize(920, 50);
        pan4.setBackground(Color.BLACK);
        frame.add(pan4);
        head = new JLabel("Available Cars");
        head.setLocation(920 / 2 - 20, 0);
        head.setFont(new Font("Helvetica Neue", Font.BOLD, 30));
        head.setForeground(Color.RED);
        pan4.add(head);

        pan2.add(bg);
        pan2.setBorder(BorderFactory.createLineBorder(Color.red));
        
        temppan1 = new JPanel();
        temppan1.setLayout(null);
        temppan1.setSize(920, 450);
        temppan1.setLocation(200, 50);
        
        
        pan1 = new JPanel();
        pan1.setLayout(new BorderLayout());
        pan1.setSize(600, 350);
        pan1.setLocation(150,50);
        //pan1.setBackground(Color.BLUE);

        bg3 = new JLabel();
        bg3.setIcon(new ImageIcon("b1 (4).jpg"));
        bg3.setLayout(new BorderLayout());
        bg3.setSize(920, 510);
        bg3.setLocation(0, 0);
        bg3.setVisible(true);

        JTmodel = Dao.getCarRemovalView();
        jt = new JTable(JTmodel);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        int numOfCols = jt.getColumnCount();
        for (int i = 0; i < numOfCols; i++) {
            jt.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        JTableHeader tableHeader = jt.getTableHeader();
        tableHeader.setFont(new Font("Times New Roman", Font.BOLD, 20));
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

        jt.setBounds(30, 40, 1000, 700);
        jt.setBackground(Color.BLACK);
        jt.setForeground(Color.WHITE);
        sp = new JScrollPane(jt);
        sp.setBackground(Color.BLACK);
        sp.getVerticalScrollBar().setBackground(Color.BLACK);
        sp.getHorizontalScrollBar().setBackground(Color.BLACK);
        sp.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
         @Override
         protected void configureScrollBarColors() {
        this.thumbColor = new Color(150,0,0);
       }
    });
        pan1.add(sp);
        temppan1.add(pan1);
        temppan1.add(bg3);
        frame.add(temppan1);

        pan3 = new JPanel();
        pan3.setLocation(201, 490);
        pan3.setSize(X_cor_Size - 200, Y_cor_Size - 490);
        pan3.setLayout(null);
        pan3.setBackground(Color.BLACK);
        
        JPanel stylePanel = new JPanel();
        stylePanel.setLayout(null);
        stylePanel.setSize(200,50);
        stylePanel.setBackground(new Color(0,0,0,5));
        stylePanel.setLocation(10,20);

        Border  b;
        b = BorderFactory.createLineBorder(new Color(150,0,0), 5);
        stylePanel.setBorder(b);
        
        String txt="Remove Car:";
        JLabel detail = new JLabel();
        detail.setText(txt);
        detail.setForeground(Color.red);
        detail.setFont(new Font("Times New Roman", Font.BOLD, 25));
        detail.setBounds(10, 2, 250, 50);
        stylePanel.add(detail);
        pan3.add(stylePanel);

        label1 = new JLabel();
        label1.setText("Enter Car Registration No.: ");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("Calibri", Font.BOLD, 20));
        label1.setBounds(10, 97, 250, 30);
        pan3.add(label1);

        vin = new JTextField();
        vin.setBounds(255, 90, 150, 30);
        vin.setFont(new Font("Calibri", Font.PLAIN, 20));
        pan3.add(vin);

        backbtn = new JButton();
        backbtn.setText("Back");
        backbtn.setBackground(Color.red);
        backbtn.setForeground(Color.white);
        backbtn.setBounds(780, 100, 120, 30);
        backbtn.addActionListener(hnd);
        pan3.add(backbtn);

        removeBtn = new JButton();
        removeBtn.setText("Remove");
        removeBtn.setBackground(Color.red);
        removeBtn.setForeground(Color.white);
        removeBtn.setBounds(650, 100, 120, 30);
        removeBtn.addActionListener(hnd);
        pan3.add(removeBtn);

        JLabel backg = new JLabel();
        backg.setIcon(new ImageIcon("bg.png"));
        backg.setLayout(new BorderLayout());
        backg.setSize(X_cor_Size - 200, Y_cor_Size - 490);
        backg.setLocation(0, 0);
        pan3.add(backg);

        frame.add(pan3);
        frame.setLocation(Loc_X_Cor_Fr, Loc_Y_Cor_Fr);
        frame.setSize(X_cor_Size, Y_cor_Size);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void DisplayMessage(String s) {
        int fr_s_x = 500, fr_s_y = 150;
        int fr_l_x = 400, fr_l_y = 300;
        popupframe = new JFrame("Sign In:");
        popupframe.setIconImage(new ImageIcon("12.jpg").getImage());
        popupframe.setSize(fr_s_x, fr_s_y);
        popupframe.setLocation(fr_l_x, fr_l_y);
        popupframe.setLayout(null);
        popupframe.setBackground(Color.BLACK);
        JPanel pan = new JPanel();
        pan.setLayout(null);
        pan.setSize(fr_s_x, fr_s_y);
        pan.setLocation(0, 0);
        pan.setBackground(Color.BLACK);

        JLabel msg = new JLabel(s);
        msg.setBackground(Color.BLACK);
        msg.setForeground(Color.red);
        msg.setFont(new Font("Arial", Font.PLAIN, 22));
        msg.setLocation(50, 20);
        msg.setSize(500, 30);

        btn = new JButton();
        btn.setText("OK");
        btn.setForeground(Color.WHITE);
        btn.setBackground(Color.red);
        btn.setLocation(200, 70);
        btn.setSize(100, 30);
        btn.addActionListener(hnd);

        pan.add(msg);
        pan.add(btn);
        popupframe.add(pan);
        popupframe.setVisible(true);
    }
    public void generateDeletionDetailGUI(Car car)
    {
      DeletionGUI = new JFrame();
      DeletionGUI.setTitle("Reciept");
      DeletionGUI.setLayout(null);
      RoundedPanel r2 = new RoundedPanel();
      r2.setLocation(25,105);
      r2.setSize(350,480);
      r2.setBackground(Color.BLACK);
      r2.setLayout(null);
      JLabel lable1, lable2,lable3,lable4,lable5,lable6,lable7,headerReciept;
      JLabel info1,info2,info3,info4,info5,info6,info7;
     
      JPanel picPanel = new JPanel();
      picPanel.setSize(280,100);
      picPanel.setLayout(null);
      picPanel.setLocation(50,5);
      picPanel.setBackground(new Color(0,0,0,5));
      picPanel.setVisible(true);
      
      JLabel bg6 = new JLabel();
      bg6.setIcon(new ImageIcon("pic1.png"));
      bg6.setLayout(new BorderLayout());
      bg6.setSize(250, 90);
      bg6.setLocation(30, 0);
      picPanel.add(bg6);
      DeletionGUI.add(picPanel);
      
      JLabel bg5 = new JLabel();
      bg5.setIcon(new ImageIcon("i01_Car.png"));
      bg5.setLayout(new BorderLayout());
      bg5.setSize(100, 50);
      bg5.setLocation(240, 20);
      r2.add(bg5);
      
      lable1 = new JLabel("Car RegistrationID: ");
      lable1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
      lable1.setBounds(20, 80, 200, 15);
      lable1.setForeground(Color.WHITE);
      r2.add(lable1);
      
      info1 = new JLabel(car.getCar_Regd_id());
      info1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
      info1.setBounds(220, 80, 200, 15);
      info1.setForeground(Color.WHITE);
      r2.add(info1);
      
      lable2 = new JLabel("Make: ");
      lable2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
      lable2.setBounds(20, 130, 200, 15);
      lable2.setForeground(Color.WHITE);
      r2.add(lable2);
      
      info2 = new JLabel(car.getMake());
      info2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
      info2.setBounds(220, 130, 200, 15);
      info2.setForeground(Color.WHITE);
      r2.add(info2);
      
      lable3 = new JLabel("Make Year: ");
      lable3.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
      lable3.setBounds(20, 180, 200, 15);
      lable3.setForeground(Color.WHITE);
      r2.add(lable3);
      
      info3 = new JLabel(car.getMake_year());
      info3.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
      info3.setBounds(220, 180, 200, 15);
      info3.setForeground(Color.WHITE);
      r2.add(info3);
      
      lable4 = new JLabel("Model: ");
      lable4.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
      lable4.setBounds(20, 230, 200, 15);
      lable4.setForeground(Color.WHITE);
      r2.add(lable4);
      
      info4 = new JLabel(car.getModel());
      info4.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
      info4.setBounds(220, 230, 200, 15);
      info4.setForeground(Color.WHITE);
      r2.add(info4);
      
      lable5 = new JLabel("Car Engine No:");
      lable5.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
      lable5.setBounds(20, 280, 200, 15);
      lable5.setForeground(Color.WHITE);
      r2.add(lable5);
      
      info5 = new JLabel(car.getEngine_No());
      info5.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
      info5.setBounds(220, 280, 200, 15);
      info5.setForeground(Color.WHITE);
      r2.add(info5);
      
      lable6 = new JLabel("Color: ");
      lable6.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
      lable6.setBounds(20, 330, 200, 15);
      lable6.setForeground(Color.WHITE);
      r2.add(lable6);
      
      info6 = new JLabel(car.getColor());
      info6.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
      info6.setBounds(220, 330, 200, 15);
      info6.setForeground(Color.WHITE);
      r2.add(info6);
      
      lable7 = new JLabel("Per Day Rent: ");
      lable7.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
      lable7.setBounds(20, 380, 200, 15);
      lable7.setForeground(Color.WHITE);
      r2.add(lable7);
      
      info7 = new JLabel(car.getPer_day_rent());
      info7.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
      info7.setBounds(220, 380, 200, 15);
      info7.setForeground(Color.WHITE);
      r2.add(info7);
      
      headerReciept = new JLabel("Car Details ");
      headerReciept.setFont(new Font("Times New Roman", Font.BOLD, 35));
      headerReciept.setBounds(20,93, 350, 40);
      headerReciept.setForeground(Color.RED);
      DeletionGUI.add(headerReciept);
      
     cancel = new JButton();
     cancel.setText("Cancel");
     cancel.setBackground(Color.red);
     cancel.setForeground(Color.white);
     cancel.setBounds(10, 430, 150, 30);
     cancel.addActionListener(hnd);
     r2.add(cancel);
      
     cRemove = new JButton();
     cRemove.setText("Confirm Remove");
     cRemove.setBackground(Color.red);
     cRemove.setForeground(Color.white);
     cRemove.setBounds(180, 430, 150, 30);
     cRemove.addActionListener(hnd);
     r2.add(cRemove);
     
      DeletionGUI.add(r2);
      
      JLabel backg1 = new JLabel();
      backg1.setIcon(new ImageIcon("b1 (2).jpg"));
      backg1.setLayout(new BorderLayout());
      backg1.setSize(410,630);
      backg1.setLocation(0, 0);
      //backg1.add(picPanel);
      DeletionGUI.add(backg1);
      DeletionGUI.setLocation(200,30);
      DeletionGUI.setSize(410,630);
      DeletionGUI.setVisible(true);
      DeletionGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
