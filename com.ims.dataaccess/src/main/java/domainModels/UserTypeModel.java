/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainModels;

import org.jooq.Record;

/**
 *
 * @author Vidhya Mohan
 */
public class UserTypeModel extends BaseModel {
    
    public UserTypeModel() {
        
    }  
    
    public UserTypeModel(Record record) {
        super(record);
        userTypeId = getValue("userTypeId", int.class);
        userTypeName = getValue("userTypeName", String.class);
        userTypeDescription = getValue("userTypeDescription", String.class);
    }    
    
    public int userTypeId;
    public String userTypeName;
    public String userTypeDescription;
}
