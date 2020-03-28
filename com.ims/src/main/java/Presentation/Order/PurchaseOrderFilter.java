/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Order;

import Presentation.Common.TabNavigationPanel;
import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import customcontrols.Button;
import customcontrols.DateTextBox;
import customcontrols.Label;
import customcontrols.LabelTextFieldInline;
import customcontrols.Panel;
import customcontrols.TextBox;
import domainModels.ProductModel;
import domainModels.PurchaseModel;
import java.util.ArrayList;
import java.util.List;
import net.miginfocom.swing.MigLayout;
import repository.ProductCategoryRepository;
import repository.ProductRepository;
import repository.PurchaseRepository;

/**
 *
 * @author Vidhya Mohan
 */
public class PurchaseOrderFilter extends TabNavigationPanel {
    
private Panel filterBox;
private Panel gridBox;

private Label lblPurchaseId;
private TextBox txtPurchaseId;
private Label lblPurchaseName;
private TextBox txtPurchaseName;
private Label lblPurchaseDate;
private DateTextBox txtPurchaseDate;
private Label lblDeliveryDate;
private DateTextBox txtDeliveryDate;

    public PurchaseOrderFilter() {       
        initializeProductFilterPanel();           
    }
    
    private void initializeProductFilterPanel() {       
        this.setLayout(new MigLayout());
        filterBox = new Panel();         
        filterBox.setLayout(new MigLayout());     
        this.setTitle("Search Purchase");
    
        lblPurchaseId = new Label("Purchase Id:");
        lblPurchaseName = new Label("Purchase Name:");
        lblPurchaseDate = new Label("Purchase Date:");
        lblDeliveryDate = new Label("Delivery Date:");
      
        txtPurchaseId = new TextBox();
        txtPurchaseName = new TextBox();
        txtPurchaseDate = new DateTextBox(300, 20);
        txtDeliveryDate = new DateTextBox();

       
        Button btnSearch = new Button("Search");
        btnSearch.addActionListener(e -> this.btnSearch_Click());
     
        filterBox.add(lblPurchaseId);
        filterBox.add(txtPurchaseId, "pushx, sg searchCtrl");
        filterBox.add(lblPurchaseName);
        filterBox.add(txtPurchaseName, "pushx, sg searchCtrl");
        filterBox.add(lblPurchaseDate);
        filterBox.add(txtPurchaseDate, "pushx, sg searchCtrl, wrap");
        
        filterBox.add(lblDeliveryDate);
        filterBox.add(txtDeliveryDate, "pushx, sg searchCtrl");
        filterBox.add(btnSearch, "skip 2, align trailing, gapy 40");       
     

       this.add(filterBox, "span, pushx, grow");     

    }
    
    private void btnSearch_Click() {
        
         int purchaseid = 0;
        if (this.txtPurchaseId.getText().matches("\\d+")) {
            purchaseid = Integer.parseInt(this.txtPurchaseId.getText());
        }
         
        String purchaseName = this.txtPurchaseName.getText();
        String dtPurchaseDate = this.txtPurchaseDate.getDateStringOrEmptyString();
        String drDeliveryDate = this.txtDeliveryDate.getDateStringOrEmptyString();
        
        PurchaseRepository purchaseRepo = new PurchaseRepository();
        List<PurchaseModel> purchaseModel = purchaseRepo.searchEntity(purchaseid ,purchaseName, dtPurchaseDate, drDeliveryDate);
        
        this.fireSearchChanged(purchaseModel);
        
  
    }
    
}
