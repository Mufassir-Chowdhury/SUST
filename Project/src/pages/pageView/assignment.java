package pages.pageView;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Constants.Colors;
import Constants.Fonts;
import Server.Datapoints;
import java.awt.Component;

public class assignment extends JPanel {
    class line extends Box{
        public line(Datapoints.Courses.Assignment assignment){
            super(BoxLayout.X_AXIS);
            JLabel name = new JLabel(assignment.title);
            add(name);
            add(Box.createHorizontalGlue());
            JLabel date = new JLabel(assignment.date);
            add(date);
            add(Box.createHorizontalGlue());
            JLabel weight = new JLabel(String.valueOf(assignment.totalMarks));
            add(weight);
            add(Box.createHorizontalGlue());
            JLabel marks = new JLabel(String.valueOf(assignment.marksObtained));
            add(marks);
            add(Box.createHorizontalGlue());
        }
    }
    public assignment(){
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Box title = Box.createHorizontalBox();
        title.setAlignmentX(Component.LEFT_ALIGNMENT);
        JLabel titleLabel = new JLabel("Students");
        titleLabel.setFont(Fonts.DISPLAY);
        titleLabel.setForeground(Colors.PLAIN_TEXT);
        title.add(titleLabel);
        add(title);
        add(Box.createVerticalStrut(20));
        JLabel regular = new JLabel("Regular Courses");
        regular.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(regular);
        for(Datapoints.Courses course: Datapoints.COURSES){
            if(course.regular.equals(true)){
                JLabel registration = new JLabel(course.code);
                registration.setAlignmentX(Component.LEFT_ALIGNMENT);
                add(registration);
                JLabel name = new JLabel(course.name);
                name.setAlignmentX(Component.LEFT_ALIGNMENT);
                add(name);
                for(Datapoints.Courses.Assignment assignment: course.assignments){
                    line line = new line(assignment);
                    line.setAlignmentX(Component.LEFT_ALIGNMENT);
                    add(line);
                }
            }
        }
        JLabel drop = new JLabel("Drop Courses");
        drop.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(drop);
        for(Datapoints.Courses course: Datapoints.COURSES){
            if(course.regular.equals(false)){
                JLabel registration = new JLabel(course.code);
                registration.setAlignmentX(Component.LEFT_ALIGNMENT);
                add(registration);
                JLabel name = new JLabel(course.name);
                name.setAlignmentX(Component.LEFT_ALIGNMENT);
                add(name);
                for(Datapoints.Courses.Assignment assignment: course.assignments){
                    line line = new line(assignment);
                    line.setAlignmentX(Component.LEFT_ALIGNMENT);
                    add(line);
                }
            }
        }
    }
}
