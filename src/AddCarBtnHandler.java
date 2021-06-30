
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Afaq
 */
public class AddCarBtnHandler implements ActionListener{

    AddCarGUI refg;
    public AddCarBtnHandler(AddCarGUI g){
        refg = g;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Back"))
        {
            refg.frame.dispose();
        }
        if(e.getActionCommand().equals("Add"))
        {
            if (refg.vin.getText().length() == 0 || refg.make.getText().length() == 0|| 
                    refg.m_year.getText().length()==0|| refg.model.getText().length()==0||
                    refg.pdrent.getText().length()==0)
            {
               refg.DisplayMessage("  Necessay Fields can't be Empty ");
                return;
            }
            if (refg.vin.getText().length() < 7)
            {
                refg.DisplayMessage("Car Registeration Number Should be at least of 7 character");
               //Display message
                return;
            }
            if(refg.pdrent.getText().length()>10)
            {
            refg.DisplayMessage("Per day rent should not be more than 10 digits");
                return;
            }
            if(refg.eno.getText().length()>10)
            {
            refg.DisplayMessage("Engine no. should not be more than 10 digits");
                return;
            }
            if(!Pattern.matches("[A-Z]{1,3}-\\d{3,4}", refg.vin.getText()))
            {
               refg.DisplayMessage("Invalid Regdno Fmt: AAA-XXX");
                return;
            }
            String r_id = refg.vin.getText();
            if(refg.Dao.isCarAlreadyExist(r_id))
            {
              refg.DisplayMessage("            Record Already Exists ");
              return;
            }
            if(!refg.Dao.isCarAlreadyExist(r_id))
            {
              refg.Dao.AddCar(refg.vin.getText(), refg.make.getText(), refg.m_year.getText(), refg.model.getText(),
                      refg.eno.getText(), refg.color.getText(), refg.pdrent.getText());
              resetToDefault();
              refg.DisplayMessage("            Record Added Succesfully ");
              return;
            }
        }
        if(e.getActionCommand().equals("OK"))
        {
          refg.popupframe.dispose();
        }
    }
    public void resetToDefault()
    {
       refg.vin.setText("");
       refg.make.setText("");
       refg.m_year.setText("");
       refg.model.setText("");
       refg.color.setText("");
       refg.eno.setText("");
       refg.pdrent.setText("");
    }
}
