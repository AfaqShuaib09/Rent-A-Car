
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Afaq
 */
public class UserMenuBtnHandler implements ActionListener{
    UserMenuGUI refg;
    public UserMenuBtnHandler(UserMenuGUI g) {
        refg=g;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
     if(e.getActionCommand().equals("My Bookings"))
        {
            refg.frame.setVisible(false);
            MyBookingsGUI myBookingsGUI = new MyBookingsGUI(refg);
        }  
     if(e.getActionCommand().equals("Book A Car")){   
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
         BookACarGUI bookACarGUI = new BookACarGUI(refg);
         refg.frame.setVisible(false);
     }
    if(e.getActionCommand().equals("Exit App"))
      {
          refg.frame.dispose();
          ExitAppGUI exit = new ExitAppGUI();
         //AvailableCarsGUI availableCarsGUI =new AvailableCarsGUI();
      }
    if(e.getActionCommand().equals("Cancel Booking"))
    {
         refg.frame.setVisible(false);
         CancelBookingGUI cancelBookingGUI = new CancelBookingGUI(refg);
         //RemoveCarGUI removeCarGUI = new RemoveCarGUI(refg);
    }
    if(e.getActionCommand().equals("Update Booking"))
    {
         refg.frame.setVisible(false);
         UpdateBookingGUI updateBookingGUI = new UpdateBookingGUI(refg);
    }
    if(e.getActionCommand().equals("Submit"))
    {
        refg.sched_sd= refg.start_date.getText();
        refg.sched_ed= refg.end_date.getText();
        if(refg.sched_sd.length()==0|| refg.sched_ed.length()==0)
         {
             refg.DisplayErrorMessage("Schedule Dates can't be empty");
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
        UserAvailableCarsGUI availableCarsGUI = new UserAvailableCarsGUI(refg);
         //CarSelectionMenu temp = new CarSelectionMenu(refg);
         refg.frame.setVisible(false);
    }
    
    if(e.getActionCommand().equals("Available Cars"))
    {
         refg.createAndDisplayInputDateFrame();
         refg.enter.setText("Submit");
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
