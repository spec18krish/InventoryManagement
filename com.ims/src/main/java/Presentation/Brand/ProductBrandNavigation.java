/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Brand;

import Enums.NavigationAction;
import Presentation.Common.BaseNavigationFrame;
import customcontrols.GridViewPanel;
import customcontrols.Label;
import customcontrols.Panel;
import customcontrols.TableModel;
import customcontrols.TextArea;
import customcontrols.TextBox;
import domainModels.BrandModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import javax.swing.JOptionPane;
import net.miginfocom.swing.MigLayout;
import repository.BrandRepository;

/**
 *
 * @author Vidhya Mohan
 */
public class ProductBrandNavigation extends BaseNavigationFrame {
    
    private Panel AddUpdatePanel;
    private GridViewPanel brandGrid;
    
    private Label lblBrandName;
    private TextBox txtBrandName;
    private Label lblBrandDescription;
    private TextArea txtBrandDescription;
    
    private BrandRepository brandRepository;
    private int selectedBrandId = 0;
    
    public ProductBrandNavigation() {
        initializeBaseNavigationFrame();
        brandRepository = new BrandRepository();
        initializeProductBrandNavigation();
        this.clearActiveNav();
        this.sideNavBrand.setActive();
    }
    
    
        public void initializeProductBrandNavigation() {
        
        //this.setLayout(new MigLayout());
        this.centerPane.setLayout(new MigLayout());
        AddUpdatePanel = new Panel();
        brandGrid = new GridViewPanel();
        AddUpdatePanel.setLayout(new MigLayout());
        
        
        lblBrandName = new Label("Name");
        txtBrandName = new TextBox();       
        txtBrandDescription = new TextArea(1000, 300);
        lblBrandDescription = new Label("Description");
        this.centerPane.add(this.getTitleLabel("Product Brand"), this.getTitleConstraint());
        AddUpdatePanel.add(lblBrandName, "gapy 10, span 2, split 2 ");
        AddUpdatePanel.add(txtBrandName, "wrap");
        AddUpdatePanel.add(lblBrandDescription, "wrap, gapy 10");
        AddUpdatePanel.add(txtBrandDescription, "wrap,  spanx 4");
        brandGrid.addDoubleClickHandler(e -> onGridDoubleClick((BrandModel)e));
        brandGrid.addClickHandler(e -> onGridClick((BrandModel)e));
        
        setGridModel();
        
        this.centerPane.add(AddUpdatePanel, "wrap, grow, pushx, gapy40");
        this.centerPane.add(brandGrid, "wrap, grow, pushx");      
        
        actionBar.setActionBarActions(NavigationAction.Browse);
        
    }
    
    private void loadGrid(ArrayList<BrandModel> model) {
       HashMap<String, String> columnsKeyVal = new LinkedHashMap<String, String>();
       
       columnsKeyVal.put("brandId", "Brand Id");
       columnsKeyVal.put("brandName", "Brand Name");
    
        
       TableModel tblModel = new TableModel(model, columnsKeyVal);
        
        brandGrid.setModel(tblModel);
    }
    
    private void setGridModel() {        
       ArrayList<BrandModel> model = new ArrayList(brandRepository.getAll());
       loadGrid(model);
    }
    
    private void setValues(BrandModel model) {
        this.selectedBrandId = model.brandId;
        this.txtBrandName.setText(model.brandName);
        this.txtBrandDescription.setText(model.brandDescription);
    }
    
    private void clearValues() {
        BrandModel model = new BrandModel();
        this.selectedBrandId = 0;
        model.brandName = "";
        model.brandDescription = "";
        setValues(model);
    }
    
    private BrandModel getValues() {
        BrandModel model = new BrandModel();
        model.brandName = this.txtBrandName.getText();
        model.brandId = this.selectedBrandId;
        model.brandDescription = this.txtBrandDescription.getText();
        return model;
    }
    
    private void onGridDoubleClick(BrandModel model) {
        setValues(model);
        actionBar.setUpdateMode();
    }
    
    private void onGridClick(BrandModel model) {
        setValues(model);     
        actionBar.setListMode();
    }

    
    @Override
    protected void save() {
        if (!this.validationSucceded(false)) {
            return;
        }
        BrandModel model = this.getValues();
        brandRepository.createEntity(model);
        actionBar.setListMode();
        this.showInfo("Saved", "Product brand Saved successfully");
        setGridModel();
        this.clearValues();
    }
    
    private boolean validationSucceded(boolean isUpdate) {
        ArrayList<String> error = new ArrayList<String>();        
        error = this.txtBrandName.hasValidValue() ? error : this.addError(error, "Brand Name Required");        
        if (this.txtBrandName.hasValidValue() && !isUpdate) {
            boolean brandExists = this.brandRepository.brandNameExists(this.txtBrandName.getText());
            error = !brandExists ? error : this.addError(error, "Brand Name already exists");
        }
        
        return !this.showValidationErrors(error);
    }
    
    @Override
    protected void add() {
        actionBar.setCreateMode();
        this.clearValues();
    }
    
    @Override
    protected void delete() {
         if (this.confirmDelete()) {
            brandRepository.deleteEntityById(getValues().brandId);
            this.showInfo("Deleted", "Product brand Deleted successfully");
            setGridModel();
            this.clearValues();
            actionBar.setListMode();
         }
    }
    
    @Override
    protected void update() {
        if (!this.validationSucceded(true)) {
            return;
        }
        BrandModel model = this.getValues();
        brandRepository.updateEntity(model);
        this.showInfo("updated", "Product brand updated successfully");
        actionBar.setListMode();
        setGridModel();
    }
    
    @Override
    protected void cancel() {
        if (this.confirmCanel()) {
            this.clearValues();
            this.txtBrandDescription.reset();
            this.txtBrandName.reset();
            actionBar.setListMode();
        }
    }
    
    
}
