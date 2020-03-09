/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

/**
 *
 * @author Vidhya Mohan
 */
public class MySqlConnection {
    
    
    public static Connection getConnection() throws SQLException
    {
        String userName = "root";
        String password = "vasanth";
        String url = "jdbc:mysql://localhost:3306/inventoryManagement?allowPublicKeyRetrieval=true";

        // Connection is the only JDBC resource that we need
        // PreparedStatement and ResultSet are handled by jOOQ, internally
        Connection conn = DriverManager.getConnection(url, userName, password);


        return conn;
    }
    
    public static DSLContext getDSLContext() {
        try{
        DSLContext context = DSL.using(getConnection(), SQLDialect.MYSQL);
         return context;
        }
        catch(SQLException  e) {
            return null;
        }
       
    }
    
}
