package Common.pages.pageView.administrivia;

import Components.Label;
import Components.pageView.Panels.TilesPanel;
import Constants.Colors;
import java.awt.Graphics;

public class Profile extends TilesPanel {
    public static String[] columnNames = {
        "Field",
        "Value"
    };
    public Profile(){
        super(6, 2, 0, 0);

        String[][] data = {
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
        for(int i=0; i<data.length; i++){
            add(new Label(data[i][0]));
            add(new Label(data[i][1]));
        }
    }
    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(Colors.Theme.ACCENT_FILL);
        g.fillRoundRect(0, getHeight() -1, getWidth(), 2, 0, 0);
    }
}
