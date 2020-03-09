/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainModels;

import com.ims.dataAccess.tables.User;
import org.jooq.Record;

/**
 *
 * @author Vidhya Mohan
 */
public class DealerModel extends BaseModel {
    
    public DealerModel() {
        user = new UserModel();
    }
    
    public DealerModel(Record record) {
        super(record);
     
        dealerId = getValue("dealerId", int.class);
        companyName = getValue("companyName", String.class);
        userId = getValue("userId", int.class);
        user = new UserModel(record);
        dealerDescription = getValue("dealerDescription", String.class);
    }
    
    public int dealerId;
    public int userId;
    public String companyName;   
    public UserModel user;
    public String dealerDescription;
}
