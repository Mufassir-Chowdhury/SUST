package Constants;

import java.sql.*;

public class conn {
    Connection c;
    public Statement s;

    public conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///sust", "root", "root");
            s = c.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
