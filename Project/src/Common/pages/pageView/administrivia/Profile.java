package Common.pages.pageView.administrivia;

import java.awt.Component;

import Components.pageView.Panels.ListPanel;
import Components.pageView.Panels.Table;

public class Profile extends ListPanel {
    public static String[] columnNames = {
        "Field",
        "Value"
    };
    public Profile(){
        Object[][] data = {
            {
                "Name",
                "Mufassir Ahmad Chowdhury"
            },
            {
                "Registration Number",
                "2019331073"
            },
            {
                "Department",
                "Computer Science and Engineering"
            },
            {
                "Session",
                "2019-2020"
            },
            {
                "Mobile",
                "01771144308"
            },
            {
                "Email",
                "mac22214u@gmail.com"
            }
        };
        
        add(new Table(data, columnNames));
        setAlignmentX(Component.LEFT_ALIGNMENT);
    }
}
