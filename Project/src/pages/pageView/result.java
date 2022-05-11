package pages.pageView;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Insets;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Component;

import Constants.Colors;
import Constants.Datapoints;
import Constants.Fonts;

public class result extends JPanel {
    public result(){
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Box title = Box.createHorizontalBox();
        title.setAlignmentX(Component.LEFT_ALIGNMENT);
        JLabel titleLabel = new JLabel("Results");
        titleLabel.setAlignmentY(Component.TOP_ALIGNMENT);
        titleLabel.setFont(Fonts.DISPLAY);
        titleLabel.setForeground(Colors.PLAIN_TEXT);
        title.add(titleLabel);
        title.add(Box.createHorizontalGlue());

        Box resultSummary = Box.createHorizontalBox();
        resultSummary.setAlignmentY(Component.TOP_ALIGNMENT);
        JLabel grade = new JLabel("A+");
        grade.setFont(Fonts.BIG_DISPLAY);
        grade.setForeground(Color.GREEN);
        grade.setBorder(new EmptyBorder(new Insets(0, 0, 0, 5)));
        resultSummary.add(grade);
        Box resultSummarySmall = Box.createVerticalBox();
        JLabel cgpa = new JLabel("4.00");
        cgpa.setFont(Fonts.Body);
        cgpa.setForeground(Colors.PLAIN_TEXT);
        resultSummarySmall.add(cgpa);
        JLabel position = new JLabel("1st");
        position.setFont(Fonts.Body);
        position.setForeground(Colors.PLAIN_TEXT);
        resultSummarySmall.add(position);
        resultSummary.add(resultSummarySmall);
        title.add(resultSummary);
        // JLabel addStudent = new JLabel("Post New Material");
        // title.add(addStudent);
        add(title);
        add(Box.createVerticalStrut(20));
        for(Datapoints.Courses course: Datapoints.COURSES){
            Box line = Box.createHorizontalBox();
            line.setAlignmentX(Component.LEFT_ALIGNMENT);
            line.add(new JLabel(course.code));
            line.add(Box.createHorizontalGlue());
            line.add(new JLabel(course.name));
            line.add(Box.createHorizontalGlue());
            line.add(new JLabel(String.valueOf(course.grade)));
            line.add(Box.createHorizontalGlue());
            line.add(new JLabel(String.valueOf(course.gpa)));
            add(line);
        }
    }
}
