package pages.pageView;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Insets;
import javax.swing.border.EmptyBorder;

import Components.Label;
import Components.ListItem;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import Constants.Fonts;
import Server.Datapoints;

public class result extends JPanel {
    public result(){
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Box title = Box.createHorizontalBox();
        title.setAlignmentX(Component.LEFT_ALIGNMENT);
        Label titleLabel = new  Label("Results", Fonts.DISPLAY);
        titleLabel.setAlignmentY(Component.TOP_ALIGNMENT);
        title.add(titleLabel);
        title.add(Box.createHorizontalGlue());

        Box resultSummary = Box.createHorizontalBox();
        resultSummary.setAlignmentY(Component.TOP_ALIGNMENT);
        Label grade = new Label("A+", Fonts.BIG_DISPLAY, Color.GREEN);
        grade.setBorder(new EmptyBorder(new Insets(0, 0, 0, 5)));
        resultSummary.add(grade);
        Box resultSummarySmall = Box.createVerticalBox();
        resultSummarySmall.add(new Label("4.00", Fonts.Body));
        resultSummarySmall.add(new Label("1st", Fonts.Body));
        resultSummary.add(resultSummarySmall);
        title.add(resultSummary);
        add(title);
        add(Box.createVerticalStrut(20));

        JPanel list = new JPanel();
        list.setOpaque(false);
        list.setAlignmentX(Component.LEFT_ALIGNMENT);
        list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS));
        list.add(new Label("Regular Courses", Fonts.TITLE, Component.LEFT_ALIGNMENT));
        for(Datapoints.Courses course: Datapoints.COURSES){
            if(course.regular.equals(true)){
                Box line = Box.createHorizontalBox();
                line.setMaximumSize(new Dimension(1000, 60));
                line.setAlignmentX(Component.LEFT_ALIGNMENT);
                line.add(new ListItem(
                    course.name, 
                    course.code, 
                    course.grade, 
                    String.format("%.2f",course.gpa)));
                list.add(line);
                list.add(Box.createVerticalStrut(10));
            }
        }
        list.add(new Label("Drop Courses", Fonts.TITLE, Component.LEFT_ALIGNMENT));
        for(Datapoints.Courses course: Datapoints.COURSES){
            if(course.regular.equals(false)){
                Box line = Box.createHorizontalBox();
                line.setMaximumSize(new Dimension(1000, 60));
                line.setAlignmentX(Component.LEFT_ALIGNMENT);
                line.add(new ListItem(
                    course.name, 
                    course.code, 
                    course.grade, 
                    String.format("%.2f",course.gpa)));
                list.add(line);
                list.add(Box.createVerticalStrut(10));
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
