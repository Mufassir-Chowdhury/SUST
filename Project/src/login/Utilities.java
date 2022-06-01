package login;

import java.awt.Cursor;
import java.awt.event.MouseListener;

import javax.swing.JCheckBox;

import Constants.Colors;
import Constants.Sizes;

class Utilities {
    public static class showPassword extends JCheckBox {
        public showPassword(){
            setSize(Sizes.CHECKBOX_SIZE);
            setFocusPainted(false);
            setBackground(Colors.PLAIN_TEXT);
            setForeground(Colors.ACCENT_TEXT);
            setBorder(null);
            setText("Show Password");
            setContentAreaFilled(false);
            setFocusable(false);
        }
        
        @Override
        public synchronized void addMouseListener(MouseListener l) {
            super.addMouseListener(l);
            setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
    }
}
