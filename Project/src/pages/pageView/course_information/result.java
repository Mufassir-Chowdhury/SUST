package pages.pageView.course_information;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import java.awt.Insets;
import javax.swing.border.EmptyBorder;

import Components.Label;
import Components.ListItem;
import Components.pageView.ScrollPane;
import Components.pageView.Title;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import Constants.Fonts;
import Server.Datapoints;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class result extends JPanel {
    public result(){
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        Box resultSummary = Box.createHorizontalBox();
        resultSummary.setAlignmentY(Component.TOP_ALIGNMENT);
        Label grade = new Label("A+", Fonts.BIG_DISPLAY, Color.GREEN);
        grade.setBorder(new EmptyBorder(new Insets(0, 0, 0, 5)));
        resultSummary.add(grade);
        Box resultSummarySmall = Box.createVerticalBox();
        resultSummarySmall.add(new Label("4.00", Fonts.Body));
        resultSummarySmall.add(new Label("1st", Fonts.Body));
        resultSummary.add(resultSummarySmall);
        add(new Title("Results", resultSummary));
        add(Box.createVerticalStrut(20));

        JPanel list = new JPanel();
        list.setOpaque(false);
        list.setAlignmentX(Component.LEFT_ALIGNMENT);
        list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS));
        list.add(new Label("Regular Courses", Fonts.TITLE, Component.LEFT_ALIGNMENT));
        for(Datapoints.Courses course: Datapoints.getInstance().COURSES){
            if(course.regular.equals(true)){
                JPanel line = new JPanel();
                line.setLayout(new BoxLayout(line, BoxLayout.Y_AXIS));
                line.setAlignmentX(Component.LEFT_ALIGNMENT);
                line.setOpaque(false);
                Box horizontalLine = Box.createHorizontalBox();
                horizontalLine.setMaximumSize(new Dimension(1000, 60));
                horizontalLine.setAlignmentX(Component.LEFT_ALIGNMENT);
                horizontalLine.add(new ListItem(
                    course.name, 
                    course.code, 
                    course.grade, 
                    String.format("%.2f",course.gpa)));
                line.add(horizontalLine);
                list.add(line);
                line.addMouseListener(new MouseAdapter(){
                    // Label attendance = new Label("Attendance", Fonts.Body);
                    Box marks = Box.createHorizontalBox();
                    Boolean open = false;
                    Boolean created = false;
                    @Override
                    public void mouseClicked(MouseEvent e){
                        if(created == false){
                            marks.setAlignmentX(Component.LEFT_ALIGNMENT);
                            marks.add(new Label("ATTENDANCE MARKS", Fonts.Body));
                            marks.add(Box.createHorizontalGlue());
                            marks.add(new Label("EXAM MARKS", Fonts.Body));
                            marks.add(Box.createHorizontalGlue());
                            marks.add(new Label("ASSIGNMENT MARKS", Fonts.Body));
                            created = true;
                        }
                        if(open == false){
                            line.add(marks);
                            open = true;
                        } else{
                            line.remove(marks);
                            open = false;
                        }
                        repaint();
                        revalidate();
                    }
                    
                });
                list.add(Box.createVerticalStrut(10));
            }
        }
        list.add(new Label("Drop Courses", Fonts.TITLE, Component.LEFT_ALIGNMENT));
        for(Datapoints.Courses course: Datapoints.getInstance().COURSES){
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
        add(new ScrollPane(list));
    }
}
