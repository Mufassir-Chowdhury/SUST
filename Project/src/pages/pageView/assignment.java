package pages.pageView;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Constants.Datapoints;

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
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel regular = new JLabel("Regular Courses");
        add(regular);
        for(Datapoints.Courses course: Datapoints.COURSES){
            if(course.regular.equals(true)){
                JLabel registration = new JLabel(course.code);
                add(registration);
                JLabel name = new JLabel(course.name);
                add(name);
                for(Datapoints.Courses.Assignment assignment: course.assignments){
                    line line = new line(assignment);
                    add(line);
                }
            }
        }
        JLabel drop = new JLabel("Drop Courses");
        add(drop);
        for(Datapoints.Courses course: Datapoints.COURSES){
            if(course.regular.equals(false)){
                JLabel registration = new JLabel(course.code);
                add(registration);
                JLabel name = new JLabel(course.name);
                add(name);
                for(Datapoints.Courses.Assignment assignment: course.assignments){
                    line line = new line(assignment);
                    add(line);
                }
            }
        }
    }
}
