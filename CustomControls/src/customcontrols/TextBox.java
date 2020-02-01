/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customcontrols;

import Skin.Skin;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author Vidhya Mohan
 */
public class TextBox extends JTextField {
    Skin skin = new Skin();
    public TextBox() {
        super();
        setFont(new Font("SansSerif", Font.PLAIN, 17));        
        Border bdr = new javax.swing.border.MatteBorder(0, 0, 2, 0, this.skin.lightSteelBlueColor);            
        setBorder(bdr);
        setText("");
        addEvents();
        
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
    }
    
    private void textFieldFocusGained(java.awt.event.FocusEvent evt) {                                      
     
        Border bdr = new javax.swing.border.MatteBorder(0, 0, 3, 0, this.skin.skyBlueColor);            
        this.setBorder(bdr);
    }                                     

    private void textFieldFocusLost(java.awt.event.FocusEvent evt) {                                    
        Border bdr = new javax.swing.border.MatteBorder(0, 0, 2, 0, this.skin.lightSteelBlueColor);            
        this.setBorder(bdr);
    } 
}
