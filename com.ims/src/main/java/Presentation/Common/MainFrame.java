/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Common;

import Helper.UIHelper;
import Skin.Skin;
import customcontrols.BaseFrame;
import customcontrols.Panel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 *
 * @author Vidhya Mohan
 */
public class MainFrame extends BaseFrame {

    protected JPanel contentPane;
    protected Skin skin = new Skin();
    protected UIHelper uiHelper = new UIHelper();
    protected Utilities utility = new Utilities();
    
    public MainFrame() {
        super();
        contentPane = new JPanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(getSkin().frameBackgroundColor);
        setBounds(0, 0, 2300, 1500);		
        setSize(2400, 1500);
        setPreferredSize(new Dimension(2400, 1500));
        this.setMinimumSize(new Dimension(2400, 1500));
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
       // setUndecorated(true);
       Image logo = this.getImageIconByPath("/Images/logo.png").getImage();
       this.setIconImage(logo);
       this.utility.setUIManager();
    }

   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pack();
    }// </editor-fold>//GEN-END:initComponents

 	
    protected JButton getButtonSettings(JButton btn) {
            if (btn == null) {
                    btn = new JButton();
            }

            btn.setBackground(skin.darkButtonColor);
            btn.setForeground(skin.buttonForeGroundColor);
            btn.setFont(new Font("SansSerif", Font.PLAIN, 17));
            btn.setSize(128, 38);
            return btn;
    }  


    protected void setFrameBackground(final String path) {
            JPanel imgPanel = new JPanel() {  
            public void paintComponent(Graphics g) {                   
                 g.drawImage(uiHelper.getImage(path), 0, 0, 1600, 835, this);  
            }  
       };

       getContentPane().add(imgPanel);
    }

    protected Image getImageByPath(String path) {
        Image imgIcon = new ImageIcon(this.getClass().getResource(path)).getImage();
        return imgIcon;
    }
    
    protected ImageIcon getImageIconByPath(String path) {
        ImageIcon imgIcon = new ImageIcon(this.getClass().getResource(path));
        return imgIcon;
    }

    protected JButton getButtonSettings(JButton btn, String name) {
            if (btn == null) {
                    btn = new JButton();
            }
            btn.setText(name);
            return this.getButtonSettings(btn);		
    }
    
    protected boolean showValidationErrors(ArrayList<String> errorLists) {
       return this.utility.showValidationErrors(errorLists);
    }
    
    protected ArrayList<String>  addError(ArrayList<String> errors, String message) {
      return this.utility.addError(errors, message);
    }
    
    protected boolean confirmCanel() {
        return this.utility.confirmCancel();
    }
    
    protected boolean confirmDelete() {
        return this.utility.confirmDelete();
    }
    
    protected void showInfo(String title, String message) {
        this.utility.showInfo(title, message);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
