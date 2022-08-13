package Components.pageView.Panels;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.Component;
import java.awt.Dimension;

import Constants.Padding;

public class ListPanel extends JPanel {

    public ListPanel()
    {
        setOpaque(false);
        setAlignmentX(Component.LEFT_ALIGNMENT);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    public ListPanel(JComponent component, JComponent component2, int padding){
        setOpaque(false);
        setAlignmentX(Component.LEFT_ALIGNMENT);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(Padding.LIST_PANEL);

        add(component);
        add(Box.createVerticalStrut(padding));
        if(component2 != null){
            add(component2);
        }

    }

    public ListPanel(Dimension size) {
        setOpaque(false);
        setAlignmentX(Component.LEFT_ALIGNMENT);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setSize(size);
    }
}
