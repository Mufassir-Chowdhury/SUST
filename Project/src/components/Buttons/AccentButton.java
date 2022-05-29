package Components.Buttons;

import java.awt.Graphics;
import java.awt.Component;
import java.awt.Color;
import java.awt.event.MouseListener;

import java.awt.event.*;
import java.awt.event.MouseEvent;
import Constants.Colors;

public class AccentButton extends Button implements MouseListener{
    private Color background = Colors.ACCENT;
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
        // TODO arch measures to Size class
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 7, 7);
        super.paintComponent(g);
    }

    protected void paintBorder(Graphics g) {
        g.setColor(background);
        g.drawRoundRect(0, 0, getWidth(), getHeight(), 7, 7);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        background = Colors.ACCENT_BUTTON_HOVER;
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(isFocusOwner()) return;
        background = Colors.ACCENT;
        repaint();
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }
    @Override
    public void mousePressed(MouseEvent e) {
        background = Colors.ACCENT_BUTTON_PRESSED;
        repaint();
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        background = Colors.ACCENT;
        repaint();
    }

    @Override
    public void focusGained(FocusEvent e) {
        background = Colors.ACCENT_BUTTON_HOVER;
        repaint();
    }

    @Override
    public void focusLost(FocusEvent e) {
        background = Colors.ACCENT;
        repaint();
    }
}
