/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Order;

import Presentation.Common.Email.SMTPEmail;
import Presentation.Common.TabNavigationPanel;
import Presentation.Product.BrowseProduct;
import customcontrols.ComboBox;
import customcontrols.DateTextBox;
import customcontrols.Label;
import customcontrols.Panel;
import customcontrols.TextBox;
import domainModels.ProductModel;
import domainModels.PurchaseDetailModel;
import domainModels.PurchaseModel;
import java.awt.Dimension;
import java.awt.Font;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import net.miginfocom.layout.AC;
import net.miginfocom.layout.CC;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;
import repository.ProductRepository;
import repository.PurchaseRepository;

/**
 *
 * @author Vidhya Mohan
 */
public class PurchaseOrderDetail extends TabNavigationPanel {
    
    private Label lblTitle;
    private Label lblPurchaseName;
    private Label lblPurchaseDescription;
    private Label lblProductGrid;
    private Label lblDeliveryDate;
    private Label lblShipmentType;
    
    private TextBox txtPurchaseName;
    private TextBox txtPurchaseDescription;
    private DateTextBox txtDeliveryDate;
    private ComboBox cmbShipmentType;
    private PurchaseProduct purchaseProduct;
    private PurchaseModel purchaseModel;
    
    PurchaseRepository purchaseRepo = new PurchaseRepository();
    public PurchaseOrderDetail() {
        this.purchaseModel = new PurchaseModel();
        initializePurchaseOrderDetail();
    }
    
    public PurchaseOrderDetail(PurchaseModel model) {
        this.purchaseModel = model;
        initializePurchaseOrderDetail();
    }
    
