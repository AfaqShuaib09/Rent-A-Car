
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Afaq
 */
public class MyBookingsBtnHandler implements ActionListener{

    MyBookingsGUI refg;
    UserMenuGUI userGUI;
    int x=0;
    public void sleepForaWhile() {
        try {
            Thread.sleep(5);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    public MyBookingsBtnHandler(MyBookingsGUI refg, UserMenuGUI usrGUI) {
        this.refg = refg;
        this.userGUI = usrGUI;
        x= refg.booking_count;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Back")) {
            userGUI.frame.setVisible(true);
            refg.frame.dispose();
        } 
        else if (e.getActionCommand().equals("Next")) {
            if(refg.move<=0)
            {
              return;
            }
            refg.move--;
           int myWidth =  refg.bk_panels[0].r2.getWidth();
           new Thread(()->{
               for(int i=0;i< myWidth;i++) {
                   for(int j=0;j<refg.booking_count;j++) {
                       refg.bk_panels[j].setLocation(
                               refg.bk_panels[j].r2.getLocation().x - 1,
                               refg.bk_panels[j].r2.getLocation().y
                       );
                   }
                   try {
                       Thread.sleep(1);
                   } catch (InterruptedException ex) {
                       Logger.getLogger(MyBookingsBtnHandler.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   refg.pan1.repaint();
                   refg.pan1.revalidate();
                   refg.frame.repaint();
                   refg.frame.revalidate();
               }
           }).start();
        }
        else if (e.getActionCommand().equals("Previous")) {
            if(refg.move>=refg.booking_count)
            {
              return;
            }
            refg.move++;
           int myWidth =  refg.bk_panels[0].r2.getWidth();
           new Thread(()->{
               for(int i=0;i< myWidth;i++) {
                   for(int j=0;j<refg.booking_count;j++) {
                       refg.bk_panels[j].setLocation(
                               refg.bk_panels[j].r2.getLocation().x + 1,
                               refg.bk_panels[j].r2.getLocation().y
                       );
                   }
                   try {
                       Thread.sleep(1);
                   } catch (InterruptedException ex) {
                       Logger.getLogger(MyBookingsBtnHandler.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   refg.pan1.repaint();
                   refg.pan1.revalidate();
                   refg.frame.repaint();
                   refg.frame.revalidate();
               }
           }).start();
        }
    }
    
}
