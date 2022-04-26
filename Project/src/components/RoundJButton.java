package components;
import java.awt.event.MouseListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.Cursor;

public class RoundJButton extends JButton implements MouseListener, FocusListener {
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
        setBounds(40, 340, 340, 40);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setFont(new Font("MS UI Gothic", Font.BOLD, 23));
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setForeground(new Color(135, 206, 250));
        setBackground(new Color(0, 0, 0));
        setBorder(null);
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
        setForeground(new Color(30, 144, 255));
    }
    @Override
    public void focusLost(FocusEvent e) {
        setForeground(new Color(135, 206, 250));
        
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
    public void mouseEntered(MouseEvent e) {
        setForeground(new Color(30, 144, 255));
        
    }
    @Override
    public void mouseExited(MouseEvent e) {
        if(isFocusOwner()) return;
        setForeground(new Color(135, 206, 250));
        
    }
}