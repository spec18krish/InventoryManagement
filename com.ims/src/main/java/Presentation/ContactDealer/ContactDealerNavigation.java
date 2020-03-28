/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.ContactDealer;

import Presentation.Common.BaseNavigationFrame;
import Presentation.Common.Email.SMTPEmail;
import customcontrols.Button;
import customcontrols.ComboBox;
import customcontrols.Label;
import customcontrols.Panel;
import customcontrols.TextArea;
import customcontrols.TextBox;
import java.util.ArrayList;
import java.util.List;
import net.miginfocom.layout.CC;
import net.miginfocom.swing.MigLayout;
import repository.DealerRepository;
import repository.ProductCategoryRepository;

/**
 *
 * @author Vidhya Mohan
 */
public class ContactDealerNavigation extends BaseNavigationFrame {
    
    private Label lblSelectDealer;
    private Label lblEmailSubject;
    private Label lblEmailBody;
    
    private ComboBox cmbDealer;
    private TextBox txtEmailSubject;
    private TextArea txtEmailBody;
    
    private Button btnSendEmail;
    
    private Panel pnlContainer;
    
    private DealerRepository dealerRepo;
    
    public ContactDealerNavigation() {
        super();  
        initializeBaseNavigationFrame();
        this.actionBar.setViewMode();
        initializeContactDealerNavigation();
        this.clearActiveNav();
        this.sideNavContactDealer.setActive();
    }
    
    public void initializeContactDealerNavigation() {
        
        dealerRepo = new DealerRepository();
        this.centerPane.setLayout(new MigLayout());
        pnlContainer = new Panel();
        pnlContainer.setLayout(new MigLayout());
        lblSelectDealer = new Label("Select Dealer");
        lblEmailSubject = new Label("Email Subject");
        lblEmailBody = new Label("Email Body");
        
        
        List<String> dealerCompanies = dealerRepo.getDealerCompanies();
        cmbDealer = new ComboBox();
        cmbDealer.setDefaultModel(new ArrayList<String>(dealerCompanies));
        txtEmailSubject = new TextBox();
        txtEmailBody = new TextArea(700, 400);
        btnSendEmail = new Button("Send Email");
        btnSendEmail.addActionListener(e -> this.btnSendEmail_Click());
        
        CC controlConstraint = new CC();
        controlConstraint.wrap().gapTop("20").sizeGroup("sg1");
        
        this.centerPane.add(this.getTitleLabel("Contact Dealer"), this.getTitleConstraint());
        this.pnlContainer.add(lblSelectDealer);
        this.pnlContainer.add(cmbDealer, controlConstraint);
        this.pnlContainer.add(lblEmailSubject);
        this.pnlContainer.add(txtEmailSubject, controlConstraint);
        this.pnlContainer.add(lblEmailBody);
        this.pnlContainer.add(txtEmailBody, "wrap, gaptop 20");
        this.pnlContainer.add(btnSendEmail, "skip 1, trailing");
        
        this.centerPane.add(this.pnlContainer, "grow, push");
        
    }
    
    private boolean validationSucceded() {
        ArrayList<String> error = new ArrayList<String>();
        error = this.cmbDealer.hasValidValue() ? error : this.addError(error, "Please select the dealer");       
        error = this.txtEmailSubject.hasValidValue() ? error : this.addError(error, "Email subject is required");
        error = this.txtEmailBody.hasValidValue() ? error : this.addError(error, "Email body is required");
        
        return !this.showValidationErrors(error);
    }
    
    private void btnSendEmail_Click() {
        
        if (!this.validationSucceded()) {
            return;
        }
        String emailSubject = this.txtEmailSubject.getText();
        String emailBody = this.txtEmailBody.getText();
        String emailTo = this.dealerRepo
                             .getDealerByCompanyName(this.cmbDealer.getSelectedString())
                             .user.email;
        SMTPEmail email = new SMTPEmail();
        email.sendEmail(emailTo, emailSubject, emailBody);
        this.showInfo("Email Sent", "Email sent to the dealer successfully");
    }
    
}
