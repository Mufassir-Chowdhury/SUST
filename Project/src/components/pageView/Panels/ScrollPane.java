package Components.pageView.Panels;

import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import java.awt.Component;

public class ScrollPane extends JScrollPane {
    public ScrollPane(JComponent component){
        super(component);
        setAlignmentX(Component.LEFT_ALIGNMENT);
        setOpaque(false);
        getViewport().setOpaque(false);
        setBorder(new EmptyBorder(0, 0, 0, 0));
    }
}
