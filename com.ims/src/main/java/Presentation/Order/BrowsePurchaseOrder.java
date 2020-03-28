/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Order;

import Enums.NavigationAction;
import EventObject.TabChangeEventObj;
import Presentation.Common.TabNavigationPanel;
import customcontrols.GridViewPanel;
import customcontrols.TableModel;
import domainModels.ProductModel;
import domainModels.PurchaseModel;
import interfaces.TabChangeRequestHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import net.miginfocom.swing.MigLayout;
import repository.ProductRepository;
import repository.PurchaseRepository;

/**
 *
 * @author Vidhya Mohan
 */
public class BrowsePurchaseOrder extends TabNavigationPanel {
    
    GridViewPanel<PurchaseModel> grd;
    public BrowsePurchaseOrder() {
        super();
        this.setLayout(new MigLayout());     
        //this.setLayout(new MigLayout());
        initializeBrowseProduct();       
        this.add(grd, "span, grow, push");
        tabChangeHandlers = new ArrayList<TabChangeRequestHandler>();
    }
    
    public void initializeBrowseProduct() {
       grd = new GridViewPanel<PurchaseModel>();       
       loadGrid();
       grd.addDoubleClickHandler(e -> gridViewRowDoubleClicked((PurchaseModel) e));
       grd.addClickHandler(e -> gridViewClicked((PurchaseModel)e));
    }    
    
    public void loadGrid(List<PurchaseModel> purchaseModel) {
        
        HashMap<String, String> columnsKeyVal = new LinkedHashMap<String, String>();    
   
        columnsKeyVal.put("purchaseId", "Purchase Id");
        columnsKeyVal.put("purchaseName", "Purchase Name");
        columnsKeyVal.put("purchaseDescription", "Purchase Description");
        columnsKeyVal.put("purchaseDate", "Purchase Date");
        columnsKeyVal.put("deliveryDate", "Date of Delivery");
        columnsKeyVal.put("shipmentType", "Shipment Type");      
        
       ArrayList<PurchaseModel> arrPurchaseModel = new ArrayList<PurchaseModel>(purchaseModel);
       TableModel<PurchaseModel> tblModel = new TableModel<PurchaseModel>(arrPurchaseModel, columnsKeyVal);
       grd.setModel(tblModel);
    }
    
    public void loadGrid() {        
        PurchaseRepository repo = new PurchaseRepository();
        ArrayList<PurchaseModel> model = repo.getAll();
        this.loadGrid(model);
    }
    
    public void gridViewClicked(PurchaseModel model) {
        this.fireDataNavigationChanged(model);
    }

    public void gridViewRowDoubleClicked(PurchaseModel model) {
       this.fireTabChangeRequest(new TabChangeEventObj(1, model, NavigationAction.Update));
    }

    
}
