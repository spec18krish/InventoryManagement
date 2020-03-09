/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customcontrols;

import Skin.Skin;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author Vidhya Mohan
 */
public class ComboBox extends JComboBox{
    Skin skin = new Skin();
    public ComboBox() {
        super();
        this.initialize(370, 30, skin.font22);
    }
    
     public ComboBox(int width, int height) {
        super();
        this.initialize(width, height, skin.font22);
    }
     
     public ComboBox(String[] items) {
         super(items);
     }
     
     public void setDefaultModel(ArrayList<String> items) {
         String[] arrItems = new String[items.size()];
         DefaultComboBoxModel model = new DefaultComboBoxModel(items.toArray(arrItems));
         this.setModel(model);
     }
     
     public void setDefaultModel(String[] items) {        
         DefaultComboBoxModel model = new DefaultComboBoxModel(items);
         this.setModel(model);
     }
     
     public void setComboBoxModel(DropDownModel cmbModel) {
         this.setModel(cmbModel);
     }
     
    public void initialize(int width, int height, Font font) {
        this.setSize(300, 40);      
      //  this.setMinimumSize(new Dimension(width, height));
        this.setBackground(skin.frameBackgroundColor);
        this.setFont(skin.font22);
    }
    
}
