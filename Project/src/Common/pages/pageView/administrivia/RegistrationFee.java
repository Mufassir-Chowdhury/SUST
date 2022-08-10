package Common.pages.pageView.administrivia;

import java.awt.Component;

import javax.swing.Box;

import Components.Label;
import Components.Buttons.AccentButton;
import Components.InputFields.ComboBox;
import Components.pageView.Panels.ListPanel;
import Components.pageView.Panels.TilesPanel;
import Constants.Sizes;

public class RegistrationFee extends ListPanel {
    String[] semesters = {"1-2", "2-1"};
    
    
    public RegistrationFee(){
        add(new Profile());
        add(Box.createVerticalStrut(50));
        
        TilesPanel tilesPanel = new TilesPanel(2, 2, 0);
        tilesPanel.add(new Label("Semester"));
        ComboBox<String> comboBox = new ComboBox<>(semesters);
        comboBox.setMaximumSize(Sizes.TEXT_FIELD_SIZE);
        tilesPanel.add(comboBox);
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
