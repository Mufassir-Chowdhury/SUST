package login;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Constants.Connect;
import Constants.Values;

public class Query {

    Connect c1 = new Connect();
    private ResultSet exist;

    Query() {

    }

    public String runQuery(String email, String password)
    {
        try {
            if (extractData(email))
            {
                if(exist.getString("password") == password)
                {
                    return Values.PASSED;
                }
                else
                    return Values.WRONG_PASSWORD;
            }
            else
                return Values.WRONG_EMAIL;

        } catch (ClassNotFoundException | IOException | SQLException e) {
            
            e.printStackTrace();
            return "";
        }
    }
    
    private boolean extractData(String email) throws ClassNotFoundException, IOException
    {
        try{
            String query = "select * from login where email = '" + email + "';";

            exist = c1.s.executeQuery(query);
            if (exist.next()) {
                return true;
                
            }
            else {
                JOptionPane.showMessageDialog(null, "Invalid LogIn");
                return false;
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
}
