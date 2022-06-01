package Components.pageView.Box;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;

import Constants.Sizes;

import java.awt.Component;

public class Line extends Box {
    public Line(JComponent component){
        super(BoxLayout.X_AXIS);
        //TODO Line is always called with ListItem, so merge them together
        setMaximumSize(Sizes.LIST_ITEM);
        setAlignmentX(Component.LEFT_ALIGNMENT);
        add(component);
    }    
}
