
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class BookingDAO {

    Connection con;
    Statement stat;
    ResultSet rs;

    public BookingDAO() {
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
    public boolean updateBookingStartDate(String StartDate, int id)
    {
       boolean flag=false;
        try {
            flag = stat.execute("Update bookings set bk_StartDate = '" + StartDate + "' where booking_id= " + id + " ;");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (flag) {
                System.out.println("Record Modified Successfully");
    }
        return flag;
    }
    public boolean updateBookingRent(String Fare,int id)
    {
       boolean flag=false;
        try {
            flag = stat.execute("Update bookings set Total_Rent = '" + Fare + "' where booking_id= " + id + " ;");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (flag) {
                System.out.println("Record Modified Successfully");
    }
        return flag;
    }
    public boolean updateBookingEndDate(String EndDate, int id)
    {
       boolean flag=false;
        try {
            flag = stat.execute("Update bookings set bk_EndDate = '" + EndDate + "' where booking_id= " + id + " ;");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (flag) {
                System.out.println("Record Modified Successfully");
    }
        return flag;
    }
    public int countNumberOfBookingsbwDates(int id,String startDate,String EndDate,String vehid)
    {
       String count = "";
        try {
            rs = stat.executeQuery("select count(*) from bookings where (('" + startDate + "' <= bk_startdate AND '" + EndDate + "' >= bk_startdate) or ('" + startDate + "' <= bk_enddate AND '" + EndDate + "' >= bk_enddate)) and Car_regdNo= '" + vehid + "' and booking_id != " + id + ";");
            while (rs.next()) {
                count = (rs.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        int i = Integer.parseInt(count);
        return i;
    }
    public Booking book(String username, String CNIC, String carRegNo, String startDate,
            String endDate, String totalFare) {
        Booking bk = null;
        //insert data to database (expecting only valid data)
        try {
            //rs = stat.executeQuery("SELECT COUNT(*) FROM bookings;");
            rs = stat.executeQuery("SELECT max(Booking_ID) FROM bookings;");
            rs.next();
            int curID = (rs.getInt(1) + 1);
            stat.execute("INSERT INTO bookings VALUES (" + curID + ", '" + username + "', '" + CNIC + "', '" + carRegNo + "', str_to_date('"
                    + startDate + "','%Y-%m-%d'), str_to_date('" + endDate + "','%Y-%m-%d'), '" + totalFare + "'*(str_to_date('" + endDate + "','%Y-%m-%d')-str_to_date('" + startDate + "','%Y-%m-%d')));");
            bk = new Booking(curID,username,CNIC,carRegNo,startDate,endDate,totalFare);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return bk;
    }
    public int diffbwDates(String start,String end)
    {
        try {
            rs = stat.executeQuery("SELECT DATEDIFF('"+end+"', '"+start+"');");
            rs.next();
            int diff =rs.getInt(1);
            System.out.println(diff);
            return diff;
            //return diff;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }
    public int diffWithCurDate(String date)
    {
        try {
            rs = stat.executeQuery("SELECT DATEDIFF('"+date+"', DATE_FORMAT(CURDATE(), '%y-%m-%d'));");
            rs.next();
            int diff =rs.getInt(1);
            System.out.println(diff);
            return diff;
            //return diff;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }
    //str_to_date('" + startDate + "', '%d-%m-%y')
    
    public boolean delete_booking(int id)
    {
       boolean flag=false;
        try {
            flag = stat.execute("Delete from bookings where Booking_ID = " + id + ";");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (flag) {
                System.out.println("Record Removed Successfully");
    }
        return flag;
    }
    public Booking getBooking(int id)
    {
       Booking bk = new Booking();
        try {
            rs = stat.executeQuery("select * from bookings where Booking_ID = " + id + ";");
            rs.next();
            Booking tempBooking = new Booking(
                        Integer.parseInt(rs.getString(1)), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7));
            bk= tempBooking;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       return bk;
    }
    public int GetCommingUpBookingsCountOfUser(String usr)
    {
      String count = "";
        try {
            rs = stat.executeQuery("select count(*) from bookings where curDate()< bk_startdate and username = '" + usr + "';");
            while (rs.next()) {
                count = (rs.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        int i = Integer.parseInt(count);
        return i;
    }
    public DefaultTableModel GetComingUpBookingsOfUser(String usrname)
    {
       String count = "";
        try {
            rs = stat.executeQuery("select count(*) from bookings where curDate()< bk_startdate and username = '" + usrname + "';");
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
            rs = stat.executeQuery("select booking_id,Car_RegdNo, bk_startdate,bk_enddate, Total_Rent from bookings where curDate()< bk_startdate and username = '" + usrname + "';");
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
    public int GetOnWayBookingsCount()
    {
      String count = "";
        try {
            rs = stat.executeQuery("select count(*) from bookings where curDate()< bk_enddate and curDate()>= bk_startdate");
            while (rs.next()) {
                count = (rs.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        int i = Integer.parseInt(count);
        return i;
    }
    public DefaultTableModel GetPreviousBookings()
    {
       String count = "";
        try {
            rs = stat.executeQuery("select count(*) from bookings where curDate()> bk_startdate and curDate()> bk_enddate");
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
            rs = stat.executeQuery("select * from bookings where curDate()> bk_startdate and curDate()> bk_enddate");
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
    public String GetCurrentDateAndTime()
    {
      String time = "";
        try {
            //rs = stat.executeQuery("Select DATE_FORMAT(bk_startDate, '%y') from bookings");
            rs = stat.executeQuery("Select SYSDATE() from dual");
            while (rs.next()) {
                time = (rs.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return time;
    }
    public int getBookingsCountofYear(String year)
    {
       String count = "";
        try {
            rs = stat.executeQuery("select count(*) from bookings where DATE_FORMAT(bk_startDate, '%y') = SUBSTRING('" + year + "',3,2);");
            while (rs.next()) {
                count = (rs.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        int i = Integer.parseInt(count);
        return i;
    }
    public int getBookingsCountofUser(String usrname)      
    {
       String count = "";
        try {
            rs = stat.executeQuery("SELECT count(*) FROM bookings where username = '" + usrname + "';");
            while (rs.next()) {
                count = (rs.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        int i = Integer.parseInt(count);
        return i;
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
    public int getBookingsCountofMonth(String year,String month)
    {  
       if(month.length()==1)
           month="0"+month;
       String monyear = year+"-"+month;
       String count = "";
        try {
            rs = stat.executeQuery("select count(*) from bookings where DATE_FORMAT(bk_startDate, '%y-%m') = SUBSTRING('" + monyear + "',3);");
            while (rs.next()) {
                count = (rs.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        int i = Integer.parseInt(count);
        return i;
    }
    public DefaultTableModel getAllBookingsOfMonth(String year,String month)
    {
        if(month.length()==1)
           month="0"+month;
        String monyear =year+"-"+month;   
        String count = "";
        try {
            rs = stat.executeQuery("select count(*) from bookings where DATE_FORMAT(bk_startDate, '%y-%m') = SUBSTRING('" + monyear + "',3);");
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
            rs = stat.executeQuery("select * from bookings where DATE_FORMAT(bk_startDate, '%y-%m') = SUBSTRING('" + monyear + "',3);");
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
    public DefaultTableModel getAllBookingsOfYear(String year)
    {
        String count = "";
        try {
            rs = stat.executeQuery("select count(*) from bookings where DATE_FORMAT(bk_startDate, '%y') = SUBSTRING('" + year + "',3);");
            while (rs.next()) {
                count = (rs.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        String[][] str;
        int i = Integer.parseInt(count);
        System.out.println(i);
        String[][] data = null;
        String[] heading = null;
        try {
            rs = stat.executeQuery("select * from bookings where DATE_FORMAT(bk_startDate, '%y') = SUBSTRING('" + year + "',3);");
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
    public DefaultTableModel GetOnWayBookings()
    {
       String count = "";
        try {
            rs = stat.executeQuery("select count(*) from bookings where curDate()< bk_enddate and curDate()>= bk_startdate");
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
            rs = stat.executeQuery("select * from bookings where curDate()< bk_enddate and curDate()>= bk_startdate");
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
    public int GetPreviousBookingsCount()
    {
      String count = "";
        try {
            rs = stat.executeQuery("select count(*) from bookings where curDate()> bk_startdate and curDate()> bk_enddate");
            while (rs.next()) {
                count = (rs.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        int i = Integer.parseInt(count);
        return i;
    }
    public int GetComingUpBookingsCount()
    {
      String count = "";
        try {
            rs = stat.executeQuery("select count(*) from bookings where curDate()< bk_startdate");
            while (rs.next()) {
                count = (rs.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        int i = Integer.parseInt(count);
        return i;
    }
    public DefaultTableModel GetComingUpBookings()
    {
       String count = "";
        try {
            rs = stat.executeQuery("select count(*) from bookings where curDate()< bk_startdate");
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
            rs = stat.executeQuery("select * from bookings where curDate()< bk_startdate");
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
    
    public DefaultTableModel getAllBookings()
    {
      String count = "";
        try {
            rs = stat.executeQuery("select count(*) from bookings");
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
            rs = stat.executeQuery("select * from bookings");
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
    
    public boolean isBookingExist(String book_id)
    {
        try {
            rs = stat.executeQuery("SELECT Booking_ID FROM bookings WHERE Booking_ID = '" + book_id + "';");
            return rs.next();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    public int getMaxBookID(){
        int maxID =0;
        try {
            rs = stat.executeQuery("Select max(Booking_ID) from bookings;");
            rs.next();
            maxID= (rs.getInt(1));
            return maxID;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return maxID;
    }
    public void searchBookingOnUsername(String Username)
    {
      //write logic here
    }
    public int monthlyRevenue(String year,String month)
    {
        int total_rent=0;
       if(month.length()==1)
           month="0"+month;
        String monyear =year+"-"+month;   
        String count = "";
        try {
            rs = stat.executeQuery("select count(*) from bookings where DATE_FORMAT(bk_startDate, '%y-%m') = SUBSTRING('" + monyear + "',3);");
            while (rs.next()) {
                count = (rs.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        String[][] str;
        int i = Integer.parseInt(count);
        //System.out.println(i);
        String[][] data = null;
        try {
            rs = stat.executeQuery("select * from bookings where DATE_FORMAT(bk_startDate, '%y-%m') = SUBSTRING('" + monyear + "',3);");
            int colcount = rs.getMetaData().getColumnCount();
            int cnt = 0;
            while (rs.next()) {
                for (int m = colcount-1; m < colcount; m++) {
                    if(m ==colcount-1)
                        total_rent += Integer.parseInt(rs.getString(colcount));
                }
                cnt++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return total_rent;
    }
    public int YearlyRevenue(String year)
    {
        int total_rent=0;
        String count = "";
        try {
            rs = stat.executeQuery("select count(*) from bookings where DATE_FORMAT(bk_startDate, '%y') = SUBSTRING('" + year + "',3);");
            while (rs.next()) {
                count = (rs.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        String[][] str;
        int i = Integer.parseInt(count);
        String[][] data = null;
        try {
            rs = stat.executeQuery("select * from bookings where DATE_FORMAT(bk_startDate, '%y') = SUBSTRING('" + year + "',3);");
            int colcount = rs.getMetaData().getColumnCount();
            int cnt = 0;
            while (rs.next()) {
                for (int m = colcount-1; m < colcount; m++) {
                    if(m ==colcount-1)
                        total_rent += Integer.parseInt(rs.getString(colcount));
                }
                cnt++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return total_rent;
    }
    public boolean unbook(int bookingID) {
        //insert data to database (expecting only valid data)
        try {
            rs = stat.executeQuery("SELECT bk_enddate from bookings where bk_enddate < sysdate() AND booking_id = " + bookingID);
            if (rs.next()) {
                stat.execute("DELETE FROM bookings where booking_ID = " + bookingID + ";");
                return true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
    

//    public static void main(String[] args) {
//        BookingDAO b = new BookingDAO();
//        b.unbook(1);
//    }
}
