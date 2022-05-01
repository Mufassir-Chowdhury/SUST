package mainView;

import java.awt.Component;
import java.awt.Graphics;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Constants.Colors;
import Constants.Fonts;
import Constants.Sizes;

class Card extends JPanel {
    JLabel logo = new JLabel();
    JLabel label = new JLabel();

    public Card(String text, Icon icon){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Colors.CARD);
        setSize(Sizes.CARD_SIZE);
        setMinimumSize(Sizes.CARD_SIZE);
        setMaximumSize(Sizes.CARD_SIZE);

        logo.setIcon(icon);
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        label.setText(text);
        label.setFont(Fonts.BODY_LARGE);
        label.setForeground(Colors.ACCENT);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(Box.createVerticalGlue());
        add(logo);
        add(label);
        add(Box.createVerticalGlue());
    }
    protected void paintComponent(Graphics g) {
        g.setColor(Colors.CARD);
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 7, 7);
         super.paintComponent(g);
    }
    protected void paintBorder(Graphics g) {
        g.setColor(Colors.CARD);
        g.drawRoundRect(0, 0, getWidth(), getHeight(), 7, 7);
    }
}