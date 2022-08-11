package Components.pageView.Panels;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

import Components.Label;
import Components.pageView.Box.Title;
import Constants.Fonts;
import Constants.Sizes;

public class ViewPort extends JPanel {
    protected Title title;
    public Title getTitle(){
        return title;
    }

    public ViewPort(String title, JComponent component) {
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.title = new Title(new Label(title, Fonts.DISPLAY), component);
        add(this.title);
        add(Box.createVerticalStrut(Sizes.TITLE_AND_PANEL_GAP));
    }
}
