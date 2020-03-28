/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prsentation.Dealers;

import Presentation.Common.IDetailNavigation;
import Presentation.Common.TabNavigationPanel;
import customcontrols.Label;
import customcontrols.TextArea;
import customcontrols.TextBox;
import domainModels.DealerModel;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JTextArea;
import net.miginfocom.layout.CC;
import net.miginfocom.swing.MigLayout;
import repository.DealerRepository;

/**
 *
 * @author Vidhya Mohan
 */
public class DealerDetail extends TabNavigationPanel implements IDetailNavigation<DealerModel> {

    public Label lblFirstName;
    public Label lblLastName;
    public Label lblEmail;
    public Label lblMobile;
    public Label lblHouseNo;
    public Label lblStreetName;
    public Label lblSuburb;
    public Label lblCity;
    public Label lblCountry;
    public Label lblCompany;
    public Label lblDealerDescription;
    
    public TextBox txtFirstName;
    public TextBox txtLastName;
    public TextBox txtEmail;
    public TextBox txtMobile;
    public TextBox txtHouseNo;
    public TextBox txtStreetName;
    public TextBox txtSuburb;
    public TextBox txtCity;
    public TextBox txtCountry;
    public TextBox txtCompany;
    public TextArea txtDealerDescription;
    
    
    private DealerRepository dealerRepo;
    private DealerModel _model;
    
    public DealerDetail() {
        initializeDealerDetail();
    }
    
    public void initializeDealerDetail() {
        
        dealerRepo = new DealerRepository();
        _model = new DealerModel();
        this.setLayout(new MigLayout());
        
        this.lblFirstName = new Label("First Name: ");
        this.lblLastName = new Label("Last Name: ");
        this.lblMobile = new Label("Mobile No: ");
        this.lblEmail = new Label("Email: ");
        this.lblHouseNo = new Label("Street No: ");
        this.lblStreetName = new Label("Street Name: ");
        this.lblSuburb = new Label("Suburb: ");
        this.lblCity = new Label("City: ");
        this.lblCountry = new Label("Country: ");
        this.lblCompany = new Label("Company: ");
        this.lblDealerDescription = new Label("Dealer Description: ");
        
        this.txtFirstName = new TextBox();
        this.txtLastName = new TextBox();
        this.txtMobile = new TextBox();
        this.txtEmail= new TextBox();
        this.txtHouseNo = new TextBox();
        this.txtStreetName = new TextBox();
        this.txtSuburb = new TextBox();
        this.txtCity = new TextBox();
        this.txtCountry = new TextBox();
        this.txtCompany = new TextBox();
        this.txtDealerDescription = new TextArea(500, 300);       
        CC componentCotrol = new CC();
        componentCotrol.wrap();
        
        this.add(lblCompany);
        this.add(txtCompany, componentCotrol);
        this.add(this.lblFirstName);
        this.add(this.txtFirstName, componentCotrol);
        this.add(this.lblLastName);
        this.add(this.txtLastName, componentCotrol);
        this.add(this.lblEmail);
        this.add(this.txtEmail, componentCotrol);
        this.add(this.lblMobile);
        this.add(this.txtMobile, componentCotrol);
        this.add(this.lblHouseNo);
        this.add(this.txtHouseNo, componentCotrol);
        this.add(this.lblStreetName);
        this.add(this.txtStreetName, componentCotrol);
        this.add(this.lblSuburb);
        this.add(this.txtSuburb, componentCotrol);
        this.add(this.lblCity);
        this.add(this.txtCity, componentCotrol);
        this.add(this.lblCountry);
        this.add(this.txtCountry, componentCotrol);    
        this.add(this.lblDealerDescription);
        this.add(this.txtDealerDescription, componentCotrol);
    }   