    public void initializePurchaseOrderDetail() {
        
        this.setLayout(new MigLayout());
        
        Panel pnlLeft = new Panel();
        pnlLeft.setLayout(new MigLayout(new LC().gridGapY("10")));
        pnlLeft.setPreferredSize(new Dimension(1200 , 250));
        
        Panel pnlRight = new Panel();
        pnlRight.setLayout(new MigLayout(new LC().gridGapX("30")));
        pnlRight.setPreferredSize(new Dimension(500,250));
              
        
        Panel pnlBottom = new Panel();
        pnlBottom.setLayout(new MigLayout(new LC().fill(), new AC().grow()));
        pnlBottom.setPreferredSize(new Dimension(this.skin.frameDimension.width, 750));
        
        this.lblTitle = new Label("Purchase Order");
        this.lblPurchaseName = new Label("Purchase Name: ");
        this.lblPurchaseDescription = new Label("Purchase Description: ");
        this.lblDeliveryDate = new Label("Delivery Date");
        this.lblProductGrid = new Label("Product Grid: ");
        
        this.txtPurchaseName = new TextBox();
        this.txtPurchaseDescription = new TextBox();
        this.txtDeliveryDate = new DateTextBox();
        this.purchaseProduct = new PurchaseProduct();
        
        Label lblImage = new Label();     
        
        lblImage.setIcon(new ImageIcon( getClass().getResource("/images/purchaseOrder.png")));
        lblImage.setPreferredSize(new Dimension(500,500));
        
        lblShipmentType = new Label("Shipment Type: ");
       
       String[] cargoType = {"Air Cargo", "Sea Cargo"};       
       cmbShipmentType = new ComboBox(cargoType);
       cmbShipmentType.setFont(skin.font22);
       
       this.txtDeliveryDate.setFont(skin.font22);
       
        
        CC ctrlConstraints = new CC();
        ctrlConstraints.growX().pushX().wrap().alignY("center").sizeGroup("1");
        
        CC shipTypeConstraint = new CC();
        shipTypeConstraint.growX().pushX().wrap().alignY("center").sizeGroup("1").gapTop("10");
        
        CC deliveryDateConstraint = new CC();
        deliveryDateConstraint.growX().pushX().wrap().alignY("center").sizeGroup("1").gapTop("10");
        
        pnlLeft.add(lblPurchaseName);
        pnlLeft.add(txtPurchaseName, ctrlConstraints);
        pnlLeft.add(lblPurchaseDescription);
        pnlLeft.add(txtPurchaseDescription, ctrlConstraints);
        pnlLeft.add(lblDeliveryDate, "gaptop 10");
        pnlLeft.add(txtDeliveryDate, deliveryDateConstraint);
        pnlLeft.add(lblShipmentType, "gaptop 10");
        pnlLeft.add(cmbShipmentType, shipTypeConstraint);
        pnlRight.add(lblImage, "span, gapleft 30");
        pnlLeft.add(pnlRight, "spany 7, spanx, gapleft 30, dock east, wrap");   
        pnlBottom.add(purchaseProduct, "grow, push");
        
        CC componentConstraints = new CC();
       componentConstraints.alignX("center").spanX().wrap().gapAfter("60");
      
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 30));
        this.add(lblTitle, componentConstraints);
        this.add(pnlLeft, "wrap");
        this.add(this.lblProductGrid, "wrap");
        this.add(pnlBottom, "span 7 7, grow, push");       
        
    }
    
    public boolean validationSucceded() {
        ArrayList<String> error = new ArrayList<String>();
        
        error = this.txtPurchaseName.hasValidValue() ? error : this.addError(error, "Purchase Name Required");
        error = this.txtPurchaseDescription.hasValidValue() ? error : this.addError(error, "Purchase Description is required");
        error = this.txtDeliveryDate.hasValidValue() ? error : this.addError(error, "Valid Delivery date is required");
        error = this.cmbShipmentType.hasValidValue() ? error : this.addError(error, "Shipment type required");
                
        return !this.showValidationErrors(error);
    }
    
    public void load(PurchaseModel model) {       
        purchaseModel =  purchaseRepo.getById(model.purchaseId);
        setValues(purchaseModel);
    }
    
    public PurchaseModel getUserEnteredValues() {      
        try{
        purchaseModel.purchaseName = this.txtPurchaseName.getText();
        purchaseModel.purchaseDescription = this.txtPurchaseDescription.getText();
        String deliveryDate = this.txtDeliveryDate.getText();
        if (!deliveryDate.equals(null) && !deliveryDate.isEmpty()) {
            purchaseModel.deliveryDate = new SimpleDateFormat("dd/mm/yyyy").parse(this.txtDeliveryDate.getText());
        }
        purchaseModel.shipmentType = this.cmbShipmentType.getSelectedItem().toString();
        purchaseModel.purchaseDetails = this.purchaseProduct.getUserEnteredValues();
        
        if (purchaseModel.purchaseDate == null) {     
            purchaseModel.purchaseDate = new Date(); 
        }
        
         } catch (ParseException e) {
            e.printStackTrace();
        }
        return purchaseModel;
    }
    
    public void setValues(PurchaseModel purchaseModel) {
        this.txtPurchaseName.setText(purchaseModel.purchaseName);
        this.txtDeliveryDate.setText(purchaseModel.deliveryDate.toString());
        this.txtPurchaseDescription.setText(purchaseModel.purchaseDescription);
        this.cmbShipmentType.setSelectedItem(purchaseModel.shipmentType);
         for (PurchaseDetailModel detail : purchaseModel.purchaseDetails) 
         {
             detail.requireOrder = true;
         }
        this.purchaseProduct.loadGrid((ArrayList<PurchaseDetailModel>) purchaseModel.purchaseDetails);
        
    }
    
    public void setDefaultValues() {
        PurchaseModel purchaseModel = new PurchaseModel();
        purchaseModel.purchaseDetails = new ArrayList<PurchaseDetailModel>();
        this.txtPurchaseName.setText("");
        this.txtDeliveryDate.setDateToToday();
        this.txtPurchaseDescription.setText("");
        this.cmbShipmentType.setSelectedItem("Sea Cargo");
        ProductRepository productRepo = new ProductRepository();
        for(ProductModel productModel : productRepo.getAll()) {
             PurchaseDetailModel detailModel = new PurchaseDetailModel();
             detailModel.product = productModel;
             detailModel.productId = productModel.productId;            
             purchaseModel.purchaseDetails.add(detailModel);
         }
        this.purchaseProduct.loadGrid((ArrayList<PurchaseDetailModel>) purchaseModel.purchaseDetails);
    }
    
    public void savePurchase() {
        if (!this.validationSucceded()) {
            return;
        }
       int inserted = this.purchaseRepo.createEntity(this.getUserEnteredValues()); 
       this.goTOBrowse("Saved Successfully", inserted > 0);        
    }
    
    public void add() {
        
    }
    
    public void delete() {
        
    }
    
    public void update() {
        if (!this.validationSucceded()) {
            return;
        }
       int updated = this.purchaseRepo.updateEntity(this.getUserEnteredValues()); 
       this.goTOBrowse("Saved Successfully", updated > 0);     
       confirmOrder();

    }
    
     public void confirmOrder() {
       PurchaseModel model = getUserEnteredValues();
       Map<String, List<ProductModel>> dealerOrder =  model.purchaseDetails.stream()
                                                     .map(m -> m.product)
                                                     .collect(Collectors.groupingBy(g -> g.dealer.user.email));
       
        SMTPEmail email = new SMTPEmail();
        StringBuilder emailContent = new StringBuilder();
       
        String tbl = "<table>"
                    + "<tr>"
                    + "<th>Product Name</th>"
                    + "<th>Quantity</th>"
                    + "<th>Color</th>"
                    + "</tr>";
       emailContent.append(tbl);
        
       for (Map.Entry<String, List<ProductModel>> entry : dealerOrder.entrySet()) {
           String productNames = entry.getValue().stream().map(m -> m.name).collect(Collectors.joining(", "));
           
           for(ProductModel pm : entry.getValue() ) 
           {
                    String tblRow =  "<tr>"
                    + "<td>"+pm.name+"</td>"
                    + "<td>"+pm.availableStock+"</td>"
                    + "<td>green</td>"
                    + "</tr>";
                 emailContent.append(tblRow);               
           }

           emailContent.append("</table>");
           email.sendEmail(entry.getKey(), emailContent.toString());
         }     
      
      
    }
}
