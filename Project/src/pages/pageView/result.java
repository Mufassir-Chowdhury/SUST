package pages.pageView;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Constants.Datapoints;

public class result extends JPanel {
    public result(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel grade = new JLabel("A+");
        add(grade);
        JLabel cgpa = new JLabel("4.0");
        add(cgpa);
        JLabel position = new JLabel("1st");
        add(position);
        for(Datapoints.Courses course: Datapoints.COURSES){
            Box line = Box.createHorizontalBox();
            line.add(new JLabel(course.code));
            line.add(Box.createHorizontalGlue());
            line.add(new JLabel(course.name));
            line.add(Box.createHorizontalGlue());
            line.add(new JLabel(String.valueOf(course.grade)));
            line.add(Box.createHorizontalGlue());
            line.add(new JLabel(String.valueOf(course.gpa)));
            add(line);
        }
    }
}
