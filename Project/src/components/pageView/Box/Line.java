package Components.pageView.Box;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import java.awt.Dimension;
import java.awt.Component;

public class Line extends Box {
    public Line(JComponent component){
        super(BoxLayout.X_AXIS);
        setMaximumSize(new Dimension(1000, 60));
        setAlignmentX(Component.LEFT_ALIGNMENT);
        add(component);
    }    
}
