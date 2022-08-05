package Components.pageView.Box;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;

import Components.Label;
import java.awt.Component;

public class Title extends Box {
    Label titleLabel;

    public void setText(String title){
        titleLabel.setText(title);
    }

    public Title(Label label, JComponent component) {
        super(BoxLayout.X_AXIS);
        setAlignmentX(Component.LEFT_ALIGNMENT);
        titleLabel = label;
        titleLabel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        add(titleLabel);

        add(Box.createHorizontalGlue());
        if (component != null) {
            add(component);
            component.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        }
    }
    
    public Title(Label label){
        super(BoxLayout.X_AXIS);
        setAlignmentX(Component.LEFT_ALIGNMENT);
        titleLabel = label;
        titleLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
        add(titleLabel);
    }
}
