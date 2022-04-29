package Components;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Tools{

    public static ImageIcon imageScale(String source, int width, int height){
        ImageIcon bgIcon = new ImageIcon(ClassLoader.getSystemResource(source));
	    Image bgImage = bgIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
	    return new ImageIcon(bgImage);
    }

    // public ImageIcon setBackgroundImage(String source, int width, int height){
    //     ImageIcon bgIcon = new ImageIcon(ClassLoader.getSystemResource(source));
	//     Image bgImage = bgIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
	//     return new ImageIcon(bgImage);
    // }

    // public ImageIcon makeLogo(String source, int width, int height){
    //     ImageIcon logoIcon = new ImageIcon(ClassLoader.getSystemResource(source));
    // 	Image sizedLogo = logoIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
    // 	return new ImageIcon(sizedLogo);
    // }

    // both are the same method, so unified them. 
}