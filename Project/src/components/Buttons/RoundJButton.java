package Components.Buttons;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import Constants.Colors;

import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.Dimension;

public class RoundJButton extends JButton implements MouseListener, KeyListener {
    private static final long serialVersionUID = 1L;
    private int size;
    public enum Style {
        ACCENT, STANDARD, HYPERLINK
    }
    public RoundJButton(int size, String text, Style style) {
        super();
        this.size = size;
        setOpaque(false); 
        setText(text);
        setSize(120, 32);
        setMaximumSize(new Dimension(120, 32));
        setMinimumSize(new Dimension(120, 32));
        setContentAreaFilled(false);
        setFocusPainted(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setBackground(Color.WHITE);
        setForeground(Color.BLACK);
        setFont(new Font("Segoe UI", Font.PLAIN, 14));
        setMargin(new Insets(5, 10, 5, 10));
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
        setForeground(new Color(30, 144, 255));
    }
    @Override
    public void mouseExited(MouseEvent e) {
        if(isFocusOwner()) return;
        setForeground(new Color(135, 206, 250));
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