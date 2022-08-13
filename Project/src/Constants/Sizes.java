package Constants;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;


public class Sizes {
    public static final int TITLE_BAR_HEIGHT = 35;
    public static final int BORDER_RADIUS = 8;
    public static final int SMALLER_BORDER_RAIDUS = 4;
    public static final int LIST_ITEM_WIDTH = 300;
    public static final int TITLE_AND_PANEL_GAP = 20;

    public static final Dimension DP = new Dimension(50, 50);

    public static final Dimension BUTTON_SIZE = new Dimension(120, 32);
    public static final Dimension DEFAULT_WINDOW_SIZE = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getSize();
    public static final Dimension NORMAL_WINDOW_SIZE = new Dimension(1000, 600);
    public static       Dimension USABLE_WINDOW_SIZE = Sizes.DEFAULT_WINDOW_SIZE;
    public static final Dimension TEXT_FIELD_SIZE = new Dimension(350, 32);

    public static class DIALOG{
        public static final Dimension ASSIGNMENT = new Dimension((int)(Sizes.DEFAULT_WINDOW_SIZE.getWidth()/1.7), (int)(Sizes.DEFAULT_WINDOW_SIZE.getHeight()/1.4));
        public static final Dimension CLASS = new Dimension((int) (Sizes.DEFAULT_WINDOW_SIZE.getWidth() / 1.2), (int) (Sizes.DEFAULT_WINDOW_SIZE.getHeight() / 1.15));
        public static final Dimension EVENT = new Dimension((int)(Sizes.DEFAULT_WINDOW_SIZE.getWidth()/1.4), (int)(Sizes.DEFAULT_WINDOW_SIZE.getHeight()/1.2));
        public static final Dimension EXAM = new Dimension((int)(Sizes.DEFAULT_WINDOW_SIZE.getWidth()/1.7), (int)(Sizes.DEFAULT_WINDOW_SIZE.getHeight()/1.4));
        public static final Dimension LINK = new Dimension((int)(Sizes.DEFAULT_WINDOW_SIZE.getWidth()/1.7), (int)(Sizes.DEFAULT_WINDOW_SIZE.getHeight()/2.2));
        public static final Dimension PAYMENT_HISTORY = new Dimension((int)(Sizes.DEFAULT_WINDOW_SIZE.getWidth()/1.4), (int)(Sizes.DEFAULT_WINDOW_SIZE.getHeight()/1.2));
        public static final Dimension RESOURCES = new Dimension((int)(Sizes.DEFAULT_WINDOW_SIZE.getWidth()/1.7), (int)(Sizes.DEFAULT_WINDOW_SIZE.getHeight()/2.2));
        public static final Dimension REGISTER_PROFILE = new Dimension((int) (Sizes.DEFAULT_WINDOW_SIZE.getWidth() / 1.2), (int) (Sizes.DEFAULT_WINDOW_SIZE.getHeight() / 1.15));
        public static final Dimension REGISTER_PROFILE_CHOOSE = new Dimension((int) (Sizes.DEFAULT_WINDOW_SIZE.getWidth() / 2.5), (int) (Sizes.DEFAULT_WINDOW_SIZE.getHeight() / 2.5));
    }

    public static final Dimension ICON_SIZE = new Dimension(15, 15);
    public static final Dimension GUI_BIG_SIZE = new Dimension(35, 35);
    public static final Dimension GUI_SMALL_SIZE = new Dimension(25, 25);

    public static final Dimension LOGO_SIZE = new Dimension(156, 173);

    public static final Dimension CHECKBOX_SIZE = new Dimension(110, 23);
    
    public static final Dimension CARD_SIZE = new Dimension(190, 115);
    public static final Dimension CARD_SIZE_2 = new Dimension(350, 200);

    public static final Dimension LIST_ITEM = new Dimension(1000, 70);
    public static final Dimension OPTIONS = new Dimension(1000, 40);
    public static final Dimension COLUMN = new Dimension(1000, 200);
    public static final Dimension NOTIFICATION_SIZE = new Dimension(1000, 40);
    public static final Dimension SEARCH_FIELD = new Dimension(288, 32);
}
