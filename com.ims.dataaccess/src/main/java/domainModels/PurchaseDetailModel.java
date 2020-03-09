/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainModels;


import java.util.Date;
import org.jooq.Record;

/**
 *
 * @author Vidhya Mohan
 */
public class PurchaseDetailModel extends BaseModel {
    
    public PurchaseDetailModel() {
        
    }
    
    public PurchaseDetailModel(Record record) {
        super(record);
        purchaseDetailId = getValue("purchaseDetailId", int.class);
        purchaseId = getValue("purchaseId", int.class);
        productId = getValue("productId", int.class);
        quantity = getValue("quantity", int.class);
        purchaseNotes = getValue("purchaseNotes", String.class);
        product = new ProductModel(record);
    }
    
    public int purchaseDetailId;
    public int purchaseId;
    public int productId;
    public int quantity;
    public boolean requireOrder;
    public String purchaseNotes;
    public ProductModel product;
    
}
