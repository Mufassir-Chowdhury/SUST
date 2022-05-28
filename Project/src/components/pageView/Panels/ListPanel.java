package Components.pageView.Panels;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.Component;

public class ListPanel extends JPanel {
    public ListPanel(){
        decorate();
    }

    public ListPanel(JComponent component) {
        decorate();
        if (component != null)
            add(component);
    }
    
    private void decorate()
    {
        setOpaque(false);
        setAlignmentX(Component.LEFT_ALIGNMENT);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
}
