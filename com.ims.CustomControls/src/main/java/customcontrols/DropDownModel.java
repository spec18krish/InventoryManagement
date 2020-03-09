/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customcontrols;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Vidhya Mohan
 */
public class DropDownModel<T> extends AbstractListModel implements ComboBoxModel {

    List<T> cmbModel = new ArrayList<T>();
    private T selectedItem;
    private String IdField;
    private String valueField = "";
    public DropDownModel(List<T> model, String valueField, String IdField) {
        this.cmbModel = model;        
        this.valueField = valueField;
        this.IdField = IdField;
    }
    
    @Override
    public int getSize() {
       return cmbModel.size();
    }

    @Override
    public Object getElementAt(int index) {
        Object value = "Not found";
        try 
        {
            T item = cmbModel.get(index);        
            Field field = item.getClass().getDeclaredField(this.valueField);
            value = field.get(item);        
        } 
        catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) 
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
        }
        return value;
    }

    @Override
    public void setSelectedItem(Object item) {
        selectedItem = (T)item;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
    
    public int getSelectedId() {
        int id = -1;
        try{            
           T item = (T)selectedItem;
           Field field = item.getClass().getDeclaredField(IdField);
           id = (int)field.get(item);
         } 
        catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) 
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
        }
        return id;
    }
    
}
