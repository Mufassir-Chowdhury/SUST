package Components.pageView;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.Component;

public class ListPanel extends JPanel {
    public ListPanel(JComponent component){
        setOpaque(false);
        setAlignmentX(Component.LEFT_ALIGNMENT);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        if(component != null)
            add(component);
    }
}
