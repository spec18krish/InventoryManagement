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
public class PurchaseProductModel {
    
    public PurchaseProductModel() {
        
    }
    
    public PurchaseProductModel(Record record) {
        product = new ProductModel(record);
    }
    
    public int quantity;
    public String purchaseDescription;
    public boolean requireOrder;    
    public ProductModel product;
    
}
