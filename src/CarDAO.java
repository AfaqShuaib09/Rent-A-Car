
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Afaq
 */
public class CarDAO {

    Connection con;
    Statement stat;
    ResultSet rs;

    public CarDAO() {
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

    public void AddCar(String VIN, String Make, String MakeYear, String Model, String Engine_no, String Color, String perday_rent) {
        //insert data to database (expecting only valid data)
        boolean flag = false;
        try {
            flag = stat.execute("INSERT INTO cars VALUES('" + VIN + "', '" + Make + "', '" + MakeYear + "','" + Model + "','" + Engine_no + "','" + Color + "','" + perday_rent + "');");
            if (flag) {
                System.out.println("Added Successfully");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public boolean isCarAlreadyExist(String r_id) {
        try {
            rs = stat.executeQuery("SELECT Car_RegdNo FROM cars WHERE Car_RegdNo = '" + r_id + "';");
            return rs.next();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    public DefaultTableModel getCarRemovalView() {
        String count = "";
        try {
            rs = stat.executeQuery("select count(*) from cars");
            while (rs.next()) {
                count = (rs.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        String[][] str;
        int i = Integer.parseInt(count);
        String[][] data = null;
        String[] heading = null;
        try {
            rs = stat.executeQuery("select Car_RegdNo, Make,Model,Per_day_rent from cars");
            int colcount = rs.getMetaData().getColumnCount();
            data = new String[i][colcount];
            heading = new String[colcount];
            for (int k = 0; k < colcount; k++) {
                heading[k] = rs.getMetaData().getColumnName(k + 1);
                System.out.println(heading[k]);
            }
            int cnt = 0;
            while (rs.next()) {
                for (int m = 0; m < colcount; m++) {
                    data[cnt][m] = rs.getString(m + 1);
                    System.out.println(data[cnt][m]);
                }
                cnt++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        DefaultTableModel tempModel = new DefaultTableModel(data, heading);
        return tempModel;
    }
    public DefaultTableModel searchRecord(String regd) {
        String count="";
        try {
            rs = stat.executeQuery("SELECT Car_RegdNo FROM cars WHERE Car_RegdNo = '" + regd + "';");
            if(rs.next())
                 count = "1";
            else if(!rs.next())
                count="0";
        } catch (SQLException ex) {
            Logger.getLogger(CarDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[][] str;
        int i = Integer.parseInt(count);
        String[][] data = null;
        String[] heading = null;
        try {
            rs = stat.executeQuery("select * from cars where Car_RegdNo= = '" + regd + "';");
            int colcount = rs.getMetaData().getColumnCount();
            data = new String[i][colcount];
            heading = new String[colcount];
            for (int k = 0; k < colcount; k++) {
                heading[k] = rs.getMetaData().getColumnName(k + 1);
                System.out.println(heading[k]);
            }
            int cnt = 0;
            while (rs.next()) {
                for (int m = 0; m < colcount; m++) {
                    data[cnt][m] = rs.getString(m + 1);
                    System.out.println(data[cnt][m]);
                }
                cnt++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        DefaultTableModel tempModel = new DefaultTableModel(data, heading);
        return tempModel;
    }
    public DefaultTableModel DisplayUserData() {
        String count = "";
        try {
            rs = stat.executeQuery("select count(*) from cars");
            while (rs.next()) {
                count = (rs.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        String[][] str;
        int i = Integer.parseInt(count);
        String[][] data = null;
        String[] heading = null;
        try {
            rs = stat.executeQuery("select * from cars");
            int colcount = rs.getMetaData().getColumnCount();
            data = new String[i][colcount];
            heading = new String[colcount];
            for (int k = 0; k < colcount; k++) {
                heading[k] = rs.getMetaData().getColumnName(k + 1);
                System.out.println(heading[k]);
            }
            int cnt = 0;
            while (rs.next()) {
                for (int m = 0; m < colcount; m++) {
                    data[cnt][m] = rs.getString(m + 1);
                    System.out.println(data[cnt][m]);
                }
                cnt++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        DefaultTableModel tempModel = new DefaultTableModel(data, heading);
        return tempModel;
    }
    public int getScheduleCount(String regd)
    {
       int i=0;
       try {
            rs = stat.executeQuery("select count(*) from bookings where Car_RegdNo= '" + regd + "' and CURDATE()<bookings.bk_enddate");
            rs.next();
            i= Integer.parseInt(rs.getString(1));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       return i;
    }
    public int getPerdayRent(String vehid)
    {
       int i=0;
       try {
            rs = stat.executeQuery("select per_day_rent from cars where Car_RegdNo= '" + vehid + "';");
            rs.next();
            i= Integer.parseInt(rs.getString(1));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       return i;
    }
    public boolean removeCar(String regid)
    {
        boolean flag=false;
        try {
            flag = stat.execute("Delete from Cars where Car_RegdNo= '" + regid + "';");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (flag) {
                System.out.println("Record Removed Successfully");
    }
        return flag;
    }
    public Car getCarDetails(String regdid)
    {
       Car car = new Car();
        try {
            rs = stat.executeQuery("select * from cars where Car_RegdNo= '" + regdid + "';");
            rs.next();
            Car tempCar = new Car(
                        rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7));
            car= tempCar;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       return car;
    }
    public Booking[] getBookingsOfUser(String usrname) {
        Vector<Booking> BookArr = new Vector<Booking>();
        try {
            rs = stat.executeQuery("SELECT * FROM bookings where username = '" + usrname + "';");
            while (rs.next()) {
                Booking tempBooking = new Booking(
                        rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7)
                );
                BookArr.add(tempBooking);
            }
            System.out.println("");
        } catch (SQLException ex) {
            Logger.getLogger(BookingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        Booking[] returnArr = new Booking[BookArr.size()];
        BookArr.copyInto(returnArr);
        return returnArr;
    }
    public Car[] getAvailableCars(String startDate, String endDate) {
        Vector<Car> carArr = new Vector<Car>();
        try {
            rs = stat.executeQuery("SELECT * FROM cars where car_regdno not in (SELECT cars.car_regdno FROM cars join bookings on cars.car_regdno=bookings.car_regdno "
                    + "where str_to_date('" + startDate + "', '%d-%m-%y') < bookings.bk_enddate OR "
                    + "str_to_date('" + endDate + "', '%d-%m-%y') > bookings.bk_startdate)");
            while (rs.next()) {
                Car tempCar = new Car(
                        rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7)
                );
                carArr.add(tempCar);
            }
            System.out.println("");
        } catch (SQLException ex) {
            Logger.getLogger(BookingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        Car[] returnArr = new Car[carArr.size()];
        carArr.copyInto(returnArr);
        return returnArr;
    }
}
