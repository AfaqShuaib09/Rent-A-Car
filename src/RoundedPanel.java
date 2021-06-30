
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
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
public class RoundedPanel extends JPanel{
    
     protected void paintComponent(Graphics g) {
           super.paintComponent(g);
           Dimension arcs = new Dimension(15,15);
           int width = getWidth();
           int height = getHeight();
           Graphics2D graphics = (Graphics2D) g;
           graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //Draws the rounded opaque panel with borders.
          graphics.setColor(getBackground());
          graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint background
          graphics.setColor(getForeground());
          graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint border
     }
}
