package Helper;


import customcontrols.Panel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vidhya Mohan
 */
public class UIHelper {
    
        public ImageIcon getImageIcon(String path) {
		Image imgIcon = new ImageIcon(path).getImage();
		return new ImageIcon(imgIcon);
	}
	
	public Image getImage(String path) {
		Image imgIcon = new ImageIcon(path).getImage();
		return imgIcon;
	}
        
        public Panel getEmptyPanel(int width, int height) {
            Panel emptyPanel = new Panel();
            emptyPanel.setPreferredSize(new Dimension(width, height));
           // emptyPanel.setBackground(Color.red);
            return emptyPanel;
        }
        
    
}
