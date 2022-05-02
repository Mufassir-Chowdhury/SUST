package Components;

import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.border.Border;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;

public class Tools{

    public static ImageIcon imageScale(String source, Dimension dimension){
        ImageIcon bgIcon = new ImageIcon(ClassLoader.getSystemResource(source));
	    Image bgImage = bgIcon.getImage().getScaledInstance(dimension.width, dimension.height, Image.SCALE_SMOOTH);
	    return new ImageIcon(bgImage);
    }

    
    
    
}