
package bank.management.system;
import java.sql.*;

public class Conn {

    Connection c;
    Statement s;
    Conn()
    {
        try{
//            Class.forName(com.mysql.cj.jdbc.Driver);
            c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","1914113412");
            s=c.createStatement();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
   
    
}
