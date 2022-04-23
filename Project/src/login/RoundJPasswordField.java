package login;
import javax.swing.JPasswordField;

import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

class RoundJPasswordField extends JPasswordField {
    private Shape shape;
    private int size;
    public RoundJPasswordField(int size) {
        super(size);
        this.size = size;
        setOpaque(false); // As suggested by @AVD in comment.
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
    public boolean contains(int x, int y) {
            if (shape == null || !shape.getBounds().equals(getBounds())) {
                shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, size, size);
            }
            return shape.contains(x, y);
    }
}
