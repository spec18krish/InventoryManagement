package customcontrols;



import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

public class TableModel<T> extends AbstractTableModel {

	ArrayList<T> tblModel = new ArrayList<T>();
	HashMap<String, String> columnsKeyVal = new LinkedHashMap<String, String>();
	ArrayList<String> columnKeys = new ArrayList<String>();
	
	public TableModel(ArrayList<T> tblModel, HashMap<String, String> columnsKeyVal) {
		this.tblModel = tblModel;
		this.columnsKeyVal = columnsKeyVal;	
		columnsKeyVal.keySet().forEach((item) -> {columnKeys.add(item);});
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return tblModel.size();
	}

	@Override
	public int getColumnCount() {		 
		return columnsKeyVal.size();
	}
	
	@Override
    public Class getColumnClass(int col) {
	      if (columnsKeyVal.get(columnKeys.get(col)) == "View Detail") {
	         return JButton.class;
	      }
	      else {	     
	    	  return String.class;
	      
	      }
    }

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object value = null;
		
		T tblModelRow =  (T) tblModel.get(rowIndex);		 
		 try {
			Field field = tblModelRow.getClass().getField(columnKeys.get(columnIndex));
			value = field.get(tblModelRow);
			
			if(field.getType() == Date.class) {
				return formatDate((Date)value);
			}
		
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return value;
	}
	
   // needed to show column names in JTable
   public String getColumnName(int col) {		
      return columnsKeyVal.get(columnKeys.get(col));
   }
   
   
   
   public String formatDate(Date date){
       if(date != null) {           
           DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
           return dateFormat.format(date);
       }
       return null;
   }

}
