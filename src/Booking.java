/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Afaq
 */
public class Booking {
   private int book_id;
   private String username;
   private String user_Cnic;
   private String vehicleID;
   private String Sched_StartDate;
   private String Sched_EndDate;
   private String Fare;
    
   Booking()
   {
     this.book_id=-1;
     username = "";
     user_Cnic="";
     vehicleID="";
     Sched_StartDate="";
     Sched_EndDate="";
     Fare="";
   }
   Booking(int id,String usr,String cnic,String vehID,String Sched_sd,String Sched_ed, String fare)
   {
     this.book_id=id;
     this.username=usr;
     this.user_Cnic=cnic;
     this.vehicleID=vehID;
     this.Sched_StartDate= Sched_sd;
     this.Sched_EndDate= Sched_ed;
     this.Fare= fare;
   }

    public int getBook_id() {
        return book_id;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public String getUsername() {
        return username;
    }

    public String getUser_Cnic() {
        return user_Cnic;
    }

    public String getSched_StartDate() {
        return Sched_StartDate;
    }

    public String getSched_EndDate() {
        return Sched_EndDate;
    }

    public String getFare() {
        return Fare;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUser_Cnic(String user_Cnic) {
        this.user_Cnic = user_Cnic;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public void setSched_StartDate(String Sched_StartDate) {
        this.Sched_StartDate = Sched_StartDate;
    }

    public void setSched_EndDate(String Sched_EndDate) {
        this.Sched_EndDate = Sched_EndDate;
    }

    public void setFare(String Fare) {
        this.Fare = Fare;
    } 

    void setFare(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

