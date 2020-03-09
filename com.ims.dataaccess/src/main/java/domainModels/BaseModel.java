/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainModels;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import org.jooq.Field;
import org.jooq.Record;

/**
 *
 * @author Vidhya Mohan
 */
public class BaseModel {
   
   Record dataRecord;
   ResultSet rs;
   ArrayList<String> recordFields;
   public BaseModel() {
       
   }
   
   public BaseModel(Record record) {
       this.dataRecord = record;
       this.recordFields = new ArrayList<String>();
       for(Field field : Arrays.asList(record.fields())){
           recordFields.add(field.getName());
       }
       
   }

   
   public void setRecord(Record record) {
       this.dataRecord = record;
   }
   
   <T> T getValue(String fieldName, Class<? extends T> type)
   {        
       if (dataRecord != null &&  recordFields.contains(fieldName) ) { 
             return dataRecord.getValue(fieldName, type);      
       }
      
       else {
           if (type == int.class) {
               return (T)(Object)0;
           } 
           else if(type == String.class) {
               return (T) "";
           }
           else if(type == Date.class) {
               return null;
           }
       }
       return null;
   }
   
 
   
}
