package pages.pageView;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Component;
import java.awt.Dimension;

import Components.Label;
import Components.ListItem;
import Constants.Fonts;
import Server.Datapoints;

public class exam extends JPanel {
    public exam(){
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Box title = Box.createHorizontalBox();
        title.setAlignmentX(Component.LEFT_ALIGNMENT);
        title.add(new Label("Exams", Fonts.DISPLAY));
        add(title);
        add(Box.createVerticalStrut(20));
        JPanel list = new JPanel();
        list.setOpaque(false);
        list.setAlignmentX(Component.LEFT_ALIGNMENT);
        list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS));
        list.add(new Label("Regular Courses", Fonts.TITLE, Component.LEFT_ALIGNMENT));
        for(Datapoints.Courses course: Datapoints.getInstance().COURSES){
            if(course.regular.equals(true)){
                for(Datapoints.Courses.Exam exam: course.exams){
                    Box line = Box.createHorizontalBox();
                    line.setMaximumSize(new Dimension(1000, 60));
                    line.setAlignmentX(Component.LEFT_ALIGNMENT);
                    line.add(new ListItem(
                        exam.title, 
                        course.name, 
                        exam.date, 
                        String.format("%03d", exam.totalMarks) + "   " + String.format("%03d", exam.marksObtained)));
                    list.add(line);
                    list.add(Box.createVerticalStrut(10));
                }
            }
        }
        list.add(new Label("Drop Courses", Fonts.TITLE, Component.LEFT_ALIGNMENT));
        for(Datapoints.Courses course: Datapoints.getInstance().COURSES){
            if(course.regular.equals(false)){
                for(Datapoints.Courses.Exam exam: course.exams){
                    Box line = Box.createHorizontalBox();
                    line.setMaximumSize(new Dimension(1000, 60));
                    line.setAlignmentX(Component.LEFT_ALIGNMENT);
                    line.add(new ListItem(
                        exam.title, 
                        course.name, 
                        exam.date, 
                        String.format("%03d", exam.totalMarks) + "   " + String.format("%03d", exam.marksObtained)));
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
