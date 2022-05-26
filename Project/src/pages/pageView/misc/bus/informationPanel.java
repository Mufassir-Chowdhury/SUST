package pages.pageView.misc.bus;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Components.Label;
import Constants.Fonts;
import java.awt.Component;

public class informationPanel extends JPanel{
    public informationPanel(){
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new Label("Current Time", Fonts.SUBTITLE, Component.LEFT_ALIGNMENT));
        add(Box.createVerticalStrut(1));
        add(new Label("12:59 PM", Fonts.DISPLAY, Component.LEFT_ALIGNMENT));
        add(Box.createVerticalStrut(1));
        add(new Label("Saturday, April 16, 2022", Fonts.Body, Component.LEFT_ALIGNMENT));
        add(Box.createVerticalStrut(50));

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
