/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Order;

import Enums.NavigationAction;
import EventObject.TabChangeEventObj;
import Presentation.Common.TabNavigationFrame;
import domainModels.ProductModel;

import domainModels.PurchaseModel;
import java.util.List;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author Vidhya Mohan
 */
public class PurchaseOrderNavigation extends TabNavigationFrame {
    
    PurchaseOrderDetail purchaseOrderDetail;
    BrowsePurchaseOrder browsePurchaseOrder;
    PurchaseOrderFilter purchaseOrderFilter;
    
    public PurchaseOrderNavigation() {
        super();    
        this.useMigLayout();
        initializeOrderNavigation();
    }
    
    
    public void initializeOrderNavigation() {
        purchaseOrderDetail = new PurchaseOrderDetail();
        browsePurchaseOrder = new BrowsePurchaseOrder();        
        purchaseOrderFilter = new PurchaseOrderFilter();
        
        pnlBrowse.add(purchaseOrderFilter, "span, growx, pushx");
        pnlBrowse.add(browsePurchaseOrder, "span, growx, pushx");   
        pnlDetail.add(purchaseOrderDetail, "span, growx, pushx");
        
        purchaseOrderFilter.addOnSearchChanged(e -> this.onSearchChanged(e));
        browsePurchaseOrder.addChangeTabRequest(e -> this.changeTab(e));
        purchaseOrderDetail.addChangeTabRequest(e -> this.changeTab(e));
        browsePurchaseOrder.addDataNavigationChanged(e -> this.dataNavigationChanged((PurchaseModel)e));
        
        actionBar.setActionBarActions(NavigationAction.Browse);
    }
    
    protected void dataNavigationChanged(PurchaseModel model) {
        purchaseOrderDetail.load(model);
        enableDetail(true);
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
            tabControl.setEnabledAt(eventObj.tabIndex, true);
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
        super.TabChangeListener(e);
    }
    
     @Override
    protected void onSearchChanged(Object purchaseModel) {
         this.browsePurchaseOrder.loadGrid((List<PurchaseModel>)purchaseModel);
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
