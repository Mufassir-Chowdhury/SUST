package login;
import javax.swing.JButton;
import java.awt.Graphics;

class RoundJButton extends JButton {
    private static final long serialVersionUID = 1L;
    private int size;
    public RoundJButton(int size) {
        super();
        this.size = size;
        setOpaque(false); 
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
}