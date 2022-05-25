package pages.pageView.updates;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;

import java.awt.event.MouseEvent;

import Components.Label;
import Components.ListItem;
import Constants.Fonts;
import Server.Datapoints;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.CardLayout;

public class exam extends JPanel {
    public exam(){
        JPanel assignmentPanel = new JPanel(new CardLayout());
        assignmentPanel.setOpaque(false);
        assignmentPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Box title = Box.createHorizontalBox();
        title.setAlignmentX(Component.LEFT_ALIGNMENT);
        Label name = new Label("Exam", Fonts.DISPLAY);
        name.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                CardLayout cl = (CardLayout)(assignmentPanel.getLayout());
                cl.show(assignmentPanel, "assignment");
                name.setText("Exam");
            }
        });
        title.add(name);
        add(title);
        add(Box.createVerticalStrut(20));


        JPanel list = new JPanel();
        list.setOpaque(false);
        list.setAlignmentX(Component.LEFT_ALIGNMENT);
        list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS));
        list.add(new Label("Regular Courses", Fonts.TITLE, Component.LEFT_ALIGNMENT));
        for(Datapoints.Courses course: Datapoints.getInstance().COURSES){
            if(course.regular.equals(true)){
                for(Datapoints.Courses.Exam exam: course.exams){
                    Box line = Box.createHorizontalBox();
                    line.setMaximumSize(new Dimension(1000, 60));
                    line.setAlignmentX(Component.LEFT_ALIGNMENT);
                    line.add(new ListItem(
                        exam.title, 
                        course.name, 
                        exam.date, 
                        String.format("%03d", exam.totalMarks) + "   " + String.format("%03d", exam.marksObtained)));
                        line.addMouseListener(new MouseAdapter(){
                            @Override
                            public void mouseClicked(MouseEvent e){
                                name.setText("Exam > " + exam.title);
                                JPanel individualAssignment = new JPanel();
                                individualAssignment.setLayout(new BoxLayout(individualAssignment, BoxLayout.Y_AXIS));
                                individualAssignment.setOpaque(false);
                                individualAssignment.setAlignmentX(Component.LEFT_ALIGNMENT);
                                individualAssignment.add(new Label(exam.title, Fonts.TITLE, Component.LEFT_ALIGNMENT));
                                individualAssignment.add(new Label("Due Date: " + exam.date, Fonts.Body, Component.LEFT_ALIGNMENT));
                                individualAssignment.add(new Label("Total Marks: " + String.valueOf(exam.totalMarks), Fonts.Body, Component.LEFT_ALIGNMENT));
                                individualAssignment.add(new JSeparator());
                                individualAssignment.add(new Label(exam.description, Fonts.BODY_LARGE, Component.LEFT_ALIGNMENT));
                                individualAssignment.add(Box.createVerticalGlue());
                                assignmentPanel.add(individualAssignment, exam.title);
                                CardLayout cl = (CardLayout)(assignmentPanel.getLayout());
                                cl.show(assignmentPanel, exam.title);
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
                for(Datapoints.Courses.Exam exam: course.exams){
                    Box line = Box.createHorizontalBox();
                    line.setMaximumSize(new Dimension(1000, 60));
                    line.setAlignmentX(Component.LEFT_ALIGNMENT);
                    line.add(new ListItem(
                        exam.title, 
                        course.name, 
                        exam.date, 
                        String.format("%03d", exam.totalMarks) + "   " + String.format("%03d", exam.marksObtained)));
                        line.addMouseListener(new MouseAdapter(){
                            @Override
                            public void mouseClicked(MouseEvent e){
                                name.setText("Exam > " + exam.title);
                                JPanel individualAssignment = new JPanel();
                                individualAssignment.setLayout(new BoxLayout(individualAssignment, BoxLayout.Y_AXIS));
                                individualAssignment.setOpaque(false);
                                individualAssignment.setAlignmentX(Component.LEFT_ALIGNMENT);
                                individualAssignment.add(new Label(exam.title, Fonts.TITLE, Component.LEFT_ALIGNMENT));
                                individualAssignment.add(new Label("Due Date: " + exam.date, Fonts.Body, Component.LEFT_ALIGNMENT));
                                individualAssignment.add(new Label("Total Marks: " + String.valueOf(exam.totalMarks), Fonts.Body, Component.LEFT_ALIGNMENT));
                                individualAssignment.add(new JSeparator());
                                individualAssignment.add(new Label(exam.description, Fonts.BODY_LARGE, Component.LEFT_ALIGNMENT));
                                individualAssignment.add(Box.createVerticalGlue());
                                assignmentPanel.add(individualAssignment, exam.title);
                                CardLayout cl = (CardLayout)(assignmentPanel.getLayout());
                                cl.show(assignmentPanel, exam.title);
                            }
                            
                        });
                    list.add(line);
                    list.add(Box.createVerticalStrut(10));
                }
            }
        }
        JScrollPane scroll = new JScrollPane(list);
        scroll.setAlignmentX(Component.LEFT_ALIGNMENT);
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        scroll.setBorder(null);

        assignmentPanel.add(scroll, "assignment");
        add(assignmentPanel);
    }
}
