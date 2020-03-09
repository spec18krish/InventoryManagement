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
public class ProductCategoryModel  extends BaseModel {
    
    public ProductCategoryModel() {
        
    }
    
    public ProductCategoryModel(Record record) {
        super(record);
        categoryId = getValue("categoryId", int.class);
        categoryName = getValue("categoryName", String.class);
        categoryDescription = getValue("categoryDescription", String.class);
    }
    
    public int categoryId;
    public String  categoryName;
    public String categoryDescription;
}
