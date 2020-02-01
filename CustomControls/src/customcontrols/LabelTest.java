/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customcontrols;

import Skin.Skin;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.border.Border;

/**
 *
 * @author Vidhya Mohan
 */
public class LabelTest extends Panel {
    
     private Skin skin = new Skin();
    protected Color frameBackgroundColor = new Color(237, 240, 242);
    private Panel panel = new Panel();
    // Variables declaration - do not modify                     
    private customcontrols.Label label;
    private customcontrols.TextBox textField;

    public LabelTest() { 
        
        initialize("Label");        
    }
    
    public LabelTest(String labelText, Font font) {   
       
        initialize(labelText);
        this.label.setFont(font);
        this.textField.setFont(font);
        this.label.setText(labelText);    
        this.textField.setText("");
        this.textField.initialize(frameBackgroundColor, new Color(0,255,255));        
    }
    
    public void setTextVal(String text){
        this.label.setText(text);
    }
    
    public void initialize(String lblText) {
        label = new customcontrols.Label(lblText);
        textField = new customcontrols.TextBox();
        
        textField.setBackground(frameBackgroundColor);        
        Border bdr = new javax.swing.border.MatteBorder(0, 0, 2, 0, this.skin.lightSteelBlueColor);            
        textField.setBorder(bdr);
        textField.setBackground(frameBackgroundColor);
       
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        this.setPreferredSize(new Dimension(350, 30));
        this.add(label);       
        this.add(Box.createRigidArea(new Dimension(15,0)));
        this.add(textField);
        

        textField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 255, 255)));
        textField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textFieldFocusLost(evt);
            }
        });
        
      //  this.add(panel);       
    }

    public void setLabelText(String lblText) {
        this.label.setText(lblText);
    }
    
     public String getTextVal() {
        return this.textField.getText();
    }
     
     public void setFieldBackground(Color background) {
      //   this.setBackground(background);
     }
     
     public void setTextFieldBackground(Color background) {
         this.textField.setBackground(background);
     }
     
         private void textFieldActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void textFieldFocusGained(java.awt.event.FocusEvent evt) {                                      
     
        Border bdr = new javax.swing.border.MatteBorder(0, 0, 3, 0, this.skin.skyBlueColor);            
        textField.setBorder(bdr);
    }                                     

    private void textFieldFocusLost(java.awt.event.FocusEvent evt) {                                    
        Border bdr = new javax.swing.border.MatteBorder(0, 0, 2, 0, this.skin.lightSteelBlueColor);            
        textField.setBorder(bdr);
    }    
    
}
