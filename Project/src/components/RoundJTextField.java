package Components;

import javax.swing.JTextField;

import Constants.Colors;
import Constants.Fonts;
import Constants.Margins;
import Constants.Sizes;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Component;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class RoundJTextField extends JTextField implements KeyListener, FocusListener {
	private static final long serialVersionUID = 1L;
    private String placeholder;
    
    public RoundJTextField(String placeholder) {
        this.placeholder = placeholder;

        setOpaque(false);
        setText(placeholder);
        setSize(Sizes.TEXT_FIELD_SIZE);
        setMaximumSize(Sizes.TEXT_FIELD_SIZE);
        setMinimumSize(Sizes.TEXT_FIELD_SIZE);
        setForeground(Colors.PLAIN_TEXT);
        setFont(Fonts.PLAIN_TEXT);
        setMargin(Margins.TEXT_FIELD);
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



