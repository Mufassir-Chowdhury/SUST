package Components;

import javax.swing.JPasswordField;

import Constants.Colors;
import Constants.Fonts;
import Constants.Margins;
import Constants.Sizes;
import Constants.Values;
import java.awt.Graphics;
import java.awt.Component;
import java.util.Arrays;

public class RoundJPasswordField extends JPasswordField {
	private static final long serialVersionUID = 1L;
    Boolean showPassword = false;

    public RoundJPasswordField(boolean showPassword) {
        this.showPassword = showPassword;
    
        setOpaque(false);
        setSize(Sizes.TEXT_FIELD_SIZE);
        setMaximumSize(Sizes.TEXT_FIELD_SIZE);
        setForeground(Colors.PLAIN_TEXT);
        setFont(Fonts.PLAIN_TEXT);
        setMargin(Margins.TEXT_FIELD);
        setText(Values.PASSWORD_PLACEHOLDER);
        setEchoChar(Values.PASSWORD_PLAIN_ECHO_CHAR);
        setAlignmentX(Component.CENTER_ALIGNMENT);
    }
    
    protected void paintComponent(Graphics g) {
        g.setColor(Colors.TEXT_FIELD_BACKGROUND);
        g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 4, 4);
        super.paintComponent(g);
    }
    
    protected void paintBorder(Graphics g) {
        g.setColor(Colors.TEXT_FIELD_BORDER);
        g.drawRoundRect(0, getHeight(), getWidth() - 1, 0, 0, 0);
    }
    
    public boolean checkPlaceholder()
    {
        return Arrays.equals(getPassword(), Values.DEFAULT_PASSWORD);
    }
    
    public boolean isEmpty()
    {
        return getPassword().length == 0;
    }

    public void cleanField()
    {
        if (checkPlaceholder()){
            setText("");
            if(showPassword==false) setEchoChar(Values.PASSWORD_ECHO_CHAR);
        }
    }
}