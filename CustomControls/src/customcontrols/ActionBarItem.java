/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customcontrols;

import Skin.Skin;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.Border;

/**
 *
 * @author Vidhya Mohan
 */
public class ActionBarItem extends JButton {
    Skin skin = new Skin();
    public ActionBarItem() {
        super();
        this.setPreferredSize(new Dimension(179, 80));   
        this.setBackground(this.skin.skyBlueColor);
        Border bdr = new javax.swing.border.MatteBorder(2, 2, 2, 2, this.skin.milkWhiteColor);            
        this.setBorder(bdr);
        this.setForeground(this.skin.milkWhiteColor);
        this.setFont(this.skin.fontBold18);
        
    }   
    
}
