package pages.pageView.course_information;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Components.Card;
import Components.Label;
import Components.ListItem;
import Constants.Fonts;
import Server.Datapoints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class attendance extends JPanel {
    public attendance(){
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Box title = Box.createHorizontalBox();
        title.setAlignmentX(Component.LEFT_ALIGNMENT);
        title.add(new Label("Attendance", Fonts.DISPLAY));
        add(title);
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

                line.setOpaque(false);
                Box horizontalLine = Box.createHorizontalBox();
                horizontalLine.setMaximumSize(new Dimension(1000, 60));
                horizontalLine.setAlignmentX(Component.LEFT_ALIGNMENT);
                horizontalLine.add(new ListItem(
                    course.name, 
                    course.code, 
                    String.valueOf(course.attendance), 
                    String.format("%03d", course.absent) + "   " + String.format("%03d", course.leave)));
                line.add(horizontalLine);
                list.add(line);
                line.addMouseListener(new MouseAdapter(){
                    Label attendance = new Label("Attendance", Fonts.Body);
                    Boolean open = false;
                    @Override
                    public void mouseClicked(MouseEvent e){
                        if(open == false){
                            line.add(attendance);
                            open = true;
                        } else{
                            line.remove(attendance);
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
                    String.valueOf(course.attendance), 
                        String.format("%03d", course.absent) + "   " + String.format("%03d", course.leave)));
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
