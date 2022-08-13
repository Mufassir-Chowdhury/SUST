package Constants;
import java.awt.Color;

/**
 * This class contains all the colors used in the application.
 * This file includes variable colors.
 */
public class Colors {
    // Theme colors
    public static class Theme{
        /**
         * Default Accent color to be used throughout the application.
         * This Color can be changed from the settings.
         * TODO : Change this to a variable that can be changed from the settings.
         */
        public static final Color ACCENT = new Color(96,205,255);
        /**
         * Default Accent text to be used throughout the application 
         * to let certain text stand out.
         * This Color will change when the Accent color change.
         */
        public static final Color ACCENT_TEXT = new Color(153,235,255);
        /**
         * Default background color to be used throughout the application.
         * This Color will change when the Accent color change.
         */
        public static final Color ACCENT_FILL = new Color(96,205,255);
        /**
         * Default secondary color to be used throughout the application.
         * This color is used as the second color when two colors are needed.
         * The other one is the Accent color.
         */
        public static final Color SECONDARY = new Color(0,94,183);

        public static class Button{
            /**
             * Default background color for Accent buttons when hovered.
             * This Color will change when the Accent color change.
             * For more information about buttons, see the buttons package.
             */
            public static final Color ACCENT_BUTTON_HOVER = new Color(96,205,255, 230);
            /**
             * Default background color for Accent buttons when pressed.
             * This Color will change when the Accent color change.
             * For more information about buttons, see the buttons package.
             */
            public static final Color ACCENT_BUTTON_PRESSED = new Color(96,205,255, 200);
        }
    }
    
    // Button Colors
    
    public static class Button{
        /**
         * Background color for Hyper Link Buttons when hovered
         * For more information about buttons, see the buttons package.
         */
        public static final Color HYPER_LINK_BUTTON_HOVER = new Color(55, 40, 44);
        /**
         * Background color for Hyper Link Buttons when pressed
         * For more information about buttons, see the buttons package.
         */
        public static final Color HYPER_LINK_BUTTON_PRESSED = new Color(52, 35, 40);
        /**
         * Background color for Close button in the title bar when hovered.
         */
        public static final Color CLOSE_BUTTON_HOVER = new Color(196, 43, 28);
        /**
         * Background color for Close button in the title bar when pressed.
         */
        public static final Color CLOSE_BUTTON_PRESSED = new Color(179, 42, 28);
        /**
         * Background color for buttons in the title bar.
         */
        public static final Color TITLE_BAR_BUTTON_HOVER = new Color(45, 45, 45);
    }
    /**
     * Background color for custom ComboBox component.
     */
    public static final Color COMBO_BOX = new Color(50, 50, 50);
    /**
     * Background color cards.
     */
    public static final Color CARD = new Color(255, 255, 255, 13);
    /**
     * Background color cards when hovered.
     */
    public static final Color CARD_HOVER = new Color(255, 255, 255, 25);
    /**
     * Basic text color.
     */
    public static final Color PLAIN_TEXT = Color.WHITE;
    /**
     * Basic text color to use on top of Accent Color.
     */
    public static final Color PLAIN_TEXT_BLACK = Color.BLACK;

    /**
     * Colors used for text field and password fields.
     */
    public static class TextField{
        /**
         * Border color for Text Fields in rest.
         */
        public static final Color BORDER = new Color(156, 150, 154);
        /**
         * Border color for Text Fields when focused.
         * It is the accent color and changed when accent color is changed.
         */
        public static final Color BORDER_FOCUSED = Theme.ACCENT;
        /**
         * Background color for Text Fields in rest.
         */
        public static final Color BACKGROUND = new Color(255, 255, 255, 15);
        /**
         * Background color for Text Fields when Focused.
         */
        public static final Color BACKGROUND_FOCUSED = new Color(30, 30, 30, 178);
        /**
         * Background color for Text Fields when hovered.
         */
        public static final Color BACKGROUND_HOVER = new Color(255, 255, 255, 21);
        /**
         * Used to indicate valid input in textfield.
         */
        public static final Color VALID = Color.GREEN;
        /**
         * Used to indicate invalid input in textfield.
         */
        public static final Color INVALID = Color.RED;
    }
    /**
     * Colors used for showing grades in result page.
     */
    public static class Grade{
        /**
         * Text color to show Grade more than or equal to A-.
         */
        public static final Color FIRST_CLASS = Color.GREEN;
        /**
         * Text color to show Grade more than or equal to B-.
         */
        public static final Color SECOND_CLASS = new Color(80, 70, 70, 255);
        /**
         * Text color to show Grade more than or equal to D-.
         */
        public static final Color THIRD_CLASS = new Color(67, 53, 25, 255);
        /**
         * Text color to show Grade F.
         */
        public static final Color FOURTH_CLASS = new Color(68, 39, 38, 255);
    }
    
    /**
     * Background for custom List component when hovered.
     */
    public static final Color LIST_ITEM_HOVER = new Color(45, 45, 45);
    public static final Color SCROLLBAR = new Color(0,0,0);

    /**
     * Colors for custom CheckBox component.
     */
    public static class CheckBox{
        /**
         * Background color custom checkbox element when selected.
         */
        public static final Color SELECTED = new Color(0, 191, 255);
        /**
         * Background color custom checkbox element when not selected.
         */
        public static final Color UNSELECTED = new Color(135, 206, 250);
    }

    /**
     * Colors for DashBoard panels.
     */
    public static class DashBoard{
        /**
         * Background color Title shown in dashboard panels.
         */
        public static final Color TITLE_BACKGROUND = new Color(84, 84, 84, 163);
        /**
         * Background color for dashboard panels.
         */
        public static final Color BACKGROUND = new Color(84, 84, 84, 163);
    }
    
    /**
     * The color of notifications to be shown on the dashboard.
     * There are four types of notifications:
     * 1. Success
     * 2. Informational
     * 3. Warning
     * 4. Critical
     */
    public static class Notification{
        /**
         * The color of Informational notifications.
         */
        public static final Color INFORMATIONAL = new Color(80, 70, 70, 255);
        /**
         * The color of Success notifications.
         */
        public static final Color SUCCESS = new Color(57, 61, 27, 255);
        /**
         * The color of Warning notifications.
         */
        public static final Color WARNING = new Color(67, 53, 25, 255);
        /**
         * The color of Critical notifications.
         */
        public static final Color CRITICAL = new Color(68, 39, 38, 255);
    }
}
