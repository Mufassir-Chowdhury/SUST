package pages.pageView;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Server.Datapoints;

public class attendance extends JPanel {
    class line extends Box{
        public line(Datapoints.Courses course){
            super(BoxLayout.X_AXIS);
            JLabel registration = new JLabel(course.code);
            add(registration);
            add(Box.createHorizontalGlue());
            JLabel name = new JLabel(course.name);
            add(name);
            add(Box.createHorizontalGlue());
            JLabel attendance = new JLabel(String.valueOf(course.attendance));
            add(attendance);
            add(Box.createHorizontalGlue());
            JLabel absent = new JLabel(String.valueOf(course.absent));
            add(absent);
            add(Box.createHorizontalGlue());
            JLabel leave = new JLabel(String.valueOf(course.leave));
            add(leave);
            add(Box.createHorizontalGlue());
        }
    }
    public attendance(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel regular = new JLabel("Regular Courses");
        add(regular);
        for(Datapoints.Courses course: Datapoints.COURSES){
            if(course.regular.equals(true)){
                line line = new line(course);
                add(line);
            }
        }
        JLabel drop = new JLabel("Drop Courses");
        add(drop);
        for(Datapoints.Courses course: Datapoints.COURSES){
            if(course.regular.equals(false)){
                line line = new line(course);
                add(line);
            }
        }
    }
}
