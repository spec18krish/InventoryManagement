/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Common;

import Skin.Skin;
import customcontrols.Label;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Vidhya Mohan
 */
public class Utilities {
    Skin skin = new Skin();
    
    public void setUIManager() {
        UIManager.put("OptionPane.messageFont", skin.font20);
        UIManager.put("OptionPane.buttonFont", skin.font20);
    }
    
    public void setBlackLabel() {
        UIManager.put("OptionPane.messageForeground", skin.darkTextColor);
    }
    
    public void setErrorLabel() {
        UIManager.put("OptionPane.messageForeground", skin.invalidLabelColor);
    }
    
    protected boolean showValidationErrors(ArrayList<String> errorLists) {
        String message = "";
        if (errorLists != null && errorLists.size() > 0) {
            for(String error: errorLists) {
            message += error + "\r\n";
        }
            
        this.setErrorLabel();      
        JOptionPane.showMessageDialog(null, message, "Validation Errors", JOptionPane.ERROR_MESSAGE);
        return true;
        }
        else {
            return false;
        }
    }
    
    protected ArrayList<String>  addError(ArrayList<String> errors, String message) {
        if (errors == null) {
            errors = new ArrayList<String>();
        }
        
        errors.add(message);
        return errors;
    }
    
    public boolean confirmCancel() {
     int cofirmation = 1;
     this.setBlackLabel();
     cofirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel ?", "Cancel Confirmation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
    
       if (cofirmation == JOptionPane.YES_OPTION) {
           return true;
       }
       else 
       if (cofirmation == JOptionPane.CANCEL_OPTION || cofirmation == JOptionPane.CLOSED_OPTION) {
           return false;
       }
       return false;
    }
    
    public boolean confirmDelete() {
     int cofirmation = 1;
     this.setBlackLabel();
     cofirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to Delete ?", "Delete Confirmation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
    
       if (cofirmation == JOptionPane.YES_OPTION) {
           return true;
       }
       else 
       if (cofirmation == JOptionPane.CANCEL_OPTION || cofirmation == JOptionPane.CLOSED_OPTION) {
           return false;
       }
       return false;
    }
    
    public void showInfo(String title, String message) {
         if (title == null || title.isEmpty()) {
             title = "Info";
         }
         this.setBlackLabel();
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }
    
    
}
