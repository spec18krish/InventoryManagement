/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Order;

import Presentation.Common.TabNavigationPanel;
import customcontrols.Label;
import customcontrols.TextBox;
import domainModels.PurchaseDetailModel;
import domainModels.PurchaseProductModel;
import java.awt.Dimension;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Vidhya Mohan
 */
public class PurchaseProductDetail extends TabNavigationPanel {
    Label lblProductQuantity;
    Label lblPurchaseProductDescription;
    Label lblRequiredOrdering;
    
    TextBox txtProductQuantity;
    TextBox txtPurchaseProductDescription;
    JCheckBox chkRequiredOrdering;

    
    
    public PurchaseProductDetail() {
        super();
        this.setLayout(new MigLayout());
        this.setPreferredSize(new Dimension(650, 350));
        initializePurchaseProductDetail();
    }
    
    
    public void initializePurchaseProductDetail() {
       lblProductQuantity = new Label("Product Quantity: ");
       txtProductQuantity = new TextBox();
       lblPurchaseProductDescription = new Label("Product Description: ");
       txtPurchaseProductDescription = new TextBox();       
       lblRequiredOrdering = new Label("Required Ordering: ");
       chkRequiredOrdering = new JCheckBox();

       

       this.add(lblProductQuantity);
       this.add(txtProductQuantity, "wrap");
       this.add(lblPurchaseProductDescription);
       this.add(txtPurchaseProductDescription, "wrap");
       this.add(lblRequiredOrdering);
       this.add(chkRequiredOrdering, "wrap");

    }
    
    public PurchaseDetailModel getUserEnteredValues() {
        PurchaseDetailModel pModel = new PurchaseDetailModel();
        pModel.quantity = Integer.parseInt(this.txtProductQuantity.getText());
        pModel.purchaseNotes = this.txtPurchaseProductDescription.getText();
        pModel.requireOrder = this.chkRequiredOrdering.isSelected();
        return pModel;
    }
    
    public void setDefaultValues() {
        PurchaseDetailModel pModel = new PurchaseDetailModel();
        this.txtProductQuantity.setText("");
        this.txtPurchaseProductDescription.setText("");
        this.chkRequiredOrdering.setSelected(false);        
    }
    
    public void setModelValues(PurchaseDetailModel pModel) {        
        this.txtProductQuantity.setText( Integer.toString(pModel.quantity));
        this.txtPurchaseProductDescription.setText(pModel.purchaseNotes);
        this.chkRequiredOrdering.setSelected(pModel.requireOrder);        
    }
}
