package Components;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.RenderingHints;

import java.awt.Dimension;

public class Tools{

    public static ImageIcon imageScaleB(String source, Dimension dimension){
        ImageIcon bgIcon = new ImageIcon(ClassLoader.getSystemResource(source));
	    Image bgImage = bgIcon.getImage().getScaledInstance(dimension.width, dimension.height, Image.SCALE_SMOOTH);
	    return new ImageIcon(bgImage);
    }

    public static ImageIcon imageScale(String source, Dimension dimension)
    {
        try{
            BufferedImage original = ImageIO.read(ClassLoader.getSystemResource(source));
            Image newimg = original.getScaledInstance(dimension.width, dimension.height,  java.awt.Image.SCALE_SMOOTH);
            // BufferedImage resizedImg = new BufferedImage(dimension.width, dimension.height, BufferedImage.TYPE_INT_ARGB);
            // Graphics2D g2 = resizedImg.createGraphics();

            // g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            // g2.drawImage(original, 0, 0, dimension.width, dimension.height, null);
            // g2.dispose();
            // BufferedImage resized = new BufferedImage(dimension.width, dimension.height, java.awt.Image.SCALE_SMOOTH);
            // BufferedImage resized = new BufferedImage(dimension.width, dimension.height, original.getType());
            // Graphics2D g = resized.createGraphics();
            // g.drawImage(original, 0, 0, dimension.width, dimension.height, null);
            // g.dispose();
            return new ImageIcon(newimg);
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
            return new ImageIcon(source);
            // have to return something so added this.
        }
        
    }
    
    
}