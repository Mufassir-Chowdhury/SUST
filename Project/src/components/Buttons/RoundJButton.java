package Components.Buttons;

import javax.swing.JButton;

import Constants.Fonts;
import Constants.Margins;
import Constants.Sizes;

import java.awt.Cursor;

public class RoundJButton extends JButton {
    private static final long serialVersionUID = 1L;

    public RoundJButton(String text) {
        setOpaque(false); 
        setText(text);
        setSize(Sizes.BUTTON_SIZE);
        setMaximumSize(Sizes.BUTTON_SIZE);
        setMinimumSize(Sizes.BUTTON_SIZE);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setFont(Fonts.PLAIN_TEXT);
        setMargin(Margins.BUTTON);
        setFocusable(false);
    }
}