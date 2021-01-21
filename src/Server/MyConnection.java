
package Server;

import java.sql.Connection;
import java.sql.DriverManager;


public class MyConnection {
    
    static String forname = "com.mysql.cj.jdbc.Driver";
    static String host = "jdbc:mysql://localhost/sakshatkar?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    //static String host = "jdbc:mysql://192.168.43.235/user?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    static String root = "root";
    static String pwd = "";
    
    public static Connection getConnection()
    {
        Connection con =null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
                    
            con = DriverManager.getConnection("jdbc:mysql://localhost/sakshatkar?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root" , "");
            
             /*forname = "com.mysql.cj.jdbc.Driver";
             host = "jdbc:mysql://localhost/user?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
             root = "root";
             pwd = "";*/
            
            
            
        } catch (Exception e) {
            System.out.println("Exception in Myconnection :  " + e);
        }
        
        return con;
    }
    
}
