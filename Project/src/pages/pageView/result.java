package pages.pageView;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.Insets;
import javax.swing.border.EmptyBorder;

import Components.Label;

import java.awt.Component;

import Constants.Fonts;
import Server.Datapoints;

public class result extends JPanel {
    public result(){
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Box title = Box.createHorizontalBox();
        title.setAlignmentX(Component.LEFT_ALIGNMENT);
        Label titleLabel = new  Label("Results", Fonts.DISPLAY);
        titleLabel.setAlignmentY(Component.TOP_ALIGNMENT);
        title.add(titleLabel);
        title.add(Box.createHorizontalGlue());

        Box resultSummary = Box.createHorizontalBox();
        resultSummary.setAlignmentY(Component.TOP_ALIGNMENT);
        Label grade = new Label("A+", Fonts.BIG_DISPLAY);
        grade.setBorder(new EmptyBorder(new Insets(0, 0, 0, 5)));
        resultSummary.add(grade);
        Box resultSummarySmall = Box.createVerticalBox();
        resultSummarySmall.add(new Label("4.00", Fonts.Body));
        resultSummarySmall.add(new Label("1st", Fonts.Body));
        resultSummary.add(resultSummarySmall);
        title.add(resultSummary);
        add(title);
        add(Box.createVerticalStrut(20));
        for(Datapoints.Courses course: Datapoints.COURSES){
            Box line = Box.createHorizontalBox();
            line.setAlignmentX(Component.LEFT_ALIGNMENT);
            line.add(new Label(course.code, Fonts.Body));
            line.add(Box.createHorizontalGlue());
            line.add(new Label(course.name, Fonts.Body));
            line.add(Box.createHorizontalGlue());
            line.add(new Label(String.valueOf(course.grade), Fonts.Body));
            line.add(Box.createHorizontalGlue());
            line.add(new Label(String.valueOf(course.gpa), Fonts.Body));
            add(line);
        }
    }
}
