/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.About;

import Presentation.Common.BaseNavigationFrame;
import customcontrols.Label;
import customcontrols.Panel;
import customcontrols.PictureBox;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Vidhya Mohan
 */
public class AboutNavigation extends BaseNavigationFrame {
    Panel pnlAbout;
    public AboutNavigation() {
        super();  
        initializeBaseNavigationFrame();
        initializeAboutNavigation();
        this.clearActiveNav();
        this.sideNavAbout.setActive();
        this.actionBar.setViewMode();
    }
    
    public void initializeAboutNavigation() {        
        this.centerPane.setLayout(new MigLayout());
        this.centerPane.add(this.getTitleLabel("About"), this.getTitleConstraint());
        pnlAbout = new Panel();        
        pnlAbout.setLayout(new MigLayout());
       
        StringBuilder sb = new StringBuilder();
        sb.append("The Inventory Management System is designed and owned by Stock Absence");
        sb.append(System.lineSeparator());
        sb.append("If you have any question or query please contact the admin through email: vidhya074@gmail.com");
        Label lblAboutContent = new Label(sb.toString());
        lblAboutContent.setFont(skin.font20);     
        lblAboutContent.setForeground(skin.darkTextColor);
        
        Label lblImage = new Label();
        lblImage.setIcon(new ImageIcon( this.getClass().getResource("/images/aboutUs.png")));
        lblImage.setPreferredSize(new Dimension(400, 381));
        pnlAbout.add(lblAboutContent, "wrap, align center, gaptop 40");
        pnlAbout.add(lblImage, "align center, gaptop 30");
        
        this.centerPane.add(pnlAbout, "grow, push");
        
    }
    
}
