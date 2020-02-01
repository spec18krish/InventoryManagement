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
import javax.swing.JButton;

/**
 *
 * @author Vidhya Mohan
 */
public class Button extends JButton {   
 private Skin skin = new Skin();
    public Button() {
        super();
        initialize();
    }
    
     public Button(String text) {
        super(text);
        initialize();
    }
    
    public void initialize() {
        setBackground(skin.darkButtonColor);
        setForeground(skin.buttonForeGroundColor);
        setSize(190, 38);
        setFont(skin.font17);
    }
}
