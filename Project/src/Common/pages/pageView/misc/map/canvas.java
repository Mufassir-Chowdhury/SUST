package Common.pages.pageView.misc.map;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;

import Components.Tools;


public class canvas extends Canvas {

    int width, height;

    public canvas()
    {
        setBackground(new Color(0, 0, 0, 0));
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(Tools.extractWidth(), Tools.extractHeight());
    }

    @Override
    public void paint(Graphics g)
    {
        this.width = getWidth();
        this.height = getHeight();
        g.setColor(Color.red);
        g.fillOval(0, 0, 50, 50);
        g.fillOval(width-50, 0, 50, 50);
        g.fillOval(0, height-50, 50, 50);
        g.fillOval(width - 50, height-50, 50, 50);
    }
}
