package Common.pages.pageView.administrivia;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.DefaultCellEditor;

import Components.Buttons.AccentButton;
import Components.InputFields.ComboBox;
import Components.InputFields.TextField;
import Components.InputFields.TextField.TYPE;
import Components.pageView.Panels.ListPanel;
import Components.pageView.Panels.Table;

public class CreditFee extends ListPanel {
    public CreditFee(){
        add(new Profile());
        String[] semesters = {"1-2", "2-1"};

        add(Box.createVerticalStrut(50));
        Object[][] data = {
            {
                "Semester",
                "Select a semester"
            }
        };
        Object[][] data2 = {
            {
                "Number of Credits (Theory)",
                "Enter number of credits"
            },
            {
                "Number of Credits (Lab)",
                "Enter number of credits"
            }
        };
        Object[][] amount = {
            {
                "Total amount",
                "0 BDT"
            }
        };
        
        Table table = new Table(data, Profile.columnNames);
        table.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(new ComboBox<>(semesters)));
        table.setEnabled(true);
        add(table);
        Table table2 = new Table(data2, Profile.columnNames);
        table2.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(new TextField("Enter number of credits", TYPE.PLAIN)));
        table2.setEnabled(true);
        add(table2);
        add(new Table(amount, Profile.columnNames));
        AccentButton proceed = new AccentButton("Proceed");
        proceed.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(proceed);
    }
}
