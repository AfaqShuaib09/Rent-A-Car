
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Afaq
 */
public class CancelBookingBtnHandler implements ActionListener{
    CancelBookingGUI refg;
    UserMenuGUI userGUI;
    String tempfare =""; 
    int x = 0;
    int i=0;
    String regd;
    String make="",model="", fare="";

    public CancelBookingBtnHandler(CancelBookingGUI refg, UserMenuGUI usrGUI) {
        this.refg = refg;
        this.userGUI = usrGUI;
    }    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Cancel Booking"))
        {
             regd= refg.vin.getText();
          if(refg.vin.getText().length()==0)
          {
              refg.DisplayMessage("Car Regd Number can't be empty");
             return;
          }
          boolean flag = false;
            for(int i=0;i<refg.JTmodel.getRowCount();i++)
             {
               if(regd.equals(refg.JTmodel.getValueAt(i, 0))){ 
                   flag=true;
               }
             }
            System.out.println("Flag value:  "+ flag);
            if(flag==false)
            {
                
                refg.DisplayMessage("Car Registration Number doesn't Exist");
                return;
            }  
            refg.frame.setVisible(false);
            Booking temp = refg.bdao.getBooking(Integer.parseInt(regd));
            refg.generateDeletionDetailGUI(temp);
        }
        else if (e.getActionCommand().equals("OK")) {
            refg.popupframe.dispose();
        }
        if(e.getActionCommand().equals("Back"))
        {
            refg.frame.dispose();
            userGUI.frame.setVisible(true);
        }
        if(e.getActionCommand().equals("Confirm Unbook"))
        {
            int count=refg.Dao.getScheduleCount(regd);
            if(count==0){
                refg.bdao.delete_booking(Integer.parseInt(regd));
                refg.DisplayMessage("Removed Succesfully");
                File f= new File("C:\\java_pdf\\reciept_"+regd+".pdf"); 
                f.delete();
                refg.popupframe.setTitle("Message");
                refg.btn.setText("Ok");
            }
            else if(count>0)
           {
              refg.DisplayMessage("Can't be deleted bcz it has "+count+" Bookings");
              refg.popupframe.setTitle("Error");
              refg.btn.setText("Ok");
           }
        }
        if(e.getActionCommand().equals("Cancel"))
        {
              refg.DeletionGUI.dispose();
              refg.frame.setVisible(true);
        }
        if(e.getActionCommand().equals("Ok"))
        {
              refg.popupframe.dispose();
              refg.DeletionGUI.dispose();
              if(refg.popupframe.getTitle().equals("Error"))
                refg.frame.setVisible(true);
              else if (refg.popupframe.getTitle().equals("Message")){
                refg.frame.dispose();
              CancelBookingGUI cancelBookingGUI = new CancelBookingGUI(userGUI);
            }
        }
    }
}
