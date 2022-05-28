package Components.pageView.Box;

import javax.swing.Box;
import javax.swing.BoxLayout;

import Constants.Fonts;
import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import javax.swing.border.EmptyBorder;

import Components.Label;

public class ResultSummary extends Box {
    public ResultSummary(){
        super(BoxLayout.X_AXIS);
        setAlignmentY(Component.TOP_ALIGNMENT);
        Label grade = new Label("A+", Fonts.BIG_DISPLAY, Color.GREEN);
        grade.setBorder(new EmptyBorder(new Insets(0, 0, 0, 5)));
        add(grade);
        Box resultSummarySmall = Box.createVerticalBox();
        resultSummarySmall.add(new Label("4.00", Fonts.Body));
        resultSummarySmall.add(new Label("1st", Fonts.Body));
        add(resultSummarySmall);
    }
}
