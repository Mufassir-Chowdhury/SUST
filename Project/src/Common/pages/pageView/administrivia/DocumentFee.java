package Common.pages.pageView.administrivia;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.DefaultCellEditor;

import Components.Buttons.AccentButton;
import Components.InputFields.ComboBox;
import Components.pageView.Panels.ListPanel;
import Components.pageView.Panels.Table;

public class DocumentFee extends ListPanel {
    public DocumentFee(){
        add(new Profile());
        String[] type = {"Transcript", "Grade Sheet", "Provisional Certificate", "Main Certificate"};
        Integer[] numberOfDocuments = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        add(Box.createVerticalStrut(50));
        Object[][] documentType = {
            {
                "Document Type",
                "Select a document"
            }
        };
        Object[][] numberOfDocumentsTable = {
            {
                "Number of documents",
                "Select a number"
            }
        };
        Object[][] amount = {
            {
                "Total amount",
                "0 BDT"
            }
        };
        
        Table table = new Table(documentType, Profile.columnNames);
        table.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(new ComboBox<>(type)));
        table.setEnabled(true);
        add(table);
        Table table2 = new Table(numberOfDocumentsTable, Profile.columnNames);
        table2.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(new ComboBox<>(numberOfDocuments)));
        table2.setEnabled(true);
        add(table2);
        add(new Table(amount, Profile.columnNames));
        AccentButton proceed = new AccentButton("Proceed");
        proceed.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(proceed);
    }
}
