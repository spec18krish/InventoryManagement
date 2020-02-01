/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Presentation.Common.BaseNavigationFrame;
import customcontrols.CatalogPanel;
import customcontrols.Label;
import customcontrols.TilePanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.netbeans.lib.awtextra.AbsoluteLayout;



/**
 *
 * @author Vidhya Mohan
 */
public class DashBoard extends BaseNavigationFrame {

    private JPanel pnlInfoBox;
    private TilePanel pnlTodaySales;
    private TilePanel pnlLastWeekSales;
    private TilePanel pnlRecentOrders;
    private TilePanel pnlProductsToOrder;
    public TilePanel pnlTest = new TilePanel();
    
    public DashBoard() {
        super();
        initComponents();
        this.setBackground(this.skin.frameBackgroundColor);       
        this.setSize(this.skin.frameDimension);
        int width = skin.frameDimension.width;   
        super.setPanes();
        super.setNavigation();
        initialize();
    }
    
    public void initialize() {
        
        Dimension tileDimension = new Dimension(350, 200);
        Dimension menuItemDimension = new Dimension(350,250);
        Color menuItemColor = skin.blueGreenColor;
        
        centerPane.setLayout(new BoxLayout(centerPane, BoxLayout.PAGE_AXIS));
        pnlInfoBox = new javax.swing.JPanel(new FlowLayout(FlowLayout.LEADING, 30, 30));      
  
        
        JPanel menu = new JPanel(new FlowLayout(FlowLayout.LEADING, 30, 30));
        CatalogPanel mProduct;
        CatalogPanel mOrders;
        CatalogPanel mDealers;
        CatalogPanel mUsers;
        CatalogPanel mReturns;
        CatalogPanel mSettings;
        CatalogPanel mContactDealer;
        
        Label lblSummary = new Label();        
        lblSummary.setText("Summary"); 
        lblSummary.setBorder(new EmptyBorder(0,0,10,0));
        lblSummary.setFont(skin.font22);      
        lblSummary.setAlignmentX(Component.LEFT_ALIGNMENT);
        centerPane.add(lblSummary);
        

        pnlInfoBox.setPreferredSize(new Dimension(1500,280));
        pnlInfoBox.setMaximumSize(new Dimension(1600,280)); 
        
        ImageIcon pInfoImg = getImageIconByPath("/Resources/Images/summary/Sales.png");
        pnlTodaySales = new TilePanel("Today Sales", "24", "Products Sold",pInfoImg, tileDimension);        
        pnlTodaySales.setBackground(skin.skyBlueColor);         
        pnlInfoBox.add(pnlTodaySales);

        ImageIcon lastWeekSaleImg = getImageIconByPath("/Resources/Images/summary/WeekSale.png");
        pnlLastWeekSales = new TilePanel("Last Week Sale", "23432", "Products Sold",lastWeekSaleImg, tileDimension);        
        pnlLastWeekSales.setBackground(skin.skyGreenColor);         
        pnlInfoBox.add(pnlLastWeekSales);
       

        ImageIcon recentOrdersImg = getImageIconByPath("/Resources/Images/summary/orders.png");
        pnlRecentOrders = new TilePanel("Recent Orders", "23432", "Orders made",recentOrdersImg, tileDimension);      
        pnlRecentOrders.setBackground(skin.sandalYellowColor);
        pnlInfoBox.add(pnlRecentOrders);
        
        
        ImageIcon productsToORderImg = getImageIconByPath("/Resources/Images/summary/product.png");
        pnlProductsToOrder = new TilePanel("Products To Order", "1234", "Products",productsToORderImg, tileDimension);      
        pnlProductsToOrder.setBackground(skin.bloodRedColor);
        pnlInfoBox.add(pnlProductsToOrder);       
       
        
        pnlInfoBox.setAlignmentX(LEFT_ALIGNMENT);        
        pnlInfoBox.setBackground(skin.darkSilverColor);     
        centerPane.add(pnlInfoBox);        
     
        ImageIcon productsCatalogImage = getImageIconByPath("/Resources/Images/Catalog/products.png");
        mProduct = new CatalogPanel("Products", productsCatalogImage, menuItemDimension );
        mProduct.setBackground(menuItemColor);       
        menu.add(mProduct);
        
        ImageIcon ordersCatalogImage = getImageIconByPath("/Resources/Images/Catalog/Orders.png");
        mOrders = new CatalogPanel("Orders", ordersCatalogImage, menuItemDimension );
        mOrders.setBackground(menuItemColor);       
        menu.add(mOrders);       
       
        
        ImageIcon dealersCatalogImage = getImageIconByPath("/Resources/Images/Catalog/suppliers.png");
        mDealers = new CatalogPanel("Dealers", dealersCatalogImage, menuItemDimension );
        mDealers.setBackground(menuItemColor);       
        menu.add(mDealers); 
        
  
        ImageIcon usersCatalogImage = getImageIconByPath("/Resources/Images/catalog/users.png");
        mUsers = new CatalogPanel("Users", usersCatalogImage, menuItemDimension );
        mUsers.setBackground(menuItemColor);       
        menu.add(mUsers); 
      
        ImageIcon returnsCatalogImage = getImageIconByPath("/Resources/Images/catalog/returns.png");
        mReturns = new CatalogPanel("Returns", returnsCatalogImage, menuItemDimension );
        mReturns.setBackground(menuItemColor);       
        menu.add(mReturns); 
       
        ImageIcon settingsCatalogImage = getImageIconByPath("/Resources/Images/catalog/settings.png");
        mSettings = new CatalogPanel("Settings", settingsCatalogImage, menuItemDimension );
        mSettings.setBackground(menuItemColor);       
        menu.add(mSettings); 
        
        ImageIcon sendEmailCatalogImage = getImageIconByPath("/Resources/Images/catalog/email.png");
        mContactDealer = new CatalogPanel("Contact Dealer", sendEmailCatalogImage, menuItemDimension );
        mContactDealer.setBackground(menuItemColor);       
        menu.add(mContactDealer); 
        
       
        menu.setAlignmentX(LEFT_ALIGNMENT);
        centerPane.add(menu);

      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1800, 239));
        setPreferredSize(new java.awt.Dimension(1800, 239));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1412, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 721, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
