/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customcontrols;

import Skin.Skin;
import interfaces.DocumentControlListener;
import java.awt.Dimension;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;

/**
 *
 * @author Vidhya Mohan
 */
public class TextArea extends JTextArea {
    private Skin skin = new Skin();
    boolean required = true;
    public TextArea() {        
        super();        
        this.initialize();
    }  
    
    public TextArea(int width, int height) {
        super();
        
        this.setPreferredSize(new Dimension(width, height));
        this.initialize();        
    }
    
    public void initialize() {
        Border bdr = new javax.swing.border.MatteBorder(2, 2, 2, 2, this.skin.lightSteelBlueColor);            
        setBorder(bdr);
        this.setFont(skin.font22);
        setText("");    
        this.addEvents();
    }
    
    public void reset () {
        this.setText("");
        this.setBackground(skin.frameBackgroundColor);
    }
    
    public boolean hasValidValue(boolean errorBackground) {
        boolean status =  this.hasValidValue();
        if (!errorBackground) {
            this.setBackground(skin.frameBackgroundColor);
        }
        return status;
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
       return value;
    }    
    
    public void addEvents() {
        this.getDocument().addDocumentListener((DocumentControlListener)e -> { 
         this.textFieldTextChanged(e);
     });
    }
    
    private void textFieldTextChanged(DocumentEvent e) {
        if (!this.getText().isEmpty()) {
            this.setBackground(skin.frameBackgroundColor);
        }
    }
}
