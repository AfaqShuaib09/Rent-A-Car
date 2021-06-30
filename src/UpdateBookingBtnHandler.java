
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
public class UpdateBookingBtnHandler implements ActionListener{
    UpdateBookingGUI refg;
    UserMenuGUI userMenuGUI;
    String tempfare =""; 
    int x = 0;
    int i=0;
    int bk_id;
    String regd;
    String make="",model="", fare="";
    Booking bk;
    Booking temp;

    public UpdateBookingBtnHandler(UpdateBookingGUI refg, UserMenuGUI userGUI) {
        this.refg = refg;
        this.userMenuGUI = userGUI;
        //this.bk_id = Integer.parseInt(refg.vin.getText());
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Select")) {
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
                   make = (String) refg.JTmodel.getValueAt(i, 1);
                   model =(String) refg.JTmodel.getValueAt(i, 3);
                   fare = (String) refg.JTmodel.getValueAt(i,(refg.JTmodel.getColumnCount()-1));
                   flag=true;
               }
             }
            System.out.println("Flag value:  "+ flag);
            if(flag==false)
            {
                refg.DisplayMessage("Given Car Registration Number not Available or doesn't Exist");
                return;
            }
            temp =refg.bdao.getBooking(Integer.parseInt(regd));
            refg.attr1.setText(String.valueOf(temp.getBook_id()));
            refg.attr2.setText(temp.getUsername());
            refg.attr3.setText(temp.getUser_Cnic());
            refg.attr4.setText(temp.getVehicleID());
            refg.attr5.setText(temp.getSched_StartDate());
            refg.attr6.setText(temp.getSched_EndDate());
            refg.attr7.setText(temp.getFare());
            refg.pan1.setVisible(false);
            refg.bg3.setVisible(true);
            refg.tempPan5.setVisible(true);
            refg.vin.setVisible(false);
            refg.label1.setVisible(false);
            refg.start_dateLab.setVisible(true);
            refg.end_dateLab.setVisible(true);
            refg.stField.setVisible(true);
            refg.enField.setVisible(true);
            refg.backbtn.setText("BACK");
            refg.SelectBtn.setText("Update");

        } else if (e.getActionCommand().equals("Back")) {
            userMenuGUI.frame.setVisible(true);
            refg.frame.dispose();

        }
        else if (e.getActionCommand().equals("OK")) {
            refg.popupframe.dispose();
        }
        else if (e.getActionCommand().equals("Update")) {
            if(refg.stField.getText().length()==0||refg.enField.getText().length()==0)
            {
                 refg.DisplayMessage("  Necessay Fields can't be Empty ");
                 return;
            }
            String startDate,endDate;
            startDate = refg.stField.getText();
            endDate = refg.enField.getText();
            int i1= refg.bdao.diffbwDates(startDate, endDate);
            if(i1<0)
            {
               refg.DisplayMessage("Book Start Date Must be lesser than or equal to End Date");
               return;
            }
            int countOfbookings =refg.bdao.countNumberOfBookingsbwDates(temp.getBook_id(),startDate,endDate,temp.getVehicleID());
            if(countOfbookings == 0)
            {
                refg.frame.dispose();
                int numberOfDays = i1+1;
                int rnt = refg.Dao.getPerdayRent(temp.getVehicleID());
                refg.bdao.updateBookingStartDate(startDate, temp.getBook_id());
                refg.bdao.updateBookingEndDate(endDate, temp.getBook_id());
                refg.bdao.updateBookingRent(String.valueOf(numberOfDays*rnt), temp.getBook_id());
                Booking b= refg.bdao.getBooking(temp.getBook_id());
                refg.Generatereciept(b);
            }
            else 
            {
               refg.DisplayMessage("Car Already have bookings during these days");
               return;
            } 
            refg.stField.setText("");
            refg.enField.setText("");
            refg.vin.setText("");
        }
        else if (e.getActionCommand().equals("Close")) {
            refg.reciept.dispose();
            userMenuGUI.frame.setVisible(true);
        }
        else if (e.getActionCommand().equals("Save as PDF")) {
            //write your pdf making function here
            Booking b= refg.bdao.getBooking(temp.getBook_id());
            PdfDocument  pdf = new PdfDocument(b,refg.bdao.GetCurrentDateAndTime());
            refg.reciept.dispose();
            userMenuGUI.frame.setVisible(true);
        }
        else if (e.getActionCommand().equals("BACK")) {
            refg.bg3.setVisible(true);
            refg.tempPan5.setVisible(false);
            refg.pan1.setVisible(true); 
            refg.vin.setVisible(true);
            refg.label1.setVisible(true);
            refg.start_dateLab.setVisible(false);
            refg.end_dateLab.setVisible(false);
            refg.stField.setVisible(false);
            refg.enField.setVisible(false);
            refg.backbtn.setText("Back");
            refg.SelectBtn.setText("Select");

        } 
    }
    
}
