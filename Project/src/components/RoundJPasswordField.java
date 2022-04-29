package Components;

import javax.swing.JPasswordField;

import Constants.Colors;
import Constants.Fonts;
import Constants.Margins;
import Constants.Sizes;
import Constants.Values;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Component;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class RoundJPasswordField extends JPasswordField implements KeyListener, FocusListener {
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
        g.drawRoundRect(0, getHeight(), getWidth()-1, 0, 0, 0);
    }
    @Override
    public void focusGained(FocusEvent e) {
        setBackground(new Color(0, 191, 255));
        
    }
	@Override
    public void focusLost(FocusEvent e) {
        if(getPassword().length == 0 || Arrays.equals(getPassword(), Values.DEFAULT_PASSWORD)) {
            setEchoChar(Values.PASSWORD_PLAIN_ECHO_CHAR);
            setBackground(new Color(135, 206, 250));
            setText(Values.PASSWORD_PLACEHOLDER);
        }
        
    }
    @Override
    public void keyTyped(KeyEvent e) {
    if (Arrays.equals(getPassword(), Values.DEFAULT_PASSWORD)){
            setText("");
            if(showPassword==false) setEchoChar(Values.PASSWORD_ECHO_CHAR);
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {
    	if(Arrays.equals(getPassword(), Values.DEFAULT_PASSWORD) && e.getKeyChar() == KeyEvent.VK_BACK_SPACE){
            setText(" ");
            if(showPassword==false) setEchoChar(Values.PASSWORD_ECHO_CHAR);
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}