/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;
import com.ims.dataAccess.tables.daos.ProductcategoryDao;
import com.ims.dataAccess.tables.pojos.Productcategory;
import com.ims.dataAccess.tables.records.ProductcategoryRecord;
import domainModels.ProductCategoryModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.jooq.DSLContext;
import org.jooq.Table;

/**
 *
 * @author Vidhya Mohan
 */
public class ProductCategoryRepository extends ProductcategoryDao {
    
    private DSLContext context;
    private com.ims.dataAccess.tables.Productcategory pCat;   
    
    public ProductCategoryRepository() {
        this.context = MySqlConnection.getDSLContext();
         pCat = com.ims.dataAccess.tables.Productcategory.PRODUCTCATEGORY;
    }
    
    public int createEntity(ProductCategoryModel catModel) {           
      ProductcategoryRecord record = this.context.newRecord(pCat, catModel);
      return record.store();
    }
    
    public int updateEntity(ProductCategoryModel catModel) {         
      ProductcategoryRecord record = this.context.newRecord(pCat, catModel);
      return record.update();
    }
    
     public int deleteEntityById(int id) {        
        return context.deleteFrom(pCat).where(pCat.CATEGORYID.eq(id)).execute();
    }
     
     public ArrayList<String> getAllCategoryNames() {
         ArrayList<String> categoryNames = new ArrayList<String>();
         context.select()
                .from(pCat).fetch()
                .map(record -> new ProductCategoryModel(record))
                .forEach(item -> {categoryNames.add(item.categoryName); });
         return categoryNames;
     }
    
    public List<ProductCategoryModel> getAll() { 
        // return context.selectFrom(pCat).fetch().into(Productcategory.class);
        return context.select().from(pCat).fetch().map(record -> new ProductCategoryModel(record));
    }
    
     public Productcategory getById(int id) {        
        return context.selectFrom(pCat).where(pCat.CATEGORYID.eq(id)).fetchOne().into(Productcategory.class);
    }    
    
    
}
