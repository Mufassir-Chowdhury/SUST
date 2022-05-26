package Components.pageView;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class ViewPort extends JPanel {
    Title title;
    public Title getTitle(){
        return title;
    }
    public ViewPort(String title, JComponent component){
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.title = new Title(title, component);
        add(this.title);
        add(Box.createVerticalStrut(20));
    }
}
