package pages.pageView.misc;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Components.pageView.Title;

public class map extends JPanel {
    public map(){
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new Title("Map", null));
        add(Box.createVerticalStrut(20));
    }
}
