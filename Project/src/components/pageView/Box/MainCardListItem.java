package Components.pageView.Box;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Common.pages.pageView.course_information.expanded;
import Components.pageView.Panels.ListPanel;
import Components.pageView.Panels.Post;
import Server.Datapoints.Courses;
import Server.Datapoints.Tilable;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.CardLayout;

public class MainCardListItem extends Box {
    public enum Type {
        ASSIGNMENT, EXAM, ATTENDANCE, RESULT
    }

    public MainCardListItem(String pageName, Tilable event, Title title, JPanel panel) {
        super(BoxLayout.X_AXIS);
        setAlignmentX(Component.LEFT_ALIGNMENT);
        Box line = event.getListItem();
        line.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                title.setText(pageName + " > " + event.getTitle());
                Post individualExam = event.getPost();
                panel.add(individualExam, event.getTitle());
                CardLayout cl = (CardLayout) (panel.getLayout());
                cl.show(panel, event.getTitle());
            }
        });
        add(line);
    }

    public MainCardListItem(String pageName, Courses course, Title title, Type type, ListPanel listItem) {
        super(BoxLayout.X_AXIS);
        setAlignmentX(Component.LEFT_ALIGNMENT);
        ListPanel line = listItem;
        line.addMouseListener(new MouseAdapter() {
            expanded marks = new expanded(type);
            Boolean open = false;

            @Override
            public void mouseClicked(MouseEvent e) {
                if (open == false) {
                    line.add(marks);
                    open = true;
                } else {
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
