
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author afaqs
 */
public class ShowCaseView {
   JPanel panel;
   ItemCtrl iCtrl;
   
   public ShowCaseView(){
       initGUI();
   }
   

    public  void initGUI() {
       panel = new JPanel();
       this.iCtrl = new ItemCtrl();
       panel.setLayout(new GridLayout(2,3));
       panel.setSize(900,683-25);
       panel.setVisible(true);
       
       for (int i=0;i<6;i++)
       {
           ItemView item;
           item = iCtrl.getItem();
           item.btn.setForeground(Color.red);
           item.btn.setBackground(Color.black);
           
           switch(i){
               case 0:
                   item.btn.setText("Shedule A Car");
                   item.l1.setLocation(10, 0);
                   //item.l1.setBounds(50, 100, 100, 30);
                   item.l1.setText("Schedule a Car");
                   break;
               case 1:
                   item.btn.setText("Add A Car");
                   item.l1.setLocation(40, 0);
                   item.l1.setText("Add A Car");
                   break;
               case 2:
                   item.btn.setText("Remove A Car");
                   item.l1.setLocation(15, 0);
                   item.l1.setText("Remove A Car");
                   break;
               case 3:
                   item.btn.setText("Monthly Revenue");
                   item.l1.setText("Monthly Revenue");
                   break;
               case 4:
                   item.btn.setText("Scheduled Cars");
                   item.l1.setLocation(7, 0);
                   item.l1.setText("Scheduled Cars");
                   break;
               case 5:
                   item.btn.setText("Available Cars");
                   item.l1.setLocation(15, 0);
                   item.l1.setText("Available Cars");
                   break;
               default:
                   System.out.println("None");
       }
           panel.add(item);
           panel.repaint();
           panel.validate();
       }
    }
      
  }    