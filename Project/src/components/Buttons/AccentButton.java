package Components.Buttons;

import java.awt.Graphics;

import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import Constants.Colors;

public class AccentButton extends RoundJButton implements MouseListener, KeyListener {

    public AccentButton(String text) {
        super(text);
        setBackground(Colors.PLAIN_TEXT);
        setForeground(Colors.PLAIN_TEXT_BLACK);
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
    public void mouseEntered(MouseEvent e) {
        setForeground(Colors.ACCENT_BUTTON_HOVER);
    }
    @Override
    public void mouseExited(MouseEvent e) {
        if(isFocusOwner()) return;
        setForeground(Colors.PLAIN_TEXT_BLACK);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}
