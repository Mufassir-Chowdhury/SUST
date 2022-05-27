package pages.pageView.course_information;

import javax.swing.JComponent;


import javax.swing.Box;

import Components.Label;
import Components.pageView.ListPanel;
import Components.pageView.ScrollPane;
import Components.pageView.ViewPort;

import java.awt.Component;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Constants.Fonts;
import Server.Datapoints;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Components.pageView.Line;

public class expandableList extends ViewPort {
    public enum Type{
        ATTENDANCE,
        RESULT
    }
    public class ExpandableItem extends JPanel {
        public ExpandableItem(Line listItem){
            setAlignmentX(Component.LEFT_ALIGNMENT);
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            setOpaque(false);
            add(listItem);
        }
    }
    public expandableList(String title, JComponent component, Type type){
        super(title, component);
        ListPanel list = new ListPanel();
        Boolean values[] = {true, false};
        for(Boolean value: values){
            list.add(new Label(value ? "Regular Courses" : "Drop Courses", Fonts.TITLE, Component.LEFT_ALIGNMENT));     
            for(Datapoints.Courses course: Datapoints.getInstance().COURSES){
                if(course.regular.equals(value)){
                    ExpandableItem line;
                    if(type == Type.ATTENDANCE){
                        line = new ExpandableItem(course.getAttendance());
                    }
                    else{
                        line = new ExpandableItem(course.getResult());
                    }
                    line.addMouseListener(new MouseAdapter(){
                        expanded marks = null;
                        Boolean open = false;
                        @Override
                        public void mouseClicked(MouseEvent e){
                            if(marks == null){
                                marks = new expanded(type);
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
                    list.add(line);
                    list.add(Box.createVerticalStrut(10));
                }
            }
        }
        add(new ScrollPane(list));
    }
}
