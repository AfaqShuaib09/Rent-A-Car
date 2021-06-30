
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
public class BookACarGUI {
    JFrame frame, popupframe,reciept; 
    JPanel pan1, pan2, pan3, pan4;
    RoundedPanel r, tempPan5;
    JButton backbtn, Addbtn;
    JTable jt;
    DefaultTableModel JTmodel;
    CarDAO Dao;
    BookingDAO bdao;
    JScrollPane sp;
    BookACarBtnHandler hnd;
    JLabel head, heading,MovingTagline;
    JButton close, pdf;
    JLabel label1, label2, label3, label4, label5, label6, label7, bg3;
    JLabel selLabel1, selLabel2, selLabel3, selLabel4, selLabel5, selLabel6, selLabel7, selLabel8;
    JLabel attr1,attr2,attr3,attr4,attr5,attr6,attr7,attr8;
    JTextField vin;
    //JTextField selVin, selMake, selM_year, selModel, selEno, selColor, selPdrent;
    int Loc_X_Cor_Fr = 0;
    int Loc_Y_Cor_Fr = 10;
    int X_cor_Size = 1138;
    int Y_cor_Size = 700;
    UserMenuGUI userGUI;

    public BookACarGUI(UserMenuGUI refg) {
        userGUI = refg;
        Dao = new CarDAO();
        bdao = new BookingDAO();
        initGUI();
    }

