package components;

import javax.swing.JTextField;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class RoundJTextField extends JTextField implements KeyListener, FocusListener {
	private static final long serialVersionUID = 1L;
	private int size;
    private String placeholder;
    
    public RoundJTextField(int size, String placeholder) {
        super(size);
        this.size = size;
        this.placeholder = placeholder;

        setOpaque(false);
        setText(placeholder);
        setBounds(40, 160, 340, 40);
        setBackground(new Color(135, 206, 250));
        setForeground(Color.black);
        setFont(new Font("Segoe UI", Font.ITALIC, 16));
        setMargin(new Insets(2, 10, 2, 2));
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
    public void keyTyped(KeyEvent e) {
        if(getText().equals(placeholder)){	
            setText("");
        }   
    }
    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
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



