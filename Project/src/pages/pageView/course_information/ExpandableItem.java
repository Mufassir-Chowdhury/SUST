package pages.pageView.course_information;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import java.awt.Component;
import Components.pageView.Line;

public class ExpandableItem extends JPanel {
    public ExpandableItem(Line listItem){
        setAlignmentX(Component.LEFT_ALIGNMENT);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setOpaque(false);
        add(listItem);
    }
}
