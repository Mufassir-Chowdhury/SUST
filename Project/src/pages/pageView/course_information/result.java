package pages.pageView.course_information;

import javax.swing.Box;

import Components.Label;
import Components.pageView.ListPanel;
import Components.pageView.ScrollPane;
import Components.pageView.ViewPort;

import java.awt.Component;

import Constants.Fonts;
import Server.Datapoints;

public class result extends ViewPort {
    public result(){
        super("Results", new ResultSummary());

        ListPanel list = new ListPanel();
        Boolean values[] = {true, false};
        for(Boolean value: values){
            list.add(new Label(value ? "Regular Courses" : "Drop Courses", Fonts.TITLE, Component.LEFT_ALIGNMENT));     
            for(Datapoints.Courses course: Datapoints.getInstance().COURSES){
                if(course.regular.equals(value)){
                    ResultList line = new ResultList(course.getResult());
                    list.add(line);
                    list.add(Box.createVerticalStrut(10));
                }
            }
        }
        add(new ScrollPane(list));
    }
}
