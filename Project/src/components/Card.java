package Components;

import java.awt.*;
import java.awt.Graphics;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Constants.Colors;
import Constants.Fonts;
import Constants.Sizes;

public class Card extends JPanel {
    public Card(String text, Icon icon) {
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setMaximumSize(Sizes.CARD_SIZE);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        JLabel logo = new JLabel(icon);
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(Box.createVerticalGlue());
        add(logo);
        add(new Label(text, Fonts.BODY_LARGE, Component.CENTER_ALIGNMENT));
        add(Box.createVerticalGlue());
    }
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Colors.CARD);
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 7, 7);
        super.paintComponent(g);
    }

}