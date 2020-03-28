/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Common;

import Enums.NavigationAction;
import EventObject.TabChangeEventObj;
import customcontrols.Label;
import customcontrols.Panel;
import interfaces.DataNavigationChangedHandler;
import interfaces.SearchChangeHandler;
import interfaces.TabChangeRequestHandler;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import net.miginfocom.layout.CC;

/**
 *
 * @author Vidhya Mohan
 */
public class TabNavigationPanel extends Panel {
    
    public List<TabChangeRequestHandler> tabChangeHandlers;
    public List<DataNavigationChangedHandler> dataNavigationChanged;
    public List<SearchChangeHandler> onSearchChanged;
    public Utilities utility = new Utilities();
    
    public TabNavigationPanel() {
        tabChangeHandlers = new ArrayList<TabChangeRequestHandler>();
        dataNavigationChanged = new ArrayList<DataNavigationChangedHandler>();
        onSearchChanged = new ArrayList<SearchChangeHandler>();
    }
    
    public void addChangeTabRequest(TabChangeRequestHandler changeTab) {
        tabChangeHandlers.add(changeTab);
    }
    
    public void addDataNavigationChanged (DataNavigationChangedHandler datChangeEvent) {
        dataNavigationChanged.add(datChangeEvent);
    }
    
    public void addOnSearchChanged(SearchChangeHandler searchChanged){
        onSearchChanged.add(searchChanged);
    }
    
    public <T> void fireDataNavigationChanged(T model) {
         for(DataNavigationChangedHandler dataChanged: dataNavigationChanged) {
           dataChanged.onDataNavigationChanged(model);
       }    
    }   
    
    
    public void fireTabChangeRequest(TabChangeEventObj eventObj) {        
         for(TabChangeRequestHandler changeRequest: tabChangeHandlers) {
           changeRequest.changeTab(eventObj);
       }        
    }
    
    public void fireSearchChanged(Object searchResult) {        
         for(SearchChangeHandler searchChange: onSearchChanged) {
           searchChange.onSearchChange(searchResult);
       }        
    }
    
    public void goTOBrowse(boolean isSuccess) {
        this.goTOBrowse("", isSuccess);
    }
    
     protected boolean showValidationErrors(ArrayList<String> errorLists) {
       return this.utility.showValidationErrors(errorLists);
    }
    
     protected ArrayList<String> addError(ArrayList<String> errors, String message) {
       return this.utility.addError(errors, message);
    }
     
    protected boolean confirmCanel() {
        return this.utility.confirmCancel();
    }
    
    protected void showInfo(String title, String message) {
        this.utility.showInfo(title, message);
    }
    
    protected boolean confirmDelete() {
        return this.utility.confirmDelete();
    }
    
    protected boolean confirmMessage(String title, String message) {
        return this.utility.confirmation(title, message);
    }
    
    protected CC getTitleConstraint() {
        return this.utility.getTitleConstraint();
    }
    
    protected Label getTitleLabel(String title){
        return this.utility.getTitleLabel(title);
    }
    
    public void goTOBrowse(String optionalMessage, boolean isSuccess) {
        
        String message = optionalMessage;
        if (isSuccess) {
            if (message.equals(null) || message.isEmpty()) { 
                message = "Record created or updated successfully";
            }            
            this.utility.showInfo("Success", message);
            this.fireTabChangeRequest(new TabChangeEventObj(0, null, NavigationAction.Browse));
        }
        else {
             if (message.equals(null) || message.isEmpty()) { 
                message = "Record does not created or updated";
            }    
             this.utility.showInfo("Failed", message);
        }
        
    }
}
