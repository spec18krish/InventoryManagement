/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customcontrols;

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
public class LabelTextFieldInline1 extends Panel  {
    private Panel panel = new Panel();
    private int labelTextSpacing = 15;
    private int width = 350;
    
    private customcontrols.Label label;
    private customcontrols.TextBox textField;
    

    public LabelTextFieldInline1(String labelText) {         
        initialize(labelText);        
    }
    
    public LabelTextFieldInline1(String labelText, Font font) {
        this.initialize(labelText, font, this.width, this.labelTextSpacing);
    }
    
     public LabelTextFieldInline1(String labelText, Font font, int width) {
         this.initialize(labelText, font, width, this.labelTextSpacing);
    }
     
     public LabelTextFieldInline1(String labelText, int width) {   
        this.initialize(labelText, skin.font22, width, this.labelTextSpacing);
    }
     
     public LabelTextFieldInline1(String labelText, int width, int labelTextSpace) { 
        this.initialize(labelText, skin.font22, width, labelTextSpace);       
    }
     
    public void initialize(String labelText,Font font, int width, int labelTextSpace) {
        this.labelTextSpacing = labelTextSpace;
        initialize(labelText);
        setControls(font, labelText);
        this.setPreferredSize(new Dimension(width, 30));
    }
     
    public void setControls(Font font, String labelText) {
        this.label.setFont(font);
        this.textField.setFont(font);
        this.label.setText(labelText);    
        this.textField.setText("");
        this.textField.initialize(this.skin.frameBackgroundColor, this.skin.lightSteelBlueColor);   
    }
    
    public void setTextVal(String text){
        this.label.setText(text);
    }
    
    public void initialize(String lblText) {
        label = new customcontrols.Label(lblText);
        textField = new customcontrols.TextBox();    
       
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        this.setPreferredSize(new Dimension(350, 30));
        this.add(label);       
        this.add(Box.createRigidArea(new Dimension(labelTextSpacing,0)));
        this.add(textField);        

        
        this.add(panel);       
    }

    public void setLabelText(String lblText) {
        this.label.setText(lblText);
    }
    
     public String getTextVal() {
        return this.textField.getText();
    }
     
     public void setFieldBackground(Color background) {
         this.setBackground(background);
     }
     
     public void setTextFieldBackground(Color background) {
         this.textField.setBackground(background);
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
