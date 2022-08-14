package Components.pageView.Box;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;

import java.awt.Component;
import Constants.Sizes;

public class Options extends Box {
    public Options(JComponent component1, JComponent component2){
        super(BoxLayout.X_AXIS);
        setMaximumSize(Sizes.OPTIONS);
        setAlignmentX(Component.LEFT_ALIGNMENT);

        add(component1);
        add(Box.createHorizontalGlue());
        add(component2);
    }
}
