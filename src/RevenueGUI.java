
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
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
public class RevenueGUI {
    JFrame frame, popupframe,revenue,mwRevenueFrame;
    JPanel pan1, pan2, pan3,pan4;
    JButton mRevenue, yRevenue,back,monthwise,backBtn,closeBtn;
    CarDAO Dao;
    BookingDAO bdao;
    JTable jt;
    DefaultTableModel JTmodel;
    JScrollPane sp;
    RevenueBtnHandler hnd;
    JLabel label1, label2, label3, label4, label5, label6, label7, bg3;
    JTextField myear,month,year,mwyear;
    int Loc_X_Cor_Fr = 0;
    int Loc_Y_Cor_Fr = 10;
    int X_cor_Size = 1138;
    int Y_cor_Size = 700;
    AdminMenuGUI adminGUI;
    
    public RevenueGUI(AdminMenuGUI refg) {
        adminGUI = refg;
        Dao = new CarDAO();
        bdao = new BookingDAO();
        initGUI();
    }

    private void initGUI() {
        frame = new JFrame();
        frame.setLayout(null);
        
        hnd = new RevenueBtnHandler(this, adminGUI);
        pan2 = new JPanel();
        pan2.setLayout(null);
        pan2.setLocation(0, 0);
        pan2.setSize(200, 665);
        pan2.setBackground(Color.BLACK);
        frame.add(pan2);

        JLabel bg = new JLabel();
        bg.setIcon(new ImageIcon("Car3.jpg"));
        bg.setLayout(new BorderLayout());
        bg.setSize(254, 673);
        bg.setLocation(0, 0);
        pan2.add(bg);
        frame.add(pan2);
        
        pan3 = new JPanel();
        pan3.setLocation(200, 0);
        pan3.setSize(920, 50);
        pan3.setBackground(Color.BLACK);
        frame.add(pan3);
        
        JLabel heading = new JLabel("Calculate Revenue(Monthly or Yearly)");
        heading.setLocation(920 / 2 - 20, 0);
        heading.setFont(new Font("Helvetica Neue", Font.BOLD, 30));
        heading.setForeground(Color.RED);
        pan3.add(heading);
        
        pan1 = new JPanel();
        pan1.setLayout(null);
        pan1.setSize(920, 500);
        pan1.setLocation(200, 50);
        
        JLabel header = new JLabel();
        header.setText("Yearly Revenue");
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Times New Roman", Font.BOLD, 25));
        header.setBounds(10, 20, 200, 50);
        Border  b;
        b = BorderFactory.createLineBorder(new Color(150,0,0), 5);
        header.setBorder(b);
        pan1.add(header);
        
        JLabel l1 = new JLabel();
        l1.setText("Enter Year: ");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Calibri", Font.BOLD, 20));
        l1.setBounds(10, 85, 150, 30);
        pan1.add(l1);
        
        year = new JTextField();
        year.setBounds(120, 85, 70, 30);
        year.setFont(new Font("Calibri", Font.PLAIN, 15));
        pan1.add(year);
        
        mRevenue = new JButton();
        mRevenue.setText("Generate Yearly Revenue");
        mRevenue.setSize(200, 40);
        mRevenue.setLocation(10,135);
        mRevenue.setBackground(Color.red);
        mRevenue.setForeground(Color.white);
        mRevenue.addActionListener(hnd);
        pan1.add(mRevenue);
        
        JLabel header1 = new JLabel();
        header1.setText("Monthly Revenue");
        header1.setForeground(Color.WHITE);
        header1.setFont(new Font("Times New Roman", Font.BOLD, 25));
        header1.setBounds(10, 195, 200, 50);
        header1.setBorder(b);
        pan1.add(header1);
        
        JLabel l2 = new JLabel();
        l2.setText("Enter Year: ");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Calibri", Font.BOLD, 20));
        l2.setBounds(10, 260, 150, 30);
        pan1.add(l2);
        
        myear = new JTextField();
        myear.setBounds(120, 260, 70, 30);
        myear.setFont(new Font("Calibri", Font.PLAIN, 15));
        pan1.add(myear);
        
        JLabel l3 = new JLabel();
        l3.setText("Enter Month: ");
        l3.setForeground(Color.WHITE);
        l3.setFont(new Font("Calibri", Font.BOLD, 20));
        l3.setBounds(250, 260, 150, 30);
        pan1.add(l3);
        
        month = new JTextField();
        month.setBounds(368, 260, 70, 30);
        month.setFont(new Font("Calibri", Font.PLAIN, 15));
        pan1.add(month);
        
        yRevenue = new JButton();
        yRevenue.setText("Generate Monthly Revenue");
        yRevenue.setSize(200, 40);
        yRevenue.setLocation(10,310);
        yRevenue.setBackground(Color.red);
        yRevenue.setForeground(Color.white);
        yRevenue.addActionListener(hnd);
        pan1.add(yRevenue);
        
        JLabel tempheader1 = new JLabel();
        tempheader1.setText("Month Wise Revenue");
        tempheader1.setForeground(Color.WHITE);
        tempheader1.setFont(new Font("Times New Roman", Font.BOLD, 23));
        tempheader1.setBounds(10, 355, 235, 45);
        tempheader1.setBorder(b);
        pan1.add(tempheader1);
        
        JLabel templabel = new JLabel();
        templabel.setText("Enter Year: ");
        templabel.setForeground(Color.WHITE);
        templabel.setFont(new Font("Calibri", Font.BOLD, 20));
        templabel.setBounds(10, 410, 150, 30);
        pan1.add(templabel);
        
        mwyear = new JTextField();
        mwyear.setBounds(120, 410, 70, 30);
        mwyear.setFont(new Font("Calibri", Font.PLAIN, 15));
        pan1.add(mwyear);
        
        monthwise = new JButton();
        monthwise.setText("Month Wise Revenue");
        monthwise.setSize(200, 40);
        monthwise.setLocation(10,455);
        monthwise.setBackground(Color.red);
        monthwise.setForeground(Color.white);
        monthwise.addActionListener(hnd);
        pan1.add(monthwise);
        
        bg3 = new JLabel();
        bg3.setIcon(new ImageIcon("b1 (4).jpg"));
        bg3.setLayout(new BorderLayout());
        bg3.setSize(920, 550);
        bg3.setLocation(0, 0);
        pan1.add(bg3);
        
        frame.add(pan1);
        
        pan4 = new JPanel();
        pan4.setLocation(200, 550);
        pan4.setSize(X_cor_Size - 220, Y_cor_Size - 530);
        pan4.setLayout(null);
        pan4.setBackground(Color.BLACK);
        
        back =new JButton();
        back.setText("Back");
        back.setSize(150, 30);
        back.setLocation(720,70);
        back.setBackground(Color.red);
        back.setForeground(Color.white);
        back.addActionListener(hnd);
        pan4.add(back);
        
        JLabel bg4 = new JLabel();
        bg4.setIcon(new ImageIcon("b1 (1).jpg"));
        bg4.setLayout(new BorderLayout());
        bg4.setSize(920, 400);
        bg4.setLocation(0, 0);
        pan4.add(bg4);
        
        frame.add(pan4);
        frame.setLocation(Loc_X_Cor_Fr, Loc_Y_Cor_Fr);
        frame.setSize(X_cor_Size, Y_cor_Size);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
    public void DisplayMessage(String s) {
        int fr_s_x = 500, fr_s_y = 150;
        int fr_l_x = 400, fr_l_y = 300;
        popupframe = new JFrame("Revenue Error");
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
        popupframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }    
    public void GenerateRevenueFrame(String btnText,String year,String month)
    {
      revenue =new JFrame();
      revenue.setLayout(null);
      
      JPanel tempPan2 = new JPanel();
      tempPan2.setLayout(null);
      tempPan2.setLocation(0, 0);
      tempPan2.setSize(200, 665);
      tempPan2.setBackground(Color.BLACK);
      revenue.add(tempPan2);

      JLabel tempbg = new JLabel();
      tempbg.setIcon(new ImageIcon("Car3.jpg"));
      tempbg.setLayout(new BorderLayout());
      tempbg.setSize(254, 673);
      tempbg.setLocation(0, 0);
      tempPan2.add(tempbg);
      
      JPanel tempPan3 = new JPanel();
      tempPan3.setLocation(200, 0);
      tempPan3.setSize(920, 50);
      tempPan3.setBackground(Color.BLACK);
      revenue.add(tempPan3);
      JLabel tempheading = new JLabel(); 
      if(btnText.equals("Generate Monthly Revenue"))
          tempheading.setText("Month's Bookings");
      else if (btnText.equals("Generate Yearly Revenue"))
          tempheading.setText("Year's Bookings");
      tempheading.setLocation(920 / 2 - 20, 0);
      tempheading.setFont(new Font("Helvetica Neue", Font.BOLD, 30));
      tempheading.setForeground(new Color(200,0,0));
      tempPan3.add(tempheading);
      
     JPanel temppan1 = new JPanel();
     temppan1.setLayout(new BorderLayout());
     temppan1.setSize(920, 400);
     temppan1.setLocation(200, 50);
     if(month.length()==0)
         month="0"+month;
     if(btnText.equals("Generate Monthly Revenue"))
           JTmodel = bdao.getAllBookingsOfMonth(year, month);
     else
         JTmodel = bdao.getAllBookingsOfYear(year);
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

        jt.setBounds(30, 40, 1000, 500);
        jt.setBackground(Color.BLACK);
        jt.setForeground(Color.WHITE);
        sp = new JScrollPane(jt);
        sp.setBackground(Color.BLACK);
        temppan1.add(sp);
        revenue.add(temppan1);
        
        JPanel tempPan4 = new JPanel();
        tempPan4.setLocation(201, 450);
        tempPan4.setSize(X_cor_Size - 200, Y_cor_Size - 450);
        tempPan4.setLayout(null);
        tempPan4.setBackground(Color.BLACK);
        
        JLabel tempLabel = new JLabel();
        if(btnText.equalsIgnoreCase("Generate Monthly Revenue"))
                tempLabel.setText("Month's Revenue");
        else
            tempLabel.setText("Year's Revenue");
        tempLabel.setForeground(Color.WHITE);
        tempLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
        tempLabel.setBounds(10, 25, 250, 50);
        Border  b;
        b = BorderFactory.createLineBorder(new Color(150,0,0), 5);
        tempLabel.setBorder(b);
        tempLabel.setVisible(true);
        tempPan4.add(tempLabel);
        
        int rev=0;
        if(btnText.equalsIgnoreCase("Generate Monthly Revenue"))
                rev=bdao.monthlyRevenue(year, month);
        else
            rev= bdao.YearlyRevenue(year);
        
        JLabel tempLabel1 = new JLabel(); 
        tempLabel1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        tempLabel1.setText(String.valueOf(rev)+" RS");
        tempLabel1.setForeground(Color.WHITE);
        tempLabel1.setSize(200,50);
        tempLabel1.setLocation(10,90);
        tempPan4.add(tempLabel1);

        backBtn = new JButton();
        backBtn.setText("BACK");
        backBtn.setBackground(Color.red);
        backBtn.setForeground(Color.white);
        backBtn.setBounds(780, 150, 120, 30);
        backBtn.addActionListener(hnd);
        tempPan4.add(backBtn);

        JLabel backgm = new JLabel();
        backgm.setIcon(new ImageIcon("b1 (4).jpg"));
        backgm.setLayout(new BorderLayout());
        backgm.setSize(X_cor_Size - 200, Y_cor_Size - 450);
        backgm.setLocation(0, 0);
        tempPan4.add(backgm);

        revenue.add(tempPan4);
        revenue.setLocation(Loc_X_Cor_Fr, Loc_Y_Cor_Fr);
        revenue.setSize(X_cor_Size, Y_cor_Size);
        revenue.setVisible(true);
        revenue.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
    }
    public void generateMonthwiseRevenueFrame(String year)
    {
        mwRevenueFrame = new JFrame();
        mwRevenueFrame.setLayout(null);
        mwRevenueFrame.setTitle("Month Wise Revenue");
        
        int []rev =new int[12];
        rev[0]= bdao.monthlyRevenue(year, "1");
        rev[1]= bdao.monthlyRevenue(year, "2");
        rev[2]= bdao.monthlyRevenue(year, "3");
        rev[3]= bdao.monthlyRevenue(year, "4");
        rev[4]= bdao.monthlyRevenue(year, "5");
        rev[5]= bdao.monthlyRevenue(year, "6");
        rev[6]= bdao.monthlyRevenue(year, "7");
        rev[7]= bdao.monthlyRevenue(year, "8");
        rev[8]= bdao.monthlyRevenue(year, "9");
        rev[9]= bdao.monthlyRevenue(year, "10");
        rev[10]= bdao.monthlyRevenue(year, "11");
        rev[11]= bdao.monthlyRevenue(year, "12");
        
        JPanel temppan2 = new JPanel();
        temppan2.setLayout(null);
        temppan2.setLocation(0, 0);
        temppan2.setSize(200, 665);
        temppan2.setBackground(Color.BLACK);
        mwRevenueFrame.add(temppan2);
        
        
        
        JLabel bg5 = new JLabel();
        bg5.setIcon(new ImageIcon("Car3.jpg"));
        bg5.setLayout(new BorderLayout());
        bg5.setSize(254, 673);
        bg5.setLocation(0, 0);
        temppan2.add(bg5);
        mwRevenueFrame.add(temppan2);
        
        JPanel temppan1 = new JPanel();
        temppan1.setLayout(null);
        temppan1.setSize(920, Y_cor_Size);
        temppan1.setLocation(200, 0);
        
        JPanel picPanel = new JPanel();
        picPanel.setLocation(920/2+50,10);
        picPanel.setSize(300,100);
        picPanel.setBackground(new Color(0,0,0,5));
        picPanel.add(temppan1);
        
        JLabel tempbg7 = new JLabel();
        tempbg7.setIcon(new ImageIcon("pic1.png"));
        tempbg7.setLayout(new BorderLayout());
        tempbg7.setBackground(new Color(0,0,0,5));
        tempbg7.setSize(250, 80);
        tempbg7.setLocation(0, 0);
        picPanel.add(tempbg7);
        mwRevenueFrame.add(picPanel);
        
        JLabel headerlabel = new JLabel("Month Wise Revenue: ");
        headerlabel.setFont(new Font("Times New Roman", Font.BOLD, 35));
        headerlabel.setBounds(30,78, 450, 40);
        headerlabel.setForeground(Color.RED);
        temppan1.add(headerlabel);
        
        RoundedPanel tempRpanel = new RoundedPanel();
        tempRpanel.setLocation(30,100);
        tempRpanel.setSize(870,500);
        tempRpanel.setBackground(Color.BLACK);
        tempRpanel.setLayout(null);
        temppan1.add(tempRpanel);
        
        JLabel tempHeader1 = new JLabel();
        tempHeader1.setText("  January");
        tempHeader1.setForeground(Color.WHITE);
        tempHeader1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        tempHeader1.setBounds(10, 40, 100, 50);
        Border  b;
        b = BorderFactory.createLineBorder(new Color(150,0,0), 5);
        tempHeader1.setBorder(b);
        tempRpanel.add(tempHeader1);
        
        JLabel temprev1 = new JLabel();
        temprev1.setText(String.valueOf(rev[0])+" Rs.");
        temprev1.setForeground(Color.WHITE);
        temprev1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        temprev1.setBounds(170, 40, 100, 50);
        tempRpanel.add(temprev1);
        
        
        JLabel tempHeader2 = new JLabel();
        tempHeader2.setText("  February");
        tempHeader2.setForeground(Color.WHITE);
        tempHeader2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        tempHeader2.setBounds(400, 40, 100, 50);
        b = BorderFactory.createLineBorder(new Color(150,0,0), 5);
        tempHeader2.setBorder(b);
        tempRpanel.add(tempHeader2);
        
        JLabel temprev2 = new JLabel();
        temprev2.setText(String.valueOf(rev[1])+" Rs.");
        temprev2.setForeground(Color.WHITE);
        temprev2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        temprev2.setBounds(570, 40, 100, 50);
        tempRpanel.add(temprev2);
        
        JLabel tempHeader3 = new JLabel();
        tempHeader3.setText("   March");
        tempHeader3.setForeground(Color.WHITE);
        tempHeader3.setFont(new Font("Times New Roman", Font.BOLD, 20));
        tempHeader3.setBounds(10, 120, 100, 50);
        b = BorderFactory.createLineBorder(new Color(150,0,0), 5);
        tempHeader3.setBorder(b);
        tempRpanel.add(tempHeader3);
        
        JLabel temprev3 = new JLabel();
        temprev3.setText(String.valueOf(rev[2])+" Rs.");
        temprev3.setForeground(Color.WHITE);
        temprev3.setFont(new Font("Times New Roman", Font.BOLD, 20));
        temprev3.setBounds(170, 120, 100, 50);
        tempRpanel.add(temprev3);
        
        JLabel tempHeader4 = new JLabel();
        tempHeader4.setText("   April");
        tempHeader4.setForeground(Color.WHITE);
        tempHeader4.setFont(new Font("Times New Roman", Font.BOLD, 20));
        tempHeader4.setBounds(400, 120, 100, 50);
        b = BorderFactory.createLineBorder(new Color(150,0,0), 5);
        tempHeader4.setBorder(b);
        tempRpanel.add(tempHeader4);
        
        JLabel temprev4 = new JLabel();
        temprev4.setText(String.valueOf(rev[3])+" Rs.");
        temprev4.setForeground(Color.WHITE);
        temprev4.setFont(new Font("Times New Roman", Font.BOLD, 20));
        temprev4.setBounds(570, 120, 100, 50);
        tempRpanel.add(temprev4);
        
        JLabel tempHeader5 = new JLabel();
        tempHeader5.setText("    May");
        tempHeader5.setForeground(Color.WHITE);
        tempHeader5.setFont(new Font("Times New Roman", Font.BOLD, 20));
        tempHeader5.setBounds(10, 200, 100, 50);
        b = BorderFactory.createLineBorder(new Color(150,0,0), 5);
        tempHeader5.setBorder(b);
        tempRpanel.add(tempHeader5);
        
        JLabel temprev5 = new JLabel();
        temprev5.setText(String.valueOf(rev[4])+" Rs.");
        temprev5.setForeground(Color.WHITE);
        temprev5.setFont(new Font("Times New Roman", Font.BOLD, 20));
        temprev5.setBounds(170, 200, 100, 50);
        tempRpanel.add(temprev5);
        
        JLabel tempHeader6 = new JLabel();
        tempHeader6.setText("    June");
        tempHeader6.setForeground(Color.WHITE);
        tempHeader6.setFont(new Font("Times New Roman", Font.BOLD, 20));
        tempHeader6.setBounds(400, 200, 100, 50);
        b = BorderFactory.createLineBorder(new Color(150,0,0), 5);
        tempHeader6.setBorder(b);
        tempRpanel.add(tempHeader6);
        
        JLabel temprev6 = new JLabel();
        temprev6.setText(String.valueOf(rev[5])+" Rs.");
        temprev6.setForeground(Color.WHITE);
        temprev6.setFont(new Font("Times New Roman", Font.BOLD, 20));
        temprev6.setBounds(570, 200, 100, 50);
        tempRpanel.add(temprev6);
        
        
        JLabel tempHeader7 = new JLabel();
        tempHeader7.setText("    July");
        tempHeader7.setForeground(Color.WHITE);
        tempHeader7.setFont(new Font("Times New Roman", Font.BOLD, 20));
        tempHeader7.setBounds(10, 280, 100, 50);
        b = BorderFactory.createLineBorder(new Color(150,0,0), 5);
        tempHeader7.setBorder(b);
        tempRpanel.add(tempHeader7);
        
        JLabel temprev7 = new JLabel();
        temprev7.setText(String.valueOf(rev[6])+" Rs.");
        temprev7.setForeground(Color.WHITE);
        temprev7.setFont(new Font("Times New Roman", Font.BOLD, 20));
        temprev7.setBounds(170, 280, 100, 50);
        tempRpanel.add(temprev7);
        
        JLabel tempHeader8 = new JLabel();
        tempHeader8.setText("  August");
        tempHeader8.setForeground(Color.WHITE);
        tempHeader8.setFont(new Font("Times New Roman", Font.BOLD, 20));
        tempHeader8.setBounds(400, 280, 100, 50);
        b = BorderFactory.createLineBorder(new Color(150,0,0), 5);
        tempHeader8.setBorder(b);
        tempRpanel.add(tempHeader8);

        JLabel temprev8 = new JLabel();
        temprev8.setText(String.valueOf(rev[7])+" Rs.");
        temprev8.setForeground(Color.WHITE);
        temprev8.setFont(new Font("Times New Roman", Font.BOLD, 20));
        temprev8.setBounds(570, 280, 100, 50);
        tempRpanel.add(temprev8);
        
        JLabel tempHeader9 = new JLabel();
        tempHeader9.setText(" September");
        tempHeader9.setForeground(Color.WHITE);
        tempHeader9.setFont(new Font("Times New Roman", Font.BOLD, 17));
        tempHeader9.setBounds(10, 360, 100, 50);
        b = BorderFactory.createLineBorder(new Color(150,0,0), 5);
        tempHeader9.setBorder(b);
        tempRpanel.add(tempHeader9);
        
        JLabel temprev9 = new JLabel();
        temprev9.setText(String.valueOf(rev[8])+" Rs.");
        temprev9.setForeground(Color.WHITE);
        temprev9.setFont(new Font("Times New Roman", Font.BOLD, 20));
        temprev9.setBounds(170, 360, 100, 50);
        tempRpanel.add(temprev9);
        
        JLabel tempHeader10 = new JLabel();
        tempHeader10.setText(" October");
        tempHeader10.setForeground(Color.WHITE);
        tempHeader10.setFont(new Font("Times New Roman", Font.BOLD, 20));
        tempHeader10.setBounds(400, 360, 100, 50);
        b = BorderFactory.createLineBorder(new Color(150,0,0), 5);
        tempHeader10.setBorder(b);
        tempRpanel.add(tempHeader10);
        
        JLabel temprev10 = new JLabel();
        temprev10.setText(String.valueOf(rev[9])+" Rs.");
        temprev10.setForeground(Color.WHITE);
        temprev10.setFont(new Font("Times New Roman", Font.BOLD, 20));
        temprev10.setBounds(570, 360, 100, 50);
        tempRpanel.add(temprev10);
        
        JLabel tempHeader11 = new JLabel();
        tempHeader11.setText(" November");
        tempHeader11.setForeground(Color.WHITE);
        tempHeader11.setFont(new Font("Times New Roman", Font.BOLD, 18));
        tempHeader11.setBounds(10, 440, 100, 50);
        b = BorderFactory.createLineBorder(new Color(150,0,0), 5);
        tempHeader11.setBorder(b);
        tempRpanel.add(tempHeader11);
        
        JLabel temprev11 = new JLabel();
        temprev11.setText(String.valueOf(rev[10])+" Rs.");
        temprev11.setForeground(Color.WHITE);
        temprev11.setFont(new Font("Times New Roman", Font.BOLD, 20));
        temprev11.setBounds(170, 440, 100, 50);
        tempRpanel.add(temprev11);
        
        JLabel tempHeader12 = new JLabel();
        tempHeader12.setText("December");
        tempHeader12.setForeground(Color.WHITE);
        tempHeader12.setFont(new Font("Times New Roman", Font.BOLD, 20));
        tempHeader12.setBounds(400, 440, 100, 50);
        b = BorderFactory.createLineBorder(new Color(150,0,0), 5);
        tempHeader12.setBorder(b);
        tempRpanel.add(tempHeader12);
        
        JLabel temprev12 = new JLabel();
        temprev12.setText(String.valueOf(rev[11])+" Rs.");
        temprev12.setForeground(Color.WHITE);
        temprev12.setFont(new Font("Times New Roman", Font.BOLD, 20));
        temprev12.setBounds(570, 440, 100, 50);
        tempRpanel.add(temprev12);
        
        
        JLabel tempHeader13 = new JLabel();
        tempHeader13.setText("      Total Year Revenue");
        tempHeader13.setForeground(Color.WHITE);
        tempHeader13.setFont(new Font("Times New Roman", Font.BOLD, 20));
        tempHeader13.setBounds(10, Y_cor_Size-90, 250, 50);
        tempHeader13.setBorder(b);
        temppan1.add(tempHeader13);
        
        JLabel temprev13 = new JLabel();
        temprev13.setText(String.valueOf(bdao.YearlyRevenue(year))+" Rs.");
        temprev13.setForeground(Color.WHITE);
        temprev13.setFont(new Font("Times New Roman", Font.BOLD, 20));
        temprev13.setBounds(330, Y_cor_Size-90, 100, 50);
        temppan1.add(temprev13);
        
        closeBtn = new JButton();
        closeBtn.setText("Close");
        closeBtn.setBackground(Color.red);
        closeBtn.setForeground(Color.white);
        closeBtn.setBounds(780, Y_cor_Size-90, 120, 30);
        closeBtn.addActionListener(hnd);
        temppan1.add(closeBtn);

        
        
        JLabel tempbg6 = new JLabel();
        tempbg6.setIcon(new ImageIcon("b1 (4).jpg"));
        tempbg6.setLayout(new BorderLayout());
        tempbg6.setSize(920, Y_cor_Size);
        tempbg6.setLocation(0, 0);
        temppan1.add(tempbg6);
        
        mwRevenueFrame.add(temppan1);
        mwRevenueFrame.setLocation(Loc_X_Cor_Fr, Loc_Y_Cor_Fr);
        mwRevenueFrame.setSize(X_cor_Size, Y_cor_Size);
        mwRevenueFrame.setVisible(true);
        mwRevenueFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
