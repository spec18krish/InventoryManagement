/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Users;

import Enums.NavigationAction;
import EventObject.TabChangeEventObj;
import Presentation.Common.TabNavigationFrame;
import Presentation.Order.BrowsePurchaseOrder;
import Presentation.Order.PurchaseOrderDetail;
import Presentation.Order.PurchaseOrderFilter;
import domainModels.PurchaseModel;
import domainModels.UserModel;
import java.util.List;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author Vidhya Mohan
 */
public class UserNavigation  extends TabNavigationFrame {   
    
        
    UserDetail userDetail;
    BrowseUser browseUser;
    UserFilter userFilter;
    
    public UserNavigation() {
        super();    
        this.useMigLayout();
        initializeUserNavigation();
    }
    
    
    public void initializeUserNavigation() {
        userDetail = new UserDetail();
        browseUser = new BrowseUser();        
        userFilter = new UserFilter();
        
        
        pnlBrowse.add(userFilter, "span, growx, pushx");
        pnlBrowse.add(browseUser, "span, growx, pushx");   
        pnlDetail.add(userDetail, "span, growx, pushx");
        
        userFilter.addOnSearchChanged(e -> this.onSearchChanged(e));
        userDetail.addChangeTabRequest(e -> this.changeTab(e));       
        browseUser.addDataNavigationChanged(e -> this.dataNavigationChanged((UserModel)e));
        browseUser.addChangeTabRequest(e -> this.changeTab(e));   
        
        actionBar.setActionBarActions(NavigationAction.Browse);
    }
    
    protected void dataNavigationChanged(UserModel model) {
        userDetail.load(model);
        enableDetail(true);
    }

    @Override
    protected void changeTab(TabChangeEventObj eventObj) {         
        if (eventObj.tabIndex == 1)
        {
            if (eventObj.navAction == NavigationAction.Update) 
            {
              userDetail.load((UserModel) eventObj.model);
            }
            else {
                userDetail.setDefaultValues();
            }
            tabControl.setSelectedIndex(eventObj.tabIndex);
            tabControl.setEnabledAt(eventObj.tabIndex, true);
            actionBar.setActionBarActions(eventObj.navAction);
        }
       else 
        if (eventObj.tabIndex == 0)
        {
            tabControl.setSelectedIndex(eventObj.tabIndex);
            browseUser.setGrid();
            actionBar.setActionBarActions(eventObj.navAction);
        }
    }
    
    @Override
    protected void TabChangeListener(ChangeEvent e){
        super.TabChangeListener(e);
    }
    
     @Override
    protected void onSearchChanged(Object userModel) {
         this.browseUser.loadGrid((List<UserModel>)userModel);
    }
    
        
     @Override
    protected void save() {
        userDetail.save();
    }
    
    @Override
    protected void add() {
        this.changeTab(new TabChangeEventObj(1, null, NavigationAction.Create));
    }
    
    @Override
    protected void delete() {
        userDetail.delete();
    }
    
    @Override 
    protected void update() {
        userDetail.update();
    }
    
    @Override 
    protected void cancel() {
        this.changeTab(new TabChangeEventObj(0, null, NavigationAction.Browse));
    }
    
    @Override 
    protected void goHome() {
        
    }
}
