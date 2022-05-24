package pages.pageView.updates;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Components.Label;
import Components.ListItem;
import Constants.Fonts;
import Server.Datapoints;
import java.awt.Component;
import java.awt.Dimension;

public class assignment extends JPanel {
    public assignment(){
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Box title = Box.createHorizontalBox();
        title.setAlignmentX(Component.LEFT_ALIGNMENT);
        title.add(new Label("Assignment", Fonts.DISPLAY));
        add(title);
        add(Box.createVerticalStrut(20));
        JPanel list = new JPanel();
        list.setOpaque(false);
        list.setAlignmentX(Component.LEFT_ALIGNMENT);
        list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS));
        list.add(new Label("Regular Courses", Fonts.TITLE, Component.LEFT_ALIGNMENT));
        for(Datapoints.Courses course: Datapoints.getInstance().COURSES){
            if(course.regular.equals(true)){
                for(Datapoints.Courses.Assignment assignment: course.assignments){
                    Box line = Box.createHorizontalBox();
                    line.setMaximumSize(new Dimension(1000, 60));
                    line.setAlignmentX(Component.LEFT_ALIGNMENT);
                    line.add(new ListItem(
                        assignment.title, 
                        course.name, 
                        assignment.date, 
                        String.format("%03d", assignment.totalMarks) + "   " + String.format("%03d", assignment.marksObtained)));
                    list.add(line);
                    list.add(Box.createVerticalStrut(10));
                }
            }
        }
        list.add(new Label("Drop Courses", Fonts.TITLE, Component.LEFT_ALIGNMENT));
        for(Datapoints.Courses course: Datapoints.getInstance().COURSES){
            if(course.regular.equals(false)){
                for(Datapoints.Courses.Assignment assignment: course.assignments){
                    Box line = Box.createHorizontalBox();
                    line.setMaximumSize(new Dimension(1000, 60));
                    line.setAlignmentX(Component.LEFT_ALIGNMENT);
                    line.add(new ListItem(
                        assignment.title, 
                        course.name, 
                        assignment.date, 
                        String.format("%03d", assignment.totalMarks) + "   " + String.format("%03d", assignment.marksObtained)));
                    list.add(line);
                    list.add(Box.createVerticalStrut(10));
                }
            }
        }
        JScrollPane scroll = new JScrollPane(list);
        scroll.setAlignmentX(Component.LEFT_ALIGNMENT);
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        scroll.setBorder(null);
        add(scroll);
    }
}
