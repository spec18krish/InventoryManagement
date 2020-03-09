/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customcontrols;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Vidhya Mohan
 */
public class GridCellRenderer<T> implements TableCellRenderer {
   
   private TableCellRenderer defaultRenderer;
   private Class<?> controlType;
   
   public GridCellRenderer(TableCellRenderer renderer, Class<?> controlName) {
      defaultRenderer = renderer;
      controlType = controlName;
   }
   
   public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        if (controlType == Button.class) {
            return new Button("button 1");
        }
        

        
//      if(value instanceof Component){
//           return (Component)value;
//      }
      
       return defaultRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
      
   }
    
}
