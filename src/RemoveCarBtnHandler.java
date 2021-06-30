
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
public class RemoveCarBtnHandler implements ActionListener{

    RemoveCarGUI refg;
    AdminMenuGUI adminGUI;
    String tempfare =""; 
    int x = 0;
    int i=0;
    String regd;
    String make="",model="", fare="";

    public RemoveCarBtnHandler(RemoveCarGUI refg, AdminMenuGUI adminGUI) {
        this.refg = refg;
        this.adminGUI = adminGUI;
    }    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Remove"))
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
                refg.DisplayMessage("Car Against Given Registration Number doesn't Exist");
                return;
            }  
            refg.frame.setVisible(false);
            Car req = refg.Dao.getCarDetails(regd);
            refg.generateDeletionDetailGUI(req);
        }
        else if (e.getActionCommand().equals("OK")) {
            refg.popupframe.dispose();
        }
        if(e.getActionCommand().equals("Back"))
        {
            refg.frame.dispose();
            adminGUI.frame.setVisible(true);
        }
        if(e.getActionCommand().equals("Confirm Remove"))
        {
            int count=refg.Dao.getScheduleCount(regd);
            if(count==0){
                
                refg.Dao.removeCar(regd);
                refg.DisplayMessage("Removed Succesfully");
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
                RemoveCarGUI removeCarGUI = new RemoveCarGUI(adminGUI);
              }
              
        }
    }
}
