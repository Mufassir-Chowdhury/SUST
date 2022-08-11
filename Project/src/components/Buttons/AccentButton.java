package Components.Buttons;

import java.awt.Graphics;
import java.awt.Component;
import java.awt.Color;
import java.awt.event.MouseListener;

import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;
import Constants.Colors;
import Constants.Sizes;

public class AccentButton extends Button implements MouseListener{
    private Color background = Colors.Theme.ACCENT_FILL;
    public AccentButton(String text) {
        super(text);
        setOpaque(false);
        setForeground(Colors.PLAIN_TEXT_BLACK);
        setAlignmentX(Component.CENTER_ALIGNMENT);
        setFocusPainted(false);
        addMouseListener(this);
        addFocusListener(this);
    }

    protected void paintComponent(Graphics g) {
        g.setColor(background);
        g.fillRoundRect(0, 0, getWidth(), getHeight(), Sizes.BORDER_RADIUS, Sizes.BORDER_RADIUS);
        super.paintComponent(g);
    }

    protected void paintBorder(Graphics g) {
        g.setColor(background);
        g.drawRoundRect(0, 0, getWidth(), getHeight(), Sizes.BORDER_RADIUS, Sizes.BORDER_RADIUS);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        background = Colors.Theme.Button.ACCENT_BUTTON_HOVER;
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(isFocusOwner()) return;
        background = Colors.Theme.ACCENT_FILL;
        repaint();
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }
    @Override
    public void mousePressed(MouseEvent e) {
        background = Colors.Theme.Button.ACCENT_BUTTON_PRESSED;
        repaint();
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        background = Colors.Theme.ACCENT_FILL;
        repaint();
    }

    @Override
    public void focusGained(FocusEvent e) {
        background = Colors.Theme.Button.ACCENT_BUTTON_HOVER;
        repaint();
    }

    @Override
    public void focusLost(FocusEvent e) {
        background = Colors.Theme.ACCENT_FILL;
        repaint();
    }
}
