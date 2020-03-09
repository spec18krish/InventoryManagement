


import com.ims.dataAccess.tables.pojos.Productcategory;
import  java.sql.*;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;




public class Program {
    
        public static void main(String args[]) throws SQLException {  
       
         // DSLContext create = DSL.using(getConnection(), SQLDialect.MYSQL);
        try {
  
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
          
      
        }
        
        public static Connection getConnection() throws SQLException{
            String userName = "root";
            String password = "vasanth";
            String url = "jdbc:mysql://localhost:3306/inventorymanagement?useSSL=false";

            // Connection is the only JDBC resource that we need
            // PreparedStatement and ResultSet are handled by jOOQ, internally
            Connection conn = DriverManager.getConnection(url, userName, password);


            return conn;
        }
        
}
