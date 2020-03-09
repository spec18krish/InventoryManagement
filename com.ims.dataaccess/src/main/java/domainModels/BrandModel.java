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
public class BrandModel extends BaseModel {
    
    public BrandModel() {
        
    }
    
    public BrandModel(Record record) {
        super(record);
        brandId = getValue("brandId", int.class);
        brandName = getValue("brandName", String.class);
        brandDescription = getValue("brandDescription", String.class);
    }
   
    
    public int brandId;
    public String  brandName;
    public String brandDescription;
}
