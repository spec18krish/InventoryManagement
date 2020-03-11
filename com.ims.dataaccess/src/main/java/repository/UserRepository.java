/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import com.ims.dataAccess.tables.User;
import domainModels.UserModel;
import org.jooq.DSLContext;

/**
 *
 * @author Vidhya Mohan
 */
public class UserRepository {
    
    private DSLContext context;
    private User tblUser;
    
    public UserRepository() {
        this.context = MySqlConnection.getDSLContext(); 
        this.tblUser = User.USER;
    }
    
    public UserModel login(String userName, String password) 
    {
       UserModel model = this.context.selectFrom(tblUser)
                             .where(tblUser.USERNAME.eq(userName))
                             .and(tblUser.PASSWORD.eq(password))
                             .fetchOne()
                             .map(m -> new UserModel(m));
       return model;                  
                    
    }
    
}
