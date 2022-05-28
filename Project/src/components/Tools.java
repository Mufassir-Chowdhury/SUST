package Components;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;

import Constants.Colors;
import Constants.Fonts;

import java.awt.Component;
import java.awt.RenderingHints;
import java.awt.AlphaComposite ;


import java.awt.geom.RoundRectangle2D ;



import java.awt.Dimension;

public class Tools{

    public static ImageIcon imageScaleB(String source, Dimension dimension){
        ImageIcon bgIcon = new ImageIcon(ClassLoader.getSystemResource(source));
	    Image bgImage = bgIcon.getImage().getScaledInstance(dimension.width, dimension.height, Image.SCALE_SMOOTH);
	    return new ImageIcon(bgImage);
    }

    public static ImageIcon imageScale(String source, Dimension dimension)
    {
        try {
            BufferedImage original = ImageIO.read(ClassLoader.getSystemResource(source));
            Image newimg = original.getScaledInstance(dimension.width, dimension.height, java.awt.Image.SCALE_SMOOTH);
            // BufferedImage resizedImg = new BufferedImage(dimension.width, dimension.height, BufferedImage.TYPE_INT_ARGB);
            // Graphics2D g2 = resizedImg.createGraphics();

            // g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            // g2.drawImage(original, 0, 0, dimension.width, dimension.height, null);
            // g2.dispose();
            // BufferedImage resized = new BufferedImage(dimension.width, dimension.height, java.awt.Image.SCALE_SMOOTH);
            // BufferedImage resized = new BufferedImage(dimension.width, dimension.height, original.getType());
            // BufferedImage output = new BufferedImage(dimension.width, dimension.height, BufferedImage.TYPE_INT_ARGB);

            // Graphics2D g2 = output.createGraphics();

            // // This is what we want, but it only does hard-clipping, i.e. aliasing
            // // g2.setClip(new RoundRectangle2D ...)

            // // so instead fake soft-clipping by first drawing the desired clip shape
            // // in fully opaque white with antialiasing enabled...
            // g2.setComposite(AlphaComposite.Src);
            // g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            // g2.setColor(Colors.PLAIN_TEXT);
            // g2.fill(new RoundRectangle2D.Float(0, 0, dimension.width, dimension.height, 50, 50));

            // // ... then compositing the image on top,
            // // using the white shape from above as alpha source
            // g2.setComposite(AlphaComposite.SrcAtop);
            // g2.drawImage(resized, 0, 0, null);

            // g2.dispose();
            return new ImageIcon(newimg);
        } catch (IOException ex) {
            ex.printStackTrace();
            return new ImageIcon(source);
            // have to return something so added this.
        }

    }
    
    public static Box createBox(String title)
    {
        Box box = Box.createHorizontalBox();
        box.setAlignmentX(Component.LEFT_ALIGNMENT);
        box.add(new Label(title, Fonts.DISPLAY, Colors.ACCENT_BUTTON_HOVER));
        return box;
    }
    
    public static Dimension locate(Dimension parent, Dimension child)
    {
        int x = (int) (parent.getWidth() - child.getWidth()) / 2;
        int y = (int) (parent.getHeight() - child.getHeight()) / 2;
        return new Dimension(x, y);
    }
}