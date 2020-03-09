/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customcontrols;

import Enums.ActionBarActions;
import Enums.NavigationAction;
import Skin.Skin;
import interfaces.ActionBarItemClickedHandler;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Panel;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

/**
 *
 * @author Vidhya Mohan
 */


public class ActionBar extends javax.swing.JPanel {
    
  private List<ActionBarItemClickedHandler> listeners = new ArrayList<ActionBarItemClickedHandler>();
  private Skin skin = new Skin();
    public ActionBar() {
        initComponents();              

      
        this.setBackground(this.skin.skyBlueColor);
        int width = skin.frameDimension.width;
        
        this.setPreferredSize(new Dimension(width,60));
      
        this.pnlInnerRight.setBackground(this.skin.skyBlueColor);    
        this.btnHome.setIcon(getImageIcon("/Icons/home.png"));
        this.btnAdd.setIcon(getImageIcon("/Icons/add.png"));
        this.btnUpdate.setIcon(getImageIcon("/Icons/update.png"));
        this.btnSave.setIcon(getImageIcon("/Icons/save.png"));
        this.btnCancel.setIcon(getImageIcon("/Icons/cancel.png"));
        this.btnLogout.setIcon(getImageIcon("/Icons/logout.png"));
        this.btnDelete.setIcon(getImageIcon("/Icons/delete.png"));
        
        this.lblTitle.setFont(this.skin.fontBold24);
        this.lblTitle.setForeground(this.skin.milkWhiteColor);
        
        this.pnlInnerLeft.setBackground(this.skin.skyBlueColor);    
        //add(Box.createHorizontalStrut(400));
        this.pnlFiller.setPreferredSize(new Dimension(500,50));
        
        this.setActionClickedEvents();
    }
    
    public void setActionBarActions(NavigationAction navAction) 
    {
        switch(navAction) 
        {
            case Create:
                setCreateMode();
                break;                
            case Browse:
                setListMode();
                break;
            case Update:
            case Delete:
                setUpdateMode();  
                break;
            
        }
        
    }
    
    public void setHomeMode() {
        this.btnHome.setVisible(false);
        this.btnAdd.setVisible(false);
        this.btnSave.setVisible(false);
        this.btnCancel.setVisible(false);
        this.btnUpdate.setVisible(false);   
        this.btnDelete.setVisible(false);
        this.btnLogout.setVisible(true);
    }
    
    public void setCreateMode() {
        this.btnHome.setVisible(false);
        this.btnAdd.setVisible(false);
        this.btnSave.setVisible(true);
        this.btnCancel.setVisible(true);
        this.btnUpdate.setVisible(false);   
        this.btnDelete.setVisible(false);
        this.btnLogout.setVisible(false);
    }
    
    public void setUpdateMode() {
        this.btnHome.setVisible(false);
        this.btnAdd.setVisible(false);
        this.btnSave.setVisible(false);
        this.btnCancel.setVisible(true);
        this.btnUpdate.setVisible(true);
        this.btnDelete.setVisible(true);
        this.btnLogout.setVisible(false);
    }
    
    public void setListMode() {
        this.btnHome.setVisible(true);
        this.btnAdd.setVisible(true);
        this.btnSave.setVisible(false);
        this.btnCancel.setVisible(false);
        this.btnUpdate.setVisible(false);
        this.btnDelete.setVisible(false);
        this.btnLogout.setVisible(true);
    }
    
    public void addClickedListener(ActionBarItemClickedHandler event) {
        listeners.add(event);
    }
    
    private void setActionClickedEvents() {
        this.btnHome.addActionListener(e -> { fireEvents(ActionBarActions.Home); });
        this.btnAdd.addActionListener(e -> { fireEvents(ActionBarActions.Add); });
        this.btnSave.addActionListener(e -> { fireEvents(ActionBarActions.Save); });
        this.btnCancel.addActionListener(e -> { fireEvents(ActionBarActions.Cancel); });
        this.btnUpdate.addActionListener(e -> { fireEvents(ActionBarActions.Update); });
        this.btnDelete.addActionListener(e -> { fireEvents(ActionBarActions.Delete); }); 
        this.btnLogout.addActionListener(e -> { fireEvents(ActionBarActions.Logout); });        
    }
    
