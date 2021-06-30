
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author afaqs
 */
public class SignInBtnHandler implements ActionListener{

    SignInGUI refg;
    public SignInBtnHandler(SignInGUI g){
        refg = g;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Sign Up") || e.getActionCommand().equals("Create New Account"))
        {
            refg.frame.dispose();
            SignUpGUI signUp=new SignUpGUI();
        }
        if(e.getActionCommand().equals("Delete Account"))
        {
            DeleteAccountGUI dltgui=new DeleteAccountGUI();
        }
        if(e.getActionCommand().equals("OK"))
        {
            if(refg.messageFrame.getTitle().equals("Closing Application")){
                refg.frame.dispose();
                refg.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
            refg.messageFrame.dispose();
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
        if(e.getActionCommand().equals("Sign In"))
        {
            refg.fillUser();
            String usr= refg.user.getUsername();
            String pass= refg.user.getPassword();
             if(refg.user.getUsername().length()==0||refg.user.getPassword().length()==0)
             {
               refg.DisplayMessage("         Necessary Fields Empty");
               return;
             }
            if(!(refg.usercheckBox1.isSelected() || refg.usercheckBox2.isSelected()))
            {
               refg.DisplayMessage("Please Select 1 Option (Admin or User)");
               return;
            }
            else if(refg.usercheckBox1.isSelected() || refg.usercheckBox2.isSelected())
            {  
                if(refg.usercheckBox1.isSelected() && refg.usercheckBox2.isSelected())
                {
                    refg.DisplayMessage("Only 1 CheckBox Should be Selected");
                    return;
                }
                else if(refg.usercheckBox1.isSelected()){  
                    if(!refg.DAO.SearchFromAdmin(usr, pass) && refg.DAO.isAdminAlreadyExist(usr))
                    {
                        System.out.println("Hello");
                          refg.DisplayMessage("              Wrong Password");
                          return;
                    }
                    else if(!refg.DAO.SearchFromAdmin(usr, pass))
                    {
                          refg.DisplayMessage("        User Doesn't Exist");
                          return;
                    }
                    
                    if(refg.DAO.SearchFromAdmin(usr, pass))
                    {
                        refg.frame.dispose();
                        LoadingGUI l1 = new LoadingGUI("Admin",refg.user);
                    }
                }
                    else if(refg.usercheckBox2.isSelected()){  
                        if(!refg.DAO.SearchFromUser(usr, pass) && refg.DAO.isUserAlreadyExist(usr))
                        {
                            refg.DisplayMessage("                 Wrong Password"); 
                            return;
                        }
                        else if(!refg.DAO.SearchFromUser(usr, pass))
                        {
                          refg.DisplayMessage("                User Doesn't Exist");
                          return;
                        }
                        if(refg.DAO.SearchFromUser(usr, pass))
                        {
                            
                            refg.frame.dispose();
                            LoadingGUI l2 = new LoadingGUI("Normal User", refg.user);
                        }
                }
            }
        }
    }
}
