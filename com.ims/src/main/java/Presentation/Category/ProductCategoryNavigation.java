/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Category;

import Enums.NavigationAction;
import Presentation.Common.BaseNavigationFrame;
import Presentation.Common.TabNavigationFrame;
import customcontrols.GridViewPanel;
import customcontrols.Label;
import customcontrols.Panel;
import customcontrols.TableModel;
import customcontrols.TextArea;
import customcontrols.TextBox;
import domainModels.ProductCategoryModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import javax.swing.JOptionPane;

import net.miginfocom.swing.MigLayout;
import repository.ProductCategoryRepository;

/**
 *
 * @author Vidhya Mohan
 */
public class ProductCategoryNavigation extends BaseNavigationFrame {
    
    private Panel AddUpdatePanel;
    private GridViewPanel categoryGrid;
    
    private Label lblCategoryName;
    private TextBox txtCategoryName;
    private Label lblCategoryDescription;
    private TextArea txtCategoryDescription;
    
    private ProductCategoryRepository categoryRepo;
    private int selectedCategoryId = 0;

    
    
    public ProductCategoryNavigation() {
        super();  
        initializeBaseNavigationFrame();
        categoryRepo = new ProductCategoryRepository();
        initializeProductCategoryNavigation();
       
    }
    
    public void initializeProductCategoryNavigation() {
        
        //this.setLayout(new MigLayout());
        this.centerPane.setLayout(new MigLayout());
        AddUpdatePanel = new Panel();
        categoryGrid = new GridViewPanel();
        AddUpdatePanel.setLayout(new MigLayout());
        
        
        lblCategoryName = new Label("Name");
        txtCategoryName = new TextBox();       
        txtCategoryDescription = new TextArea(1000, 300);
        lblCategoryDescription = new Label("Description");
        
        AddUpdatePanel.add(lblCategoryName, "gapy 10, span 2, split 2 ");
        AddUpdatePanel.add(txtCategoryName, "wrap");
        AddUpdatePanel.add(lblCategoryDescription, "wrap, gapy 10");
        AddUpdatePanel.add(txtCategoryDescription, "wrap, spanx 4");
        categoryGrid.addClickHandler(e -> onGridClick((ProductCategoryModel)e));
        categoryGrid.addDoubleClickHandler(e -> onGridDoubleClick((ProductCategoryModel)e));
        
        
        setGridModel();
        
        this.centerPane.add(AddUpdatePanel, "wrap, grow, pushx, gapy40");
        this.centerPane.add(categoryGrid, "wrap, grow, pushx");      
        
        actionBar.setActionBarActions(NavigationAction.Browse);
        
    }
    
    private void loadGrid(ArrayList<ProductCategoryModel> model) {
       HashMap<String, String> columnsKeyVal = new LinkedHashMap<String, String>();
       
       columnsKeyVal.put("categoryId", "Category Id");
       columnsKeyVal.put("categoryName", "Category Name");
        
       TableModel tblModel = new TableModel(model, columnsKeyVal);
        
        categoryGrid.setModel(tblModel);
    }
    
    private void setGridModel() {        
       ArrayList<ProductCategoryModel> model = new ArrayList(categoryRepo.getAll());
       loadGrid(model);
    }
    
    private boolean validationSucceded() {
        ArrayList<String> error = new ArrayList<String>();
  
        error = this.txtCategoryName.hasValidValue() ? error : this.addError(error, "Category Name required");
        if (this.txtCategoryName.hasValidValue()) {
            boolean categoryExists = categoryRepo.categoryNameExists(this.txtCategoryName.getText());
            error = !categoryExists ? error : this.addError(error, "Category Name already exists");
         }
        return !this.showValidationErrors(error);
    }
    
    private void setValues(ProductCategoryModel model) {
        this.selectedCategoryId = model.categoryId;
        this.txtCategoryName.setText(model.categoryName);
        this.txtCategoryDescription.setText(model.categoryDescription);
    }
    
    private void clearValues() {
        ProductCategoryModel model = new ProductCategoryModel();
        this.selectedCategoryId = 0;
        model.categoryName = "";
        model.categoryDescription = "";
        this.setValues(model);
    }
    
    private ProductCategoryModel getValues() {
        ProductCategoryModel model = new ProductCategoryModel();
        model.categoryName = this.txtCategoryName.getText();
        model.categoryId = this.selectedCategoryId;
        model.categoryDescription = this.txtCategoryDescription.getText();
        return model;
    }
    
    private void onGridDoubleClick(ProductCategoryModel model) {
        setValues(model);
        actionBar.setActionBarActions(NavigationAction.Update);
    }
    
    private void onGridClick(ProductCategoryModel model) {
        setValues(model);    
       actionBar.setActionBarActions(NavigationAction.Browse);
    }
    
    @Override
    protected void save() {
        if (!this.validationSucceded()) {
            return;
        }
        ProductCategoryModel model = this.getValues();
        categoryRepo.createEntity(model);
        actionBar.setListMode();
        setGridModel();
        this.showInfo("Saved", "Product Category saved succesfully");
        this.clearValues();
        
    }
    
    @Override
    protected void add() {
        actionBar.setCreateMode();
        this.clearValues();
    }
    
    @Override
    protected void delete() {
         if (this.confirmDelete()) {
            categoryRepo.deleteEntityById(getValues().categoryId);
            this.showInfo("Deletion", "Product Category Deleted succesfully");
            setGridModel();
            this.clearValues();
            actionBar.setListMode();
         }
    }
    
    @Override
    protected void update() {
        if (!this.validationSucceded()) {
            return;
        }
        ProductCategoryModel model = this.getValues();
        categoryRepo.updateEntity(model);
        this.showInfo("Updated", "Product Category Updated succesfully");
        actionBar.setListMode();
        setGridModel();
    }
    
    @Override
    protected void cancel() {
      if (this.confirmCanel()) {
        this.clearValues();        
        this.txtCategoryName.reset();
        this.clearValues();
        actionBar.setListMode();
        }
    }
    
    
}
