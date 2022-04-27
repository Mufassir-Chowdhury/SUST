package Components;

import javax.swing.JPasswordField;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

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
        setBounds(40, 250, 340, 40);
        setBackground(new Color(135, 206, 250));
        setForeground(Color.black);
        setFont(new Font("Segoe UI", Font.ITALIC, 16));
        setMargin(new Insets(2, 10, 2, 2));
        setText(placeholder);
        setEchoChar('\u0000');
    }
    
    protected void paintComponent(Graphics g) {
            g.setColor(getBackground());
            g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, size, size);
            super.paintComponent(g);
    }
    
    protected void paintBorder(Graphics g) {
            g.setColor(getForeground());
            g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, size, size);
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