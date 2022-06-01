package Components.pageView.Panels;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.Component;

import Constants.Padding;

public class ListPanel extends JPanel {

    public ListPanel()
    {
        setOpaque(false);
        setAlignmentX(Component.LEFT_ALIGNMENT);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    public ListPanel(JComponent component, JComponent component2){
        setOpaque(false);
        setAlignmentX(Component.LEFT_ALIGNMENT);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(Padding.LIST_PANEL);

        add(component);
        if(component2 != null){
            add(component2);
        }

    }
}
