
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
public class SignUpBtnHandler implements ActionListener{
    SignUpGUI refg;
    public SignUpBtnHandler(SignUpGUI g){
        refg = g;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Sign In"))
        {
            refg.frame.dispose();
            SignInGUI signIn=new SignInGUI();
        }
        if(e.getActionCommand().equals("Sign Up"))
        {
            refg.fillUser();
            if (refg.user.getUsername().length() == 0 || refg.user.getPassword().length() == 0|| 
                    refg.user.getCNIC().length()==0)
            {
               refg.DisplayErrorMessage("Sign Up Error Neccessary Fields Empty");
               return;
            }
            else if (refg.user.getUsername().length() < 5 || refg.user.getPassword().length() < 3|| 
                    refg.user.getCNIC().length()!=15)
            {
                if(refg.user.getUsername().length() < 5)
                {
                    refg.DisplayErrorMessage("Username Must be Atleast of 5 Characters");
                    return;
                }
                else if(refg.user.getPassword().length() < 3)
                {
                    refg.DisplayErrorMessage("Password Must be Atleast of 3 Characters");
                    refg.password.setText("");
                    return;
                }
                else if(refg.user.getCNIC().length()!=15)
                {
                    refg.DisplayErrorMessage("       CNIC Number is of 15 characters");
                    return;
                }
            }
            if(refg.user.getPassword().length()>15)
            {
                refg.DisplayErrorMessage("       Password can be max of 15 character");
                    return;
            }
            char ch= refg.user.getUsername().charAt(0);
            if(!Pattern.matches("[a-zA-z]", String.valueOf(ch)))
            {
              refg.DisplayErrorMessage("    Intial letter of username must be Alpha");
               return;
            }
            boolean flag=Pattern.matches("^[a-zA-z][^&%$(){}?<<>;:/.]{4,19}", refg.user.getUsername());
            if(!flag)
            {
               refg.DisplayErrorMessage("Invalid Format of username Special Characters Not Allowed");
               return;
            }
            boolean flag1 = Pattern.matches("^\\d{4}-\\d{7}", refg.user.getPhno());
            if (!(flag1) && refg.user.getPhno().length()>0)
            {
               refg.DisplayErrorMessage("           Invalid Fmt: 03XX-XXXXXXX");
               return;
            }
            boolean flag2 = Pattern.matches("^\\d{5}-\\d{7}-\\d{1}", refg.user.getCNIC());
            if (!(flag2))
            {
               refg.DisplayErrorMessage("Invalid Fmt CNIC: XXXXX-XXXXXXX-X");
               return;
            }
            if(refg.usercheckBox1.isSelected()|| refg.usercheckBox2.isSelected())
            {
                if(refg.usercheckBox1.isSelected()&&refg.usercheckBox2.isSelected())
                {
                      refg.DisplayErrorMessage("Only 1 CheckBox Should be Selected");
                      return;
                }
                if (refg.usercheckBox2.isSelected()) //normal User  
                {
                    
                    if (!refg.DAO.isUserAlreadyExist(refg.user.getUsername())) {
                       refg.DAO.InsertUser(refg.user.getUsername(), refg.user.getPassword(),refg.user.getCNIC(),
                        refg.user.getGender(),refg.phField.getText());
                        resetToDefault();
                        refg.DisplayErrorMessage("                  Sign Up Successfully");
                    }
                }
               else if (refg.usercheckBox1.isSelected())  //Admuin User
               {
                   
                refg.AdminConfirmation();    
              } 
            }
            else if(!(refg.usercheckBox1.isSelected() || refg.usercheckBox2.isSelected()))
                {
                    refg.DisplayErrorMessage("Please Select 1 Option (Admin or User)");
                    return;
                }
        }
        if(e.getActionCommand().equals("OK"))
        {
            if(refg.SignUpError.getTitle().equals("Closing Application"))
            {
                refg.frame.dispose();
                refg.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
           refg.SignUpError.dispose();
        }
        if(e.getActionCommand().equals("Verify"))
        {
           String s1 = refg.pass.getText();
           if(s1.equals(refg.AdminConfirmation))//refg.pass.getText()==refg.AdminConfirmation)
           {
               refg.adminConfirm.dispose();
                if (!refg.DAO.isAdminAlreadyExist(refg.user.getUsername())) {
                    refg.DAO.InsertAdmin(refg.user.getUsername(), refg.user.getPassword(),refg.user.getCNIC(),
                        refg.user.getGender(),refg.phField.getText());
                    resetToDefault();
                    refg.DisplayErrorMessage("                  Sign Up Successfully");
                }     
           }
           else if(!s1.equals(refg.AdminConfirmation))
           {
              refg.DisplayErrorMessage("     Wrong Confirmation Password");
              refg.adminConfirm.dispose();
           }
        }
        if(e.getActionCommand().equals("Yes"))
        {
                refg.frame.dispose();
                refg.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            refg.QuitFrame.dispose();
            ExitAppGUI exit = new ExitAppGUI();
        }
        if(e.getActionCommand().equals("No"))
        {
            refg.QuitFrame.dispose();
        }
     } 
    public void resetToDefault()
    {
       refg.username.setText("");
       refg.CNICfield.setText("");
       refg.phField.setText("");
       refg.password.setText("");
       refg.usercheckBox1.setSelected(false);
       refg.usercheckBox2.setSelected(false);
       refg.gender1.setSelected(false);
       refg.gender2.setSelected(false);
    }        
}   


    

