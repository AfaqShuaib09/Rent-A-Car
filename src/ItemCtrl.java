
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author afaqs
 */
public class ItemCtrl {
    ItemView item;
   

   public ItemView getItem()
   {
      ImageIcon icon = new ImageIcon("7f61d47e8d10f146a8bb3dfdda11db19.jpg");
      this.item = new ItemView(icon);
      return this.item;
   }
}
