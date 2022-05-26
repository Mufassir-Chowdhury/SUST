package Components.pageView;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.Component;

public class ListPanel extends JPanel {
    public ListPanel(){
        setOpaque(false);
        setAlignmentX(Component.LEFT_ALIGNMENT);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
}
