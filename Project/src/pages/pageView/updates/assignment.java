package pages.pageView.updates;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import java.awt.event.MouseEvent;

import Components.Label;
import Components.ListItem;
import Components.pageView.ScrollPane;
import Components.pageView.Title;
import Constants.Fonts;
import Server.Datapoints;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.CardLayout;

public class assignment extends JPanel {
    public assignment(){
        JPanel assignmentPanel = new JPanel(new CardLayout());
        assignmentPanel.setOpaque(false);
        assignmentPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Title title = new Title("Assignments", null);
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
        list.add(new Label("Regular Courses", Fonts.TITLE, Component.LEFT_ALIGNMENT));
        for(Datapoints.Courses course: Datapoints.getInstance().COURSES){
            if(course.regular.equals(true)){
                for(Datapoints.Courses.Assignment assignment: course.assignments){
                    Box line = Box.createHorizontalBox();
                    line.setMaximumSize(new Dimension(1000, 60));
                    line.setAlignmentX(Component.LEFT_ALIGNMENT);                    
                    line.add(new ListItem(
                        assignment.title, 
                        course.name, 
                        assignment.date, 
                        String.format("%03d", assignment.totalMarks) + "   " + String.format("%03d", assignment.marksObtained)));
                    line.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mouseClicked(MouseEvent e){
                            title.setText("Assignment > " + assignment.title);
                            JPanel individualAssignment = new JPanel();
                            individualAssignment.setLayout(new BoxLayout(individualAssignment, BoxLayout.Y_AXIS));
                            individualAssignment.setOpaque(false);
                            individualAssignment.setAlignmentX(Component.LEFT_ALIGNMENT);
                            individualAssignment.add(new Label(assignment.title, Fonts.TITLE, Component.LEFT_ALIGNMENT));
                            individualAssignment.add(new Label("Due Date: " + assignment.date, Fonts.Body, Component.LEFT_ALIGNMENT));
                            individualAssignment.add(new Label("Total Marks: " + String.valueOf(assignment.totalMarks), Fonts.Body, Component.LEFT_ALIGNMENT));
                            individualAssignment.add(new JSeparator());
                            individualAssignment.add(new Label(assignment.description, Fonts.BODY_LARGE, Component.LEFT_ALIGNMENT));
                            individualAssignment.add(Box.createVerticalGlue());
                            assignmentPanel.add(individualAssignment, assignment.title);
                            CardLayout cl = (CardLayout)(assignmentPanel.getLayout());
                            cl.show(assignmentPanel, assignment.title);
                        }
                        
                    });
                    list.add(line);
                    list.add(Box.createVerticalStrut(10));
                }
            }
        }
        list.add(new Label("Drop Courses", Fonts.TITLE, Component.LEFT_ALIGNMENT));
        for(Datapoints.Courses course: Datapoints.getInstance().COURSES){
            if(course.regular.equals(false)){
                for(Datapoints.Courses.Assignment assignment: course.assignments){
                    Box line = Box.createHorizontalBox();
                    line.setMaximumSize(new Dimension(1000, 60));
                    line.setAlignmentX(Component.LEFT_ALIGNMENT);
                    ListItem item = new ListItem(
                        assignment.title, 
                        course.name, 
                        assignment.date, 
                        String.format("%03d", assignment.totalMarks) + "   " + String.format("%03d", assignment.marksObtained)
                    );
                    
                    item.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mouseClicked(MouseEvent e){
                            title.setText("Assignment > " + assignment.title);
                            JPanel individualAssignment = new JPanel();
                            individualAssignment.setLayout(new BoxLayout(individualAssignment, BoxLayout.Y_AXIS));
                            individualAssignment.setOpaque(false);
                            individualAssignment.setAlignmentX(Component.LEFT_ALIGNMENT);
                            individualAssignment.add(new Label(assignment.title, Fonts.TITLE, Component.LEFT_ALIGNMENT));
                            individualAssignment.add(new Label("Due Date: " + assignment.date, Fonts.Body, Component.LEFT_ALIGNMENT));
                            individualAssignment.add(new Label("Total Marks: " + String.valueOf(assignment.totalMarks), Fonts.Body, Component.LEFT_ALIGNMENT));
                            individualAssignment.add(new JSeparator());
                            individualAssignment.add(new Label(assignment.description, Fonts.BODY_LARGE, Component.LEFT_ALIGNMENT));
                            individualAssignment.add(Box.createVerticalGlue());
                            assignmentPanel.add(individualAssignment, assignment.title);
                            CardLayout cl = (CardLayout)(assignmentPanel.getLayout());
                            cl.show(assignmentPanel, assignment.title);
                        }
                        
                    });
                    line.add(item);
                    list.add(line);
                    list.add(Box.createVerticalStrut(10));
                }
            }
        }
        ScrollPane scroll = new ScrollPane(list);
        add(scroll);
        
        assignmentPanel.add(scroll, "assignment");
        add(assignmentPanel);
    }
}
