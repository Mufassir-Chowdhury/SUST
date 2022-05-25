package Components;

import java.awt.*;
import java.awt.Graphics;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Constants.Colors;
import Constants.Fonts;
import Constants.Sizes;

public class Card extends JPanel {
    Color background = Colors.CARD;
    public Card(String text, Icon icon) {
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setMaximumSize(Sizes.CARD_SIZE);
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        
        JLabel logo = new JLabel(icon);
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(Box.createVerticalGlue());
        add(logo);
        add(Box.createVerticalStrut(5));
        Label label = new Label(text, Fonts.BODY_LARGE, Component.CENTER_ALIGNMENT);
        add(label);
        add(Box.createVerticalGlue());

        addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e) {
                background = new Color(255, 255, 255, 25);
                repaint();
            }

            public void mouseExited(MouseEvent e) {
                background = Colors.CARD;
                repaint();
            }
        });
    }
    public Card(String text, Font font) {
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setMaximumSize(Sizes.CARD_SIZE);
        add(Box.createVerticalGlue());
        add(new Label(text, font, Component.CENTER_ALIGNMENT));
        add(Box.createVerticalGlue());
        addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e) {
                background = new Color(255, 255, 255, 25);
                repaint();
            }

            public void mouseExited(MouseEvent e) {
                background = Colors.CARD;
                repaint();
            }
        });
    }

    
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(background);
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 7, 7);
        super.paintComponent(g);
    }

}