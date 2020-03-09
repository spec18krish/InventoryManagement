/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Common;

import Enums.NavigationAction;
import EventObject.TabChangeEventObj;
import customcontrols.Panel;
import interfaces.DataNavigationChangedHandler;
import interfaces.TabChangeRequestHandler;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Vidhya Mohan
 */
public class TabNavigationPanel extends Panel {
    
    public List<TabChangeRequestHandler> tabChangeHandlers;
    public List<DataNavigationChangedHandler> dataNavigationChanged;
    public TabNavigationPanel() {
        tabChangeHandlers = new ArrayList<TabChangeRequestHandler>();
        dataNavigationChanged = new ArrayList<DataNavigationChangedHandler>();
    }
    
    public void addChangeTabRequest(TabChangeRequestHandler changeTab) {
        tabChangeHandlers.add(changeTab);
    }
    
    public void addDataNavigationChanged (DataNavigationChangedHandler datChangeEvent) {
        dataNavigationChanged.add(datChangeEvent);
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
    
    public void goTOBrowse(boolean isSuccess) {
        this.goTOBrowse("", isSuccess);
    }
    
    public void goTOBrowse(String optionalMessage, boolean isSuccess) {
        
        String message = optionalMessage;
        if (isSuccess) {
            if (message.equals(null) || message.isEmpty()) { 
                message = "Record created or updated successfully";
            } 
            JOptionPane.showMessageDialog(null, message);
        this.fireTabChangeRequest(new TabChangeEventObj(0, null, NavigationAction.Browse));
        }
        else {
             if (message.equals(null) || message.isEmpty()) { 
                message = "Record does not created or updated";
            } 
            JOptionPane.showMessageDialog(null, message);
        }
    }
}
