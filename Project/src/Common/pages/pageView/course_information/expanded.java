package Common.pages.pageView.course_information;

import java.awt.Component;
import javax.swing.Box;
import javax.swing.BoxLayout;

import Components.Label;
import Components.pageView.Box.MainCardListItem.Type;

public class expanded extends Box {
    public expanded(Type type){
        super(BoxLayout.X_AXIS);
        setAlignmentX(Component.LEFT_ALIGNMENT);
        add(new Label("ATTENDANCE MARKS"));
        add(Box.createHorizontalGlue());
        if(type == Type.RESULT){
            add(new Label("EXAM MARKS"));
            add(Box.createHorizontalGlue());
            add(new Label("ASSIGNMENT MARKS"));
        }
    }
}
