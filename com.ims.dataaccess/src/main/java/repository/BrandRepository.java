/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import com.ims.dataAccess.tables.daos.BrandDao;
import com.ims.dataAccess.tables.pojos.Product;
import com.ims.dataAccess.tables.records.BrandRecord;
import domainModels.BrandModel;
import java.util.ArrayList;
import java.util.List;
import org.jooq.DSLContext;

/**
 *
 * @author Vidhya Mohan
 */
public class BrandRepository extends BrandDao {
    
    private DSLContext context;
    private com.ims.dataAccess.tables.Brand tblBrand;   
    
    public BrandRepository() {
       this.context = MySqlConnection.getDSLContext();      
       tblBrand = com.ims.dataAccess.tables.Brand.BRAND;   
    }
    
    public int createEntity(BrandModel brandModel) {           
      BrandRecord record = this.context.newRecord(tblBrand, brandModel);
      return record.store();
    }
    
    public int updateEntity(BrandModel brandModel) {         
      BrandRecord record = this.context.newRecord(tblBrand, brandModel);
      return record.update();
    }
    
     public int deleteEntityById(int id) {        
        return context.deleteFrom(tblBrand).where(tblBrand.BRANDID.eq(id)).execute();
    }
    
    public BrandModel getById(int brandId) {        
         return context.selectFrom(tblBrand)
                       .where(tblBrand.BRANDID.eq(brandId))
                       .fetchOne().map(m -> new BrandModel(m));
    }
    
    public ArrayList<BrandModel> getAll() {
         List<BrandModel> model = context.selectFrom(tblBrand)                       
                       .fetch()
                       .map(m -> new BrandModel(m));
         return new ArrayList<BrandModel>(model);                       
    }
    
    public String[] getAllBrandNames() {
          ArrayList<String> brandNames = new ArrayList<String>();        
          context.selectFrom(tblBrand)                       
                 .fetch()
                 .map(m -> new BrandModel(m))
                 .forEach(f -> { brandNames.add(f.brandName);});
            String[] arrBrandNames = new String[brandNames.size()];
         return  brandNames.toArray(arrBrandNames);
    }
    
        public boolean brandNameExists(String searchName) {
            String brandName = this.context.select()
                         .from(tblBrand)
                         .where(tblBrand.BRANDNAME.eq(searchName))
                         .fetchOne(tblBrand.BRANDNAME, String.class);

            if (brandName != null && !brandName.isEmpty()) {
                return true;
            }
       
       return false;
    }
}
