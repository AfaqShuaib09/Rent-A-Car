
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author afaqs
 */
public class DeleteAccountHandler implements ActionListener{

    DeleteAccountGUI refg;
    public DeleteAccountHandler(DeleteAccountGUI g){
        refg = g;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getActionCommand().equals("Delete Account"))
        {
            String usr= refg.usernametf.getText();
            String pass = refg.passField.getText();
            if(refg.usercheckBox1.isSelected()){
                if(refg.dao.SearchAdmin(usr, pass)==1)
                {
                   refg.DisplayMessage("         Deleted Succesfully");
                   refg.dao.DeleteAdmin(usr, pass);
                   return;
                }
               else if(refg.dao.SearchAdmin(usr, pass)==0)
               {
                   refg.DisplayMessage("             Wrong Credentials");
                   return;
               }
            }   
            else if(refg.usercheckBox2.isSelected())
            {
                if(refg.dao.SearchUser(usr, pass)==1)
                {
                   refg.DisplayMessage("         Deleted Succesfully");
                   refg.dao.DeleteUser(usr, pass);
                   return;
                }
               else if(refg.dao.SearchUser(usr, pass)==0)
               {
                   refg.DisplayMessage("             Wrong Credentials");
                   return;
               }
            }
        }
         else if(e.getActionCommand().equals("Cancel"))
        {
            refg.frame.dispose();
        } 
         else if(e.getActionCommand().equals("OK"))
        {
            refg.messageFrame.dispose();
        }  
         //To change body of generated methods, choose Tools | Templates.
    }
    
}
