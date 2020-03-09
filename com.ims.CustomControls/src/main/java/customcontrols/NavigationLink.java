/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customcontrols;

import Skin.Skin;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

/**
 *
 * @author Vidhya Mohan
 */
public class NavigationLink extends JButton {
    Skin skin = new Skin();
    public NavigationLink() {
        super(); 
        initializeNavigationLink("");
    }
    
    public NavigationLink(String text) {
        super(); 
        initializeNavigationLink(text);
    }
    
    public NavigationLink(String text, ImageIcon icon) {
        super(); 
        initializeNavigationLink(text);
        this.setIcon(icon);
    }
    
    public void initializeNavigationLink(String text) {
        this.setPreferredSize(new Dimension(200, 60));   
        this.setBackground(this.skin.slateBlackColor);
        Border bdr = new javax.swing.border.MatteBorder(2, 2, 2, 2, this.skin.milkWhiteColor);            
        this.setBorder(bdr);
        this.setForeground(this.skin.milkWhiteColor);
        this.setFont(this.skin.fontBold20);      
        Cursor csr = new Cursor(Cursor.HAND_CURSOR);
        this.setCursor(csr);  
        this.setText(text);
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setIconTextGap(15);
        this.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
        
    }
}
