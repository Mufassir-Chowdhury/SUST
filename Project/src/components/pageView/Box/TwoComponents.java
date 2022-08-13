package Components.pageView.Box;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;

import Components.Label;
import java.awt.Component;

public class TwoComponents extends Box {
    public TwoComponents(JComponent component, JComponent component2) {
        super(BoxLayout.X_AXIS);
        setAlignmentX(Component.LEFT_ALIGNMENT);
        add(component);
        add(Box.createHorizontalStrut(10));
        add(component2);
    }
}
