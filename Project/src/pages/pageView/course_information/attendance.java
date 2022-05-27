package pages.pageView.course_information;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Components.Label;
import Components.pageView.ListPanel;
import Components.pageView.ScrollPane;
import Components.pageView.ViewPort;
import Constants.Fonts;
import Server.Datapoints;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class attendance extends ViewPort {
    public attendance(){
        super("Attendance", null);

        ListPanel list = new ListPanel();
        Boolean values[] = {true, false};
        for(Boolean value: values){
            list.add(new Label(value ? "Regular Courses" : "Drop Courses", Fonts.TITLE, Component.LEFT_ALIGNMENT));     
            for(Datapoints.Courses course: Datapoints.getInstance().COURSES){
                if(course.regular.equals(value)){
                    JPanel line = new JPanel();
                    line.setLayout(new BoxLayout(line, BoxLayout.Y_AXIS));
                    line.setOpaque(false);
                    line.add(course.getAttendance());
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
                    list.add(line);
                }
            }
        }
        add(new ScrollPane(list));
    }
}
