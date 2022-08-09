package Common.pages.pageView.administrivia;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.DefaultCellEditor;

import Components.Buttons.AccentButton;
import Components.InputFields.ComboBox;
import Components.pageView.Panels.ListPanel;
import Components.pageView.Panels.Table;

public class RegistrationFee extends ListPanel {
    
    
    public RegistrationFee(){
        add(new Profile());
        add(Box.createVerticalStrut(50));
        String[] semesters = {"1-2", "2-1"};
        Object[][] data = {
            {
                "Semester",
                "Select a semester"
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
        add(new Table(amount, Profile.columnNames));
        add(Box.createVerticalStrut(10));
        AccentButton proceed = new AccentButton("Proceed");
        proceed.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(proceed);
    }
}
