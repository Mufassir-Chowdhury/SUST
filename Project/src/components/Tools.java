package Components;

import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Dimension;

public class Tools{

    public static ImageIcon imageScale(String source, Dimension dimension){
        ImageIcon bgIcon = new ImageIcon(ClassLoader.getSystemResource(source));
	    Image bgImage = bgIcon.getImage().getScaledInstance(dimension.width, dimension.height, Image.SCALE_SMOOTH);
	    return new ImageIcon(bgImage);
    }

}