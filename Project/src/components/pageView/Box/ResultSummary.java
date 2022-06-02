package Components.pageView.Box;

import javax.swing.Box;
import javax.swing.BoxLayout;

import Constants.Colors;
import Constants.Fonts;
import Constants.Padding;

import java.awt.Component;

import Components.Label;

public class ResultSummary extends Box {
    public ResultSummary(){
        super(BoxLayout.X_AXIS);
        setAlignmentY(Component.TOP_ALIGNMENT);
        Label grade = new Label("A+", Fonts.BIG_DISPLAY, Colors.Grade.FIRST_CLASS);
        grade.setBorder(Padding.GRADE);
        add(grade);
        Box resultSummarySmall = Box.createVerticalBox();
        resultSummarySmall.add(new Label("4.00"));
        resultSummarySmall.add(new Label("1st"));
        add(resultSummarySmall);
    }
}
