package Components;

import java.awt.Image;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class BackgroundImage extends JLabel{

    public ImageIcon setBackgroundImage(String source, int width, int height){
        ImageIcon bgIcon = new ImageIcon(ClassLoader.getSystemResource(source));
	    Image bgImage = bgIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
	    return new ImageIcon(bgImage);
    }
}