package Components.pageView.Panels;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Components.Label;
import Components.pageView.Box.Title;
import Constants.Fonts;
import pages.pageView.misc.bus.Day;
public class Column extends JPanel {
    public Column(){
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setMaximumSize(new Dimension(1000, 200));
        add(new Title("Bus 1", Fonts.SUBTITLE, null));
        add(Box.createVerticalStrut(5));
        add(new Day());
    }
    public Column(String item){
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setMaximumSize(new Dimension(1000, 200));
        add(new Title("Tuesday", Fonts.SUBTITLE, new Label("Date")));
        add(Box.createVerticalStrut(5));
        add(new Day(item));
    }
}
