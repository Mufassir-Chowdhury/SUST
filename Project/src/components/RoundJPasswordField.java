package Components;

import javax.swing.JPasswordField;

import Constants.Colors;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.Dimension;

public class RoundJPasswordField extends JPasswordField implements KeyListener, FocusListener {
	private static final long serialVersionUID = 1L;
	private int size;
    String placeholder = " password";
    private char[] defaultPassword = new char[]{' ', 'p','a','s','s','w','o','r','d'};
    Boolean showPassword = false;

    public RoundJPasswordField(int size, boolean showPassword) {
        super(size);
        this.size = size;
        this.showPassword = showPassword;
    
        setOpaque(false);
        setSize(350, 32);
        setMaximumSize(new Dimension(350, 32));
        setMinimumSize(new Dimension(350, 32));
        setBackground(Color.WHITE);
        setForeground(Color.WHITE);
        setFont(new Font("Segoe UI", Font.PLAIN, 14));
        setMargin(new Insets(8, 10, 8, 10));
        setText(placeholder);
        setEchoChar('\u0000');
    }
    
    protected void paintComponent(Graphics g) {
        g.setColor(new Color(53, 40, 47));
        g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 4, 4);
        super.paintComponent(g);
    }
    
    protected void paintBorder(Graphics g) {
        g.setColor(new Color(156, 150, 154));
         g.drawRoundRect(0, getHeight(), getWidth()-1, 0, 0, 0);
    }
    @Override
    public void focusGained(FocusEvent e) {
        setBackground(new Color(0, 191, 255));
        
    }
	@Override
    public void focusLost(FocusEvent e) {
        if(getPassword().length == 0 || Arrays.equals(getPassword(), defaultPassword)) {
            setEchoChar('\u0000');
            setBackground(new Color(135, 206, 250));
            setText(placeholder);
        }
        
    }
    @Override
    public void keyTyped(KeyEvent e) {
    if (Arrays.equals(getPassword(), defaultPassword)){
            setText("");
            if(showPassword==false) setEchoChar('\u25cf');
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {
    	if(Arrays.equals(getPassword(), defaultPassword) && e.getKeyChar() == KeyEvent.VK_BACK_SPACE){
            setText(" ");
            if(showPassword==false) setEchoChar('\u25cf');
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}