/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Common;

import customcontrols.NavigationLink;
import customcontrols.Panel;
import domainModels.UserModel;
import repository.UserSessionRepository;

/**
 *
 * @author Vidhya Mohan
 */
public class SideNavigation extends Panel {
    
    public SideNavigation() {
        
    }
    
    public void initializeSideNavControls() {
        
    }
    
    
    
    
    public void add(NavigationLink link, String layoutConstraints) {
        
        UserModel currentUser = UserSessionRepository.getUserModel();
        if (currentUser.userType.userTypeName == "Admin") {
            
        }       
        
    }
}


