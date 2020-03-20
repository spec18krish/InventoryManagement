/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import com.ims.dataAccess.tables.User;
import com.ims.dataAccess.tables.Usertype;
import domainModels.UserModel;
import org.jooq.DSLContext;
import org.jooq.Record;

/**
 *
 * @author Vidhya Mohan
 */
public class UserRepository {
    
    private DSLContext context;
    private User tblUser;
    private Usertype tblUserType;
    
    public UserRepository() {
        this.context = MySqlConnection.getDSLContext(); 
        this.tblUser = User.USER;
        this.tblUserType = Usertype.USERTYPE;
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
