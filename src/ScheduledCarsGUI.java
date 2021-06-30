
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
public class ScheduledCarsGUI {
    JFrame frame, popupframe,reciept; 
    JPanel pan1, pan2, pan3, pan4;
    RoundedPanel r, tempPan5;
    JPanel tempPan1, tempPan2;
    JButton backbtn, Addbtn;
    JTable jt, subjt1,subjt2;
    DefaultTableModel JTmodel,JTmodel1,JTmodel2;
    CarDAO Dao;
    BookingDAO bdao;
    JScrollPane sp,subsp1,subsp2;
    ScheduledCarBtnHandler hnd;
    JLabel head, heading,MovingTagline;
    JButton close, pdf;
    JLabel label1, label2, label3, label4, label5, label6, label7, bg3;
    JLabel header1, header2,header3;
    
    JLabel attr1,attr2,attr3,attr4,attr5,attr6,attr7,attr8;
    JTextField vin;
    //JTextField selVin, selMake, selM_year, selModel, selEno, selColor, selPdrent;
    int Loc_X_Cor_Fr = 0;
    int Loc_Y_Cor_Fr = 10;
    int X_cor_Size = 1138;
    int Y_cor_Size = 700;
    AdminMenuGUI adminGUI;

    public ScheduledCarsGUI(AdminMenuGUI refg) {
        adminGUI = refg;
        Dao = new CarDAO();
        bdao = new BookingDAO();
        initGUI();
    }

    public void initGUI() {
        frame = new JFrame();
        frame.setLayout(null);
        hnd = new ScheduledCarBtnHandler(this, adminGUI);

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
        head = new JLabel("All Bookings(Scheduled Cars)");
        head.setLocation(920 / 2 - 20, 0);
        head.setFont(new Font("Helvetica Neue", Font.BOLD, 30));
        head.setForeground(Color.RED);
        pan4.add(head);

        pan2.add(bg);
        pan2.setBorder(BorderFactory.createLineBorder(Color.red));
        pan1 = new JPanel();
        pan1.setLayout(new BorderLayout());
        pan1.setSize(920, 510);
        pan1.setLocation(200, 50);
        //pan1.setBackground(Color.BLUE);
        
        header1 = new JLabel();
        header1.setText("Current On Way Bookings");
        header1.setForeground(Color.WHITE);
        header1.setFont(new Font("Times New Roman", Font.BOLD, 25));
        header1.setBounds(10, 5, 300, 50);
        Border  b;
        b = BorderFactory.createLineBorder(new Color(150,0,0), 5);
        header1.setBorder(b);
        header1.setVisible(false);
        pan1.add(header1);
        
        header2 = new JLabel();
        header2.setText("Coming Up Bookings");
        header2.setForeground(Color.WHITE);
        header2.setFont(new Font("Times New Roman", Font.BOLD, 25));
        header2.setBounds(10, 265, 300, 50);
        header2.setBorder(b);
        header2.setVisible(false);
        pan1.add(header2);
        
        header3 = new JLabel();
        header3.setText("Previous Bookings");
        header3.setForeground(Color.WHITE);
        header3.setFont(new Font("Times New Roman", Font.BOLD, 25));
        header3.setBounds(10, 650, 300, 50);
        header3.setBorder(b);
        header3.setVisible(false);
        pan1.add(header3);
        
        tempPan1 =new JPanel();
        tempPan1.setLayout(new BorderLayout());
        tempPan1.setLocation(0, 60);
        tempPan1.setSize(920, 200);
        tempPan1.setBackground(Color.BLACK);
        tempPan1.setVisible(false);
        pan1.add(tempPan1);
        
        //pssting here to edit
        JTmodel1 = bdao.GetOnWayBookings();
        subjt1 = new JTable(JTmodel1);
        DefaultTableCellRenderer centerRenderer1 = new DefaultTableCellRenderer();
        centerRenderer1.setHorizontalAlignment(JLabel.CENTER);
        int numOfCols = subjt1.getColumnCount();
        for (int i = 0; i < numOfCols; i++) {
            subjt1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer1);
        }
        JTableHeader tableHeader1 = subjt1.getTableHeader();
        tableHeader1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        tableHeader1.setBackground(Color.BLACK);
        tableHeader1.setForeground(Color.red);
        Font font1 = new Font("Arial", Font.PLAIN, 15);
        subjt1.setFont(font1);
        subjt1.setRowHeight(30);
//jt.setGridColor(Color.GREEN);
        subjt1.setRowSelectionAllowed(false);
        subjt1.setColumnSelectionAllowed(false);
        subjt1.setCellSelectionEnabled(false);
        subjt1.setDragEnabled(false);
        subjt1.setPreferredScrollableViewportSize(subjt1.getPreferredScrollableViewportSize());
        subjt1.setFillsViewportHeight(true);

