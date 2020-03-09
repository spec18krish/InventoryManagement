/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import com.ims.dataAccess.tables.Brand;
import com.ims.dataAccess.tables.Dealer;
import com.ims.dataAccess.tables.Product;
import com.ims.dataAccess.tables.Productcategory;
import com.ims.dataAccess.tables.Purchase;
import com.ims.dataAccess.tables.Purchasedetail;
import com.ims.dataAccess.tables.User;
import com.ims.dataAccess.tables.records.PurchaseRecord;
import com.ims.dataAccess.tables.records.PurchasedetailRecord;
import domainModels.PurchaseDetailModel;
import domainModels.PurchaseModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.groupingBy;
import org.jooq.Batch;
import org.jooq.DSLContext;
import org.jooq.Record;


import repository.Interface.IRepository;

/**
 *
 * @author Vidhya Mohan
 */
public class PurchaseRepository implements IRepository<PurchaseModel>{
    
    private DSLContext context;
    private Purchase tblPurchase;
    private Purchasedetail tblPurchaseDetail;
    private Product tblProduct;
    private Brand tblBrand;
    private Productcategory tblProductCategory;
    private Dealer tblDealer;
    private User tblUser;
      
    public PurchaseRepository() {
         this.context = MySqlConnection.getDSLContext();
         this.tblPurchase = Purchase.PURCHASE;
         this.tblPurchaseDetail = Purchasedetail.PURCHASEDETAIL;
         this.tblProduct = Product.PRODUCT;
         this.tblBrand = Brand.BRAND;
         this.tblProductCategory = Productcategory.PRODUCTCATEGORY;
         this.tblDealer = Dealer.DEALER;
         this.tblUser = User.USER;
    }

    @Override
    public int createEntity(PurchaseModel model) {       
      
       PurchaseRecord purchaseRecord = context.newRecord(tblPurchase, model);       
       purchaseRecord.store();
       model.purchaseId = purchaseRecord.getPurchaseid();
       List<PurchasedetailRecord> recordList = new ArrayList<PurchasedetailRecord>();
       
       for(PurchaseDetailModel detailRecord : model.purchaseDetails) {
           detailRecord.purchaseId = model.purchaseId;
           recordList.add(context.newRecord(tblPurchaseDetail, detailRecord));
       }
      
       return context.batchInsert(recordList).execute().length;
       
    }

    @Override
    public int updateEntity(PurchaseModel model) {
       PurchaseRecord purchaseRecord = context.newRecord(tblPurchase, model);
       purchaseRecord.update();
       model.purchaseId = purchaseRecord.getPurchaseid();
       List<PurchasedetailRecord> recordList = new ArrayList<PurchasedetailRecord>();
       model.purchaseDetails.forEach(f -> recordList.add(context.newRecord(tblPurchaseDetail, f)));
       return context.batchUpdate(recordList).execute().length;
    }

    @Override
    public int deleteEntityById(int id) {
         context.deleteFrom(tblPurchaseDetail).where(tblPurchaseDetail.PURCHASEID.eq(id)).execute();
         return context.deleteFrom(tblPurchase).where(tblPurchase.PURCHASEID.eq(id)).execute();
    }

    @Override
    public ArrayList<PurchaseModel> getAll() {
        ArrayList<PurchaseModel> alPurchaseModel = new ArrayList<PurchaseModel>();
        List<Record> records = context.select()
                                      .from(tblPurchase)
                                      .join(tblPurchaseDetail).on(tblPurchase.PURCHASEID.eq(tblPurchaseDetail.PURCHASEID))
                                      .join(tblProduct).on(tblPurchaseDetail.PRODUCTID.eq(tblProduct.PRODUCTID))
                                      .join(tblBrand).on(tblProduct.BRANDID.eq(tblBrand.BRANDID))
                                      .join(tblProductCategory).on(tblProduct.CATEGORYID.eq(tblProductCategory.CATEGORYID))
                                     // .join(tblDealer).on(tblDealer.DEALERID.eq(tblProduct.DEALERID))
                                      .fetch();
         Map<Integer, List<Record>> mapper =   records.stream().collect(Collectors.groupingBy(x -> ((Record)x).getValue("purchaseId", int.class)));
     
         for (Map.Entry<Integer, List<Record>> entry : mapper.entrySet()) {
           alPurchaseModel.add(new PurchaseModel(entry.getValue()));
         }
             
        return alPurchaseModel;
       
    }

    @Override
    public PurchaseModel getById(int id) {
        List<Record> record = context.select()
                                      .from(tblPurchase)
                                      .join(tblPurchaseDetail).on(tblPurchase.PURCHASEID.eq(tblPurchaseDetail.PURCHASEID))
                                      .join(tblProduct).on(tblPurchaseDetail.PRODUCTID.eq(tblProduct.PRODUCTID))
                                      .join(tblBrand).on(tblProduct.BRANDID.eq(tblBrand.BRANDID))
                                      .join(tblProductCategory).on(tblProduct.CATEGORYID.eq(tblProductCategory.CATEGORYID))                      
                                      .join(tblDealer).on(tblDealer.DEALERID.eq(tblProduct.DEALERID))
                                      .join(tblUser).on(tblDealer.USERID.eq(tblUser.USERID))
                                      .where(tblPurchase.PURCHASEID.eq(id))
                                      .fetch();
        PurchaseModel purchaseModel = new PurchaseModel(record);                                      
                                      
        return purchaseModel;
    }
    
}
