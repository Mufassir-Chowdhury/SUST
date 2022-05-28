package Components.pageView.Panels;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

import Components.pageView.Box.Title;

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
