/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import org.jooq.DSLContext;
import  com.ims.dataAccess.tables.User;
import  com.ims.dataAccess.tables.Dealer;
import  com.ims.dataAccess.tables.Usertype;
import com.ims.dataAccess.tables.daos.DealerDao;
import com.ims.dataAccess.tables.records.DealerRecord;
import com.ims.dataAccess.tables.records.UserRecord;
import com.ims.dataAccess.tables.records.UsertypeRecord;
import domainModels.DealerModel;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import repository.Interface.IRepository;

/**
 *
 * @author Vidhya Mohan
 */
public class DealerRepository extends DealerDao implements IRepository<DealerModel> {
    
  private DSLContext context;
  private Dealer tblDealer;
  private User tblUser;
  private Usertype tblUserType;
  
  
  
  public DealerRepository() {  
     super();
     this.context = MySqlConnection.getDSLContext();    
     this.tblDealer = Dealer.DEALER;
     this.tblUser = User.USER;
     this.tblUserType = Usertype.USERTYPE;         
  }

    @Override
    public int createEntity(DealerModel model) {
       
        model.dealerId = 0;
        model.userId = 0;   
        model.user.userTypeId = context.select()
               .from(tblUserType)
               .where(tblUserType.USERTYPENAME.eq("Dealer"))
               .fetchOne().getValue("userTypeId", int.class);        
        UserRecord userRecord = context.newRecord(tblUser, model.user);                                        
        userRecord.store(); 
        model.userId = model.user.userId = userRecord.getUserid();         
        DealerRecord dealerRecord = context.newRecord(tblDealer, model);        
        return dealerRecord.store();
    }

    @Override
    public int updateEntity(DealerModel model) {
        UserRecord userRecord = context.newRecord(tblUser, model.user);
        userRecord.update();
        return context.newRecord(tblDealer, model).update();       
    }

    @Override
    public int deleteEntityById(int id) {
        return context.deleteFrom(tblDealer).where(tblDealer.DEALERID.eq(id)).execute();
    }

    @Override
    public ArrayList<DealerModel> getAll() {
      List<DealerModel> models =  context.select()
               .from(tblDealer)
               .join(tblUser).on(tblDealer.USERID.eq(tblUser.USERID))
               .join(tblUserType).on(tblUser.USERTYPEID.eq(tblUserType.USERTYPEID))
               .fetch()
               .map(record -> new DealerModel(record));
      return new ArrayList<DealerModel>(models);
    }

    @Override
    public DealerModel getById(int id) {
        
       DealerModel model = context.select()
                          .from(tblDealer)
                          .join(tblUser).on(tblDealer.USERID.eq(tblUser.USERID))
                          .join(tblUserType).on(tblUser.USERTYPEID.eq(tblUserType.USERTYPEID))
                          .where(tblDealer.DEALERID.eq(id))
                          .fetchOne()
                          .map(record -> new DealerModel(record));
       return model;
    }
    
    public List<String> getDealerCompanies() {
        return this.getAll().stream().map(m -> m.companyName).collect(Collectors.toList());
    }
    
    public DealerModel getDealerByCompanyName(String companyName) {
       return this.context.select()
                    .from(tblDealer)
                    .join(tblUser).on(tblDealer.USERID.eq(tblUser.USERID))
                    .where(tblDealer.COMPANYNAME.eq(companyName))
                    .fetchOne()
                    .map(record -> new DealerModel(record));
    }
    
    public boolean isCompanyExists(String companyName) {
       List<DealerModel> models = this.context.select()
                               .from(tblDealer)
                               .where(tblDealer.COMPANYNAME.eq(companyName))
                               .fetch()
                               .map(record -> new DealerModel(record));
                               
       if (models == null || models.size() <= 0) {
           return false;
       }
       return true;
    }
  
  
    
}
