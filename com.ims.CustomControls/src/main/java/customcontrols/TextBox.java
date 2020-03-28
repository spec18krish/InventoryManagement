/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customcontrols;

import Skin.Skin;
import interfaces.DocumentControlListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;

/**
 *
 * @author Vidhya Mohan
 */
public class TextBox extends JTextField {
    Skin skin = new Skin();
    boolean required = true;
    public TextBox() {
        super();
        setFont(skin.font26);        
        Border bdr = new javax.swing.border.MatteBorder(0, 0, 2, 0, this.skin.lightSteelBlueColor);            
        setBorder(bdr);
        setText("");
        addEvents();
        this.setPreferredSize(new Dimension(300, 40));
        this.setBackground(skin.frameBackgroundColor);
    }
    
    public TextBox(int width, int height) {
        super();
        setFont(skin.font26);        
        Border bdr = new javax.swing.border.MatteBorder(0, 0, 2, 0, this.skin.lightSteelBlueColor);            
        setBorder(bdr);
        setText("");
        addEvents();
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(skin.frameBackgroundColor);
    }
    
    public void initialize(Color background, Color border) {
        setText("");
        Border bdr = new javax.swing.border.MatteBorder(0, 0, 2, 0, border);            
        setBorder(bdr);
        setBackground(background);
        addEvents();
    }
    
    private void addEvents() {        
        this.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textFieldFocusLost(evt);
            }
        });      
        
        this.getDocument().addDocumentListener((DocumentControlListener)e -> { 
            this.textFieldTextChanged(e);
        });        
   
    }
    
    @Override
    public void setText(String value) {
        if (value == null || value.isEmpty()) {
            value = "";
        }        
        super.setText(value);       
    }
    
    public void setText(Object value, Class<?> typeName) {
        String castedValue = "";
       if (value != null || typeName != null) {
           
           if (typeName == int.class) {
               castedValue = Integer.toString((int) value);
           }           
       }
        super.setText(castedValue);       
    }
    
    @Override
    public String getText() {
       String value = super.getText();
       if (value == null || value.isEmpty()) {
           value = "";
       }
       return value.trim();
    }
    
    public boolean hasValidValue(boolean errorBackground) {
        boolean status =  this.hasValidValue();
        if (!errorBackground) {
            this.setBackground(skin.frameBackgroundColor);
        }
        return status;
    }
    
    public void reset () {
        this.setText("");
        this.setBackground(skin.frameBackgroundColor);
    }

    public boolean hasValidValue() {
        String value = this.getText();
        if (required ) {
            if (value != null && !value.trim().isEmpty()) {
                this.setBackground(skin.frameBackgroundColor);
                return true;
            }
            this.setBackground(skin.inValidControlColor);
        }
       
        return false;
    }
    
    public boolean hasValidValue( Class<?> typeName) {
        if (!typeName.equals(int.class) && !typeName.equals(float.class)) {
            return this.hasValidValue();
        }
        String enteredValue = this.getText();
        
        if (typeName == int.class && enteredValue.matches("\\d+") && enteredValue.length() <= 10)  {      
           int value = Integer.parseInt(this.getText());
           if (required && value > 0 ) {           
                this.setBackground(skin.frameBackgroundColor);
                return true;          
          }       
        }
        
        if (typeName == float.class && enteredValue.matches("\\d{1,8}(\\.\\d{1,7})?")) {           
                float value = Float.parseFloat(enteredValue);
                if (required  && value > 0) {
                     this.setBackground(skin.frameBackgroundColor);
                     return true;
                }            
        }
    
        this.setBackground(skin.inValidControlColor);
        return false;
    }
    
    public boolean hasValidEmail() {       
         if (!this.hasValidValue()) {
             return false;
         }       
        return this.getText().matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
    }
    
 
//    public T getText<T>(Class<?> type) {
//       String value = super.getText();
//       T castValue = null;
//       if (value == null || value.isEmpty()) {
//           
//           if (type == int.class) {
//               value = "0";
//           }
//       }       
//                  
//       if (type == int.class) {
//               castValue = (T)"0";
//           }
//       
//     
//       return value;
//    }
    
    private void textFieldFocusGained(java.awt.event.FocusEvent evt) {                                      
     
        Border bdr = new javax.swing.border.MatteBorder(0, 0, 3, 0, this.skin.skyBlueColor);            
        this.setBorder(bdr);
    }                                     

    private void textFieldFocusLost(java.awt.event.FocusEvent evt) {                                    
        Border bdr = new javax.swing.border.MatteBorder(0, 0, 2, 0, this.skin.lightSteelBlueColor);            
        this.setBorder(bdr);
    } 
    
    private void textFieldTextChanged(DocumentEvent e) {
        if (!this.getText().isEmpty()) {
            this.setBackground(skin.frameBackgroundColor);
        }
    }
}
