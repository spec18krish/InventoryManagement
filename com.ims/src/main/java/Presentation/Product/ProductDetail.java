/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Product;

import Enums.NavigationAction;
import EventObject.TabChangeEventObj;
import Presentation.Common.TabNavigationPanel;
import customcontrols.Button;
import customcontrols.ComboBox;
import customcontrols.DropDownModel;
import customcontrols.Label;
import customcontrols.Panel;
import customcontrols.PictureBox;
import customcontrols.TextArea;
import customcontrols.TextBox;
import domainModels.BrandModel;
import domainModels.DealerModel;
import domainModels.ProductCategoryModel;
import domainModels.ProductModel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import net.miginfocom.layout.AC;
import net.miginfocom.layout.CC;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;
import repository.BrandRepository;
import repository.DealerRepository;
import repository.ProductCategoryRepository;
import repository.ProductRepository;

/**
 *
 * @author Vidhya Mohan
 */
public class ProductDetail extends TabNavigationPanel {

     Label lblTitle;
     Label lblName;
     Label lblPrice;
     Label lblAvailableStock;
     Label lblCategory;
     Label lblBrand;
     Label lblDealer;
     Label lblDescription;
     JScrollPane descriptionScrollPane;
     
     TextBox txtName;
     TextBox txtPrice;
     TextBox txtAvailableStock;
     ComboBox cmbBrand;
     ComboBox cmbCategory;
     ComboBox cmbDealer;
     TextArea txtDescription;
     PictureBox productImage;
     Button btnAdd;
     
     private ProductModel productModel;
     private List<BrandModel> brandModels;
     private List<ProductCategoryModel> categoryModels;
     
     DealerRepository dealerRepo;
    /**
     * Creates new form ProductDetail
     */
    public ProductDetail() {
        super();
        initializeProductDetail();
        loadLookups();
    }
    
    public ProductDetail(ProductModel productModel) {
        super();
        initializeProductDetail();        
        loadProduct(productModel);
    }
    
