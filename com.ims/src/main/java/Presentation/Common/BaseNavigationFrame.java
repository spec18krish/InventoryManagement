/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Common;

import Enums.ActionBarActions;
import Enums.UserRole;
import Presentation.About.AboutNavigation;
import Presentation.Brand.ProductBrandNavigation;
import Presentation.Category.ProductCategoryNavigation;
import Presentation.ContactDealer.ContactDealerNavigation;
import Presentation.DashBoard;
import Presentation.Login;
import Presentation.Order.PurchaseOrderNavigation;
import Presentation.Product.ProductNavigation;
import Presentation.Users.UserNavigation;
import Prsentation.Dealers.DealerNavigation;
import customcontrols.ActionBar;
import customcontrols.Label;
import customcontrols.NavigationLink;
import customcontrols.Panel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import repository.UserSessionRepository;

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
    
    public ActionBarActions currentUserAction;
    
    public NavigationLink sideNavDashBoard; 
    public NavigationLink sideNavProducts;  
    public NavigationLink sideNavOrders;
    public NavigationLink sideNavDealers;
    public NavigationLink sideNavContactDealer;
    public  NavigationLink sideNavUsers; 
    public  NavigationLink sideNavCategory;
    public  NavigationLink sideNavBrand; 
    public  NavigationLink sideNavAbout; 
    
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
        String userRole = UserSessionRepository.getUserRole();
        String welcome = "Welcome " + UserSessionRepository.getFirstName()+ " ("+userRole+")";
        
        boolean isAdmin = false;
        boolean isManager = false;
        boolean isSalesRep = false;
        
          if (userRole.equals("Admin")) {
              this.actionBar.setUserRole(UserRole.Admin);
              isAdmin = true;
          }
          else
          if (userRole.equals("Manager")) {
              this.actionBar.setUserRole(UserRole.Manager);
              isManager = true;
          }
          else
          if (userRole.equals("SalesPerson")) {
              this.actionBar.setUserRole(UserRole.SalesRep);
              isSalesRep = true;
          }
        
        ImageIcon navHomeImage = getImageIconByPath("/Images/sideNavigation/navHome.png");
        ImageIcon navProductsImage = getImageIconByPath("/Images/sideNavigation/navProducts.png");
        ImageIcon navOrdersImage = getImageIconByPath("/Images/sideNavigation/navOrders.png");
        ImageIcon navDealersImage = getImageIconByPath("/Images/sideNavigation/navDealers.png");
        ImageIcon navContactDealer = getImageIconByPath("/Images/sideNavigation/navEmail.png");
        ImageIcon navUsersImage = getImageIconByPath("/Images/sideNavigation/navUsers.png");
        ImageIcon navCategoryImage = getImageIconByPath("/Images/sideNavigation/navCategory.png");
        ImageIcon navBrandImage = getImageIconByPath("/Images/sideNavigation/navBrand.png");
        ImageIcon navAbout = getImageIconByPath("/Images/sideNavigation/navAbout.png");
        
        
        sideNavDashBoard = new NavigationLink("Dashboard", navHomeImage);
        sideNavProducts = new NavigationLink("Products", navProductsImage);
        sideNavOrders = new NavigationLink("Orders", navOrdersImage);
        sideNavDealers = new NavigationLink("Dealers", navDealersImage);
        sideNavContactDealer = new NavigationLink("Contact Dealers", navContactDealer);
        sideNavUsers = new NavigationLink("Users", navUsersImage);
        sideNavCategory = new NavigationLink("Category", navCategoryImage);
        sideNavBrand = new NavigationLink("Brand", navBrandImage);
        sideNavAbout = new NavigationLink("About", navAbout);   
        
        Label lblWelcome = new Label();
        lblWelcome.setText(welcome);
        lblWelcome.setFont(skin.font20);
        lblWelcome.setForeground(skin.goldenColor);
        lblWelcome.setPreferredSize(new Dimension(100, 20));
        
        sideNavigation.add(lblWelcome, "wrap, grow, pushx, gapy 20");        
        sideNavigation.add(sideNavDashBoard, "wrap, grow, pushx, gapy 20");
        sideNavigation.add(sideNavProducts, "wrap, grow, pushx, gapy 20");
        sideNavigation.add(sideNavOrders, "wrap, grow, gapy 20");
        
        if (isAdmin || isManager) 
        {           
            sideNavigation.add(sideNavDealers, "wrap, grow, pushx, gapy 20");        
        
            if (isAdmin) 
            {
               sideNavigation.add(sideNavUsers, "wrap, grow, pushx, gapy 20");
            }  
    
        }
          sideNavigation.add(sideNavContactDealer, "wrap, grow, pushx, gapy 20");
          sideNavigation.add(sideNavCategory, "wrap, grow, pushx, gapy 20");
          sideNavigation.add(sideNavBrand, "wrap, grow, pushx, gapy 20");
          sideNavigation.add(sideNavAbout, "wrap, grow, pushx, gapy 20");
          
       
        sideNavDashBoard.addActionListener(e -> {   
          this.clearActiveNav();
          sideNavDashBoard.setActive();
          DashBoard dash = new DashBoard();
          dash.setVisible(true);
          this.setVisible(false);  
            
        });
        
        sideNavProducts.addActionListener(e -> {        
            this.clearActiveNav();
            sideNavProducts.setActive();
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
        
        sideNavContactDealer.addActionListener(e -> { 
          ContactDealerNavigation contactDealer = new ContactDealerNavigation();
          contactDealer.setVisible(true);
          this.setVisible(false);
        });
        
        sideNavOrders.addActionListener(e -> {
          PurchaseOrderNavigation purchaseOrder = new PurchaseOrderNavigation();
          purchaseOrder.setVisible(true);
          this.setVisible(false);
        });
        
        sideNavBrand.addActionListener(e -> {
          ProductBrandNavigation brandNav = new ProductBrandNavigation();
          brandNav.setVisible(true);
          this.setVisible(false);   
        });
        
        sideNavUsers.addActionListener(e -> {
          UserNavigation userNav = new UserNavigation();
          userNav.setVisible(true);
          this.setVisible(false);       
            
        });
        
        sideNavAbout.addActionListener(e -> { 
          AboutNavigation about = new AboutNavigation();
          about.setVisible(true);
          this.setVisible(false);
        });

        
    }
    
    public void clearActiveNav() {
        sideNavDashBoard.setInactive();
        sideNavProducts.setInactive();
        sideNavOrders.setInactive();
        sideNavDealers.setInactive();
        sideNavContactDealer.setInactive();
        sideNavUsers.setInactive();
        sideNavCategory.setInactive();
        sideNavBrand.setInactive();
        sideNavAbout.setInactive();
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
                break;
            case Logout:
                logout();
                break;
                
        }
        this.currentUserAction = action;
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
        UserSessionRepository.logout();
        Login login = new Login();
        login.setVisible(true);
        this.setVisible(false);
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
