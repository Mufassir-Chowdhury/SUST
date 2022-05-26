package Components.pageView;

import javax.swing.Box;
import javax.swing.JPanel;

import Components.Label;
import Components.pageView.EvaluationItem.Type;
import Constants.Fonts;
import Server.Datapoints;
import java.awt.Component;

public class EvaluationItemList extends ListPanel {
    public EvaluationItemList(Title title, JPanel panel, Type type) {
        Boolean values[] = {true, false};
        for(Boolean value: values){
            add(new Label(value ? "Regular Courses" : "Drop Courses", Fonts.TITLE, Component.LEFT_ALIGNMENT));     
            for(Datapoints.Courses course: Datapoints.getInstance().COURSES){
                if(course.regular.equals(value)){
                    if(type == Type.EXAM){
                        for(Datapoints.Courses.Exam exam: course.exams){
                            add(new EvaluationItem(course, exam, title, panel, Type.EXAM));
                            add(Box.createVerticalStrut(10));
                        }
                    } else {
                        for(Datapoints.Courses.Assignment assignment: course.assignments){
                            add(new EvaluationItem(course, assignment, title, panel, Type.ASSIGNMENT));
                            add(Box.createVerticalStrut(10));
                        }
                    }
                }
            }
        }
    }
}
