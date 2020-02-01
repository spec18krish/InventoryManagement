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
import javax.swing.JLabel;


public class Label extends JLabel {        
 private Skin skin = new Skin();
    
    public Label() {
        super(); 
        initialize();
    }
    
     public Label(String test) {
      super(test); 
      initialize();
    }
     
     public void initialize() {
        setForeground(this.skin.darkTextColor);        
        setFont(this.skin.font22);
     }   
    
}
