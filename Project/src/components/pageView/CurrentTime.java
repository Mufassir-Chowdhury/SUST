package Components.pageView;

import javax.swing.Box;

import Components.Label;
import Components.pageView.Panels.ListPanel;
import Constants.Fonts;
import java.awt.Component;

public class CurrentTime extends ListPanel {
    public CurrentTime(){
        add(new Label("Current Time", Fonts.SUBTITLE, Component.LEFT_ALIGNMENT));
        add(Box.createVerticalStrut(1));
        add(new Label("12:59 PM", Fonts.DISPLAY, Component.LEFT_ALIGNMENT));
        add(Box.createVerticalStrut(1));
        add(new Label("Saturday, April 16, 2022", Fonts.Body, Component.LEFT_ALIGNMENT));
        add(Box.createVerticalStrut(50));
    }    
}
