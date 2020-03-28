/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Order;

import Enums.NavigationAction;
import EventObject.TabChangeEventObj;
import Presentation.Common.TabNavigationPanel;
import Presentation.Product.ProductNavigation;
import customcontrols.Button;
import customcontrols.GridCellRenderer;
import customcontrols.GridViewPanel;
import customcontrols.TableModel;
import domainModels.ProductModel;
import domainModels.PurchaseDetailModel;
import domainModels.PurchaseProductModel;
import interfaces.TabChangeRequestHandler;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.TableCellRenderer;
import net.miginfocom.swing.MigLayout;
import repository.ProductRepository;

/**
 *
 * @author Vidhya Mohan
 */
public class PurchaseProduct extends TabNavigationPanel {
    
      GridViewPanel<PurchaseDetailModel> grd;
      PurchaseProductDetail purchaseProductDetail;
      
    private JDialog dialog;
    public PurchaseProduct() {
        super();
        this.setLayout(new MigLayout());     
        //this.setLayout(new MigLayout());
        initializeBrowseProduct();
        this.add(grd, "span, grow, push");
        purchaseProductDetail = new PurchaseProductDetail();   
        purchaseProductDetail.setPreferredSize(new Dimension(500, 500 ));
        tabChangeHandlers = new ArrayList<TabChangeRequestHandler>();        
    }
    
    public void initializeBrowseProduct() {
       grd = new GridViewPanel<PurchaseDetailModel>(); 
       grd.addDoubleClickHandler(e -> gridViewRowDoubleClicked((PurchaseDetailModel) e));       
    }    
    
    public void loadGrid(ArrayList<PurchaseDetailModel> purchaseDetailModel) {
       
        HashMap<String, String> columnsKeyVal = new LinkedHashMap<String, String>();    
   
        columnsKeyVal.put("productId", "Product Id");
        columnsKeyVal.put("product-name", "Product Name");
        columnsKeyVal.put("product-availableStock", "Available Stock");        
        columnsKeyVal.put("product-price", "Price");
        columnsKeyVal.put("product-category-categoryName", "Category");
        columnsKeyVal.put("product-brand-brandName", "Brand Name");
        columnsKeyVal.put("quantity", "Quantity Required");  
        columnsKeyVal.put("requireOrder", "Add To Order");
        
        TableModel<PurchaseDetailModel> tblModel = new TableModel<PurchaseDetailModel>(purchaseDetailModel, columnsKeyVal);
        grd.setModel(tblModel);
       
   //    TableCellRenderer tableRenderer = grd.getGridView().getDefaultRenderer(Button.class);
       
       //grd.getGridView().setDefaultRenderer(Button.class, new GridCellRenderer(tableRenderer));
//       grd.getGridView().getColumn("Add To Order").setCellRenderer(new GridCellRenderer(tableRenderer, Button.class));
       
      
    }
    
    
    public List<PurchaseDetailModel> getUserEnteredValues() {
        List<PurchaseDetailModel> gridModel = this.grd.getModel().getGridModel();        
        return gridModel.stream().filter(f -> f.requireOrder).collect(Collectors.toList());
    }


    public void gridViewRowDoubleClicked(PurchaseDetailModel model) {
        
     // ImageIcon imgIcon = new ImageIcon(this.getClass().getResource("/images/catalog/Orders.png"));
      purchaseProductDetail.setModelValues(model);
      int result = JOptionPane.showConfirmDialog(null, purchaseProductDetail, "Product Order",JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE);
      
      if (result == JOptionPane.OK_OPTION) {
          PurchaseDetailModel userEnteredValues = purchaseProductDetail.getUserEnteredValues();
           if (userEnteredValues.requireOrder) {
                 model.quantity = userEnteredValues.quantity;
                 model.purchaseNotes = userEnteredValues.purchaseNotes;
                 model.requireOrder = userEnteredValues.requireOrder;   
           } else {
                 model.quantity = 0;
                 model.purchaseNotes = "";
                 model.requireOrder = userEnteredValues.requireOrder; 
           }
          
         grd.getModel().fireTableDataChanged();
      }    
      
    }
    
   
    
}
