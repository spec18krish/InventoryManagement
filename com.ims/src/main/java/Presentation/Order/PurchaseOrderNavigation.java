/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Order;

import Enums.NavigationAction;
import EventObject.TabChangeEventObj;
import Presentation.Common.TabNavigationFrame;

import domainModels.PurchaseModel;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author Vidhya Mohan
 */
public class PurchaseOrderNavigation extends TabNavigationFrame {
    
    PurchaseOrderDetail purchaseOrderDetail;
    BrowsePurchaseOrder browsePurchaseOrder;
    
    public PurchaseOrderNavigation() {
        super();    
        this.useMigLayout();
        initializeOrderNavigation();
    }
    
    
    public void initializeOrderNavigation() {
        purchaseOrderDetail = new PurchaseOrderDetail();
        browsePurchaseOrder = new BrowsePurchaseOrder();        
        
        pnlBrowse.add(browsePurchaseOrder, "span, growx, pushx");   
        pnlDetail.add(purchaseOrderDetail, "span, growx, pushx");
        
        browsePurchaseOrder.addChangeTabRequest(e -> this.changeTab(e));
        purchaseOrderDetail.addChangeTabRequest(e -> this.changeTab(e));
        browsePurchaseOrder.addDataNavigationChanged(e -> this.dataNavigationChanged((PurchaseModel)e));
        
        actionBar.setActionBarActions(NavigationAction.Browse);
    }
    
    protected void dataNavigationChanged(PurchaseModel model) {
        purchaseOrderDetail.load(model);
    }

    @Override
    protected void changeTab(TabChangeEventObj eventObj) {         
        if (eventObj.tabIndex == 1)
        {
            if (eventObj.navAction == NavigationAction.Update) 
            {
              purchaseOrderDetail.load((PurchaseModel) eventObj.model);
            }
            else {
                purchaseOrderDetail.setDefaultValues();
            }
            tabControl.setSelectedIndex(eventObj.tabIndex);
            actionBar.setActionBarActions(eventObj.navAction);
        }
       else 
        if (eventObj.tabIndex == 0)
        {
            tabControl.setSelectedIndex(eventObj.tabIndex);
            browsePurchaseOrder.loadGrid();
            actionBar.setActionBarActions(eventObj.navAction);
        }
    }
    
        @Override
    protected void TabChangeListener(ChangeEvent e){
        int selectedTab = tabControl.getSelectedIndex(); 
        
        if(selectedTab > 0) {
            if (selectedTab == 2) {
                
            }
        }
    }
    
     @Override
    protected void save() {
        purchaseOrderDetail.savePurchase();
    }
    
    @Override
    protected void add() {
        this.changeTab(new TabChangeEventObj(1, null, NavigationAction.Create));
    }
    
    @Override
    protected void delete() {
        purchaseOrderDetail.delete();
    }
    
    @Override 
    protected void update() {
        purchaseOrderDetail.update();
    }
    
    @Override 
    protected void cancel() {
        this.changeTab(new TabChangeEventObj(0, null, NavigationAction.Browse));
    }
    
    @Override 
    protected void goHome() {
        
    }
    
}
