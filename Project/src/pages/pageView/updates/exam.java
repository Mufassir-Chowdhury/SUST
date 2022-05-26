package pages.pageView.updates;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import java.awt.event.MouseEvent;

import Components.Label;
import Components.pageView.EvaluationItem;
import Components.pageView.ScrollPane;
import Components.pageView.Title;
import Constants.Fonts;
import Server.Datapoints;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.CardLayout;

public class exam extends JPanel {
    JPanel assignmentPanel = new JPanel(new CardLayout());
    Title title = new Title("Exam", null);

    public exam(){
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
                title.setText("Exam");
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
                    for(Datapoints.Courses.Exam exam: course.exams){
                        list.add(new EvaluationItem(course, exam, title, assignmentPanel));
                        list.add(Box.createVerticalStrut(10));
                    }
                }
            }
        }
        assignmentPanel.add(new ScrollPane(list), "assignment");
        add(assignmentPanel);
    }
}