    public void initGUI() {
        frame = new JFrame();
        frame.setLayout(null);
        hnd = new BookACarBtnHandler(this, userGUI);

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
        pan1 = new JPanel();
        pan1.setLayout(new BorderLayout());
        pan1.setSize(920, 510);
        pan1.setLocation(200, 50);
        //pan1.setBackground(Color.BLUE);

        bg3 = new JLabel();
        bg3.setIcon(new ImageIcon("b1 (4).jpg"));
        bg3.setLayout(new BorderLayout());
        bg3.setSize(920, 510);
        bg3.setLocation(0, 0);
        bg3.setVisible(false);
        pan1.add(bg3);

        tempPan5 = new RoundedPanel();
        tempPan5.setLayout(null);
        tempPan5.setSize(350, 450);
        tempPan5.setLocation(480, 65);
        tempPan5.setBackground(Color.BLACK);
        frame.add(tempPan5);
        tempPan5.setVisible(false);

        JLabel bg4 = new JLabel();
        bg4.setIcon(new ImageIcon("i01_Car.png"));
        bg4.setLayout(new BorderLayout());
        bg4.setSize(100, 50);
        bg4.setLocation(240, 20);
        tempPan5.add(bg4);

        selLabel1 = new JLabel("Scheduling ID: ");
        selLabel1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        selLabel1.setBounds(30, 100, 200, 15);
        selLabel1.setForeground(Color.WHITE);
        tempPan5.add(selLabel1);
        
        attr1 = new JLabel(" *****");
        attr1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        attr1.setBounds(230, 100, 200, 15);
        attr1.setForeground(Color.WHITE);
        tempPan5.add(attr1);

        selLabel2 = new JLabel("Car_RegdNo: ");
        selLabel2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        selLabel2.setBounds(30, 150, 200, 15);
        selLabel2.setForeground(Color.WHITE);
        tempPan5.add(selLabel2);
        
        attr2 = new JLabel(" *****");
        attr2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        attr2.setBounds(230, 150, 200, 15);
        attr2.setForeground(Color.WHITE);
        tempPan5.add(attr2);

        selLabel3 = new JLabel("Make: ");
        selLabel3.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        selLabel3.setBounds(30, 200, 200, 15);
        selLabel3.setForeground(Color.WHITE);
        tempPan5.add(selLabel3);
        
        attr3 = new JLabel(" *****");
        attr3.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        attr3.setBounds(230, 200, 200, 15);
        attr3.setForeground(Color.WHITE);
        tempPan5.add(attr3);

        selLabel4 = new JLabel("Model: ");
        selLabel4.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        selLabel4.setBounds(30, 250, 200, 15);
        selLabel4.setForeground(Color.WHITE);
        tempPan5.add(selLabel4);
        
        attr4 = new JLabel(" *****");
        attr4.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        attr4.setBounds(230, 250, 200, 15);
        attr4.setForeground(Color.WHITE);
        tempPan5.add(attr4);
        

        selLabel5 = new JLabel("Schedule Start Date: ");
        selLabel5.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        selLabel5.setBounds(30, 300, 200, 15);
        selLabel5.setForeground(Color.WHITE);
        tempPan5.add(selLabel5);
        
        attr5 = new JLabel(" *****");
        attr5.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        attr5.setBounds(230, 300, 200, 15);
        attr5.setForeground(Color.WHITE);
        tempPan5.add(attr5);

        selLabel6 = new JLabel("Schedule End Date: ");
        selLabel6.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        selLabel6.setBounds(30, 350, 200, 15);
        selLabel6.setForeground(Color.WHITE);
        tempPan5.add(selLabel6);
        
        attr6 = new JLabel(" *****");
        attr6.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        attr6.setBounds(230, 350, 200, 15);
        attr6.setForeground(Color.WHITE);
        tempPan5.add(attr6);

        selLabel7 = new JLabel("Total Fare: ");
        selLabel7.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        selLabel7.setBounds(30, 400, 200, 15);
        selLabel7.setForeground(Color.WHITE);
        tempPan5.add(selLabel7);
        
        attr7 = new JLabel(" *****");
        attr7.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        attr7.setBounds(230, 400, 200, 15);
        attr7.setForeground(Color.WHITE);
        tempPan5.add(attr7);

        heading = new JLabel("Booking Details: ");
        heading.setFont(new Font("Times New Roman", Font.BOLD, 25));
        heading.setBounds(30, 20, 300, 30);
        heading.setForeground(Color.red);
        tempPan5.add(heading);

        Car[] tempCarArr = Dao.getAvailableCars(userGUI.sched_sd, userGUI.sched_ed);
        Vector<String[]> carData = new Vector<String[]>();
        for (int i = 0; i < tempCarArr.length; i++) {
            Vector<String> cur = new Vector<String>();
            cur.add(tempCarArr[i].getCar_Regd_id());
            cur.add(tempCarArr[i].getMake());
            cur.add(tempCarArr[i].getMake_year());
            cur.add(tempCarArr[i].getModel());
            cur.add(tempCarArr[i].getEngine_No());
            cur.add(tempCarArr[i].getColor());
            cur.add(tempCarArr[i].getPer_day_rent());
            String[] curArr = new String[cur.size()];
            cur.copyInto(curArr);
            carData.add(curArr);
        }
        String[][] carDataArr = new String[carData.size()][7];
        carData.copyInto(carDataArr);

        //heading
        String[] headings = {"Car_RegdID","Make", "Make_year","Model","Engine_No","Color","Per_Day_Rent"};

        JTmodel = new DefaultTableModel(carDataArr, headings);
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

        pan1.add(sp);
        frame.add(pan1);

        pan3 = new JPanel();
        pan3.setLocation(201, 550);
        pan3.setSize(X_cor_Size - 200, Y_cor_Size - 550);
        pan3.setLayout(null);
        pan3.setBackground(Color.BLACK);

        label1 = new JLabel();
        label1.setText("Car Regd_No: ");
        label1.setForeground(Color.red);
        label1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        label1.setBounds(10, 37, 150, 30);
        pan3.add(label1);

        vin = new JTextField();
        vin.setBounds(150, 30, 200, 35);
        vin.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        pan3.add(vin);

        backbtn = new JButton();
        backbtn.setText("Back");
        backbtn.setBackground(Color.red);
        backbtn.setForeground(Color.white);
        backbtn.setBounds(780, 55, 120, 30);
        BookACarBtnHandler hnd1 = new BookACarBtnHandler(this, userGUI);
        backbtn.addActionListener(hnd1);
        pan3.add(backbtn);

        Addbtn = new JButton();
        Addbtn.setText("Select");
        Addbtn.setBackground(Color.red);
        Addbtn.setForeground(Color.white);
        Addbtn.setBounds(650, 55, 120, 30);
        Addbtn.addActionListener(hnd);
        pan3.add(Addbtn);

        JLabel note = new JLabel();
        note.setText("* shows here necessary fields");
        note.setForeground(Color.red);
        note.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        note.setBounds(10, 135, 250, 10);
        pan3.add(note);

        JLabel backg = new JLabel();
        backg.setIcon(new ImageIcon("bg.png"));
        backg.setLayout(new BorderLayout());
        backg.setSize(X_cor_Size - 200, Y_cor_Size - 500);
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
    void recieptGeneration(Booking bk)
    {
      reciept = new JFrame();
      reciept.setTitle("Reciept");
      reciept.setLayout(null);
      RoundedPanel r2 = new RoundedPanel();
      r2.setLocation(25,105);
      r2.setSize(350,530);
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
      reciept.add(picPanel);
      
      JLabel bg5 = new JLabel();
      bg5.setIcon(new ImageIcon("i01_Car.png"));
      bg5.setLayout(new BorderLayout());
      bg5.setSize(100, 50);
      bg5.setLocation(240, 20);
      r2.add(bg5);
      
      lable1 = new JLabel("Booking ID: ");
      lable1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
      lable1.setBounds(20, 80, 200, 15);
      lable1.setForeground(Color.WHITE);
      r2.add(lable1);
      
      info1 = new JLabel(String.valueOf(bk.getBook_id()));
      info1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
      info1.setBounds(220, 80, 200, 15);
      info1.setForeground(Color.WHITE);
      r2.add(info1);
      
      lable2 = new JLabel("Username: ");
      lable2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
      lable2.setBounds(20, 130, 200, 15);
      lable2.setForeground(Color.WHITE);
      r2.add(lable2);
      
      info2 = new JLabel(bk.getUsername());
      info2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
      info2.setBounds(220, 130, 200, 15);
      info2.setForeground(Color.WHITE);
      r2.add(info2);
      
      lable3 = new JLabel("CNIC: ");
      lable3.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
      lable3.setBounds(20, 180, 200, 15);
      lable3.setForeground(Color.WHITE);
      r2.add(lable3);
      
      info3 = new JLabel(bk.getUser_Cnic());
      info3.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
      info3.setBounds(220, 180, 200, 15);
      info3.setForeground(Color.WHITE);
      r2.add(info3);
      
      lable4 = new JLabel("Car RegdNo: ");
      lable4.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
      lable4.setBounds(20, 230, 200, 15);
      lable4.setForeground(Color.WHITE);
      r2.add(lable4);
      
      info4 = new JLabel(bk.getVehicleID());
      info4.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
      info4.setBounds(220, 230, 200, 15);
      info4.setForeground(Color.WHITE);
      r2.add(info4);
      
      lable5 = new JLabel("Booking Start Date: ");
      lable5.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
      lable5.setBounds(20, 280, 200, 15);
      lable5.setForeground(Color.WHITE);
      r2.add(lable5);
      
      info5 = new JLabel(bk.getSched_StartDate());
      info5.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
      info5.setBounds(220, 280, 200, 15);
      info5.setForeground(Color.WHITE);
      r2.add(info5);
      
      lable6 = new JLabel("Booking End Date: ");
      lable6.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
      lable6.setBounds(20, 330, 200, 15);
      lable6.setForeground(Color.WHITE);
      r2.add(lable6);
      
      info6 = new JLabel(bk.getSched_EndDate());
      info6.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
      info6.setBounds(220, 330, 200, 15);
      info6.setForeground(Color.WHITE);
      r2.add(info6);
      
      lable7 = new JLabel("Total Fare: ");
      lable7.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
      lable7.setBounds(20, 380, 200, 15);
      lable7.setForeground(Color.WHITE);
      r2.add(lable7);
      
      info7 = new JLabel(bk.getFare());
      info7.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
      info7.setBounds(220, 380, 200, 15);
      info7.setForeground(Color.WHITE);
      r2.add(info7);
      
      headerReciept = new JLabel("Booking Details: ");
      headerReciept.setFont(new Font("Times New Roman", Font.BOLD, 35));
      headerReciept.setBounds(20,93, 350, 40);
      headerReciept.setForeground(Color.RED);
      reciept.add(headerReciept);
      
      MovingTagline = new JLabel();
      MovingTagline.setText("Serves You First");
      MovingTagline.setFont(new Font("Algerian", Font.PLAIN, 30));
      MovingTagline.setBounds(30,410, 290, 35);
      MovingTagline.setForeground(Color.RED);
      r2.add(MovingTagline);
      
     close = new JButton();
     close.setText("Close");
     close.setBackground(Color.red);
     close.setForeground(Color.white);
     close.setBounds(10, 480, 150, 30);
     close.addActionListener(hnd);
     r2.add(close);
      
     pdf = new JButton();
     pdf.setText("Save as PDF");
     pdf.setBackground(Color.red);
     pdf.setForeground(Color.white);
     pdf.setBounds(180, 480, 150, 30);
     pdf.addActionListener(hnd);
     r2.add(pdf);
     
      reciept.add(r2);
      
      JLabel backg1 = new JLabel();
      backg1.setIcon(new ImageIcon("b1 (2).jpg"));
      backg1.setLayout(new BorderLayout());
      backg1.setSize(410,700);
      backg1.setLocation(0, 0);
      //backg1.add(picPanel);
      reciept.add(backg1);
      
      reciept.setLocation(200,30);
      reciept.setSize(410,700);
      reciept.setVisible(true);
      //moveText();
    }
    public void sleepForaWhile() {
        try {
            Thread.sleep(25);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    public void moveText()
    {
        int inc = 0;
        int count = 0;
        do{
        while (MovingTagline.getLocation().getX() + MovingTagline.getSize().getWidth() < 403) {
            sleepForaWhile();
            MovingTagline.setLocation(inc, 410);
            inc += 2;
        }
        inc-=2;
        while (MovingTagline.getLocation().getX() + MovingTagline.getSize().getWidth() !=MovingTagline.getSize().getWidth())
        {
            sleepForaWhile();
            MovingTagline.setLocation(inc, 410);
            inc -= 2;
        }
        }while(true);
    }
    public void Generatereciept(Booking bk)
    {
       new Thread(() -> {
            recieptGeneration(bk);
            moveText();
        }).start();
    }
}    

