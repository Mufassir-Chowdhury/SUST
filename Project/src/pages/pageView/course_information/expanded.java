package pages.pageView.course_information;

import java.awt.Component;
import javax.swing.Box;
import javax.swing.BoxLayout;

import Components.Label;
import Constants.Fonts;

public class expanded extends Box {
    public expanded(expandableList.Type type){
        super(BoxLayout.X_AXIS);
        setAlignmentX(Component.LEFT_ALIGNMENT);
        add(new Label("ATTENDANCE MARKS", Fonts.Body));
        add(Box.createHorizontalGlue());
        if(type == expandableList.Type.RESULT){
            add(new Label("EXAM MARKS", Fonts.Body));
            add(Box.createHorizontalGlue());
            add(new Label("ASSIGNMENT MARKS", Fonts.Body));
        }
    }
}
