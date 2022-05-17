package Components;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

import javax.swing.JPasswordField;

import Constants.Colors;
import Constants.Fonts;
import Constants.Margins;
import Constants.Sizes;
import Constants.Values;

public class RoundJPasswordField extends JPasswordField implements MouseListener, FocusListener, KeyListener {
	private static final long serialVersionUID = 1L;
    Boolean showPassword;
    private Color background = Colors.TEXT_FIELD_BACKGROUND;
    private Color border = Colors.TEXT_FIELD_BORDER;

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
        setCaretColor(Colors.PLAIN_TEXT);
    }
    
    protected void paintComponent(Graphics g) {
        g.setColor(background);
        g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 4, 4);
        super.paintComponent(g);
    }
    
    protected void paintBorder(Graphics g) {
        g.setColor(border);
        g.drawRoundRect(0, getHeight(), getWidth() - 1, 0, 0, 0);
    }
    
    public boolean checkPlaceholder(){
        return Arrays.equals(getPassword(), Values.DEFAULT_PASSWORD);
    }
    
    public boolean isEmpty() {
        return getPassword().length == 0;
    }
    
    public void setPlaceholder(){
        setText(Values.PASSWORD_PLACEHOLDER);
    }

    public void cleanField(){
        if (checkPlaceholder()){
            setText("");
            if(showPassword==false) setEchoChar(Values.PASSWORD_ECHO_CHAR);
        }
    }
    @Override
    public void focusGained(FocusEvent e) {
        border = Colors.ACCENT;
        background = new Color(32, 30, 31);
        repaint();
    }

    @Override
    public void focusLost(FocusEvent e) {
        border = Colors.TEXT_FIELD_BORDER;
        background = Colors.TEXT_FIELD_BACKGROUND;
        if(isEmpty()) setPlaceholder();
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        EventQueue.invokeLater(new Runnable() {

            @Override
              public void run() {
                  grabFocus();
                  requestFocus();//or inWindow
              }
         });
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(isFocusOwner()) return;
        background = new Color(57, 48, 50);
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(isFocusOwner()) return;
        background = Colors.TEXT_FIELD_BACKGROUND;
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        cleanField();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE)
        {
            cleanField();
            if (isEmpty())
                setText(" ");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}