    public void initializeProductDetail() {
        dealerRepo = new DealerRepository();
        this.setLayout(new MigLayout());     
        this.productModel = new ProductModel();
        
        Panel pnlleft = new Panel();
        pnlleft.setLayout(new MigLayout(new LC().gridGapY("20")));
        pnlleft.setPreferredSize(new Dimension(1200 , 400));
        
        Panel pnlRight = new Panel();
        pnlRight.setLayout(new MigLayout(new LC().gridGapX("30")));
        pnlRight.setPreferredSize(new Dimension(500,500));
              
        
        Panel pnlBottom = new Panel();
        pnlBottom.setLayout(new MigLayout(new LC().fill(), new AC().grow()));
        pnlBottom.setPreferredSize(new Dimension(this.skin.frameDimension.width, 150));
     

      lblTitle = new Label("Product Detail");
      lblName = new Label("Product Name");
      lblPrice = new Label("Product Price");
      lblAvailableStock  = new Label("Available Stock");
      lblCategory = new Label("Product Category");
      lblBrand = new Label("Product Brand");
      lblDealer = new Label("Select Dealer");
      lblDescription = new Label("Product Description");
      Label lblImage = new Label();
      
        txtName = new TextBox();
        txtPrice = new TextBox();
        txtAvailableStock = new TextBox();
        cmbBrand = new ComboBox();
        cmbCategory = new ComboBox();
        cmbDealer = new ComboBox();
        txtDescription = new TextArea();
        productImage = new PictureBox();
        descriptionScrollPane = new JScrollPane(txtDescription);
        
        URL ddd =   getClass().getClassLoader().getResource("/resources/images/login.jpg");
        
        lblImage.setIcon(new ImageIcon("src/main/resources/productSample.png"));
        lblImage.setPreferredSize(new Dimension(500,500));
        txtDescription.setFont(new Font("SansSerif", Font.PLAIN, 30));
        // productImage.setPicture(new ImageIcon("src/main/resources/images/login.png").getImage());
        // productImage.setPreferredSize(new Dimension(200,300));
         CC ctrlConstraints = new CC();
         ctrlConstraints.growX().pushX().wrap().alignY("center").sizeGroup("1");
         
         
        pnlleft.add(lblName);
        pnlleft.add(txtName, ctrlConstraints);
        pnlleft.add(lblPrice);
        pnlleft.add(txtPrice, ctrlConstraints);
        pnlleft.add(lblAvailableStock);
        pnlleft.add(txtAvailableStock, ctrlConstraints);
        pnlleft.add(lblCategory);
        pnlleft.add(cmbCategory, ctrlConstraints);
        pnlleft.add(lblBrand);
        pnlleft.add(cmbBrand, ctrlConstraints); 
        pnlleft.add(lblDealer);
        pnlleft.add(cmbDealer, ctrlConstraints);
        pnlRight.add(lblImage, "span, gapleft 30");
        pnlleft.add(pnlRight, "spany 7, spanx, gapleft 30, dock east, wrap");   
        pnlBottom.add(descriptionScrollPane, "grow, push");
        
       //;
       CC componentConstraints = new CC();
       componentConstraints.alignX("center").spanX().wrap().gapAfter("60");
      
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 30));
        this.add(lblTitle, componentConstraints);
        this.add(pnlleft, "wrap");
        this.add(lblDescription, "wrap");
        this.add(pnlBottom, "span 6 6, grow, push");
    }
    
    public boolean validationSucceded() {
        
        ArrayList<String> error = new ArrayList<String>(0);
        error = this.txtName.hasValidValue() ? error : this.addError(error, "Product Name required");        
        error = this.txtPrice.hasValidValue(float.class) ? error : this.addError(error, "Enter a valid product price");
        error = this.txtAvailableStock.hasValidValue(int.class)? error : this.addError(error, "Enter a valid number for Available stock");      
        error = this.cmbBrand.hasValidValue() ? error : this.addError(error, "Product Brand Required");
        error = this.cmbCategory.hasValidValue() ? error : this.addError(error, "Product Category Required");
        error = this.cmbDealer.hasValidValue() ? error : this.addError(error, "Dealer is Required");
        error = this.txtDescription.hasValidValue() ? error : this.addError(error, "Product description required");
        
        return !this.showValidationErrors(error);
    }
    
    public void loadLookups() 
    {
        ProductCategoryRepository catRepo = new ProductCategoryRepository();
        BrandRepository brandRepo = new BrandRepository();
        DealerRepository dealerRepo = new DealerRepository();
        
        this.categoryModels = catRepo.getAll();
        this.brandModels = brandRepo.getAll();
        ArrayList<String> dealerCompany = new ArrayList<String>(dealerRepo.getDealerCompanies());
        
        String[] brandNames = new String[brandModels.size()];
        String[] catagoryNames = new String[categoryModels.size()];
        
        catRepo.getAllCategoryNames().toArray(catagoryNames);
        
        
        cmbCategory.setDefaultModel(catagoryNames);       
        cmbBrand.setDefaultModel(brandRepo.getAllBrandNames());
        cmbDealer.setDefaultModel(dealerCompany);
    }
    
    public void loadProduct(ProductModel productModel) {
        this.productModel = productModel;
        loadLookups();
        ProductRepository productRepo = new ProductRepository();        
        productModel = productRepo.getById(productModel.productId);
       
        
        this.txtName.setText(productModel.name);
        this.txtPrice.setText(productModel.price.toString());
        this.txtAvailableStock.setText(Integer.toString(productModel.availableStock));
        this.txtDescription.setText(productModel.productDescription);
        this.cmbBrand.setSelectedItem(productModel.brand.brandName);
        this.cmbCategory.setSelectedItem(productModel.category.categoryName); 
        this.cmbDealer.setSelectedItem(productModel.dealer.companyName);
    }
    
    public void getUserEnteredValues() {
          
          
          this.productModel.name = this.txtName.getText();
          this.productModel.productDescription = this.txtDescription.getText();
          this.productModel.price = Long.parseLong(this.txtPrice.getText());
          this.productModel.brandId = this.getBrandByName(this.cmbBrand.getSelectedItem().toString()).brandId;
          this.productModel.categoryId = this.getCategoryByName(this.cmbCategory.getSelectedItem().toString()).categoryId;
          this.productModel.availableStock = Integer.parseInt(txtAvailableStock.getText());
          DealerModel dealer =  this.dealerRepo.getDealerByCompanyName(this.cmbDealer.getSelectedString());
          this.productModel.dealer = dealer;
          this.productModel.dealerId = dealer.dealerId;
    }
    
    public void setDefaultValues(){
        this.productModel = new ProductModel();
        this.txtName.setText("");
        this.txtPrice.setText("");
        this.txtAvailableStock.setText("");
        this.txtDescription.setText("");    
        this.cmbBrand.setSelectedItem(this.cmbBrand.initialVal);
        this.cmbCategory.setSelectedItem(this.cmbCategory.initialVal);
        this.cmbDealer.setSelectedItem(this.cmbDealer.initialVal);
    }
    
    public void saveProduct() {
        
        if (!this.validationSucceded()) {
            return;
        }
        
         getUserEnteredValues();
         ProductRepository productRepo = new ProductRepository();       
         int inserted = productRepo.createEntity(this.productModel);
         
         if (inserted > 0) {
             JOptionPane.showMessageDialog(null, "Product created");
             this.fireTabChangeRequest(new TabChangeEventObj(0, null, NavigationAction.Browse));
         }
         else 
         {
               JOptionPane.showMessageDialog(null, "Product not created");
         }
    }
    
    public BrandModel getBrandByName(String name) {
        for(BrandModel model: this.brandModels){
            if(model.brandName.equals(name)) {
                return model;
            }
        }
        return null;
    }
    
    public ProductCategoryModel getCategoryByName(String name) {
        for(ProductCategoryModel model: this.categoryModels){
            if(model.categoryName.equals(name)) {
                return model;
            }
        }
         return null;
    }
    
    public void addProduct() {
        
    }
    
    public void deleteProduct() {
         ProductRepository productRepo = new ProductRepository();       
         int deleted = productRepo.deleteEntityById(this.productModel.productId);
         
         if (deleted > 0) {         
             this.showInfo("", "Product deleted");
             this.setDefaultValues();
             this.fireTabChangeRequest(new TabChangeEventObj(0, null, NavigationAction.Browse));
         }
         else 
         {
               this.showInfo("", "Product not deleted");               
         }
    }
    
    public void updateProduct() {
         if (!this.validationSucceded()) {
             return;
         }
         getUserEnteredValues();
         ProductRepository productRepo = new ProductRepository();       
         int updated = productRepo.updateEntity(this.productModel);
         
         if (updated > 0) {
             JOptionPane.showMessageDialog(null, "Product updated");
             this.fireTabChangeRequest(new TabChangeEventObj(0, null, NavigationAction.Browse));
         }
         else 
         {
               JOptionPane.showMessageDialog(null, "Product not updated");
         }     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
