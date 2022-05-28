package Components;

import java.awt.Color;
import java.awt.Component;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Insets;
import javax.swing.border.EmptyBorder;

import Constants.Fonts;

public class ListItem extends JPanel {
    public ListItem(String title, String caption, String center, String trailing) {
        setBackground(new Color(255, 255, 255, 13));
        setAlignmentX(Component.LEFT_ALIGNMENT);
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBorder(new EmptyBorder(new Insets(10, 5, 10, 5)));
        Box congestedInfo = Box.createVerticalBox();
        congestedInfo.add(new Label(title));
        congestedInfo.add(new Label(caption, Fonts.CAPTION));
        add(congestedInfo);
        add(Box.createHorizontalGlue());
        add(new Label(center, Fonts.PLAIN_TEXT, SwingConstants.RIGHT));
        add(Box.createHorizontalStrut(20));
        add(new Label(trailing, Fonts.PLAIN_TEXT));
    }
}
