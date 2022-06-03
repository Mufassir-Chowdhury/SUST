package Constants;

import java.awt.Font;

/**
 * This class contains all the text styles used in the application.
 * The only font use here is 'Segoe UI' and it's variants.
 */
public class Fonts {
    /**
     * This text style is used to show extra and less important information.
     */
    public static final Font CAPTION = new Font("Segoe UI", Font.PLAIN, 12);
    /**
     * This text style is used to show normal text.
     */
    public static final Font PLAIN_TEXT = new Font("Segoe UI", Font.PLAIN, 14);
    /**
     * The default text style used in the application. This is semibold version of normal text.
     */
    public static final Font BODY = new Font("Segoe UI Semibold", Font.PLAIN, 14);
    /**
     * This text style is used to emphasize certain information.
     */
    public static final Font BODY_LARGE = new Font("Segoe UI", Font.PLAIN, 18);

    /**
     * This text style is used for section titles in different pages.
     */
    public static final Font TITLE = new Font("Segoe UI", Font.PLAIN, 24);
    /**
     * This text style is usually used with huge texts.
     */
    public static final Font SUBTITLE = new Font("Segoe UI Semibold", Font.BOLD, 20);
    /**
     * This text style is used for large Titles such as page name in individual page and app name in landing page.
     */
    public static final Font DISPLAY = new Font("Segoe UI", Font.BOLD, 28);
    /**
     * This text style is used for the time display in the application.
     */
    public static final Font SECOND_DISPLAY = new Font("Segoe UI", Font.BOLD, 40);
    /**
     * This text style is used for the showing summaries.
     * This is only used in result page to show grade.
     */
    public static final Font BIG_DISPLAY = new Font("Segoe UI Display", Font.BOLD, 60);
}
