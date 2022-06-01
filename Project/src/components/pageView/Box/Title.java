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

    public Title(Label label, JComponent component){
        super(BoxLayout.X_AXIS);
        setAlignmentX(Component.LEFT_ALIGNMENT);
        label.setAlignmentY(Component.TOP_ALIGNMENT);
        add(label);

        add(Box.createHorizontalGlue());
        if(component != null){
            add(component);
            component.setAlignmentY(Component.TOP_ALIGNMENT);
        }
    }
}
