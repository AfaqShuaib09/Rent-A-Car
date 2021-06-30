
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Afaq
 */
public class UserAvailableCarsBtnHandler implements ActionListener{
     UserAvailableCarsGUI refg;
     UserMenuGUI usermenu;
     public UserAvailableCarsBtnHandler(UserAvailableCarsGUI refg, UserMenuGUI userMenuGUI) {
        this.refg = refg;
        this.usermenu = userMenuGUI;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getActionCommand().equals("Back")) {
            usermenu.frame.setVisible(true);
            refg.frame.dispose();
        }
    }
     
}
