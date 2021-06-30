
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
public class ScheduledCarBtnHandler implements ActionListener{

    ScheduledCarsGUI refg;
    AdminMenuGUI adminGUI;
    public ScheduledCarBtnHandler(ScheduledCarsGUI refg, AdminMenuGUI adminGUI) {
        this.refg = refg;
        this.adminGUI = adminGUI;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
     if (e.getActionCommand().equals("Change View")) {    
         refg.sp.setVisible(false);
         refg.header1.setVisible(true);
         refg.subsp1.setVisible(true);
         refg.tempPan1.setVisible(true);
         refg.header2.setVisible(true);
         refg.subsp2.setVisible(true);
         refg.tempPan2.setVisible(true);
         refg.header3.setVisible(true);
         refg.bg3.setVisible(true);
         refg.Addbtn.setText("Change view");
     }
     if (e.getActionCommand().equals("Change view")) {    
         
         refg.header1.setVisible(false);
         refg.subsp1.setVisible(false);
         refg.tempPan1.setVisible(false);
         refg.header2.setVisible(false);
         refg.subsp2.setVisible(false);
         refg.tempPan2.setVisible(false);
         refg.header3.setVisible(false);
         refg.bg3.setVisible(false);
         refg.sp.setVisible(true);
         refg.Addbtn.setText("Change View");
     }
     else if (e.getActionCommand().equals("Back")) {
            adminGUI.frame.setVisible(true);
            refg.frame.dispose();
     }    
    }  
}
