/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prsentation.Dealers;

import Enums.NavigationAction;
import EventObject.TabChangeEventObj;
import Presentation.Common.TabNavigationFrame;
import Presentation.Product.BrowseProduct;
import Presentation.Product.ProductDetail;
import Presentation.Product.ProductFilterPanel;
import domainModels.DealerModel;
import domainModels.ProductModel;
import java.awt.Color;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author Vidhya Mohan
 */
public class DealerNavigation extends TabNavigationFrame
{
    
    BrowseDealer browseDealer;
    DealerDetail dealerDetail;
    

    /**
     * Creates new form ProductNavigation
     */
    public DealerNavigation() {
        super();    
        this.useMigLayout();
        initializeDealerNavigation();
    }
    
    public void initializeDealerNavigation() {    

        browseDealer = new BrowseDealer(); 
        dealerDetail = new DealerDetail();
              

        pnlBrowse.add(browseDealer, "span, growx, pushx");   
        pnlDetail.add(dealerDetail, "span, growx, pushx");
        browseDealer.addChangeTabRequest(e -> this.changeTab(e));
        dealerDetail.addChangeTabRequest(e -> this.changeTab(e));
        browseDealer.addDataNavigationChanged(e -> this.dataNavigationChanged((DealerModel)e));
        
        actionBar.setActionBarActions(NavigationAction.Browse);
    }   
    
    protected void dataNavigationChanged(DealerModel model) {
        dealerDetail.load(model);
    }

    @Override
    protected void changeTab(TabChangeEventObj eventObj) {         
        if (eventObj.tabIndex == 1)
        {
            if (eventObj.navAction == NavigationAction.Update) 
            {
              dealerDetail.load((DealerModel) eventObj.model);
            }
            else {
                dealerDetail.setDefaultValues();
            }
            tabControl.setSelectedIndex(eventObj.tabIndex);
            actionBar.setActionBarActions(eventObj.navAction);
        }
       else 
        if (eventObj.tabIndex == 0)
        {
            tabControl.setSelectedIndex(eventObj.tabIndex);
            browseDealer.loadGrid();
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
        dealerDetail.save();
    }
    
    @Override
    protected void add() {
        this.changeTab(new TabChangeEventObj(1, null, NavigationAction.Create));
    }
    
    @Override
    protected void delete() {
        dealerDetail.delete();
    }
    
    @Override 
    protected void update() {
        dealerDetail.update();
    }
    
    @Override 
    protected void cancel() {
        this.changeTab(new TabChangeEventObj(0, null, NavigationAction.Browse));
    }
    
}
