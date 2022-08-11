package Modes.Administration.pages;

import Components.pageView.Panels.ListPanel;
import Components.pageView.Panels.ScrollPane;
import Components.pageView.Panels.Table;

public class PaymentHistory extends ListPanel {
    public PaymentHistory(String title){
        Object[] columnNames = {"ID", "Registration", "Type", "Amount", "Date"};
        Object[][] data = {
            {
                "1",
                "2019331073",
                "Credit Fee",
                "400 BDT",
                "2019-11-11"
            },
            {
                "2",
                "2019331073",
                "Registration Fee",
                "1000 BDT",
                "2019-11-11"
            },
            {
                "3",
                "2019331073",
                "Library Fee",
                "50 BDT",
                "2019-11-11"
            },
            {
                "4",
                "2019331073",
                "Registration Fee",
                "1000 BDT",
                "2019-11-11"
            },
            {
                "5",
                "2019331073",
                "Credit Fee",
                "400 BDT",
                "2019-11-11"
            }
        };
        add(
            new ListPanel(
                    new ScrollPane(
                            new Table(data, columnNames)),
                    null,
                    0
            )
        );
    }
}
