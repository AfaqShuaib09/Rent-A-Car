
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Afaq
 */
public class AdminMenuBtnHandler implements ActionListener {

    AdminMenuGUI refg;
    public AdminMenuBtnHandler(AdminMenuGUI g) {
        refg=g;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
     if(e.getActionCommand().equals("Add A Car"))
        {
            AddCarGUI addCarGUI = new AddCarGUI();
        }  
     if(e.getActionCommand().equals("Schedule A Car")){   
         refg.createAndDisplayInputDateFrame();
     }
     if(e.getActionCommand().equals("Enter")){   
         refg.sched_sd= refg.start_date.getText();
         refg.sched_ed= refg.end_date.getText();
         if(refg.sched_sd.length()==0|| refg.sched_ed.length()==0)
         {
             refg.DisplayErrorMessage("Schedule Dates can't be empty");
             refg.inputDate.setVisible(false);
             return;
         }
         if(!Pattern.matches("^\\d{4}-\\d{1,2}-\\d{1,2}", refg.sched_sd))
         {
             refg.DisplayErrorMessage("Start Date wrong fmt: YYYY-MM-DD");
             refg.inputDate.setVisible(false);
             return;
         }
         if(!Pattern.matches("^\\d{4}-\\d{1,2}-\\d{1,2}", refg.sched_ed))
         {
             refg.DisplayErrorMessage("End Date wrong fmt: YYYY-MM-DD");
             refg.inputDate.setVisible(false);
             return;
         }
         BookingDAO b = new BookingDAO();
         int cnt1 =b.diffbwDates(refg.sched_sd, refg.sched_ed);
         if(cnt1<0)
         {
             refg.DisplayErrorMessage("Start Date must be lass than or equal to end date");
             refg.inputDate.setVisible(false);
            return;
         }
         int cnt2 = b.diffWithCurDate(refg.sched_sd);
         if(cnt2<0)
         {
             refg.DisplayErrorMessage("Invalid Date Input");
             refg.inputDate.setVisible(false);
            return;
         }
         refg.inputDate.dispose();
         CarSelectionMenu temp = new CarSelectionMenu(refg);
         refg.frame.setVisible(false);
     }
    if(e.getActionCommand().equals("Available Cars"))
      {
         AvailableCarsGUI availableCarsGUI =new AvailableCarsGUI();
      }
    if(e.getActionCommand().equals("Remove A Car"))
    {
         refg.frame.setVisible(false);
         RemoveCarGUI removeCarGUI = new RemoveCarGUI(refg);
    }
    if(e.getActionCommand().equals("Scheduled Cars"))
    {
         refg.frame.setVisible(false);
         ScheduledCarsGUI scheduledCarsGUI = new ScheduledCarsGUI(refg);
         //RemoveCarGUI removeCarGUI = new RemoveCarGUI(refg);
    }
    if(e.getActionCommand().equals("Calculate Revenue"))
    {
         refg.frame.setVisible(false);
         RevenueGUI rGui = new RevenueGUI(refg);
    }
    
    if(e.getActionCommand().equals("Sign Out"))
      {
         refg.frame.dispose();
         SignInGUI s = new SignInGUI();
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
    if(e.getActionCommand().equals("OK"))
    {
        refg.popupFrame.dispose();
       refg.inputDate.setVisible(true);
    }
    }
}
