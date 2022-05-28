package Components.pageView.Panels;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.Component;
import java.awt.Insets;
import javax.swing.border.EmptyBorder;

public class ListPanel extends JPanel {
    public ListPanel(JComponent component, JComponent component2){
        setOpaque(false);
        setAlignmentX(Component.LEFT_ALIGNMENT);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(new Insets(5, 10, 5, 10)));

        add(component);
        if(component2 != null){
            add(component2);
        }

    }
}
