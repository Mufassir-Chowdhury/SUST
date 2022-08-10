package Common.pages.pageView.administrivia;

import java.awt.Component;

import javax.swing.Box;

import Components.Label;
import Components.Buttons.AccentButton;
import Components.InputFields.TextField;
import Components.InputFields.TextField.TYPE;
import Components.pageView.Panels.ListPanel;
import Components.pageView.Panels.TilesPanel;

public class FixedFee extends ListPanel {
    public FixedFee(int amount){
        add(new Profile());
        add(Box.createVerticalStrut(50));
        
        TilesPanel tilesPanel = new TilesPanel(2, 2, 0);
        tilesPanel.add(new Label("Amount"));
        if(amount != 0)
            tilesPanel.add(new Label(amount + " BDT"));
        else
            tilesPanel.add(new TextField("Enter amount", TYPE.PLAIN));
        tilesPanel.add(new Label("Total Amount"));
        tilesPanel.add(new Label("0 BDT"));
        
        add(tilesPanel);
        
        AccentButton proceed = new AccentButton("Proceed");
        proceed.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(proceed);
        add(Box.createVerticalGlue());
    }
}
