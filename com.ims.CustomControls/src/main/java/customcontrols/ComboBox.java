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
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.border.Border;

/**
 *
 * @author Vidhya Mohan
 */
public class ComboBox extends JComboBox{
    Skin skin = new Skin();
    public boolean required = true;
    public String initialVal = "--Select Items--";
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
     
     public void reset () {
        this.setSelectedItem(this.initialVal);
        this.setBackground(skin.frameBackgroundColor);
     }
     
     public void setDefaultModel(ArrayList<String> arrayListItems) {
         String[] items = this.addInitialItem(arrayListItems);
         DefaultComboBoxModel model = new DefaultComboBoxModel(items);
         this.setModel(model);
     }
     
     public String[] addInitialItem(ArrayList<String> arrayListItems) {
          arrayListItems.add(initialVal);
          List<String> itemsList =  arrayListItems.stream()
		              .sorted(Comparator.naturalOrder())
			      .collect(Collectors.toList());
            String[] items = new String[itemsList.size()];
            return arrayListItems.toArray(items);
     }
     
     public void setDefaultModel(String[] items) {     
         ArrayList<String> list = new ArrayList<String>(Arrays.asList(items));
         items = this.addInitialItem(list);
         DefaultComboBoxModel model = new DefaultComboBoxModel(items);         
         this.setModel(model);
     }
     
     public void setComboBoxModel(DropDownModel cmbModel) {
         this.setModel(cmbModel);
     }
     
    public void initialize(int width, int height, Font font) {
        this.setSize(300, 40);      
      //  this.setMinimumSize(new Dimension(width, height));
        Border bdr = new javax.swing.border.MatteBorder(0, 0, 2, 0, this.skin.lightSteelBlueColor);            
        setBorder(bdr);       
        this.setBackground(skin.frameBackgroundColor);
        this.setFont(skin.font22);
    }
    
     public boolean hasValidValue() {
        String value = this.getSelectedString();
        if (required ) {
            if (value != null && !value.trim().isEmpty() && !value.equals(this.initialVal)) {
                this.setBackground(skin.frameBackgroundColor);
                return true;
            }
             this.setBackground(skin.inValidControlColor);
        }       
        return false;
    }
    
    
    public String getSelectedString() {
      String item =  this.getSelectedItem().toString();
      return item.equals(initialVal) ? "" : item;
    }
    
}
