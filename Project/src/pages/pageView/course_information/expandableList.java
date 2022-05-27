package pages.pageView.course_information;

import javax.swing.JComponent;


import javax.swing.Box;

import Components.Label;
import Components.pageView.ListPanel;
import Components.pageView.ScrollPane;
import Components.pageView.ViewPort;

import java.awt.Component;

import Constants.Fonts;
import Server.Datapoints;

public class expandableList extends ViewPort {
    public enum Type{
        ATTENDANCE,
        RESULT
    }
    public expandableList(String title, JComponent component, Type type){
        super(title, component);
        ListPanel list = new ListPanel();
        Boolean values[] = {true, false};
        for(Boolean value: values){
            list.add(new Label(value ? "Regular Courses" : "Drop Courses", Fonts.TITLE, Component.LEFT_ALIGNMENT));     
            for(Datapoints.Courses course: Datapoints.getInstance().COURSES){
                if(course.regular.equals(value)){
                    if(type == Type.ATTENDANCE){
                        AttendanceList line = new AttendanceList(course.getAttendance());
                        list.add(line);
                    }
                    else{
                        ResultList line = new ResultList(course.getResult());
                        list.add(line);
                    }
                    list.add(Box.createVerticalStrut(10));
                }
            }
        }
        add(new ScrollPane(list));
    }
}
