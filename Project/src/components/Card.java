package Components;

import java.awt.*;
import java.awt.Graphics;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import Constants.Colors;
import Constants.Fonts;
import Constants.Sizes;

public class Card extends JPanel implements MouseListener {
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

        addMouseListener(this);
    }
    public Card(String text, Font font) {
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setMaximumSize(Sizes.CARD_SIZE);
        add(Box.createVerticalGlue());
        add(new Label(text, font, Component.CENTER_ALIGNMENT));
        add(Box.createVerticalGlue());
        addMouseListener(this);
    }

    
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(background);
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 7, 7);
        super.paintComponent(g);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        background = Colors.CARD_HOVER;
        repaint();
    }
    @Override
    public void mouseExited(MouseEvent e) {
        background = Colors.CARD;
        repaint();
    }

}