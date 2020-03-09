/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainModels;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.jooq.Record;

/**
 *
 * @author Vidhya Mohan
 */
public class PurchaseModel extends BaseModel {
    
    public PurchaseModel() {
        
    }
    
      public PurchaseModel(Record records) {  
      
      }
    
    public PurchaseModel(List<Record> records) {  
        super(records.get(0));        
        purchaseId = getValue("purchaseId", int.class);      
        purchaseName = getValue("purchaseName", String.class);
        purchaseDescription = getValue("purchaseDescription", String.class);
        purchaseDate = getValue("purchaseDate", Date.class);
        deliveryDate = getValue("deliveryDate", Date.class);
        shipmentType = getValue("shipmentType", String.class);
        purchaseDetails = new ArrayList<PurchaseDetailModel>();
        for(Record rd: records) {
           PurchaseDetailModel pdm = new PurchaseDetailModel(rd);
           purchaseDetails.add(pdm);
        }       
      
    }   

    
    public int purchaseId;
    public String purchaseName;
    public String purchaseDescription;
    public Date purchaseDate;
    public Date deliveryDate;
    public String shipmentType;   
    public List<PurchaseDetailModel> purchaseDetails;
    
}
