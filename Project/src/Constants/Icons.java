package Constants;

import javax.swing.ImageIcon;
import Components.Tools;

public class Icons {

    public static final ImageIcon CLOSE = Tools.imageScale("static/images/cancel-white.png", 15, 15);
    public static final ImageIcon FULL_SCREEN = Tools.imageScale("static/images/full-screen.png", 15, 15);
    public static final ImageIcon MINIMIZE = Tools.imageScale("static/images/minimize.png", 15, 15);
    public static final ImageIcon RESTORE = Tools.imageScale("static/images/restore-white.png", 15, 15);

    public static final ImageIcon SUST = new ImageIcon(ClassLoader.getSystemResource("static/images/logo.png"));
}
