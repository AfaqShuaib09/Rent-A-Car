
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
public class UserAvailableCarsGUI {
    JFrame frame, popupframe,reciept; 
    JPanel pan1, pan2, pan3, pan4;
    RoundedPanel r, tempPan5;
    JButton backbtn, Addbtn;
    JTable jt;
    DefaultTableModel JTmodel;
    CarDAO Dao;
    BookingDAO bdao;
    JScrollPane sp;
    UserAvailableCarsBtnHandler hnd;
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

    public UserAvailableCarsGUI(UserMenuGUI refg) {
        userGUI = refg;
        Dao = new CarDAO();
        bdao = new BookingDAO();
        initGUI();
    }

    public void initGUI() {
        frame = new JFrame();
        frame.setLayout(null);
        hnd = new UserAvailableCarsBtnHandler(this, userGUI);

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
       
        pan2.setBorder(BorderFactory.createLineBorder(Color.red));
        pan2.add(bg);
        
        pan1 = new JPanel();
        pan1.setLayout(new BorderLayout());
        pan1.setSize(920, 510);
        pan1.setLocation(200, 50);
        //pan1.setBackground(Color.BLUE);

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

        jt.setBounds(30, 40, 920, 700);
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
}
