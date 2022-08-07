package Components.pageView.Panels;

import javax.swing.Box;
import javax.swing.JPanel;

import Components.Label;
import Constants.Fonts;
import Server.Datapoints;
import Server.Datapoints.Tilable;
import java.awt.Component;
import java.util.Vector;

import Components.pageView.Box.MainCardListItem;
import Components.pageView.Box.Title;
import Components.pageView.Box.MainCardListItem.Type;

public class MainCardList extends ListPanel {
    public MainCardList(String pageName, Title title, JPanel panel, Tilable[] tiles) {
        for(Datapoints.Tilable eventItem: tiles){
            add(new MainCardListItem(pageName, eventItem, title, panel));
            add(Box.createVerticalStrut(10));
        }
    }
    public MainCardList(String pageName, Title title, JPanel panel, Type type) {
        Boolean values[] = {true, false};
        for(Boolean value: values){
            add(new Label(value ? "Regular Courses" : "Drop Courses", Fonts.TITLE, Component.LEFT_ALIGNMENT));     
            for(Datapoints.Courses course: Datapoints.getInstance().COURSES){
                if(course.regular.equals(value)){
                    Vector<Datapoints.Tilable> evaluationItem;
                    if(type == Type.EXAM){
                        evaluationItem = new Vector<>(course.exams);
                    } else{
                        evaluationItem = new Vector<>(course.assignments);
                    }
                    for(Datapoints.Tilable exam: evaluationItem){
                        add(new MainCardListItem(pageName, exam, title, panel));
                        add(Box.createVerticalStrut(10));
                    }
                }
            }
        }
    }
    public MainCardList(String pageName, Title title, Type type) {
        Boolean values[] = {true, false};
        for(Boolean value: values){
            add(new Label(value ? "Regular Courses" : "Drop Courses", Fonts.TITLE, Component.LEFT_ALIGNMENT));     
            for(Datapoints.Courses course: Datapoints.getInstance().COURSES){
                if(course.regular.equals(value)){
                    ListPanel line;
                    if(type == Type.ATTENDANCE){
                        line = new ListPanel(course.getAttendance(), null, 0);
                    }
                    else{
                        line = new ListPanel(course.getResult(), null, 0);
                    }
                    add(new MainCardListItem(pageName, course, title, type, line));
                    add(Box.createVerticalStrut(10));
                }
            }
        }
    }
}
