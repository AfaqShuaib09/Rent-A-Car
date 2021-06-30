

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
public class LoadingGUI {

    JFrame frame;
    JLabel Label;
    JPanel panel;
    User user;
    String s;
    int Loc_X_Cor_Fr = 0;
    int Loc_Y_Cor_Fr = 10;
    int X_cor_Size = 1000;
    int Y_cor_Size = 683;
    Clip c;
    public LoadingGUI(String s,User usr) {
        new Thread(() -> {
            initGUI(s,usr);
            movePanel();
        }).start();
    }

    public void sleepForaWhile() {
        try {
            Thread.sleep(5);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public void initGUI(String mode,User usr) {
        c = playSound("C:\\Users\\afaqs\\OneDrive\\Documents\\Documents\\NetBeansProjects\\R5_Project\\car_turbo.wav", true);
        frame = new JFrame();
        frame.setTitle("Loading..");
        frame.setLayout(null);
        user = usr;
        s = mode;
        Label = new JLabel();
        Font font;
        font = new Font(Font.MONOSPACED, Font.BOLD, 40);
        Label.setFont(font);
        Label.setForeground(Color.red);
        Label.setText("Signing In");
        Label.setBounds(350, 200, 400, 60);

        frame.add(Label);

        JLabel car = new JLabel();
        car.setIcon(new ImageIcon("Car.png"));
        car.setLayout(new BorderLayout());
        car.setLocation(0, 0);
        car.setSize(205, 70);

        panel = new JPanel();
        panel.setLocation(0, 450);
        panel.setSize(205, 70);
        panel.setBackground(new Color(0, 0, 0, 5));
        panel.add(car);
        // panel.setIcon(new ImageIcon("Car3.png"));
        frame.add(panel);

        JLabel contentPane = new JLabel();
        contentPane.setIcon(new ImageIcon("Loading.jpg"));
        contentPane.setLayout(new BorderLayout());
        contentPane.setSize(X_cor_Size, Y_cor_Size);
        contentPane.setLocation(0, 0);
        frame.add(contentPane);

        frame.setLocation(Loc_X_Cor_Fr, Loc_Y_Cor_Fr);
        frame.setSize(X_cor_Size, Y_cor_Size);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void movePanel() {
        panel.setLocation(0, 450);
        int inc = 0;
        int count = 0;
        while (panel.getLocation().getX() + panel.getSize().getWidth() <= 1000) {
            if (count % 100 == 0) {
                Label.setText(Label.getText() + '.');
            }
            sleepForaWhile();
            panel.setLocation(inc, 450);
            inc += 2;
            count++;
        }
        if (panel.getSize().getWidth() <= 1000) {
            frame.dispose();
            c.stop();
            if (s == "Admin") {
                AdminMenuGUI adminMenuGUI = new AdminMenuGUI(user);
            } else if (s == "Normal User") {
                UserMenuGUI userMenuGUI = new UserMenuGUI(user);
            }
        }
    }
    static Clip playSound (String soundFilePath, Boolean loop) {
        Clip clip = null;
        try {
            AudioInputStream clickSound = AudioSystem.getAudioInputStream(
                    new File(soundFilePath).getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(clickSound);
            clip.start();
            if(loop) clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return clip;
   }
}
