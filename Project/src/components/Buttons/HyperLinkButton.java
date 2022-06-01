package Components.Buttons;

import Constants.Colors;
import Constants.Margins;

import java.awt.event.*;

import java.awt.event.MouseEvent;

public class HyperLinkButton extends Button implements MouseListener  {
    public HyperLinkButton(String text) {
        super(text);
        setOpaque(false);
        setForeground(Colors.ACCENT_TEXT);
        setBorder(Margins.BUTTON);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setBackground(Colors.HYPER_LINK_BUTTON_HOVER);
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
        setBackground(Colors.HYPER_LINK_BUTTON_PRESSED);
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
        setBackground(Colors.HYPER_LINK_BUTTON_HOVER);
        setOpaque(true);
    }

    @Override
    public void focusLost(FocusEvent e) {
        setBackground(null);
        setOpaque(false);
    }
    
}