package pages.pageView.updates.routine;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Components.Label;
import Constants.Fonts;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class timeline extends JPanel {
    public class defaultTimes extends JPanel{
        public defaultTimes(){
            setOpaque(false);
            setLayout(new GridLayout(9, 1));
            for(int i=9; i<=17; i++){
                JPanel panel = new JPanel(new BorderLayout());
                panel.setOpaque(false);
                panel.add(new Label(i + ":00", Fonts.Body, Component.RIGHT_ALIGNMENT), BorderLayout.NORTH);
                add(panel);
            }
        }
    }
    public timeline(){
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new Label(" ", Fonts.SUBTITLE, Component.RIGHT_ALIGNMENT));
        add(Box.createVerticalStrut(5));
        add(new defaultTimes());
    }
}
