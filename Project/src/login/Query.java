package login;

import java.io.IOException;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import Constants.Connect;

public class Query {

    Connect c1 = new Connect();
    private LogInPage page;

    Query() {

    }

    public boolean runQuery(String email, String password)
    {
        try {
            return extractData(email, password);
        } catch (ClassNotFoundException | IOException e) {
            
            e.printStackTrace();
            return false;
        }
    }
    
    private boolean extractData(String email, String password) throws ClassNotFoundException, IOException
    {
        try{
            String query = "select * from login where email = '" + email + "' and password = '" + password + "'";

            ResultSet exist = c1.s.executeQuery(query);
            if (exist.next()) {
                return true;
                // page.LogIn("mainPage");
            }
            else {
                JOptionPane.showMessageDialog(null, "Invalid LogIn");
                return false;
            }

            // System.out.println(query);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
}
