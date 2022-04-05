package lms;

import java.sql.Connection;
import java.sql.DriverManager;


public class Connects {

        public static Connection openConnection() throws Exception{
       
        String connectionUrl = "jdbc:sqlserver://localhost:1433;database=QL";
        String username = "sa";
        String password = "abc123";
        Connection conn ;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        conn = DriverManager.getConnection(connectionUrl,username,password);
        System.out.println(conn.getCatalog());
        return conn;
       
    }
    public static void main(String[] args) throws Exception {
        openConnection();
    }
}



