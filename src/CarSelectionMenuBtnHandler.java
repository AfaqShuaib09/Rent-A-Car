
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class CarSelectionMenuBtnHandler implements ActionListener {

    CarSelectionMenu refg;
    AdminMenuGUI adminGUI;
    String tempfare =""; 
    int x = 0;
    int i=0;
    String regd;
    String make="",model="", fare="";
    Booking bk;

    public CarSelectionMenuBtnHandler(CarSelectionMenu refg, AdminMenuGUI adminGUI) {
        this.refg = refg;
        this.adminGUI = adminGUI;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Select")) {
            //insert validation code here
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
            int max_id = -1;
            max_id = refg.bdao.getMaxBookID();
            Integer y = new Integer(max_id+1);
            refg.attr1.setText(y.toString());
            refg.attr2.setText(regd);
            refg.attr3.setText(make);
            refg.attr4.setText(model);
            refg.attr5.setText(adminGUI.sched_sd);
            refg.attr6.setText(adminGUI.sched_ed);
            tempfare = fare;
            int i = Integer.parseInt(fare);
            i= i*(refg.bdao.diffbwDates(adminGUI.sched_sd, adminGUI.sched_ed)+1);
            fare=String.valueOf(i);
            refg.attr7.setText(fare);
            refg.sp.setVisible(false);
            refg.head.setText("Confirm Booking");
            refg.Addbtn.setText("Confirm");
            refg.backbtn.setText("Cancel");
            
            refg.bg3.setVisible(true);
            refg.tempPan5.setVisible(true);

        } else if (e.getActionCommand().equals("Back")) {
            adminGUI.frame.setVisible(true);
            refg.frame.dispose();

        } else if (e.getActionCommand().equals("Confirm")) {
            int max_id = -1;
            max_id = refg.bdao.getMaxBookID();
            refg.adminGUI.loggedInUser.setCNIC(new UserDAO().getCNICOfAdmin(refg.adminGUI.loggedInUser.getUsername()));
            bk =refg.bdao.book(refg.adminGUI.loggedInUser.getUsername(),refg.adminGUI.loggedInUser.getCNIC() ,
                    regd, refg.adminGUI.sched_sd, refg.adminGUI.sched_ed, tempfare);
            bk.setFare(fare);
            refg.bdao.updateBookingRent(fare, max_id+1);
            refg.frame.dispose();
            refg.Generatereciept(bk);

            
        } else if (e.getActionCommand().equals("Cancel")) {
            refg.tempPan5.setVisible(false);
            refg.bg3.setVisible(false);
            refg.head.setText("Available Cars");
            refg.Addbtn.setText("Select");
            refg.backbtn.setText("Back");
            refg.sp.setVisible(true);
        }
        else if (e.getActionCommand().equals("OK")) {
            refg.popupframe.dispose();
        }
        else if (e.getActionCommand().equals("Close")) {
            refg.reciept.dispose();
            adminGUI.frame.setVisible(true);
        }
        else if (e.getActionCommand().equals("Save as PDF")) {
            //write your pdf making function here
            PdfDocument  pdf = new PdfDocument(bk,refg.bdao.GetCurrentDateAndTime());
            refg.reciept.dispose();
            adminGUI.frame.setVisible(true);
        }
    }
    
}
