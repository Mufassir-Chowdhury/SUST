package pages.pageView.course_information;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Components.Label;
import Components.ListItem;
import Components.pageView.Line;
import Components.pageView.ScrollPane;
import Components.pageView.ViewPort;

import java.awt.Component;

import Constants.Fonts;
import Server.Datapoints;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class result extends ViewPort {
    public result(){
        super("Results", new ResultSummary());

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
                line.add(new Line(new ListItem(
                    course.name, 
                    course.code, 
                    String.valueOf(course.attendance), 
                    String.format("%03d", course.absent) + "   " + String.format("%03d", course.leave))));
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
                list.add(new Line(new ListItem(course.name, course.code, course.grade, String.format("%.2f", course.gpa))));
                list.add(Box.createVerticalStrut(10));
            }
        }
        add(new ScrollPane(list));
    }
}
