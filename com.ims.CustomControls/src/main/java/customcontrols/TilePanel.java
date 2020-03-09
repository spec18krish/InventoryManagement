/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customcontrols;

import Skin.Skin;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Vidhya Mohan
 */
public class TilePanel extends javax.swing.JPanel {

    public String tileName = "tile name";
    public String tileContent = "tile content";
    public ImageIcon tileIcon;
    public Dimension tileSize;
    public String tileSecondaryContent = "";
    private Skin skin = new Skin();
    
    public TilePanel() {
        initComponents();
        initialize();
    }
    
      public TilePanel(String name, String content, String secContent, ImageIcon img, Dimension tileDimension) {
        this.tileName = name;
        this.tileContent = content;
        this.tileSecondaryContent = secContent;
        this.tileIcon = img;
        this.setPreferredSize(tileDimension);
        initComponents();
        initialize();
    }
    
    public void initialize() {
        
        lblTitle.setText(tileName);
        lblTitle.setForeground(skin.milkWhiteColor);
        lblTitle.setFont(skin.fontBold20);
        
        lblContent.setText(tileContent);
        lblContent.setForeground(skin.milkWhiteColor);
        lblContent.setFont(skin.fontBold30);
        
        lblSecondaryContent.setForeground(skin.milkWhiteColor);
        lblSecondaryContent.setFont(skin.font22);
        lblSecondaryContent.setText(tileSecondaryContent);
        
        this.lblIcon.setText("");
        this.lblIcon.setIcon((Icon) tileIcon);
       
      
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblContent = new javax.swing.JLabel();
        lblIcon = new javax.swing.JLabel();
        lblSecondaryContent = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("jLabel1");
        add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        lblContent.setText("jLabel2");
        add(lblContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        lblIcon.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblIcon.setText("jLabel3");
        add(lblIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 65, -1, -1));

        lblSecondaryContent.setText("jLabel1");
        add(lblSecondaryContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblContent;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblSecondaryContent;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}
