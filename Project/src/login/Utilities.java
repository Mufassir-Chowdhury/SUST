package login;

import javax.swing.JCheckBox;

import Constants.Colors;
import Constants.Sizes;

class Utilities {
    public static class showPassword extends JCheckBox {
        public showPassword(){
            setSize(Sizes.CHECKBOX_SIZE);
            setFocusPainted(false);
            setBackground(Colors.PLAIN_TEXT);
            setForeground(Colors.ACCENT);
            setBorder(null);
            setText("Show Password");
            setContentAreaFilled(false);
            setFocusable(false);
        }
    }
}
