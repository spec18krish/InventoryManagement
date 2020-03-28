/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import com.ims.dataAccess.tables.User;
import com.ims.dataAccess.tables.Usertype;
import com.ims.dataAccess.tables.records.DealerRecord;
import com.ims.dataAccess.tables.records.UserRecord;
import domainModels.DealerModel;
import domainModels.UserModel;
import domainModels.UserTypeModel;
import java.util.ArrayList;
import java.util.List;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record;
import static org.jooq.impl.DSL.trueCondition;
import repository.Interface.IRepository;

/**
 *
 * @author Vidhya Mohan
 */
public class UserRepository implements IRepository<UserModel>  {
    
    private DSLContext context;
    private User tblUser;
    private Usertype tblUserType;
    
    public UserRepository() {
        this.context = MySqlConnection.getDSLContext(); 
        this.tblUser = User.USER;
        this.tblUserType = Usertype.USERTYPE;
    }
    
    private Condition makeCondition( String col, Object val, Condition where) {
        
        return where.and(col+"='"+val+"'");
    }
    
    private Condition makeCondition(String table, String col, Object val, Condition where) {
        
        return where.and(table +"."+col+"='"+val+"'");
    }
    
    public List<UserModel> searchUser(int userId, String firstName, String email, String userType) {
        
        Condition where = trueCondition();
        
        where = userId > 0 ? makeCondition(tblUser.getName(), tblUser.USERID.getName(),userId, where)  :
                  where;
        where = !firstName.isEmpty() ? makeCondition(tblUser.FIRSTNAME.getName(),firstName, where)  :
                  where;
        where = !email.isEmpty() ? makeCondition( tblUser.EMAIL.getName(),email, where)  :
                  where;
        where = !userType.isEmpty() ? makeCondition(tblUserType.USERTYPENAME.getName() ,userType, where)  :
                  where;
        
      return   context.select()
               .from(tblUser)              
               .join(tblUserType).on(tblUser.USERTYPEID.eq(tblUserType.USERTYPEID))
               .where(where)
               .fetch()
               .map(record -> new UserModel(record)); 
        
    }
    
    @Override
    public int createEntity(UserModel model) {         
        
        model.userId = 0;   
        model.userTypeId = context.select()
               .from(tblUserType)
               .where(tblUserType.USERTYPENAME.eq(model.userType.userTypeName))
               .fetchOne().getValue("userTypeId", int.class);        
        UserRecord userRecord = context.newRecord(tblUser, model);                                        
        return userRecord.store();  
    }

    @Override
    public int updateEntity(UserModel model) {       
        return context.newRecord(tblUser, model).update(); 
    }

    @Override
    public int deleteEntityById(int id) {
        return context.deleteFrom(tblUser).where(tblUser.USERID.eq(id)).execute();
    }

    @Override
    public ArrayList<UserModel> getAll() {
      List<UserModel> models =  context.select()
               .from(tblUser)              
               .join(tblUserType).on(tblUser.USERTYPEID.eq(tblUserType.USERTYPEID))
               .fetch()
               .map(record -> new UserModel(record));
      return new ArrayList<UserModel>(models);
    }

    @Override
    public UserModel getById(int id) {
        
       UserModel model = context.select()
                          .from(tblUser)                         
                          .join(tblUserType).on(tblUser.USERTYPEID.eq(tblUserType.USERTYPEID))
                          .where(tblUser.USERID.eq(id))
                          .fetchOne()
                          .map(record -> new UserModel(record));
       return model;
    }
  
  
    public List<UserTypeModel> getAllUserType() {
                           return context.select()
                                   .from(tblUserType)
                                   .fetch()
                                   .map(record -> new UserTypeModel(record));     
    }
    
    
    public UserModel login(String userName, String password) 
    {
       Record record = this.context.select()
                             .from(tblUser)
                             .join(tblUserType).on(tblUserType.USERTYPEID.eq(tblUser.USERTYPEID))
                             .where(tblUser.USERNAME.eq(userName))
                             .and(tblUser.PASSWORD.eq(password))
                             .fetchOne();
       if (record == null) {
           
           return null;
       }
       UserModel userModel =   record.map(m -> new UserModel(m));
       return userModel;                  
                    
    }
    
}
