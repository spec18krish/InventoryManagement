/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Common;

import Enums.ActionBarActions;
import Presentation.Category.ProductCategoryNavigation;
import Presentation.DashBoard;
import Presentation.Order.PurchaseOrderNavigation;
import Presentation.Product.ProductNavigation;
import Prsentation.Dealers.DealerNavigation;
import customcontrols.ActionBar;
import customcontrols.Label;
import customcontrols.NavigationLink;
import customcontrols.Panel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Vidhya Mohan
 */
public class BaseNavigationFrame extends MainFrame {

    public ActionBar actionBar;
    public JPanel topPane;
    public JPanel centerPane;
    public JPanel bottomPane;
    public JPanel leftPane;
    
    public JPanel sideNavigation;
    
    /**
     * Creates new form BaseNavigationFrame
     */
    public BaseNavigationFrame() {
        super();
        initComponents();         
    }
    
    public void initializeBaseNavigationFrame() {
        setPanes();
        setNavigation();     
      
        this.setBackground(this.skin.frameBackgroundColor);       
        this.setSize(this.skin.frameDimension);       
      
        actionBar.addClickedListener( e -> { ActionItemClickedHandlers(e); });
    }
    
    public void setPanes() {
        setLayout(new BorderLayout());
        topPane = new JPanel();
        topPane.setLayout(new BoxLayout(topPane, BoxLayout.Y_AXIS));
        topPane.setBorder(new EmptyBorder(0,0,0,0));
        add(topPane, BorderLayout.NORTH);
        
        centerPane = new Panel();
        //centerPane.setLayout(new BoxLayout(centerPane, BoxLayout.PAGE_AXIS));
        centerPane.setBorder(new EmptyBorder(15, 15,15,0));        
        add(centerPane, BorderLayout.CENTER);
        
        bottomPane = new Panel();
        bottomPane.setLayout(new BoxLayout(bottomPane, BoxLayout.Y_AXIS));
        bottomPane.setBorder(new EmptyBorder(0,0,0,0));
        add(bottomPane, BorderLayout.SOUTH);
        
        leftPane = new Panel();        
        leftPane.setLayout(new BoxLayout(leftPane, BoxLayout.Y_AXIS));
        add(leftPane, BorderLayout.WEST);        
    }
    
    public void setNavigation() {
        
        actionBar = new ActionBar();
        topPane.add(actionBar);  
        sideNavigation = new Panel();
        initializeSideNavControls();
        sideNavigation.setPreferredSize(new Dimension(300,100));
        sideNavigation.setBackground(skin.slateBlackColor);            
        leftPane.add(sideNavigation);
    }
    
    public void initializeSideNavControls() {        
        sideNavigation.setLayout(new MigLayout());   
        ImageIcon navProductsImage = getImageIconByPath("/Images/sideNavigation/navProducts.png");
        ImageIcon navOrdersImage = getImageIconByPath("/Images/sideNavigation/navOrders.png");
        ImageIcon navDealersImage = getImageIconByPath("/Images/sideNavigation/navDealers.png");
        ImageIcon navUsersImage = getImageIconByPath("/Images/sideNavigation/navUsers.png");
        ImageIcon navCategoryImage = getImageIconByPath("/Images/sideNavigation/navCategory.png");
        ImageIcon navBrandImage = getImageIconByPath("/Images/sideNavigation/navBrand.png");
        ImageIcon navReturnsImage = getImageIconByPath("/Images/sideNavigation/navReturns.png");
        
        NavigationLink sideNavProducts = new NavigationLink("Products", navProductsImage);
        NavigationLink sideNavOrders = new NavigationLink("Orders", navOrdersImage);
        NavigationLink sideNavDealers = new NavigationLink("Dealers", navDealersImage);
        NavigationLink sideNavUsers = new NavigationLink("Users", navUsersImage);
        NavigationLink sideNavCategory = new NavigationLink("Category", navCategoryImage);
        NavigationLink sideNavBrand = new NavigationLink("Brand", navBrandImage);
        NavigationLink sideNavReturns = new NavigationLink("Returns", navReturnsImage);   
        
        
        sideNavigation.add(sideNavProducts, "wrap, grow, pushx, gapy 20");
        sideNavigation.add(sideNavOrders, "wrap, grow, gapy 20");
        sideNavigation.add(sideNavDealers, "wrap, grow, pushx, gapy 20");
        sideNavigation.add(sideNavUsers, "wrap, grow, pushx, gapy 20");
        sideNavigation.add(sideNavCategory, "wrap, grow, pushx, gapy 20");
        sideNavigation.add(sideNavBrand, "wrap, grow, pushx, gapy 20");
        sideNavigation.add(sideNavReturns, "wrap, grow, pushx, gapy 20");
        
        sideNavProducts.addActionListener(e -> {
            ProductNavigation pn = new ProductNavigation();
            pn.setVisible(true);
            this.setVisible(false);
        });
        
        
        sideNavCategory.addActionListener(e -> {
          ProductCategoryNavigation pc = new ProductCategoryNavigation();
          pc.setVisible(true);
          this.setVisible(false);
        });
        
        sideNavDealers.addActionListener(e -> {
          DealerNavigation dealer = new DealerNavigation();
          dealer.setVisible(true);
          this.setVisible(false);
        });
        
        sideNavOrders.addActionListener(e -> {
          PurchaseOrderNavigation purchaseOrder = new PurchaseOrderNavigation();
          purchaseOrder.setVisible(true);
          this.setVisible(false);
        });
        

        
    }
    
    public void ActionItemClickedHandlers(ActionBarActions action) {
        
        switch(action) {
            case Add:
                add();
                break;
            case Save:
                save();
                break;
            case Update:
                update();
                break;
            case Delete:
                delete();
                break;
            case Cancel:
                cancel();
                break;
            case Home:
                goHome();
            case Logout:
                logout();
                
        }
    }
        
    protected void save() {
        
    }
    
    protected void add() {
        
    }
    
    protected void delete() {
        
    }
    
    protected void update() {
        
    }
    
    protected void cancel() {
        
    }
    
    protected void goHome() {
        DashBoard dashBoard = new DashBoard();
        dashBoard.setVisible(true);
               
    }
    
    protected void logout() {
        
    }
    
    public void navigate(BaseNavigationFrame frame) 
    {
          frame.setVisible(true);
          this.setVisible(false);
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

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
