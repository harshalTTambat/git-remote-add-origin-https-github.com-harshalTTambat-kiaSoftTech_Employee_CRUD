package CompanyEmployee;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

     static Connection con;
        public static Connection createDBConnection()
        {

           try{
               // loading driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // getting connection
               String url = "jdbc:mysql://localhost:3306/employeedb";
               String username = "root";
               String password = "harshu9061";
               con = DriverManager.getConnection(url,username,password);
           }catch (Exception e)
           {
               e.printStackTrace();
           }

            return con;
        }
}
