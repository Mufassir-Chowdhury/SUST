package Components;

import java.sql.*;

public class Connect {
    Connection c;
    public Statement s;

    public Connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///sust", "root", "root");
            s = c.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
