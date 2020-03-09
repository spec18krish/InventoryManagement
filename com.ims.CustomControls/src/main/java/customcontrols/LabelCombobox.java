/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customcontrols;

import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;

/**
 *
 * @author Vidhya Mohan
 */
public class LabelCombobox extends Panel {   
    

   public LabelCombobox() {
        initComponents();
    }
   
   public LabelCombobox(String labelText, Font font, String[] items) {
         this.setControls(font, labelText, items);
         this.initialize(labelText, font, 0, items);
    }
   
   public LabelCombobox(String labelText, Font font, ArrayList<String> arrayListItems) {
       
         String[] arrayItems = new String[arrayListItems.size()];
         arrayListItems.toArray(arrayItems);
         this.setControls(font, labelText, arrayItems);
         this.initialize(labelText, font, 0, arrayItems);
    }
   
    public LabelCombobox(String labelText, String[] items) {             
           this.initialize(labelText, this.skin.font22, 0, items);
    }
    
    public LabelCombobox(String labelText, int width, String[] items) {          
           this.initialize(labelText, this.skin.font22, width, items);          
    }
    
    private void initialize( String labelText, Font font, int width, String[] items){       
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        this.setControls(font, labelText, items);
        if (width == 0){
        this.setPreferredSize(this.skin.fieldDimension);
        } else {
             this.setPreferredSize(new Dimension(width, this.skin.fieldDimension.height));
        }
        this.add(label);       
        this.add(Box.createRigidArea(new Dimension(15,0)));
        this.add(combobox);  
   }
   
   public void setControls(Font font, String labelText, String[] items) {
        this.label = new Label();
        label.setText(labelText);
        label.setFont(font);    
        combobox = new JComboBox(items);
        combobox.setFont(font);   
   }
   

   
   public String selectedItem(){
       return (String) this.combobox.getSelectedItem();
   }
   
    public int selectedIndex(){
       return (int) this.combobox.getSelectedIndex();
   }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label = new customcontrols.Label();
        combobox = new javax.swing.JComboBox();

        label.setText("label1");

        combobox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(combobox, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox combobox;
    private customcontrols.Label label;
    // End of variables declaration//GEN-END:variables
}
