
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author afaqs
 */
public class ItemView extends JPanel{
    ImageIcon icon;
    JLabel lb,l1;
    JButton btn;
    RoundedPanel r;
    //JPanel pan;
    public ItemView(ImageIcon i){
       this.icon=i;
     initGUI();
    }

    public void initGUI() {
       //pan = new JPanel();
       this.setLayout(new BorderLayout());
       this.setBackground(Color.black);
       this.btn = new JButton();
       this.lb = new JLabel(this.icon);
       this.l1= new JLabel();
       l1.setForeground(Color.white);
       this.lb.setBounds(0, 0, 300, 300);
       
       r = new RoundedPanel();
       //pan = new JPanel();
       r.setBounds(50,150,205,35);
       l1.setLocation(0,0);
       l1.setSize(300,30);
       r.add(l1);
       r.setBackground(Color.black);
       r.setOpaque(false);
        //signIn.setBounds(30,140,350,500);
        r.setLayout(null);
        //signIn.setBackground(Color.BLACK);
       //pan.setBorder(new TextBubbleBorder(Color.RED, 4, 8, 7));
       //pan.setLocation(0,0);
       //pan.setSize(300,330);
       //pan.add(this.lb);
       l1.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, 25));
       btn.setSize(300,330);
       //btn.setBorder(BorderFactory.createBevelBorder(1, Color.red, Color.blue));
//btn.setBorder(BorderFactory.createBevelBorder(0));
       btn.setBorder(BorderFactory.createLineBorder(Color.RED));
//btn.setBorder(new TitledBorder("full"));
       //btn.add(this.pan);
       
      
//btn.add(l1);
       btn.add(this.lb);
       lb.add(r);
       this.add(btn);
       this.setSize(300,330);
       this.setVisible(true);
    }
}
