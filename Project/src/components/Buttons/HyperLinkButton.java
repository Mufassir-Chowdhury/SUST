package Components.Buttons;

import Constants.Colors;
import Constants.Padding;

import java.awt.event.*;

import java.awt.event.MouseEvent;

public class HyperLinkButton extends Button implements MouseListener  {
    public HyperLinkButton(String text) {
        super(text);
        setOpaque(false);
        setForeground(Colors.Theme.ACCENT_TEXT);
        setBorder(Padding.BUTTON);

        addMouseListener(this);
        addFocusListener(this);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setBackground(Colors.Button.HYPER_LINK_BUTTON_HOVER);
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
        setBackground(Colors.Button.HYPER_LINK_BUTTON_PRESSED);
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
        setBackground(Colors.Button.HYPER_LINK_BUTTON_HOVER);
        setOpaque(true);
    }

    @Override
    public void focusLost(FocusEvent e) {
        setBackground(null);
        setOpaque(false);
    }
    
}