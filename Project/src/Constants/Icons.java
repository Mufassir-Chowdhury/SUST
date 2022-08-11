package Constants;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import Components.Tools;

/**
 * This class contains all the icons and logos used in the application.
 */
public class Icons {
    /**
     * This is the main logo of the application.
     */
    public static final ImageIcon SUST_LOGO = Tools.imageScale("static/images/logo.png", Sizes.LOGO_SIZE);
    /**
     * This is a multipurpose information icon to show additional information.
     */
    public static final ImageIcon INFO = Tools.imageScale("static/images/info.png", Sizes.ICON_SIZE);
    
    /**
     * This is the profile picture of the logged in profile and also used in the list of students.
     */
    // public static final ImageIcon DP = Tools.imageScale("static/images/2019331073.png", Sizes.DP);
    public static final BufferedImage DP = Tools.bufferImage("static/images/2019331073.png", Sizes.DP);
    // public static final BufferedImage DP = Tools.makeRoundedCorner(DPB,50);

    /**
     * Icons to use in Title bar.
     */
    public static class TitleBar{
        /**
         * Icon to close the window.
         */
        public static final ImageIcon CLOSE = Tools.imageScale("static/images/cancel-white.png", Sizes.ICON_SIZE);
        /**
         * Icon to Extend the window to full screen.
         */
        public static final ImageIcon FULL_SCREEN = Tools.imageScale("static/images/full-screen.png", Sizes.ICON_SIZE);
        /**
         * Icon to minimize the window to tool bar.
         */
        public static final ImageIcon MINIMIZE = Tools.imageScale("static/images/minimize.png", Sizes.ICON_SIZE);
        /**
         * Icon to restore the window to default size.
         */
        public static final ImageIcon RESTORE = Tools.imageScale("static/images/restore-white.png", Sizes.ICON_SIZE);
        /**
         * Icon to go back to the previous page.
         */
        public static final ImageIcon BACK = Tools.imageScale("static/images/back-white.png", Sizes.ICON_SIZE);
        /**
         * Icon to go back to the previous page.
         */
        public static final ImageIcon BACK_COLORED = Tools.imageScale("static/images/back-color.png", Sizes.ICON_SIZE);
    }

    /**
     * Icons to indicate different pages.
     */
    public static class Pages{
        /**
         * Icon for class routine page.
         */
        public static final ImageIcon SCHEDULE = Tools.imageScale("static/pages/routine.png", Sizes.GUI_SMALL_SIZE);
        /**
         * Icon for due assignment page.
         */
        public static final ImageIcon ASSIGNMENT = Tools.imageScale("static/pages/assignment.png", Sizes.GUI_SMALL_SIZE);
        /**
         * Icon for upcoming exam page.
         */
        public static final ImageIcon EXAM = Tools.imageScale("static/pages/exam.png", Sizes.GUI_SMALL_SIZE);
        /**
         * Icon for notice and community posts page.
         */
        public static final ImageIcon NOTICE = Tools.imageScale("static/pages/notice.png", Sizes.GUI_SMALL_SIZE);
        
        /**
         * Icon for result page.
         */
        public static final ImageIcon RESULT = Tools.imageScale("static/pages/result.png", Sizes.GUI_SMALL_SIZE);
        /**
         * Icon for attendance page.
         */
        public static final ImageIcon ATTENDANCE = Tools.imageScale("static/pages/attendance.png", Sizes.GUI_SMALL_SIZE);
        /**
         * Icon for course resources page.
         */
        public static final ImageIcon RESOURCES = Tools.imageScale("static/pages/resource.png", Sizes.GUI_SMALL_SIZE);
    
        /**
         * Icon for payment page.
         */
        public static final ImageIcon PAYMENT = Tools.imageScale("static/pages/payment.png", Sizes.GUI_SMALL_SIZE);
        /**
         * Icon for course registration page.
         */
        public static final ImageIcon COURSE_REGISTRATION = Tools.imageScale("static/pages/registration.png", Sizes.GUI_SMALL_SIZE);
        /**
         * Icon for important links page.
         */
        public static final ImageIcon IMPORTANT_LINKS = Tools.imageScale("static/pages/links.png", Sizes.GUI_SMALL_SIZE);
    
        /**
         * Icon for bus schedule page.
         */
        public static final ImageIcon BUS_SCHEDULE = Tools.imageScale("static/pages/bus.png", Sizes.GUI_SMALL_SIZE);
        /**
         * Icon for student list page.
         */
        public static final ImageIcon STUDENT_INFO = Tools.imageScale("static/pages/students.png", Sizes.GUI_SMALL_SIZE);
        /**
         * Icon for events page.
         */
        public static final ImageIcon EVENTS = Tools.imageScale("static/pages/event.png", Sizes.GUI_SMALL_SIZE);
        /**
         * Icon for map page.
         */
        public static final ImageIcon MAP = Tools.imageScale("static/pages/map.png", Sizes.GUI_SMALL_SIZE);
    
        /**
         * Icon for settings page.
         */
        public static final ImageIcon SETTINGS = Tools.imageScale("static/pages/settings.png", Sizes.GUI_SMALL_SIZE);
    }    

    /**
     * Icons to indicate different roles of the app.
     */
    public static class Role{
        /**
         * Icon for student role.
         */
        public static final ImageIcon STUDENT = Tools.imageScale("static/images/student.png", Sizes.GUI_BIG_SIZE);
        /**
         * Icon for teacher role.
         */
        public static final ImageIcon TEACHER = Tools.imageScale("static/images/teacher.png", Sizes.GUI_BIG_SIZE);
        /**
         * Icon for admin role.
         */
        public static final ImageIcon ADMINISTRATOR = Tools.imageScale("static/images/administrator.png", Sizes.GUI_BIG_SIZE);
    }
    
}
