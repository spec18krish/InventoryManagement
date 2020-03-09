package customcontrols;



import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        
        public ArrayList<T> getGridModel() {
            return this.tblModel;
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
          
                     // if (columnsKeyVal.get(columnKeys.get(col)) == "View Detail") { 
                if (tblModel.size() > 0) {
                    T tblModelRow = tblModel.get(0);
                    String columnName = columnKeys.get(col);
                    Object value = getValueFromRow(tblModelRow, columnName);
                    if (value.getClass() == Boolean.class ) {
                     return Boolean.class;
                   }
                  else {	     
                      return String.class;	      
                  }
                }

           return String.class;
    }
    
    @Override
    public boolean isCellEditable(int row, int column) { // custom isCellEditable function
//        if (columnKeys.get(column).getClass() == String.class &&  columnKeys.get(column) == "Boolean") {
//            return false;
//        }
//        
//        return false;
        
        return false;
    }
    
     private Object getValueFromRow(T tblModelRow, String columnName) {
             Object value = null;
             String subColumnName = "";
             try {

                if (columnName.contains("-")) {
                 String[] splitVal = columnName.split("-");
                 columnName = splitVal[0];

                 Field field = tblModelRow.getClass().getDeclaredField(columnName);
                 Object subValue = field.get(tblModelRow);                   

                 int level = 1;

                 Field innerField;

                 while( level < splitVal.length) {
                     subColumnName = splitVal[level];
                     innerField = subValue.getClass().getDeclaredField(subColumnName);
                     subValue = innerField.get(subValue); 
                     level += 1;
                 }

                 value = subValue;
                 } 
                 else 
                 {

                 Field field = tblModelRow.getClass().getDeclaredField(columnName);
                 value = field.get(tblModelRow);                       
                 }
             }
             
	   catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
             return value;
     }

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object value = null;
		
		T tblModelRow =  (T) tblModel.get(rowIndex);		 
		                     
                String columnName = columnKeys.get(columnIndex);
                value = getValueFromRow(tblModelRow, columnName);  
		
		return value;
        }
	
   // needed to show column names in JTable
   public String getColumnName(int col) {		
      return columnsKeyVal.get(columnKeys.get(col));
   }
   
   public T getRowByIndex(int rowIndex) {
       T tblModelRow =  (T) tblModel.get(rowIndex);
       return tblModelRow;
   }
   
   
   
   public String formatDate(Date date){
       if(date != null) {           
           DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
           return dateFormat.format(date);
       }
       return null;
   }

}
