package Components.pageView;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class ViewPort extends JPanel {
    public ViewPort(String title, JComponent component){
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new Title(title, component));
        add(Box.createVerticalStrut(20));
    }
}
