package Common.pages.pageView.administrivia;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.DefaultCellEditor;

import Components.Buttons.AccentButton;
import Components.InputFields.TextField;
import Components.InputFields.TextField.TYPE;
import Components.pageView.Panels.ListPanel;
import Components.pageView.Panels.Table;

public class FixedFee extends ListPanel {
    public FixedFee(int amount){
        add(new Profile());
        add(Box.createVerticalStrut(50));
        Object[][] data = {
            {
                "Amount",
                amount + ""
            }
        };
        Object[][] totalAmount = {
            {
                "Total amount",
                "0 BDT"
            }
        };
        
        
        Table table = new Table(data, Profile.columnNames);
        TextField textField = new TextField(amount + "", TYPE.PLAIN);
        if(amount != 0){
            textField.setEnabled(false);
            textField.setText(amount + " BDT");
        }
        table.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(textField));
        table.setEnabled(true);
        add(table);
        add(new Table(totalAmount, Profile.columnNames));
        AccentButton proceed = new AccentButton("Proceed");
        proceed.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(proceed);
    }
}
