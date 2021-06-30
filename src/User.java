/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Afaq
 */
public class User {
    private String username;
    private String Password;
    private String CNIC;
    private String Gender;
    private String Phno;
    
    User()
    {
      this.username = "";
      this.Password = "";
      this.Phno = "";
      this.CNIC= "";
      this.Gender="";
    }
    User(String usr,String pass,String cnic, String phno, String gen)
    {
      this.username = usr;
      this.Password = pass;
      this.Phno = phno;
      this.CNIC= cnic;
      this.Gender=gen;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setCNIC(String CNIC) {
        this.CNIC = CNIC;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public void setPhno(String Phno) {
        this.Phno = Phno;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return Password;
    }

    public String getCNIC() {
        return CNIC;
    }

    public String getGender() {
        return Gender;
    }

    public String getPhno() {
        return Phno;
    }
    
}
