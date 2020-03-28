/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Users;

import Presentation.Common.TabNavigationPanel;
import customcontrols.Button;
import customcontrols.ComboBox;
import customcontrols.Label;
import customcontrols.Panel;
import customcontrols.TextBox;
import domainModels.UserModel;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import net.miginfocom.swing.MigLayout;
import repository.UserRepository;

/**
 *
 * @author Vidhya Mohan
 */
public class UserFilter extends TabNavigationPanel {
    
    private Label lblUserId;
    private Label lblFirstName;
    private Label lblEmail;
    private Label lblUserType;
    
    private TextBox txtUserId;
    private TextBox txtFirstName;
    private TextBox txtEmail;
    private ComboBox cmbUserType;
    private Panel filterBox;
    
    private UserRepository userRepo;
    
    
    public UserFilter() {
        this.setLayout(new MigLayout());
        initializeUserFilter();
    }
    
    public void initializeUserFilter() {
        
        userRepo = new UserRepository();
        List<String> userTypeNames = this.userRepo.getAllUserType().stream().map(m -> m.userTypeName)
                     .collect(Collectors.toList());
        
        Button btnSearch = new Button("Search");
        btnSearch.addActionListener(e -> this.btnSearch_Click());
        
        filterBox = new Panel();         
        filterBox.setLayout(new MigLayout());     
        this.setTitle("Search User");
        
        lblUserId = new Label("User Id:");
        lblFirstName = new Label("First Name:");
        lblEmail = new Label("Email:");
        lblUserType = new Label("User Type:");
        
        txtUserId = new TextBox();
        txtFirstName = new TextBox();
        txtEmail = new TextBox();
        cmbUserType = new ComboBox();
        cmbUserType.setDefaultModel(new ArrayList<String>(userTypeNames));
        
        filterBox.add(lblUserId);
        filterBox.add(txtUserId, "pushx, sg searchCtrl");
        filterBox.add(lblFirstName);
        filterBox.add(txtFirstName, "pushx, sg searchCtrl");
        filterBox.add(lblEmail);
        filterBox.add(txtEmail, "pushx, sg searchCtrl, wrap");
        
        filterBox.add(lblUserType);
        filterBox.add(cmbUserType, "pushx, sg searchCtrl");
        filterBox.add(btnSearch, "skip 2, align trailing, gapy 40");    
        
        this.add(filterBox, "span, pushx, grow");     
    }
    
    private void btnSearch_Click() {
        
        int userId = 0;
        if (this.txtUserId.getText().matches("\\d+")) {
            userId = Integer.parseInt(this.txtUserId.getText());
        }
        
        String firstName = this.txtFirstName.getText();
        String email = this.txtEmail.getText();
        String userTypeName = this.cmbUserType.getSelectedString();
        
        List<UserModel> userModel =  this.userRepo.searchUser(userId, firstName, email, userTypeName);
        
        this.fireSearchChanged(userModel);      
        
    }
}
