package pages.pageView.misc.bus;

import javax.swing.Box;

import Components.Label;
import Components.pageView.CurrentTime;
import Components.pageView.Panels.ListPanel;
import Constants.Fonts;
import java.awt.Component;

public class informationPanel extends ListPanel{
    public informationPanel(){
        super(new CurrentTime()); 
        
        Box line = Box.createHorizontalBox();
        line.setAlignmentX(Component.LEFT_ALIGNMENT);
        line.add(new Label("Buses", Fonts.BODY_LARGE, Component.LEFT_ALIGNMENT));
        line.add(Box.createHorizontalGlue());
        add(line);
        add(Box.createVerticalStrut(5));
        for(int i=1; i<=7; i++){
            add(new Label("Bus " + i + " - BUS NAME", Fonts.Body));
            add(new Label("Liscence Number - DRIVER NAME", Fonts.CAPTION));
            add(Box.createVerticalStrut(10));
        }
    }
}
