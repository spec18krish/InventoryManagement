/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainModels;

import java.lang.reflect.Field;
import java.sql.Date;
import org.jooq.Record;

/**
 *
 * @author Vidhya Mohan
 */
public class UserModel  extends BaseModel {
    
    public UserModel() {
        this.userType = new UserTypeModel();
    }
    
    public UserModel(Record record) {
        super(record);
       userId = getValue("userId", int.class);
       userTypeId = getValue("userTypeId", int.class);
       firstName = getValue("firstName", String.class);
       lastName = getValue("lastName", String.class);
       userName = getValue("userName", String.class);
       password = getValue("password", String.class);
       gender = getValue("gender", String.class);
       age = getValue("age", int.class);
       email = getValue("email", String.class);
       dateOfBirth = getValue("dateOfBirth", Date.class);
       mobileNumber = getValue("mobileNumber", String.class);
       houseNo = getValue("houseNo", int.class);
       streetName = getValue("streetName", String.class);
       suburb = getValue("suburb", String.class);
       city = getValue("city", String.class);
       userType = new UserTypeModel(record);
       
    }
    
    public int userId;
    public int userTypeId;
    public String firstName;    
    public String lastName;    
    public String userName;    
    public String password;    
    public String gender;    
    public int age;    
    public String email;    
    public Date dateOfBirth;    
    public String mobileNumber;    
    public int houseNo;    
    public String streetName;    
    public String suburb;    
    public String city;
    public UserTypeModel userType;
    

    
    
}
