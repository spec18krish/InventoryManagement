/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Users;

import Presentation.Common.IDetailNavigation;
import Presentation.Common.TabNavigationPanel;
import customcontrols.ComboBox;
import customcontrols.Label;
import customcontrols.TextBox;
import domainModels.DealerModel;
import domainModels.UserModel;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JTextArea;
import net.miginfocom.layout.CC;
import net.miginfocom.swing.MigLayout;
import repository.DealerRepository;
import repository.UserRepository;

/**
 *
 * @author Vidhya Mohan
 */
public class UserDetail extends TabNavigationPanel implements IDetailNavigation<UserModel> {

    public Label lblFirstName;
    public Label lblLastName;
    public Label lblEmail;
    public Label lblMobile;
    public Label lblHouseNo;
    public Label lblStreetName;
    public Label lblSuburb;
    public Label lblCity;
    public Label lblCountry;
    public Label lblUserType;

    
    public TextBox txtFirstName;
    public TextBox txtLastName;
    public TextBox txtEmail;
    public TextBox txtMobile;
    public TextBox txtHouseNo;
    public TextBox txtStreetName;
    public TextBox txtSuburb;
    public TextBox txtCity;
    public TextBox txtCountry;
    public ComboBox cmbUserType;

    
    
    private UserRepository userRepo;
    private UserModel _model;
    
    public UserDetail() {
        initializeUserDetail();
    }
    
    public void initializeUserDetail() {
        
        userRepo = new UserRepository();
        _model = new UserModel();
        this.setLayout(new MigLayout());
        
        List<String> userTypeNames = this.userRepo.getAllUserType().stream().map(m -> m.userTypeName)
                     .collect(Collectors.toList());
        String[] userTypeNamesArr = new String[userTypeNames.size()];
        
        this.lblFirstName = new Label("First Name: ");
        this.lblLastName = new Label("Last Name: ");
        this.lblMobile = new Label("Mobile No: ");
        this.lblEmail = new Label("Email: ");
        this.lblHouseNo = new Label("Street No: ");
        this.lblStreetName = new Label("Street Name: ");
        this.lblSuburb = new Label("Suburb: ");
        this.lblCity = new Label("City: ");
        this.lblCountry = new Label("Country: ");
        this.lblUserType = new Label("User Type: ");

        
        this.txtFirstName = new TextBox();
        this.txtLastName = new TextBox();
        this.txtMobile = new TextBox();
        this.txtEmail= new TextBox();
        this.txtHouseNo = new TextBox();
        this.txtStreetName = new TextBox();
        this.txtSuburb = new TextBox();
        this.txtCity = new TextBox();
        this.txtCountry = new TextBox();
        this.cmbUserType = new ComboBox(userTypeNames.toArray(userTypeNamesArr));


        CC componentCotrol = new CC();
        componentCotrol.wrap().sizeGroup("userdetailControl").gapTop("10");
       
        cmbUserType.setPreferredSize(new Dimension(300, 40));

        this.add(this.lblFirstName);
        this.add(this.txtFirstName, componentCotrol);
        this.add(this.lblLastName);
        this.add(this.txtLastName, componentCotrol);
        this.add(this.lblEmail);
        this.add(this.txtEmail, componentCotrol);
        this.add(this.lblUserType);
        this.add(this.cmbUserType, componentCotrol);
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

    }
    
    public boolean validationSucceded() {
        ArrayList<String> error = new ArrayList<String>();
        
        error = this.txtFirstName.hasValidValue() ? error : this.addError(error, "First Name is required");
        error = this.txtLastName.hasValidValue() ? error : this.addError(error, "First Name is required");
        error = this.txtEmail.hasValidEmail() ? error : this.addError(error, "Valid Email is required");
        error = this.cmbUserType.hasValidValue() ? error : this.addError(error, "User Type is required");
        error = this.txtMobile.hasValidValue() ? error : this.addError(error, "Valid Mobile number is required (Not more than 10 digits)");
        error = this.txtHouseNo.hasValidValue() ? error : this.addError(error, "Street Number is required");
        error = this.txtStreetName.hasValidValue() ? error : this.addError(error, "Street Name is required");
        error = this.txtSuburb.hasValidValue() ? error : this.addError(error, "Suburg is required");
        error = this.txtCity.hasValidValue() ? error : this.addError(error, "City is required");
        error = this.txtCountry.hasValidValue() ? error : this.addError(error, "Country is required");       
        
        return !this.showValidationErrors(error);
        
    }


    @Override
    public void setValues(UserModel model) {
        setModel(model);   
        this.txtFirstName.setText(model.firstName);
        this.txtLastName.setText(model.lastName);
        this.cmbUserType.setSelectedItem(model.userType.userTypeName);
        this.txtMobile.setText(model.mobileNumber);
        this.txtEmail.setText(model.email);
        this.txtHouseNo.setText(Integer.toString(model.houseNo));
        this.txtStreetName.setText(model.streetName);
        this.txtSuburb.setText(model.suburb);
        this.txtCity.setText(model.city);
        this.txtCountry.setText(model.country);       
    }

    @Override
    public UserModel getUserSelectedValues() {      
       
       _model.firstName = this.txtFirstName.getText();
       _model.lastName = this.txtLastName.getText();
       _model.userType.userTypeName = this.cmbUserType.getSelectedItem().toString();
       _model.mobileNumber =  this.txtMobile.getText();
       _model.email = this.txtEmail.getText();
       _model.houseNo = Integer.parseInt(this.txtHouseNo.getText());
       _model.streetName = this.txtStreetName.getText();
       _model.suburb = this.txtSuburb.getText();
       _model.city = this.txtCity.getText();
       _model.country = this.txtCountry.getText();
      
       return _model;        
    }
    
    public void setModel(UserModel model) {
        _model = model;
    }
    
    public UserModel getModel() {
        if (_model == null) {
            _model = new UserModel();
        }
        
        return _model;
    }

    @Override
    public void load(UserModel model) {
        this.setModel(model);
        setValues(model);
    }

    @Override
    public void setDefaultValues() {
        UserModel model = new UserModel();
        setModel(model);
        setValues(model);
    }
    
    @Override
    public void save() {
        if (!this.validationSucceded()) {
            return;
        }
       UserModel userModel = getUserSelectedValues();
       int inserted = this.userRepo.createEntity(userModel);
       this.goTOBrowse(inserted > 0);
    }

    @Override
    public void update() {  
        if (!this.validationSucceded()) {
            return;
        }
       int updated = this.userRepo.updateEntity(getUserSelectedValues());
       this.goTOBrowse(updated > 0);
    }

    @Override
    public void delete() {
        int deleted = this.userRepo.deleteEntityById(_model.userId);
        this.goTOBrowse(deleted > 0);
    }

    @Override
    public void add() {
    }
    
}
