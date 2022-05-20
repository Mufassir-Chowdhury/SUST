package pages.pageView;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.Component;
import Components.Label;
import Constants.Fonts;
import Server.Datapoints;

public class exam extends JPanel {
    class line extends Box{
        public line(Datapoints.Courses.Exam exam){
            super(BoxLayout.X_AXIS);
            add(new Label(exam.title, Fonts.BODY_LARGE));
            add(Box.createHorizontalGlue());
            add(new Label(exam.date, Fonts.BODY_LARGE));
            add(Box.createHorizontalGlue());
            add(new Label(String.valueOf(exam.totalMarks), Fonts.Body));
            add(Box.createHorizontalGlue());
            add(new Label(String.valueOf(exam.marksObtained), Fonts.Body));
            add(Box.createHorizontalGlue());
        }
    }
    public exam(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new Label("Regular Courses", Fonts.TITLE, Component.LEFT_ALIGNMENT));
        for(Datapoints.Courses course: Datapoints.COURSES){
            if(course.regular.equals(true)){
                add(new Label(course.code, Fonts.Body));
                add(new Label(course.name, Fonts.Body));
                for(Datapoints.Courses.Exam exam: course.exams){
                    line line = new line(exam);
                    add(line);
                }
            }
        }
        add(new Label("Drop Courses", Fonts.TITLE, Component.LEFT_ALIGNMENT));
        for(Datapoints.Courses course: Datapoints.COURSES){
            if(course.regular.equals(false)){
                add(new Label(course.code, Fonts.Body));
                add(new Label(course.name, Fonts.Body));
                for(Datapoints.Courses.Exam exam: course.exams){
                    line line = new line(exam);
                    add(line);
                }
            }
        }
    }
}
