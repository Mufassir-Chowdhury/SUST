package Components;

import java.awt.*;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.tools.Tool;

import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Constants.Colors;
import Constants.Fonts;
import Constants.Icons;
import Constants.Sizes;

public class Card extends JPanel {
    Color background = Colors.CARD;
    int curve = 7;
    BufferedImage image = null;
    public Card(String text, Icon icon) {
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setMaximumSize(Sizes.CARD_SIZE);
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        
        JLabel logo = new JLabel(icon);
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(Box.createVerticalGlue());
        add(logo);
        add(Box.createVerticalStrut(5));
        Label label = new Label(text, Fonts.BODY_LARGE, Component.CENTER_ALIGNMENT);
        add(label);
        add(Box.createVerticalGlue());

        addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e) {
                background = new Color(255, 255, 255, 25);
                repaint();
            }

            public void mouseExited(MouseEvent e) {
                background = Colors.CARD;
                repaint();
            }
        });
    }

    public Card(String text, Font font) {
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setMaximumSize(Sizes.CARD_SIZE);
        add(Box.createVerticalGlue());
        add(new Label(text, font, Component.CENTER_ALIGNMENT));
        add(Box.createVerticalGlue());
        addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                background = new Color(255, 255, 255, 25);
                repaint();
            }

            public void mouseExited(MouseEvent e) {
                background = Colors.CARD;
                repaint();
            }
        });
    }
    
    public Card(BufferedImage image, int curve)
    {
        this.curve = curve;
        this.image = Tools.makeRoundedCorner(image, curve);
        setOpaque(false);
        setMaximumSize(Sizes.DP);
        

    }
    
    @Override
    protected void paintComponent(Graphics g) {
        if (image != null)
            g.drawImage(image, 0, 0, this);
        g.setColor(background);
        g.fillRoundRect(0, 0, getWidth(), getHeight(), curve, curve);
        super.paintComponent(g);
        
    }
    
    @Override
    public Dimension getPreferredSize() {
        if(image == null) return new Dimension(0, 0);
        return new Dimension(image.getWidth(), image.getHeight());
    }

}