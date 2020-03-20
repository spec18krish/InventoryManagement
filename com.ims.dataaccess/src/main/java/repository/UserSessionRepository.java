/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import domainModels.UserModel;

/**
 *
 * @author Vidhya Mohan
 */
public class UserSessionRepository {
    
    public static UserModel userSession  = new UserModel();
    
    public UserSessionRepository() 
    {
        
    }
    
    public static UserModel getUserModel() {
        return userSession;
    } 
    
    public static void setUserModel(UserModel currentUserSession) {
        userSession = currentUserSession;
    }
    
    public static String getUserName() {
       return userSession.userName;
    }
    
    public static String getUserFullName() {
        return userSession.firstName +" "+ userSession.lastName;
    }
    
    public static String getUserRole() {
        return userSession.userType.userTypeName;
    }
    
    public static void logout() {
       userSession = null;
    }
    
}
