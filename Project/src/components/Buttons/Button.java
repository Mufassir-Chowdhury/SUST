package Components.Buttons;

import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import Constants.Fonts;
import Constants.Margins;
import Constants.Sizes;

import java.awt.Cursor;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Button extends JButton implements FocusListener{
    private static final long serialVersionUID = 1L;

    public Button(String text) {
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
        setFocusable(true);

    }

    @Override
    public void focusGained(FocusEvent e) {
        setBorder(new Border() {
            @Override
            public void paintBorder(java.awt.Component c, java.awt.Graphics g, int x, int y, int width, int height) {
                g.setColor(Constants.Colors.PLAIN_TEXT);
                g.drawRoundRect(x, y, width, height, 7, 7);
            }

            @Override
            public Insets getBorderInsets(java.awt.Component c) {
                return Margins.BUTTON;
            }

            @Override
            public boolean isBorderOpaque() {
                return false;
            }
        });
        repaint();
    }

    @Override
    public void focusLost(FocusEvent e) {
        setBorder(new EmptyBorder(Margins.BUTTON));
        repaint();
    }
}