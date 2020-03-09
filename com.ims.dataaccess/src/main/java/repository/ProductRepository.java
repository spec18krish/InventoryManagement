/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import com.ims.dataAccess.tables.Dealer;
import com.ims.dataAccess.tables.Productcategory;
import com.ims.dataAccess.tables.daos.ProductDao;
import com.ims.dataAccess.tables.pojos.Product;
import com.ims.dataAccess.tables.records.BrandRecord;
import com.ims.dataAccess.tables.records.ProductRecord;
import com.ims.dataAccess.tables.records.ProductcategoryRecord;
import domainModels.ProductModel;
import domainModels.PurchaseProductModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;

/**
 *
 * @author Vidhya Mohan
 */
public class ProductRepository extends ProductDao {
    
    private DSLContext context;
    private com.ims.dataAccess.tables.Product tblProduct;   
    private com.ims.dataAccess.tables.Brand tblBrand;   
    private com.ims.dataAccess.tables.Productcategory tblCategory;   
    private Dealer tblDealer;

    
    public ProductRepository() {
       this.context = MySqlConnection.getDSLContext();
       tblProduct = com.ims.dataAccess.tables.Product.PRODUCT;    
       tblBrand = com.ims.dataAccess.tables.Brand.BRAND;   
       tblCategory = com.ims.dataAccess.tables.Productcategory.PRODUCTCATEGORY;   
       tblDealer = Dealer.DEALER;
    }
    
       
    public int createEntity(ProductModel productModel) {           
      ProductRecord record = this.context.newRecord(tblProduct, productModel);
      return record.store();
    }
    
    public int updateEntity(ProductModel productModel) {         
      ProductRecord record = this.context.newRecord(tblProduct, productModel); 
      return record.update();
    }
    
     public int deleteEntityById(int id) {        
        return context.deleteFrom(tblProduct).where(tblProduct.PRODUCTID.eq(id)).execute();
    }
    
    public ArrayList<ProductModel> getAll() { 
        
        List<ProductModel> results =   context.select()
                        .from(tblProduct)
                        .join(tblBrand).on(tblProduct.BRANDID.eq(tblBrand.BRANDID))
                        .join(tblCategory).on(tblProduct.CATEGORYID.eq(tblCategory.CATEGORYID))
                        .join(tblDealer).on(tblProduct.DEALERID.eq(tblDealer.DEALERID))
                        .fetch()
                        .map(record -> new ProductModel(record));         
       
         
         return new ArrayList<ProductModel>(results);        
    }
    
      public ArrayList<PurchaseProductModel> getAllByPurchaseProductModel() { 
        
        List<PurchaseProductModel> results =   context.select()
                        .from(tblProduct)
                        .join(tblBrand).on(tblProduct.BRANDID.eq(tblBrand.BRANDID))
                        .join(tblCategory).on(tblProduct.CATEGORYID.eq(tblCategory.CATEGORYID))
                        .join(tblDealer).on(tblProduct.DEALERID.eq(tblDealer.DEALERID))
                        .fetch()
                        .map(record -> new PurchaseProductModel(record));         
       
         
         return new ArrayList<PurchaseProductModel>(results);        
    }
    
     public ProductModel getById(int id) {        
        return context.select().from(tblProduct)                     
                      .join(tblBrand).on(tblProduct.BRANDID.eq(tblBrand.BRANDID))
                      .join(tblCategory).on(tblProduct.CATEGORYID.eq(tblCategory.CATEGORYID))
                      .join(tblDealer).on(tblProduct.DEALERID.eq(tblDealer.DEALERID))
                      .where(tblProduct.PRODUCTID.eq(id))
                      .fetchOne()
                      .map(m -> new ProductModel(m));
    }  
    
}
