package pages.pageView.updates.routine;

import javax.swing.Box;

import Components.Label;
import Components.Buttons.AccentButton;
import Components.pageView.CurrentTime;
import Components.pageView.Panels.ListPanel;
import Constants.Fonts;
import Server.Datapoints;

import java.awt.Color;
import java.awt.Component;

public class informationPanel extends ListPanel {
    public informationPanel(){
        super(new CurrentTime());
        
        Box line = Box.createHorizontalBox();
        line.setAlignmentX(Component.LEFT_ALIGNMENT);
        line.add(new Label("Your courses", Fonts.Body, Component.LEFT_ALIGNMENT));
        line.add(Box.createHorizontalGlue());
        line.add(new AccentButton("Manage Courses"));
        add(line);
        add(Box.createVerticalStrut(5));
        for(Datapoints.Courses course: Datapoints.getInstance().COURSES){
            if(course.regular.equals(true)){
                add(new Label("     " + course.name, Fonts.CAPTION, new Color(0,120,212)));
            } else{
                Box horizontal = Box.createHorizontalBox();
                horizontal.setAlignmentX(Component.LEFT_ALIGNMENT);
                horizontal.add(new Label("     " + course.name, Fonts.CAPTION, new Color(120,121,241)));
                horizontal.add(Box.createHorizontalGlue());
                horizontal.add(new Label("(Drop)", Fonts.CAPTION, new Color(120,121,241)));
                add(horizontal);
            }
        }
    }
}
