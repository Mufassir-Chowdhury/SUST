package pages.pageView.updates;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import java.awt.event.MouseEvent;

import Components.Label;
import Components.ListItem;
import Components.pageView.Line;
import Components.pageView.Post;
import Components.pageView.ScrollPane;
import Components.pageView.Title;
import Constants.Fonts;
import Server.Datapoints;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.CardLayout;

public class assignment extends JPanel {
    JPanel assignmentPanel = new JPanel(new CardLayout());
    Title title = new Title("Exam", null);

    public class line extends Box{
        public line(Datapoints.Courses course, Datapoints.Courses.Assignment assignment){
            super(BoxLayout.X_AXIS);
            setAlignmentX(Component.LEFT_ALIGNMENT);
            Box line = new Line(new ListItem(
                assignment.title, 
                course.name, 
                assignment.date, 
                String.format("%03d", assignment.totalMarks) + "   " + String.format("%03d", assignment.marksObtained)));
            line.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e){
                    title.setText("Assignment > " + assignment.title);
                    JPanel individualExam = new Post(
                        assignment.title,
                        "Due Date: " + assignment.date, 
                        "Total Marks: " + assignment.totalMarks, 
                        assignment.description);
                    assignmentPanel.add(individualExam, assignment.title);
                    CardLayout cl = (CardLayout)(assignmentPanel.getLayout());
                    cl.show(assignmentPanel, assignment.title);
                }
                
            });
            add(line);
        }
    }
    public assignment(){
        assignmentPanel.setOpaque(false);
        assignmentPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(title);
        title.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                CardLayout cl = (CardLayout)(assignmentPanel.getLayout());
                cl.show(assignmentPanel, "assignment");
                title.setText("Assignment");
            }
        });
        add(title);
        add(Box.createVerticalStrut(20));

        
        JPanel list = new JPanel();
        list.setOpaque(false);
        list.setAlignmentX(Component.LEFT_ALIGNMENT);
        list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS));
        Boolean values[] = {true, false};
        for(Boolean value: values){
            list.add(new Label(value ? "Regular Courses" : "Drop Courses", Fonts.TITLE, Component.LEFT_ALIGNMENT));     
            for(Datapoints.Courses course: Datapoints.getInstance().COURSES){
                if(course.regular.equals(value)){
                    for(Datapoints.Courses.Assignment assignment: course.assignments){
                        Box line = new line(course, assignment);
                        list.add(line);
                        list.add(Box.createVerticalStrut(10));
                    }
                }
            }
        }
        ScrollPane scroll = new ScrollPane(list);
        add(scroll);
        
        assignmentPanel.add(scroll, "assignment");
        add(assignmentPanel);
    }
}
