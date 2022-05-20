package pages.pageView;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Components.Label;
import Constants.Fonts;
import Server.Datapoints;
import java.awt.Component;

public class assignment extends JPanel {
    class line extends Box{
        public line(Datapoints.Courses.Assignment assignment){
            super(BoxLayout.X_AXIS);
            add(new Label(assignment.title, Fonts.BODY_LARGE));
            add(Box.createHorizontalGlue());
            add(new Label(assignment.date, Fonts.Body));
            add(Box.createHorizontalGlue());
            add(new Label(String.valueOf(assignment.totalMarks), Fonts.Body));
            add(Box.createHorizontalGlue());
            add(new Label(String.valueOf(assignment.marksObtained), Fonts.Body));
            add(Box.createHorizontalGlue());
        }
    }
    public assignment(){
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Box title = Box.createHorizontalBox();
        title.setAlignmentX(Component.LEFT_ALIGNMENT);
        title.add(new Label("Assignment", Fonts.DISPLAY));
        add(title);
        add(Box.createVerticalStrut(20));
        add(new Label("Regular Courses", Fonts.TITLE, Component.LEFT_ALIGNMENT));
        for(Datapoints.Courses course: Datapoints.COURSES){
            if(course.regular.equals(true)){
                add(new Label(course.code, Fonts.Body, Component.LEFT_ALIGNMENT));
                add(new Label(course.name, Fonts.Body, Component.LEFT_ALIGNMENT));
                for(Datapoints.Courses.Assignment assignment: course.assignments){
                    line line = new line(assignment);
                    line.setAlignmentX(Component.LEFT_ALIGNMENT);
                    add(line);
                }
            }
        }
        add(new Label("Drop Courses", Fonts.TITLE, Component.LEFT_ALIGNMENT));
        for(Datapoints.Courses course: Datapoints.COURSES){
            if(course.regular.equals(false)){
                add(new Label(course.code, Fonts.Body, Component.LEFT_ALIGNMENT));
                add(new Label(course.name, Fonts.Body, Component.LEFT_ALIGNMENT));
                for(Datapoints.Courses.Assignment assignment: course.assignments){
                    line line = new line(assignment);
                    line.setAlignmentX(Component.LEFT_ALIGNMENT);
                    add(line);
                }
            }
        }
    }
}
