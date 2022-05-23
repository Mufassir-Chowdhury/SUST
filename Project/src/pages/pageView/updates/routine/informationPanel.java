package pages.pageView.updates.routine;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Components.Label;
import Components.Buttons.AccentButton;
import Constants.Colors;
import Constants.Fonts;
import Server.Datapoints;

import java.awt.Color;
import java.awt.Component;

public class informationPanel extends JPanel {
    public informationPanel(){
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new Label("Current Time", Fonts.SUBTITLE, Component.LEFT_ALIGNMENT));
        add(Box.createVerticalStrut(1));
        add(new Label("12:59 PM", Fonts.DISPLAY, Component.LEFT_ALIGNMENT));
        add(Box.createVerticalStrut(1));
        add(new Label("Saturday, April 16, 2022", Fonts.BODY_LARGE, Component.LEFT_ALIGNMENT));
        // setBackground(Color.CYAN);
        add(Box.createVerticalStrut(20));

        Box line = Box.createHorizontalBox();
        line.setAlignmentX(Component.LEFT_ALIGNMENT);
        line.add(new Label("Your courses", Fonts.Body, Component.LEFT_ALIGNMENT));
        line.add(Box.createHorizontalGlue());
        line.add(new AccentButton("Manage Courses"));
        add(line);
        add(Box.createVerticalStrut(5));
        for(Datapoints.Courses course: Datapoints.getInstance().COURSES){
            if(course.regular.equals(true)){
                add(new Label("     " + course.name, Fonts.CAPTION, Colors.PLAIN_TEXT));
            } else{
                add(new Label("     " + course.name, Fonts.CAPTION, Colors.ACCENT));
            }
        }
    }
}
