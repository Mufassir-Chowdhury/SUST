package Components.pageView;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Server.Datapoints.Courses;
import Server.Datapoints.Tilable;
import pages.pageView.course_information.expanded;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.CardLayout;

public class MainCardListItem extends Box {
    public enum Type{
        ASSIGNMENT, EXAM, ATTENDANCE, RESULT
    }
    public MainCardListItem(String pageName, Tilable event, Title title, JPanel panel){
        super(BoxLayout.X_AXIS);
        setAlignmentX(Component.LEFT_ALIGNMENT);
        Box line = event.getListItem();
        line.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                title.setText(pageName + " > " + event.getTitle());
                Post individualExam = event.getPost();
                panel.add(individualExam, event.getTitle());
                CardLayout cl = (CardLayout)(panel.getLayout());
                cl.show(panel, event.getTitle());
            }
        });
        add(line);
    }
    public MainCardListItem(String pageName, Courses course, Title title, Type type, ListPanel listItem){
        super(BoxLayout.X_AXIS);
        setAlignmentX(Component.LEFT_ALIGNMENT);
        ListPanel line = listItem;
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
        add(line);
    }
}
