package pages.pageView.updates;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import java.awt.event.MouseEvent;

import Components.Label;
import Components.ListItem;
import Components.pageView.Line;
import Components.pageView.ScrollPane;
import Components.pageView.Title;
import Components.pageView.Post;
import Constants.Fonts;
import Server.Datapoints;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.CardLayout;

public class exam extends JPanel {
    public class line extends Box{
        public line(){
            super(BoxLayout.X_AXIS);
            Box line = new Line(new ListItem(
                        exam.title, 
                        course.name, 
                        exam.date, 
                        String.format("%03d", exam.totalMarks) + "   " + String.format("%03d", exam.marksObtained)));
                    line.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mouseClicked(MouseEvent e){
                            title.setText("Exam > " + exam.title);
                            JPanel individualExam = new Post(
                                exam.title,
                                "Due Date: " + exam.date, 
                                "Total Marks: " + exam.totalMarks, 
                                exam.description);
                            assignmentPanel.add(individualExam, exam.title);
                            CardLayout cl = (CardLayout)(assignmentPanel.getLayout());
                            cl.show(assignmentPanel, exam.title);
                        }
                        
                    });
        }
    }
    public exam(){
        JPanel assignmentPanel = new JPanel(new CardLayout());
        assignmentPanel.setOpaque(false);
        assignmentPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Title title = new Title("Exam", null);
        add(title);
        title.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                CardLayout cl = (CardLayout)(assignmentPanel.getLayout());
                cl.show(assignmentPanel, "assignment");
                title.setText("Exam");
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
                for(Datapoints.Courses.Exam exam: course.exams){
                    Box line = new Line(new ListItem(
                        exam.title, 
                        course.name, 
                        exam.date, 
                        String.format("%03d", exam.totalMarks) + "   " + String.format("%03d", exam.marksObtained)));
                    line.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mouseClicked(MouseEvent e){
                            title.setText("Exam > " + exam.title);
                            JPanel individualExam = new Post(
                                exam.title,
                                "Due Date: " + exam.date, 
                                "Total Marks: " + exam.totalMarks, 
                                exam.description);
                            assignmentPanel.add(individualExam, exam.title);
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
                    Box line = new Line(new ListItem(
                        exam.title, 
                        course.name, 
                        exam.date, 
                        String.format("%03d", exam.totalMarks) + "   " + String.format("%03d", exam.marksObtained)));
                    line.addMouseListener(new MouseAdapter(){
                        @Override
                        public void mouseClicked(MouseEvent e){
                            title.setText("Exam > " + exam.title);
                            JPanel individualExam = new Post(
                                exam.title,
                                "Due Date: " + exam.date, 
                                "Total Marks: " + exam.totalMarks, 
                                exam.description);
                            assignmentPanel.add(individualExam, exam.title);
                            CardLayout cl = (CardLayout)(assignmentPanel.getLayout());
                            cl.show(assignmentPanel, exam.title);
                        }
                        
                    });
                    list.add(line);
                    list.add(Box.createVerticalStrut(10));
                }
            }
        }
        ScrollPane scroll = new ScrollPane(list);

        assignmentPanel.add(scroll, "assignment");
        add(assignmentPanel);
    }
}
