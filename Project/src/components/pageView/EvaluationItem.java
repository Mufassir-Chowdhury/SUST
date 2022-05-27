package Components.pageView;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Components.ListItem;
import Server.Datapoints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.CardLayout;

import java.awt.Component;

public class EvaluationItem extends Box {
    public enum Type {
        EXAM, ASSIGNMENT
    }
    public EvaluationItem(Datapoints.Courses course, Datapoints.Courses.EvaluationItem evaluationMethod, Title title, JPanel panel, Type type) {
        super(BoxLayout.X_AXIS);
        setAlignmentX(Component.LEFT_ALIGNMENT);
        Box line = new Line(new ListItem(
            evaluationMethod.title, 
            course.name, 
            evaluationMethod.date, 
            String.format("%03d", evaluationMethod.totalMarks) + "   " + String.format("%03d", evaluationMethod.marksObtained)));
        
        line.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                title.setText(((type == Type.EXAM) ? "Exam > " : "Assignment > ") + evaluationMethod.title);
                Post individualExam = new Post(
                    evaluationMethod.title,
                    "Due Date: " + evaluationMethod.date, 
                    "Total Marks: " + evaluationMethod.totalMarks, 
                    evaluationMethod.description);
                panel.add(individualExam, evaluationMethod.title);
                CardLayout cl = (CardLayout)(panel.getLayout());
                cl.show(panel, evaluationMethod.title);
            }
        });
        add(line);
    }
}
