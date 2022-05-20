package pages.pageView;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Components.Label;
import Constants.Fonts;
import Server.Datapoints;

public class attendance extends JPanel {
    class line extends Box{
        public line(Datapoints.Courses course){
            super(BoxLayout.X_AXIS);
            add(new Label(course.code, Fonts.BODY_LARGE));
            add(Box.createHorizontalGlue());
            add(new Label(course.name, Fonts.BODY_LARGE));
            add(Box.createHorizontalGlue());
            add(new Label(String.valueOf(course.attendance), Fonts.Body));
            add(Box.createHorizontalGlue());
            add(new Label(String.valueOf(course.absent), Fonts.Body));
            add(Box.createHorizontalGlue());
            add(new Label(String.valueOf(course.leave), Fonts.Body));
            add(Box.createHorizontalGlue());
        }
    }
    public attendance(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new Label("Regular Courses", Fonts.TITLE, Component.LEFT_ALIGNMENT));
        for(Datapoints.Courses course: Datapoints.COURSES){
            if(course.regular.equals(true)){
                line line = new line(course);
                add(line);
            }
        }
        add(new Label("Drop Courses", Fonts.TITLE, Component.LEFT_ALIGNMENT));
        for(Datapoints.Courses course: Datapoints.COURSES){
            if(course.regular.equals(false)){
                line line = new line(course);
                add(line);
            }
        }
    }
}