        subjt1.setBounds(0, 0, 920, 200);
        subjt1.setBackground(Color.BLACK);
        subjt1.setForeground(Color.WHITE);
        subsp1 = new JScrollPane(subjt1);
        subsp1.setBackground(Color.BLACK);
        subsp1.setVisible(false);
        tempPan1.add(subsp1);
        //ok
        
        tempPan2 =new JPanel();
        tempPan2.setLayout(new BorderLayout());
        tempPan2.setLocation(0, 320);
        tempPan2.setSize(920, 200);
        tempPan2.setBackground(Color.BLACK);
        tempPan2.setVisible(false);
        pan1.add(tempPan2);
  
        //pasting here code to edit
        JTmodel2 = bdao.GetComingUpBookings();
        subjt2 = new JTable(JTmodel2);
        DefaultTableCellRenderer centerRenderer2 = new DefaultTableCellRenderer();
        centerRenderer2.setHorizontalAlignment(JLabel.CENTER);
        numOfCols = subjt2.getColumnCount();
        for (int i = 0; i < numOfCols; i++) {
            subjt2.getColumnModel().getColumn(i).setCellRenderer(centerRenderer1);
        }
        JTableHeader tableHeader2 = subjt2.getTableHeader();
        tableHeader2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        tableHeader2.setBackground(Color.BLACK);
        tableHeader2.setForeground(Color.red);
        Font font2 = new Font("Arial", Font.PLAIN, 15);
        subjt2.setFont(font1);
        subjt2.setRowHeight(30);
//jt.setGridColor(Color.GREEN);
        subjt2.setRowSelectionAllowed(false);
        subjt2.setColumnSelectionAllowed(false);
        subjt2.setCellSelectionEnabled(false);
        subjt2.setDragEnabled(false);
        subjt2.setPreferredScrollableViewportSize(subjt1.getPreferredScrollableViewportSize());
        subjt2.setFillsViewportHeight(true);

        subjt2.setBounds(0, 0, 920, 200);
        subjt2.setBackground(Color.BLACK);
        subjt2.setForeground(Color.WHITE);
        subsp2 = new JScrollPane(subjt2);
        subsp2.setBackground(Color.BLACK);
        subsp2.setVisible(false);
        tempPan2.add(subsp2);
        //ok
        
        bg3 = new JLabel();
        bg3.setIcon(new ImageIcon("b1 (4).jpg"));
        bg3.setLayout(new BorderLayout());
        bg3.setSize(920, 510);
        bg3.setLocation(0, 0);
        bg3.setVisible(false);
        pan1.add(bg3);
        
        
        //heading
        JTmodel = bdao.getAllBookings();
        jt = new JTable(JTmodel);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        numOfCols = jt.getColumnCount();
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

        pan1.add(sp);
        
        
        
        frame.add(pan1);
        
        pan3 = new JPanel();
        pan3.setLocation(201, 550);
        pan3.setSize(X_cor_Size - 200, Y_cor_Size - 550);
        pan3.setLayout(null);
        pan3.setBackground(Color.BLACK);

        backbtn = new JButton();
        backbtn.setText("Back");
        backbtn.setBackground(Color.red);
        backbtn.setForeground(Color.white);
        backbtn.setBounds(780, 55, 120, 30);
        backbtn.addActionListener(hnd);
        pan3.add(backbtn);

        Addbtn = new JButton();
        Addbtn.setText("Change View");
        Addbtn.setBackground(Color.red);
        Addbtn.setForeground(Color.white);
        Addbtn.setBounds(650, 55, 120, 30);
        Addbtn.addActionListener(hnd);
        pan3.add(Addbtn);


        JLabel backg = new JLabel();
        backg.setIcon(new ImageIcon("b1 (4).jpg"));
        backg.setLayout(new BorderLayout());
        backg.setSize(X_cor_Size - 200, Y_cor_Size - 570);
        backg.setLocation(0, 0);
        pan3.add(backg);

        frame.add(pan3);
        frame.setLocation(Loc_X_Cor_Fr, Loc_Y_Cor_Fr);
        frame.setSize(X_cor_Size, Y_cor_Size);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void DisplayMessage(String s) {
        int fr_s_x = 500, fr_s_y = 150;
        int fr_l_x = 400, fr_l_y = 300;
        popupframe = new JFrame("Scheduled Car Msg:");
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

        JButton btn = new JButton();
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
}
