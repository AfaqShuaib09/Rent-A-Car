/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Afaq
 */
public class Car {
   private String Car_Regd_id;
   private String make;
   private String make_year;
   private String model;
   private String Engine_No;
   private String Color;
   private String per_day_rent;
   
   Car()
   {
     this.Car_Regd_id="";
     this.make="";
     this.make_year="";
     this.model="";
     this.Engine_No="";
     this.Color="";
     this.per_day_rent="";
   }
   Car(String r_id,String mk,String m_year,String mdl,String eno, String color,String pdrent)
   {
     this.Car_Regd_id=r_id;
     this.make=mk;
     this.make_year=m_year;
     this.model=mdl;
     this.Engine_No=eno;
     this.Color= color;
     this.per_day_rent= pdrent;
   }

    public void setCar_Regd_id(String Car_Regd_id) {
        this.Car_Regd_id = Car_Regd_id;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setMake_year(String make_year) {
        this.make_year = make_year;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setEngine_No(String Engine_No) {
        this.Engine_No = Engine_No;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public void setPer_day_rent(String per_day_rent) {
        this.per_day_rent = per_day_rent;
    }

    public String getCar_Regd_id() {
        return Car_Regd_id;
    }

    public String getColor() {
        return Color;
    }

    public String getMake() {
        return make;
    }

    public String getMake_year() {
        return make_year;
    }

    public String getEngine_No() {
        return Engine_No;
    }

    public String getModel() {
        return model;
    }

    public String getPer_day_rent() {
        return per_day_rent;
    }
   }
