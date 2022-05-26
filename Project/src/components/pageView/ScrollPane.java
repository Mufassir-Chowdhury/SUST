package Components.pageView;

import javax.swing.JComponent;
import javax.swing.JScrollPane;
import java.awt.Component;

public class ScrollPane extends JScrollPane {
    public ScrollPane(JComponent component){
        super(component);
        setAlignmentX(Component.LEFT_ALIGNMENT);
        setOpaque(false);
        getViewport().setOpaque(false);
        setBorder(null);
    }
}
