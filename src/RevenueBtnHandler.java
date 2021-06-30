
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
public class RevenueBtnHandler implements ActionListener{
    RevenueGUI refg;
    AdminMenuGUI adminGUI;
    public RevenueBtnHandler(RevenueGUI refg, AdminMenuGUI adminGUI) {
        this.refg = refg;
        this.adminGUI = adminGUI;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
     if (e.getActionCommand().equals("Back")) {    
            refg.frame.dispose();
            adminGUI.frame.setVisible(true);
     }
     if (e.getActionCommand().equals("Generate Monthly Revenue")) {    
         //Write your Logic Here   
         String ActionCommand1 = e.getActionCommand(); 
         String s = refg.myear.getText();
         String s1 = refg.month.getText();
         if(s.length()==0 || s1.length()==0)
         {
             refg.DisplayMessage("            Necessary Fields Empty");
             return;
         }
         int valm = Integer.parseInt(refg.month.getText());
         int valyear = Integer.parseInt(refg.myear.getText());
         if(valm<=0 || valm>=13)
         {
             refg.DisplayMessage("                       Invalid Month");
             return;
         }
         if(valyear<2000)
         {
            refg.DisplayMessage("     Year Less than 2000 not allowed");
            return;
         }
         refg.GenerateRevenueFrame(ActionCommand1, s, s1);
         refg.frame.setVisible(false);
         //RevenueFrame(Text)
     }
     if (e.getActionCommand().equals("Generate Yearly Revenue")) {    
         //Write your Logic Here   
         String ActionCommand = e.getActionCommand(); 
         if(refg.year.getText().length()==0)
         {
            refg.DisplayMessage("            Necessary Fields Empty");
             return;
         }
         int val = Integer.parseInt(refg.year.getText());
         if(val<2000)
         {
            refg.DisplayMessage("     Year Less than 2000 not allowed");
            return;
         }
         String yr = refg.year.getText();
         refg.GenerateRevenueFrame(ActionCommand, yr, "0");
         refg.frame.setVisible(false);
         //adminGUI.frame.setVisible(true);
     }
     if (e.getActionCommand().equals("OK")) {   
         refg.popupframe.dispose();
     }
     if (e.getActionCommand().equals("BACK")) {   
         refg.revenue.dispose();
         refg.year.setText("");
         refg.myear.setText("");
         refg.month.setText("");
         refg.mwyear.setText("");
         refg.frame.setVisible(true);
     }
     if (e.getActionCommand().equals("Month Wise Revenue")) {   
         if(refg.mwyear.getText().length()==0)
         {
            refg.DisplayMessage("            Necessary Fields Empty");
             return;
         }
         int val = Integer.parseInt(refg.mwyear.getText());
         if(val<2000)
         {
            refg.DisplayMessage("     Year Less than 2000 not allowed");
            return;
         }
         refg.generateMonthwiseRevenueFrame(refg.mwyear.getText());
         refg.frame.setVisible(false);
     }
     if (e.getActionCommand().equals("Close")) {   
         refg.mwRevenueFrame.dispose();
         refg.year.setText("");
         refg.myear.setText("");
         refg.month.setText("");
         refg.mwyear.setText("");
         refg.frame.setVisible(true);
     }
    }
}
