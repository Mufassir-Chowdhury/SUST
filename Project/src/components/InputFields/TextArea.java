package Components.InputFields;

import java.awt.*;

import javax.swing.JTextArea;
import java.awt.event.*;
import Constants.Colors;
import Constants.Fonts;
import Constants.Padding;
import Constants.Sizes;


import java.awt.Graphics;

public class TextArea extends JTextArea implements MouseListener, FocusListener, KeyListener {

    private Color background = Colors.TextField.BACKGROUND;
    public Color border = Colors.TextField.BORDER;
    private String placeholder;

    public TextArea(String placeholder, Boolean bool)
    {
        super(placeholder);
        this.placeholder = placeholder;
        common();

        // decorate();

        addKeyListener(this);
        addMouseListener(this);
        addFocusListener(this);
        
    }

    public TextArea(String placeholder)
    {
        super(placeholder);
        this.placeholder = placeholder;
        border = background = new Color(0,0,0,0);
        common();
        
        // decorate();
    }

    private void common() {
        setOpaque(false);
        setForeground(Colors.PLAIN_TEXT); 
        setFont(Fonts.PLAIN_TEXT);
        setText(placeholder);
        setBorder(Padding.TEXT_FIELD);
        setLineWrap(true);
        setWrapStyleWord(true);
        setAlignmentX(Component.CENTER_ALIGNMENT);
        setCaretColor(Colors.PLAIN_TEXT);
        setAutoscrolls(true);
    }

    protected void paintComponent(Graphics g) {
        g.setColor(background);
        g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, Sizes.SMALLER_BORDER_RAIDUS, Sizes.SMALLER_BORDER_RAIDUS);
        super.paintComponent(g);
    }
    
    protected void paintBorder(Graphics g) {
        g.setColor(border);
        g.drawRoundRect(0, getHeight() - 1, getWidth() - 2, 1, Sizes.SMALLER_BORDER_RAIDUS,
                Sizes.SMALLER_BORDER_RAIDUS);
    }

    public boolean checkPlaceholder(){
        return getText().equals(placeholder);
    }
    
    public boolean isEmpty() {
        return getText().length() == 0;
    }
    
    public void setPlaceholder(){
        setText(placeholder);
    }

    public void cleanField(){
        if (checkPlaceholder()){
            setText("");
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        border = Colors.TextField.BORDER_FOCUSED;
        background = Colors.TextField.BACKGROUND_FOCUSED;
        repaint();
    }

    @Override
    public void focusLost(FocusEvent e) {
        border = Colors.TextField.BORDER;
        background = Colors.TextField.BACKGROUND;
        if (isEmpty())
            setPlaceholder();
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
        background = Colors.TextField.BACKGROUND_HOVER;
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(isFocusOwner()) return;
        background = Colors.TextField.BACKGROUND;
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_ENTER) {
            e.consume();
        }
        else cleanField();
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
