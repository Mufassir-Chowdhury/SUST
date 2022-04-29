package Components;

import javax.swing.JTextField;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.Dimension;

public class RoundJTextField extends JTextField implements KeyListener, FocusListener {
	private static final long serialVersionUID = 1L;
    private String placeholder;
    
    public RoundJTextField(String placeholder) {
        this.placeholder = placeholder;

        setOpaque(false);
        setText(placeholder);
        setSize(350, 32);
        setMaximumSize(new Dimension(350, 32));
        setMinimumSize(new Dimension(350, 32));
        setBackground(Color.WHITE);
        setForeground(Color.WHITE);
        setFont(new Font("Segoe UI", Font.PLAIN, 14));
        setMargin(new Insets(8, 10, 8, 10));
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
    public void keyTyped(KeyEvent e) {
        if(getText().equals(placeholder)){	
            setText("");
        }   
    }
    @Override
    public void keyPressed(KeyEvent e) {
    	if(getText().equals(placeholder) && e.getKeyChar() == KeyEvent.VK_BACK_SPACE){
            setText(" ");
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    @Override
    public void focusGained(FocusEvent e) {
        setBackground(new Color(0, 191, 255));
        
    }
    @Override
    public void focusLost(FocusEvent e) {
        if(getText().isEmpty() || getText().equals(placeholder)) {
            setBackground(new Color(135, 206, 250));
            setText(placeholder);
        }
        
    }

}



