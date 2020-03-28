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
public class ProductModel extends BaseModel {
    
    public ProductModel() {
        
    }
    
    public ProductModel(Record record){      
     super(record);
     this.productId = getValue("productId", Integer.class);
     this.name =  getValue("name", String.class);
     this.availableStock =  getValue("availableStock", int.class);
     this.productDescription =  getValue("productDescription", String.class);     
     this.price = getValue("price", Long.class);
     this.brandId = brandId = getValue("brandId", int.class);
     this.categoryId =  getValue("categoryId", int.class);
     this.dealerId = getValue("dealerId", int.class);
     this.brand = new BrandModel(record);
     this.category = new ProductCategoryModel(record);  
     this.dealer = new DealerModel(record);
    }  
    
    public int productId;
    public String  name;
    public int availableStock;
    public String  productDescription;
    public Long    price;
    public byte[]  image;
    public int categoryId;
    public int brandId;
    public int dealerId;
    public BrandModel brand;
    public ProductCategoryModel category;
    public DealerModel dealer;
    
}
