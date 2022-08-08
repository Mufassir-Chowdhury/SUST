package Components;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import Constants.Fonts;
import Constants.Margins;
import Constants.Padding;
import Constants.Sizes;

import java.awt.RenderingHints;
import java.awt.AlphaComposite ;


import java.awt.geom.RoundRectangle2D ;



import java.awt.Dimension;

public class Tools{

    public static ImageIcon imageScaleB(String source, Dimension dimension) {
        ImageIcon bgIcon = new ImageIcon(ClassLoader.getSystemResource(source));
        Image bgImage = bgIcon.getImage().getScaledInstance(dimension.width, dimension.height, Image.SCALE_SMOOTH);
        return new ImageIcon(bgImage);
    }
    
    public static Image imageScale(ImageIcon img, Dimension dimension){
	    Image bgImage = img.getImage().getScaledInstance(dimension.width, dimension.height, Image.SCALE_SMOOTH);
        return bgImage;
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

    public static BufferedImage makeRoundedCorner(BufferedImage image, int cornerRadius) {
        int w = image.getWidth();
        int h = image.getHeight();
        BufferedImage roundImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
    
        Graphics2D g = roundImage.createGraphics();
        
        g.setComposite(AlphaComposite.Src);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(Color.WHITE);
        g.fill(new RoundRectangle2D.Float(0, 0, w, h, cornerRadius, cornerRadius));

        g.setComposite(AlphaComposite.SrcAtop);
        g.drawImage(image, 0, 0, null);
        
        g.dispose();
        return roundImage;
    }

    public static BufferedImage bufferImage(String source, Dimension dimension)
    {
        BufferedImage bImage = null;
        try {
            bImage = ImageIO.read(ClassLoader.getSystemResource(source));
            Image image = bImage.getScaledInstance(dimension.width, dimension.height, java.awt.Image.SCALE_SMOOTH);
            bImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);

            Graphics2D g = bImage.createGraphics();
            g.drawImage(image, 0, 0, null);
            g.dispose();

            return bImage;
        } catch (IOException e) {
            e.printStackTrace();
            return bImage;
        }
        



    }
    
    public static Dimension locate(Dimension parent, Dimension child)
    {
        int x = (int) (parent.getWidth() - child.getWidth()) / 2;
        int y = (int) (parent.getHeight() - child.getHeight()) / 2;
        return new Dimension(x, y);
    }

    /**
     * extracts width for canvas portion
     * @return
     */
    public static int extractWidth()
    {
        int a = (int) Sizes.USABLE_WINDOW_SIZE.getWidth();
        int b = (int) Sizes.DEFAULT_WINDOW_SIZE.getWidth() / 4;
        int c = Padding.SIDE_NAV_VIEW.getBorderInsets().left + Padding.SIDE_NAV_VIEW.getBorderInsets().right;
        int d = Margins.MAJOR_PANEL.left + Margins.MAJOR_PANEL.right;
        return a - b - c - d + 11;
    }
    
    /**
     * extracts height for canvas portion
     * @return
     */
    public static int extractHeight()
    {
        int a = (int) Sizes.USABLE_WINDOW_SIZE.getHeight();
        int b = Sizes.TITLE_BAR_HEIGHT;
        int c = Padding.MAIN_VIEW_PORT.getBorderInsets().top + Padding.MAIN_VIEW_PORT.getBorderInsets().bottom;
        int d = Padding.SIDE_NAV_VIEW.getBorderInsets().top + Padding.SIDE_NAV_VIEW.getBorderInsets().bottom;
        int e = Fonts.TITLE.getSize();
        int f = Sizes.TITLE_AND_PANEL_GAP;
        return a - b - c - d - e - f;
    }
}