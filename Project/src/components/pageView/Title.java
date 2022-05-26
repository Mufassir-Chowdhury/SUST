package Components.pageView;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;

import Components.Label;
import Constants.Fonts;

import java.awt.Component;

public class Title extends Box {
    Label titleLabel;

    public void setText(String title){
        titleLabel.setText(title);
    }

    public Title(String name, JComponent component){
        super(BoxLayout.X_AXIS);
        setAlignmentX(Component.LEFT_ALIGNMENT);
        titleLabel = new Label(name, Fonts.DISPLAY);
        titleLabel.setAlignmentY(Component.TOP_ALIGNMENT);
        add(titleLabel);

        add(Box.createHorizontalGlue());
        if(component != null){
            add(component);
            component.setAlignmentY(Component.TOP_ALIGNMENT);
        }
    }
}
