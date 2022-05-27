package pages.pageView.course_information;

import java.awt.Component;

import javax.swing.Box;

import Components.Label;
import Components.pageView.ListPanel;
import Components.pageView.ScrollPane;
import Components.pageView.ViewPort;
import Constants.Fonts;
import Server.Datapoints;

public class attendance extends ViewPort {
    public attendance(){
        super("Attendance", null);

        ListPanel list = new ListPanel();
        Boolean values[] = {true, false};
        for(Boolean value: values){
            list.add(new Label(value ? "Regular Courses" : "Drop Courses", Fonts.TITLE, Component.LEFT_ALIGNMENT));     
            for(Datapoints.Courses course: Datapoints.getInstance().COURSES){
                if(course.regular.equals(value)){
                    AttendanceList line = new AttendanceList(course.getAttendance());
                    list.add(line);
                    list.add(Box.createVerticalStrut(10));        
                }
            }
        }
        add(new ScrollPane(list));
    }
}
