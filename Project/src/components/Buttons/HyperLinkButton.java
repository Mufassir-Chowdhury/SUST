package Components.Buttons;

import Constants.Colors;
import Constants.Margins;

import java.awt.event.*;

import javax.swing.border.EmptyBorder;

import java.awt.Color;

import java.awt.event.MouseEvent;

public class HyperLinkButton extends Button implements MouseListener  {
    public HyperLinkButton(String text) {
        super(text);
        setOpaque(false);
        setForeground(Colors.ACCENT);
        setBorder(new EmptyBorder(Margins.BUTTON));
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setBackground(new Color(55, 40, 44));
        setOpaque(true);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(isFocusOwner()) return;
        setBackground(null);
        setOpaque(false);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }
    @Override
    public void mousePressed(MouseEvent e) {
        setBackground(new Color(52, 35, 40));
        setOpaque(true);
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        if (isFocusOwner())
            return;
        setBackground(null);
        setOpaque(false);
    }

    @Override
    public void focusGained(FocusEvent e) {
        setBackground(new Color(55, 40, 44));
        setOpaque(true);
    }

    @Override
    public void focusLost(FocusEvent e) {
        setBackground(null);
        setOpaque(false);
    }
    
}