    private void fireEvents(ActionBarActions action) {
        for(ActionBarItemClickedHandler event : listeners) {
            event.onClick(action);
        }
    }
    
      public ImageIcon getImageIcon(String path) {
       return new ImageIcon(this.getClass().getResource(path));
    }
      
    
    
   


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));
        add(Box.createHorizontalStrut(20));
        pnlInnerLeft = new javax.swing.JPanel();
        lblTitle = new customcontrols.Label();
        pnlFiller = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        pnlInnerRight = new javax.swing.JPanel();
        btnHome = new customcontrols.ActionBarItem();
        btnAdd = new customcontrols.ActionBarItem();
        btnUpdate = new customcontrols.ActionBarItem();
        btnSave = new customcontrols.ActionBarItem();
        btnDelete = new customcontrols.ActionBarItem();
        btnCancel = new customcontrols.ActionBarItem();
        btnLogout = new customcontrols.ActionBarItem();

        setBackground(new java.awt.Color(0, 153, 204));
        setMinimumSize(new java.awt.Dimension(1750, 50));
        setPreferredSize(new java.awt.Dimension(1800, 60));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        lblTitle.setText("Inventory Management System");
        pnlInnerLeft.add(lblTitle);

        pnlInnerLeft.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 10));

        add(pnlInnerLeft);

        pnlFiller.setBackground(new java.awt.Color(255, 102, 51));
        add(pnlFiller);

        pnlInnerRight.setLayout(new FlowLayout(FlowLayout.TRAILING, 10,10));
        pnlInnerRight.setBackground(new java.awt.Color(0, 153, 204));
        pnlInnerRight.setPreferredSize(new java.awt.Dimension(1380, 50));
        pnlInnerRight.setBackground(Color.red);

        btnHome.setText("Home");
        btnHome.setMaximumSize(new java.awt.Dimension(63, 50));
        btnHome.setMinimumSize(new java.awt.Dimension(63, 50));
        btnHome.setPreferredSize(new java.awt.Dimension(117, 40));
        pnlInnerRight.add(btnHome);

        btnAdd.setText("Add");
        btnAdd.setPreferredSize(new java.awt.Dimension(117, 40));
        pnlInnerRight.add(btnAdd);

        btnUpdate.setText("Update");
        btnUpdate.setPreferredSize(new java.awt.Dimension(117, 40));
        pnlInnerRight.add(btnUpdate);

        btnSave.setText("Save");
        btnSave.setPreferredSize(new java.awt.Dimension(117, 40));
        pnlInnerRight.add(btnSave);

        btnDelete.setText("Delete");
        btnDelete.setPreferredSize(new java.awt.Dimension(117, 40));
        pnlInnerRight.add(btnDelete);
        btnDelete.getAccessibleContext().setAccessibleName("Delete");

        btnCancel.setText("Cancel");
        btnCancel.setPreferredSize(new java.awt.Dimension(117, 40));
        pnlInnerRight.add(btnCancel);

        btnLogout.setText("Logout");
        btnLogout.setPreferredSize(new java.awt.Dimension(117, 40));
        pnlInnerRight.add(btnLogout);

        pnlInnerRight.add(Box.createRigidArea(new Dimension(20, 0)));

        add(pnlInnerRight);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private customcontrols.ActionBarItem btnAdd;
    private customcontrols.ActionBarItem btnCancel;
    private customcontrols.ActionBarItem btnDelete;
    private customcontrols.ActionBarItem btnHome;
    private customcontrols.ActionBarItem btnLogout;
    private customcontrols.ActionBarItem btnSave;
    private customcontrols.ActionBarItem btnUpdate;
    private javax.swing.Box.Filler filler2;
    private customcontrols.Label lblTitle;
    private javax.swing.Box.Filler pnlFiller;
    private javax.swing.JPanel pnlInnerLeft;
    private javax.swing.JPanel pnlInnerRight;
    // End of variables declaration//GEN-END:variables
}
