package pages.pageView;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Constants.Datapoints;

public class exam extends JPanel {
    class line extends Box{
        public line(Datapoints.Courses.Exam exam){
            super(BoxLayout.X_AXIS);
            JLabel name = new JLabel(exam.title);
            add(name);
            add(Box.createHorizontalGlue());
            JLabel date = new JLabel(exam.date);
            add(date);
            add(Box.createHorizontalGlue());
            JLabel weight = new JLabel(String.valueOf(exam.totalMarks));
            add(weight);
            add(Box.createHorizontalGlue());
            JLabel marks = new JLabel(String.valueOf(exam.marksObtained));
            add(marks);
            add(Box.createHorizontalGlue());
        }
    }
    public exam(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel regular = new JLabel("Regular Courses");
        add(regular);
        for(Datapoints.Courses course: Datapoints.COURSES){
            if(course.regular.equals(true)){
                JLabel registration = new JLabel(course.code);
                add(registration);
                JLabel name = new JLabel(course.name);
                add(name);
                for(Datapoints.Courses.Exam exam: course.exams){
                    line line = new line(exam);
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
                for(Datapoints.Courses.Exam exam: course.exams){
                    line line = new line(exam);
                    add(line);
                }
            }
        }
    }
}
