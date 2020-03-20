/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Presentation.Common.MainFrame;
import customcontrols.Button;
import customcontrols.Label;
import customcontrols.LabelTextField;
import customcontrols.Panel;
import customcontrols.PictureBox;
import customcontrols.TextBox;
import domainModels.UserModel;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import net.miginfocom.swing.MigLayout;
import repository.UserRepository;
import repository.UserSessionRepository;

/**
 *
 * @author Vidhya Mohan
 */
public class Login extends MainFrame {
    
    private Panel pnlLeft;
    private Panel pnlRight;
    private PictureBox picBoxLogin;
    private LabelTextField lblTextPassword;
    private LabelTextField lblTextUserName;
    private Label lblInventoryManagement;
    private Label lblLoginLabel;
    private Label lblPassword;
    private JPasswordField txtPassword;
    private Button btnLogin;
    
    public Login() {
        super();
        this.setBackground(this.skin.frameBackgroundColor); 
        this.setLayout(new MigLayout());
        this.setPreferredSize(new Dimension(600, 400));
        this.setSize(new Dimension(800, 700));
        
        pnlRight = new Panel();
        pnlLeft = new Panel();
        picBoxLogin = new PictureBox();
        lblLoginLabel = new Label();
        lblTextUserName = new LabelTextField();
        lblTextPassword = new LabelTextField();
        lblInventoryManagement = new Label();
        lblPassword = new Label();
        txtPassword = new JPasswordField(16);
        btnLogin = new Button("Login");
        btnLogin.addActionListener(a -> this.btnLogin_click());
        
        this.lblLoginLabel.setForeground(this.skin.blueGreenColor);
        this.lblLoginLabel.setFont(skin.fontBold20);
        this.lblTextUserName.setLabelText("User Name: ");
        this.lblPassword.setText("Password: ");
        
        this.lblInventoryManagement.setText("Inventory Management System");       
        this.lblInventoryManagement.setForeground(this.skin.skyBlueColor);
        this.lblInventoryManagement.setFont(skin.fontBold18);
        this.pnlLeft.setBackground(this.skin.frameBackgroundColor);
        
       
        Image img = new ImageIcon(this.getClass().getResource("/images/login.png")).getImage();        
        this.picBoxLogin.setPicture(img, 180, 180);     
        this.picBoxLogin.setPreferredSize(new Dimension(180, 180));
        this.picBoxLogin.setImageForeColor(this.skin.milkWhiteColor);
        

        
        this.pnlRight.setLayout(new MigLayout());
        this.pnlRight.setPreferredSize(new Dimension(350, 700));
        this.pnlRight.setBackground(skin.skyBlueColor);
        this.pnlRight.add(this.picBoxLogin, "pushy 180, gapleft 40");
  
        
         this.pnlLeft.setLayout(new MigLayout());
         this.pnlLeft.add(lblInventoryManagement, "wrap");
         this.pnlLeft.add(lblLoginLabel, "wrap");
         this.pnlLeft.add(lblTextUserName, "wrap");
         this.pnlLeft.add(this.lblPassword, "wrap, gapleft 10");
         this.pnlLeft.add(txtPassword, "wrap, gapleft 10");
        
         this.pnlLeft.add(btnLogin);
         

        
        this.add(pnlRight, "growy, pushy" );
        
        this.add(pnlLeft );
    }
    
    private void btnLogin_click() 
    {
        UserRepository userRepo = new UserRepository();
        UserModel userModel = userRepo.login(this.lblTextUserName.getTextVal(), new String(this.txtPassword.getPassword()));
        
        if (userModel != null) {
            UserSessionRepository.setUserModel(userModel);
            DashBoard dashBoard = new DashBoard();
            dashBoard.setVisible(true);
            this.setVisible(false);
        }
        else {
            JOptionPane.showMessageDialog(null, "Login failed");
        }
    }
    
}
