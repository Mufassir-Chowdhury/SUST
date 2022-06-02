package Components.pageView;

import javax.swing.Box;

import Components.Label;
import Components.pageView.Panels.ListPanel;
import Constants.Fonts;
import java.awt.Component;

public class CurrentTime extends ListPanel {
    public CurrentTime(){
        add(new Label("Current Time", Fonts.SUBTITLE, Component.LEFT_ALIGNMENT));
        add(Box.createVerticalStrut(-10));
        add(new Label("12:59 PM", Fonts.SECOND_DISPLAY, Component.LEFT_ALIGNMENT));
        add(Box.createVerticalStrut(-10));
        add(new Label("Saturday,     April 16, 2022", Fonts.BODY, Component.LEFT_ALIGNMENT));
        add(Box.createVerticalGlue());
    }    
}