    @Override
    public void setValues(DealerModel model) {
        setModel(model);
        this.txtCompany.setText(model.companyName);
        this.txtFirstName.setText(model.user.firstName);
        this.txtLastName.setText(model.user.lastName);
        this.txtMobile.setText(model.user.mobileNumber);
        this.txtEmail.setText(model.user.email);
        this.txtHouseNo.setText(Integer.toString(model.user.houseNo));
        this.txtStreetName.setText(model.user.streetName);
        this.txtSuburb.setText(model.user.suburb);
        this.txtCity.setText(model.user.city);
        this.txtCountry.setText(model.user.country);
        this.txtDealerDescription.setText(model.dealerDescription);
    }

    @Override
    public DealerModel getUserSelectedValues() {      
       
       _model.user.firstName = this.txtFirstName.getText();
       _model.user.lastName = this.txtLastName.getText();
       _model.user.mobileNumber =  this.txtMobile.getText();
       _model.user.email = this.txtEmail.getText();
       _model.user.houseNo = Integer.parseInt(this.txtHouseNo.getText());
       _model.user.streetName = this.txtStreetName.getText();
       _model.user.suburb = this.txtSuburb.getText();
       _model.user.city = this.txtCity.getText();
       _model.user.country = this.txtCountry.getText();
       _model.companyName = this.txtCompany.getText();
       _model.dealerDescription = this.txtDealerDescription.getText();
      
       return _model;        
    }
    
    public void setModel(DealerModel model) {
        _model = model;
    }
    
    public DealerModel getModel() {
        if (_model == null) {
            _model = new DealerModel();
        }
        
        return _model;
    }

    @Override
    public void load(DealerModel model) {
        this.setModel(model);
        setValues(model);
    }
    
    public boolean validationSucceded(boolean isUpdate) {
       
        ArrayList<String> error = new ArrayList<String>();
        
        error = this.txtCompany.hasValidValue() ? error : this.addError(error, "Company required");
        String company = this.txtCompany.getText();
        if (this.txtCompany.hasValidValue() && !isUpdate) {
             error = !this.dealerRepo.isCompanyExists(company) ? error : this.addError(error, "Company Name already exists");
        }
       
        error = this.txtFirstName.hasValidValue() ? error : this.addError(error, "First Name Required");
        error = this.txtLastName.hasValidValue() ? error : this.addError(error,  "Last Name Required");
        error = this.txtEmail.hasValidEmail()? error : this.addError(error, "Valid Email is Required");
        error = this.txtMobile.hasValidValue(int.class) ? error :
                                          this.addError(error, "valid Mobile number Required ( only 10 digits allowed )");
        error = this.txtHouseNo.hasValidValue(int.class) ? error : this.addError(error, "valid street number Required");
        
        error = this.txtStreetName.hasValidValue() ? error : this.addError(error,  "Street Name Required");
        error = this.txtSuburb.hasValidValue() ? error : this.addError(error,  "Suburb is Required");
        error = this.txtCity.hasValidValue() ? error : this.addError(error,  "City is Required");
        error = this.txtCountry.hasValidValue() ? error : this.addError(error,  "Country is Required");
        error = this.txtDealerDescription.hasValidValue() ? error : this.addError(error,  "Dealer Discripton Required");
        
        return !this.showValidationErrors(error);        
    }

    @Override
    public void setDefaultValues() {
        DealerModel model = new DealerModel();
        setModel(model);
        setValues(model);
    }
    
    @Override
    public void save() {
       if (!validationSucceded(false)) {
           return;
       }
       DealerModel dealerModel = getUserSelectedValues();
       int inserted = this.dealerRepo.createEntity(dealerModel);
       this.goTOBrowse(inserted > 0);
    }

    @Override
    public void update() {    
       if (!validationSucceded(true)) {
           return;
       }
       int updated = this.dealerRepo.updateEntity(getUserSelectedValues());
       this.goTOBrowse(updated > 0);
    }

    @Override
    public void delete() {
        int deleted = this.dealerRepo.deleteEntityById(_model.dealerId);
        this.goTOBrowse(deleted > 0);
    }

    @Override
    public void add() {
    }
    
}
