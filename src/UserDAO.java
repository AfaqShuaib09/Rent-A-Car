
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
public class UserDAO {

    Connection con;
    Statement stat;
    ResultSet rs;

    public UserDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rent_a_car", "root", "");
            System.out.println("Ddatabase connected!");
            stat = con.createStatement();
        } catch (Exception ex) {
            System.out.println("User Database Connection failure!");
            System.exit(1);
        }
    }

    public void InsertUser(String username, String password, String CNIC, String Gender, String Phone) {
        //insert data to database (expecting only valid data)
        boolean flag = false;
        try {
            flag = stat.execute("INSERT INTO users VALUES ('" + username + "', '" + password + "', '" + CNIC + "','" + Gender + "','" + Phone + "');");
            if (flag) {
                System.out.println("User SignUp Succesfully");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    public int SearchUser(String usr,String pass)
    {
      String count = "";
        try {
            rs = stat.executeQuery("select count(*) from users where password = '"+ pass +"' and username = '" + usr + "';");
            while (rs.next()) {
                count = (rs.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        int i = Integer.parseInt(count);
        return i;
    }
    public int SearchAdmin(String usr,String pass)
    {
      String count = "";
        try {
            rs = stat.executeQuery("select count(*) from admin where password = '"+ pass +"' and username = '" + usr + "';");
            while (rs.next()) {
                count = (rs.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        int i = Integer.parseInt(count);
        return i;
    }
    public String getCNICOfAdmin(String username)
    {
        try {
            rs = stat.executeQuery("SELECT CNIC FROM admin WHERE username = '" + username + "';");
            rs.next();
            return rs.getString(1);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    public String getCNICOfUser(String username)
    {
        try {
            rs = stat.executeQuery("SELECT CNIC FROM users WHERE username = '" + username + "';");
            rs.next();
            return rs.getString(1);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    public void InsertAdmin(String username, String password, String CNIC, String Gender, String Phone) {
        //insert data to database (expecting only valid data)
        boolean flag = false;
        try {
            flag = stat.execute("INSERT INTO admin VALUES ('" + username + "', '" + password
                    + "', '" + CNIC + "','" + Gender + "','" + Phone + "');");
            if (flag) {
                System.out.println("User SignUp Succesfully");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean DeleteAdmin(String username, String password) {
        //insert data to database (expecting only valid data)
        boolean flag = false;
        try {
            flag = stat.execute("Delete from admin where username = '" + username + "' and  password ='" + password + "';");
            if (flag) {
                System.out.println("Deleted Succesfully");
                return flag;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return flag;
    }

    public boolean DeleteUser(String username, String password) {
        //insert data to database (expecting only valid data)
        boolean flag = false;
        try {
            flag = stat.execute("Delete from users where username = '" + username + "' and  password ='" + password + "';");
            if (flag) {
                System.out.println("User Deleted Succesfully");
            }
            return flag;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return flag;
    }

    public void DatabaseConnectionFailure() {
        JFrame frame = new JFrame();
        frame.setTitle("DataBase Error");
        frame.setIconImage(new ImageIcon("Picture.png").getImage());
        frame.setSize(200, 200);
        frame.setLocationRelativeTo(null);
        JLabel msg = new JLabel("ERROR: No Database Found!", SwingConstants.CENTER);
        msg.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
        frame.add(msg);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        try {
            Thread.sleep(2500);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public boolean isUserAlreadyExist(String username) {
        try {
            rs = stat.executeQuery("SELECT username FROM users WHERE username = '" + username + "';");
            return rs.next();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean isAdminAlreadyExist(String username) {
        try {
            rs = stat.executeQuery("SELECT username FROM admin WHERE username = '" + username + "';");
            return rs.next();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean SearchFromUser(String username, String Password) {
        try {
            rs = stat.executeQuery("SELECT username FROM users WHERE username = '" + username + "' and password ='" + Password + "' ;");
            return rs.next();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean SearchFromAdmin(String username, String Password) {
        try {
            rs = stat.executeQuery("SELECT username FROM admin WHERE username = '" + username + "' and password ='" + Password + "' ;");
            return rs.next();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
