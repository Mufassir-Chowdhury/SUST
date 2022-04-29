package Components.Buttons;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import Constants.Colors;
import Constants.Fonts;
import Constants.Margins;
import Constants.Sizes;

import java.awt.Graphics;
import java.awt.Cursor;

public class RoundJButton extends JButton implements MouseListener, KeyListener {
    private static final long serialVersionUID = 1L;

    public RoundJButton(String text) {
        setOpaque(false); 
        setText(text);
        setSize(Sizes.BUTTON_SIZE);
        setMaximumSize(Sizes.BUTTON_SIZE);
        setMinimumSize(Sizes.BUTTON_SIZE);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setBackground(Colors.PLAIN_TEXT);
        setForeground(Colors.PLAIN_TEXT_BLACK);
        setFont(Fonts.PLAIN_TEXT);
        setMargin(Margins.BUTTON);
        setFocusable(false);
    }
    protected void paintComponent(Graphics g) {
        g.setColor(Colors.ACCENT);
        g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 4, 4);
         super.paintComponent(g);
    }
    protected void paintBorder(Graphics g) {
        g.setColor(Colors.ACCENT);
        g.drawRoundRect(0, 0, 0, 0, 0, 0);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
    	
        //fetching data and checking database
    	
    }
    @Override
    public void mousePressed(MouseEvent e) {
        
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        setForeground(Colors.ACCENT_BUTTON_HOVER);
    }
    @Override
    public void mouseExited(MouseEvent e) {
        if(isFocusOwner()) return;
        setForeground(Colors.ACCENT);
    }
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyChar() == KeyEvent.VK_ENTER){
			//fetching data and checking database
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		
	}
}