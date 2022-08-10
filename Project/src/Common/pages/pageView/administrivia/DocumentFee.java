package Common.pages.pageView.administrivia;

import java.awt.Component;

import javax.swing.Box;

import Components.Label;
import Components.Buttons.AccentButton;
import Components.InputFields.ComboBox;
import Components.pageView.Panels.ListPanel;
import Components.pageView.Panels.TilesPanel;
import Constants.Sizes;

public class DocumentFee extends ListPanel {
    public DocumentFee(){
        add(new Profile());
        String[] type = {"Transcript", "Grade Sheet", "Provisional Certificate", "Main Certificate"};
        Integer[] numberOfDocuments = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        add(Box.createVerticalStrut(50));
        
        TilesPanel tilesPanel = new TilesPanel(3, 2, 0);
        tilesPanel.add(new Label("Document Type"));
        ComboBox<String> documentType = new ComboBox<>(type);
        documentType.setMaximumSize(Sizes.TEXT_FIELD_SIZE);
        tilesPanel.add(documentType);
        tilesPanel.add(new Label("Number of Documents"));
        ComboBox<Integer> documentCount = new ComboBox<>(numberOfDocuments);
        documentCount.setMaximumSize(Sizes.TEXT_FIELD_SIZE);
        tilesPanel.add(documentCount);
        tilesPanel.add(new Label("Total Amount"));
        tilesPanel.add(new Label("0 BDT"));
        
        add(tilesPanel);

        add(Box.createVerticalStrut(10));
        AccentButton proceed = new AccentButton("Proceed");
        proceed.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(proceed);
        add(Box.createVerticalGlue());
    }
}
