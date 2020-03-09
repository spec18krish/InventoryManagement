/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Category;

import Presentation.Common.BaseNavigationFrame;
import Presentation.Common.TabNavigationFrame;
import customcontrols.GridViewPanel;
import customcontrols.Label;
import customcontrols.Panel;
import customcontrols.TableModel;
import customcontrols.TextBox;
import domainModels.ProductCategoryModel;
import java.awt.TextArea;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import javax.swing.JTextArea;
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
    private JTextArea txtCategoryDescription;
    
    private ProductCategoryRepository categoryRepo;

    
    
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
        txtCategoryDescription = new JTextArea(12, 20);
        lblCategoryDescription = new Label("Description");
        
        AddUpdatePanel.add(lblCategoryName, "gapy 10, span 2, split 2 ");
        AddUpdatePanel.add(txtCategoryName, "wrap");
        AddUpdatePanel.add(lblCategoryDescription, "wrap, gapy 10");
        AddUpdatePanel.add(txtCategoryDescription, "wrap, grow, pushx");
        categoryGrid.addDoubleClickHandler(e -> onGridDoubleClick((ProductCategoryModel)e));
        
        setGridModel();
        
        this.centerPane.add(AddUpdatePanel, "wrap, grow, pushx, gapy40");
        this.centerPane.add(categoryGrid, "wrap, grow, pushx");      
        
    }
    
    private void setGridModel() {
        
       ArrayList<ProductCategoryModel> model = new ArrayList(categoryRepo.getAll());
        
       HashMap<String, String> columnsKeyVal = new LinkedHashMap<String, String>();
       
       columnsKeyVal.put("categoryId", "Category Id");
       columnsKeyVal.put("categoryName", "Category Name");
        
        TableModel tblModel = new TableModel(model, columnsKeyVal);
        
        categoryGrid.setModel(tblModel);
    }
    
    private void setValues(ProductCategoryModel model) {
        this.txtCategoryName.setText(model.categoryName);
        this.txtCategoryDescription.setText(" ");
    }
    
    private ProductCategoryModel getValues() {
        ProductCategoryModel model = new ProductCategoryModel();
        model.categoryName = this.txtCategoryName.getText();
        return model;
    }
    
    private void onGridDoubleClick(ProductCategoryModel model) {
        setValues(model);
        actionBar.setUpdateMode();
    }
    
    private void clearValues() {
        
    }
    
    @Override
    protected void save() {
        ProductCategoryModel model = this.getValues();
        categoryRepo.createEntity(model);
        actionBar.setListMode();
        setGridModel();
    }
    
    @Override
    protected void add() {
        actionBar.setCreateMode();
    }
    
    @Override
    protected void delete() {
        
    }
    
    @Override
    protected void update() {
        ProductCategoryModel model = this.getValues();
        categoryRepo.updateEntity(model);
        actionBar.setListMode();
        setGridModel();
    }
    
    @Override
    protected void cancel() {
        ProductCategoryModel model = new ProductCategoryModel();
        model.categoryName = "";
        this.setValues(model);      
        actionBar.setListMode();
    }
    
    
}
