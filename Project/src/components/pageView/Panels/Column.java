package Components.pageView.Panels;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

import Components.pageView.Box.Title;
import Constants.Sizes;

public class Column extends JPanel {
    public Column(Title title, JComponent component){
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setMaximumSize(Sizes.COLUMN);
        add(title);
        add(Box.createVerticalStrut(5));
        add(component);
    }
}
